package es.urjc.ist.hash;
import es.urjc.ist.gens.*;


public class Hash<K,V>{
	public static final int tamanio_hash = 11;
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
			posicion = ptr_aux.buscar(elemento_aux);
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
}
