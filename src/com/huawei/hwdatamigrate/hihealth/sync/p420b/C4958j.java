package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hihealth.p394c.C4544f;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;
import com.huawei.hwcloudmodel.model.unite.SportDetail;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4847d;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p068d.C4886r;
import com.huawei.hwdatamigrate.hihealth.p419i.C4938a;
import com.huawei.hwdatamigrate.hihealth.p419i.C4941d;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.d.m;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4970b;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: SportDataSwitchUtil */
public class C4958j {
    private C4847d f18042a = C4847d.m23553a(this.f18046e);
    private C4850g f18043b = C4850g.m23559a(this.f18046e);
    private C4886r f18044c = C4886r.m23660a(this.f18046e);
    private C4952d f18045d;
    private Context f18046e;

    public C4958j(Context context) {
        this.f18046e = context.getApplicationContext();
        this.f18045d = new C4952d(context);
    }

    public List<SportDetail> m23852a(List<HiHealthData> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<SportDetail> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            SportDetail sportDetail = new SportDetail();
            sportDetail.setSportType(Integer.valueOf(C4941d.m23806b(hiHealthData.getType())));
            SportBasicInfo[] sportBasicInfoArr = new SportBasicInfo[1];
            SportBasicInfo sportBasicInfo = new SportBasicInfo();
            int i = hiHealthData.getInt("step");
            int i2 = hiHealthData.getInt("calorie");
            float f = hiHealthData.getFloat("altitude_offset");
            if (C4544f.m21784a(i) && C4544f.m21786b(i2) && C4544f.m21782a((double) f)) {
                sportBasicInfo.setSteps(Integer.valueOf(i));
                sportBasicInfo.setCalorie(Integer.valueOf(i2));
                sportBasicInfo.setAltitude(Float.valueOf(f / 10.0f));
                sportBasicInfo.setDistance(Integer.valueOf(hiHealthData.getInt("distance")));
                sportBasicInfo.setFloor(Integer.valueOf(0));
                sportBasicInfo.setDuration(Integer.valueOf(1));
                sportBasicInfoArr[0] = sportBasicInfo;
                sportDetail.setSportBasicInfos(sportBasicInfoArr);
                sportDetail.setStartTime(Long.valueOf(hiHealthData.getStartTime()));
                sportDetail.setEndTime(Long.valueOf(hiHealthData.getEndTime()));
                sportDetail.setTimeZone(hiHealthData.getTimeZone());
                sportDetail.setMetadata(hiHealthData.getMetaData());
                g e = this.f18043b.m23567e(hiHealthData.getClientID());
                if (e != null) {
                    sportDetail.setDeviceCode(Long.valueOf(e.g()));
                    HiAppInfo a = this.f18042a.m23558a(e.d());
                    if (a != null) {
                        sportDetail.setAppType(Integer.valueOf(C4938a.m23799a(a.getPackageName())));
                        arrayList.add(sportDetail);
                    }
                }
            } else {
                C2538c.e("Debug_SportDataSwitchUtil", new Object[]{"localSportToCloud data is out of rang data = ", hiHealthData});
            }
        }
        return arrayList;
    }

    public List<SportDetail> m23854b(List<HiHealthData> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<SportDetail> arrayList = new ArrayList();
        g e = this.f18043b.m23567e(((HiHealthData) list.get(0)).getClientID());
        if (e == null) {
            return null;
        }
        for (HiHealthData hiHealthData : list) {
            SportDetail sportDetail = new SportDetail();
            sportDetail.setSportType(Integer.valueOf(C4941d.m23806b(hiHealthData.getType())));
            SportBasicInfo a = C4970b.m23888a(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0f), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
            sportDetail.setStartTime(Long.valueOf(hiHealthData.getStartTime()));
            sportDetail.setEndTime(Long.valueOf(hiHealthData.getEndTime()));
            sportDetail.setTimeZone(hiHealthData.getTimeZone());
            sportDetail.setMetadata(hiHealthData.getMetaData());
            sportDetail.setDeviceCode(Long.valueOf(e.g()));
            HiAppInfo a2 = this.f18042a.m23558a(e.d());
            if (a2 != null) {
                sportDetail.setSportBasicInfos(new SportBasicInfo[]{a});
                sportDetail.setAppType(Integer.valueOf(C4938a.m23799a(a2.getPackageName())));
                arrayList.add(sportDetail);
            }
        }
        return arrayList;
    }

    public List<HiHealthData> m23851a(SportDetail sportDetail, int i) throws h {
        long e = C4540b.m21757e(sportDetail.getStartTime().longValue());
        long longValue = sportDetail.getEndTime().longValue();
        SportBasicInfo[] sportBasicInfos = sportDetail.getSportBasicInfos();
        long length = (long) sportBasicInfos.length;
        g a = this.f18044c.m23663a(sportDetail.getAppType().intValue(), i, sportDetail.getDeviceCode().longValue());
        if (a == null) {
            C2538c.e("Debug_SportDataSwitchUtil", new Object[]{"switchToHiHealthDatas hiHealthContext is null"});
            return null;
        }
        a.a(1);
        int a2 = C4941d.m23805a(sportDetail.getSportType().intValue());
        String timeZone = sportDetail.getTimeZone();
        String metadata = sportDetail.getMetadata();
        List<HiHealthData> arrayList = new ArrayList();
        if (a2 <= UtilLoggingLevel.SEVERE_INT || a2 >= 22099) {
            for (int i2 = 0; ((long) i2) < length; i2++) {
                long j = (((long) i2) * FileWatchdog.DEFAULT_DELAY) + e;
                Collection a3 = this.f18045d.m23826a(sportBasicInfos[i2], j, FileWatchdog.DEFAULT_DELAY + j, a2, a, metadata, timeZone, this);
                if (!a3.isEmpty()) {
                    arrayList.addAll(a3);
                }
            }
            return arrayList;
        }
        while (e < longValue) {
            arrayList.add(this.f18045d.m23825a(e, FileWatchdog.DEFAULT_DELAY + e, a2, 0.0d, 1, a, metadata, timeZone));
            e += FileWatchdog.DEFAULT_DELAY;
        }
        return arrayList;
    }

    public List<HiHealthData> m23853b(SportDetail sportDetail, int i) throws h {
        int i2 = 0;
        List samplePoints = sportDetail.getSamplePoints();
        if (samplePoints == null || samplePoints.isEmpty()) {
            C2538c.d("Debug_SportDataSwitchUtil", new Object[]{"cloudSportDataToHiHealthDatasBySamplePoint samplePoints is null or empty"});
            return null;
        }
        g a = this.f18044c.m23663a(m.a(this.f18046e), i, sportDetail.getDeviceCode().longValue());
        if (a == null) {
            C2538c.e("Debug_SportDataSwitchUtil", new Object[]{"switchToHiHealthDatas hiHealthContext is null"});
            return null;
        }
        a.a(1);
        List<HiHealthData> arrayList = new ArrayList();
        String timeZone = sportDetail.getTimeZone();
        String metadata = sportDetail.getMetadata();
        long size = (long) samplePoints.size();
        while (((long) i2) < size) {
            HiHealthData a2 = C4970b.m23885a((SamplePoint) samplePoints.get(i2));
            if (a2 != null) {
                a2.setTimeZone(timeZone);
                a2.setMetaData(metadata);
                g.a(a2, a);
                arrayList.add(a2);
            }
            i2++;
        }
        return arrayList;
    }
}
