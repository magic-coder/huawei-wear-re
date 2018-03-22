package com.huawei.hwdatamigrate.hihealth.p416h.p418b;

import android.content.Context;
import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwdatamigrate.hihealth.a.a;
import com.huawei.hwdatamigrate.hihealth.p067c.bj;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HiSportStat */
public class C4930e extends C4925f {
    private bj f18011c = bj.m23507a(this.b);
    private C4883o f18012d = C4883o.m23650a(this.b);
    private C4880l f18013e = C4880l.m23643a(this.b);

    public C4930e(Context context) {
        super(context);
    }

    public boolean m23791a(HiHealthData hiHealthData) {
        long currentTimeMillis = System.currentTimeMillis();
        int userID = hiHealthData.getUserID();
        long b = C4540b.m21754b(hiHealthData.getStartTime());
        C2538c.c("Debug_HiSportStat", new Object[]{"stat() sportData = ", Long.valueOf(hiHealthData.getDay()), ",startTime = ", Long.valueOf(b), ",endTime = ", Long.valueOf(C4540b.m21756d(hiHealthData.getStartTime()))});
        int[] iArr = new int[]{2, 3, 4, 5};
        String[] strArr = new String[]{"step", "distance", "calorie", "altitude_offset"};
        HiAggregateOption hiAggregateOption = new HiAggregateOption();
        hiAggregateOption.setStartTime(b);
        hiAggregateOption.setEndTime(r6);
        hiAggregateOption.setType(iArr);
        hiAggregateOption.setConstantsKey(strArr);
        hiAggregateOption.setGroupUnitType(3);
        hiAggregateOption.setAggregateType(1);
        m23782a(hiAggregateOption, userID, strArr, b, hiHealthData.getSyncStatus());
        if (!(hiHealthData.getDay() != ((long) C4540b.m21750a(System.currentTimeMillis())) || hiHealthData.getDeviceUUID() == null || C4539a.m21747a(this.b).equals(hiHealthData.getDeviceUUID()))) {
            C2538c.c("Debug_HiSportStat", new Object[]{"stat() send  stepSum change broadcast"});
            a.e(this.b);
            a.a(this.b, 1);
        }
        C2538c.b("Debug_HiSportStat", new Object[]{"stat() totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return true;
    }

    private boolean m23782a(HiAggregateOption hiAggregateOption, int i, String[] strArr, long j, int i2) {
        int b = this.f18012d.m23656b(0, i, 0);
        if (b <= 0) {
            return false;
        }
        List a = this.f18013e.m23646a(i);
        if (!C4539a.m21749a(a)) {
            m23783a(hiAggregateOption, a, strArr, j, i, b, i2);
        }
        return true;
    }

    private boolean m23783a(HiAggregateOption hiAggregateOption, List<Integer> list, String[] strArr, long j, int i, int i2, int i3) {
        hiAggregateOption.setAlignType(20001);
        List b = this.f18011c.m23518b((List) list, hiAggregateOption);
        hiAggregateOption.setGroupUnitType(8);
        m23785a(b, this.f18011c.m23520c(list, hiAggregateOption), strArr, j, i, i2, i3);
        hiAggregateOption.setGroupUnitType(3);
        hiAggregateOption.setAlignType(20002);
        m23786a(this.f18011c.m23516a((List) list, hiAggregateOption), strArr, j, i, i2, i3);
        hiAggregateOption.setAlignType(20003);
        m23787b(this.f18011c.m23516a((List) list, hiAggregateOption), strArr, j, i, i2, i3);
        hiAggregateOption.setAlignType(20005);
        m23788c(this.f18011c.m23516a((List) list, hiAggregateOption), strArr, j, i, i2, i3);
        hiAggregateOption.setAlignType(20004);
        m23789d(this.f18011c.m23516a((List) list, hiAggregateOption), strArr, j, i, i2, i3);
        hiAggregateOption.setAlignType(20007);
        m23790e(this.f18011c.m23516a((List) list, hiAggregateOption), strArr, j, i, i2, i3);
        HiAggregateOption hiAggregateOption2 = new HiAggregateOption();
        int[] iArr = new int[]{20001};
        String[] strArr2 = new String[]{"duration"};
        hiAggregateOption2.setStartTime(hiAggregateOption.getStartTime());
        hiAggregateOption2.setEndTime(hiAggregateOption.getEndTime());
        hiAggregateOption2.setType(iArr);
        hiAggregateOption2.setConstantsKey(strArr2);
        hiAggregateOption2.setGroupUnitType(3);
        hiAggregateOption2.setAggregateType(1);
        m23784a(this.f18011c.m23518b((List) list, hiAggregateOption2), j, i, i2, i3);
        return true;
    }

    private boolean m23785a(List<HiHealthData> list, List<HiHealthData> list2, String[] strArr, long j, int i, int i2, int i3) {
        C2538c.c("Debug_HiSportStat", new Object[]{"saveAllSessionStat()  statDatas is ", list, ",deviceDatas = ", list2});
        if (C4539a.m21749a((List) list) || C4539a.m21749a((List) list2)) {
            C2538c.d("Debug_HiSportStat", new Object[]{"saveAllSessionStat()  statDatas or deviceDatas is null"});
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        double d = hiHealthData.getDouble(strArr[0]);
        double d2 = hiHealthData.getDouble(strArr[1]);
        double d3 = hiHealthData.getDouble(strArr[2]);
        double d4 = hiHealthData.getDouble(strArr[3]);
        double d5 = d4;
        double d6 = d3;
        double d7 = d2;
        for (HiHealthData hiHealthData2 : list2) {
            if (d < hiHealthData2.getDouble(strArr[0])) {
                d = hiHealthData2.getDouble(strArr[0]);
            }
            if (d7 < hiHealthData2.getDouble(strArr[1])) {
                d2 = hiHealthData2.getDouble(strArr[1]);
            } else {
                d2 = d7;
            }
            if (d6 < hiHealthData2.getDouble(strArr[2])) {
                d3 = hiHealthData2.getDouble(strArr[2]);
            } else {
                d3 = d6;
            }
            if (d5 < hiHealthData2.getDouble(strArr[3])) {
                d4 = hiHealthData2.getDouble(strArr[3]);
            } else {
                d4 = d5;
            }
            d5 = d4;
            d6 = d3;
            d7 = d2;
        }
        boolean a = m23781a(j, (int) PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED, i, i2, i3, d, 1);
        C2538c.c("Debug_HiSportStat", new Object[]{"saveAllSessionStat()  step change = ", Boolean.valueOf(a), ",statDate = ", Integer.valueOf(C4540b.m21750a(j)), ",step = ", Double.valueOf(d)});
        a = m23781a(j, (int) PayStatusCodes.PRODUCT_SOME_NOT_EXIST, i, i2, i3, d7, 2);
        C2538c.c("Debug_HiSportStat", new Object[]{"saveAllSessionStat()  distance change = ", Boolean.valueOf(a), ",statDate = ", Integer.valueOf(C4540b.m21750a(j)), ",distance = ", Double.valueOf(d7)});
        a = m23781a(j, (int) PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION, i, i2, i3, d6, 3);
        C2538c.c("Debug_HiSportStat", new Object[]{"saveAllSessionStat()  calorie change = ", Boolean.valueOf(a), ",statDate = ", Integer.valueOf(C4540b.m21750a(j)), ",calorie = ", Double.valueOf(d6)});
        a = m23781a(j, 40005, i, i2, i3, d5, 4);
        C2538c.c("Debug_HiSportStat", new Object[]{"saveAllSessionStat()  altitude change = ", Boolean.valueOf(a), ",statDate = ", Integer.valueOf(C4540b.m21750a(j)), ",altitude = ", Double.valueOf(d5)});
        return true;
    }

    private boolean m23786a(List<HiHealthData> list, String[] strArr, long j, int i, int i2, int i3) {
        if (C4539a.m21749a((List) list)) {
            C2538c.d("Debug_HiSportStat", new Object[]{"saveWalkSessionStat()  statDatas is ", list});
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        boolean a = m23781a(j, 40011, i, i2, i3, hiHealthData.getDouble(strArr[0]), 1);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveWalkSessionStat()  step change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40031, i, i2, i3, hiHealthData.getDouble(strArr[1]), 2);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveWalkSessionStat()  distance change = ", Boolean.valueOf(a)});
        boolean a2 = m23781a(j, 40021, i, i2, i3, hiHealthData.getDouble(strArr[2]), 3);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveWalkSessionStat()  calorie change = ", Boolean.valueOf(a2)});
        return true;
    }

    private boolean m23787b(List<HiHealthData> list, String[] strArr, long j, int i, int i2, int i3) {
        if (C4539a.m21749a((List) list)) {
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        boolean a = m23781a(j, 40012, i, i2, i3, hiHealthData.getDouble(strArr[0]), 1);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveRunSessionStat()  step change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40032, i, i2, i3, hiHealthData.getDouble(strArr[1]), 2);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveRunSessionStat()  distance change = ", Boolean.valueOf(a)});
        boolean a2 = m23781a(j, 40022, i, i2, i3, hiHealthData.getDouble(strArr[2]), 3);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveRunSessionStat()  calorie change = ", Boolean.valueOf(a2)});
        return true;
    }

    private boolean m23788c(List<HiHealthData> list, String[] strArr, long j, int i, int i2, int i3) {
        if (C4539a.m21749a((List) list)) {
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        boolean a = m23781a(j, 40033, i, i2, i3, hiHealthData.getDouble(strArr[1]), 2);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveCycleSessionStat()  distance change = ", Boolean.valueOf(a)});
        boolean a2 = m23781a(j, 40023, i, i2, i3, hiHealthData.getDouble(strArr[2]), 3);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveCycleSessionStat()  calorie change = ", Boolean.valueOf(a2)});
        return true;
    }

    private boolean m23789d(List<HiHealthData> list, String[] strArr, long j, int i, int i2, int i3) {
        if (C4539a.m21749a((List) list)) {
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        boolean a = m23781a(j, 40013, i, i2, i3, hiHealthData.getDouble(strArr[0]), 1);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveClimbSessionStat()  step change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40034, i, i2, i3, hiHealthData.getDouble(strArr[1]), 2);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveClimbSessionStat()  distance change = ", Boolean.valueOf(a)});
        boolean a2 = m23781a(j, 40024, i, i2, i3, hiHealthData.getDouble(strArr[2]), 3);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveClimbSessionStat()  calorie change = ", Boolean.valueOf(a2)});
        return true;
    }

    private boolean m23790e(List<HiHealthData> list, String[] strArr, long j, int i, int i2, int i3) {
        if (C4539a.m21749a((List) list)) {
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        C2538c.c("Debug_HiSportStat", new Object[]{"saveSwimSessionStat()  statDatas = ", list});
        boolean a = m23781a(j, 40035, i, i2, i3, hiHealthData.getDouble(strArr[1]), 2);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveSwimSessionStat()  distance change = ", Boolean.valueOf(a)});
        boolean a2 = m23781a(j, 40025, i, i2, i3, hiHealthData.getDouble(strArr[2]), 3);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveSwimSessionStat()  calorie change = ", Boolean.valueOf(a2)});
        return true;
    }

    private boolean m23784a(List<HiHealthData> list, long j, int i, int i2, int i3) {
        if (C4539a.m21749a((List) list)) {
            return false;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        for (HiHealthData hiHealthData : list) {
            switch (hiHealthData.getType()) {
                case 20002:
                    d = hiHealthData.getDouble("duration");
                    break;
                case 20003:
                    d2 = hiHealthData.getDouble("duration");
                    break;
                case 20004:
                    d4 = hiHealthData.getDouble("duration");
                    break;
                case 20005:
                    d3 = hiHealthData.getDouble("duration");
                    break;
                case 20007:
                    d5 = hiHealthData.getDouble("duration");
                    break;
                default:
                    break;
            }
        }
        boolean a = m23781a(j, 40041, i, i2, i3, d, 13);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveDurationSessionStat()  walkDuration change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40042, i, i2, i3, d2, 13);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveDurationSessionStat()  runDuration change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40043, i, i2, i3, d3, 13);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveDurationSessionStat()  cycleDuration change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40044, i, i2, i3, d4, 13);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveDurationSessionStat()  climbDuration change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40045, i, i2, i3, d5, 13);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveDurationSessionStat()  swimDuration change = ", Boolean.valueOf(a)});
        a = m23781a(j, 40006, i, i2, i3, (((d + d2) + d3) + d4) + d5, 13);
        C2538c.b("Debug_HiSportStat", new Object[]{"saveDurationSessionStat()  totalDuration change = ", Boolean.valueOf(a)});
        return true;
    }

    private boolean m23781a(long j, int i, int i2, int i3, int i4, double d, int i5) {
        if (d <= 0.0d) {
            return false;
        }
        C4807a c4807a = new C4807a();
        c4807a.m23028a(j);
        c4807a.m23031b(20001);
        c4807a.m23038e(i3);
        c4807a.m23036d(i2);
        c4807a.m23042g(i4);
        c4807a.m23040f(i5);
        c4807a.m23034c(i);
        c4807a.m23026a(d);
        return this.a.m23618a(c4807a);
    }
}
