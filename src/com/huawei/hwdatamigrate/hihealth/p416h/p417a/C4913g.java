package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p067c.C4859p;
import com.huawei.p190v.C2538c;

import java.util.Collections;
import java.util.List;

/* compiled from: HiDataSequenceMerge */
public class C4913g {
    private C4859p f17970a;

    public C4913g(Context context) {
        this.f17970a = C4859p.m23582a(context);
    }

    public boolean m23735a(HiHealthData hiHealthData, int i, List<Integer> list) {
        long currentTimeMillis = System.currentTimeMillis();
        List<HiHealthData> a = this.f17970a.m23591a((List) list, hiHealthData.getStartTime(), hiHealthData.getType());
        boolean z;
        if (a == null || a.isEmpty()) {
            C2538c.b("Debug_HiDataSequenceMerge", new Object[]{"sequenceDataMerge insertSequenceData insert =  ", Long.valueOf(this.f17970a.m23588a(hiHealthData, i, 0))});
            if (this.f17970a.m23588a(hiHealthData, i, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        for (HiHealthData hiHealthData2 : a) {
            if (hiHealthData2.getClientID() == i) {
                hiHealthData2.putInt("merged", 0);
                hiHealthData2.setSequenceData(hiHealthData.getSequenceData());
                hiHealthData2.setMetaData(hiHealthData.getMetaData());
                hiHealthData2.setSyncStatus(hiHealthData.getSyncStatus());
                Object obj = null;
                break;
            }
        }
        int i2 = 1;
        if (obj != null) {
            hiHealthData.setClientID(i);
            hiHealthData.putInt("merged", 0);
            a.add(hiHealthData);
        }
        Collections.sort(a, new C4914h(hiHealthData.getType()));
        HiHealthData hiHealthData22 = (HiHealthData) a.get(0);
        if (hiHealthData22.getClientID() == i) {
            z = this.f17970a.m23597c(hiHealthData22, i, 0);
            C2538c.b("Debug_HiDataSequenceMerge", new Object[]{"sequenceDataMerge insertOrUpdateSequenceData maxData merge isSuccess =  ", Boolean.valueOf(z)});
        } else {
            C2538c.b("Debug_HiDataSequenceMerge", new Object[]{"sequenceDataMerge updateSequenceDataMerge maxData update =  ", Long.valueOf(this.f17970a.m23595b(hiHealthData22, hiHealthData22.getClientID(), 0))});
            z = this.f17970a.m23595b(hiHealthData22, hiHealthData22.getClientID(), 0) > 0;
        }
        int size = a.size();
        int i3 = 1;
        boolean z2 = z;
        while (i3 < size) {
            hiHealthData22 = (HiHealthData) a.get(i3);
            if (hiHealthData22.getInt("merged") == 0) {
                if (hiHealthData22.getClientID() == i) {
                    C2538c.b("Debug_HiDataSequenceMerge", new Object[]{"sequenceDataMerge insertOrUpdateSequenceData unmerge change ", Boolean.valueOf(this.f17970a.m23597c(hiHealthData22, i, 1))});
                    if (!this.f17970a.m23597c(hiHealthData22, i, 1)) {
                        z = false;
                        i3++;
                        z2 = z;
                    }
                } else {
                    C2538c.b("Debug_HiDataSequenceMerge", new Object[]{"sequenceDataMerge updateSequenceDataMerge unmerge ", Long.valueOf(this.f17970a.m23595b(hiHealthData22, hiHealthData22.getClientID(), 1))});
                    if (this.f17970a.m23595b(hiHealthData22, hiHealthData22.getClientID(), 1) <= 0) {
                        z = false;
                        i3++;
                        z2 = z;
                    }
                }
            }
            z = z2;
            i3++;
            z2 = z;
        }
        C2538c.c("Debug_HiDataSequenceMerge", new Object[]{"sequenceDataMerge use time ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return z2;
    }
}
