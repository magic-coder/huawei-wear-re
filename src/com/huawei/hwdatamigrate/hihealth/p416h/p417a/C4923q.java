package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4838c;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: HiHealthDataSessionMerge */
class C4923q implements Serializable, Comparator<HiHealthData> {
    private C4923q() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m23742a((HiHealthData) obj, (HiHealthData) obj2);
    }

    public int m23742a(HiHealthData hiHealthData, HiHealthData hiHealthData2) {
        return C4838c.m23334b(hiHealthData2.getType(), hiHealthData.getType());
    }
}
