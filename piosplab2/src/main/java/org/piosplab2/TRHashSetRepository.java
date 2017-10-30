package org.piosplab2;

import java.util.function.Supplier;

import gnu.trove.set.hash.THashSet;

public class TRHashSetRepository<T> implements InMemoryRepository<T> {
	private THashSet<T> thashset;

	public TRHashSetRepository(Supplier<? extends THashSet<T>> supplier) {
		this.thashset = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return thashset.add(e);
	}

	@Override
	public boolean contains(T e) {
		return thashset.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return thashset.remove(e);
	}

	@Override
	public void clear() {
		thashset.clear();

	}
}
