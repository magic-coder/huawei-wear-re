package com.fenda.hwbracelet.p263f;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.fenda.hwbracelet.connection.C3583l;
import com.fenda.hwbracelet.connection.C3584a;
import com.fenda.hwbracelet.connection.C3595m;
import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.p260c.C3581a;
import com.fenda.hwbracelet.p262e.C3598a;
import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3601d;
import com.fenda.hwbracelet.p267g.C3614a;
import com.huawei.p032e.p264a.p265a.p266b.C4385a;
import com.huawei.p032e.p264a.p265a.p266b.C4386b;
import com.huawei.p032e.p264a.p265a.p266b.C4387c;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;

import java.util.concurrent.Executors;

/* compiled from: XbService */
public class C3609e implements C3595m {
    private static C3609e f13832b;
    C4387c f13833a;
    private C3584a f13834c;
    private int f13835d = -50;
    private boolean f13836e = false;
    private boolean f13837f = false;
    private C3613i f13838g = C3613i.IDLE;
    private Context f13839h;
    private BluetoothDevice f13840i;
    private C4389a f13841j;
    private C4385a f13842k = null;
    private C4386b f13843l = null;
    private BroadcastReceiver f13844m = new C3611g(this);
    private Handler f13845n = new Handler(new C3612h(this));

    public static C3609e m18112a(Context context) {
        C3609e c3609e;
        synchronized (C3609e.class) {
            C2538c.c("XbService", new Object[]{"instance == null"});
            if (f13832b == null && context != null) {
                f13832b = new C3609e(context);
                C2538c.c("XbService", new Object[]{"null == instance"});
            }
            c3609e = f13832b;
        }
        return c3609e;
    }

    public void m18117a() {
        this.f13836e = true;
    }

    private C3609e(Context context) {
        this.f13839h = context;
        this.f13834c = new C3584a(this.f13839h);
        this.f13834c.m18039a((C3595m) this);
        if (context != null) {
            Executors.newSingleThreadExecutor().execute(new C3610f(this, context));
            IntentFilter intentFilter = new IntentFilter("com.fenda.hwbracelet.INTENT_START_RSSI");
            intentFilter.addAction("com.fenda.hwbracelet.INTENT_STOP_RSSI");
            intentFilter.addAction("com.fenda.hwbracelet.intent.prevent.reconnect");
            context.registerReceiver(this.f13844m, intentFilter, "com.af500.permission.MYBRODCAST", null);
        }
    }

    public void m18119a(BluetoothDevice bluetoothDevice, C4387c c4387c) {
        if (c4387c == null) {
            C2538c.e("XbService", new Object[]{"HealthDeviceCallback is null."});
            return;
        }
        this.f13833a = c4387c;
        this.f13834c.m18041a(bluetoothDevice);
        this.f13840i = bluetoothDevice;
    }

    public void m18123a(C4389a c4389a) {
        C2538c.c("XbService", new Object[]{"setOnSyncDataListener"});
        this.f13841j = c4389a;
        C3614a.m18129a().m18142a(c4389a);
    }

    public void m18122a(C4387c c4387c) {
        this.f13833a = c4387c;
    }

    public void mo4229a(C3583l c3583l) {
        C2538c.b("XbService", new Object[]{"xwservice connection established"});
        this.f13838g = C3613i.IDLE;
        m18118a(3);
        this.f13834c.m18038a(this.f13845n);
        this.f13834c.m18042a(C3601d.m18065a().m18076c());
        m18121a((C3600c) C3601d.m18065a().m18075b());
        C3614a.m18129a().m18144b();
        C3581a.m17973g();
        C3581a.m17974h();
        C3581a.m17965b(false);
        C3581a.m17975i();
        if (this.f13833a != null) {
            this.f13833a.mo5110a(2);
        }
        C3581a.m17953a(this.f13839h);
    }

    public void mo4230b(C3583l c3583l) {
        C2538c.e("XbService", new Object[]{"xbservice connection lost"});
        m18118a(0);
        this.f13836e = true;
        this.f13840i = null;
        if (this.f13841j != null && C3614a.m18129a().m18147e()) {
            C3614a.m18129a().m18143a(false);
            this.f13841j.mo4597a(-1);
        }
        if (this.f13833a != null) {
            this.f13833a.mo5110a(3);
        }
    }

    public void mo4231c(C3583l c3583l) {
        m18118a(2);
        if (this.f13833a != null) {
            this.f13833a.mo5110a(1);
        }
    }

    public void m18118a(int i) {
        Intent intent = new Intent("com.fenda.hwbracelet.CONNECTION_STATE");
        intent.putExtra("com.fenda.hwbracelet.XB_CONNECTION_STATE", i);
        if (this.f13839h != null) {
            this.f13839h.sendBroadcast(intent, "com.af500.permission.MYBRODCAST");
        }
    }

    private void m18115c() {
        C2538c.c("XbService", new Object[]{"prevent reconnect"});
        if (this.f13834c != null) {
            this.f13834c.m18047e();
        }
    }

    public void m18121a(C3600c c3600c) {
        if (C3596n.m18054a() == 3) {
            if (c3600c == null) {
                C2538c.e("XbService", new Object[]{"failed to send null message"});
            } else if (!this.f13834c.m18042a((C3598a) c3600c)) {
                C2538c.e("XbService", new Object[]{"failed to send message "});
            }
        }
    }

    public void m18124a(byte[] bArr) {
        if (C3596n.m18054a() == 3 && !this.f13834c.m18043a(bArr)) {
            C2538c.e("XbService", new Object[]{"failed to send message "});
        }
    }

    public void m18125b() {
        C2538c.c("XbService", new Object[]{"disconnect BT"});
        C3581a.m17950a();
        if (this.f13834c != null) {
            C2538c.b("XbService", new Object[]{"XbService: Start to disconnect AF500."});
            this.f13834c.m18045c();
            return;
        }
        C2538c.b("XbService", new Object[]{"XbService: mConnectionManager is null."});
    }
}
