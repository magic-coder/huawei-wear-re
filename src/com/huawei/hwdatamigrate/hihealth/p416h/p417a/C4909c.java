package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4838c;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: HiDataCoreSessionMerge */
class C4909c implements Serializable, Comparator<HiHealthData> {
    private C4909c() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m23729a((HiHealthData) obj, (HiHealthData) obj2);
    }

    public int m23729a(HiHealthData hiHealthData, HiHealthData hiHealthData2) {
        return C4838c.m23335c(hiHealthData2.getType(), hiHealthData.getType());
    }
}
