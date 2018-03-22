package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.SystemClock;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1691i;
import java.util.UUID;

/* compiled from: BluetoothClassicConnectService */
class C1701f extends C1700i {
    public static final UUID f4510a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static C1701f f4511j;
    private static Object f4512l = new Object();
    private UUID f4513e = null;
    private C1702g f4514f;
    private Object f4515g = new Object();
    private C1703h f4516h;
    private Object f4517i = new Object();
    private Long f4518k = Long.valueOf(0);

    private C1701f(Context context) {
        super(context);
    }

    public static C1701f m8051a(Context context, C1690h c1690h) {
        C1701f c1701f;
        synchronized (f4512l) {
            if (f4511j == null) {
                f4511j = new C1701f(context);
            }
            f4511j.d = c1690h;
            c1701f = f4511j;
        }
        return c1701f;
    }

    public void mo2588a(BluetoothDevice bluetoothDevice, boolean z, int i, C1691i c1691i) {
        C2538c.m12674b("ClassicBTConnectService", " call connect() to dev: " + bluetoothDevice.getName());
        if (1 == C1700i.m8041a()) {
            C2538c.m12674b("ClassicBTConnectService", " the state is connecting need wait the resault");
            return;
        }
        synchronized (this.f4515g) {
            if (this.f4514f != null) {
                this.f4514f.m8066a();
                this.f4514f = null;
                this.f4518k = Long.valueOf(SystemClock.uptimeMillis());
            }
            this.f4514f = new C1702g(this, bluetoothDevice, z, i);
            this.f4514f.start();
        }
        synchronized (this.f4517i) {
            if (this.f4516h != null) {
                this.f4516h.m8067a();
                this.f4516h = null;
                this.f4518k = Long.valueOf(SystemClock.uptimeMillis());
            }
        }
        C2538c.m12674b("ClassicBTConnectService", " start new connect thread to device:*");
        if (1 != C1700i.m8041a()) {
            m8044a(1);
        }
    }

    public void m8062a(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice, String str) {
        C2538c.m12674b("ClassicBTConnectService", " connected, Socket Type:" + str);
        synchronized (this.f4515g) {
            if (this.f4514f != null) {
                this.f4514f.m8066a();
                this.f4514f = null;
            }
        }
        synchronized (this.f4517i) {
            if (this.f4516h != null) {
                this.f4516h.m8067a();
                this.f4516h = null;
            }
            this.f4516h = new C1703h(this, bluetoothSocket, str);
            this.f4516h.start();
        }
        if (2 != C1700i.m8041a()) {
            m8044a(2);
        }
    }

    public void mo2589a(boolean z) {
        C2538c.m12674b("ClassicBTConnectService", " stop");
        synchronized (this.f4515g) {
            if (this.f4514f != null) {
                this.f4514f.m8066a();
                this.f4514f = null;
                this.f4518k = Long.valueOf(SystemClock.uptimeMillis());
            }
        }
        synchronized (this.f4517i) {
            if (this.f4516h != null) {
                this.f4516h.m8067a();
                this.f4516h = null;
            }
        }
        synchronized (f4512l) {
            f4511j = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2590a(byte[] r7) {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = "ClassicBTConnectService";
        r1 = new java.lang.Object[r5];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = " write data enter, write to remote len: ";
        r2 = r2.append(r3);
        r3 = r7.length;
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1[r4] = r2;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r1 = r6.f4517i;
        monitor-enter(r1);
        r0 = com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.C1700i.m8041a();	 Catch:{ all -> 0x0040 }
        r2 = 2;
        if (r0 == r2) goto L_0x002b;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
    L_0x002a:
        return;
    L_0x002b:
        r0 = r6.f4516h;	 Catch:{ all -> 0x0040 }
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        if (r0 == 0) goto L_0x002a;
    L_0x0030:
        r0.m8068a(r7);
        r0 = "ClassicBTConnectService";
        r1 = new java.lang.Object[r5];
        r2 = "write packet finished";
        r1[r4] = r2;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        goto L_0x002a;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.a.a.d.f.a(byte[]):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2591a(byte[] r5, int r6) {
        /*
        r4 = this;
        r0 = "ClassicBTConnectService";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "  writeWithLen called";
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r1 = r4.f4517i;
        monitor-enter(r1);
        r0 = com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.C1700i.m8041a();	 Catch:{ all -> 0x0022 }
        r2 = 2;
        if (r0 == r2) goto L_0x0019;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
    L_0x0018:
        return;
    L_0x0019:
        r0 = r4.f4516h;	 Catch:{ all -> 0x0022 }
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0018;
    L_0x001e:
        r0.m8069a(r5, r6);
        goto L_0x0018;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.a.a.d.f.a(byte[], int):void");
    }

    private void m8056c() {
        C2538c.m12674b("ClassicBTConnectService", " connectionFailed() called.");
        if (3 != C1700i.m8041a()) {
            m8044a(3);
        }
    }

    private void m8059d() {
        C2538c.m12674b("ClassicBTConnectService", " connectionLost() called.");
        if (3 != C1700i.m8041a()) {
            m8044a(3);
        }
    }
}
