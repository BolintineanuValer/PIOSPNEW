package org.piosplab2;

import java.util.function.Supplier;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

public class ECMutableListRepository<T> implements InMemoryRepository<T> {
	private MutableList<T> mutablelist = Lists.mutable.empty();

	public ECMutableListRepository(Supplier<? extends MutableList<T>> supplier) {
		this.mutablelist = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return mutablelist.add(e);
	}

	@Override
	public boolean contains(T e) {
		return mutablelist.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return mutablelist.remove(e);
	}

	@Override
	public void clear() {
		mutablelist.clear();

	}

}
