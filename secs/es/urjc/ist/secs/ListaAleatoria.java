package es.urjc.ist.secs;

public class ListaAleatoria extends Lista implements SecuenciaAleatoria {
	
	public ListaAleatoria(){
		super();
	}
	
	public boolean insert(int index, String elemento){
		boolean result;		
		result = put(elemento, index);
		
		return result;
	}
	
	public String toString(){
		return "** Lista Aleatoria **\n"+ super.toString();
	}
}
