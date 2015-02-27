package es.urjc.ist.gens;

public class ListaAleatoria<E> extends Lista<E> implements SecuenciaAleatoria<E> {
	
	public ListaAleatoria(){
		super();
	}
	
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
	
	public String toString(){
		return "** Lista Aleatoria **\n"+ super.toString();
	}
}
