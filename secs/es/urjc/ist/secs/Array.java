package es.urjc.ist.secs;

import java.util.Arrays;

public class Array implements Secuencia {
	protected static final int tamanio = 16;
	protected int ocupados = 0;
	private static final String valor_defecto = ""; 
	protected String [] array = new String [tamanio];
	
	
	
	// Constructor
	public Array (){		
		for (int i = 0; i < tamanio; i++){
			array[i] = valor_defecto;
		}		
		Arrays.fill (array, valor_defecto);
	}
	
	// agregar un elemento
	public boolean insert (String elemento){
		try{
			array[ocupados] = elemento; 
			ocupados ++;
			return true;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println (e +": No se puede insertar, se ha llegado al limite del array");
			return false;	
		}
	}
	
	// devuelve un string del array que  
	// este en la posicion "index"
	public String get(int index){
		String result;
		try{
			result = array[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e + ": indice fuera de rango, se devuelve 'null'");
			result = null;
		}
		return result;
	}

	public int buscar(String elemento){
		int result = -1;
		
		for (int i = 0; i < tamanio; i++){
			if (!valor_defecto.equals(array[i]) && elemento.equals(array[i])){
				result = i;
				break;
			}			
		}
		
		return result;
	}
	
	
	// imprimir elementos
	public String toString (){
		String result = "";
		if (ocupados == 0){
			result = "No hay elementos en el array";
		}
		
		for (int i = 0; i<tamanio; i++){
			if(!valor_defecto.equals(array[i])){
				result += "["+array[i]+"] - ["+i+"]\n";
			}
		}
		return result;
	}
}
