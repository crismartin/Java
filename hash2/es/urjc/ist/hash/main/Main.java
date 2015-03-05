package es.urjc.ist.hash.main;

import java.util.Iterator;

import es.urjc.ist.hash.Hash;
import es.urjc.ist.hash.Tupla;

public class Main {
	
	public static void imprimir(Hash<String, Integer> tabla, int num_elementos) {
		String clave;
		int valor;
		Tupla<String, Integer> elemento;
		
		System.out.println("\n-> Imprimiendo las tuplas con claves del 1 al 10");
		for(int i = 1; i <= num_elementos; i++){
			clave = String.valueOf(((int) Math.floor(i)));
			try{
				valor = tabla.get(clave);
				elemento = new Tupla<String, Integer>(clave, valor);
				System.out.println(elemento);
			}catch(java.lang.NullPointerException e){	
				continue;
			}
		}
		
	}
		
	public static void agregar(Hash <String, Integer> tabla, int num_elementos, int num_min) {		
		int valor;
		String clave;
		boolean insertado;
				
		System.out.println("-> Agregando tuplas");
		for(int i = 1; i <= num_elementos; i++){
			clave = String.valueOf(((int) Math.floor(Math.random()*(num_elementos-num_min+1)+num_min)));
			valor =((int) Math.floor(Math.random()*(num_elementos-num_min+1)+num_min));
			insertado = tabla.insert(clave, valor);
			
			if(insertado == false){
				System.out.println("no se ha insertado el elemento: {" + clave + " = "+ valor +"}");
			}
		}
		
	}
	
	public static void main(String[] args) {		
		Hash<String,Integer> tabla = new Hash<String,Integer>();
		int num_min = 1;
		int num_elementos = 10;
		
		agregar(tabla, num_elementos, num_min);
		imprimir(tabla, num_elementos);
		
		System.out.println("\n** tabla hash **\n" + tabla);
		
		// iteramos la tabla mediante un objeto iterador
		Iterator<String> iterador = tabla.getIterator();		
		while(iterador.hasNext()){
			System.out.println("clave: " + iterador.next());			
		}		
	}
}
