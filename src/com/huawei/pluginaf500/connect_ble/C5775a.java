package com.huawei.pluginaf500.connect_ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.p261d.C3597a;
import com.fenda.hwbracelet.p263f.C3604a;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p032e.p264a.p265a.p266b.C3605d;
import com.huawei.p032e.p264a.p265a.p266b.C4386b;
import com.huawei.p032e.p264a.p265a.p266b.C4387c;
import com.huawei.p032e.p264a.p265a.p266b.C4388e;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.ui.C5795f;
import com.huawei.pluginaf500.utils.C5821d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AF500DeviceMgr */
public class C5775a {
    private static C5775a f19598b = null;
    private static Map<String, DeviceInfo> f19599j = new HashMap();
    private static final Object f19600k = new Object();
    private Context f19601a;
    private C3605d f19602c = null;
    private BluetoothAdapter f19603d = null;
    private String f19604e = "";
    private List<C3597a> f19605f = new ArrayList();
    private boolean f19606g = false;
    private HandlerThread f19607h = new HandlerThread("AF500DeviceMgr");
    private C5780f f19608i = null;
    private C4387c f19609l = new C5776b(this);
    private BroadcastReceiver f19610m = new C5779e(this);

    private C5775a(Context context) {
        this.f19601a = context;
        this.f19603d = BluetoothAdapter.getDefaultAdapter();
        this.f19602c = C3604a.m18086a(this.f19601a);
        this.f19602c.mo4223a(this.f19609l);
        this.f19607h.start();
        this.f19608i = new C5780f(this.f19607h.getLooper());
        this.f19601a.registerReceiver(this.f19610m, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    public static C5775a m26544a(Context context) {
        C5775a c5775a;
        synchronized (f19600k) {
            if (f19598b == null) {
                f19598b = new C5775a(context);
            }
            c5775a = f19598b;
        }
        return c5775a;
    }

    public void m26557a(String str, C5795f c5795f) {
        if (this.f19603d != null && !TextUtils.isEmpty(str)) {
            BluetoothDevice remoteDevice = this.f19603d.getRemoteDevice(str);
            if (remoteDevice != null) {
                if (c5795f != null) {
                    c5795f.mo5119b(true);
                }
                m26558a(true);
                if (TextUtils.isEmpty(this.f19604e)) {
                    if (c5795f != null) {
                        c5795f.mo5118a(false);
                    }
                    this.f19604e = str;
                    m26546a(1);
                    this.f19602c.mo4221a(remoteDevice);
                } else if (!this.f19604e.equalsIgnoreCase(str)) {
                    if (c5795f != null) {
                        c5795f.mo5118a(true);
                    }
                    this.f19602c.mo4218a();
                    m26546a(1);
                    this.f19608i.postDelayed(new C5777c(this, str, remoteDevice), 6000);
                } else if (3 == C3596n.m18054a()) {
                    m26546a(2);
                } else if (C3596n.m18054a() == 0) {
                    C2538c.c("AF500DeviceMgr", new Object[]{"Start to connect device with XwConnection.STATE_NONE."});
                    if (this.f19603d != null && 12 == this.f19603d.getState()) {
                        m26546a(1);
                        this.f19608i.postDelayed(new C5778d(this, remoteDevice), 2000);
                    }
                }
            } else if (c5795f != null) {
                c5795f.mo5119b(false);
            }
        } else if (c5795f != null) {
            c5795f.mo5119b(false);
        }
    }

    public void m26552a() {
        C2538c.c("AF500DeviceMgr", new Object[]{"Enter disconnectAF500Device()."});
        if (this.f19602c != null) {
            this.f19602c.mo4218a();
        }
    }

    private Object m26550f() {
        List list;
        synchronized (f19600k) {
            list = this.f19605f;
        }
        return list;
    }

    public void m26554a(C3597a c3597a) {
        if (c3597a != null && !this.f19605f.contains(c3597a)) {
            synchronized (m26550f()) {
                this.f19605f.add(c3597a);
                C2538c.c("AF500DeviceMgr", new Object[]{"Reg mAF500DeviceStateCallbackList size = " + this.f19605f.size()});
            }
        }
    }

    public void m26561b(C3597a c3597a) {
        if (c3597a != null && this.f19605f.contains(c3597a)) {
            synchronized (m26550f()) {
                this.f19605f.remove(c3597a);
                C2538c.c("AF500DeviceMgr", new Object[]{"UnReg mAF500DeviceStateCallbackList size = " + this.f19605f.size()});
            }
        }
    }

    public String m26560b() {
        return this.f19604e;
    }

    public void m26559a(byte[] bArr) {
        if (this.f19602c != null) {
            this.f19602c.mo4226a(bArr);
        }
    }

    public boolean m26562c() {
        if (TextUtils.isEmpty(this.f19604e) || this.f19602c == null) {
            return false;
        }
        BluetoothDevice remoteDevice = this.f19603d.getRemoteDevice(this.f19604e);
        if (remoteDevice == null) {
            return false;
        }
        this.f19602c.mo4221a(remoteDevice);
        return true;
    }

    public int m26563d() {
        if (3 == C3596n.m18054a()) {
            return 2;
        }
        if (2 == C3596n.m18054a()) {
            return 1;
        }
        if (C3596n.m18054a() == 0) {
            return 3;
        }
        return 0;
    }

    public void m26558a(boolean z) {
        this.f19606g = z;
    }

    public boolean m26564e() {
        return this.f19606g;
    }

    private static Object m26551g() {
        Map map;
        synchronized (f19600k) {
            map = f19599j;
        }
        return map;
    }

    private void m26546a(int i) {
        if (f19599j == null || TextUtils.isEmpty(this.f19604e)) {
            C2538c.c("reportAF500DeviceConnect with invalid parameter.", new Object[0]);
            return;
        }
        DeviceInfo deviceInfo;
        if (f19599j.containsKey(this.f19604e)) {
            deviceInfo = (DeviceInfo) f19599j.get(this.f19604e);
        } else {
            DeviceInfo deviceInfo2 = new DeviceInfo();
            deviceInfo2.setDeviceConnectState(i);
            deviceInfo2.setDeviceIdentify(this.f19604e);
            deviceInfo2.setDeviceName("ColorBand");
            deviceInfo2.setProductType(-2);
            synchronized (C5775a.m26551g()) {
                f19599j.put(this.f19604e, deviceInfo2);
            }
            deviceInfo = deviceInfo2;
        }
        deviceInfo.setDeviceConnectState(i);
        synchronized (m26550f()) {
            for (C3597a a : this.f19605f) {
                a.mo4602a(deviceInfo);
            }
        }
    }

    public void m26556a(C4389a c4389a) {
        C2538c.c("AF500DeviceMgr", new Object[]{"setSyncDataListener enter"});
        if (this.f19602c != null) {
            C2538c.c("AF500DeviceMgr", new Object[]{"setSyncDataListener null != mHealthManage"});
            this.f19602c.mo4225a(c4389a);
        }
    }

    public void m26555a(C4386b c4386b) {
        C2538c.c("AF500DeviceMgr", new Object[]{"setSyncDataListener setIGetTotalDataFromDevice"});
        if (this.f19602c != null) {
            this.f19602c.mo4222a(c4386b);
        }
    }

    public void m26553a(int i, int i2, byte[] bArr) {
        if (this.f19602c == null) {
            return;
        }
        if (2 == i && 1 == i2) {
            if (bArr != null) {
                if (this.f19602c.mo4227a(C4388e.TYPE_CALLING, C0973a.a(bArr))) {
                    this.f19602c.mo4224a(C4388e.TYPE_CALLING);
                    return;
                }
                return;
            }
            this.f19602c.mo4224a(C4388e.TYPE_CALLING_END);
        } else if (7 == i && 1001 == i2) {
            C2538c.c("AF500DeviceMgr", new Object[]{"startSyncData"});
            this.f19602c.mo4228b();
        } else if (7 == i && 2 == i2) {
            if (bArr != null) {
                C2538c.c("AF500DeviceMgr", new Object[]{"sendAF500Command weight" + C5821d.m26905b(bArr) + "height " + C5821d.m26899a(bArr)});
                this.f19602c.mo4220a(r1, r0);
            }
        } else if (7 == i && 1 == i2 && bArr != null) {
            C2538c.c("AF500DeviceMgr", new Object[]{"sendAF500Command weight" + C5821d.m26907c(bArr)});
            this.f19602c.mo4219a(r0);
        }
    }
}
