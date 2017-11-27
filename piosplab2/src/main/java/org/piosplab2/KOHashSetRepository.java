package org.piosplab2;

import java.util.function.Supplier;

import com.koloboke.collect.set.hash.HashObjSet;
import com.koloboke.collect.set.hash.HashObjSets;

public class KOHashSetRepository<T> implements InMemoryRepository<T> {
	private HashObjSet<T> kohashset = HashObjSets.newMutableSet();

	public KOHashSetRepository(Supplier<? extends HashObjSet<T>> supplier) {
		this.kohashset = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return kohashset.add(e);
	}

	@Override
	public boolean contains(T e) {
		return kohashset.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return kohashset.remove(e);
	}

	@Override
	public void clear() {
		kohashset.clear();

	}

}
