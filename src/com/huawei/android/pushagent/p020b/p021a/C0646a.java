package com.huawei.android.pushagent.p020b.p021a;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.b.a.a.a;
import com.huawei.android.pushagent.b.a.a.b;
import com.huawei.android.pushagent.p017a.C0642a;
import com.huawei.android.pushagent.p018c.p019a.C0656a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p020b.p022b.C0648a;
import com.huawei.android.pushagent.p020b.p022b.C0649c;
import java.util.LinkedList;
import java.util.List;

public class C0646a {
    private static C0646a f1160d = null;
    a f1161a = a.b;
    com.huawei.android.pushagent.b.a.a.a[] f1162b = new com.huawei.android.pushagent.b.a.a.a[a.values().length];
    private Context f1163c;

    private C0646a(Context context) {
        this.f1163c = context;
    }

    public static synchronized C0646a m2431a(Context context) {
        C0646a c0646a;
        synchronized (C0646a.class) {
            if (f1160d != null) {
                c0646a = f1160d;
            } else if (context == null) {
                C0657e.m2522d("PushLogAC2712", "when init ChannelMgr g_channelMgr and context all null!!");
                c0646a = null;
            } else {
                f1160d = new C0646a(context);
                f1160d.m2437g();
                c0646a = f1160d;
            }
        }
        return c0646a;
    }

    public static b m2432b(Context context) {
        return C0646a.m2431a(context).m2444d().e;
    }

    public static a m2433c() {
        return C0646a.m2431a(null).f1161a;
    }

    private static void m2434c(Context context) {
        C0657e.m2512a("PushLogAC2712", "enter cancelDelayAlarm");
        C0656a.m2506a(context, "com.huawei.action.CONNECT_PUSHSRV");
        C0656a.m2506a(context, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
        C0656a.m2504a(context, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", 2592000000L).setPackage(context.getPackageName()));
    }

    public static com.huawei.android.pushagent.b.a.a.a m2435e() {
        return C0646a.m2431a(null).f1162b[a.a.ordinal()];
    }

    public static com.huawei.android.pushagent.b.a.a.a m2436f() {
        return C0646a.m2431a(null).f1162b[a.b.ordinal()];
    }

    private boolean m2437g() {
        C0657e.m2512a("PushLogAC2712", "begin to init ChannelMgr");
        int a = C0649c.m2455a(this.f1163c, "curConnectEntity", a.b.ordinal());
        C0657e.m2512a("PushLogAC2712", "in cfg curConEntity:" + a);
        if (a >= 0 && a < a.values().length) {
            this.f1161a = a.values()[a];
        }
        if (a.b == this.f1161a && !C0648a.m2447a(this.f1163c).m2396X() && C0648a.m2447a(this.f1163c).m2395W()) {
            this.f1161a = a.a;
        }
        this.f1162b[a.a.ordinal()] = new com.huawei.android.pushagent.b.a.a.b.a(null, this.f1163c);
        this.f1162b[a.b.ordinal()] = new com.huawei.android.pushagent.b.a.a.a.a(null, this.f1163c);
        return true;
    }

    public List m2438a() {
        List linkedList = new LinkedList();
        for (com.huawei.android.pushagent.b.a.a.a aVar : this.f1162b) {
            if (aVar.e.c() != null) {
                linkedList.add(aVar.e.c());
            }
        }
        return linkedList;
    }

    public void m2439a(long j) {
        C0657e.m2512a("PushLogAC2712", "next connect pushsvr will be after " + j);
        Intent intent = new Intent("com.huawei.action.CONNECT_PUSHSRV");
        intent.setPackage(this.f1163c.getPackageName());
        C0656a.m2507b(this.f1163c, intent, j);
    }

    public void m2440a(Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("EXTRA_INTENT_TYPE");
        if ("com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT".equals(action)) {
            C0657e.m2517b("PushLogAC2712", "time out for wait heartbeat so reconnect");
            C0646a.m2432b(this.f1163c).c(true);
            m2444d().d();
            if (-1 != com.huawei.android.pushagent.c.a.b.a(this.f1163c) && C0646a.m2433c() == a.a) {
                try {
                    m2444d().a(false);
                } catch (Throwable e) {
                    C0657e.m2521c("PushLogAC2712", e.toString(), e);
                }
            }
        } else if ("com.huawei.intent.action.PUSH".equals(action) && "com.huawei.android.push.intent.HEARTBEAT_REQ".equals(stringExtra)) {
            if (-1 != com.huawei.android.pushagent.c.a.b.a(this.f1163c)) {
                com.huawei.android.pushagent.b.a.a.a d = m2444d();
                if (d.a()) {
                    d.e.a(true);
                    d.e.g();
                    return;
                }
                PushService.m2357a(new Intent("com.huawei.action.CONNECT_PUSHSRV").setPackage(this.f1163c.getPackageName()));
                return;
            }
            C0657e.m2522d("PushLogAC2712", "when send heart beat, not net work");
            C0646a.m2432b(this.f1163c).b();
        } else if (!"com.huawei.android.push.intent.REFRESH_PUSH_CHANNEL".equals(action) && !"android.intent.action.TIME_SET".equals(action) && !"android.intent.action.TIMEZONE_CHANGED".equals(action)) {
        } else {
            if (m2444d().a()) {
                C0646a.m2432b(this.f1163c).a(false);
                C0646a.m2432b(this.f1163c).g();
            } else if (-1 != com.huawei.android.pushagent.c.a.b.a(this.f1163c)) {
                C0657e.m2512a("PushLogAC2712", "received " + action + ", but not Connect, go to connect!");
                PushService.m2357a(new Intent("com.huawei.action.CONNECT_PUSHSRV"));
            } else {
                C0657e.m2517b("PushLogAC2712", "no net work, when recevice :" + action + ", do nothing");
            }
        }
    }

    public void m2441a(a aVar) {
        this.f1161a = aVar;
        if (a.b == aVar && !C0648a.m2447a(this.f1163c).m2396X() && C0648a.m2447a(this.f1163c).m2395W()) {
            aVar = a.a;
        }
        C0649c.m2460a(this.f1163c, new C0642a("curConnectEntity", Integer.class, Integer.valueOf(aVar.ordinal())));
    }

    public void m2442a(a aVar, boolean z) {
        C0657e.m2522d("PushLogAC2712", "enter ChannelMgr:connect(entity" + aVar + ", forceCon" + z + ")");
        if (aVar != null) {
            try {
                this.f1162b[aVar.ordinal()].a(z);
                return;
            } catch (Throwable e) {
                C0657e.m2521c("PushLogAC2712", e.toString(), e);
                return;
            }
        }
        C0657e.m2522d("PushLogAC2712", "entityMode is invalid!!");
    }

    public void m2443b() {
        C0646a.m2434c(this.f1163c);
        for (com.huawei.android.pushagent.b.a.a.a d : this.f1162b) {
            d.d();
        }
    }

    public com.huawei.android.pushagent.b.a.a.a m2444d() {
        C0657e.m2512a("PushLogAC2712", "enter getCurConnetEntity(curConnectType:" + this.f1161a + ", ordinal:" + this.f1161a.ordinal() + " curConnect:" + this.f1162b[this.f1161a.ordinal()].getClass().getSimpleName() + ")");
        if (a.b == this.f1161a && !C0648a.m2447a(this.f1163c).m2396X() && C0648a.m2447a(this.f1163c).m2395W()) {
            C0657e.m2512a("PushLogAC2712", "polling srv is not ready, push is ok, so change it to Push");
            this.f1161a = a.a;
        }
        return this.f1162b[this.f1161a.ordinal()];
    }
}
