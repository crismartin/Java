package es.urjc.ist.gens;

import org.junit.Test;

public class TestArray {

	@Test
	public void test() {
		
		///////
		// Creo un array para probar la clase Array
		int tamanio = 10;
		Secuencia<String> array = new Array<String>(tamanio);
		System.out.println("array: " + array);
		
		// Inserto elementos en el array
		for(int i = 0; i < tamanio; i++){
			array.insert("elemento " + String.valueOf(i));			
		}		
		System.out.println(array);
		
		// Hago un get de un elemento que no existe
		int pos = 10;
		String elemento = array.get(pos);
		System.out.println("En la posicion '" + pos +"' hay '" + elemento + "'");
		
		// Hago un get de un elemento que existe
		pos = 3;
		elemento = array.get(pos);
		System.out.println("En la posicion '" + pos +"' hay '" + elemento + "'");
		
		
		////////
		// Creo un array para probar la clase ArrayOrdenado		
		SecuenciaOrdenada<String> array_o = new ArrayOrdenado<String>(tamanio);
		System.out.println(array_o);
		
		// Inserto elementos en el array (de 0 a 4)
		for(int i = 0; i < tamanio-5; i++){
			array_o.insert("elemento " + String.valueOf(i));			
		}		
		System.out.println(array_o);
		
		// pruebo la busqueda binaria
		// busqueda de un elemento que no esta en el array
		elemento = "elemento 10";
		int index = array_o.search(elemento);
		
		if(index < 0){
			System.out.println("'" + elemento + "' no existe");
		}else{
			System.out.println("'" + elemento + "' esta en la posicion " + index);
		}
		
		// busqueda de un elemento que si esta en el array
		elemento = "elemento 1";
		index = array_o.search(elemento);
		
		if(index < 0){
			System.out.println("'" + elemento + "' no existe");
		}else{
			System.out.println("'" + elemento + "' esta en la posicion '" + index + "'");
		}


		/////////////
		// Creo un array para probar la clase ArrayAleatorio		
		SecuenciaAleatoria<String> array_a = new ArrayAleatorio<String>(tamanio);		
			
		// Inserto elementos en el array (de 0 a 4) en posiciones pares
		for(int i = 0; i < tamanio-5; i++){
			array_a.insert(i*2, "elemento " + String.valueOf(i));			
		}		
		System.out.println(array_a);
		
	}
}
