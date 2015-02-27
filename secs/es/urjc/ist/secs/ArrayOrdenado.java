package es.urjc.ist.secs;

import java.util.Arrays;


public class ArrayOrdenado extends Array implements SecuenciaOrdenada{
	
	public ArrayOrdenado (){
		super();
	}
	
	public boolean esPar(int num){
		if ((num % 2) == 0){
			return true;
		}
		return false;
	}
		
	// buscar un elemento	
	public int search(String elemento) {//arreglo seria de estring y el dato string 

		int inicio = 0; 
		int fin = ocupados-1; 
		int posicion; 

			
		while (inicio <= fin) { 			
			posicion = (inicio + fin)/2; 

			if ( array[posicion].compareTo(elemento) == 0 ){
				return posicion;
				
			} else if ( array[posicion].compareTo(elemento) < 0 ) {		
				//System.out.println("entro al menor");
				inicio = posicion+1; 
				
			} else {
				//System.out.println("entro al mayor");
				fin = posicion-1; 
			} 
		}

		return -1; 
	}
	
	// agregar un elemento
	public boolean insert(String elemento){
		int encontrado = -1;				
		encontrado = search (elemento);		
				
		if (encontrado > -1){
			System.out.println("No se ha agregado el elemento '"+ elemento+"'. Ya existe");
			return false;
		}
		
		try{			
			array[ocupados] = elemento; 
			ocupados ++;
			Arrays.sort(array, 0, ocupados);
		
			return true;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println (e +": No se puede insertar, se ha llegado al limite del array");
			return false;	
		}
	}
	

	
	public String toString(){		
		return "** Array Ordenado **\n" + super.toString();
	}
}
