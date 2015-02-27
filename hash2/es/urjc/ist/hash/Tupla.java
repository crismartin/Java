package es.urjc.ist.hash;

public class Tupla<K, V> implements Comparable<K> {
	public K key;
	public V value;
	
	
	public Tupla (K key, V value){
		this.key = key;
		this.value = value;
	}

	public String toString(){
		
		return "{" + key +" = "+ value + "}";
	}	
	
	@Override
	public boolean equals(Object pareja){
		boolean respuesta = false;
		
		@SuppressWarnings("unchecked")
		Tupla<K, V> aux = (Tupla<K, V>)pareja;
		
		if(aux.key.equals(this.key)){
			respuesta = true;
		}
		
		return respuesta;
	
	}
	
	@SuppressWarnings("unchecked")
	public int compareTo(Object elemento) {
		Tupla <K, V> aux = (Tupla<K, V>)elemento;
		return ((Comparable<K>) aux.key).compareTo(this.key);
	}
	
	
}