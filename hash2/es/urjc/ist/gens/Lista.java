package es.urjc.ist.gens;

import java.util.Iterator;


public class Lista<E> implements Secuencia<E> {
	protected Nodo<E> ptr_inicio;
	private int tamanio;
		
	
	// clase interna
	protected static class Nodo<E> {		
		E elemento;
		Nodo<E> siguiente;
				
		public Nodo (E elemento){
			this.elemento = elemento;
			siguiente = null;		
		}
		
		public String toString (){				
			return elemento.toString();
		}		
	}
	
	
	// Constructor de la clase List 
	public Lista(){
		this.ptr_inicio = null;
		this.tamanio = 0;
	}
	
	// Devuelve el numero de elementos que tiene la lista
	public int length (){		
		return this.tamanio;
	}
		
	// Agregar un elemento al final de la lista
	public void put (E elemento){		
		put(elemento, tamanio);
	}
	
	
	public boolean put (E elemento, int index){
		
		Nodo<E> ptr_aux1;
		Nodo<E> ptr_aux2;		
		boolean resultado;
		int i;
				
		Nodo<E> ptr_element = new Nodo<E> (elemento);		
		ptr_aux1 = ptr_inicio;
		ptr_aux2 = ptr_inicio;
		resultado = false;
		i = tamanio-index;
		
		if ((index >= 0)&&(index <= tamanio)){			
			if (index == tamanio){
				ptr_element.siguiente = ptr_inicio;
				ptr_inicio = ptr_element;				
			}else{												
				while (i != 0){					
					ptr_aux2 = ptr_aux1;
					ptr_aux1 = ptr_aux1.siguiente;					
					i--;
				}
				ptr_element.siguiente = ptr_aux1;
				ptr_aux2.siguiente = ptr_element;				
			}
			
			tamanio++;			
			resultado = true;
		}
		
		return resultado;
	}
	
	
	// devolver un elemento de la lista (sin borrar)
	public E get (int index){
		
		Nodo<E> ptr_aux;
		ptr_aux = ptr_inicio;
		int i;
		
		i = tamanio-1;
		
		if ( (ptr_inicio == null) || ((index < 0)&&(index > tamanio-1)) ){			
			return null;
			
		}else{						
			while (i != index){
				ptr_aux = ptr_aux.siguiente;
				i--;
			}			
			return ptr_aux.elemento;
		}		
	}
	
	// borrar un elemento de la lista
	public E delete (int index){
		
		Nodo<E> ptr_aux;
		Nodo<E> ptr_aux2;
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
									
		return ptr_aux.elemento;
	}
	
	// busca si esta el elemento en la lista
			// devuelve -1 si el elemento no esta en la lista
	public int search(E elemento) {
		Nodo<E> ptr_aux = ptr_inicio;
		int contador = length()-1;
						
		while(ptr_aux != null){
			if(elemento.equals(ptr_aux.elemento)){
				break;
			}else{
				ptr_aux = ptr_aux.siguiente;
				contador--;
			}				
		}			
		return contador;			
	}
	
	public String toString (){
		Nodo<E> ptr_aux;
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
					result = ptr_aux.toString() + ", " + result;
				}
				ptr_aux = ptr_aux.siguiente;				
			}			
		}		
		
		result = "["+ result + "]\n";
		
		return result;
	}

	
	//////////////////////////
	// Metodos de la secuencia //
	//////////////////////////
	
	public boolean insert(E elemento) {	
		put (elemento);
		return true;		
	}
	
	public Iterator<E> getIterator(){
		return new ListaIterator();
	}
	
	protected class ListaIterator implements Iterator<E> {
		protected Nodo<E> puntero;
		
		protected ListaIterator(){			
			puntero = ptr_inicio;
		}
		
		public boolean hasNext() {
			if(puntero == null){
				return false;
			}else{
				return true;
			}		
		}
		
		public E next() {
			E elemento = puntero.elemento;
			puntero = puntero.siguiente;
			return elemento;
		}

		public void remove() {
		
		}		
	}	
}
	