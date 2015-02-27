package es.urjc.ist.gens;

public interface Secuencia<E> {
	public boolean insert(E elemento);
	public E get(int index);	
}
