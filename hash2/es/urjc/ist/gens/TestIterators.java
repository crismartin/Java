package es.urjc.ist.gens;

import java.util.Iterator;

import org.junit.Test;



public class TestIterators {

	@Test
	public void test() {
		
		int tamanio = 10;
		String elemento;
		Array<String> array_n = new Array<String>(tamanio);
		
		// Insertar 
		for(int i = 0; i<tamanio-5; i++){
			elemento = "elemento: " + String.valueOf(i);
			array_n.insert(elemento);
		}
		
		System.out.println(array_n);
		
		// probando iterador
		Iterator<String> iterador = array_n.getIterator();
		
		while(iterador.hasNext()){
			String extraido = iterador.next();
			System.out.println("extraido: '" + extraido + "'");
		}
		

		Lista<String> lista = new Lista<String>();
		
		for(int i = 0; i<tamanio-5; i++){
			elemento = "elemento: " + String.valueOf(i);
			lista.insert(elemento);
		}
		
		System.out.println("\n" + lista);
		System.out.println("probando Iterador Lista..");
		Iterator<String> iterador_array = lista.getIterator();
		String extraido;
		
		while(iterador_array.hasNext()){
			extraido = iterador_array.next();
			System.out.println("extraido: '" + extraido + "'");			
		}
		
	}
}
