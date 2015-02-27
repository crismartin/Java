package es.urjc.ist.listas;

public class List {
	private Nodo ptr_inicio;
	private int tamanio;
		
	
	// clase interna
	private static class Nodo {		
		Coor coordenada;
		Nodo siguiente;
				
		public Nodo (Coor coordenada){
			this.coordenada = coordenada;
			siguiente = null;		
		}
		
		public String toString (){				
			return coordenada.toString();
		}		
	}
	
	
	// Constructor de la clase List 
	public List(){
		this.ptr_inicio = null;
		this.tamanio = 0;
	}
	
	// Devuelve el numero de elementos que tiene la lista
	public int length (){		
		return this.tamanio;
	}
		
	// Agregar un elemento al final de la lista
	public void put (Coor c){		
		put(c, tamanio);
	}
	
	
	public boolean put (Coor c, int index){
		
		Nodo ptr_aux1;
		Nodo ptr_aux2;		
		boolean resultado;
		int i;
				
		Nodo elemento = new Nodo (c);		
		ptr_aux1 = ptr_inicio;
		ptr_aux2 = ptr_inicio;
		resultado = false;
		i = tamanio-index;
		
		if ((index >= 0)&&(index <= tamanio)){			
			if (index == tamanio){
				elemento.siguiente = ptr_inicio;
				ptr_inicio = elemento;				
			}else{												
				while (i != 0){					
					ptr_aux2 = ptr_aux1;
					ptr_aux1 = ptr_aux1.siguiente;					
					i--;
				}
				elemento.siguiente = ptr_aux1;
				ptr_aux2.siguiente = elemento;				
			}
			
			tamanio++;			
			resultado = true;
		}
		
		return resultado;
	}
	
	
	// devolver un elemento de la lista (sin borrar)
	public Coor get (int index){
		
		Nodo ptr_aux;
		ptr_aux = ptr_inicio;
		int i;
		
		i = tamanio-1;
		if(tamanio == 0){
			return null;
		}
		
		if ( (ptr_inicio == null) || ((index < 0)&&(index > tamanio-1)) ){			
			return null;
			
		}else{						
			while (i != index){
				ptr_aux = ptr_aux.siguiente;
				i--;
			}			
			return ptr_aux.coordenada;
		}		
	}
	
	// borrar un elemento de la lista
	public Coor delete (int index){
		
		Nodo ptr_aux;
		Nodo ptr_aux2;
		int i;
				
		ptr_aux = ptr_inicio;
		ptr_aux2 = ptr_inicio;
		i = tamanio-1;
				
		if ( (ptr_inicio == null) || ((index < 0)&&(index > tamanio-1))){			
			return null;
			
		}else if (index == i){			
			ptr_inicio = ptr_aux.siguiente;
			ptr_aux.siguiente = null;
			
		}else{				
			while (i != index){
				ptr_aux2 = ptr_aux;
				ptr_aux = ptr_aux.siguiente;
				i--;
			}
			ptr_aux2.siguiente = ptr_aux.siguiente;
			ptr_aux.siguiente = null;
		}
		
		tamanio--;
		ptr_aux2 = null;
									
		return ptr_aux.coordenada;
	}
	
	
	public String toString (){
		Nodo ptr_aux;
		String result;
		
		ptr_aux = ptr_inicio;		
		result = "";
		
		if (tamanio == 0){
			result = "lista vacía";
		}else{
			while (ptr_aux != null){
				
				if (ptr_aux == ptr_inicio){
					result += ptr_aux.toString();
				}else{
					result = ptr_aux.toString() + "," + result;
				}
					ptr_aux = ptr_aux.siguiente;				
			}			
		}		
		
		result = "["+ result + "]\n";
		
		return result;
	}
}