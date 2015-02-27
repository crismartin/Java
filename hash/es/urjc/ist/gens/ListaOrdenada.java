package es.urjc.ist.gens;

public class ListaOrdenada<E> extends Lista<E> implements SecuenciaOrdenada<E> {

		public ListaOrdenada(){			
			super();
		}
		
		// inserta un elemento en la lista
		// siempre que el elemento no este en ella
		public boolean insert(E elemento){		
			boolean result;
			int encontrado;
			result = false;
			encontrado = search(elemento);
			
			if (encontrado == -1){
				result = put(elemento, length());
			}				
			return result;
		}
				
		// busca si esta el elemento en la lista
		// devuelve -1 si el elemento no esta en la lista
		public int search(E elemento) {
			return buscar(elemento);		
		}		
		
		public String toString(){
			return "** Lista Ordenada **\n"+ super.toString();
		}
}
