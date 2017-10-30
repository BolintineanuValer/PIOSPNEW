package org.piosplab2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ArrayListRepository<T> implements InMemoryRepository<T> {
	private List<T> arraylist = new ArrayList<T>();

	public ArrayListRepository(Supplier<? extends ArrayList<T>> supplier) {
		this.arraylist = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return arraylist.add(e);
	}

	@Override
	public boolean contains(T e) {
		return arraylist.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return arraylist.remove(e);
	}

	@Override
	public void clear() {
		arraylist.clear();
		
	}

}
