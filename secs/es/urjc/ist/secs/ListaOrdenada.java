package es.urjc.ist.secs;

public class ListaOrdenada extends Lista implements SecuenciaOrdenada{

		public ListaOrdenada(){			
			super();
		}
		
		// inserta un elemento en la lista
		// siempre que el elemento no este en ella
		public boolean insert(String elemento){		
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
		public int search(String elemento) {
			Nodo ptr_aux = ptr_inicio;
			int contador = length()-1;
						
			while(ptr_aux != null){
				if(elemento.equals(ptr_aux.str)){
					break;
				}else{
					ptr_aux = ptr_aux.siguiente;
					contador--;
				}				
			}			
			return contador;			
		}		
		
		public String toString(){
			return "** Lista Ordenada **\n"+ super.toString();
		}
}
