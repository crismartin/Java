package es.urjc.ist.secs;

public class ArrayAleatorio extends Array implements SecuenciaAleatoria {
	
	public ArrayAleatorio(){
		super();
	}
	
	
	public boolean insert(int posicion, String elemento){
	
		if (posicion < tamanio){			
			array[posicion] = elemento;
			ocupados++;
			return true;
		}
	
		return false;
	}

	public String toString(){
		return "** Array Aleatorio **\n" + super.toString();
	}
}
