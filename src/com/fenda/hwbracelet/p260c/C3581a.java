package com.fenda.hwbracelet.p260c;

import android.content.Context;
import android.util.Log;
import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.hwbracelet.mode.C3619b;
import com.fenda.hwbracelet.mode.C3624g;
import com.fenda.hwbracelet.mode.C3625h;
import com.fenda.hwbracelet.mode.C3627j;
import com.fenda.hwbracelet.mode.C3628k;
import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3601d;
import com.fenda.hwbracelet.p262e.C3602e;
import com.fenda.hwbracelet.p263f.C3608d;
import com.fenda.hwbracelet.p263f.C3609e;
import com.fenda.hwbracelet.p267g.C3614a;
import com.fenda.hwbracelet.p267g.C3617d;
import com.fenda.p255a.p256a.C3565a;
import com.fenda.p255a.p256a.C3568d;
import com.huawei.p032e.p264a.p265a.p266b.C4386b;
import com.huawei.p032e.p264a.p265a.p266b.C4387c;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* compiled from: XCommand */
public class C3581a {
    private static C3609e m17981o() throws C3582b {
        if (C3609e.m18112a(null) != null) {
            return C3609e.m18112a(null);
        }
        throw new C3582b();
    }

    public static void m17959a(List<Alarm> list) {
        if (list == null) {
            try {
                C2538c.c("XCommand", new Object[]{"alarmList == null"});
                list = new ArrayList();
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"XbService is unavailable with info = " + e.getMessage()});
                return;
            } catch (Exception e2) {
                C2538c.c("XCommand", new Object[]{"sendSetAlarmMessage: " + e2.getMessage()});
                return;
            }
        }
        List arrayList = new ArrayList();
        if (list != null && list.size() >= 1) {
            int size = list.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3 = i2 + 1;
                Alarm alarm = (Alarm) list.get(i);
                byte b = (byte) i3;
                C2538c.c("XCommand", new Object[]{"getId: " + alarm.getId()});
                byte onOff = (byte) alarm.getOnOff();
                C2538c.c("XCommand", new Object[]{"TIME: " + alarm.getTime()});
                if (alarm.getTime() == null) {
                    C2538c.d("XCommand", new Object[]{"null == getTime"});
                    return;
                }
                String[] split = alarm.getTime().split(":");
                if (split == null || split.length != 2) {
                    C2538c.d("XCommand", new Object[]{"null == time || time.length != 2"});
                    return;
                }
                byte b2;
                byte b3;
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                int i4 = (parseInt * 60) + parseInt2;
                if (parseInt <= 24) {
                    byte b4 = (byte) parseInt;
                }
                if (parseInt2 <= 60) {
                    b2 = (byte) parseInt2;
                }
                if (alarm.getMon() > 0) {
                    b2 = (byte) 1;
                } else {
                    b2 = (byte) 0;
                }
                if (alarm.getTue() > 0) {
                    b2 = (byte) (b2 + 2);
                }
                if (alarm.getWed() > 0) {
                    b2 = (byte) (b2 + 4);
                }
                if (alarm.getThu() > 0) {
                    b2 = (byte) (b2 + 8);
                }
                if (alarm.getFri() > 0) {
                    b2 = (byte) (b2 + 16);
                }
                if (alarm.getSta() > 0) {
                    b2 = (byte) (b2 + 32);
                }
                if (alarm.getSun() > 0) {
                    b3 = (byte) (b2 + 64);
                } else {
                    b3 = b2;
                }
                C3619b c3619b = new C3619b(b, onOff, i4, b3);
                if (onOff > (byte) 0) {
                    arrayList.add(c3619b);
                }
                i++;
                i2 = i3;
            }
        }
        C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18070a(arrayList));
    }

    public static void m17950a() {
        try {
            C3581a.m17981o().m18121a(C3601d.m18065a().m18077d());
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendActiveDisconnectMessage: " + e.getMessage()});
        }
    }

    public static void m17955a(C3627j c3627j) {
        if (c3627j == null) {
            try {
                c3627j = C3581a.m17982p();
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"XbService is unavailable. e: " + e.getMessage()});
                return;
            } catch (Exception e2) {
                C2538c.c("XCommand", new Object[]{"sendSportRemindMessage: " + e2.getMessage()});
                return;
            }
        }
        if (c3627j != null) {
            boolean z;
            if (c3627j.m18165a() > 0) {
                z = true;
            } else {
                z = false;
            }
            byte b = (byte) c3627j.m18168b();
            String c = c3627j.m18171c();
            if (c == null) {
                c.d("XCommand", new Object[]{"null == starttime"});
                return;
            }
            String d = c3627j.m18174d();
            if (d == null) {
                c.d("XCommand", new Object[]{"null == endtime"});
                return;
            }
            String e3 = c3627j.m18177e();
            if (e3 == null) {
                c.d("XCommand", new Object[]{"null == pmstarttime"});
                return;
            }
            String f = c3627j.m18180f();
            if (f == null) {
                c.d("XCommand", new Object[]{"null == pmendtime"});
                return;
            }
            String[] split = c.split(":");
            String[] split2 = d.split(":");
            String[] split3 = e3.split(":");
            String[] split4 = f.split(":");
            if (split != null && split2 != null && split3 != null && split4 != null && split.length == 2 && split2.length == 2 && split3.length == 2 && split4.length == 2) {
                int parseInt = (((byte) Integer.parseInt(split[0])) * 60) + ((byte) Integer.parseInt(split[1]));
                int parseInt2 = ((byte) Integer.parseInt(split2[1])) + (((byte) Integer.parseInt(split2[0])) * 60);
                int parseInt3 = ((byte) Integer.parseInt(split3[1])) + (((byte) Integer.parseInt(split3[0])) * 60);
                int parseInt4 = ((byte) Integer.parseInt(split4[1])) + (((byte) Integer.parseInt(split4[0])) * 60);
                byte i = (byte) c3627j.m18189i();
                byte b2 = (byte) 0;
                for (int i2 = 0; i2 < 7; i2++) {
                    if (((1 << i2) & i) > 0) {
                        b2 = (byte) (b2 + ((byte) (1 << ((12 - i2) % 7))));
                    }
                }
                C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18068a(new C3628k(z, parseInt, parseInt2, parseInt3, parseInt4, b, b2)));
            }
        }
    }

    public static void m17964b(C3627j c3627j) {
        if (c3627j == null) {
            try {
                c3627j = C3581a.m17982p();
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"sendAutoSleepTimeMessage XbServiceUnvailableException: " + e.getMessage()});
                return;
            } catch (Exception e2) {
                C2538c.c("XCommand", new Object[]{"sendAutoSleepTimeMessage Exception: " + e2});
                return;
            }
        }
        if (c3627j != null) {
            String h = c3627j.m18186h();
            String h2 = c3627j.m18186h();
            if (h == null || h2 == null) {
                C2538c.c("XCommand", new Object[]{"null == starttime || null == endtime"});
                return;
            }
            String[] split = c3627j.m18183g().split(":");
            String[] split2 = c3627j.m18186h().split(":");
            if (split != null && split2 != null && split.length == 2 && split2.length == 2) {
                C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18067a((byte) 1, (byte) Integer.parseInt(split[0]), (byte) Integer.parseInt(split[1]), (byte) Integer.parseInt(split2[0]), (byte) Integer.parseInt(split2[1])));
            }
        }
    }

    public static void m17967c(C3627j c3627j) {
        C2538c.c("XCommand", new Object[]{"sendHighLightStateMessage"});
        if (c3627j == null) {
            try {
                c3627j = C3581a.m17982p();
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"XbServiceUnvailableException: " + e.getMessage()});
                return;
            } catch (Exception e2) {
                C2538c.c("XCommand", new Object[]{"sendAutoSleepTimeMessage: " + e2.getMessage()});
                return;
            }
        }
        if (c3627j != null) {
            C3581a.m17981o().m18124a(new C3624g(c3627j.m18195o() == 1).m18162a());
        }
    }

    public static void m17970d(C3627j c3627j) {
        C2538c.c("XCommand", new Object[]{"sendRemoteHandStateMessage"});
        if (c3627j == null) {
            try {
                c3627j = C3581a.m17982p();
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"XbServiceUnvailableException: " + e.getMessage()});
                return;
            } catch (Exception e2) {
                C2538c.c("XCommand", new Object[]{"sendAutoSleepTimeMessage: " + e2.getMessage()});
                return;
            }
        }
        if (c3627j != null) {
            C3581a.m17981o().m18124a(new C3625h(c3627j.m18196p() == 1).m18163a());
        }
    }

    public static void m17952a(int i, int i2) {
        try {
            C3581a.m17981o().m18121a(C3601d.m18065a().m18071a(i, i2));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendUserInfoMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17951a(int i) {
        try {
            C3581a.m17981o().m18121a(C3601d.m18065a().m18072a(i, (int) ((((float) i) * 25.0f) / 1000.0f), 0));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendSportGoalMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17954a(Context context, String str) {
        C2538c.c("XCommand", new Object[]{"sendIncomingCallMessage"});
        if (context == null) {
            C2538c.e("XCommand", new Object[]{"null == context"});
        } else if (C3581a.m17968c(context)) {
            try {
                C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18069a(str));
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"sendIncomingCallMessage XbServiceUnvailableException: " + e.getMessage()});
            }
        } else {
            C2538c.e("XCommand", new Object[]{"judgeIncomingTime: false"});
        }
    }

    private static boolean m17968c(Context context) {
        C3627j a = new C3568d(context).m17915a();
        if (a == null) {
            a = C3581a.m17982p();
        }
        if (a == null) {
            return false;
        }
        C2538c.c("XCommand", new Object[]{"status: " + a.m18190j()});
        if (a.m18190j() <= 0) {
            return false;
        }
        String k = a.m18191k();
        String l = a.m18192l();
        C2538c.c("XCommand", new Object[]{"startTime: " + k + ", endTime: " + l});
        if (k.length() > 5 || l.length() > 5) {
            k = "8:00";
            l = "22:00";
        }
        Calendar instance = Calendar.getInstance();
        int i = instance.get(12) + (instance.get(11) * 60);
        int a2 = C3608d.m18109a(k);
        int a3 = C3608d.m18109a(l);
        C2538c.c("XCommand", new Object[]{"current: " + i + ", Start: " + a2 + ", End: " + a3});
        if ((i < a2 || i > a3) && ((i > a3 && i < a2) || a2 <= a3)) {
            return false;
        }
        return true;
    }

    public static void m17962b() {
        C2538c.c("XCommand", new Object[]{"sendCallEndMessage"});
        try {
            C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18079f());
            C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18079f());
            C2538c.c("XCommand", new Object[]{"sendMessage."});
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendCallEndMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17966c() {
        try {
            C3581a.m17981o().m18121a(C3601d.m18065a().m18078e());
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendRssiAlertMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17960a(boolean z) {
        try {
            C3581a.m17981o().m18121a(C3601d.m18065a().m18073a(z));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendRssiState XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17953a(Context context) {
        C2538c.c("XCommand", new Object[]{"startRssiListener"});
        C3627j a = new C3568d(context).m17915a();
        if (a == null) {
            a = C3581a.m17982p();
        }
        if (a == null) {
            C2538c.e("XCommand", new Object[]{"null == info"});
        } else if (a.m18193m() <= 0) {
            C3581a.m17969d();
        } else {
            C3581a.m17960a(true);
        }
    }

    public static void m17969d() {
        try {
            C3581a.m17960a(false);
            C3581a.m17981o().m18117a();
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"stopRssiListener XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17971e() {
        try {
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_USER_INFO));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetUserInfo XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17972f() {
        try {
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_BAND_BATTERY));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetBatteryMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17973g() {
        try {
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_CURRENT_VERSION));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetVersionMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17974h() {
        try {
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_ST_VERSION));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetBasebandVersionMessage XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17975i() {
        if (C3614a.m18129a().m18146d() != C3617d.STATE_SYNC) {
            C3581a.m17971e();
            try {
                C3614a.m18129a().m18145c();
                C3581a.m17981o().m18121a(new C3600c(C3602e.SYNC_DATA_REQUEST));
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"sendSyncDataRequestMessage XbServiceUnvailableException: " + e.getMessage()});
            }
        }
    }

    public static void m17976j() {
        try {
            C2538c.c("XCommand", new Object[]{"sendGetTotalStepsAndCalorie()"});
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_TOTAL_STEPS));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetTotalSteps XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17977k() {
        try {
            C2538c.c("XCommand", new Object[]{"sendGetTotalStepsAndCalorie()"});
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_TOTAL_CALORIE));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetTotalCalorie XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17978l() {
        C3581a.m17976j();
        C3581a.m17977k();
    }

    public static void m17979m() {
        try {
            C3581a.m17981o().m18121a(new C3600c(C3602e.GET_TOTAL_SLEEP_TIME));
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendGetTotalSleepTime XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17965b(boolean z) {
        C3614a.m18129a().m18143a(z);
    }

    public static void m17963b(Context context) {
        C2538c.c("XCommand", new Object[]{"sendOneClickSyncMessage()"});
        C3581a.m17965b(true);
        C3581a.m17978l();
        C3581a.m17979m();
        try {
            C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18075b());
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendOneClickSyncMessage XbServiceUnvailableException: " + e.getMessage()});
        }
        C3581a.m17972f();
        C3581a.m17973g();
        C3581a.m17971e();
        if (context != null) {
            C3581a.m17959a(new C3565a(context).m17898a());
            C3568d c3568d = new C3568d(context);
            C3581a.m17955a(c3568d.m17915a());
            C3581a.m17964b(c3568d.m17915a());
            C3581a.m17967c(c3568d.m17915a());
            C3581a.m17970d(c3568d.m17915a());
        }
        if (C3614a.m18129a().m18146d() != C3617d.STATE_SYNC) {
        }
    }

    public static void m17958a(C4389a c4389a) {
        try {
            C3581a.m17981o().m18123a(c4389a);
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"setOnSyncDataListener XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17957a(C4387c c4387c) {
        try {
            C3581a.m17981o().m18122a(c4387c);
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"setIHealthDeviceCallback XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17956a(C4386b c4386b) {
        C3614a.m18129a().m18140a(c4386b);
    }

    public static void m17980n() {
        try {
            C3581a.m17981o().m18121a((C3600c) C3601d.m18065a().m18080g());
        } catch (C3582b e) {
            C2538c.c("XCommand", new Object[]{"sendSyncEndConfirm XbServiceUnvailableException: " + e.getMessage()});
        }
    }

    public static void m17961a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            C2538c.e("XCommand", new Object[]{"The byte array that will be sent is null or the byte array's length is zero!"});
        } else if (bArr.length <= 20) {
            try {
                C3581a.m17981o().m18124a(bArr);
            } catch (C3582b e) {
                C2538c.c("XCommand", new Object[]{"sendByteArrayMessage XbServiceUnvailableException: " + e.getMessage()});
            }
        } else {
            Log.e("XCommand", "The ByteArray's size beyond 20.");
        }
    }

    private static C3627j m17982p() {
        C3627j c3627j = new C3627j();
        c3627j.m18178e(0);
        c3627j.m18188h("22:00");
        c3627j.m18185g("08:00");
        c3627j.m18175d(1);
        c3627j.m18184g(1);
        c3627j.m18181f(13);
        c3627j.m18187h(1);
        c3627j.m18182f("07:00");
        c3627j.m18179e("22:30");
        c3627j.m18166a(0);
        c3627j.m18170b("11:59");
        c3627j.m18167a("08:00");
        c3627j.m18172c(31);
        c3627j.m18176d("18:00");
        c3627j.m18173c("14:00");
        c3627j.m18169b(15);
        return c3627j;
    }
}
