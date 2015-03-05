package es.urjc.ist.gens;


/**
* <H3> ArrayAleatorio.java </H3>
* Clase que implementa de la Interfaz <b> SecuenciaAleatoria.java </b> y 
* hereda de la clase <b>Array</b><br>
* Inserta, devuelve, busca elementos en un array de clase ArrayList.<br>
* 
*  
* @author Cristian Martínez Rosero
* @author Ingeniería de Sistemas Telemáticos (IST)
* @author 3ro - Tecnologías de la Telecomunicación.
 *
 * @param <E> Tipo Generico. Tipo de los elementos que se guardarán en el array
 */
public class ArrayAleatorio<E> extends Array<E> implements SecuenciaAleatoria<E> {
	
	/**
	 * Crea un array incializado en todas sus posiciones a 'null'
	 * @param tamanio Longitud del array
	 */
	public ArrayAleatorio(int tamanio){
		super(tamanio);
		System.out.println("tamanioConstructor:" + array.size());
		for(int i=0; i<tamanio; i++){
			array.add(null);
			ocupados++;
		}
	}
	
	/**
	 * Inserta un elemento en el array
	 * @return 'true' si el elemento se ha guardado en el array, 'false' si no se ha guardado
	 */
	public boolean insert(int posicion, E elemento){	
		boolean insertado = false;		
		
		if(array.size() == 0){
			array.add(elemento);
			ocupados++;
			return true;
		}
		
		if(posicion < tamanio){
			try{
				array.get(posicion);				
				array.set(posicion, elemento);
			}catch(Exception e){				
				array.add(posicion, elemento);
				ocupados++;			
			}
								
			insertado = true;			
		}
	
		return insertado;
	}
	
	/**
	 * Devuelve los elementos del array en un solo string
	 * @return devuelve los elementos del array en un string
	 */
	public String toString(){
		return "** Array Aleatorio **\n" + super.toString();
	}
}
