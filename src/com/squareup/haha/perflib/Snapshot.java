package com.squareup.haha.perflib;

import cn.com.fmsh.communication.core.MessageHead;
import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.perflib.analysis.Dominators;
import com.squareup.haha.perflib.analysis.ShortestDistanceVisitor;
import com.squareup.haha.perflib.analysis.TopologicalSort;
import com.squareup.haha.perflib.io.HprofBuffer;
import com.squareup.haha.trove.THashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Snapshot {
    static final /* synthetic */ boolean $assertionsDisabled = (!Snapshot.class.desiredAssertionStatus());
    private static final int DEFAULT_HEAP_ID = 0;
    private static final String JAVA_LANG_CLASS = "java.lang.Class";
    public static final Instance SENTINEL_ROOT = new RootObj(RootType.UNKNOWN);
    final HprofBuffer mBuffer;
    Heap mCurrentHeap;
    private Dominators mDominators;
    ArrayList<Heap> mHeaps = new ArrayList();
    private long mIdSizeMask = MessageHead.SERIAL_MAK;
    private THashSet<ClassObj> mReferenceClasses = new THashSet();
    private ImmutableList<Instance> mTopSort;
    private int[] mTypeSizes;

    public Snapshot(HprofBuffer hprofBuffer) {
        this.mBuffer = hprofBuffer;
        setToDefaultHeap();
    }

    public Heap setToDefaultHeap() {
        return setHeapTo(0, "default");
    }

    public Heap setHeapTo(int i, String str) {
        Heap heap = getHeap(i);
        if (heap == null) {
            heap = new Heap(i, str);
            heap.mSnapshot = this;
            this.mHeaps.add(heap);
        }
        this.mCurrentHeap = heap;
        return this.mCurrentHeap;
    }

    public int getHeapIndex(Heap heap) {
        return this.mHeaps.indexOf(heap);
    }

    public Heap getHeap(int i) {
        for (int i2 = 0; i2 < this.mHeaps.size(); i2++) {
            if (((Heap) this.mHeaps.get(i2)).getId() == i) {
                return (Heap) this.mHeaps.get(i2);
            }
        }
        return null;
    }

    public Heap getHeap(String str) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            if (str.equals(((Heap) this.mHeaps.get(i)).getName())) {
                return (Heap) this.mHeaps.get(i);
            }
        }
        return null;
    }

    public Collection<Heap> getHeaps() {
        return this.mHeaps;
    }

    public Collection<RootObj> getGCRoots() {
        return ((Heap) this.mHeaps.get(0)).mRoots;
    }

    public final void addStackFrame(StackFrame stackFrame) {
        this.mCurrentHeap.addStackFrame(stackFrame);
    }

    public final StackFrame getStackFrame(long j) {
        return this.mCurrentHeap.getStackFrame(j);
    }

    public final void addStackTrace(StackTrace stackTrace) {
        this.mCurrentHeap.addStackTrace(stackTrace);
    }

    public final StackTrace getStackTrace(int i) {
        return this.mCurrentHeap.getStackTrace(i);
    }

    public final StackTrace getStackTraceAtDepth(int i, int i2) {
        return this.mCurrentHeap.getStackTraceAtDepth(i, i2);
    }

    public final void addRoot(RootObj rootObj) {
        this.mCurrentHeap.addRoot(rootObj);
        rootObj.setHeap(this.mCurrentHeap);
    }

    public final void addThread(ThreadObj threadObj, int i) {
        this.mCurrentHeap.addThread(threadObj, i);
    }

    public final ThreadObj getThread(int i) {
        return this.mCurrentHeap.getThread(i);
    }

    public final void setIdSize(int i) {
        int i2 = 0;
        int i3 = -1;
        for (Type typeId : Type.values()) {
            i3 = Math.max(typeId.getTypeId(), i3);
        }
        if ($assertionsDisabled || (i3 > 0 && i3 <= Type.LONG.getTypeId())) {
            this.mTypeSizes = new int[(i3 + 1)];
            Arrays.fill(this.mTypeSizes, -1);
            while (i2 < Type.values().length) {
                this.mTypeSizes[Type.values()[i2].getTypeId()] = Type.values()[i2].getSize();
                i2++;
            }
            this.mTypeSizes[Type.OBJECT.getTypeId()] = i;
            this.mIdSizeMask = -1 >>> ((8 - i) << 3);
            return;
        }
        throw new AssertionError();
    }

    public final int getTypeSize(Type type) {
        return this.mTypeSizes[type.getTypeId()];
    }

    public final long getIdSizeMask() {
        return this.mIdSizeMask;
    }

    public final void addInstance(long j, Instance instance) {
        this.mCurrentHeap.addInstance(j, instance);
        instance.setHeap(this.mCurrentHeap);
    }

    public final void addClass(long j, ClassObj classObj) {
        this.mCurrentHeap.addClass(j, classObj);
        classObj.setHeap(this.mCurrentHeap);
    }

    public final Instance findInstance(long j) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            Instance instance = ((Heap) this.mHeaps.get(i)).getInstance(j);
            if (instance != null) {
                return instance;
            }
        }
        return findClass(j);
    }

    public final ClassObj findClass(long j) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            ClassObj classObj = ((Heap) this.mHeaps.get(i)).getClass(j);
            if (classObj != null) {
                return classObj;
            }
        }
        return null;
    }

    public final ClassObj findClass(String str) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            ClassObj classObj = ((Heap) this.mHeaps.get(i)).getClass(str);
            if (classObj != null) {
                return classObj;
            }
        }
        return null;
    }

    public final Collection<ClassObj> findClasses(String str) {
        Collection arrayList = new ArrayList();
        for (int i = 0; i < this.mHeaps.size(); i++) {
            arrayList.addAll(((Heap) this.mHeaps.get(i)).getClasses(str));
        }
        return arrayList;
    }

    public void resolveClasses() {
        ClassObj findClass = findClass(JAVA_LANG_CLASS);
        int instanceSize = findClass != null ? findClass.getInstanceSize() : 0;
        Iterator it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap heap = (Heap) it.next();
            for (ClassObj classObj : heap.getClasses()) {
                ClassObj superClassObj = classObj.getSuperClassObj();
                if (superClassObj != null) {
                    superClassObj.addSubclass(classObj);
                }
                int i = instanceSize;
                for (Field type : classObj.mStaticFields) {
                    i += getTypeSize(type.getType());
                }
                classObj.setSize(i);
            }
            for (Instance instance : heap.getInstances()) {
                ClassObj classObj2 = instance.getClassObj();
                if (classObj2 != null) {
                    classObj2.addInstance(heap.getId(), instance);
                }
            }
        }
    }

    public void resolveReferences() {
        for (ClassObj classObj : findAllDescendantClasses(ClassObj.getReferenceClassName())) {
            classObj.setIsSoftReference();
            this.mReferenceClasses.add(classObj);
        }
    }

    public List<ClassObj> findAllDescendantClasses(String str) {
        Collection<ClassObj> findClasses = findClasses(str);
        List<ClassObj> arrayList = new ArrayList();
        for (ClassObj descendantClasses : findClasses) {
            arrayList.addAll(descendantClasses.getDescendantClasses());
        }
        return arrayList;
    }

    public void computeDominators() {
        if (this.mDominators == null) {
            this.mTopSort = TopologicalSort.compute(getGCRoots());
            this.mDominators = new Dominators(this, this.mTopSort);
            this.mDominators.computeRetainedSizes();
            new ShortestDistanceVisitor().doVisit(getGCRoots());
        }
    }

    public List<Instance> getReachableInstances() {
        List<Instance> arrayList = new ArrayList(this.mTopSort.size());
        Iterator it = this.mTopSort.iterator();
        while (it.hasNext()) {
            Instance instance = (Instance) it.next();
            if (instance.getImmediateDominator() != null) {
                arrayList.add(instance);
            }
        }
        return arrayList;
    }

    public ImmutableList<Instance> getTopologicalOrdering() {
        return this.mTopSort;
    }

    public final void dumpInstanceCounts() {
        Iterator it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap heap = (Heap) it.next();
            System.out.println("+------------------ instance counts for heap: " + heap.getName());
            heap.dumpInstanceCounts();
        }
    }

    public final void dumpSizes() {
        Iterator it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap heap = (Heap) it.next();
            System.out.println("+------------------ sizes for heap: " + heap.getName());
            heap.dumpSizes();
        }
    }

    public final void dumpSubclasses() {
        Iterator it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap heap = (Heap) it.next();
            System.out.println("+------------------ subclasses for heap: " + heap.getName());
            heap.dumpSubclasses();
        }
    }
}
