package com.huawei.hwfitnessmgr.deviceadapter;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartZoneConf;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5024g;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5025h;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

import java.util.List;

/* compiled from: FitnessPackage */
public class C5014a {
    public static byte[] m24123a(List<MotionGoal> list) {
        return C5015b.m24140a(list);
    }

    public static byte[] m24121a(UserInfomation userInfomation) {
        int parseInt;
        String str;
        int i = HiUserInfo.HEIGHT_DEFAULT;
        int i2 = 60;
        int age = userInfomation.getAge();
        int gender = userInfomation.getGender();
        try {
            parseInt = Integer.parseInt(userInfomation.getBirthday());
        } catch (Exception e) {
            C2538c.c("FitnessPackage", new Object[]{"setDataUserInfo get brithday error:" + e});
            parseInt = 0;
        }
        if (userInfomation.getMetricHeight() > 0) {
            i = userInfomation.getMetricHeight();
        } else {
            C2538c.d("FitnessPackage", new Object[]{"setDataUserInfo invalide height"});
        }
        String str2 = C0973a.a(1) + C0973a.a(1) + C0973a.a(i);
        if (userInfomation.getMetricWeight() > 0) {
            i2 = userInfomation.getMetricWeight();
        } else {
            C2538c.d("FitnessPackage", new Object[]{"setDataUserInfo invalide weight"});
        }
        String str3 = C0973a.a(2) + C0973a.a(1) + C0973a.a(i2);
        String str4 = C0973a.a(3) + C0973a.a(1) + C0973a.a(age);
        String str5 = "";
        if (gender == 1) {
            str5 = C0973a.a(5) + C0973a.a(1) + C0973a.a(2);
        } else {
            str5 = C0973a.a(5) + C0973a.a(1) + C0973a.a(1);
        }
        String str6 = C0973a.a(6) + C0973a.a(1) + C0973a.a(Math.round(((float) i) * 0.42f));
        String str7 = C0973a.a(7) + C0973a.a(1) + C0973a.a(Math.round(((float) i) * 0.83f));
        String str8 = "";
        if (parseInt != 0) {
            str = parseInt + "";
            if (8 == str.length()) {
                int parseInt2 = Integer.parseInt(str.substring(0, 4));
                i = Integer.parseInt(str.substring(4, 6));
                parseInt = Integer.parseInt(str.substring(6));
                String b = C0973a.b(parseInt2);
                str8 = C0973a.a(i);
                str = C0973a.a(4) + C0973a.a(4) + b + str8 + C0973a.a(parseInt);
                return C0973a.b(str2 + str3 + str4 + str5 + str6 + str7 + str);
            }
        }
        str = str8;
        return C0973a.b(str2 + str3 + str4 + str5 + str6 + str7 + str);
    }

    public static byte[] m24114a() {
        return C0973a.b(C0973a.a(1) + C0973a.a(0));
    }

    public static byte[] m24117a(long j, long j2) {
        String str = ("" + C0973a.a(1)) + C0973a.a(0);
        if (0 != j) {
            System.out.println("startTime=" + j);
            str = (str + C0973a.a(3) + C0973a.a(4)) + C0973a.a(j);
            if (0 != j2) {
                str = (str + C0973a.a(4) + C0973a.a(4)) + C0973a.a(j2);
            }
        }
        return C0973a.b(str);
    }

    public static byte[] m24115a(int i) {
        return C0973a.b(((("" + C0973a.a(129)) + C0973a.a(4)) + C0973a.a(2)) + C0973a.a(2) + C0973a.b(i));
    }

    public static byte[] m24118a(ActivityReminder activityReminder) {
        String str = "";
        if (activityReminder != null) {
            str = str + C0973a.a(129);
            String str2 = str + C0973a.a(17);
            int i = 0;
            if (activityReminder.isEnabled()) {
                i = 1;
            }
            str = (str2 + C0973a.a(2) + C0973a.a(1) + C0973a.a(i)) + C0973a.a(3) + C0973a.a(1) + C0973a.a(activityReminder.getInterval());
            int startTime = activityReminder.getStartTime();
            str = str + C0973a.a(4) + C0973a.a(2) + C0973a.a((startTime >> 8) & 255) + C0973a.a(startTime & 255);
            startTime = activityReminder.getEndTime();
            str = (str + C0973a.a(5) + C0973a.a(2) + C0973a.a((startTime >> 8) & 255) + C0973a.a(startTime & 255)) + C0973a.a(6) + C0973a.a(1) + C0973a.a(activityReminder.getCycle());
        }
        return C0973a.b(str);
    }

    public static byte[] m24116a(int i, int i2) {
        return C0973a.b(((((("" + C0973a.a(129)) + C0973a.a(8)) + C0973a.a(2)) + C0973a.a(2) + C0973a.b(i)) + C0973a.a(3)) + C0973a.a(2) + C0973a.b(i2));
    }

    public static byte[] m24127b(long j, long j2) {
        String str = "";
        str = C0973a.a(129) + C0973a.a(0);
        if (0 != j) {
            str = (str + C0973a.a(3) + C0973a.a(4)) + C0973a.a(j);
            if (0 != j2) {
                str = (str + C0973a.a(4) + C0973a.a(4)) + C0973a.a(j2);
            }
        }
        return C0973a.b(str);
    }

    public static byte[] m24125b(int i) {
        return C0973a.b(((("" + C0973a.a(129)) + C0973a.a(4)) + C0973a.a(2)) + C0973a.a(2) + C0973a.b(i));
    }

    public static byte[] m24131c(long j, long j2) {
        String str = "";
        str = C0973a.a(129) + C0973a.a(0);
        if (0 != j) {
            str = (str + C0973a.a(3) + C0973a.a(4)) + C0973a.a(j);
            if (0 != j2) {
                str = (str + C0973a.a(4) + C0973a.a(4)) + C0973a.a(j2);
            }
        }
        return C0973a.b(str);
    }

    public static byte[] m24130c(int i) {
        return C0973a.b(((("" + C0973a.a(129)) + C0973a.a(4)) + C0973a.a(2)) + C0973a.a(2) + C0973a.b(i));
    }

    public static byte[] m24128b(List<C5024g> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (C5024g c5024g : list) {
            stringBuffer.append(C0973a.a(2));
            stringBuffer.append(C0973a.a(5));
            stringBuffer.append(C0973a.a(c5024g.m24214a()));
            stringBuffer.append(C0973a.a(c5024g.m24216b()));
            stringBuffer.append(C0973a.b(c5024g.m24218c()));
            stringBuffer.append(C0973a.a(c5024g.m24220d()));
            i += 7;
        }
        return C0973a.b(C0973a.a(129) + C0973a.a(i) + stringBuffer.toString());
    }

    public static byte[] m24132c(List<C5025h> list) {
        return C5016c.m24141a(list);
    }

    public static byte[] m24120a(HeartZoneConf heartZoneConf) {
        String str;
        int i;
        String str2 = ("" + C0973a.a(8)) + C0973a.a(1) + C0973a.a(heartZoneConf.isWarningEnble() ? 1 : 0);
        if (heartZoneConf.getWarningLimitHR() <= 0 || heartZoneConf.getFitnessThreshold() <= 0 || heartZoneConf.getWarmUpThreshold() <= 0 || heartZoneConf.getFatBurnThreshold() <= 0 || heartZoneConf.getAerobicThreshold() <= 0 || heartZoneConf.getAnaerobicThreshold() <= 0 || heartZoneConf.getMaxThreshold() <= 0) {
            str = str2;
            i = 3;
        } else {
            str = (((((((((((((str2 + C0973a.a(9)) + C0973a.a(1) + C0973a.a(heartZoneConf.getWarningLimitHR())) + C0973a.a(2)) + C0973a.a(1) + C0973a.a(heartZoneConf.getFitnessThreshold())) + C0973a.a(3)) + C0973a.a(1) + C0973a.a(heartZoneConf.getWarmUpThreshold())) + C0973a.a(4)) + C0973a.a(1) + C0973a.a(heartZoneConf.getFatBurnThreshold())) + C0973a.a(5)) + C0973a.a(1) + C0973a.a(heartZoneConf.getAerobicThreshold())) + C0973a.a(6)) + C0973a.a(1) + C0973a.a(heartZoneConf.getAnaerobicThreshold())) + C0973a.a(7)) + C0973a.a(1) + C0973a.a(heartZoneConf.getMaxThreshold());
            i = 24;
        }
        return C0973a.b(C0973a.a(129) + C0973a.a(i) + str);
    }

    public static byte[] m24134d(int i) {
        return C0973a.b("" + C0973a.a(1) + C0973a.a(1) + C0973a.a(i));
    }

    public static byte[] m24136e(int i) {
        return C0973a.b("" + C0973a.a(1) + C0973a.a(1) + C0973a.a(i));
    }

    public static byte[] m24137f(int i) {
        return C0973a.b("" + C0973a.a(1) + C0973a.a(1) + C0973a.a(i));
    }

    public static byte[] m24124b() {
        return C0973a.b("" + C0973a.a(1) + C0973a.a(1) + C0973a.a(1));
    }

    public static byte[] m24129c() {
        return C0973a.b(("" + C0973a.a(1)) + C0973a.a(0));
    }

    public static byte[] m24122a(UserInfomation userInfomation, int i) {
        r0 = new byte[16];
        int metricHeight = userInfomation.getMetricHeight();
        int metricWeight = userInfomation.getMetricWeight();
        int age = userInfomation.getAge();
        int gender = userInfomation.getGender();
        int walkStepLen = userInfomation.getWalkStepLen();
        int runStepLen = userInfomation.getRunStepLen();
        int i2 = (i >> 8) & 255;
        int i3 = i & 255;
        r0[0] = (byte) 5;
        r0[1] = (byte) 14;
        r0[2] = (byte) metricHeight;
        r0[3] = (byte) metricWeight;
        r0[4] = (byte) age;
        r0[5] = (byte) gender;
        r0[6] = (byte) walkStepLen;
        r0[7] = (byte) runStepLen;
        r0[8] = (byte) null;
        r0[9] = (byte) null;
        r0[10] = (byte) 1;
        r0[11] = (byte) i2;
        r0[12] = (byte) i3;
        r0[13] = (byte) 1;
        r0[14] = (byte) null;
        r0[15] = (byte) null;
        return r0;
    }

    public static byte[] m24119a(ActivityReminder activityReminder, List<SmartAlarmInfo> list) {
        int i;
        byte[] bArr = new byte[15];
        int parseInt = Integer.parseInt(String.valueOf(activityReminder.getStartTime() / 256), 16);
        int parseInt2 = Integer.parseInt(String.valueOf(activityReminder.getEndTime() / 256), 16);
        int interval = activityReminder.getInterval();
        int cycle = activityReminder.getCycle();
        if (activityReminder.isEnabled()) {
            i = 127;
        } else {
            i = 0;
        }
        SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) list.get(0);
        int parseInt3 = Integer.parseInt(String.valueOf(smartAlarmInfo.getSmartAlarmStartTime_hour()), 16);
        int parseInt4 = Integer.parseInt(String.valueOf(smartAlarmInfo.getSmartAlarmStartTime_mins()), 16);
        int smartAlarmAheadTime = smartAlarmInfo.getSmartAlarmAheadTime();
        int smartAlarmRepeat = smartAlarmInfo.getSmartAlarmRepeat();
        int i2 = smartAlarmAheadTime != 0 ? 127 : 0;
        int i3 = smartAlarmInfo.getSmartAlarmEnable() == 0 ? 0 : 127;
        bArr[0] = (byte) 6;
        bArr[1] = TagName.PAY_CHANNEL;
        bArr[2] = (byte) parseInt;
        bArr[3] = (byte) parseInt2;
        bArr[4] = (byte) interval;
        bArr[5] = (byte) cycle;
        bArr[6] = (byte) i;
        bArr[7] = (byte) parseInt3;
        bArr[8] = (byte) parseInt4;
        bArr[9] = (byte) smartAlarmAheadTime;
        bArr[10] = (byte) smartAlarmRepeat;
        bArr[11] = (byte) i2;
        bArr[12] = (byte) i3;
        bArr[13] = (byte) 0;
        bArr[14] = (byte) 0;
        return bArr;
    }

    public static byte[] m24133d() {
        return new byte[]{TagName.IDENTIFYING_CODE, (byte) 0};
    }

    public static byte[] m24138g(int i) {
        r0 = new byte[4];
        int i2 = i >> 8;
        int i3 = i & 255;
        r0[0] = (byte) 17;
        r0[1] = (byte) 2;
        r0[2] = (byte) i2;
        r0[3] = (byte) i3;
        return r0;
    }

    public static byte[] m24135e() {
        return new byte[]{TagName.ORDER_TIME, (byte) 0};
    }

    public static byte[] m24126b(int i, int i2) {
        byte[] bArr = new byte[4];
        int i3 = i & 255;
        bArr[0] = (byte) (i >> 8);
        bArr[1] = (byte) i3;
        i3 = i2 & 255;
        bArr[2] = (byte) (i2 >> 8);
        bArr[3] = (byte) i3;
        return bArr;
    }

    public static byte[] m24139h(int i) {
        byte[] bArr = new byte[4];
        int i2 = i & 255;
        bArr[0] = (byte) (i >> 8);
        bArr[1] = (byte) i2;
        return bArr;
    }
}
