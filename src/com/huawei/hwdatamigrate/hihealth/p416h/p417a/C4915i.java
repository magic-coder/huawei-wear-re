package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p067c.C4862s;
import com.huawei.hwdatamigrate.hihealth.p067c.at;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4838c;

import java.util.Collections;
import java.util.List;

/* compiled from: HiDataSessionMerge */
public class C4915i {
    private C4862s f17972a;
    private at f17973b;

    public C4915i(Context context) {
        this.f17972a = C4862s.m23598a(context);
        this.f17973b = at.m23480a(context);
    }

    public boolean m23737a(HiHealthData hiHealthData, int i, List<Integer> list) {
        List<HiHealthData> a = this.f17973b.m23482a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), list);
        boolean z;
        if (a == null || a.isEmpty()) {
            if (this.f17972a.m23604a(hiHealthData, i, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        HiHealthData hiHealthData2;
        int i2;
        boolean c;
        for (HiHealthData hiHealthData22 : a) {
            int i3;
            if (hiHealthData22.getClientID() == i) {
                if (C4838c.m23332a(hiHealthData.getType(), hiHealthData22.getType()) <= 0) {
                    c.b("Debug_HiDataSessionMerge", new Object[]{"sessionDataMerge() insertData priority is lower oldData = ", hiHealthData22, ",sesseionData = ", hiHealthData});
                    return true;
                }
                c.c("Debug_HiDataSessionMerge", new Object[]{"sessionDataMerge() merged has happen  type from  ", Integer.valueOf(hiHealthData22.getType()), ",to ", Integer.valueOf(hiHealthData.getType()), ",time = ", C4540b.m21764l(hiHealthData.getStartTime())});
                hiHealthData22.setType(hiHealthData.getType());
                hiHealthData22.putInt("merged", 0);
                hiHealthData22.setSyncStatus(hiHealthData.getSyncStatus());
                i2 = 0;
                if (i2 != 0) {
                    hiHealthData.setClientID(i);
                    hiHealthData.putInt("merged", 0);
                    a.add(hiHealthData);
                }
                Collections.sort(a, new C4917k());
                hiHealthData22 = (HiHealthData) a.get(0);
                c = this.f17972a.m23608c(hiHealthData22, hiHealthData22.getClientID(), 0);
                for (i3 = 1; i3 < a.size(); i3++) {
                    hiHealthData22 = (HiHealthData) a.get(i3);
                    if (hiHealthData22.getInt("merged") == 0) {
                        c.b("Debug_HiDataSessionMerge", new Object[]{"sessionDataMerge() insertOrUpdateSessionData unmerge change = ", Boolean.valueOf(this.f17972a.m23608c(hiHealthData22, hiHealthData22.getClientID(), 1))});
                        if (!this.f17972a.m23608c(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                            c = false;
                        }
                    }
                }
                return c;
            }
        }
        z = true;
        if (i2 != 0) {
            hiHealthData.setClientID(i);
            hiHealthData.putInt("merged", 0);
            a.add(hiHealthData);
        }
        Collections.sort(a, new C4917k());
        hiHealthData22 = (HiHealthData) a.get(0);
        c = this.f17972a.m23608c(hiHealthData22, hiHealthData22.getClientID(), 0);
        for (i3 = 1; i3 < a.size(); i3++) {
            hiHealthData22 = (HiHealthData) a.get(i3);
            if (hiHealthData22.getInt("merged") == 0) {
                c.b("Debug_HiDataSessionMerge", new Object[]{"sessionDataMerge() insertOrUpdateSessionData unmerge change = ", Boolean.valueOf(this.f17972a.m23608c(hiHealthData22, hiHealthData22.getClientID(), 1))});
                if (!this.f17972a.m23608c(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                    c = false;
                }
            }
        }
        return c;
    }
}
