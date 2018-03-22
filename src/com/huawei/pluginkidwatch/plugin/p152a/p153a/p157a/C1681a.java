package com.huawei.pluginkidwatch.plugin.p152a.p153a.p157a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1685c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.C1695a;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.C1699e;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.ak;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.am;

@SuppressLint({"UseSparseArrays"})
/* compiled from: KwApi */
public class C1681a {
    private static C1681a f4422a = null;
    private BluetoothAdapter f4423b = null;
    private Context f4424c = null;
    private int f4425d = -1;
    private am f4426e = null;

    private C1681a(Context context) {
        C2538c.m12674b("KwApi", "Api instance with Context = " + context);
        this.f4424c = context;
        synchronized (this) {
            C1695a.m7891a(context, this.f4423b);
        }
    }

    private C1681a() {
    }

    public static C1681a m7837a(Context context) {
        if (context != null) {
            synchronized (C1681a.class) {
                if (f4422a == null) {
                    f4422a = new C1681a(context);
                }
            }
        }
        return f4422a;
    }

    public void m7842a(int i) {
        C2538c.m12664a("KwApi", "Enter initDeviceByType() deviceType = " + i);
        this.f4425d = i;
        m7840d();
        C2538c.m12664a("KwApi", "End initDeviceByType()");
    }

    public void m7845a(int i, C1685c c1685c) {
        C2538c.m12664a("KwApi", "Enter registerDeviceConnectStatusCallback()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a != null) {
                a.mo2580a(c1685c);
                return;
            }
            C2538c.m12664a("KwApi", "deviceManager is null");
            return;
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
    }

    public void m7850b(int i, C1685c c1685c) {
        C2538c.m12664a("KwApi", "Enter unregisterDeviceConnectStatusCallback()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a != null) {
                a.mo2584b(c1685c);
                return;
            }
            C2538c.m12664a("KwApi", "deviceManager is null");
            return;
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
    }

    public void m7843a(int i, BluetoothDevice bluetoothDevice) {
        C2538c.m12664a("KwApi", "Enter connectDevice() with deviceType & bluetoothDevice");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a != null) {
                a.mo2578a(bluetoothDevice);
                return;
            }
            C2538c.m12664a("KwApi", "deviceManager is null");
            return;
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
    }

    public void m7849b(int i) {
        C2538c.m12664a("KwApi", "Enter disconnectDevice()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a == null) {
                C2538c.m12664a("KwApi", "deviceManager is null");
                return;
            } else if (m7838a(a)) {
                a.mo2576a();
                return;
            } else {
                return;
            }
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
    }

    public void m7847a(C1620b c1620b, int i) {
        C2538c.m12664a("KwApi", "Enter turnOnLostAlert()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a == null) {
                C2538c.m12664a("KwApi", "deviceManager is null");
                c1620b.mo2554a(10, "device not supported");
                return;
            } else if (m7838a(a)) {
                a.mo2579a(c1620b, i);
                return;
            } else {
                C2538c.m12664a("KwApi", "device not connect");
                c1620b.mo2554a(12, "device not supported");
                return;
            }
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
        c1620b.mo2554a(10, "device not supported");
    }

    private am m7839c() {
        C2538c.m12674b("KwApi", "HUAWEI_BT_BLE constructed");
        return C1699e.m8039a(this.f4424c, this.f4425d);
    }

    private synchronized am m7840d() {
        C2538c.m12674b("KwApi", "Enter getWearableDevice()");
        if (this.f4426e == null) {
            this.f4426e = m7839c();
        }
        if (this.f4426e != null && this.f4423b == null) {
            this.f4423b = BluetoothAdapter.getDefaultAdapter();
        }
        C2538c.m12674b("KwApi", "Leave getWearableDevice()");
        return this.f4426e;
    }

    private boolean m7838a(ak akVar) {
        if (akVar == null) {
            C2538c.m12664a("KwApi", "isDeviceConnected() deviceManager is null ");
            return false;
        }
        int b = akVar.mo2583b();
        C2538c.m12664a("KwApi", "isDeviceConnected() status = " + b);
        if (4 == this.f4425d) {
            if (b == 0 || 3 == b) {
                return false;
            }
            return true;
        } else if (2 == b) {
            return true;
        } else {
            return false;
        }
    }

    public void m7848a(C1686d c1686d, int i) {
        C2538c.m12664a("KwApi", "Enter searchBluetoothDevice()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a != null) {
                a.mo2581a(c1686d, i);
                return;
            }
            C2538c.m12664a("KwApi", "deviceManager is null");
            c1686d.mo2572a(10, "device not supported");
            return;
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
        c1686d.mo2572a(10, "device not supported");
    }

    public void m7841a() {
        C2538c.m12664a("KwApi", "Enter cancelSearchBluetoothDevice() ");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a != null) {
                a.mo2585c();
                return;
            }
            C2538c.m12664a("KwApi", "deviceManager is null");
            return;
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
    }

    public void m7846a(int i, byte[] bArr, C1620b c1620b) {
        C2538c.m12674b("KwApi", "Enter writeAuthenticationCharacteristic()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a == null) {
                C2538c.m12664a("KwApi", "deviceManager is null");
                c1620b.mo2554a(10, "device not supported");
                return;
            } else if (m7838a(a)) {
                a.mo2582a(bArr, i, c1620b);
                return;
            } else {
                C2538c.m12664a("KwApi", "device not connect");
                c1620b.mo2554a(12, "device not supported");
                return;
            }
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
        c1620b.mo2554a(10, "device not supported");
    }

    public void m7844a(int i, C1620b c1620b) {
        C2538c.m12674b("KwApi", "Enter writeDataToLinkLossCharacteristic()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a == null) {
                C2538c.m12664a("KwApi", "deviceManager is null");
                c1620b.mo2554a(10, "device not supported");
                return;
            } else if (m7838a(a)) {
                a.mo2577a(i, c1620b);
                return;
            } else {
                C2538c.m12664a("KwApi", "device not connect");
                c1620b.mo2554a(12, "device not supported");
                return;
            }
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
        c1620b.mo2554a(10, "device not supported");
    }

    public boolean m7851b() {
        C2538c.m12674b("KwApi", "Enter enableBluetooth()");
        if (this.f4426e != null) {
            ak a = this.f4426e.mo2587a();
            if (a == null) {
                C2538c.m12664a("KwApi", "deviceManager is null");
                return false;
            } else if (m7838a(a)) {
                return a.mo2586d();
            } else {
                C2538c.m12664a("KwApi", "device not connect");
                return false;
            }
        }
        C2538c.m12664a("KwApi", "mBTDeviceMgr is null");
        return false;
    }
}
