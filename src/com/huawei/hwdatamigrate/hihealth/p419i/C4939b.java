package com.huawei.hwdatamigrate.hihealth.p419i;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.p396c.C4556c;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: HiStatUtil */
public class C4939b {
    public static List<HiHealthData> m23803a(List<HiHealthData> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList();
        List<HiHealthData> arrayList2 = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            int type = hiHealthData.getType();
            int userID = hiHealthData.getUserID();
            switch (C4940c.f18024a[C4556c.m21809b(type).ordinal()]) {
                case 1:
                    C4939b.m23804a(arrayList2, arrayList, hiHealthData, C4556c.m21811c(type), C4540b.m21754b(hiHealthData.getStartTime()), userID);
                    break;
                case 2:
                    if (type > 31000) {
                        break;
                    }
                    C4939b.m23804a(arrayList2, arrayList, hiHealthData, PayStatusCodes.PAY_STATE_PARAM_ERROR, C4540b.m21754b(hiHealthData.getStartTime()), userID);
                    break;
                case 3:
                    if (type != 10002) {
                        break;
                    }
                    C4939b.m23804a(arrayList2, arrayList, hiHealthData, 2018, C4540b.m21754b(hiHealthData.getStartTime()), userID);
                    break;
                case 4:
                    if (type > UtilLoggingLevel.WARNING_INT) {
                        if (type > 22099) {
                            if (type > 22199) {
                                break;
                            }
                            C4939b.m23804a(arrayList2, arrayList, hiHealthData, 22100, C4540b.m21761i(hiHealthData.getStartTime()), userID);
                            break;
                        }
                        C4939b.m23804a(arrayList2, arrayList, hiHealthData, UtilLoggingLevel.SEVERE_INT, C4540b.m21761i(hiHealthData.getStartTime()), userID);
                        break;
                    }
                    C4939b.m23804a(arrayList2, arrayList, hiHealthData, 20001, C4540b.m21754b(hiHealthData.getStartTime()), userID);
                    break;
                default:
                    break;
            }
        }
        return arrayList2;
    }

    private static void m23804a(List<HiHealthData> list, List<String> list2, HiHealthData hiHealthData, int i, long j, int i2) {
        if (i > 0 && i2 > 0) {
            String str = Integer.toString(i) + HwAccountConstants.SPLIIT_UNDERLINE + j + HwAccountConstants.SPLIIT_UNDERLINE + i2;
            if (!list2.contains(str)) {
                hiHealthData.setType(i);
                hiHealthData.setSequenceData(null);
                hiHealthData.setMetaData(null);
                list.add(hiHealthData);
                list2.add(str);
            }
        }
    }
}
