package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.hwcloudmodel.model.unite.HealthDetail;
import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: HiDataSwitchUtil */
public class C4970b {
    public static HiHealthData m23885a(@NonNull SamplePoint samplePoint) {
        HiHealthData hiHealthData = new HiHealthData();
        int a = C4975j.m23898a(samplePoint.getKey(), samplePoint.getValue());
        if (a <= 0) {
            C2538c.d("HiDataSwitchUtil", new Object[]{"switchSportSamplePoint so such type"});
            return null;
        }
        try {
            hiHealthData.setValue(Double.parseDouble(samplePoint.getValue()));
            hiHealthData.setType(a);
            hiHealthData.setTimeInterval(samplePoint.getStartTime().longValue(), samplePoint.getEndTime().longValue());
            hiHealthData.setPointUnit(0);
            C2538c.b("HiDataSwitchUtil", new Object[]{"switchSportSamplePoint hiHealthData is ", hiHealthData});
            return hiHealthData;
        } catch (NumberFormatException e) {
            C2538c.e("HiDataSwitchUtil", new Object[]{"switchSportSamplePoint NumberFormatException value is ", samplePoint.getValue()});
            return null;
        }
    }

    public static List<HiHealthData> m23890b(@NonNull SamplePoint samplePoint) {
        String key = samplePoint.getKey();
        if (key == null) {
            return null;
        }
        if ("WEIGHT_BODYWEIGHT".equals(key) || "WEIGHT_BODYFAT".equals(key) || "DATA_POINT_DYNAMIC_HEARTRATE".equals(key) || "DATA_POINT_REST_HEARTRATE".equals(key)) {
            return C4976k.m23908a(samplePoint);
        }
        if ("SLEEP_DEEP".equals(key) || "SLEEP_LIGHT".equals(key) || "SLEEP_AWAKE".equals(key) || "PROFESSIONAL_SLEEP_SHALLOW".equals(key) || "PROFESSIONAL_SLEEP_DREAM".equals(key) || "PROFESSIONAL_SLEEP_DEEP".equals(key) || "PROFESSIONAL_SLEEP_WAKE".equals(key) || "PROFESSIONAL_SLEEP_NOON".equals(key)) {
            return C4978n.m23914a(samplePoint);
        }
        if ("BLOODPRESSURE".equals(key)) {
            return C4975j.m23902a(samplePoint);
        }
        if ("BLOODGLUCOSE_BLOODSUGAR".equals(key)) {
            return C4975j.m23904b(samplePoint);
        }
        return null;
    }

    public static HealthDetail m23886a(@NonNull HiHealthData hiHealthData, int i) {
        if (i <= -1) {
            return null;
        }
        Object b;
        HealthDetail healthDetail = new HealthDetail();
        List arrayList = new ArrayList();
        switch (i) {
            case 4:
                b = C4975j.m23903b(hiHealthData);
                break;
            case 5:
                b = C4975j.m23899a(hiHealthData);
                break;
            default:
                b = C4975j.m23900a(hiHealthData, i);
                break;
        }
        if (b == null) {
            return null;
        }
        arrayList.add(b);
        healthDetail.setStartTime(Long.valueOf(hiHealthData.getStartTime()));
        healthDetail.setEndTime(Long.valueOf(hiHealthData.getEndTime()));
        healthDetail.setTimeZone(hiHealthData.getTimeZone());
        healthDetail.setType(Integer.valueOf(i));
        healthDetail.setSamplePoints(arrayList);
        return healthDetail;
    }

    public static HealthDetail m23887a(@NonNull List<HiHealthData> list, int i) {
        HealthDetail healthDetail = new HealthDetail();
        List arrayList = new ArrayList();
        healthDetail.setType(Integer.valueOf(i));
        healthDetail.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        long j = Long.MIN_VALUE;
        long j2 = Long.MAX_VALUE;
        for (HiHealthData hiHealthData : list) {
            long startTime = hiHealthData.getStartTime();
            long endTime = hiHealthData.getEndTime();
            SamplePoint a = C4975j.m23900a(hiHealthData, i);
            if (a != null) {
                long j3;
                arrayList.add(a);
                if (endTime >= j) {
                    j = endTime;
                }
                if (startTime <= j2) {
                    j3 = startTime;
                } else {
                    j3 = j2;
                }
                j2 = j3;
            }
        }
        C2538c.c("HiDataSwitchUtil", new Object[]{"integrateData minTempTime is ", Long.valueOf(j2), " maxTempTime is ", Long.valueOf(j)});
        healthDetail.setStartTime(Long.valueOf(j2));
        healthDetail.setEndTime(Long.valueOf(j));
        healthDetail.setSamplePoints(arrayList);
        return healthDetail;
    }

    public static SportBasicInfo m23888a(Integer num, Integer num2, Integer num3, Float f, Integer num4, Integer num5, Integer num6) {
        SportBasicInfo sportBasicInfo = new SportBasicInfo();
        sportBasicInfo.setAltitude(f);
        sportBasicInfo.setCalorie(num3);
        sportBasicInfo.setDistance(num2);
        sportBasicInfo.setDuration(num5);
        sportBasicInfo.setFloor(num4);
        sportBasicInfo.setSteps(num);
        sportBasicInfo.setCount(num6);
        return sportBasicInfo;
    }

    public static C4807a m23889a(int i, double d, int i2) {
        C4807a c4807a = new C4807a();
        c4807a.m23026a(d);
        c4807a.m23034c(i);
        c4807a.m23040f(i2);
        return c4807a;
    }
}
