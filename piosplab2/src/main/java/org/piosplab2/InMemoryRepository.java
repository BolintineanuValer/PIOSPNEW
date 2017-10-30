package org.piosplab2;

public interface InMemoryRepository<T> {
	boolean add(T e);

	boolean contains(T e);

	boolean remove(T e);
	
	void clear();

}
