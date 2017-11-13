package org.piosplab2;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Supplier;

import org.eclipse.collections.impl.factory.Lists;

import gnu.trove.set.hash.THashSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.koloboke.collect.set.hash.HashObjSets;

public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
	HASH_SET() {
		@Override
		public InMemoryRepository<Order> get() {
			return new HashSetRepository<>(HashSet::new);
		}
	},

	TREE_SET() {
		@Override
		public InMemoryRepository<Order> get() {
			return new TreeSetRepository<>(TreeSet::new);
		}
	},

	ARRAY_LIST() {
		@Override
		public InMemoryRepository<Order> get() {
			return new ArrayListRepository<>(ArrayList::new);
		}
	},

	CONCURRENT_HASH_MAP() {
		@Override
		public InMemoryRepository<Order> get() {
			return new ConcurrentHashMapRepository<>(
					() -> Collections.newSetFromMap(new ConcurrentHashMap<Order, Boolean>()));
		}
	},

	TR_HASH_SET() {
		@Override
		public InMemoryRepository<Order> get() {
			return new TRHashSetRepository<>(THashSet::new);
		}
	},

	EC_MUTABLE_LIST() {
		@Override
		public InMemoryRepository<Order> get() {
			return new ECMutableListRepository<>(() -> Lists.mutable.empty());
		}
	},

	FU_OPEN_HASH_SET() {
		@Override
		public InMemoryRepository<Order> get() {
			return new FUOpenHashSetRepository<>(ObjectOpenHashSet::new);
		}
	},

	KO_HASH_SET() {
		@Override
		public InMemoryRepository<Order> get() {
			return new KOHashSetRepository<>(() -> HashObjSets.newMutableSet());
		}
	}

}
