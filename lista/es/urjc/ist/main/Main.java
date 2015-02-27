package es.urjc.ist.main;

import es.urjc.ist.listas.Coor;
import es.urjc.ist.listas.List;

public class Main {

	public static void main (String[] args){
		final int max_coors = 15;
		Coor coordenada;
		// creamos una lista
		List lista = new List ();
		
		// imprimimos para ver que tiene la lista
		//System.out.println (lista.toString()+"\n");
		
		// insertamos las coordenadas 
		for (int i = 0; i<= max_coors; i++){
			coordenada = new Coor (i,i);
			lista.put(coordenada);
		}
		
		//imprimimos para ver que tiene la lista
		//System.out.println (lista.toString()+"\n");
		
		//borramos las coordenadas con componentes pares
		for (int i = 0; i*2 <= max_coors; i++){				
			lista.delete(i);			
		}
		
		//imprimimos para ver que tiene la lista
		//System.out.println (lista.toString()+"\n");
		
		// Insertamos en la posicion 2 la coordenada (-11, -11)
		coordenada = new Coor (-11,-11);
		lista.put(coordenada, 2);
		System.out.println (lista.toString()+"\n");
	}	
}
