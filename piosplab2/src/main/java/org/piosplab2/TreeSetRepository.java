package org.piosplab2;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class TreeSetRepository<T> implements InMemoryRepository<T> {
	private Set<T> treeset = new TreeSet<T>();

	public TreeSetRepository(Supplier<? extends TreeSet<T>> supplier) {
		this.treeset = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return treeset.add(e);
	}

	@Override
	public boolean contains(T e) {
		return treeset.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return treeset.remove(e);
	}

	@Override
	public void clear() {
		treeset.clear();
		
	}

}
