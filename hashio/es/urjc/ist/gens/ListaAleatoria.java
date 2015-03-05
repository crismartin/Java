package es.urjc.ist.gens;

/**
 * <H3> ListaAleatoria.java </H3>
* Clase que implementa de la interfaz <b>SecuenciaAleatoria.java</b> y hereda
* de la clase <b>Lista.java</b><br>
* Inserta elementos de manera aleatoria en una <b>lista enlazada</b><br>
*
* 
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación
* 
*  
* @version <b>v2.0</b>
* @param <E> Tipo Generico. Tipo de los elementos que se guardarán en la lista aleatoria
 */
public class ListaAleatoria<E> extends Lista<E> implements SecuenciaAleatoria<E> {
	
	/**
	 * Constructor heredado de la clase <b>Lista.java</b>
	 */
	public ListaAleatoria(){
		super();
	}
	
	/**
	 * Inserta un elemento en la posicion 'index' de la lista enlazada
	 * siempre que no sea mayor al tamaño de la lista
	 * @return 'true' si se ha podido agregar el elemento en esa posicion, 'false' si
	 * el elemento no se ha podido guardar en la lista
	 */
	public boolean insert(int index, E elemento){
		boolean result;		
		if(index == length()){
			result = put(elemento, index);	
		}else if(index < length()){
			delete(index);
			result = put(elemento, index);
		}else{
			 result = false;
		}
			
		return result;
	}
	
	/** 
	 * Metodo heredado de la clase <b>Lista.java</b>
	 * Retorna un string con los elementos de la lista aleatoria.
	 * @return string con los elementos de la lista aleatoria.
	 */
	public String toString(){
		return "** Lista Aleatoria **\n"+ super.toString();
	}
}
