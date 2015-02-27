package es.urjc.ist.gens;

public interface SecuenciaAleatoria<E> extends Secuencia<E> {
	public boolean insert(int index, E elemento);
}
