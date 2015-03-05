
package es.urjc.ist.hash;
import java.util.Iterator;

import es.urjc.ist.gens.*;

/**
* <H3> TablaHash.java </H3>
* Clase que implementa una Tabla Hash con listas de desbordamiento.<br>
* Consta de un array de la clase ArrayList, donde cada posición se guarda una lista de desbordamiento. <br>
* Tambien tiene la clase interna Iterador, para poder iterar la tabla desde fuera. <br>
* 
* 
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación
* 
*  
* @version <b>v2.0</b>
 */
public class Hash<K,V> {
	/**
	 * Tamaño de la tabla hash (11).
	 */
	public static final int tamanio_hash = 11; //se podría poner un valor mas alto
											   //pero para realizar las pruebas éste esta bien
	protected K key;
	protected V value;
	private Secuencia<Lista <Tupla<K,V>>> tabla_hash = new Array<Lista<Tupla<K,V>>>(tamanio_hash);
	
	
	/**
	 * Construye una tabla de tamanio 11 vacía con listas de desbordamiento
	 */
	public Hash(){
		for (int i = 0; i < tamanio_hash; i++){
			tabla_hash.insert(new Lista<Tupla<K,V>>());
		}		
	}
	
	private int funcionResumen(K key){
		int key_aux = key.hashCode();
		int posicion = (key_aux % tamanio_hash);
		posicion = Math.abs(posicion);
		return posicion;
	}
	


	/**
	 * Inserta una tupla [clave: valor] 
	 * @param key clave del elemento a guardarse en la tabla.
	 * @param value  valor asociado a la clave a guardarse en la tabla hash.
	 * @return devuelve true si el elemento se ha guardado, false si no se ha guardado
	 */
	public boolean insert(K key, V value){
		boolean insertado = false;
		int encontrado = -2;		
		int slot;
		Lista<Tupla<K,V>> ptr_aux;
		Tupla<K,V> elemento = new Tupla<K,V>(key, value);
		
		try{
			//buscamos la posicion donde deberia ir el elemento
			slot = funcionResumen(key);
			// extraemos la lista de ese slot
			ptr_aux = tabla_hash.get(slot);
			// buscamos si el elemento esta en esa lista
			encontrado = ptr_aux.buscar(elemento);
			
			if(encontrado == -1){
				// si no lo ha encontrado, guardo
				ptr_aux.insert(elemento);
				insertado = true;
			}
			
		}catch (java.lang.NullPointerException e){
			System.out.println(e + ": clave '" + key + "' invalida. Imposible guardar en tabla");			
		}
		
		return insertado;
	}
	
	
	/**
	 * Devuelve el valor asociado a esa clave
	 * @param key clave de la tupla y/o del valor a obtener
	 * @return devuelve el 'value' (valor) asociado a la clave del parámetro 'key', null si la clave
	 * no existe en la tabla.
	 */
	public V get(K key){
		int slot;
		int posicion;
		V value;
		Lista<Tupla<K,V>> ptr_aux;
		Tupla<K,V> elemento_aux = new Tupla<K,V>(key, null);
		
		try{
			slot = funcionResumen(key);
			// busco el valor de la clave pasada:
			// extraigo la lista de ese slot
			ptr_aux = tabla_hash.get(slot);
			// busco el elemento mediante un auxiliar con la misma clave
			posicion = ptr_aux.buscar(elemento_aux);
			elemento_aux = ptr_aux.get(posicion);		
			value =  elemento_aux.value;
		}catch (java.lang.NullPointerException e){
			System.out.println(e + ": No se ha encontrado valor asociado a la clave '" + key +"'");
			value = null;
		}
				
		return value;
	}
	
	/**
	 * Devuelve la tabla hash en string
	 * @return string con todos los elementos de la tabla hash.
	 */
	public String toString(){		
		String result = "";		
		for(int i = 0; i < tamanio_hash; i++){
			result += "Lista [" + i + "]: " + tabla_hash.get(i).toString();
		}		
		return result;
	}
	
	/**
	 * Iterador de la Tabla Hash
	 * @return objeto iterador para poder extraer (recorrer, iterar) los elementos de la lista
	 */
	public Iterator<K> getIterator(){
		
		return new HashIterator();
	}
	
	protected class HashIterator implements Iterator<K> {
		protected Iterator <Lista<Tupla<K,V>>> iterador_array;
		protected Lista<Tupla<K,V>> lista = null;
		Iterator<Tupla<K, V>> iterador_lista;
		K elemento = null;
		boolean iterar = true;
		
		protected HashIterator(){
			iterador_array = tabla_hash.getIterator();
			comprobarListaNextNull();
		}
		
		/**
		 * Retorna true si hay mas elementos en la tabla hash.
		 * @return devuelve 'true' si hay elementos en la tabla por iterar, 'false' si ya no hay
		 * mas elementos por devolver.
		 */
		public boolean hasNext() {						
			if(iterar){
				//System.out.println("itero");
				return true;
				
			}else{
				//System.out.println("no itero");
				return false;
			}			
		}

 
		// compruebo Si hay una siguiente lista que no sea nula
		private void comprobarListaNextNull() {
			// itero en busca de una lista que no sea nula
			while(iterador_array.hasNext()){
				lista = iterador_array.next();
				// si la lista no es vacia, creo su iterador y salgo del bucle
				if(lista.length() != 0){
					// creo el iteador de la lista para poder recorrerla
					iterador_lista = lista.getIterator();
					break;
				}
			}
			// si he llegado al final de la tabla, y tengo una lista vacia, dejo de iterar
			if(lista.length() == 0 && !iterador_array.hasNext()){
				iterar = false;
			}			
		}
		
		// busco la siguiente lista
		private void siguienteLista() {			

			if(iterador_array.hasNext()){
				//compruebo si la siguiente lista es nula o no
				comprobarListaNextNull();
			}else{
				// si se ha llegado al final, devuelvo false				
				iterar = false;
			}
		}
		
		
		/**
		 * Retorna el siguiente elemento de la tabla hash.
		 * @return devuelve la 'key' a la cual está apuntando el iterador en ese momento. 
		 */
		public K next() {					
			K elemento_aux = elemento;
			
			if (iterador_lista.hasNext()){	
				// como la lista no es nula, y aun faltan elementos por recorrer
				// extraigo el elemento siguiente de la lista
				elemento_aux = iterador_lista.next().key;
				
				// compruebo si el iterador no devuelve mas elementos
				if(!iterador_lista.hasNext()){			
					// busco la siguiente lista de la tabla
					siguienteLista();
				}				
			}			
			
			return elemento_aux;		
		}
		
		// remover elemento
		public void remove() {			
		} 
	 }
}
