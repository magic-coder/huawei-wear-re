package com.squareup.leakcanary;

import com.squareup.haha.perflib.ArrayInstance;
import com.squareup.haha.perflib.ClassInstance;
import com.squareup.haha.perflib.ClassInstance.FieldValue;
import com.squareup.haha.perflib.ClassObj;
import com.squareup.haha.perflib.Field;
import com.squareup.haha.perflib.HahaSpy;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.RootObj;
import com.squareup.haha.perflib.RootType;
import com.squareup.haha.perflib.Snapshot;
import com.squareup.leakcanary.LeakTraceElement.Type;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

final class ShortestPathFinder {
    private boolean canIgnoreStrings;
    private final ExcludedRefs excludedRefs;
    private final Queue<LeakNode> toVisitIfNoPathQueue = new LinkedList();
    private final LinkedHashSet<Instance> toVisitIfNoPathSet = new LinkedHashSet();
    private final Queue<LeakNode> toVisitQueue = new LinkedList();
    private final LinkedHashSet<Instance> toVisitSet = new LinkedHashSet();
    private final LinkedHashSet<Instance> visitedSet = new LinkedHashSet();

    final class Result {
        final boolean excludingKnownLeaks;
        final LeakNode leakingNode;

        Result(LeakNode leakNode, boolean z) {
            this.leakingNode = leakNode;
            this.excludingKnownLeaks = z;
        }
    }

    ShortestPathFinder(ExcludedRefs excludedRefs) {
        this.excludedRefs = excludedRefs;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.squareup.leakcanary.ShortestPathFinder.Result findPath(com.squareup.haha.perflib.Snapshot r6, com.squareup.haha.perflib.Instance r7) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r5.clearState();
        r0 = r5.isString(r7);
        if (r0 != 0) goto L_0x003c;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        r5.canIgnoreStrings = r0;
        r5.enqueueGcRoots(r6);
        r3 = 0;
    L_0x0012:
        r0 = r5.toVisitQueue;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0022;
    L_0x001a:
        r0 = r5.toVisitIfNoPathQueue;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00ae;
    L_0x0022:
        r0 = r5.toVisitQueue;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x003e;
    L_0x002a:
        r0 = r5.toVisitQueue;
        r0 = r0.poll();
        r0 = (com.squareup.leakcanary.LeakNode) r0;
    L_0x0032:
        r4 = r0.instance;
        if (r4 != r7) goto L_0x0065;
    L_0x0036:
        r1 = new com.squareup.leakcanary.ShortestPathFinder$Result;
        r1.<init>(r0, r2);
        return r1;
    L_0x003c:
        r0 = r2;
        goto L_0x000c;
    L_0x003e:
        r0 = r5.toVisitIfNoPathQueue;
        r0 = r0.poll();
        r0 = (com.squareup.leakcanary.LeakNode) r0;
        r2 = r0.exclusion;
        if (r2 != 0) goto L_0x0063;
    L_0x004a:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expected node to have an exclusion ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0063:
        r2 = r1;
        goto L_0x0032;
    L_0x0065:
        r4 = r5.checkSeen(r0);
        if (r4 != 0) goto L_0x0012;
    L_0x006b:
        r4 = r0.instance;
        r4 = r4 instanceof com.squareup.haha.perflib.RootObj;
        if (r4 == 0) goto L_0x0075;
    L_0x0071:
        r5.visitRootObj(r0);
        goto L_0x0012;
    L_0x0075:
        r4 = r0.instance;
        r4 = r4 instanceof com.squareup.haha.perflib.ClassObj;
        if (r4 == 0) goto L_0x007f;
    L_0x007b:
        r5.visitClassObj(r0);
        goto L_0x0012;
    L_0x007f:
        r4 = r0.instance;
        r4 = r4 instanceof com.squareup.haha.perflib.ClassInstance;
        if (r4 == 0) goto L_0x0089;
    L_0x0085:
        r5.visitClassInstance(r0);
        goto L_0x0012;
    L_0x0089:
        r4 = r0.instance;
        r4 = r4 instanceof com.squareup.haha.perflib.ArrayInstance;
        if (r4 == 0) goto L_0x0093;
    L_0x008f:
        r5.visitArrayInstance(r0);
        goto L_0x0012;
    L_0x0093:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unexpected type for ";
        r2 = r2.append(r3);
        r0 = r0.instance;
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x00ae:
        r0 = r3;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.leakcanary.ShortestPathFinder.findPath(com.squareup.haha.perflib.Snapshot, com.squareup.haha.perflib.Instance):com.squareup.leakcanary.ShortestPathFinder$Result");
    }

    private void clearState() {
        this.toVisitQueue.clear();
        this.toVisitIfNoPathQueue.clear();
        this.toVisitSet.clear();
        this.toVisitIfNoPathSet.clear();
        this.visitedSet.clear();
    }

    private void enqueueGcRoots(Snapshot snapshot) {
        for (RootObj rootObj : snapshot.getGCRoots()) {
            switch (rootObj.getRootType()) {
                case JAVA_LOCAL:
                    Exclusion exclusion = (Exclusion) this.excludedRefs.threadNames.get(HahaHelper.threadName(HahaSpy.allocatingThread(rootObj)));
                    if (exclusion != null && exclusion.alwaysExclude) {
                        break;
                    }
                    enqueue(exclusion, null, rootObj, null, null);
                    break;
                    break;
                case INTERNED_STRING:
                case DEBUGGER:
                case INVALID_TYPE:
                case UNREACHABLE:
                case UNKNOWN:
                case FINALIZING:
                    break;
                case SYSTEM_CLASS:
                case VM_INTERNAL:
                case NATIVE_LOCAL:
                case NATIVE_STATIC:
                case THREAD_BLOCK:
                case BUSY_MONITOR:
                case NATIVE_MONITOR:
                case REFERENCE_CLEANUP:
                case NATIVE_STACK:
                case JAVA_STATIC:
                    enqueue(null, null, rootObj, null, null);
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown root type:" + rootObj.getRootType());
            }
        }
    }

    private boolean checkSeen(LeakNode leakNode) {
        return !this.visitedSet.add(leakNode.instance);
    }

    private void visitRootObj(LeakNode leakNode) {
        RootObj rootObj = (RootObj) leakNode.instance;
        Instance referredInstance = rootObj.getReferredInstance();
        if (rootObj.getRootType() == RootType.JAVA_LOCAL) {
            Exclusion exclusion;
            Instance allocatingThread = HahaSpy.allocatingThread(rootObj);
            if (leakNode.exclusion != null) {
                exclusion = leakNode.exclusion;
            } else {
                exclusion = null;
            }
            LeakNode leakNode2 = new LeakNode(null, allocatingThread, null, null, null);
            enqueue(exclusion, leakNode2, referredInstance, "<Java Local>", Type.LOCAL);
            return;
        }
        enqueue(null, leakNode, referredInstance, null, null);
    }

    private void visitClassObj(LeakNode leakNode) {
        ClassObj classObj = (ClassObj) leakNode.instance;
        Map map = (Map) this.excludedRefs.staticFieldNameByClassName.get(classObj.getClassName());
        for (Entry entry : classObj.getStaticFieldValues().entrySet()) {
            Field field = (Field) entry.getKey();
            if (field.getType() == com.squareup.haha.perflib.Type.OBJECT) {
                String name = field.getName();
                if (!name.equals("$staticOverhead")) {
                    Instance instance = (Instance) entry.getValue();
                    Object obj = 1;
                    if (map != null) {
                        Exclusion exclusion = (Exclusion) map.get(name);
                        if (exclusion != null) {
                            if (!exclusion.alwaysExclude) {
                                enqueue(exclusion, leakNode, instance, name, Type.STATIC_FIELD);
                            }
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        enqueue(null, leakNode, instance, name, Type.STATIC_FIELD);
                    }
                }
            }
        }
    }

    private void visitClassInstance(LeakNode leakNode) {
        ClassInstance classInstance = (ClassInstance) leakNode.instance;
        Map linkedHashMap = new LinkedHashMap();
        Exclusion exclusion = null;
        for (ClassObj classObj = classInstance.getClassObj(); classObj != null; classObj = classObj.getSuperClassObj()) {
            Exclusion exclusion2;
            Exclusion exclusion3 = (Exclusion) this.excludedRefs.classNames.get(classObj.getClassName());
            if (exclusion3 == null || (exclusion != null && exclusion.alwaysExclude)) {
                exclusion2 = exclusion;
            } else {
                exclusion2 = exclusion3;
            }
            Map map = (Map) this.excludedRefs.fieldNameByClassName.get(classObj.getClassName());
            if (map != null) {
                linkedHashMap.putAll(map);
            }
            exclusion = exclusion2;
        }
        if (exclusion == null || !exclusion.alwaysExclude) {
            for (FieldValue fieldValue : classInstance.getValues()) {
                Field field = fieldValue.getField();
                if (field.getType() == com.squareup.haha.perflib.Type.OBJECT) {
                    Instance instance = (Instance) fieldValue.getValue();
                    String name = field.getName();
                    Exclusion exclusion4 = (Exclusion) linkedHashMap.get(name);
                    if (exclusion4 == null || (exclusion != null && (!exclusion4.alwaysExclude || exclusion.alwaysExclude))) {
                        exclusion3 = exclusion;
                    } else {
                        exclusion3 = exclusion4;
                    }
                    enqueue(exclusion3, leakNode, instance, name, Type.INSTANCE_FIELD);
                }
            }
        }
    }

    private void visitArrayInstance(LeakNode leakNode) {
        ArrayInstance arrayInstance = (ArrayInstance) leakNode.instance;
        if (arrayInstance.getArrayType() == com.squareup.haha.perflib.Type.OBJECT) {
            Object[] values = arrayInstance.getValues();
            for (int i = 0; i < values.length; i++) {
                enqueue(null, leakNode, (Instance) values[i], "[" + i + "]", Type.ARRAY_ENTRY);
            }
        }
    }

    private void enqueue(Exclusion exclusion, LeakNode leakNode, Instance instance, String str, Type type) {
        if (instance != null && !HahaHelper.isPrimitiveOrWrapperArray(instance) && !HahaHelper.isPrimitiveWrapper(instance) && !this.toVisitSet.contains(instance)) {
            Object obj;
            if (exclusion == null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || !this.toVisitIfNoPathSet.contains(instance)) {
                if ((!this.canIgnoreStrings || !isString(instance)) && !this.visitedSet.contains(instance)) {
                    LeakNode leakNode2 = new LeakNode(exclusion, instance, leakNode, str, type);
                    if (obj != null) {
                        this.toVisitSet.add(instance);
                        this.toVisitQueue.add(leakNode2);
                        return;
                    }
                    this.toVisitIfNoPathSet.add(instance);
                    this.toVisitIfNoPathQueue.add(leakNode2);
                }
            }
        }
    }

    private boolean isString(Instance instance) {
        return instance.getClassObj() != null && instance.getClassObj().getClassName().equals(String.class.getName());
    }
}
