package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.hwcloudmodel.model.unite.HealthDetail;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p068d.C4886r;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.d.m;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4970b;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4976k;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: HealthDataSwitch */
public class C4950b {
    private Context f18027a;
    private C4886r f18028b = C4886r.m23660a(this.f18027a);

    public C4950b(Context context) {
        this.f18027a = context;
    }

    public List<HealthDetail> m23821a(List<HiHealthData> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        switch (i2) {
            case 3:
            case 7:
            case 9:
                return m23819b(list, i, i2);
            case 5:
                return m23818a((List) list, i);
            default:
                return m23818a((List) list, i);
        }
    }

    public List<HiHealthData> m23820a(HealthDetail healthDetail, int i) throws h {
        int i2 = 0;
        List samplePoints = healthDetail.getSamplePoints();
        if (samplePoints == null || samplePoints.isEmpty()) {
            C2538c.d("Debug_HealthDataSwitch", new Object[]{"cloudToLocal samplePoints is null or empty"});
            return null;
        }
        g a = this.f18028b.m23663a(m.a(this.f18027a), i, healthDetail.getDeviceCode().longValue());
        if (a == null) {
            C2538c.e("Debug_HealthDataSwitch", new Object[]{"cloudToLocal hiHealthContext is null"});
            return null;
        }
        a.a(1);
        List<HiHealthData> arrayList = new ArrayList();
        String timeZone = healthDetail.getTimeZone();
        long size = (long) samplePoints.size();
        while (((long) i2) < size) {
            SamplePoint samplePoint = (SamplePoint) samplePoints.get(i2);
            if (samplePoint != null) {
                Collection<HiHealthData> b = C4970b.m23890b(samplePoint);
                if (!(b == null || b.isEmpty())) {
                    for (HiHealthData hiHealthData : b) {
                        hiHealthData.setTimeZone(timeZone);
                        g.a(hiHealthData, a);
                    }
                    arrayList.addAll(b);
                }
            }
            i2++;
        }
        return arrayList;
    }

    private List<HealthDetail> m23818a(List<HiHealthData> list, int i) {
        List<HealthDetail> arrayList = new ArrayList();
        g e = C4850g.m23559a(this.f18027a).m23567e(i);
        if (e == null) {
            return null;
        }
        for (HiHealthData hiHealthData : list) {
            if (hiHealthData != null) {
                HealthDetail a = C4970b.m23886a(hiHealthData, C4976k.m23905a(hiHealthData.getType()));
                if (a != null) {
                    a.setDeviceCode(Long.valueOf(e.g()));
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    private List<HealthDetail> m23819b(List<HiHealthData> list, int i, int i2) {
        List<HealthDetail> arrayList = new ArrayList();
        g e = C4850g.m23559a(this.f18027a).m23567e(i);
        if (e == null) {
            return null;
        }
        HealthDetail a = C4970b.m23887a((List) list, i2);
        a.setDeviceCode(Long.valueOf(e.g()));
        arrayList.add(a);
        return arrayList;
    }
}
