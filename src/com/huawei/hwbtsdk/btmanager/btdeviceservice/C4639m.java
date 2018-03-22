package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p057b.p058a.C4622e;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceBRService */
public class C4639m implements C0959q {
    private static C4641o f16960c;
    private static final Object f16961d = new Object();
    private static C4642p f16962e;
    private static final Object f16963f = new Object();
    private BluetoothDevice f16964a = null;
    private C0958f f16965b = null;
    private int f16966g;
    private boolean f16967h = false;
    private DeviceInfo f16968i = new DeviceInfo();
    private C4600d f16969j = null;
    private int f16970k = -1;
    private C4622e f16971l = new C4640n(this);

    public C4639m(Context context, BluetoothDevice bluetoothDevice, C0958f fVar, int i) {
        this.f16964a = bluetoothDevice;
        this.f16965b = fVar;
        this.f16969j = C4600d.m21899a();
        this.f16968i.setDeviceBTType(1);
        this.f16970k = i;
    }

    private void m22234b(BluetoothDevice bluetoothDevice) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter connectBTDeviceThread()."});
        synchronized (C4639m.m22244i()) {
            if (f16960c != null) {
                f16960c.m22260a();
                f16960c = null;
            }
            C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Start ConnectThread."});
            f16960c = new C4641o(this, bluetoothDevice);
            f16960c.start();
        }
        synchronized (C4639m.m22242h()) {
            if (f16962e != null) {
                f16962e.m22263a();
                f16962e = null;
            }
        }
    }

    public void m22246a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"btDevice is null."});
            return;
        }
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Start to report connecting state."});
        m22245a(1);
        if (12 != bluetoothDevice.getBondState()) {
            C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Need to pair btDevice."});
            if (!this.f16969j.m21936a(bluetoothDevice, this.f16971l)) {
                C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"btDevice pair failed, so connect btDevice fail."});
                m22245a(4);
                return;
            }
            return;
        }
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Do not need to pair btDevice, so connect btDevice directly."});
        m22234b(bluetoothDevice);
    }

    private void m22230a(BluetoothSocket bluetoothSocket) {
        synchronized (C4639m.m22242h()) {
            if (f16962e != null) {
                f16962e.m22263a();
                f16962e = null;
            }
            f16962e = new C4642p(this, bluetoothSocket);
            f16962e.start();
        }
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Connect success, so report state."});
        m22245a(2);
    }

    private void m22229a() {
        m22245a(3);
    }

    private void m22236c() {
        m22245a(4);
    }

    protected synchronized void m22245a(int i) {
        if (i != this.f16966g) {
            this.f16966g = i;
            if (this.f16965b != null) {
                C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"report connect state = " + i});
                if (this.f16968i != null) {
                    this.f16968i.setDeviceName(this.f16964a.getName());
                    this.f16968i.setDeviceIdentify(this.f16964a.getAddress());
                    this.f16965b.a(this.f16968i, this.f16966g);
                }
            }
        }
    }

    public void m22250b() {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter disconnectBTDevice."});
        synchronized (C4639m.m22244i()) {
            if (f16960c != null) {
                f16960c.m22260a();
                f16960c = null;
            }
        }
        synchronized (C4639m.m22242h()) {
            if (f16962e != null) {
                f16962e.m22263a();
                f16962e = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m22249a(byte[] r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        monitor-enter(r7);
        r2 = 2;
        r3 = r7.f16966g;	 Catch:{ all -> 0x0033 }
        if (r2 == r3) goto L_0x001a;
    L_0x0008:
        r1 = "01";
        r2 = 1;
        r3 = "BTDeviceBRService";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0033 }
        r5 = 0;
        r6 = "Connect State is not connect.";
        r4[r5] = r6;	 Catch:{ all -> 0x0033 }
        com.huawei.v.c.b(r1, r2, r3, r4);	 Catch:{ all -> 0x0033 }
        monitor-exit(r7);	 Catch:{ all -> 0x0033 }
    L_0x0019:
        return r0;
    L_0x001a:
        monitor-exit(r7);	 Catch:{ all -> 0x0033 }
        r2 = com.huawei.hwbtsdk.btmanager.btdeviceservice.C4639m.m22242h();
        monitor-enter(r2);
        r3 = f16962e;	 Catch:{ all -> 0x0036 }
        monitor-exit(r2);	 Catch:{ all -> 0x0036 }
        if (r3 != 0) goto L_0x0039;
    L_0x0025:
        r2 = "01";
        r3 = "BTDeviceBRService";
        r4 = new java.lang.Object[r1];
        r5 = "dataTransferThread is null.";
        r4[r0] = r5;
        com.huawei.v.c.b(r2, r1, r3, r4);
        goto L_0x0019;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0036 }
        throw r0;
    L_0x0039:
        r3.m22262a(r8);
        r0 = r1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwbtsdk.btmanager.btdeviceservice.m.a(byte[]):boolean");
    }

    public DeviceInfo m22253d() {
        return this.f16968i;
    }

    public void m22251b(int i) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter btSwitchChangeInfo() with status = " + i});
    }

    public void m22248a(String str) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter sendBTFilePath in br."});
    }

    public void m22247a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter setFileCallback in br."});
    }

    private static synchronized Object m22242h() {
        Object obj;
        synchronized (C4639m.class) {
            obj = f16963f;
        }
        return obj;
    }

    private static synchronized Object m22244i() {
        Object obj;
        synchronized (C4639m.class) {
            obj = f16961d;
        }
        return obj;
    }

    public void m22254e() {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"start to disconnectGMS in br."});
    }

    public void m22255f() {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"start to removeV1CheckCommand in br."});
    }

    public void m22252c(int i) {
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter setPathExtendNum in br with pathExtendNum = " + i});
    }

    public int m22256g() {
        int i;
        synchronized (this) {
            i = this.f16966g;
        }
        return i;
    }
}
