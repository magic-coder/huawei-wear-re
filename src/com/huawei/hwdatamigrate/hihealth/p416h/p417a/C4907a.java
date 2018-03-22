package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p067c.C4853j;
import com.huawei.hwdatamigrate.hihealth.p067c.an;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4838c;
import com.huawei.p190v.C2538c;

import java.util.Collections;
import java.util.List;

/* compiled from: HiDataCoreSessionMerge */
public class C4907a {
    private C4853j f17963a;
    private an f17964b;

    public C4907a(Context context) {
        this.f17963a = C4853j.m23568a(context);
        this.f17964b = an.m23465a(context);
    }

    public boolean m23728a(HiHealthData hiHealthData, int i, List<Integer> list) {
        List<HiHealthData> a = this.f17963a.m23571a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), (List) list);
        boolean z;
        if (a == null || a.isEmpty()) {
            if (this.f17963a.m23570a(hiHealthData, i, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        HiHealthData hiHealthData2;
        boolean b;
        int i2;
        for (HiHealthData hiHealthData22 : a) {
            if (hiHealthData22.getClientID() == i) {
                if (C4838c.m23335c(hiHealthData.getType(), hiHealthData22.getType()) <= 0) {
                    C2538c.b("Debug_HiDataCoreSessionMerge", new Object[]{"healthSessionDataMerge().. insertData priority is lower oldData = ", hiHealthData22, ",sesseionData = ", hiHealthData});
                    return true;
                }
                C2538c.c("Debug_HiDataCoreSessionMerge", new Object[]{"healthSessionDataMerge() .. merged has happen  type from  ", Integer.valueOf(hiHealthData22.getType()), ",to ", Integer.valueOf(hiHealthData.getType()), ",time = ", C4540b.m21764l(hiHealthData.getStartTime())});
                hiHealthData22.setType(hiHealthData.getType());
                hiHealthData22.putInt("merged", 0);
                hiHealthData22.setSyncStatus(hiHealthData.getSyncStatus());
                z = false;
                C2538c.c("Debug_HiDataCoreSessionMerge", new Object[]{"isNew:" + z});
                if (z) {
                    hiHealthData.setClientID(i);
                    hiHealthData.putInt("merged", 0);
                    a.add(hiHealthData);
                }
                Collections.sort(a, new C4909c());
                hiHealthData22 = (HiHealthData) a.get(0);
                b = this.f17964b.m23475b(hiHealthData22, hiHealthData22.getClientID(), 0);
                for (i2 = 1; i2 < a.size(); i2++) {
                    hiHealthData22 = (HiHealthData) a.get(i2);
                    if (hiHealthData22.getInt("merged") == 0) {
                        C2538c.b("Debug_HiDataCoreSessionMerge", new Object[]{"healthSessionDataMerge() insertOrUpdateSessionData unmerge change = ", Boolean.valueOf(this.f17964b.m23475b(hiHealthData22, hiHealthData22.getClientID(), 1))});
                        if (!this.f17964b.m23475b(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                            b = false;
                        }
                    }
                }
                return b;
            }
        }
        z = true;
        C2538c.c("Debug_HiDataCoreSessionMerge", new Object[]{"isNew:" + z});
        if (z) {
            hiHealthData.setClientID(i);
            hiHealthData.putInt("merged", 0);
            a.add(hiHealthData);
        }
        Collections.sort(a, new C4909c());
        hiHealthData22 = (HiHealthData) a.get(0);
        b = this.f17964b.m23475b(hiHealthData22, hiHealthData22.getClientID(), 0);
        for (i2 = 1; i2 < a.size(); i2++) {
            hiHealthData22 = (HiHealthData) a.get(i2);
            if (hiHealthData22.getInt("merged") == 0) {
                C2538c.b("Debug_HiDataCoreSessionMerge", new Object[]{"healthSessionDataMerge() insertOrUpdateSessionData unmerge change = ", Boolean.valueOf(this.f17964b.m23475b(hiHealthData22, hiHealthData22.getClientID(), 1))});
                if (!this.f17964b.m23475b(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                    b = false;
                }
            }
        }
        return b;
    }
}
