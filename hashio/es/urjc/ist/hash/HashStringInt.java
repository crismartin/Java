package es.urjc.ist.hash;
import java.io.*;
import java.util.Iterator;

/**
* <H3> HashStringInt.java </H3>
* Clase que implementa una Tabla Hash con listas de desbordamiento. Hereda de Hash.java<br>
* Consta de un array de la clase ArrayList, donde cada posición se guarda una lista de desbordamiento. <br>
* Clave es un String y el Valor es un Integer. <br>
* 
* 
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación
* 
*  
* @version <b>v2.0</b>
 */
public class HashStringInt extends Hash<String, Integer> {
	
	/**
	 * Hereda de la clase Hash.java, inicializa una tabla hash de 11 posiciones 
	 */
	public HashStringInt(){
		super();
	}
	
	
	private static int leerInt(DataInputStream datain) {		
		int numero = 0;
		
		try{
			numero = datain.readInt();			
		}catch (IOException e){
			System.err.println(e + ": error al leer valor entero");
		}		
		return numero;
	}
	
	
	private static byte[] leerValor(DataInputStream datain){	
		int n = leerInt(datain);
		
		if(n > 8*1024*1024){
			throw new RuntimeException("readbytes: msg is > 8M");
		}
		
		byte[] bytes = new byte[n];
			
		if(n > 0){			
			try {
				datain.readFully(bytes);
			} catch (IOException e) {
				System.out.println(e + ": Error al leer la clave");
			}
		}
		
		return bytes;
	}
	
	
	private static String leerClave(DataInputStream datain) {				
		byte[] bytes;
		String clave;
		
		try {
			bytes = leerValor(datain);
			clave = new String(bytes, "UTF-8");			

			return clave;			
		} catch (IOException e) {
			 System.out.println(e + ": Error al leerDatos");		
			 return null;
		}
	}
	
	
		
	/**
	 * Lee tuplas de un fichero para crear una Tabla Hash
	 * @param fichero Fichero del cual extraigo los datos para crear la tabla
	 * @return tabla Hash con los datos extraidos del fichero
	 */
	public static HashStringInt readFrom(String fichero) {					
		// leer los datos del fichero
		try{
			HashStringInt tabla_hash = new HashStringInt();
			// abro el fichero en modo lectura (FileInputStream)
			FileInputStream fdin = new FileInputStream(fichero);
			BufferedInputStream input = new BufferedInputStream(fdin);
			DataInputStream datain = new DataInputStream(input);
						
			// leer el fichero
			// 1ro. Leo la cabecera del fichero, para saber cuantas tuplas tengo en el fichero
			int num_cabecera = leerInt(datain);
			
			for(int i = 0; i < num_cabecera; i++){
				String clave = leerClave(datain);
				int valor = leerInt(datain);				
				tabla_hash.insert(clave, valor);
			}
			datain.close();
			return tabla_hash;
			
		}catch (FileNotFoundException e){
			System.err.println(e + ": fichero no encontrado");			
			return null;
		}catch (IOException e){
			System.err.println(e + ": no se ha podido leer bytes correctamente");
			return null;
		}
	}
	
	private int numElementsHash(){
		int num_elementos = 0;
		Iterator<String> iterador = getIterator();
		
		while(iterador.hasNext()){
			iterador.next();
			num_elementos++;
		}
				
		return num_elementos;
	}
	
	private static void escribirInt(DataOutputStream dataout, int numero){
		try {
			dataout.writeInt(numero);
		} catch (IOException e) {
			System.out.println(e + ": Error al escribir el entero en el fichero");
		}
	}
	

	private static void escribirBytes(DataOutputStream dataout, byte[] bytes){
		int num = bytes.length;
		try {
			// escribo la longitud del array de bytes
			dataout.writeInt(num);
			if(num > 0){			
				// escribo los bytes
				dataout.write(bytes);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	protected void escribirClave(DataOutputStream dataout, String clave){
		try {
			byte[] bytes = clave.getBytes("UTF-8");			
			escribirBytes(dataout, bytes);
		}catch(Exception e){
			throw new RuntimeException(e + ": Error al escribir clave en UTF-8");
		}
	}
	
	/**
	 * Escribe el contenido de la tabla hash en un fichero
	 * @param fichero  direccion del fichero a donde van a guardarse los datos de la hash
	 */
	public void writeTo(String fichero) {
		try{
			// abro el fichero en modo escritura (FileOutputStream)
			FileOutputStream fdout = new FileOutputStream(fichero);
			BufferedOutputStream output = new BufferedOutputStream(fdout);
			DataOutputStream dataout = new DataOutputStream(output);
			String clave;
			int valor;
			
			// escribir en el fichero
			// 1ro. escribo el numero de elementos que tengo en la hash
			int num_elementos = numElementsHash(); 
			escribirInt(dataout, num_elementos);
						
			// extraigo las claves de la hash, iterando la tabla			
			Iterator<String> iterador = getIterator();			
			while(iterador.hasNext()){
				clave = iterador.next();
				valor = get(clave);
				// escribo la clave y el valor
				escribirClave(dataout, clave);
				escribirInt(dataout, valor);
			}
			
			dataout.close();
		}catch (FileNotFoundException e){
			System.err.println(e + ": Fichero no encontrado");
		}catch (IOException e){
			System.err.println(e + ": Error de escritura en fichero");			
		}
	}
}
