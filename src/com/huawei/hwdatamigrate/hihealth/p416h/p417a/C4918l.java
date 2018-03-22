package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p067c.ae;

import java.util.Collections;
import java.util.List;

/* compiled from: HiHealthDataPointMerge */
public class C4918l {
    private ae f17974a;

    public C4918l(Context context) {
        this.f17974a = ae.m23430a(context);
    }

    public boolean m23739a(HiHealthData hiHealthData, int i, List<Integer> list) {
        List<HiHealthData> a = this.f17974a.m23439a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), (List) list);
        if (a == null || a.isEmpty()) {
            boolean z;
            if (this.f17974a.m23437a(hiHealthData, i, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        int i2;
        for (HiHealthData hiHealthData2 : a) {
            if (hiHealthData2.getClientID() == i) {
                hiHealthData2.setValue(hiHealthData.getValue());
                hiHealthData2.putInt("merged", 0);
                hiHealthData2.setSyncStatus(hiHealthData.getSyncStatus());
                i2 = 0;
                break;
            }
        }
        i2 = 1;
        if (i2 != 0) {
            hiHealthData.setClientID(i);
            hiHealthData.putInt("merged", 0);
            a.add(hiHealthData);
        }
        Collections.sort(a, new C4920n());
        HiHealthData hiHealthData22 = (HiHealthData) a.get(0);
        boolean c = this.f17974a.m23443c(hiHealthData22, hiHealthData22.getClientID(), 0);
        for (int i3 = 1; i3 < a.size(); i3++) {
            hiHealthData22 = (HiHealthData) a.get(i3);
            if (hiHealthData22.getInt("merged") == 0) {
                c.b("Debug_HiHealthDataPointMerge", new Object[]{"pointDataMerge() insertOrUpdatePointData unmerge change = ", Boolean.valueOf(this.f17974a.m23443c(hiHealthData22, hiHealthData22.getClientID(), 1))});
                if (!this.f17974a.m23443c(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                    c = false;
                }
            }
        }
        return c;
    }
}
