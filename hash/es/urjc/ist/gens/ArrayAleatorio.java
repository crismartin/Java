package es.urjc.ist.gens;



public class ArrayAleatorio<E> extends Array<E> implements SecuenciaAleatoria<E> {
	
	public ArrayAleatorio(int tamanio){
		super(tamanio);
		System.out.println("tamanioConstructor:" + array.size());
		for(int i=0; i<tamanio; i++){
			array.add(null);
			ocupados++;
		}
	}
	
	
	public boolean insert(int posicion, E elemento){	
		boolean insertado = false;		
		
		if(array.size() == 0){
			array.add(elemento);
			ocupados++;
			return true;
		}
		
		if(posicion < tamanio){
			System.out.println("el geteado: " + array.get(posicion));
			System.out.println("posicion: " + posicion);
			
			if(null == array.get(posicion)){			
				array.set(posicion, elemento);
			}else{
				array.add(posicion, elemento);
				ocupados++;			
			}
								
			insertado = true;			
		}
		
		return insertado;
	}

	public String toString(){
		return "** Array Aleatorio **\n" + super.toString();
	}
}
