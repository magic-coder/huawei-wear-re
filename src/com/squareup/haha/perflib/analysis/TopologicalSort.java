package com.squareup.haha.perflib.analysis;

import com.squareup.haha.guava.base.Joiner;
import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.NonRecursiveVisitor;
import com.squareup.haha.perflib.RootObj;
import com.squareup.haha.perflib.Snapshot;
import com.squareup.haha.trove.TLongHashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TopologicalSort {

    class TopologicalSortVisitor extends NonRecursiveVisitor {
        private final List<Instance> mPostorder;
        private final TLongHashSet mVisited;

        private TopologicalSortVisitor() {
            this.mVisited = new TLongHashSet();
            this.mPostorder = new ArrayList();
        }

        public void visitLater(Instance instance, Instance instance2) {
            if (!this.mSeen.contains(instance2.getId())) {
                this.mStack.push(instance2);
            }
        }

        public void doVisit(Iterable<? extends Instance> iterable) {
            Instance instance;
            for (Instance instance2 : iterable) {
                instance2.accept(this);
            }
            while (!this.mStack.isEmpty()) {
                instance2 = (Instance) this.mStack.peek();
                if (this.mSeen.add(instance2.getId())) {
                    instance2.accept(this);
                } else {
                    this.mStack.pop();
                    if (this.mVisited.add(instance2.getId())) {
                        this.mPostorder.add(instance2);
                    }
                }
            }
        }

        ImmutableList<Instance> getOrderedInstances() {
            return ImmutableList.copyOf(Joiner.reverse(this.mPostorder));
        }
    }

    public static ImmutableList<Instance> compute(Iterable<RootObj> iterable) {
        TopologicalSortVisitor topologicalSortVisitor = new TopologicalSortVisitor();
        topologicalSortVisitor.doVisit(iterable);
        ImmutableList<Instance> orderedInstances = topologicalSortVisitor.getOrderedInstances();
        Snapshot.SENTINEL_ROOT.setTopologicalOrder(0);
        Iterator it = orderedInstances.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            ((Instance) it.next()).setTopologicalOrder(i);
        }
        return orderedInstances;
    }
}
