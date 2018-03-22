package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hihealth.p394c.C4544f;
import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MSportDataSwitchUtil */
public class C4952d {
    public C4952d(Context context) {
    }

    public HiHealthData m23825a(long j, long j2, int i, double d, int i2, @NonNull g gVar, String str, String str2) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setStartTime(j);
        hiHealthData.setEndTime(j2);
        hiHealthData.setType(i);
        hiHealthData.setValue(d);
        hiHealthData.setMetaData(str);
        hiHealthData.setTimeZone(str2);
        hiHealthData.setSyncStatus(i2);
        g.a(hiHealthData, gVar);
        return hiHealthData;
    }

    public List<HiHealthData> m23826a(SportBasicInfo sportBasicInfo, long j, long j2, int i, g gVar, String str, String str2, C4958j c4958j) {
        List<HiHealthData> arrayList = new ArrayList();
        if (i > 0) {
            arrayList.add(m23825a(j, j2, i, 0.0d, 1, gVar, str, str2));
        }
        int intValue = sportBasicInfo.getSteps().intValue();
        int intValue2 = sportBasicInfo.getCalorie().intValue();
        float intValue3 = (float) (sportBasicInfo.getFloor().intValue() * 30);
        float floatValue = sportBasicInfo.getAltitude().floatValue() * 10.0f;
        if (((double) (intValue3 - floatValue)) <= 1.0E-6d) {
            intValue3 = floatValue;
        }
        int intValue4 = sportBasicInfo.getDistance().intValue();
        if (C4544f.m21784a(intValue) && C4544f.m21786b(intValue2) && C4544f.m21785b((double) intValue3)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(m23825a(j, j2, 2, (double) intValue, 1, gVar, str, str2));
            }
            if (C4544f.m21789e(intValue2)) {
                arrayList.add(m23825a(j, j2, 4, (double) intValue2, 1, gVar, str, str2));
            }
            if (C4544f.m21789e(intValue4)) {
                arrayList.add(m23825a(j, j2, 3, (double) intValue4, 1, gVar, str, str2));
            }
            if (C4544f.m21783a(intValue3)) {
                arrayList.add(m23825a(j, j2, 5, (double) intValue3, 1, gVar, str, str2));
            }
            return arrayList;
        }
        C2538c.e("Debug_SportDataSwitchUtil", new Object[]{"getSportHealth STEP or CALORIE is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return arrayList;
    }
}
