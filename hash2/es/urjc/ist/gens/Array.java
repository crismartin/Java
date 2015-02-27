 package es.urjc.ist.gens;
import java.util.ArrayList;
import java.util.Iterator;


public class Array<E> implements Secuencia<E> {
	protected int tamanio;
	protected int ocupados = 0;
	protected ArrayList<E> array;
	
	
	// Constructor
	public Array (int tamanio){
		this.tamanio = tamanio;
		array = new ArrayList<E>(tamanio);	
		
	}
	
	// agregar un elemento
	public boolean insert (E elemento){
		try{
			array.add(elemento); 
			ocupados ++;
			return true;
		}catch (IndexOutOfBoundsException e){
			System.out.println (e +": No se puede insertar, se ha llegado al limite del array");
			return false;	
		}
	}
	
	// devuelve un string del array que  
	// este en la posicion "index"
	public E get(int index){
		E result;
		try{
			result = array.get(index);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e + ": indice fuera de rango, se devuelve 'null'");
			result = null;
		}
		return result;
	}

	public int buscar(E elemento){
		
		int result = -1;
		E elemento_aux;
			
		for (int i = 0; i < array.size(); i++){
			elemento_aux = array.get(i);
		
			if (elemento.equals(elemento_aux)){
				result = i;
				break;
			}				
		}
	
		return result;
	}
	
	
	// imprimir elementos
	public String toString (){
		String result = "";
		E elemento; 
		if (ocupados == 0){
			result = "No hay elementos en el array";
		}

		for (int i = 0; i < array.size(); i++){
			elemento = array.get(i);

			if((elemento != null)){
				result += "[" + elemento.toString() + "] - ["+i+"]\n";
			}
		}
		result += "size: " + array.size() + "\n";
		result += "tamanio: " + tamanio + "\n";
		result += "ocupados: " + ocupados + "\n";
		return result;
	}
	
	public Iterator<E> getIterator(){
		return new ArrayIterator() ;		
	}
		
	protected class ArrayIterator implements Iterator<E> {
		protected int posicion;

		
		protected ArrayIterator(){
			posicion = 0;
		}
		
		public boolean hasNext() {
			boolean existe = false;
			
			if(posicion < tamanio){
				existe = true;
			}else{
				existe = false;
			}
			
			return existe;
		}

		
		public E next() {
			int pos_aux;
			pos_aux = posicion;
			posicion++;
			return get(pos_aux);
		}


		public void remove() {		
		}		
	}
}
