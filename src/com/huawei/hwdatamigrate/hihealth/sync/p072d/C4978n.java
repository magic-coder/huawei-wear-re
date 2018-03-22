package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.support.annotation.NonNull;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: THiDataUtil */
public class C4978n {
    public static String m23913a(int i) {
        switch (i) {
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION /*2008*/:
                return "BLOOD_SUGAR_BF_BEFORE";
            case 2009:
                return "BLOOD_SUGAR_BF_AFTER";
            case 2010:
                return "BLOOD_SUGAR_LC_BEFORE";
            case TradeCode.ALIPAY_ONE_KEY_SIGN /*2011*/:
                return "BLOOD_SUGAR_LC_AFTER";
            case 2012:
                return "BLOOD_SUGAR_DN_BEFORE";
            case 2013:
                return "BLOOD_SUGAR_DN_AFTER";
            case 2014:
                return "BLOOD_SUGAR_SL_BEFORE";
            case 2015:
                return "BLOOD_SUGAR_BEFORE_DAWN";
            default:
                return "BLOOD_SUGAR_BEFORE_DAWN";
        }
    }

    public static List<HiHealthData> m23914a(@NonNull SamplePoint samplePoint) {
        List<HiHealthData> arrayList = new ArrayList();
        int a = C4978n.m23912a(samplePoint.getKey(), samplePoint.getValue());
        if (a <= 0) {
            C2538c.d("THiDataUtil", new Object[]{"samplePointToSleep so such type"});
            return null;
        }
        long e = C4540b.m21757e(samplePoint.getStartTime().longValue());
        C2538c.b("THiDataUtil", new Object[]{"samplePointToSleep startTime is ", Long.valueOf(e), " endTime is ", Long.valueOf(C4540b.m21757e(samplePoint.getEndTime().longValue()))});
        while (e < r4) {
            HiHealthData hiHealthData = new HiHealthData();
            hiHealthData.setType(a);
            hiHealthData.setPointUnit(15);
            hiHealthData.setTimeInterval(e, e + FileWatchdog.DEFAULT_DELAY);
            e += FileWatchdog.DEFAULT_DELAY;
            arrayList.add(hiHealthData);
        }
        return arrayList;
    }

    public static int m23912a(String str, String str2) {
        if (str == null || str2 == null || "BLOODGLUCOSE_BLOODSUGAR".equals(str)) {
            return 0;
        }
        if ("WEIGHT_BODYWEIGHT".equals(str)) {
            return 2004;
        }
        if ("WEIGHT_BODYFAT".equals(str)) {
            return 2001;
        }
        if ("DATA_POINT_DYNAMIC_HEARTRATE".equals(str)) {
            return 2002;
        }
        if ("DATA_POINT_REST_HEARTRATE".equals(str)) {
            return 2018;
        }
        if ("SLEEP_DEEP".equals(str)) {
            return 22001;
        }
        if ("SLEEP_LIGHT".equals(str)) {
            return 22002;
        }
        if ("SLEEP_AWAKE".equals(str)) {
            return 22003;
        }
        if ("PROFESSIONAL_SLEEP_SHALLOW".equals(str)) {
            return 22101;
        }
        if ("PROFESSIONAL_SLEEP_DREAM".equals(str)) {
            return 22102;
        }
        if ("PROFESSIONAL_SLEEP_DEEP".equals(str)) {
            return 22103;
        }
        if ("PROFESSIONAL_SLEEP_WAKE".equals(str)) {
            return 22104;
        }
        if ("PROFESSIONAL_SLEEP_NOON".equals(str)) {
            return 22105;
        }
        return 0;
    }
}
