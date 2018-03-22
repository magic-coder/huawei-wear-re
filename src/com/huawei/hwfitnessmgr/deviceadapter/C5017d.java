package com.huawei.hwfitnessmgr.deviceadapter;

import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartZoneConf;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5024g;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5025h;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

import java.util.Arrays;
import java.util.List;

/* compiled from: FitnessSendCommandUtil */
public class C5017d {
    public static void m24151a(List<MotionGoal> list) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendSetMotionGoalCmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(1);
        byte[] a = C5014a.m24123a((List) list);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    private static boolean m24166f() {
        DeviceInfo c = com.huawei.n.c.a(BaseApplication.b()).c();
        if (c != null) {
            c.c("FitnessSendCommandUtil", new Object[]{"isNeedEncrypt Encrypt type =" + c.getEncryptType()});
            if (1 == c.getEncryptType()) {
                return true;
            }
        }
        c.e("FitnessSendCommandUtil", new Object[]{"encryptTLVs getCurrentDeviceInfo() = null"});
        return false;
    }

    public static void m24150a(UserInfomation userInfomation) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendDeviceUserInfo enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setCommandID(2);
        if (C5017d.m24166f()) {
            C2538c.c("FitnessSendCommandUtil", new Object[]{"sendDeviceUserInfo need encrypt enter"});
            deviceCommand.setNeedEncrypt(true);
        } else {
            deviceCommand.setNeedEncrypt(false);
        }
        deviceCommand.setServiceID(7);
        byte[] a = C5014a.m24121a(userInfomation);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24142a() {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetTodayTotalCommad enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(3);
        byte[] a = C5014a.m24114a();
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24147a(long j, long j2) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetHealthDataByFrameCountCmd enter start=" + j + " endtime=" + j2});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(4);
        byte[] a = C5014a.m24117a(j, j2);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24143a(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetHealthDataByFrameCompressedCmd enter idx=" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(5);
        byte[] a = C5014a.m24115a(i);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24148a(ActivityReminder activityReminder) {
        C2538c.a("03", 1, "FitnessSendCommandUtil", new Object[]{"sendSetActivityReminderCmd enter" + activityReminder});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(7);
        byte[] a = C5014a.m24118a(activityReminder);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24154b(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"getHealthDataByFrameComm enter idx=" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(8);
        byte[] a = C5014a.m24116a(i, i);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24155b(long j, long j2) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetSampleFrameCountCmd enter start=" + j + " end=" + j2});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(10);
        byte[] b = C5014a.m24127b(j, j2);
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24158c(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetSampleFrameCmd enter idx=" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(11);
        byte[] b = C5014a.m24125b(i);
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24159c(long j, long j2) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetStatusFrameCountCmd enter start=" + j + " end=" + j2});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(12);
        byte[] c = C5014a.m24131c(j, j2);
        deviceCommand.setDataLen(c.length);
        deviceCommand.setDataContent(c);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24162d(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendGetStatusFrameCmd enter idx=" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(13);
        byte[] c = C5014a.m24130c(i);
        deviceCommand.setDataLen(c.length);
        deviceCommand.setDataContent(c);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24156b(List<C5024g> list) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendsetDeviceReportThroshold "});
        C2538c.b("FitnessSendCommandUtil", new Object[]{"throsholdList =  ", list});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(14);
        byte[] b = C5014a.m24128b((List) list);
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24152a(boolean z) {
        int i = 1;
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendSetDevCouldSummaryEnable enter enable=" + z});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(16);
        StringBuilder append = new StringBuilder().append(C0973a.a(1)).append(C0973a.a(1));
        if (!z) {
            i = 0;
        }
        byte[] b = C0973a.b(append.append(C0973a.a(i)).toString());
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24160c(List<C5025h> list) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendReverseDataSync enter todayTotal=", list});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(17);
        byte[] c = C5014a.m24132c((List) list);
        deviceCommand.setDataLen(c.length);
        deviceCommand.setDataContent(c);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24149a(HeartZoneConf heartZoneConf) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendSetHRZoneConfCmd enter " + heartZoneConf});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(19);
        byte[] a = C5014a.m24120a(heartZoneConf);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24164e(int i) {
        C2538c.b("FitnessSendCommandUtil", new Object[]{"sendSetCoreSleepEnableCmd  enabled:" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(22);
        byte[] d = C5014a.m24134d(i);
        deviceCommand.setDataLen(d.length);
        deviceCommand.setDataContent(d);
        C2538c.b("FitnessSendCommandUtil", new Object[]{"sendSetCoreSleepEnableCmd data =", d});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24165f(int i) {
        C2538c.b("FitnessSendCommandUtil", new Object[]{"sendSetCoreSleepEnableCmd  enabled:" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(23);
        byte[] e = C5014a.m24136e(i);
        deviceCommand.setDataLen(e.length);
        deviceCommand.setDataContent(e);
        C2538c.b("FitnessSendCommandUtil", new Object[]{"sendSetCoreSleepEnableCmd data =", Arrays.toString(e)});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24167g(int i) {
        C2538c.b("FitnessSendCommandUtil", new Object[]{"sendSleepStateCmd  enabled:" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(24);
        byte[] f = C5014a.m24137f(i);
        deviceCommand.setDataLen(f.length);
        deviceCommand.setDataContent(f);
        C2538c.b("FitnessSendCommandUtil", new Object[]{"sendSleepStateCmd data =", Arrays.toString(f)});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24153b() {
        C2538c.b("FitnessSendCommandUtil", new Object[]{"Enter queryDeviceCoreSleepSwitchStateCmd"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(27);
        byte[] b = C5014a.m24124b();
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        C2538c.b("FitnessSendCommandUtil", new Object[]{"queryDeviceCoreSleepSwitchStateCmd data =", Arrays.toString(b)});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24157c() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(21);
        byte[] c = C5014a.m24129c();
        deviceCommand.setDataLen(c.length);
        deviceCommand.setDataContent(c);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24146a(int i, UserInfomation userInfomation, int i2) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendV0SetUserInfo1Cmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(i);
        byte[] a = C5014a.m24122a(userInfomation, i2);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24145a(int i, ActivityReminder activityReminder, List<SmartAlarmInfo> list) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendV0SetUserInfo2Cmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(i);
        byte[] a = C5014a.m24119a(activityReminder, (List) list);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24168h(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendV0GetFrameCountCmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(i);
        byte[] d = C5014a.m24133d();
        deviceCommand.setDataLen(d.length);
        deviceCommand.setDataContent(d);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24169i(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendV0GetHealthDataByFrameCmd enter idx=" + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(5);
        byte[] g = C5014a.m24138g(i);
        deviceCommand.setDataLen(g.length);
        deviceCommand.setDataContent(g);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24161d() {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendV0ClearHealthData enter."});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(5);
        byte[] e = C5014a.m24135e();
        deviceCommand.setDataLen(e.length);
        deviceCommand.setDataContent(e);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24144a(int i, int i2, int i3) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendV0SetUserInfo1Cmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(i);
        byte[] b = C5014a.m24126b(i2, i3);
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24170j(int i) {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendAFSetMotionGoalCmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(1);
        byte[] h = C5014a.m24139h(i);
        deviceCommand.setDataLen(h.length);
        deviceCommand.setDataContent(h);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m24163e() {
        C2538c.c("FitnessSendCommandUtil", new Object[]{"sendAFSetMotionGoalCmd enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(7);
        deviceCommand.setCommandID(1001);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }
}
