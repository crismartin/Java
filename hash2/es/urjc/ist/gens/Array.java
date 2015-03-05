 package es.urjc.ist.gens;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <H3> Array.java </H3>
* Clase que implementa de la Interfaz <b>Secuencia.java</b><br>
* Inserta, devuelve, busca elementos en un array de clase ArrayList.<br>
* Tiene la clase interna Iterador, para poder iterar la tabla desde fuera. <br>
* 
* 
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación.
* 
* @version <b>v2.0</b>
 *
 * @param <E> Tipo Generico. Tipo de los elementos que se guardarán en el array
 */
public class Array<E> implements Secuencia<E> {
	protected int tamanio;
	protected int ocupados = 0;
	protected ArrayList<E> array;
	
	
	/**
	 * Constructor de la clase Array. Crea un nuevo ArrayList de tamaño 'tamanio'
	 * @param tamanio  parametro para determinar la longitud del array.
	 */
	public Array (int tamanio){
		this.tamanio = tamanio;
		array = new ArrayList<E>(tamanio);	
		
	}
	
	/**
	 * Guarda 'elemento' en el array.
	 * @return devuelvo 'true' si el elemento se ha podido insertar en el array,
	 * 'false' si no se ha insertado
	 */
	public boolean insert (E elemento){
		try{
			array.add(elemento); 
			ocupados ++;
			return true;
		}catch (IndexOutOfBoundsException e){
			System.out.println (e +": No se puede insertar, se ha llegado al limite del array");
			return false;	
		}
	}
	
	/**
	 * Devuelve el elemento de tipo E que esté en la posición 'index' del array.
	 * @return devuelve el elemento E del array que esté en la posicion "index" si existe,
	 * si no existe devuelve 'null'
	 */
	public E get(int index){
		E result;
		try{
			result = array.get(index);
		}catch(IndexOutOfBoundsException e){
			//System.out.println(e + ": indice fuera de rango, se devuelve 'null'");
			result = null;
		}
		return result;
	}
	
	/**
	 * Busca el 'elemento' pasado como parámetro y devuelve la posicion donde esta alojado
	 * en el array.
	 * @param elemento a buscar.
	 * @return posicion donde esta alojado el elemento en el array.
	 */
	public int buscar(E elemento){
		
		int result = -1;
		E elemento_aux;
			
		for (int i = 0; i < array.size(); i++){
			elemento_aux = array.get(i);
		
			if (elemento.equals(elemento_aux)){
				result = i;
				break;
			}				
		}
	
		return result;
	}
	
	
	/**
	 * Convierte el array en un String
	 * @return devuelve todos los elementos contenidos en el array
	 */
	public String toString (){
		String result = "";
		E elemento; 
		if (ocupados == 0){
			result = "No hay elementos en el array\n";
		}

		for (int i = 0; i < array.size(); i++){
			elemento = array.get(i);

			if((elemento != null)){
				result += "[" + elemento.toString() + "] - ["+i+"]\n";
			}
		}
		result += "size: " + array.size() + "\n";
		result += "tamanio: " + tamanio + "\n";
		result += "ocupados: " + ocupados + "\n";
		return result;
	}
	
	/**
	 * Iterador del Array
	 * @return objeto iterador para poder extraer (recorrer, iterar) los elementos del array
	 */
	public Iterator<E> getIterator(){
		return new ArrayIterator() ;		
	}
		
	protected class ArrayIterator implements Iterator<E> {
		protected int posicion;

		
		protected ArrayIterator(){
			posicion = 0;
		}
		
		/**
		 * Retorna true si hay mas elementos en el array
		 * @return devuelve 'true' si hay elementos en el array por iterar, 'false' si ya no hay
		 * mas elementos por devolver.
		 */
		public boolean hasNext() {
			boolean existe = false;
			
			if(posicion < tamanio){
				existe = true;
			}else{
				existe = false;
			}
			
			return existe;
		}

		/**
		 * Retorna el siguiente elemento del array apuntado por el iterador. 
		 * @return devuelve el elemento al cual está apuntando el iterador en ese momento.
		 */
		public E next() {
			int pos_aux;
			pos_aux = posicion;			
			posicion++;
			return get(pos_aux);
		}


		public void remove() {		
		}		
	}
}
