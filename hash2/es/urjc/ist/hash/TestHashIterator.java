package es.urjc.ist.hash;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


public class TestHashIterator {

	@Test(timeout = 2000)	
	public void test(){
		
		int num_min = 1;
		int numero_elementos = 21;
		String clave;
		int valor;
		
		Hash<String,Integer> tabla = new Hash<String,Integer>();
		
		
		// inserto 20 elementos en la tabla
		for (int i = 1; i <= numero_elementos; i++){
			clave = String.valueOf(i);
			tabla.insert(clave,i);	
		}
		
		System.out.println("imprimiendo tabla hash..");
		System.out.println(tabla);

		// Compruebo si un elemento con clave guardada en la tabla se guarda o no (no deberia guardarse)
		System.out.println("Probando 'insert' con clave repetida de la clase 'Hash'");		
		boolean insertado = tabla.insert("1", 99999);
		
		if(insertado == false){
			System.out.println("El elemento no se ha insertado. Clave ya existente\n");	
		}else{
			fail("Error en el metodo 'insert' de la clase 'Hash'");	
		}
		
		// probando el metodo 'get'
		System.out.println("Probando metodo 'get' de la clase 'Hash'");
		// 'get' de clave existente
		clave = "10";
		valor = tabla.get("10");		
		System.out.println("valor: " + valor);
		
		// 'get' de una clave inexistente
		clave = "100000";		
		try{
			valor = tabla.get(clave);
			System.out.println("valor: " + valor);
		}catch (Exception e){
			System.out.println("Se ha devuelto un valor 'null'");
		}
		
		// Probando el iterador de la primera de las posiciones de la tabla
		Iterator<String> iterador_hash = tabla.getIterator();

		try{
			System.out.println("Probando iterador tabla hash...");
			while(iterador_hash.hasNext()){			
				clave = iterador_hash.next();
				System.out.println("clave extraida: " + clave);
			}
		}catch(Exception e){
			fail("Error en el iterador de la clase 'Hash'");
		}
		
		
		// Probamos con una tabla hash donde no este totalmente ocupada
		System.out.println("\nProbando tabla hash parcialmente llena");
		
		Hash<String,Integer> tabla_2 = new Hash<String,Integer>();

		//inserto elementos de forma aleatoria
		for(int i = 1; i*3<= numero_elementos; i++){
			valor = (int) (Math.floor(Math.random()*(numero_elementos-num_min+1)+num_min));
			clave = String.valueOf(valor);
			tabla_2.insert(clave, valor);
		}
		//Imprimo la tabla
		System.out.println("imprimiendo tabla hash..");
		System.out.println(tabla_2);
		
		// Probando el iterador de la primera de las posiciones de la tabla
		iterador_hash = tabla_2.getIterator();

		try{
			System.out.println("Probando iterador tabla hash...");
			while(iterador_hash.hasNext()){			
				clave = iterador_hash.next();
				System.out.println("clave extraida: " + clave);
			}
		}catch(Exception e){
			fail("Error en el iterador de la clase 'Hash'");
		}		
	}
}
