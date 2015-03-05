package es.urjc.ist.gens;

/**
 * <H3> ListaOrdenada.java </H3>
* Clase que implementa de la interfaz <b>SecuenciaOrdenada.java</b> y hereda
* de la clase <b>Lista.java</b><br>
* Inserta elementos de manera ordenada en una <b>lista enlazada</b><br>
* Busca elementos en la lista realizando una busqueda binaria <br>
*
* 
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación
* 
*  
* @version <b>v2.0</b>
* @param <E> Tipo Generico. Tipo de los elementos que se guardarán en la lista ordenada 
 */
public class ListaOrdenada<E> extends Lista<E> implements SecuenciaOrdenada<E> {

		/**
		 * Crea una lista enlazada apuntando a 'null' y tamaño 0
		 */
		public ListaOrdenada(){			
			super();
		}
		

		/**
		 * Inserta un elemento en la posicion 'index' de la lista enlazada siempre que no
		 * este ya guardado en la lista
		 * @return 'true' si se ha podido agregar el elemento en esa posicion, 'false' si
		 * el elemento no se ha podido guardar en la lista
		 */
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
		/**
		 * Busca si esta el elemento en la lista ordenada.
		 * @return devuelve la posicion donde esta guardado el elemento en la lista, -1 
		 * si el elemento no esta guardado en la lista
		 */
		public int search(E elemento) {
			return buscar(elemento);		
		}
				
		
		/**
		 * Devuelve un String con los elementos de la lista ordenada
		 * @return devuelve los elementos de la lista en un String
		 */
		public String toString(){
			return "** Lista Ordenada **\n"+ super.toString();
		}
}
