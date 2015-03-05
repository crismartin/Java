package es.urjc.ist.gens;

import java.util.Collections;
import java.util.Comparator;

/**
* <H3> ArrayOrdenado.java </H3>
* Clase que implementa de la Interfaz <b> SecuenciaOrdenada.java </b> y 
* hereda de la clase <b>Array.java</b><br>
* Inserta, devuelve, busca elementos en un array de clase ArrayList.<br>
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
public class ArrayOrdenado<E extends Comparable<E>> extends Array<E> implements SecuenciaOrdenada<E> {
	
	/**
	 * Crea un array heredando el constructor de la clase <b>Array.java</b>
	 * @param tamanio Longitud del array 
	 */
	public ArrayOrdenado (int tamanio){
		super(tamanio);
	}
	
	public boolean esPar(int num){
		if ((num % 2) == 0){
			return true;
		}
		return false;
	}
		
	// buscar un elemento	
	/**
	 * Busca el elemento pasado como parámetro empleando una busqueda binaria
	 * 
	 * @return devuelve la posicion donde esta guardado el elemento, si no existe
	 * el elemento, devuelve un valor negativo
	 */
	public int search(E elemento) {//arreglo seria de estring y el dato string 
		return Collections.binarySearch(array, elemento);		
	}
	
	// agregar un elemento
	/**
	 * Inserta un elemento en el array
	 * @return 'true' si el elemento se ha guardado en el array, 'false' si no se ha guardado
	 */
	public boolean insert(E elemento){
		int encontrado = -1;				
		encontrado = search (elemento);
				
		if(encontrado > -1){
			System.out.println("No se ha agregado el elemento '"+ elemento+"'. Ya existe");
			return false;
		}
		
		try{			
			if(array.size()==tamanio){
				throw new IndexOutOfBoundsException();
			}
			
			array.add(elemento); 
			ocupados ++;
			
			Collections.sort(array, new Comparator <E>() {		        
				@Override
		        public int compare(E elemento1, E elemento2)
		        {
		            return  ((Comparable<E>) elemento1).compareTo(elemento2);
		        }});
		       	
			return true;
			
		}catch (IndexOutOfBoundsException e){
			System.out.println (e +": No se puede insertar, se ha llegado al limite del array");
			return false;	
		}
	}
	
	/** 
	 * Devuelve los elementos del array en un solo string
	 * @return devuelve los elementos del array en un string
	 */	 
	public String toString(){
		if(ocupados == 0){
			return "No hay elementos en el array";
		}
		return "** Array Ordenado **\n" + super.toString();
	}
}
