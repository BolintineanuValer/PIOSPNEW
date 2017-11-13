package org.piosplab2;

import java.util.function.Supplier;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

public class FUOpenHashSetRepository<T> implements InMemoryRepository<T> {
	private ObjectOpenHashSet<T> openhashset = new ObjectOpenHashSet<T>();

	public FUOpenHashSetRepository(Supplier<? extends ObjectOpenHashSet<T>> supplier) {
		this.openhashset = supplier.get();
	}

	@Override
	public boolean add(T e) {
		return openhashset.add(e);
	}

	@Override
	public boolean contains(T e) {
		return openhashset.contains(e);
	}

	@Override
	public boolean remove(T e) {
		return openhashset.remove(e);
	}

	@Override
	public void clear() {
		openhashset.clear();

	}

}
