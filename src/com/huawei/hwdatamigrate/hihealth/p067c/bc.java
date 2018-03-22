package com.huawei.hwdatamigrate.hihealth.p067c;

import android.util.SparseArray;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;

/* compiled from: MergePolicy */
public class bc {
    private static final SparseArray<Integer> f17839a = new SparseArray();

    static {
        f17839a.put(46001, Integer.valueOf(2));
        f17839a.put(46004, Integer.valueOf(2));
        f17839a.put(46002, Integer.valueOf(0));
        f17839a.put(46003, Integer.valueOf(1));
        f17839a.put(46011, Integer.valueOf(2));
        f17839a.put(46014, Integer.valueOf(2));
        f17839a.put(46012, Integer.valueOf(0));
        f17839a.put(46013, Integer.valueOf(1));
        f17839a.put(44006, Integer.valueOf(1));
        f17839a.put(44007, Integer.valueOf(0));
        f17839a.put(44005, Integer.valueOf(2));
        f17839a.put(44003, Integer.valueOf(2));
        f17839a.put(44101, Integer.valueOf(6));
        f17839a.put(44102, Integer.valueOf(6));
        f17839a.put(44103, Integer.valueOf(6));
        f17839a.put(44104, Integer.valueOf(6));
        f17839a.put(44105, Integer.valueOf(6));
        f17839a.put(44106, Integer.valueOf(6));
        f17839a.put(44107, Integer.valueOf(6));
        f17839a.put(44108, Integer.valueOf(6));
        f17839a.put(44201, Integer.valueOf(6));
        f17839a.put(44202, Integer.valueOf(6));
        f17839a.put(44203, Integer.valueOf(6));
        f17839a.put(44204, Integer.valueOf(6));
        f17839a.put(44205, Integer.valueOf(6));
        f17839a.put(44206, Integer.valueOf(6));
        f17839a.put(44207, Integer.valueOf(6));
        f17839a.put(44208, Integer.valueOf(6));
    }

    private static int m23492a(int i) {
        Integer num = (Integer) f17839a.get(i);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean m23493a(C4807a c4807a, C4807a c4807a2) {
        double d = c4807a.m23035d();
        double d2 = c4807a2.m23035d();
        switch (bc.m23492a(c4807a2.m23033c())) {
            case 0:
                if (d2 <= d) {
                    return false;
                }
                return true;
            case 1:
                if (d2 >= d) {
                    return false;
                }
                return true;
            case 2:
            case 4:
                return true;
            case 3:
                return false;
            case 5:
                return false;
            case 6:
                if (c4807a2.m23045j() <= c4807a.m23045j()) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }
}
