package org.piosplab2;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 20, time = 1)
@Fork(2)
public class TestContains {

    @State(Scope.Benchmark)
    public static class BeforeState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @Benchmark
    public boolean contains_before(RepoState repoState, BeforeState before) {
        return repoState.orders.contains(before.order);
    }

    @Benchmark
    public boolean contains_existing(RepoState repoState, ExistingState existing) {
        return repoState.orders.contains(existing.order);
    }

    @Benchmark
    public boolean contains_after(RepoState repoState, AfterState after) {
        return repoState.orders.contains(after.order);
    }
}
