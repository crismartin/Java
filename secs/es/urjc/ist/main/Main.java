package es.urjc.ist.main;

import es.urjc.ist.secs.*;

public class Main {

	public static void main(String[] args) {
		
		int num_elements = 10;
		String numero;
		
		SecuenciaAleatoria seq_lista_aleat = new ListaAleatoria();			
		SecuenciaOrdenada seq_lista_ord = new ListaOrdenada();		
		SecuenciaAleatoria seq_array_aleat = new ArrayAleatorio();
		SecuenciaOrdenada seq_array_ord = new ArrayOrdenado();
		
		for (int i = 0; i < num_elements; i++){
			numero = String.valueOf(((int) Math.floor(Math.random()*(num_elements-0+1)+0))); 
			seq_lista_aleat.insert(i, numero);
			seq_lista_ord.insert(numero);
			seq_array_aleat.insert(i, numero);
			seq_array_ord.insert(numero);
		}
		
		System.out.println (seq_lista_aleat.toString());
		System.out.println (seq_lista_ord.toString());
		System.out.println (seq_array_aleat.toString());
		System.out.println (seq_array_ord.toString());
		
	}
}
