package es.urjc.ist.gens;

import java.util.Iterator;


public interface Secuencia<E> {
	public boolean insert(E elemento);
	public E get(int index);
	public Iterator<E> getIterator();	
}
