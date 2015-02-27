package es.urjc.ist.hash;

import java.util.Iterator;

import org.junit.Test;


public class TestHashIterator {

	@Test	
	public void test(){
		//fail("Not yet implemented");

		Hash<Integer,Integer> tabla = new Hash<Integer,Integer>();
		
		
		for(int i = 0; i < 3; i++){
			tabla.insert(i,i);			
		}		
		
		System.out.println(tabla);
		
		// Probando el iterador de la primera de las posiciones de la tabla
		Iterator<Integer> iterador_hash = tabla.getIterator();
		int clave;
		int i = 0;
		System.out.println("Probando tabla hash...");
		while(iterador_hash.hasNext()){			
			System.out.println("****************************************");
			System.out.println("entro por i = " + i);
			clave = iterador_hash.next();
			i ++;
			System.out.println("clave extraida: " + clave + "\n");
		}
		System.out.println("he salido");
	}
}
