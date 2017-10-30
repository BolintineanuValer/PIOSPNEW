package org.piosplab2;

import java.util.Collection;
import java.util.function.Supplier;

public class ConcurrentHashMapRepository<T> implements InMemoryRepository<T> {
	private Collection<T> concurrenthashmap;

    public ConcurrentHashMapRepository(Supplier<? extends Collection<T>> supplier) {
        this.concurrenthashmap = supplier.get();
    }

    @Override
    public boolean add(T e) {
        return concurrenthashmap.add(e);
    }

    @Override
    public boolean contains(T e) {
        return concurrenthashmap.contains(e);
    }

    @Override
    public boolean remove(T e) {
        return concurrenthashmap.remove(e);
    }

	@Override
	public void clear() {
		concurrenthashmap.clear();
		
	}

}
