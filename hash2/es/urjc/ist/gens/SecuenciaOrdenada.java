package es.urjc.ist.gens;

/**
 * <H3> SecuenciaOrdenada.java </H3>
* Interfaz de una Secuencia Ordenada.<br>
* Inserta elementos de manera ordenada en una secuencia.<br>
* Busca un elemento realizando una busqueda binaria.<br>
* Hereda se la Clase <b>Secuencia</b><br> 
* @author Cristian Martínez Rosero.
* @author Ingeniería de Sistemas Telemáticos (IST).
* @author 3ro - Tecnologías de la Telecomunicación.
*  
* @version <b>v2.0</b>
 */
public interface SecuenciaOrdenada<E> extends Secuencia<E> {
	/**
	 * Busca el 'elemento' y devuelve la posicion donde está alojado en la secuencia ordenada
	 * @param elemento parámetro a buscar en la secuencia ordenada
	 * @return devuelve la posición donde está guardado el elemento o '-1' si el 
	 * elemento no existe en la secuencia.
	 */
	public int search(E elemento);
}
