package com.huawei.android.pushagent.p020b.p022b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.b.b.b;
import com.huawei.android.pushagent.b.d.a;
import com.huawei.android.pushagent.p017a.C0642a;
import com.huawei.android.pushagent.p017a.C0644e;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p018c.p019a.C0659h;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.net.InetSocketAddress;
import java.util.Date;

public class C0648a extends C0644e {
    private static C0648a f1164g = null;
    public boolean f1165a = false;
    private Thread f1166e = null;
    private long f1167f = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;

    public C0648a(Context context) {
        super(context);
        af();
    }

    public static synchronized C0648a m2447a(Context context) {
        C0648a c0648a;
        synchronized (C0648a.class) {
            if (f1164g == null) {
                f1164g = new C0648a(context);
            }
            c0648a = f1164g;
        }
        return c0648a;
    }

    private synchronized boolean ah() {
        boolean z;
        if (ai()) {
            C0657e.m2512a("PushLogSC2712", " trsQuery thread already running, just wait!!");
            z = false;
        } else {
            this.f1166e = new b(this, "PushTRSQuery");
            this.f1166e.start();
            C0649c.m2460a(this.d, new C0642a("lastQueryTRSTime", Long.class, Long.valueOf(System.currentTimeMillis())));
            C0649c.m2460a(this.d, new C0642a("queryTrsTimes", Long.class, Long.valueOf(C0649c.m2456a(this.d, "queryTrsTimes", 0) + 1)));
            z = true;
        }
        return z;
    }

    private synchronized boolean ai() {
        boolean z;
        z = this.f1166e != null && this.f1166e.isAlive();
        return z;
    }

    public static void m2450b(Context context) {
        if (f1164g != null) {
            f1164g.m2368a("pushSrvValidTime", (Object) Integer.valueOf(0));
            f1164g.f1165a = true;
        }
    }

    private boolean m2451b(C0644e c0644e) {
        if (c0644e == null || !c0644e.m2394V()) {
            C0657e.m2522d("PushLogSC2712", "in PushSrvInfo:trsRetInfo, trsRetInfo is null or invalid:" + c0644e);
            return false;
        }
        C0657e.m2517b("PushLogSC2712", "queryTrs success!");
        if (!m2401a(c0644e)) {
            C0657e.m2512a("PushLogSC2712", "heart beat range change.");
            PushService.m2357a(new Intent("com.huawei.android.push.intent.HEARTBEAT_RANGE_CHANGE"));
        }
        if (c0644e.c.containsKey("USE_SSL")) {
            C0649c.m2460a(null, new C0642a("USE_SSL", Integer.class, Integer.valueOf(((Integer) c0644e.c.get("USE_SSL")).intValue())));
        }
        if (c0644e.c.containsKey("forbiddenMultiChannel")) {
            int intValue = ((Integer) c0644e.c.get("forbiddenMultiChannel")).intValue();
            C0657e.m2517b("PushLogSC2712", "forbiddenMultiChannel:" + intValue);
            new C0659h(this.d, "pushConfig").m2532a("forbiddenMultiChannel", Integer.valueOf(intValue));
        }
        if (!m2402a(c0644e.m2403b())) {
            C0657e.m2517b("PushLogSC2712", "belongId changed, need to reRegisterDeviceToken");
            com.huawei.android.pushagent.b.e.b.c(this.d);
        }
        this.c.putAll(c0644e.c);
        m2368a("pushSrvValidTime", (Object) Long.valueOf((m2410f() * 1000) + System.currentTimeMillis()));
        this.f1167f = m2421q() * 1000;
        C0649c.m2460a(this.d, new C0642a("queryTrsTimes", Integer.class, Integer.valueOf(0)));
        C0657e.m2512a("PushLogSC2712", "write the lastQueryTRSsucc_time to the pushConfig.xml file ");
        C0649c.m2460a(this.d, new C0642a("lastQueryTRSsucc_time", Long.class, Long.valueOf(System.currentTimeMillis())));
        this.f1165a = false;
        this.c.remove("PushID");
        ag();
        com.huawei.android.pushagent.b.d.b.a(this.d).a(this.d, com.huawei.android.pushagent.b.d.b.b.c, new Bundle());
        if (C0660a.m2595r(this.d).equals(this.d.getPackageName()) || !C0660a.m2596s(this.d)) {
            PushService.m2357a(new Intent("com.huawei.android.push.intent.TRS_QUERY_SUCCESS").putExtra("trs_result", c0644e.toString()));
        } else {
            C0657e.m2512a("PushLogSC2712", "need not current " + this.d.getPackageName() + " to depose, so exit");
            C0660a.m2562a(this.d, false);
            boolean e = new C0659h(this.d, "pclient_request_info").m2545e(this.d.getPackageName());
            C0660a.m2560a(this.d, 3);
            if (e) {
                PushReceiver.getToken(this.d);
            }
            PushService.m2359b();
        }
        return true;
    }

    public InetSocketAddress m2452a(boolean z) {
        boolean c = m2454c(z);
        if (!m2394V() || c) {
            C0657e.m2512a("PushLogSC2712", "in getPushSrvAddr, have no invalid addr");
            return null;
        }
        C0657e.m2517b("PushLogSC2712", "return valid PushSrvAddr");
        return new InetSocketAddress(m2405c(), m2407d());
    }

    public InetSocketAddress m2453b(boolean z) {
        boolean c = m2454c(z);
        if (!m2396X() || c) {
            C0657e.m2522d("PushLogSC2712", "in getPollingAddr, have no invalid addr");
            return null;
        }
        C0657e.m2517b("PushLogSC2712", "return valid PollingSrvAddr");
        return new InetSocketAddress(m2375C(), m2376D());
    }

    public boolean m2454c(boolean z) {
        if (ai()) {
            C0657e.m2512a("PushLogSC2712", "trsQuery thread is running");
            return true;
        }
        long a = C0649c.m2456a(this.d, "lastQueryTRSTime", 0);
        long a2 = C0649c.m2456a(this.d, "lastQueryTRSsucc_time", 0);
        C0657e.m2512a("PushLogSC2712", "isvalid:" + m2394V() + " srvValidBefore:" + (m2369b("pushSrvValidTime", Long.MAX_VALUE) - System.currentTimeMillis()) + " pushSrvNeedQueryTRS:" + this.f1165a);
        if (m2394V() && !this.f1165a && m2369b("pushSrvValidTime", Long.MAX_VALUE) >= System.currentTimeMillis() && System.currentTimeMillis() > a2) {
            C0657e.m2512a("PushLogSC2712", " need not query TRS");
            return false;
        } else if (-1 == com.huawei.android.pushagent.c.a.b.a(this.d)) {
            C0657e.m2512a("PushLogSC2712", "in queryTRSInfo no network");
            return false;
        } else {
            if (z) {
                C0657e.m2512a("PushLogSC2712", "Force to Connect TRS");
            } else if (System.currentTimeMillis() - a2 < m2409e() * 1000 && System.currentTimeMillis() > a2) {
                C0657e.m2512a("PushLogSC2712", "can not contect TRS Service when  the connect more than " + m2409e() + " sec last contected success time," + "lastQueryTRSsucc_time = " + new Date(a2));
                return false;
            } else if (System.currentTimeMillis() - a < this.f1167f && System.currentTimeMillis() > a) {
                C0657e.m2512a("PushLogSC2712", "can't connect TRS Service when the connectting time more later " + (this.f1167f / 1000) + "sec than  last contectting time,lastQueryTRSTime =" + new Date(a));
                return false;
            } else if (C0649c.m2456a(this.d, "queryTrsTimes", 0) > m2424t()) {
                this.f1167f = m2422r() * 1000;
            }
            return (C0649c.m2461a(this.d, "cloudpush_isNoDelayConnect", false) || a.a(this.d)) ? ah() : false;
        }
    }
}
