package es.urjc.ist.gens;

/**
 * <H3> Secuencia.java </H3>
* Interfaz de una Secuencia Aleatoria.<br>
* Inserta elementos de manera aleatoria en una secuencia.<br>
* Hereda se la Clase <b>Secuencia</b><br> 
* @author Cristian Martínez Rosero.
* @author Ingeniería de Sistemas Telemáticos (IST).
* @author 3ro - Tecnologías de la Telecomunicación.
*  
* @version <b>v2.0</b>
 */
public interface SecuenciaAleatoria<E> extends Secuencia<E> {
	/**
	 * Inserta el 'elemento' en la posicion 'index' de la secuencia ordenada.
	 * @param index posicion de la secuencia donde se quiere guardar el elemento
	 * @param elemento parámetro que se guardará en la secuencia
	 * @return 'true' si el elemento se ha podido insertar en la secuencia, 'false'
	 * si no se ha insertado.
	 */
	public boolean insert(int index, E elemento);
}
