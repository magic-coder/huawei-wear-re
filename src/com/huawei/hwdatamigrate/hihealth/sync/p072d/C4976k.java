package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.support.annotation.NonNull;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MHiDataUtil */
public class C4976k {
    public static SamplePoint m23907a(String str, String str2, long j, long j2, String str3, String str4) {
        SamplePoint samplePoint = new SamplePoint();
        samplePoint.setKey(str);
        samplePoint.setValue(str2);
        samplePoint.setStartTime(Long.valueOf(j));
        samplePoint.setEndTime(Long.valueOf(j2));
        samplePoint.setUnit(str4);
        return samplePoint;
    }

    public static int m23906a(String str) {
        if ("BLOOD_SUGAR_BEFORE_DAWN".equals(str)) {
            return 2015;
        }
        if ("BLOOD_SUGAR_BF_BEFORE".equals(str)) {
            return IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION;
        }
        if ("BLOOD_SUGAR_BF_AFTER".equals(str)) {
            return 2009;
        }
        if ("BLOOD_SUGAR_LC_BEFORE".equals(str)) {
            return 2010;
        }
        if ("BLOOD_SUGAR_LC_AFTER".equals(str)) {
            return TradeCode.ALIPAY_ONE_KEY_SIGN;
        }
        if ("BLOOD_SUGAR_DN_BEFORE".equals(str)) {
            return 2012;
        }
        if ("BLOOD_SUGAR_DN_AFTER".equals(str)) {
            return 2013;
        }
        if ("BLOOD_SUGAR_SL_BEFORE".equals(str)) {
            return 2014;
        }
        return 2015;
    }

    public static List<HiHealthData> m23908a(@NonNull SamplePoint samplePoint) {
        List<HiHealthData> arrayList = new ArrayList();
        HiHealthData hiHealthData = new HiHealthData();
        int a = C4978n.m23912a(samplePoint.getKey(), samplePoint.getValue());
        if (a <= 0) {
            C2538c.d("MHiDataUtil", new Object[]{"switchHealthSamplePoint so such type"});
            return null;
        }
        hiHealthData.setType(a);
        hiHealthData.setTimeInterval(samplePoint.getStartTime().longValue(), samplePoint.getEndTime().longValue());
        hiHealthData.setPointUnit(0);
        try {
            if (Double.parseDouble(samplePoint.getValue()) <= 1.401298464324817E-45d) {
                C2538c.e("MHiDataUtil", new Object[]{"switchHealthSamplePoint NumberFormatException value is ", Double.valueOf(Double.parseDouble(samplePoint.getValue()))});
                return null;
            }
            hiHealthData.setValue(Double.parseDouble(samplePoint.getValue()));
            arrayList.add(hiHealthData);
            return arrayList;
        } catch (NumberFormatException e) {
            C2538c.e("MHiDataUtil", new Object[]{"switchHealthSamplePoint NumberFormatException value is ", samplePoint.getValue()});
            return null;
        }
    }

    public static int m23905a(int i) {
        switch (i) {
            case 2001:
                return 8;
            case 2002:
            case 2018:
                return 7;
            case 2004:
                return 6;
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION /*2006*/:
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION /*2007*/:
                return 5;
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION /*2008*/:
            case 2009:
            case 2010:
            case TradeCode.ALIPAY_ONE_KEY_SIGN /*2011*/:
            case 2012:
            case 2013:
            case 2014:
            case 2015:
                return 4;
            case 22001:
            case 22002:
            case 22003:
                return 3;
            default:
                return -1;
        }
    }
}
