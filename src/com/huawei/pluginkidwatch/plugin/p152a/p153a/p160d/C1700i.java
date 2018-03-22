package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1691i;

/* compiled from: BluetoothConnectServiceBase */
public abstract class C1700i {
    private static int f4505a;
    private static int f4506e;
    protected Context f4507b;
    protected BluetoothAdapter f4508c = BluetoothAdapter.getDefaultAdapter();
    protected C1690h f4509d;

    public abstract void mo2588a(BluetoothDevice bluetoothDevice, boolean z, int i, C1691i c1691i);

    public abstract void mo2589a(boolean z);

    public abstract void mo2590a(byte[] bArr);

    public abstract void mo2591a(byte[] bArr, int i);

    public C1700i(Context context) {
        this.f4507b = context;
        C1700i.m8043c(0);
        C2538c.m12674b("BTConnectServiceBase", "mState初始化：" + f4505a);
        this.f4509d = null;
    }

    protected void m8044a(int i) {
        C2538c.m12674b("BTConnectServiceBase", "setState() " + f4505a + " -> " + i);
        synchronized (this) {
            C1700i.m8043c(i);
            m8050b(i);
            this.f4509d.mo2568a(i);
        }
    }

    protected void m8050b(int i) {
        C2538c.m12674b("BTConnectServiceBase", "setMmstate() " + f4506e + " -> " + i);
        synchronized (this) {
            f4506e = i;
        }
    }

    public static int m8041a() {
        C2538c.m12674b("BTConnectServiceBase", "getState() " + f4505a + " -> " + f4505a);
        return f4505a;
    }

    public static int m8042b() {
        C2538c.m12674b("BTConnectServiceBase", "getMmstate() " + f4506e + " -> " + f4506e);
        return f4506e;
    }

    public void mo2592a(byte[] bArr, C1620b c1620b) {
    }

    protected static void m8043c(int i) {
        f4505a = i;
    }
}
