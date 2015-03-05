package es.urjc.ist.gens;

import org.junit.Test;

public class TestLista {

	@Test
	public void test() {
		
		///////
		// Creo un lista para probar la clase Lista
		int tamanio = 10;
		Secuencia<String> lista = new Lista<String>();
		System.out.println(lista);
		
		// Inserto elementos en el lista
		for(int i = 0; i < tamanio; i++){
			lista.insert("elemento " + String.valueOf(i));			
		}		
		System.out.println(lista);
		
		
		// Hago un get de un elemento que no existe
		int pos = 10;
		String elemento = lista.get(pos);
		System.out.println("En la posicion '" + pos +"' hay '" + elemento + "'");
		
		// Hago un get de un elemento que existe
		pos = 3;
		elemento = lista.get(pos);
		System.out.println("En la posicion '" + pos +"' hay '" + elemento + "'\n");
		
		
		////////
		// Creo un lista para probar la clase listaOrdenado		
		SecuenciaOrdenada<String> lista_o = new ListaOrdenada<String>();
		
		
		// Inserto elementos en el lista (de 0 a 4)
		for(int i = 0; i < tamanio-5; i++){
			lista_o.insert("elemento " + String.valueOf(i));			
		}		
		System.out.println(lista_o);
		
		// pruebo la busqueda binaria
		// busqueda de un elemento que no esta en el lista
		elemento = "elemento 10";
		int index = lista_o.search(elemento);
		
		if(index < 0){
			System.out.println("'" + elemento + "' no existe");
		}else{
			System.out.println("'" + elemento + "' esta en la posicion " + index);
		}
		
		// busqueda de un elemento que si esta en el lista
		elemento = "elemento 1";
		index = lista_o.search(elemento);
		
		if(index < 0){
			System.out.println("'" + elemento + "' no existe");
		}else{
			System.out.println("'" + elemento + "' esta en la posicion '" + index + "'");
		}

		 
		/////////////
		// Creo un lista para probar la clase listaAleatorio		
		SecuenciaAleatoria<String> lista_a = new ListaAleatoria<String>();		
			
		// Inserto elementos en el lista (de 0 a 4) en posiciones pares
		for(int i = 0; i < tamanio-5; i++){
			lista_a.insert(i*2, "elemento " + String.valueOf(i));			
		}		
		System.out.println(lista_a);
		
	}

}
