package com.squareup.haha.perflib;

import android.support.v4.internal.view.SupportMenu;
import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.perflib.io.HprofBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Instance {
    static final /* synthetic */ boolean $assertionsDisabled = (!Instance.class.desiredAssertionStatus());
    long mClassId;
    int mDistanceToGcRoot = Integer.MAX_VALUE;
    private final ArrayList<Instance> mHardReferences = new ArrayList();
    Heap mHeap;
    protected final long mId;
    private Instance mImmediateDominator;
    Instance mNextInstanceToGcRoot = null;
    boolean mReferencesAdded = false;
    private long[] mRetainedSizes;
    int mSize;
    private ArrayList<Instance> mSoftReferences = null;
    protected final StackTrace mStack;
    int mTopologicalOrder;

    public class CompositeSizeVisitor extends NonRecursiveVisitor {
        int mSize = 0;

        protected void defaultAction(Instance instance) {
            this.mSize += instance.getSize();
        }

        public int getCompositeSize() {
            return this.mSize;
        }
    }

    public abstract void accept(Visitor visitor);

    Instance(long j, StackTrace stackTrace) {
        this.mId = j;
        this.mStack = stackTrace;
    }

    public long getId() {
        return this.mId;
    }

    public long getUniqueId() {
        return getId() & this.mHeap.mSnapshot.getIdSizeMask();
    }

    public void setClassId(long j) {
        this.mClassId = j;
    }

    public ClassObj getClassObj() {
        return this.mHeap.mSnapshot.findClass(this.mClassId);
    }

    public final int getCompositeSize() {
        CompositeSizeVisitor compositeSizeVisitor = new CompositeSizeVisitor();
        compositeSizeVisitor.doVisit(ImmutableList.of(this));
        return compositeSizeVisitor.getCompositeSize();
    }

    public int getSize() {
        return this.mSize;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public void setHeap(Heap heap) {
        this.mHeap = heap;
    }

    public Heap getHeap() {
        return this.mHeap;
    }

    public int getTopologicalOrder() {
        return this.mTopologicalOrder;
    }

    public void setTopologicalOrder(int i) {
        this.mTopologicalOrder = i;
    }

    public Instance getImmediateDominator() {
        return this.mImmediateDominator;
    }

    public void setImmediateDominator(Instance instance) {
        this.mImmediateDominator = instance;
    }

    public int getDistanceToGcRoot() {
        return this.mDistanceToGcRoot;
    }

    public Instance getNextInstanceToGcRoot() {
        return this.mNextInstanceToGcRoot;
    }

    public void setDistanceToGcRoot(int i) {
        if ($assertionsDisabled || i < this.mDistanceToGcRoot) {
            this.mDistanceToGcRoot = i;
            return;
        }
        throw new AssertionError();
    }

    public void setNextInstanceToGcRoot(Instance instance) {
        this.mNextInstanceToGcRoot = instance;
    }

    public void resetRetainedSize() {
        List list = this.mHeap.mSnapshot.mHeaps;
        if (this.mRetainedSizes == null) {
            this.mRetainedSizes = new long[list.size()];
        } else {
            Arrays.fill(this.mRetainedSizes, 0);
        }
        this.mRetainedSizes[list.indexOf(this.mHeap)] = (long) getSize();
    }

    public void addRetainedSize(int i, long j) {
        long[] jArr = this.mRetainedSizes;
        jArr[i] = jArr[i] + j;
    }

    public long getRetainedSize(int i) {
        return this.mRetainedSizes[i];
    }

    public long getTotalRetainedSize() {
        long j = 0;
        if (this.mRetainedSizes != null) {
            long[] jArr = this.mRetainedSizes;
            int i = 0;
            while (i < jArr.length) {
                long j2 = jArr[i] + j;
                i++;
                j = j2;
            }
        }
        return j;
    }

    public void addReference(Field field, Instance instance) {
        if (instance.getIsSoftReference() && field != null && field.getName().equals("referent")) {
            if (this.mSoftReferences == null) {
                this.mSoftReferences = new ArrayList();
            }
            this.mSoftReferences.add(instance);
            return;
        }
        this.mHardReferences.add(instance);
    }

    public ArrayList<Instance> getHardReferences() {
        return this.mHardReferences;
    }

    public ArrayList<Instance> getSoftReferences() {
        return this.mSoftReferences;
    }

    public boolean getIsSoftReference() {
        return false;
    }

    protected Object readValue(Type type) {
        switch (type) {
            case OBJECT:
                return this.mHeap.mSnapshot.findInstance(readId());
            case BOOLEAN:
                return Boolean.valueOf(getBuffer().readByte() != (byte) 0);
            case CHAR:
                return Character.valueOf(getBuffer().readChar());
            case FLOAT:
                return Float.valueOf(getBuffer().readFloat());
            case DOUBLE:
                return Double.valueOf(getBuffer().readDouble());
            case BYTE:
                return Byte.valueOf(getBuffer().readByte());
            case SHORT:
                return Short.valueOf(getBuffer().readShort());
            case INT:
                return Integer.valueOf(getBuffer().readInt());
            case LONG:
                return Long.valueOf(getBuffer().readLong());
            default:
                return null;
        }
    }

    protected long readId() {
        switch (this.mHeap.mSnapshot.getTypeSize(Type.OBJECT)) {
            case 1:
                return (long) getBuffer().readByte();
            case 2:
                return (long) getBuffer().readShort();
            case 4:
                return (long) getBuffer().readInt();
            case 8:
                return getBuffer().readLong();
            default:
                return 0;
        }
    }

    protected int readUnsignedByte() {
        return getBuffer().readByte() & 255;
    }

    protected int readUnsignedShort() {
        return getBuffer().readShort() & SupportMenu.USER_MASK;
    }

    protected HprofBuffer getBuffer() {
        return this.mHeap.mSnapshot.mBuffer;
    }
}
