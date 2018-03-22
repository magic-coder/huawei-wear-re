package com.squareup.haha.perflib;

import com.squareup.haha.guava.collect.ArrayListMultimap;
import com.squareup.haha.guava.collect.Multimap;
import com.squareup.haha.trove.TIntObjectHashMap;
import com.squareup.haha.trove.TLongObjectHashMap;
import com.squareup.haha.trove.TObjectProcedure;
import java.util.ArrayList;
import java.util.Collection;

public class Heap {
    TLongObjectHashMap<ClassObj> mClassesById = new TLongObjectHashMap();
    Multimap<String, ClassObj> mClassesByName = ArrayListMultimap.create();
    TLongObjectHashMap<StackFrame> mFrames = new TLongObjectHashMap();
    private final int mId;
    private final TLongObjectHashMap<Instance> mInstances = new TLongObjectHashMap();
    private final String mName;
    ArrayList<RootObj> mRoots = new ArrayList();
    Snapshot mSnapshot;
    TIntObjectHashMap<ThreadObj> mThreads = new TIntObjectHashMap();
    TIntObjectHashMap<StackTrace> mTraces = new TIntObjectHashMap();

    public Heap(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public final void addStackFrame(StackFrame stackFrame) {
        this.mFrames.put(stackFrame.mId, stackFrame);
    }

    public final StackFrame getStackFrame(long j) {
        return (StackFrame) this.mFrames.get(j);
    }

    public final void addStackTrace(StackTrace stackTrace) {
        this.mTraces.put(stackTrace.mSerialNumber, stackTrace);
    }

    public final StackTrace getStackTrace(int i) {
        return (StackTrace) this.mTraces.get(i);
    }

    public final StackTrace getStackTraceAtDepth(int i, int i2) {
        StackTrace stackTrace = (StackTrace) this.mTraces.get(i);
        if (stackTrace != null) {
            return stackTrace.fromDepth(i2);
        }
        return stackTrace;
    }

    public final void addRoot(RootObj rootObj) {
        rootObj.mIndex = this.mRoots.size();
        this.mRoots.add(rootObj);
    }

    public final void addThread(ThreadObj threadObj, int i) {
        this.mThreads.put(i, threadObj);
    }

    public final ThreadObj getThread(int i) {
        return (ThreadObj) this.mThreads.get(i);
    }

    public final void addInstance(long j, Instance instance) {
        this.mInstances.put(j, instance);
    }

    public final Instance getInstance(long j) {
        return (Instance) this.mInstances.get(j);
    }

    public final void addClass(long j, ClassObj classObj) {
        this.mClassesById.put(j, classObj);
        this.mClassesByName.put(classObj.mClassName, classObj);
    }

    public final ClassObj getClass(long j) {
        return (ClassObj) this.mClassesById.get(j);
    }

    public final ClassObj getClass(String str) {
        Collection collection = this.mClassesByName.get(str);
        if (collection.size() == 1) {
            return (ClassObj) collection.iterator().next();
        }
        return null;
    }

    public final Collection<ClassObj> getClasses(String str) {
        return this.mClassesByName.get(str);
    }

    public final void dumpInstanceCounts() {
        for (Object obj : this.mClassesById.getValues()) {
            ClassObj classObj = (ClassObj) obj;
            int instanceCount = classObj.getInstanceCount();
            if (instanceCount > 0) {
                System.out.println(classObj + ": " + instanceCount);
            }
        }
    }

    public final void dumpSubclasses() {
        for (Object obj : this.mClassesById.getValues()) {
            ClassObj classObj = (ClassObj) obj;
            if (classObj.mSubclasses.size() > 0) {
                System.out.println(classObj);
                classObj.dumpSubclasses();
            }
        }
    }

    public final void dumpSizes() {
        for (Object obj : this.mClassesById.getValues()) {
            ClassObj classObj = (ClassObj) obj;
            int i = 0;
            for (Instance compositeSize : classObj.getHeapInstances(getId())) {
                i = compositeSize.getCompositeSize() + i;
            }
            if (i > 0) {
                System.out.println(classObj + ": base " + classObj.getSize() + ", composite " + i);
            }
        }
    }

    public Collection<ClassObj> getClasses() {
        return this.mClassesByName.values();
    }

    public Collection<Instance> getInstances() {
        final Collection arrayList = new ArrayList(this.mInstances.size());
        this.mInstances.forEachValue(new TObjectProcedure<Instance>() {
            public boolean execute(Instance instance) {
                arrayList.add(instance);
                return true;
            }
        });
        return arrayList;
    }

    public int getInstancesCount() {
        return this.mInstances.size();
    }
}
