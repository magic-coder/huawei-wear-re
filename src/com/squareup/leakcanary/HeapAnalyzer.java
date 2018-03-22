package com.squareup.leakcanary;

import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.squareup.haha.perflib.ArrayInstance;
import com.squareup.haha.perflib.ClassInstance;
import com.squareup.haha.perflib.ClassInstance.FieldValue;
import com.squareup.haha.perflib.ClassObj;
import com.squareup.haha.perflib.Field;
import com.squareup.haha.perflib.HprofParser;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.RootObj;
import com.squareup.haha.perflib.RootType;
import com.squareup.haha.perflib.Snapshot;
import com.squareup.haha.perflib.io.MemoryMappedFileBuffer;
import com.squareup.haha.trove.THashMap;
import com.squareup.haha.trove.TObjectProcedure;
import com.squareup.leakcanary.LeakTraceElement.Holder;
import com.squareup.leakcanary.LeakTraceElement.Type;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public final class HeapAnalyzer {
    private static final String ANONYMOUS_CLASS_NAME_PATTERN = "^.+\\$\\d+$";
    private final ExcludedRefs excludedRefs;

    public HeapAnalyzer(ExcludedRefs excludedRefs) {
        this.excludedRefs = excludedRefs;
    }

    public List<TrackedReference> findTrackedReferences(File file) {
        if (file.exists()) {
            try {
                Snapshot parse = new HprofParser(new MemoryMappedFileBuffer(file)).parse();
                deduplicateGcRoots(parse);
                ClassObj findClass = parse.findClass(KeyedWeakReference.class.getName());
                List<TrackedReference> arrayList = new ArrayList();
                for (Instance classInstanceValues : findClass.getInstancesList()) {
                    List classInstanceValues2 = HahaHelper.classInstanceValues(classInstanceValues);
                    String asString = HahaHelper.asString(HahaHelper.fieldValue(classInstanceValues2, SMSKeyInfo.TAG_KEY));
                    String asString2 = HahaHelper.hasField(classInstanceValues2, "name") ? HahaHelper.asString(HahaHelper.fieldValue(classInstanceValues2, "name")) : "(No name field)";
                    Instance classInstanceValues3 = (Instance) HahaHelper.fieldValue(classInstanceValues2, "referent");
                    if (classInstanceValues3 != null) {
                        arrayList.add(new TrackedReference(asString, asString2, getClassName(classInstanceValues3), describeFields(classInstanceValues3)));
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        } else {
            throw new IllegalArgumentException("File does not exist: " + file);
        }
    }

    public AnalysisResult checkForLeak(File file, String str) {
        long nanoTime = System.nanoTime();
        if (!file.exists()) {
            return AnalysisResult.failure(new IllegalArgumentException("File does not exist: " + file), since(nanoTime));
        }
        try {
            Snapshot parse = new HprofParser(new MemoryMappedFileBuffer(file)).parse();
            deduplicateGcRoots(parse);
            Instance findLeakingReference = findLeakingReference(str, parse);
            if (findLeakingReference == null) {
                return AnalysisResult.noLeak(since(nanoTime));
            }
            return findLeakTrace(nanoTime, parse, findLeakingReference);
        } catch (Throwable th) {
            return AnalysisResult.failure(th, since(nanoTime));
        }
    }

    void deduplicateGcRoots(Snapshot snapshot) {
        final THashMap tHashMap = new THashMap();
        final Collection<RootObj> gCRoots = snapshot.getGCRoots();
        for (RootObj rootObj : gCRoots) {
            String generateRootKey = generateRootKey(rootObj);
            if (!tHashMap.containsKey(generateRootKey)) {
                tHashMap.put(generateRootKey, rootObj);
            }
        }
        gCRoots.clear();
        tHashMap.forEach(new TObjectProcedure<String>() {
            public boolean execute(String str) {
                return gCRoots.add(tHashMap.get(str));
            }
        });
    }

    private String generateRootKey(RootObj rootObj) {
        return String.format("%s@0x%08x", new Object[]{rootObj.getRootType().getName(), Long.valueOf(rootObj.getId())});
    }

    private Instance findLeakingReference(String str, Snapshot snapshot) {
        ClassObj findClass = snapshot.findClass(KeyedWeakReference.class.getName());
        List arrayList = new ArrayList();
        for (Instance classInstanceValues : findClass.getInstancesList()) {
            List classInstanceValues2 = HahaHelper.classInstanceValues(classInstanceValues);
            String asString = HahaHelper.asString(HahaHelper.fieldValue(classInstanceValues2, SMSKeyInfo.TAG_KEY));
            if (asString.equals(str)) {
                return (Instance) HahaHelper.fieldValue(classInstanceValues2, "referent");
            }
            arrayList.add(asString);
        }
        throw new IllegalStateException("Could not find weak reference with key " + str + " in " + arrayList);
    }

    private AnalysisResult findLeakTrace(long j, Snapshot snapshot, Instance instance) {
        Result findPath = new ShortestPathFinder(this.excludedRefs).findPath(snapshot, instance);
        if (findPath.leakingNode == null) {
            return AnalysisResult.noLeak(since(j));
        }
        LeakTrace buildLeakTrace = buildLeakTrace(findPath.leakingNode);
        String className = instance.getClassObj().getClassName();
        snapshot.computeDominators();
        Instance instance2 = findPath.leakingNode.instance;
        return AnalysisResult.leakDetected(findPath.excludingKnownLeaks, className, buildLeakTrace, instance2.getTotalRetainedSize() + ((long) computeIgnoredBitmapRetainedSize(snapshot, instance2)), since(j));
    }

    private int computeIgnoredBitmapRetainedSize(Snapshot snapshot, Instance instance) {
        int i = 0;
        for (Instance instance2 : snapshot.findClass("android.graphics.Bitmap").getInstancesList()) {
            int i2;
            if (isIgnoredDominator(instance, instance2)) {
                ArrayInstance arrayInstance = (ArrayInstance) HahaHelper.fieldValue(HahaHelper.classInstanceValues(instance2), "mBuffer");
                if (arrayInstance != null) {
                    long totalRetainedSize = arrayInstance.getTotalRetainedSize();
                    long totalRetainedSize2 = instance2.getTotalRetainedSize();
                    if (totalRetainedSize2 < totalRetainedSize) {
                        totalRetainedSize2 += totalRetainedSize;
                    }
                    i2 = (int) (totalRetainedSize2 + ((long) i));
                }
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    private boolean isIgnoredDominator(Instance instance, Instance instance2) {
        boolean z = false;
        while (true) {
            boolean z2;
            Instance immediateDominator = instance2.getImmediateDominator();
            if ((immediateDominator instanceof RootObj) && ((RootObj) immediateDominator).getRootType() == RootType.UNKNOWN) {
                instance2 = instance2.getNextInstanceToGcRoot();
                z2 = true;
            } else {
                z2 = z;
                instance2 = immediateDominator;
            }
            if (instance2 == null) {
                return false;
            }
            if (instance2 == instance) {
                return z2;
            }
            z = z2;
        }
    }

    private LeakTrace buildLeakTrace(LeakNode leakNode) {
        List arrayList = new ArrayList();
        for (LeakNode leakNode2 = new LeakNode(null, null, leakNode, null, null); leakNode2 != null; leakNode2 = leakNode2.parent) {
            LeakTraceElement buildLeakElement = buildLeakElement(leakNode2);
            if (buildLeakElement != null) {
                arrayList.add(0, buildLeakElement);
            }
        }
        return new LeakTrace(arrayList);
    }

    private LeakTraceElement buildLeakElement(LeakNode leakNode) {
        String str = null;
        if (leakNode.parent == null) {
            return null;
        }
        Instance instance = leakNode.parent.instance;
        if (instance instanceof RootObj) {
            return null;
        }
        Holder holder;
        String str2;
        Type type = leakNode.referenceType;
        String str3 = leakNode.referenceName;
        List describeFields = describeFields(instance);
        String className = getClassName(instance);
        if (instance instanceof ClassObj) {
            holder = Holder.CLASS;
            str2 = null;
        } else if (instance instanceof ArrayInstance) {
            holder = Holder.ARRAY;
            str2 = null;
        } else {
            ClassObj classObj = instance.getClassObj();
            if (HahaHelper.extendsThread(classObj)) {
                holder = Holder.THREAD;
                str2 = "(named '" + HahaHelper.threadName(instance) + "')";
            } else if (className.matches(ANONYMOUS_CLASS_NAME_PATTERN)) {
                str2 = classObj.getSuperClassObj().getClassName();
                if (Object.class.getName().equals(str2)) {
                    holder = Holder.OBJECT;
                    try {
                        Class[] interfaces = Class.forName(classObj.getClassName()).getInterfaces();
                        if (interfaces.length > 0) {
                            str = "(anonymous implementation of " + interfaces[0].getName() + ")";
                        } else {
                            str = "(anonymous subclass of java.lang.Object)";
                        }
                    } catch (ClassNotFoundException e) {
                    }
                } else {
                    holder = Holder.OBJECT;
                    str = "(anonymous subclass of " + str2 + ")";
                }
                str2 = str;
            } else {
                holder = Holder.OBJECT;
                str2 = null;
            }
        }
        return new LeakTraceElement(str3, type, holder, className, str2, leakNode.exclusion, describeFields);
    }

    private List<String> describeFields(Instance instance) {
        List<String> arrayList = new ArrayList();
        if (instance instanceof ClassObj) {
            for (Entry entry : ((ClassObj) instance).getStaticFieldValues().entrySet()) {
                Field field = (Field) entry.getKey();
                arrayList.add("static " + field.getName() + " = " + entry.getValue());
            }
        } else if (instance instanceof ArrayInstance) {
            ArrayInstance arrayInstance = (ArrayInstance) instance;
            if (arrayInstance.getArrayType() == com.squareup.haha.perflib.Type.OBJECT) {
                Object[] values = arrayInstance.getValues();
                for (int i = 0; i < values.length; i++) {
                    arrayList.add("[" + i + "] = " + values[i]);
                }
            }
        } else {
            for (Entry entry2 : instance.getClassObj().getStaticFieldValues().entrySet()) {
                arrayList.add("static " + HahaHelper.fieldToString(entry2));
            }
            for (FieldValue fieldToString : ((ClassInstance) instance).getValues()) {
                arrayList.add(HahaHelper.fieldToString(fieldToString));
            }
        }
        return arrayList;
    }

    private String getClassName(Instance instance) {
        if (instance instanceof ClassObj) {
            return ((ClassObj) instance).getClassName();
        }
        if (instance instanceof ArrayInstance) {
            return ((ArrayInstance) instance).getClassObj().getClassName();
        }
        return instance.getClassObj().getClassName();
    }

    private long since(long j) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j);
    }
}
