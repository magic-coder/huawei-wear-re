package com.huawei.hwfitnessmgr.deviceadapter;

import android.support.v4.media.TransportMediator;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5025h;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: FitnessPackageReverseData */
public class C5016c {
    public static byte[] m24141a(List<C5025h> list) {
        String str = "";
        if (list == null || list.size() == 0) {
            return C0973a.b(str);
        }
        String str2 = str;
        for (C5025h c5025h : list) {
            String str3;
            String str4 = "";
            String str5 = "";
            if (c5025h.m24228d() != null && c5025h.m24228d().size() > 0) {
                str3 = str4;
                for (FitnessTotalData fitnessTotalData : c5025h.m24228d()) {
                    String str6 = "";
                    if (fitnessTotalData.getSteps() > 0) {
                        str6 = str6 + C0973a.a(9) + C0973a.a(4) + C0973a.a((long) fitnessTotalData.getSteps());
                    }
                    if (fitnessTotalData.getCalorie() > 0) {
                        str6 = str6 + C0973a.a(10) + C0973a.a(4) + C0973a.a((long) fitnessTotalData.getCalorie());
                    }
                    if (fitnessTotalData.getDistance() > 0) {
                        str6 = str6 + C0973a.a(11) + C0973a.a(4) + C0973a.a((long) fitnessTotalData.getDistance());
                    }
                    if (fitnessTotalData.getDuration() > 0) {
                        str6 = str6 + C0973a.a(12) + C0973a.a(4) + C0973a.a((long) (fitnessTotalData.getDuration() / 60));
                    }
                    if (fitnessTotalData.getLowIntensiveTime() > 0) {
                        str6 = str6 + C0973a.a(13) + C0973a.a(2) + C0973a.b(fitnessTotalData.getLowIntensiveTime());
                    }
                    if (fitnessTotalData.getMidIntensiveTime() > 0) {
                        str6 = str6 + C0973a.a(14) + C0973a.a(2) + C0973a.b(fitnessTotalData.getMidIntensiveTime());
                    }
                    if (fitnessTotalData.getHighIntensiveTime() > 0) {
                        str6 = str6 + C0973a.a(15) + C0973a.a(2) + C0973a.b(fitnessTotalData.getHighIntensiveTime());
                    }
                    if (fitnessTotalData.getStandTimes() > 0) {
                        str6 = str6 + C0973a.a(16) + C0973a.a(2) + C0973a.b(fitnessTotalData.getStandTimes());
                    }
                    if (str6.length() > 0) {
                        str4 = C0973a.a(8) + C0973a.a(1) + C0973a.a(fitnessTotalData.getSportType()) + str6;
                        str4 = str3 + C0973a.a(135) + C0973a.a(str4.length() / 2) + str4;
                    } else {
                        str4 = str3;
                    }
                    str3 = str4;
                }
                str4 = str3;
            }
            str3 = "";
            if (str4.length() > 0) {
                str4 = C0973a.a(134) + C0973a.e(str4.length() / 2) + str4;
            }
            str = (((str5 + C0973a.a(3) + C0973a.a(4) + C0973a.a((long) c5025h.m24222a())) + C0973a.a(4) + C0973a.a(4) + C0973a.a((long) c5025h.m24224b())) + C0973a.a(5) + C0973a.a(4) + C0973a.a((long) c5025h.m24226c())) + str4;
            str2 = str2 + C0973a.a(TransportMediator.KEYCODE_MEDIA_RECORD) + C0973a.e(str.length() / 2) + str;
        }
        C2538c.c("FitnessPackageReverseData", new Object[]{"getReverseDataSync cmd ", C0973a.a(129) + C0973a.e(str2.length() / 2) + str2});
        return C0973a.b(C0973a.a(129) + C0973a.e(str2.length() / 2) + str2);
    }
}
