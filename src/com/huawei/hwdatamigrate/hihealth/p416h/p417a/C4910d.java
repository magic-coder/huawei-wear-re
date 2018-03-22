package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p067c.C4856m;
import com.huawei.hwdatamigrate.hihealth.p067c.C4862s;
import com.huawei.hwdatamigrate.hihealth.p067c.bj;
import com.huawei.hwdatamigrate.hihealth.p068d.C4872c;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import java.util.Collections;
import java.util.List;

/* compiled from: HiDataPointMerge */
public class C4910d {
    private C4856m f17965a;
    private C4872c f17966b;
    private C4862s f17967c;
    private bj f17968d;

    public C4910d(Context context) {
        this.f17965a = C4856m.m23573a(context);
        this.f17966b = C4872c.m23634a(context);
        this.f17967c = C4862s.m23598a(context);
        this.f17968d = bj.m23507a(context);
    }

    public boolean m23733a(HiHealthData hiHealthData, int i, List<Integer> list) {
        if (m23732a(hiHealthData, i, 0)) {
            long startTime = hiHealthData.getStartTime() - 120000;
            long startTime2 = 120000 + hiHealthData.getStartTime();
            List a = this.f17968d.m23514a(startTime, startTime2, hiHealthData.getType(), list);
            if (a != null && a.size() >= 2) {
                if (m23730a(a) == i) {
                    a.remove(0);
                    this.f17965a.m23578a(startTime, startTime2, hiHealthData.getType(), a, 1);
                } else {
                    this.f17965a.m23577a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i, 1);
                }
            }
        }
        return true;
    }

    private int m23730a(List<Integer> list) {
        Collections.sort(list, new C4912f());
        return ((Integer) list.get(0)).intValue();
    }

    private boolean m23732a(HiHealthData hiHealthData, int i, int i2) {
        Double a = this.f17965a.m23580a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i);
        if (a == null) {
            return C4843h.m23395a(this.f17965a.m23579a(hiHealthData, i, i2));
        }
        if (a.doubleValue() >= hiHealthData.getValue()) {
            return false;
        }
        if (hiHealthData.getSyncStatus() == 0) {
            this.f17967c.m23606b(hiHealthData, i, 0);
        }
        return C4843h.m23395a((long) this.f17965a.m23581b(hiHealthData, i, i2));
    }
}
