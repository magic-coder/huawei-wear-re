package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import com.huawei.hihealth.HiHealthData;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: HiHealthDataPointMerge */
class C4920n implements Serializable, Comparator<HiHealthData> {
    private C4920n() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m23740a((HiHealthData) obj, (HiHealthData) obj2);
    }

    public int m23740a(HiHealthData hiHealthData, HiHealthData hiHealthData2) {
        return Double.compare(hiHealthData2.getValue(), hiHealthData.getValue());
    }
}
