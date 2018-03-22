package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.p190v.C2538c;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: HiDataPointMerge */
class C4912f implements Serializable, Comparator<Integer> {
    private static C4910d f17969a;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m23734a((Integer) obj, (Integer) obj2);
    }

    private C4912f(C4910d c4910d) {
        f17969a = c4910d;
    }

    public int m23734a(Integer num, Integer num2) {
        HiDeviceInfo a = f17969a.f17966b.m23635a(num.intValue());
        HiDeviceInfo a2 = f17969a.f17966b.m23635a(num2.intValue());
        if (a == null || a2 == null) {
            C2538c.d("Debug_HiDataPointMerge", new Object[]{"compare error input ! lhs is ", num, " rhs is ", num2});
            return 0;
        }
        int priority = a2.getPriority() - a.getPriority();
        return priority == 0 ? a2.getDeviceUniqueCode().compareTo(a.getDeviceUniqueCode()) : priority;
    }
}
