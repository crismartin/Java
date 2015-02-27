package es.urjc.ist.gens;

import java.util.Collections;
import java.util.Comparator;


public class ArrayOrdenado<E extends Comparable<E>> extends Array<E> implements SecuenciaOrdenada<E> {
	
	public ArrayOrdenado (int tamanio){
		super(tamanio);
	}
	
	public boolean esPar(int num){
		if ((num % 2) == 0){
			return true;
		}
		return false;
	}
		
	// buscar un elemento	
	public int search(E elemento) {//arreglo seria de estring y el dato string 
		return Collections.binarySearch(array, elemento);		
	}
	
	// agregar un elemento
	public boolean insert(E elemento){
		int encontrado = -1;				
		encontrado = search (elemento);
				
		if(encontrado > -1){
			System.out.println("No se ha agregado el elemento '"+ elemento+"'. Ya existe");
			return false;
		}
		
		try{			
			if(array.size()==tamanio){
				throw new IndexOutOfBoundsException();
			}
			
			array.add(elemento); 
			ocupados ++;
			
			Collections.sort(array, new Comparator <E>() {		        
				@Override
		        public int compare(E elemento1, E elemento2)
		        {
		            return  ((Comparable<E>) elemento1).compareTo(elemento2);
		        }});
		       	
			return true;
			
		}catch (IndexOutOfBoundsException e){
			System.out.println (e +": No se puede insertar, se ha llegado al limite del array");
			return false;	
		}
	}
	
	public String toString(){
		if(ocupados == 0){
			return "No hay elementos en el array";
		}
		return "** Array Ordenado **\n" + super.toString();
	}
}
