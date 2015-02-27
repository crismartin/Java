package es.urjc.ist.hash;


import java.util.Iterator;

import es.urjc.ist.gens.*;


public class Hash<K,V> {
	public static final int tamanio_hash = 3;
	protected K key;
	protected V value;
	private Secuencia<Lista <Tupla<K,V>>> tabla_hash = new Array<Lista<Tupla<K,V>>>(tamanio_hash);
	
	public Hash(){
		for (int i = 0; i < tamanio_hash; i++){
			tabla_hash.insert(new Lista<Tupla<K,V>>());
		}		
	}
	
	public int funcionResumen(K key){
		int key_aux = key.hashCode();
		int posicion = (key_aux % tamanio_hash);
		posicion = Math.abs(posicion);
		return posicion;
	}
	
	
	
	// insertar un elemento en la tabla hash
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
			encontrado = ptr_aux.search(elemento);
			
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
	
	
	// devuelve el valor asociado a esa clave
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
			posicion = ptr_aux.search(elemento_aux);
			elemento_aux = ptr_aux.get(posicion);		
			value =  elemento_aux.value;
		}catch (java.lang.NullPointerException e){
			System.out.println(e + ": No se ha encontrado valor asociado a la clave '" + key +"'");
			value = null;
		}
				
		return value;
	}
	
	
	public String toString(){		
		String result = "";		
		for(int i = 0; i < tamanio_hash; i++){
			result += "Lista [" + i + "]: " + tabla_hash.get(i).toString();
		}		
		return result;
	}
	
	public Iterator<K> getIterator(){
		
		return new HashIterator();
	}
	
	protected class HashIterator implements Iterator<K> {
		protected Iterator <Lista<Tupla<K,V>>> iterador_array;
		protected Lista<Tupla<K,V>> lista;
		Iterator<Tupla<K, V>> iterador_lista;
		K elemento;
		
		protected HashIterator(){
			iterador_array = tabla_hash.getIterator();
			lista = iterador_array.next();
			System.out.println("lista inicio" + lista);
			iterador_lista = lista.getIterator();
			
			if(lista.length() != 0){
				elemento = iterador_lista.next().key;				
			}	
		}
		
		public boolean hasNext() {		
				
			if(iterador_array.hasNext() && lista.length() != 0 && elemento != null){
				
				return true;
			}else{
				return false;
			}			
		}

		public K next() {					
			K elemento_aux;
			System.out.println("iterador_array: " + iterador_array.hasNext());
			System.out.println("iterador_lista: " + iterador_lista.hasNext());
			
			if((iterador_lista.hasNext() && iterador_array.hasNext())){		
				System.out.println("aqui");
				elemento_aux = elemento;
				elemento = iterador_lista.next().key;
				
				return elemento_aux;
						
			}else{
				System.out.println("entro aqui");
				elemento_aux = elemento;

				while(iterador_array.hasNext()){
					lista = iterador_array.next();
					if(lista.length() != 0){
						break;
					}					
				}
				System.out.println("sd:" + lista);
				if(lista.length() != 0){
					iterador_lista = lista.getIterator();
					elemento = iterador_lista.next().key;
					System.out.println("elemento es " + elemento);
				}	

				return elemento_aux;
			}
		}
		
		public void remove() {			
		} 
	 }
}

