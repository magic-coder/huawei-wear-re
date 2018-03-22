package com.fenda.hwbracelet.p267g;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.fenda.hwbracelet.mode.C3629l;
import com.fenda.hwbracelet.p257a.C3574d;
import com.fenda.hwbracelet.p260c.C3581a;
import com.fenda.hwbracelet.p262e.C3602e;
import com.fenda.hwbracelet.p262e.C3603f;
import com.fenda.hwbracelet.p263f.C3608d;
import com.fenda.p255a.p256a.C3566b;
import com.fenda.p255a.p256a.C3569e;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.p032e.p264a.p265a.p266b.C4386b;
import com.huawei.p032e.p264a.p265a.p266b.C4387c;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.ui.FindPhoneActivity;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: HandleMessageUtils */
public class C3614a {
    private static C3614a f13853i;
    private boolean f13854a = false;
    private C4386b f13855b = null;
    private int f13856c = -1;
    private int f13857d = -1;
    private int f13858e = -1;
    private int f13859f = HiUserInfo.HEIGHT_DEFAULT;
    private int f13860g = 60;
    private Context f13861h;
    private C3617d f13862j;
    private C4389a f13863k = null;
    private ArrayList<C3629l> f13864l = null;

    public static C3614a m18129a() {
        if (f13853i == null) {
            f13853i = new C3614a();
        }
        return f13853i;
    }

    public void m18144b() {
        this.f13862j = C3617d.STATE_NONE;
        this.f13856c = -1;
        this.f13857d = -1;
        this.f13858e = -1;
        C2538c.b("HandleMessageUtils", new Object[]{"resetSyncState() " + this.f13862j});
    }

    public void m18145c() {
        this.f13862j = C3617d.STATE_SYNC;
        C2538c.b("HandleMessageUtils", new Object[]{"startSyncData() " + this.f13862j});
    }

    public C3617d m18146d() {
        C2538c.b("HandleMessageUtils", new Object[]{"getSyncState() syncState  " + this.f13862j});
        return this.f13862j;
    }

    public void m18139a(Context context) {
        this.f13861h = context;
    }

    public void m18143a(boolean z) {
        this.f13854a = z;
    }

    public boolean m18147e() {
        return this.f13854a;
    }

    public void m18142a(C4389a c4389a) {
        this.f13863k = c4389a;
    }

    public void m18140a(C4386b c4386b) {
        this.f13855b = c4386b;
    }

    public void m18141a(C4387c c4387c, C4389a c4389a, C3603f c3603f) {
        this.f13863k = c4389a;
        if (c4387c != null) {
            if (!m18136b(c4387c, c3603f)) {
                if (!m18133a(c4389a, c3603f)) {
                    int c = c3603f.m18085c();
                    c.b("HandleMessageUtils", new Object[]{"Received Message len: " + c});
                    c4387c.mo5111a(c3603f.m18085c(), c3603f.m18083a().array());
                }
            } else {
                return;
            }
        }
        C3602e b = c3603f.m18084b();
        byte[] a = m18134a(c3603f.m18083a().array());
        StringBuilder stringBuilder;
        switch (C3616c.f13866a[b.ordinal()]) {
            case 1:
                if (a == null || a.length <= 0) {
                    c4389a.mo4598a("AF500", "Unknown");
                    return;
                }
                stringBuilder = new StringBuilder();
                C2538c = 0;
                while (C2538c < a.length) {
                    if (a[C2538c] >= (byte) 0 && a[C2538c] <= (byte) 9) {
                        stringBuilder.append(Integer.toString(a[C2538c]));
                    } else if (a[C2538c] == TagName.SIM_SEID) {
                        stringBuilder.append(".");
                    }
                    C2538c++;
                }
                C2538c.b("HandleMessageUtils", new Object[]{"Version: " + stringBuilder.toString()});
                if (this.f13861h != null) {
                    new C3566b(this.f13861h).m17909c(stringBuilder.toString());
                }
                if (c4389a != null) {
                    c4389a.mo4598a("AF500", stringBuilder.toString());
                    return;
                }
                return;
            case 2:
                C2538c.c("HandleMessageUtils", new Object[]{"RESPOND_ST_VERSION"});
                if (a != null && a.length > 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("12.01.01.00.");
                    C2538c = 0;
                    while (C2538c < a.length) {
                        if (a[C2538c] >= (byte) 0 && a[C2538c] <= TagName.PREDEPOSIT_TOTAL) {
                            stringBuilder.append(Integer.toString(a[C2538c]));
                        } else if (a[C2538c] == TagName.SIM_SEID) {
                            stringBuilder.append(".");
                        }
                        C2538c++;
                    }
                    C2538c.b("HandleMessageUtils", new Object[]{"STVersion: " + stringBuilder.toString()});
                    String stringBuilder2 = stringBuilder.toString();
                    if (this.f13861h != null) {
                        new C3566b(this.f13861h).m17908b(stringBuilder2);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_USER_INFO"});
                if (a != null && a.length == 8) {
                    this.f13859f = a[0] & 255;
                    this.f13860g = a[1] & 255;
                    return;
                }
                return;
            case 4:
                C2538c.c("HandleMessageUtils", new Object[]{"SYNC END"});
                if (this.f13854a && c4389a != null) {
                    C2538c.b("HandleMessageUtils", new Object[]{"send the datas to APP"});
                    m18148f();
                    this.f13854a = false;
                    return;
                } else if (this.f13854a) {
                    this.f13854a = false;
                    this.f13862j = C3617d.STATE_NONE;
                    C2538c.b("HandleMessageUtils", new Object[]{"SYNC_END SEND_DATA_TO_APP" + this.f13862j});
                    return;
                } else if (!this.f13854a) {
                    C2538c.b("HandleMessageUtils", new Object[]{"not need to send the datas to APP"});
                    this.f13862j = C3617d.STATE_NONE;
                    C2538c.b("HandleMessageUtils", new Object[]{"SYNC_END !SEND_DATA_TO_APP" + this.f13862j});
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    private void m18132a(C4387c c4387c, C3603f c3603f) {
        if (c3603f.m18085c() >= 1) {
            C2538c.b("HandleMessageUtils", new Object[]{"Size: " + c3603f.m18085c()});
            C2538c.b("HandleMessageUtils", new Object[]{"Length: " + c3603f.m18083a().array().length});
            switch (C3616c.f13866a[C3602e.m18081a(r0[1]).ordinal()]) {
                case 5:
                    C2538c.c("HandleMessageUtils", new Object[]{"ALERT_ALARM"});
                    if (this.f13861h != null) {
                        C2538c.b("HandleMessageUtils", new Object[]{"Send BT_ALARM_SYN Broadcast"});
                        this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.ALARM_SET_SUCCESS"), "com.af500.permission.MYBRODCAST");
                        return;
                    }
                    return;
                case 6:
                    C2538c.c("HandleMessageUtils", new Object[]{"ALERT_SPORT_REMINDER"});
                    if (this.f13861h != null) {
                        C2538c.b("HandleMessageUtils", new Object[]{"Send BT_SPORT_SYN Broadcast"});
                        this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.SPORT_REMIND_SET_SUCCESS"), "com.af500.permission.MYBRODCAST");
                        return;
                    }
                    return;
                case 7:
                    C2538c.c("HandleMessageUtils", new Object[]{"AUTO_SLEEP_TIME"});
                    if (this.f13861h != null) {
                        C2538c.b("HandleMessageUtils", new Object[]{"Send BT_SLEEP_SYN Broadcast"});
                        this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.SLEEP_REMIND_SET_SUCCESS"), "com.af500.permission.MYBRODCAST");
                        return;
                    }
                    return;
                case 8:
                    C2538c.c("HandleMessageUtils", new Object[]{"FACTORY_RESET"});
                    if (this.f13861h != null) {
                        this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.INTENT_FACTORY_RESET"), "com.af500.permission.MYBRODCAST");
                        return;
                    }
                    return;
                case 9:
                    C2538c.c("HandleMessageUtils", new Object[]{"PERSONAL_PROFILE"});
                    return;
                case 10:
                    C2538c.c("HandleMessageUtils", new Object[]{"DATE_TIME"});
                    return;
                case 11:
                    C2538c.c("HandleMessageUtils", new Object[]{"APP_KEY"});
                    return;
                case 12:
                    C2538c.c("HandleMessageUtils", new Object[]{"CAMERA_OPEN"});
                    return;
                case 13:
                    C2538c.c("HandleMessageUtils", new Object[]{"CAMERA_CLOSE"});
                    return;
                case 14:
                case 15:
                case 16:
                case 17:
                    C2538c.c("HandleMessageUtils", new Object[]{"SET_PROMPT"});
                    return;
                case 18:
                case 19:
                    if (this.f13861h != null) {
                        this.f13861h.sendBroadcast(new Intent("com.colorband.dispaly_state"), "com.af500.permission.MYBRODCAST");
                        return;
                    }
                    return;
                case 20:
                case 21:
                    if (this.f13861h != null) {
                        C2538c.b("HandleMessageUtils", new Object[]{"Send BT_GESTURE_STATE Broadcast"});
                        this.f13861h.sendBroadcast(new Intent("com.colorband.gesture_state"), "com.af500.permission.MYBRODCAST");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean m18136b(C4387c c4387c, C3603f c3603f) {
        C2538c.b("HandleMessageUtils", new Object[]{"received a " + c3603f.m18084b().name() + " message, body: " + C3608d.m18110a(c3603f.m18083a().array())});
        byte[] a = m18134a(c3603f.m18083a().array());
        switch (C3616c.f13866a[c3603f.m18084b().ordinal()]) {
            case 22:
                C2538c.c("HandleMessageUtils", new Object[]{"MESSAGE_CONFIRM"});
                C2538c.b("HandleMessageUtils", new Object[]{"Message Confirm: " + C3608d.m18110a(c3603f.m18083a().array())});
                m18132a(c4387c, c3603f);
                return true;
            case 23:
                C2538c.b("HandleMessageUtils", new Object[]{"Receive FindPhone Message."});
                if (this.f13861h == null) {
                    return true;
                }
                if (PreferenceManager.getDefaultSharedPreferences(this.f13861h).getBoolean("com.fenda.hwbracelet.FIND_PHONE_ACTIVITY", false)) {
                    C2538c.b("HandleMessageUtils", new Object[]{"FindPhone is playing."});
                    return true;
                }
                C2538c.b("HandleMessageUtils", new Object[]{"FindPhone start."});
                Intent intent = new Intent();
                intent.setClass(this.f13861h, FindPhoneActivity.class);
                intent.setFlags(335544320);
                this.f13861h.startActivity(intent);
                return true;
            case 24:
                C2538c.c("HandleMessageUtils", new Object[]{"ALERT_CALL_MUTE"});
                if (this.f13861h == null) {
                    return true;
                }
                this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.PHONE_CALL_MUTE"), "com.af500.permission.MYBRODCAST");
                return true;
            case 25:
                C2538c.c("HandleMessageUtils", new Object[]{"ALERT_CALL_REJUST"});
                if (this.f13861h == null) {
                    return true;
                }
                this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.PHONE_CALL_REJECT"), "com.af500.permission.MYBRODCAST");
                return true;
            case 26:
                C2538c.c("HandleMessageUtils", new Object[]{"Camera_Shutter"});
                if (this.f13861h == null) {
                    return true;
                }
                this.f13861h.sendBroadcast(new Intent("com.fenda.hwbracelet.CAMERA_SHUTTER"), "com.af500.permission.MYBRODCAST");
                return true;
            case 27:
                C2538c.c("HandleMessageUtils", new Object[]{"RESPOND_BAND_BATTERY"});
                if (a == null || a.length <= 0) {
                    return true;
                }
                int i = a[0] & 255;
                if (this.f13861h == null) {
                    return true;
                }
                Intent intent2 = new Intent("com.fenda.hwbracelet.DEVICE_POWER");
                intent2.putExtra("com.fenda.hwbracelet.DEVICE_POWER", i);
                this.f13861h.sendBroadcast(intent2, "com.af500.permission.MYBRODCAST");
                return true;
            default:
                return false;
        }
    }

    private boolean m18133a(C4389a c4389a, C3603f c3603f) {
        C3602e b = c3603f.m18084b();
        byte[] a = m18134a(c3603f.m18083a().array());
        switch (C3616c.f13866a[b.ordinal()]) {
            case 4:
                C2538c.c("HandleMessageUtils", new Object[]{"SYNC_END"});
                if (a != null && a.length != 0) {
                    return true;
                }
                C2538c.c("HandleMessageUtils", new Object[]{"currentDayFinished."});
                C3581a.m17980n();
                C3574d.m17934a().m17940a(c4389a, this.f13859f, this.f13860g);
                return true;
            case 28:
                C2538c.c("HandleMessageUtils", new Object[]{"UPDATE_SINGLE_DATA"});
                if (C3574d.m17934a() == null) {
                    C3574d.m17936b();
                }
                return (a == null || a.length < 0 || C3574d.m17934a() == null || !C3574d.m17934a().m17942a(c4389a, a, this.f13859f, this.f13860g)) ? true : true;
            case 29:
                C2538c.c("HandleMessageUtils", new Object[]{"UPDATE_DATA"});
                if (a == null || a.length < 0) {
                    return true;
                }
                C3574d.m17934a().m17943a(a);
                return true;
            case 30:
                C2538c.c("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_STEPS"});
                if (a == null || a.length != 4) {
                    return true;
                }
                this.f13856c = ((((a[0] & 255) << 24) + ((a[1] & 255) << 16)) + ((a[2] & 255) << 8)) + (a[3] & 255);
                this.f13858e = m18128a(this.f13856c);
                if (this.f13857d == -1 || this.f13855b == null) {
                    return true;
                }
                C2538c.c("HandleMessageUtils", new Object[]{"onTotalDataReceived"});
                this.f13855b.mo4596a(new int[]{this.f13856c, this.f13857d, this.f13858e}, null);
                this.f13857d = -1;
                this.f13856c = -1;
                this.f13858e = -1;
                if (m18146d() == C3617d.STATE_NONE) {
                    C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_STEPS and getSyncState() == SyncState.STATE_NONE"});
                    m18148f();
                    return true;
                }
                C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_STEPS and getSyncState() != SyncState.STATE_NONE and getSyncState = " + m18146d()});
                return true;
            case 31:
                C2538c.c("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_CALORIE"});
                if (a == null || a.length != 4) {
                    return true;
                }
                C2538c.c("HandleMessageUtils", new Object[]{"onTotalDataReceived"});
                this.f13857d = ((((a[0] & 255) << 24) + ((a[1] & 255) << 16)) + ((a[2] & 255) << 8)) + (a[3] & 255);
                if (this.f13856c == -1 || this.f13855b == null) {
                    return true;
                }
                C2538c.c("HandleMessageUtils", new Object[]{"onTotalDataReceived"});
                this.f13855b.mo4596a(new int[]{this.f13856c, this.f13857d, this.f13858e}, null);
                this.f13857d = -1;
                this.f13856c = -1;
                this.f13858e = -1;
                if (m18146d() == C3617d.STATE_NONE) {
                    C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_CALORIE and getSyncState() == SyncState.STATE_NONE"});
                    m18148f();
                    return true;
                }
                C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_CALORIE and getSyncState() != SyncState.STATE_NONE"});
                return true;
            case 32:
                C2538c.c("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_STEPS_CALORIE"});
                if (this.f13855b == null || a == null || a.length != 8) {
                    return true;
                }
                C2538c.c("HandleMessageUtils", new Object[]{"onTotalDataReceived"});
                int i = ((((a[0] & 255) << 24) + ((a[1] & 255) << 16)) + ((a[2] & 255) << 8)) + (a[3] & 255);
                int i2 = (a[7] & 255) + ((((a[4] & 255) << 24) + ((a[5] & 255) << 16)) + ((a[6] & 255) << 8));
                int a2 = m18128a(i);
                C2538c.b("HandleMessageUtils", new Object[]{"totalSteps: " + i + ", totalCalorie: " + i2 + ", totalDistances: " + a2});
                this.f13855b.mo4596a(new int[]{i, i2, a2}, null);
                if (m18146d() == C3617d.STATE_NONE) {
                    C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_STEPS_CALORIE and getSyncState() == SyncState.STATE_NONE"});
                    m18148f();
                    return true;
                }
                C2538c.b("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_STEPS_CALORIE and getSyncState() != SyncState.STATE_NONE"});
                return true;
            case 33:
                C2538c.c("HandleMessageUtils", new Object[]{"RESPOND_TOTAL_SLEEP_TIME"});
                if (this.f13855b == null || a == null || a.length != 2) {
                    return true;
                }
                int i3 = ((a[0] & 255) << 8) + (a[1] & 255);
                return true;
            default:
                return false;
        }
    }

    private byte[] m18134a(byte[] bArr) {
        if (bArr.length > 1) {
            return Arrays.copyOfRange(bArr, 1, bArr.length);
        }
        return null;
    }

    private int m18128a(int i) {
        return (int) ((((float) this.f13859f) / BitmapDescriptorFactory.HUE_VIOLET) * ((float) i));
    }

    public void m18148f() {
        C2538c.b("HandleMessageUtils", new Object[]{"ready to sendSyncDataToApp"});
        this.f13864l = null;
        if (C3569e.m17917a(null) != null) {
            C2538c.b("HandleMessageUtils", new Object[]{"sendSyncDataToApp query the syncdata db"});
            this.f13864l = C3569e.m17917a(null).m17921b();
        }
        new Thread(new C3615b(this)).start();
        if (this.f13854a) {
            this.f13854a = false;
        }
    }
}
