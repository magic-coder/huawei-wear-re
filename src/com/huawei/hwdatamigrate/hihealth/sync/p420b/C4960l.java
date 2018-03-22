package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hihealth.p394c.C4544f;
import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SportStatSwitchUtil */
public class C4960l {
    private C4953e f18050a = new C4953e();

    public List<C4807a> m23867a(int i, SportBasicInfo sportBasicInfo) {
        switch (i) {
            case 0:
                return this.f18050a.m23832b(sportBasicInfo);
            case 1:
                return this.f18050a.m23829a(sportBasicInfo);
            case 2:
                return m23866d(sportBasicInfo);
            case 3:
                return m23865c(sportBasicInfo);
            case 4:
                return m23864b(sportBasicInfo);
            case 5:
                return m23863a(sportBasicInfo);
            default:
                return null;
        }
    }

    private List<C4807a> m23863a(SportBasicInfo sportBasicInfo) {
        List<C4807a> arrayList = new ArrayList();
        int intValue = sportBasicInfo.getSteps().intValue();
        int intValue2 = sportBasicInfo.getDistance().intValue();
        int intValue3 = sportBasicInfo.getCalorie().intValue();
        int intValue4 = sportBasicInfo.getDuration().intValue();
        if (C4544f.m21787c(intValue)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(this.f18050a.m23828a(40011, (double) intValue, 1));
            }
            if (C4544f.m21789e(intValue2)) {
                arrayList.add(this.f18050a.m23828a(40031, (double) intValue2, 2));
            }
            if (C4544f.m21789e(intValue4)) {
                arrayList.add(this.f18050a.m23828a(40041, (double) (intValue4 * 60), 13));
            }
            if (!C4544f.m21789e(intValue3)) {
                return arrayList;
            }
            arrayList.add(this.f18050a.m23828a(40021, (double) intValue3, 3));
            return arrayList;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"getWalkStatTable STEP is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return null;
    }

    private List<C4807a> m23864b(SportBasicInfo sportBasicInfo) {
        List<C4807a> arrayList = new ArrayList();
        int intValue = sportBasicInfo.getSteps().intValue();
        int intValue2 = sportBasicInfo.getDistance().intValue();
        int intValue3 = sportBasicInfo.getCalorie().intValue();
        int intValue4 = sportBasicInfo.getDuration().intValue();
        if (C4544f.m21787c(intValue)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(this.f18050a.m23828a(40012, (double) intValue, 1));
            }
            if (C4544f.m21789e(intValue2)) {
                arrayList.add(this.f18050a.m23828a(40032, (double) intValue2, 2));
            }
            if (C4544f.m21789e(intValue4)) {
                arrayList.add(this.f18050a.m23828a(40042, (double) (intValue4 * 60), 13));
            }
            if (!C4544f.m21789e(intValue3)) {
                return arrayList;
            }
            arrayList.add(this.f18050a.m23828a(40022, (double) intValue3, 3));
            return arrayList;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"getRunStatTable STEP is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return null;
    }

    private List<C4807a> m23865c(SportBasicInfo sportBasicInfo) {
        List<C4807a> arrayList = new ArrayList();
        int intValue = sportBasicInfo.getDistance().intValue();
        int intValue2 = sportBasicInfo.getCalorie().intValue();
        int intValue3 = sportBasicInfo.getDuration().intValue();
        if (C4544f.m21788d(intValue2)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(this.f18050a.m23828a(40033, (double) intValue, 2));
            }
            if (C4544f.m21789e(intValue3)) {
                arrayList.add(this.f18050a.m23828a(40043, (double) (intValue3 * 60), 13));
            }
            if (!C4544f.m21789e(intValue2)) {
                return arrayList;
            }
            arrayList.add(this.f18050a.m23828a(40023, (double) intValue2, 3));
            return arrayList;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"getRideStatTable calorie is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return null;
    }

    private List<C4807a> m23866d(SportBasicInfo sportBasicInfo) {
        List<C4807a> arrayList = new ArrayList();
        int intValue = sportBasicInfo.getSteps().intValue();
        int intValue2 = sportBasicInfo.getDistance().intValue();
        int intValue3 = sportBasicInfo.getCalorie().intValue();
        int intValue4 = sportBasicInfo.getDuration().intValue();
        float floatValue = sportBasicInfo.getAltitude().floatValue() * 10.0f;
        if (C4544f.m21787c(intValue) && C4544f.m21785b((double) floatValue)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(this.f18050a.m23828a(40013, (double) intValue, 1));
            }
            if (C4544f.m21789e(intValue2)) {
                arrayList.add(this.f18050a.m23828a(40034, (double) intValue2, 2));
            }
            if (C4544f.m21789e(intValue4)) {
                arrayList.add(this.f18050a.m23828a(40044, (double) (intValue4 * 60), 13));
            }
            if (C4544f.m21789e(intValue3)) {
                arrayList.add(this.f18050a.m23828a(40024, (double) intValue3, 3));
            }
            if (!C4544f.m21783a(floatValue)) {
                return arrayList;
            }
            arrayList.add(this.f18050a.m23828a(40005, (double) floatValue, 4));
            return arrayList;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"getClimbStatTable STEP is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return null;
    }
}
