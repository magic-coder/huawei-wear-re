package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p067c.ah;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4838c;
import com.huawei.p190v.C2538c;

import java.util.Collections;
import java.util.List;

/* compiled from: HiHealthDataSessionMerge */
public class C4921o {
    private ah f17975a;

    public C4921o(Context context) {
        this.f17975a = ah.m23444a(context);
    }

    public boolean m23741a(HiHealthData hiHealthData, int i, List<Integer> list) {
        List<HiHealthData> a = this.f17975a.m23452a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), (List) list);
        boolean z;
        if (a == null || a.isEmpty()) {
            if (this.f17975a.m23450a(hiHealthData, i, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        HiHealthData hiHealthData2;
        int i2;
        boolean b;
        for (HiHealthData hiHealthData22 : a) {
            int i3;
            if (hiHealthData22.getClientID() == i) {
                if (C4838c.m23334b(hiHealthData.getType(), hiHealthData22.getType()) <= 0) {
                    C2538c.b("Debug_HiHealthDataSessionMerge", new Object[]{"healthSessionDataMerge() insertData priority is lower oldData = ", hiHealthData22, ",hiHealthData = ", hiHealthData});
                    return true;
                }
                C2538c.c("Debug_HiHealthDataSessionMerge", new Object[]{"healthSessionDataMerge() merged has happen  type from  ", Integer.valueOf(hiHealthData22.getType()), ",to ", Integer.valueOf(hiHealthData.getType()), ",time = ", C4540b.m21764l(hiHealthData.getStartTime())});
                hiHealthData22.setType(hiHealthData.getType());
                hiHealthData22.putInt("merged", 0);
                hiHealthData22.setSyncStatus(hiHealthData.getSyncStatus());
                i2 = 0;
                if (i2 != 0) {
                    hiHealthData.setClientID(i);
                    hiHealthData.putInt("merged", 0);
                    a.add(hiHealthData);
                }
                Collections.sort(a, new C4923q());
                hiHealthData22 = (HiHealthData) a.get(0);
                b = this.f17975a.m23454b(hiHealthData22, hiHealthData22.getClientID(), 0);
                for (i3 = 1; i3 < a.size(); i3++) {
                    hiHealthData22 = (HiHealthData) a.get(i3);
                    if (hiHealthData22.getInt("merged") == 0) {
                        C2538c.b("Debug_HiHealthDataSessionMerge", new Object[]{"healthSessionDataMerge() insertOrUpdateSessionData unmerge change = ", Boolean.valueOf(this.f17975a.m23454b(hiHealthData22, hiHealthData22.getClientID(), 1))});
                        if (!this.f17975a.m23454b(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                            b = false;
                        }
                    }
                }
                return b;
            }
        }
        z = true;
        if (i2 != 0) {
            hiHealthData.setClientID(i);
            hiHealthData.putInt("merged", 0);
            a.add(hiHealthData);
        }
        Collections.sort(a, new C4923q());
        hiHealthData22 = (HiHealthData) a.get(0);
        b = this.f17975a.m23454b(hiHealthData22, hiHealthData22.getClientID(), 0);
        for (i3 = 1; i3 < a.size(); i3++) {
            hiHealthData22 = (HiHealthData) a.get(i3);
            if (hiHealthData22.getInt("merged") == 0) {
                C2538c.b("Debug_HiHealthDataSessionMerge", new Object[]{"healthSessionDataMerge() insertOrUpdateSessionData unmerge change = ", Boolean.valueOf(this.f17975a.m23454b(hiHealthData22, hiHealthData22.getClientID(), 1))});
                if (!this.f17975a.m23454b(hiHealthData22, hiHealthData22.getClientID(), 1)) {
                    b = false;
                }
            }
        }
        return b;
    }
}
