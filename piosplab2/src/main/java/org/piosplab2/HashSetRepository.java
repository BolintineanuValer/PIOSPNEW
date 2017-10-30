package org.piosplab2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class HashSetRepository<T> implements InMemoryRepository<T> {
	private Set<T> hashset = new HashSet<T>();

	public HashSetRepository(Supplier<? extends HashSet<T>> supplier) {
		this.hashset = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return hashset.add(e);
	}

	@Override
	public boolean contains(T e) {
		return hashset.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return hashset.remove(e);
	}

	@Override
	public void clear() {
		hashset.clear();
		
	}

}
