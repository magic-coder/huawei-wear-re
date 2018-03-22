package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.support.annotation.NonNull;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MHiDataSwitchUtil */
public class C4975j {
    public static int m23898a(String str, String str2) {
        int i = 2;
        if (str == null || str2 == null) {
            return 0;
        }
        if ("BASIC_STEP".equals(str)) {
            return i;
        }
        if ("BASIC_DISTANCE".equals(str)) {
            return 3;
        }
        if ("BASIC_CALORIE".equals(str)) {
            return 4;
        }
        if ("BASIC_ALTITUDE".equals(str) || "BASIC_FLOOR".equals(str)) {
            return 5;
        }
        if (!"BASIC_SESSION_TYPE".equals(str)) {
            return 0;
        }
        try {
            return (int) Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            Object[] objArr = new Object[i];
            objArr[0] = "switchKeyToSportDataType NumberFormatException value is ";
            objArr[1] = str2;
            C2538c.e("MHiDataSwitchUtil", objArr);
            return 0;
        }
    }

    public static SamplePoint m23900a(@NonNull HiHealthData hiHealthData, int i) {
        long startTime = hiHealthData.getStartTime();
        long endTime = hiHealthData.getEndTime();
        String a = C4975j.m23901a(hiHealthData.getType());
        if (a == null) {
            return null;
        }
        String str;
        if (i == 3 || i == 9) {
            str = "";
        } else {
            str = Double.toString(hiHealthData.getValue());
        }
        return C4976k.m23907a(a, str, startTime, endTime, null, Integer.toString(hiHealthData.getPointUnit()));
    }

    public static SamplePoint m23899a(@NonNull HiHealthData hiHealthData) {
        long startTime = hiHealthData.getStartTime();
        long endTime = hiHealthData.getEndTime();
        String a = C4975j.m23901a(hiHealthData.getType());
        if (a == null) {
            return null;
        }
        C4969a c4969a = new C4969a();
        c4969a.m23883a("BLOOD_PRESSURE_SYSTOLIC", hiHealthData.getDouble("bloodpressure_systolic"));
        c4969a.m23883a("BLOOD_PRESSURE_DIASTOLIC", hiHealthData.getDouble("bloodpressure_diastolic"));
        String a2 = c4969a.m23882a();
        if (a2 != null) {
            return C4976k.m23907a(a, a2, startTime, endTime, null, Integer.toString(hiHealthData.getPointUnit()));
        }
        return null;
    }

    public static SamplePoint m23903b(@NonNull HiHealthData hiHealthData) {
        long startTime = hiHealthData.getStartTime();
        long endTime = hiHealthData.getEndTime();
        String a = C4975j.m23901a(hiHealthData.getType());
        if (a == null) {
            return null;
        }
        String a2 = C4978n.m23913a(hiHealthData.getType());
        C4969a c4969a = new C4969a();
        c4969a.m23883a(a2, hiHealthData.getValue());
        a2 = c4969a.m23882a();
        if (a2 != null) {
            return C4976k.m23907a(a, a2, startTime, endTime, null, Integer.toString(hiHealthData.getPointUnit()));
        }
        return null;
    }

    public static String m23901a(int i) {
        switch (i) {
            case 2001:
                return "WEIGHT_BODYFAT";
            case 2002:
                return "DATA_POINT_DYNAMIC_HEARTRATE";
            case 2004:
                return "WEIGHT_BODYWEIGHT";
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION /*2006*/:
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION /*2007*/:
                return "BLOODPRESSURE";
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION /*2008*/:
            case 2009:
            case 2010:
            case TradeCode.ALIPAY_ONE_KEY_SIGN /*2011*/:
            case 2012:
            case 2013:
            case 2014:
            case 2015:
                return "BLOODGLUCOSE_BLOODSUGAR";
            case 2018:
                return "DATA_POINT_REST_HEARTRATE";
            case 22001:
                return "SLEEP_DEEP";
            case 22002:
                return "SLEEP_LIGHT";
            case 22003:
                return "SLEEP_AWAKE";
            case 22101:
                return "PROFESSIONAL_SLEEP_SHALLOW";
            case 22102:
                return "PROFESSIONAL_SLEEP_DREAM";
            case 22103:
                return "PROFESSIONAL_SLEEP_DEEP";
            case 22104:
                return "PROFESSIONAL_SLEEP_WAKE";
            case 22105:
                return "PROFESSIONAL_SLEEP_NOON";
            default:
                return null;
        }
    }

    public static List<HiHealthData> m23902a(@NonNull SamplePoint samplePoint) {
        List<HiHealthData> arrayList = new ArrayList();
        C4969a c4969a = new C4969a(samplePoint.getValue());
        double a = c4969a.m23881a("BLOOD_PRESSURE_DIASTOLIC");
        double a2 = c4969a.m23881a("BLOOD_PRESSURE_SYSTOLIC");
        if (a <= 0.0d || a2 <= 0.0d) {
            C2538c.d("MHiDataSwitchUtil", new Object[]{"samplePointToBloodPressure"});
            return null;
        }
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setTimeInterval(samplePoint.getStartTime().longValue(), samplePoint.getEndTime().longValue());
        hiHealthData.setType(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION);
        hiHealthData.setPointUnit(7);
        hiHealthData.setValue(a);
        arrayList.add(hiHealthData);
        hiHealthData = new HiHealthData();
        hiHealthData.setTimeInterval(samplePoint.getStartTime().longValue(), samplePoint.getEndTime().longValue());
        hiHealthData.setType(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION);
        hiHealthData.setPointUnit(7);
        hiHealthData.setValue(a2);
        arrayList.add(hiHealthData);
        return arrayList;
    }

    public static List<HiHealthData> m23904b(@NonNull SamplePoint samplePoint) {
        List<HiHealthData> arrayList = new ArrayList();
        Map b = new C4969a(samplePoint.getValue()).m23884b();
        if (b == null || b.isEmpty()) {
            C2538c.d("MHiDataSwitchUtil", new Object[]{"samplePointToBloodSugar error map is null or empty, samplePoint is ", samplePoint});
            return null;
        }
        for (Entry entry : b.entrySet()) {
            int a = C4976k.m23906a((String) entry.getKey());
            double doubleValue = ((Double) entry.getValue()).doubleValue();
            C2538c.b("MHiDataSwitchUtil", new Object[]{"samplePointToBloodSugar type = " + a + ", Value = " + doubleValue});
            if (doubleValue <= 0.0d) {
                C2538c.e("MHiDataSwitchUtil", new Object[]{"samplePointToBloodSugar error value !samplePoint is ", samplePoint});
            } else {
                HiHealthData hiHealthData = new HiHealthData();
                hiHealthData.setTimeInterval(samplePoint.getStartTime().longValue(), samplePoint.getEndTime().longValue());
                hiHealthData.setType(a);
                hiHealthData.setPointUnit(6);
                hiHealthData.setValue(doubleValue);
                arrayList.add(hiHealthData);
            }
        }
        return arrayList;
    }
}
