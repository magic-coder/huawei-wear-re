package com.huawei.hwdatamigrate.hihealth.p409b.p413d;

import android.util.SparseArray;

/* compiled from: HiPriorityUtil */
public class C4838c {
    private static final SparseArray<Integer> f17803a = new SparseArray();
    private static final SparseArray<Integer> f17804b = new SparseArray();
    private static final SparseArray<Integer> f17805c = new SparseArray();
    private static SparseArray<Integer> f17806d = new SparseArray();

    static {
        f17803a.put(20006, Integer.valueOf(10));
        f17803a.put(20002, Integer.valueOf(20));
        f17803a.put(20008, Integer.valueOf(30));
        f17803a.put(20003, Integer.valueOf(40));
        f17803a.put(20005, Integer.valueOf(50));
        f17803a.put(20004, Integer.valueOf(60));
        f17803a.put(20007, Integer.valueOf(70));
        f17804b.put(22003, Integer.valueOf(10));
        f17804b.put(22002, Integer.valueOf(20));
        f17804b.put(22001, Integer.valueOf(30));
        f17805c.put(22104, Integer.valueOf(10));
        f17805c.put(22105, Integer.valueOf(20));
        f17805c.put(22101, Integer.valueOf(30));
        f17805c.put(22102, Integer.valueOf(40));
        f17805c.put(22103, Integer.valueOf(50));
        f17806d.put(32, Integer.valueOf(10));
        f17806d.put(30, Integer.valueOf(10));
        f17806d.put(23, Integer.valueOf(30));
        f17806d.put(1, Integer.valueOf(100));
    }

    public static Integer m23333a(int i) {
        Integer num = (Integer) f17806d.get(i);
        if (num == null) {
            return Integer.valueOf(50);
        }
        return num;
    }

    public static int m23332a(int i, int i2) {
        Integer num = (Integer) f17803a.get(i);
        Integer num2 = (Integer) f17803a.get(i2);
        if (num == null || num2 == null) {
            return 0;
        }
        return num.compareTo(num2);
    }

    public static int m23334b(int i, int i2) {
        Integer num = (Integer) f17804b.get(i);
        Integer num2 = (Integer) f17804b.get(i2);
        if (num == null || num2 == null) {
            return 0;
        }
        return num.compareTo(num2);
    }

    public static int m23335c(int i, int i2) {
        Integer num = (Integer) f17805c.get(i);
        Integer num2 = (Integer) f17805c.get(i2);
        if (num == null || num2 == null) {
            return 0;
        }
        return num.compareTo(num2);
    }
}
