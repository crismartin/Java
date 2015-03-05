package es.urjc.ist.gens;

import java.util.Iterator;

/**
 * <H3> Secuencia.java </H3>
* Interfaz de una Secuencia.<br>
* Inserta y busca elementos de la secuencia<br> 
* @author Cristian Martínez Rosero.
* @author Ingeniería de Sistemas Telemáticos (IST).
* @author 3ro - Tecnologías de la Telecomunicación.
* 
*  
* @version <b>v2.0</b>
 */
public interface Secuencia<E> {
	/**
	 * Inserta un elemento en la secuencia
	 * @param elemento  elemento a guardar en la secuencia.
	 * @return 'true' si el elemento ha sido guardado en la secuencia, 'false' si
	 * no se ha guardado. 
	 */
	public boolean insert(E elemento);
	
	/**
	 * Devuelve el elemento guardado en la posicion 'index' de la secuencia
	 * @param index posicion del elemento a obtener
	 * @return true: si el elemento está guardado en el conjunto.
	 */
	public E get(int index);
	
	/**
	 * Iterador de la secuencia
	 * @return devuelve un iterador para recorrer la secuencia
	 */
	public Iterator<E> getIterator();	
}
