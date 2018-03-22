package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.hwcloudmodel.model.unite.SportDetail;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4847d;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p419i.C4938a;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: SportDataSwitch */
public class C4957i {
    private C4847d f18038a = C4847d.m23553a(this.f18041d);
    private C4850g f18039b = C4850g.m23559a(this.f18041d);
    private C4958j f18040c = new C4958j(this.f18041d);
    private Context f18041d;

    public C4957i(Context context) {
        this.f18041d = context.getApplicationContext();
    }

    public List<HiHealthData> m23849a(List<SportDetail> list, int i, int i2) throws h {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        for (SportDetail sportDetail : list) {
            if (sportDetail != null) {
                Collection a = m23846a(sportDetail, i, i2);
                if (!(a == null || a.isEmpty())) {
                    arrayList.addAll(a);
                }
            }
        }
        return arrayList;
    }

    private List<HiHealthData> m23846a(SportDetail sportDetail, int i, int i2) throws h {
        switch (i2) {
            case 2:
                return this.f18040c.m23851a(sportDetail, i);
            case 3:
                return this.f18040c.m23853b(sportDetail, i);
            default:
                C2538c.d("Debug_SportDataSwtich", new Object[]{"cloudSportDatasToHiHealthDatas no such hiSyncModel"});
                return null;
        }
    }

    public List<SportDetail> m23850b(List<HiHealthData> list, int i, int i2) {
        switch (i2) {
            case 2:
                return m23848a(list, i);
            case 3:
                return m23847a((List) list);
            default:
                C2538c.d("Debug_SportDataSwtich", new Object[]{"localDataToCloud no such hiSyncModel"});
                return null;
        }
    }

    private List<SportDetail> m23847a(List<HiHealthData> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<SportDetail> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            if (hiHealthData != null) {
                List a = m23845a(hiHealthData);
                SportDetail sportDetail = new SportDetail();
                sportDetail.setSamplePoints(a);
                sportDetail.setStartTime(Long.valueOf(hiHealthData.getStartTime()));
                sportDetail.setEndTime(Long.valueOf(hiHealthData.getEndTime()));
                sportDetail.setTimeZone(hiHealthData.getTimeZone());
                sportDetail.setMetadata(hiHealthData.getMetaData());
                g e = this.f18039b.m23567e(hiHealthData.getClientID());
                if (e != null) {
                    sportDetail.setDeviceCode(Long.valueOf(e.g()));
                    HiAppInfo a2 = this.f18038a.m23558a(e.d());
                    if (a2 != null) {
                        sportDetail.setAppType(Integer.valueOf(C4938a.m23799a(a2.getPackageName())));
                        arrayList.add(sportDetail);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<SamplePoint> m23845a(HiHealthData hiHealthData) {
        List<SamplePoint> arrayList = new ArrayList();
        long startTime = hiHealthData.getStartTime();
        long endTime = hiHealthData.getEndTime();
        arrayList.add(m23844a(startTime, endTime, "BASIC_STEP", hiHealthData.getDouble("step"), 1));
        arrayList.add(m23844a(startTime, endTime, "BASIC_DISTANCE", hiHealthData.getDouble("calorie"), 3));
        arrayList.add(m23844a(startTime, endTime, "BASIC_CALORIE", hiHealthData.getDouble("distance"), 2));
        arrayList.add(m23844a(startTime, endTime, "BASIC_ALTITUDE", hiHealthData.getDouble("altitude_offset"), 4));
        arrayList.add(m23844a(startTime, endTime, "BASIC_SESSION_TYPE", (double) hiHealthData.getType(), 0));
        return arrayList;
    }

    private SamplePoint m23844a(long j, long j2, String str, double d, int i) {
        SamplePoint samplePoint = new SamplePoint();
        samplePoint.setStartTime(Long.valueOf(j));
        samplePoint.setEndTime(Long.valueOf(j2));
        samplePoint.setUnit(Integer.toString(i));
        samplePoint.setValue(Double.toString(d));
        samplePoint.setKey(str);
        return samplePoint;
    }

    private List<SportDetail> m23848a(List<HiHealthData> list, int i) {
        switch (i) {
            case 1:
                return this.f18040c.m23852a(list);
            case 3:
                return this.f18040c.m23854b(list);
            default:
                return null;
        }
    }
}
