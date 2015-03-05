package es.urjc.ist.gens;

import java.util.Iterator;

/**
 *<H3> Lista.java </H3>
* Clase que implementa de la interfaz <b>Secuencia.java</b><br>
* Inserta, devuelve, busca elementos en una <b>lista enlazada</b><br>
* Consta de un Nodo, el cual apuntará al último elemento de la lista en ser guardado. <br>
* 
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación
* 
*  
* @version <b>v2.0</b>
* @param <E> Tipo Generico. Tipo de los elementos que se guardarán en la lista enlazada
 */
public class Lista<E> implements Secuencia<E> {
		
	protected Nodo<E> ptr_inicio;
	private int tamanio;
		
	
	// clase interna
	/**
	 * Nodos de la lista enlazada
	 * 
	 *
	 * @param <E> Tipo del elemento el cual se va a asociar el nodo para ser manipulado en 
	 * la lista enlazada.
	 */
	protected static class Nodo<E> {		
		E elemento;
		Nodo<E> siguiente;
		
		/**
		 * Construye un Nodo guardando en el un elemento de tipo E y un Nodo el cual
		 * apunta a null 
		 * @param elemento Elemento el cual se va a guardar en el nodo
		 */
		public Nodo (E elemento){
			this.elemento = elemento;
			siguiente = null;		
		}
		
		/**
		 * Devuelve un string con el elemento del Nodo
		 * @return string con el elemento del Nodo
		 */
		public String toString (){				
			return elemento.toString();
		}		
	}
	
	
	// Constructor de la clase List 
	/**
	 * Construye una lista enlazada apuntando a null y tamaño 0
	 */
	public Lista(){
		this.ptr_inicio = null;
		this.tamanio = 0;
	}
	
	// Devuelve el numero de elementos que tiene la lista
	/** 
	 * Devuelve el numero de elementos que hay guardados en la lista
	 * @return numero de elementos que hay en la lista
	 */
	public int length (){		
		return this.tamanio;
	}
		
	// Agregar un elemento al final de la lista
	/**
	 * Guarda un elemento en la ultima posicion de la lista enlazada
	 * @param elemento parametro el cual se guarda en la lista enlazada
	 */
	public void put (E elemento){		
		put(elemento, tamanio);
	}
	
	/**
	 * Guarda un elemento en una posicion de la lista enlazada
	 * @param elemento parametro el cual se guarda en la lista enlazada
	 * @param index posicion donde se quiere guardar el elemento en la lista enlazada
	 * @return 'true'si el elemento se ha podido guardar en esa posicion, 'false' si 
	 * el elemento no se ha guardado en esa posicion
	 */
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
	
	
	/**
	 * Devuelve el elemento que está en la posicion index de la lista
	 * @return devuelve el elemento de la posicion 'index' si existe esa posicion,
	 * si no existe la posicion, devuelve 'null' 
	 */
	public E get (int index){
		
		Nodo<E> ptr_aux;
		ptr_aux = ptr_inicio;
		int i;
		
		i = tamanio-1;		
		if(index >= tamanio){					
			return null;
		}
		
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
	/**
	 * Borra el elemento correspondiente al parametro 'index' de la lista enlazada 
	 * @param index posicion del elemento el cual se quiere borrar
	 * @return elemento el cual se ha borrado de la lista enlazada, si no existe 
	 * la posicion 'index' se devuelve 'null'
	 */
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
	/**
	 * Busca si el elemento esta en la lista enlazada
	 * @param elemento parametro el cual se quiere buscar
	 * @return posicion donde esta el elemento, -1 si no se encuentra el elemento
	 */
	public int buscar(E elemento) {
		
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
	
	/**
	 * Devuelve un string con los elementos de la lista enlazada
	 * @return elementos de la lista enlazada en un solo string
	 */
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
	
	/**
	 * Inserta un elemento en la secuencia
	 * @return 'true' al insertar el elemento en la secuencia
	 */
	public boolean insert(E elemento) {	
		put (elemento);
		return true;		
	}
	
	/**
	 * Iterador de la Lista enlazada
	 * @return objeto iterador para poder extraer (recorrer, iterar) los elementos de la lista
	 */
	public Iterator<E> getIterator(){
		return new ListaIterator();
	}
	
	protected class ListaIterator implements Iterator<E> {
		protected Nodo<E> puntero;
		
		protected ListaIterator(){			
			puntero = ptr_inicio;
		}
		
		/**
		 * Retorna true si hay mas elementos en la lista
		 * @return devuelve 'true' si hay elementos en la lista por iterar, 'false' si ya no hay
		 * mas elementos por devolver.
		 */
		public boolean hasNext() {
			if(puntero == null){
				return false;
			}else{
				return true;
			}		
		}
		
		/**
		 * Retorna el siguiente elemento de la lista apuntado por el iterador. 
		 * @return devuelve el elemento al cual está apuntando el iterador en ese momento.
		 */
		public E next() {
			E elemento = puntero.elemento;
			puntero = puntero.siguiente;
			return elemento;
		}

		public void remove() {
		
		}		
	}	
}
	