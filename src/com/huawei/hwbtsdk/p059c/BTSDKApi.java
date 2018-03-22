package com.huawei.hwbtsdk.p059c;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbtsdk.btmanager.C4645e;
import com.huawei.hwbtsdk.btmanager.C4648h;
import com.huawei.hwbtsdk.p057b.p058a.*;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p399a.C4616s;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;
import com.huawei.hwbtsdk.p057b.p058a.C4623g;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwbtsdk.ui.BTDialogActivity;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: BTSDKApi */
// C0968a
public class BTSDKApi {
    public static final Object f1600a = new Object();
    private static Context f1601g = null;
    private static BTSDKApi f1602h = null;
    private static Map<String, C4648h> f1603j = new HashMap<>();
    private static C4661i f1604k;
    public C0958f f1605b = new C4656d(this);
    public final C4623g f1606c = new C4657e(this);
    public final C4623g f1607d = new C4658f();
    public final C4621d f1608e = new C4659g(this);
    public final C4623g f1609f = new C4660h(this);
    private C0958f f1610i = null;
    private int f1611l = -1;
    private C0957a f1612m = null;
    private List<BluetoothDevice> f1613n = new ArrayList();
    private C4616s f1614o;
    private List<String> f1615p = new ArrayList();
    private DeviceInfo f1616q;
    private C4600d f1617r = null;
    private WeakReference<Handler> f1618s;
    private Handler f1619t;
    private C4645e f1620u = new C4645e();
    private String f1621v = "";
    private int f1622w = 3;
    private DeviceInfo f1623x = null;
    private C4604c f1624y = new C4654b();

    public void m3457a(C4616s sVar) {
        this.f1614o = sVar;
        this.f1614o.m22028a(this.f1613n);
    }

    private BTSDKApi(Context context) {
        if (context == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "init BTSDKApi with context is null.");
            return;
        }
        f1601g = context;
        synchronized (this) {
            C2538c.m12672b("01", 1, "BTSDKApi", "init BluetoothProfile.");
            this.f1617r = C4600d.m21899a();
            this.f1617r.m21930a(context);
            this.f1617r.m21932a(this.f1608e);
            this.f1617r.m21941b(this.f1609f);
        }
        f1604k = new C4661i(this, Looper.getMainLooper());
    }

    public static BTSDKApi m3425a(Context context) {
        if (f1602h == null) {
            C2538c.m12661a("01", 1, "BTSDKApi", "mBTSDKAPiInstance is null.");
            f1602h = new BTSDKApi(BaseApplication.m2632b());
        }
        return f1602h;
    }

    private static synchronized Object m3447n() {
        Map map;
        synchronized (BTSDKApi.class) {
            map = f1603j;
        }
        return map;
    }

    private C4648h m3423a(int i, BluetoothDevice bluetoothDevice) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter getBTDeviceInstance().");
        if (i == 0 || bluetoothDevice != null) {
            String address;
            C4648h hVar;
            if (i == 0) {
                address = "AndroidWear";
            } else {
                address = bluetoothDevice.getAddress();
            }
            if (f1603j == null) {
                hVar = null;
            } else if (f1603j.containsKey(address)) {
                C2538c.m12661a("01", 1, "BTSDKApi", "mDeviceMgrMap already has this device.");
                hVar = f1603j.get(address);
            } else {
                C2538c.m12661a("01", 1, "BTSDKApi", "mDeviceMgrMap do not contain this device.");
                int i2 = -1;
                if (i != 0 && TextUtils.isEmpty(bluetoothDevice.getName())) {
                    i2 = this.f1617r.m21945c(this.f1615p);
                    C2538c.m12661a("01", 1, "BTSDKApi", "productType = " + i2);
                }
                hVar = new C4648h(f1601g, i, bluetoothDevice, this.f1605b, i2);
                synchronized (BTSDKApi.m3447n()) {
                    f1603j.put(address, hVar);
                }
            }
            return hVar;
        }
        C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "btDevice is null.");
        return null;
    }

    private void m3431a(String str, boolean z) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter removeBTDeviceInstance().");
        if (f1603j.containsKey(str)) {
            synchronized (f1600a) {
                if (this.f1616q != null && this.f1616q.getDeviceIdentify().equalsIgnoreCase(str)) {
                    C2538c.m12661a("01", 1, "BTSDKApi", "The wanted remove device is current device so clear reconnect device info.");
                    this.f1616q = null;
                    C2538c.m12661a("01", 1, "BTSDKApi", "Set reconnect device identify is empty.");
                    this.f1620u.m22285a("");
                }
            }
            C4648h hVar = f1603j.get(str);
            if (hVar != null) {
                boolean z2;
                C2538c.m12661a("01", 1, "BTSDKApi", "Find wanted remove device success.");
                hVar.m22362a(true);
                z2 = !z;
                hVar.m22367b(z2);
                hVar.m22370c(false);
                C2538c.m12661a("01", 1, "BTSDKApi", "Stop reconnect Device Identify = " + C4600d.m21899a().m21950d(this.f1620u.m22287c()));
                if (this.f1620u.m22287c().equalsIgnoreCase(str)) {
                    C2538c.m12661a("01", 1, "BTSDKApi", "Stop reconnect ble for remove device.");
                    this.f1620u.m22282a();
                }
                int b = hVar.m22365b();
                if (2 == b || 1 == b) {
                    hVar.m22371d();
                    return;
                }
                synchronized (BTSDKApi.m3447n()) {
                    f1603j.remove(str);
                    if (str.equalsIgnoreCase("AndroidWear")) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "AW device should disconnect GMS.");
                        hVar.m22380l();
                    } else {
                        DeviceInfo h = hVar.m22376h();
                        if (z && h != null && 1 == h.getDeviceBTType()) {
                            C2538c.m12661a("01", 1, "BTSDKApi", "unbind from health, br not unpair");
                            return;
                        } else if (!C4600d.m21899a().m21937a(str)) {
                            C2538c.m12672b("01", 1, "BTSDKApi", "Remove bond device fail.");
                        }
                    }
                    C2538c.m12661a("01", 1, "BTSDKApi", "Device remove success and device list size = " + f1603j.size());
                    return;
                }
            }
            return;
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "Do not contain wanted to delete device : " + C4600d.m21899a().m21950d(str));
    }

    public int m3452a() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter getBTSwitchState().");
        return this.f1617r.m21944c();
    }

    private void m3448o() {
        if (m3451r() || this.f1611l != 2) {
            Intent intent = new Intent(f1601g, BTDialogActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("style", 1);
            this.f1622w = 3;
            intent.putExtra("content", 3);
            f1601g.startActivity(intent);
            return;
        }
        Intent intent = new Intent(f1601g, BTDialogActivity.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("style", 1);
        this.f1622w = 1;
        intent.putExtra("content", 1);
        f1601g.startActivity(intent);
    }

    public void m3463a(boolean z) {
        if (z) {
            f1604k.sendEmptyMessage(2);
            if (this.f1611l == 0) {
                return;
            }
            if (m3451r() || this.f1611l != 2) {
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClass(f1601g, BTDialogActivity.class);
                intent.putExtra("style", 2);
                f1601g.startActivity(intent);
                return;
            }
            C2538c.m12661a("01", 1, "BTSDKApi", "GPS not enabled");
            return;
        }
        f1604k.sendEmptyMessage(1);
    }

    public void m3468b(boolean z) {
        if (z) {
            if (f1604k != null) {
                f1604k.sendEmptyMessage(6);
            }
        } else if (f1604k != null) {
            f1604k.sendEmptyMessage(1);
        }
    }

    public void m3455a(Handler handler) {
        this.f1618s = new WeakReference(handler);
    }

    public void m3465b(Handler handler) {
        this.f1619t = handler;
    }

    private synchronized void m3427a(BluetoothDevice bluetoothDevice) {
        boolean z;
        C2538c.m12661a("01", 1, "BTSDKApi", "addDeviceToList, name =" + bluetoothDevice.getName() + ", identify = " + C4600d.m21899a().m21950d(bluetoothDevice.getAddress()));
        for (BluetoothDevice bluetoothDevice2 : this.f1613n) {
            if (bluetoothDevice2 != null && bluetoothDevice2.getAddress() != null && bluetoothDevice2.getAddress().equals(bluetoothDevice.getAddress())) {
                z = true;
                break;
            }
        }
        z = false;
        C2538c.m12661a("01", 1, "BTSDKApi", "addDeviceToList, flag =" + z);
        if (!(z || this.f1614o == null || !this.f1614o.m22029a(r3))) {
            this.f1613n.add(bluetoothDevice);
            f1604k.post(new C4655c(this));
        }
    }

    private void m3437e(boolean z) {
        if (z) {
            if (m3451r() || this.f1611l != 2) {
                m3471c(true);
                return;
            }
            Intent intent = new Intent(f1601g, BTDialogActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("style", 1);
            this.f1622w = 2;
            intent.putExtra("content", 2);
            f1601g.startActivity(intent);
        } else if (m3451r() || this.f1611l != 2) {
            m3471c(true);
        } else {
            C2538c.m12661a("01", 1, "BTSDKApi", "gps not enable");
        }
    }

    public void m3464b() {
        C2538c.m12661a("01", 1, "BTSDKApi", "---------------scanbegin type:" + this.f1611l);
        if (this.f1613n != null) {
            this.f1613n.clear();
            this.f1614o.m22028a(this.f1613n);
        }
        this.f1617r.m21934a(this.f1615p, this.f1611l, this.f1624y);
        this.f1614o.m22030b(this.f1615p);
    }

    public void m3471c(boolean z) {
        Intent intent;
        if (1 == this.f1611l && z) {
            if (this.f1617r.m21938a(this.f1615p)) {
                C2538c.m12661a("01", 1, "BTSDKApi", "Has wanted BR device.");
                intent = new Intent(f1601g, BTDialogActivity.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("style", 1);
                this.f1622w = 4;
                intent.putExtra("content", 4);
                f1601g.startActivity(intent);
                return;
            }
            C2538c.m12661a("01", 1, "BTSDKApi", "Do not have wanted BR device.");
            if (this.f1617r.m21943b(this.f1615p)) {
                C2538c.m12661a("01", 1, "BTSDKApi", "Has wanted BR device type.");
                intent = new Intent(f1601g, BTDialogActivity.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("style", 1);
                this.f1622w = 5;
                intent.putExtra("content", 5);
                f1601g.startActivity(intent);
                return;
            }
            C2538c.m12661a("01", 1, "BTSDKApi", "Do not have wanted BR device.");
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "Clear device scan list.");
        intent = new Intent(f1601g, BTDialogActivity.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("style", 3);
        intent.putExtra("device_type", this.f1611l);
        f1601g.startActivity(intent);
    }

    public void m3469c() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter showPermissionDialog");
        Intent intent = new Intent(f1601g, BTDialogActivity.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("style", 1);
        this.f1622w = 6;
        intent.putExtra("content", 6);
        f1601g.startActivity(intent);
    }

    public void m3454a(long j) {
        if (j >= 0 && j < ((long) this.f1613n.size())) {
            BluetoothDevice bluetoothDevice = this.f1613n.get((int) j);
            if (bluetoothDevice != null) {
                C2538c.m12661a("01", 1, "BTSDKApi", "connectSelectedDevice:btDevice is " + C4600d.m21899a().m21950d(bluetoothDevice.getAddress()));
                C2538c.m12661a("01", 1, "BTSDKApi", "connectSelectedDevice id: " + j + ";name is: " + bluetoothDevice.getName());
                m3472d();
                m3426a(this.f1611l, bluetoothDevice, true);
            }
        }
    }

    public void m3453a(int i, String str, List<String> list, C0957a c0957a, String str2) {
        int a = m3452a();
        this.f1611l = i;
        this.f1621v = str;
        this.f1615p = list;
        this.f1612m = c0957a;
        if (!TextUtils.isEmpty(str2)) {
            m3426a(i, C4600d.m21899a().m21946c(str2), true);
        } else if (1 == a) {
            m3448o();
        } else if (3 != a) {
        } else {
            if (i == 0) {
                m3426a(i, null, true);
            } else {
                m3437e(true);
            }
        }
    }

    public void m3462a(List<DeviceInfo> list, boolean z) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter removeDeviceList().");
        if (list == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "Parameter is incorrect.");
            return;
        }
        for (DeviceInfo deviceIdentify : list) {
            m3431a(deviceIdentify.getDeviceIdentify(), z);
        }
    }

    private static Map<String, C4648h> m3449p() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter geActiveDeviceList().");
        Map<String, C4648h> hashMap = new HashMap();
        for (Entry entry : f1603j.entrySet()) {
            String str = (String) entry.getKey();
            C4648h hVar = (C4648h) entry.getValue();
            if (hVar != null && 1 == hVar.m22357a()) {
                hashMap.put(str, hVar);
            }
        }
        return hashMap;
    }

    private static String m3450q() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter getFirstActiveDeviceInfo().");
        String str = "";
        Map p = BTSDKApi.m3449p();
        if (p != null && p.size() > 0) {
            Iterator it = p.entrySet().iterator();
            if (it.hasNext()) {
                str = (String) ((Entry) it.next()).getKey();
            }
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "Active device identify = " + C4600d.m21899a().m21950d(str));
        return str;
    }

    public void m3460a(DeviceInfo deviceInfo) {
        BluetoothDevice bluetoothDevice = null;
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setCurrentDevice().");
        this.f1616q = deviceInfo;
        this.f1623x = deviceInfo;
        C4648h hVar;
        if (deviceInfo == null) {
            C2538c.m12661a("01", 1, "BTSDKApi", "device info is null.");
            hVar = f1603j.get(BTSDKApi.m3450q());
            if (hVar != null) {
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to setBTDeviceActiveState is disable.");
                hVar.m22366b(0);
                C2538c.m12661a("01", 1, "BTSDKApi", "Set Reconnect device identify is empty");
                this.f1620u.m22285a("");
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to stopReconnectBLE.");
                this.f1620u.m22282a();
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to disconnect device.");
                hVar.m22371d();
                return;
            }
            return;
        }
        String deviceIdentify = this.f1616q.getDeviceIdentify();
        C2538c.m12661a("01", 1, "BTSDKApi", "mReConnectDeviceInfo macAddress = " + C4600d.m21899a().m21950d(deviceIdentify));
        if (-2 == deviceInfo.getProductType()) {
            C2538c.m12661a("01", 1, "BTSDKApi", "This func do not support AF500 device.");
            return;
        }
        String deviceIdentify2 = deviceInfo.getDeviceIdentify();
        int deviceBTType = deviceInfo.getDeviceBTType();
        C2538c.m12661a("01", 1, "BTSDKApi", "device BTType = " + deviceBTType);
        deviceIdentify = BTSDKApi.m3450q();
        String deviceIdentify3 = deviceInfo.getDeviceIdentify();
        if (!deviceIdentify3.equalsIgnoreCase(deviceIdentify)) {
            C2538c.m12661a("01", 1, "BTSDKApi", "The Current device has not active.");
            if (deviceBTType != 0) {
                bluetoothDevice = this.f1617r.m21946c(deviceIdentify3);
                if (bluetoothDevice == null) {
                    C2538c.m12663a("0xA0200006", "01", 1, "BTSDKApi", "btDevice is null.");
                    return;
                } else if ((1 == deviceInfo.getDeviceProtocol() || deviceInfo.getDeviceProtocol() == 0) && TextUtils.isEmpty(bluetoothDevice.getName())) {
                    C2538c.m12661a("01", 1, "BTSDKApi", "btDevice name is empty.");
                    if (f1603j.get(bluetoothDevice.getAddress()) == null && -1 != deviceInfo.getProductType()) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "Device list do not have this device and device product exist.");
                        hVar = new C4648h(f1601g, deviceBTType, bluetoothDevice, this.f1605b, deviceInfo.getProductType());
                        synchronized (BTSDKApi.m3447n()) {
                            C2538c.m12661a("01", 1, "BTSDKApi", "Put thie new device send command util into device list.");
                            f1603j.put(deviceIdentify2, hVar);
                        }
                    }
                }
            }
            m3426a(deviceBTType, bluetoothDevice, false);
        } else if (deviceBTType != 0) {
            C2538c.m12661a("01", 1, "BTSDKApi", "The Current device has already active.");
            if (this.f1617r != null) {
                bluetoothDevice = this.f1617r.m21946c(deviceIdentify2);
                if (bluetoothDevice != null) {
                    hVar = f1603j.get(deviceIdentify3);
                    if (1 != deviceBTType || !this.f1617r.m21942b(bluetoothDevice)) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "btType is not BR or hfp is not connect.");
                        if (2 == deviceBTType) {
                            C2538c.m12661a("01", 1, "BTSDKApi", "Current is ble device so set is disconnect by user flag is false.");
                            if (hVar != null && 2 != hVar.m22365b()) {
                                hVar.m22372d(true);
                                m3474d(false);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (hVar != null && 2 != hVar.m22365b()) {
                        m3426a(deviceBTType, bluetoothDevice, false);
                        return;
                    } else {
                        return;
                    }
                }
                C2538c.m12661a("01", 1, "BTSDKApi", "btDevice is null.");
            }
        } else {
            hVar = f1603j.get(deviceIdentify3);
            if (hVar != null && 2 != hVar.m22365b()) {
                C2538c.m12661a("01", 1, "BTSDKApi", "start to connect aw device.");
                m3426a(deviceBTType, null, false);
            }
        }
    }

    private void m3436e(String str) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setOtherDeviceActiveFalse().");
        for (Entry entry : BTSDKApi.m3449p().entrySet()) {
            if (!((String) entry.getKey()).equalsIgnoreCase(str)) {
                C4648h hVar = (C4648h) entry.getValue();
                if (hVar != null) {
                    hVar.m22366b(0);
                }
            }
        }
    }

    public void m3461a(String str) {
        int i = 2;
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setActiveDevice().");
        if (TextUtils.isEmpty(str)) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "deviceIdentify is null.");
            return;
        }
        int i2;
        BluetoothDevice bluetoothDevice;
        if (str.equalsIgnoreCase("AndroidWear")) {
            i2 = 0;
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            BluetoothDevice c = this.f1617r.m21946c(str);
            if (c == null) {
                C2538c.m12672b("01", 1, "BTSDKApi", "btDevice is null.");
                return;
            } else if (1 == c.getType()) {
                i = 1;
                bluetoothDevice = c;
            } else if (2 == c.getType()) {
                bluetoothDevice = c;
            } else {
                C2538c.m12661a("01", 1, "BTSDKApi", "The BTType is unknown.");
                i = -1;
                bluetoothDevice = c;
            }
        } else {
            i = i2;
            bluetoothDevice = null;
        }
        m3436e(str);
        C4648h a = m3423a(i, bluetoothDevice);
        if (a != null) {
            C2538c.m12661a("01", 1, "BTSDKApi", "Set wanted device active flag enable.");
            a.m22366b(1);
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "Set Reconnect device identify = " + C4600d.m21899a().m21950d(str));
        this.f1620u.m22285a(str);
    }

    public void m3472d() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter cancelBTDeviceDiscovery().");
        this.f1617r.m21951d();
    }

    public void m3458a(C0958f c0958f) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter registerBTDeviceStateCallBack().");
        if (c0958f == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "btDeviceCallback is null.");
            return;
        }
        this.f1610i = c0958f;
    }

    private void m3426a(int i, BluetoothDevice bluetoothDevice, boolean z) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter connectBTDevice().");
        if ((i == 0 || bluetoothDevice != null) && f1603j != null) {
            String str;
            if (i == 0) {
                str = "AndroidWear";
            } else {
                str = bluetoothDevice.getAddress();
            }
            String q = BTSDKApi.m3450q();
            C4648h hVar = f1603j.get(q);
            C4648h a = m3423a(i, bluetoothDevice);
            boolean z2 = false;
            if (a != null) {
                z2 = a.m22377i();
            }
            C2538c.m12661a("01", 1, "BTSDKApi", "hasAddedWantedDevice = " + z2);
            if (q.equalsIgnoreCase(str)) {
                C2538c.m12661a("01", 1, "BTSDKApi", "preMacAddress equal strMacAddress.");
                if (a != null) {
                    int b = a.m22365b();
                    C2538c.m12661a("01", 1, "BTSDKApi", "getBTDeviceConnectState:" + b);
                    if (this.f1616q == null || 2 == b || 1 == b) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "Do not need to connect wanted device.");
                    } else {
                        C2538c.m12661a("01", 1, "BTSDKApi", "Start to connect wanted device.");
                        a.m22368c();
                    }
                    DeviceInfo h = a.m22376h();
                    if (h == null) {
                        h = new DeviceInfo();
                    }
                    h.setDeviceIdentify(str);
                    if (this.f1616q == null) {
                        this.f1616q = h;
                    }
                    if (2 == b && i != 0 && this.f1610i != null) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "Start to report connected state with device type = " + h.getProductType());
                        h.setDeviceConnectState(2);
                        this.f1610i.m3353a(h, 2);
                        return;
                    }
                    return;
                }
                return;
            }
            C2538c.m12661a("01", 1, "BTSDKApi", "preMacAddress do not equal strMacAddress.");
            if (!(z || hVar == null)) {
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to stopReconnectBLE.");
                this.f1620u.m22282a();
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to disconnect device.");
                hVar.m22371d();
            }
            if (!z || z2) {
                C2538c.m12661a("01", 1, "BTSDKApi", "set current device active state is true.");
                m3461a(str);
            }
            if (a != null) {
                int b2 = a.m22365b();
                C2538c.m12661a("01", 1, "BTSDKApi", "device connect state = " + b2);
                if (!(2 == b2 || 1 == b2)) {
                    if (3 == m3452a()) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "BT switch is on so start connect device.");
                        a.m22368c();
                    } else {
                        C2538c.m12661a("01", 1, "BTSDKApi", "BT switch is not on.");
                    }
                }
                if (2 == b2 && this.f1610i != null) {
                    C2538c.m12661a("01", 1, "BTSDKApi", "report device connected status to dms.");
                    this.f1610i.m3353a(a.m22376h(), 2);
                    return;
                }
                return;
            }
            return;
        }
        C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "parameter is not correct.");
    }

    public void m3467b(String str) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter disconnectBTDevice().");
        if (TextUtils.isEmpty(str)) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "btMacAddress is incorrect.");
            return;
        }
        C4648h hVar = f1603j.get(str);
        if (hVar != null) {
            int b = hVar.m22365b();
            if (1 == b || 2 == b) {
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to disconnect BT Device.");
                hVar.m22371d();
                return;
            }
            C2538c.m12661a("01", 1, "BTSDKApi", "Device is already disconnect.");
            return;
        }
        C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "can not get device manager handle.");
    }

    public void m3470c(String str) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter sendAWFilePath().");
        C4648h a = m3423a(0, null);
        if (a == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "deviceSendCommandUtil is null.");
            return;
        }
        C2538c.m12661a("01", 0, "BTSDKApi", "sendAWFilePath path : " + str);
        a.m22361a(str);
    }

    public void m3456a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setFileCallback().");
        C4648h a = m3423a(0, null);
        if (a == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "deviceSendCommandUtil is null.");
            return;
        }
        C2538c.m12661a("01", 0, "BTSDKApi", "setFileCallback path : " + iBaseResponseCallback);
        a.m22359a(iBaseResponseCallback);
    }

    public void m3459a(C4625b bVar) {
        int i = 2;
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter sendBTDeviceData().");
        if (bVar == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "parameter is not correct.");
            return;
        }
        BluetoothDevice bluetoothDevice;
        String a = bVar.m22107a();
        if (a.equalsIgnoreCase("AndroidWear")) {
            bVar.m22115c(0);
            bluetoothDevice = null;
        } else {
            BluetoothDevice c = this.f1617r.m21946c(a);
            if (c == null) {
                C2538c.m12663a("0xA0200006", "01", 1, "BTSDKApi", "btDevice is null.");
                return;
            }
            if (1 == c.getType()) {
                i = 1;
            } else if (2 != c.getType()) {
                i = -1;
                C2538c.m12661a("01", 1, "BTSDKApi", "The BTType is unknown.");
            }
            bVar.m22115c(i);
            bluetoothDevice = c;
        }
        C4648h a2 = m3423a(bVar.m22121f(), bluetoothDevice);
        if (a2 == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "deviceSendCommandUtil is null.");
            return;
        }
        a2.m22360a(bVar);
    }

    private boolean m3451r() {
        boolean isProviderEnabled;
        boolean isProviderEnabled2;
        if (VERSION.SDK_INT >= 23) {
            LocationManager locationManager = (LocationManager) f1601g.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            isProviderEnabled = locationManager.isProviderEnabled("gps");
            C2538c.m12661a("01", 1, "BTSDKApi", "isGPSLocationEnable：" + isProviderEnabled);
            isProviderEnabled2 = locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER);
            C2538c.m12661a("01", 1, "BTSDKApi", "isNetWorkLocationEnable：" + isProviderEnabled2);
        } else {
            isProviderEnabled2 = true;
            isProviderEnabled = true;
        }
        return isProviderEnabled || isProviderEnabled2;
    }

    public void m3474d(boolean z) {
        C2538c.m12672b("01", 1, "BTSDKApi", "Enter forceConnectBTDevice().");
        C4648h hVar = f1603j.get(BTSDKApi.m3450q());
        if (hVar != null && this.f1616q != null) {
            int b = hVar.m22365b();
            int deviceBTType = this.f1616q.getDeviceBTType();
            C2538c.m12661a("01", 1, "BTSDKApi", "Current connect state = " + b);
            if (2 == b) {
                return;
            }
            if (deviceBTType != 0) {
                BluetoothDevice c = this.f1617r.m21946c(this.f1616q.getDeviceIdentify());
                if (c == null) {
                    return;
                }
                if (2 == deviceBTType) {
                    C2538c.m12661a("01", 1, "BTSDKApi", "reconnectEnableFlag = " + hVar.m22379k());
                    if (hVar.m22379k()) {
                        this.f1620u.m22282a();
                        if (this.f1620u.m22286b() == null) {
                            C2538c.m12661a("01", 1, "BTSDKApi", "btDeviceSendCommandUtil is null so reset it.");
                            this.f1620u.m22283a(hVar);
                        }
                        if (z) {
                            C2538c.m12661a("01", 1, "BTSDKApi", "iconnect find device so connect device directly.");
                            if (1 != b && 2 != b) {
                                hVar.m22368c();
                                return;
                            }
                            return;
                        }
                        this.f1620u.m22284a(this.f1616q);
                        return;
                    }
                    C2538c.m12661a("01", 1, "BTSDKApi", "user has disabled the connect operation.");
                } else if (1 == deviceBTType && 1 != b) {
                    if (this.f1617r.m21942b(c)) {
                        C2538c.m12661a("01", 1, "BTSDKApi", "Start to connect BR device.");
                        hVar.m22368c();
                        return;
                    }
                    C2538c.m12661a("01", 1, "BTSDKApi", "HFP is not connected so do not connect device.");
                }
            } else if (1 != b) {
                C2538c.m12661a("01", 1, "BTSDKApi", "Start to connect AW device.");
                hVar.m22368c();
            }
        }
    }

    public void m3475e() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setAF500CurrentDevice().");
        this.f1616q = null;
        C4648h hVar = f1603j.get(BTSDKApi.m3450q());
        m3436e("");
        if (hVar == null) {
            return;
        }
        if (2 == hVar.m22365b() || 1 == hVar.m22365b()) {
            C2538c.m12661a("01", 1, "BTSDKApi", "Set pre device disable.");
            hVar.m22366b(0);
            C2538c.m12661a("01", 1, "BTSDKApi", "Set Reconnect device identify is empty.");
            this.f1620u.m22285a("");
            C2538c.m12661a("01", 1, "BTSDKApi", "Start to stopReconnectBLE.");
            this.f1620u.m22282a();
            C2538c.m12661a("01", 1, "BTSDKApi", "Start to disconnect pre device.");
            hVar.m22371d();
        }
    }

    public void m3476f() {
        if (this.f1612m != null) {
            this.f1612m.mo2341a(4);
        }
    }

    public void m3477g() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter connectHFPConnectedDevice().");
        BluetoothDevice e = this.f1617r.m21952e();
        if (e != null) {
            C2538c.m12661a("01", 1, "BTSDKApi", "The wanted device name = " + e.getName());
            m3426a(1, e, true);
        }
    }

    public String m3478h() {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter getHFPConnectedDeviceName().");
        String str = "";
        BluetoothDevice e = this.f1617r.m21952e();
        if (e == null) {
            return str;
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "The wanted device name = " + e.getName());
        return e.getName();
    }

    public String m3479i() {
        return this.f1621v;
    }

    public void m3473d(String str) {
        int i = 2;
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setAddedDeviceSuccess().");
        if (TextUtils.isEmpty(str)) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "strIdentify is null.");
            return;
        }
        int i2;
        if (str.equalsIgnoreCase("AndroidWear")) {
            i2 = 0;
        } else {
            i2 = -1;
        }
        BluetoothDevice bluetoothDevice = null;
        if (i2 != 0) {
            bluetoothDevice = this.f1617r.m21946c(str);
            if (bluetoothDevice == null) {
                C2538c.m12672b("01", 1, "BTSDKApi", "btDevice is null so return.");
                return;
            } else if (1 == bluetoothDevice.getType()) {
                i = 1;
            } else if (2 != bluetoothDevice.getType()) {
                C2538c.m12661a("01", 1, "BTSDKApi", "The btType is unknown.");
                i = -1;
            }
        } else {
            i = i2;
        }
        C4648h a = m3423a(i, bluetoothDevice);
        if (a != null) {
            C2538c.m12661a("01", 1, "BTSDKApi", "Set wanted device add success flag.");
            a.m22370c(true);
            return;
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "deviceSendCommandUtil is null.");
    }

    public void m3466b(DeviceInfo deviceInfo) {
        C2538c.m12661a("01", 1, "BTSDKApi", "Enter setDMSHandshakeFail().");
        if (deviceInfo == null) {
            C2538c.m12663a("0xA0200008", "01", 1, "BTSDKApi", "btDeviceInfo is null.");
            return;
        }
        C2538c.m12661a("01", 1, "BTSDKApi", "Start to report connect fail.");
        deviceInfo.setDeviceConnectState(4);
        this.f1605b.m3353a(deviceInfo, 4);
    }

    public DeviceInfo m3480j() {
        return this.f1623x;
    }

    /* compiled from: BTSDKApi */
    class C4654b implements C4604c {
        public void mo4540a(BluetoothDevice bluetoothDevice) {
            m3427a(bluetoothDevice);
        }

        public void mo4539a() {
            C2538c.a("01", 1, "BTSDKApi", "onDeviceDiscoveryFinished");
//            if (BTSDKApi.a(this.f17049a) != null) {
//                BTSDKApi.a(this.f17049a).sendEmptyMessage(0);
//            }
            if (f1604k != null) {
                f1604k.sendEmptyMessage(0);
            }
        }

        public void mo4541b() {}
    }

    /* compiled from: BTSDKApi */
    static class C4656d implements C0958f {
        final /* synthetic */ BTSDKApi f17051a;

        C4656d(BTSDKApi aVar) {
            this.f17051a = aVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m22386a(DeviceInfo r10, int r11) {
            /*
            r9 = this;
            r0 = "01";
            r1 = 1;
            r2 = "BTSDKApi";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "onDeviceConnectionStateChanged with btState = ";
            r5 = r5.append(r6);
            r5 = r5.append(r11);
            r5 = r5.toString();
            r3[r4] = r5;
            com.huawei.v.c.a(r0, r1, r2, r3);
            r0 = r9.f17051a;
            r0 = com.huawei.hwbtsdk.c.a.d(r0);
            if (r0 == 0) goto L_0x00c7;
        L_0x0029:
            r0 = r9.f17051a;
            r0 = com.huawei.hwbtsdk.c.a.d(r0);
            r0.a(r10, r11);
            r0 = 3;
            if (r0 == r11) goto L_0x0038;
        L_0x0035:
            r0 = 4;
            if (r0 != r11) goto L_0x00f8;
        L_0x0038:
            r0 = com.huawei.hwbtsdk.c.a.k();
            r1 = r10.getDeviceIdentify();
            r0 = r0.containsKey(r1);
            if (r0 == 0) goto L_0x00f8;
        L_0x0046:
            r0 = com.huawei.hwbtsdk.c.a.k();
            r1 = r10.getDeviceIdentify();
            r0 = r0.get(r1);
            r0 = (com.huawei.hwbtsdk.btmanager.C4648h) r0;
            r1 = r0.m22374f();
            if (r1 == 0) goto L_0x00f8;
        L_0x005a:
            r1 = r10.getDeviceIdentify();
            r2 = r9.f17051a;
            r2 = com.huawei.hwbtsdk.c.a.e(r2);
            r2 = r2.m22287c();
            r2 = r2.equalsIgnoreCase(r1);
            if (r2 == 0) goto L_0x0087;
        L_0x006e:
            r2 = "01";
            r3 = 1;
            r4 = "BTSDKApi";
            r5 = 1;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r7 = "Stop reconnect ble for remove device.";
            r5[r6] = r7;
            com.huawei.v.c.a(r2, r3, r4, r5);
            r2 = r9.f17051a;
            r2 = com.huawei.hwbtsdk.c.a.e(r2);
            r2.m22282a();
        L_0x0087:
            r2 = "01";
            r3 = 1;
            r4 = "BTSDKApi";
            r5 = 1;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r7 = "Need to remove device from device list.";
            r5[r6] = r7;
            com.huawei.v.c.a(r2, r3, r4, r5);
            r2 = com.huawei.hwbtsdk.c.a.l();
            monitor-enter(r2);
            r3 = com.huawei.hwbtsdk.c.a.k();	 Catch:{ all -> 0x00e4 }
            r4 = r10.getDeviceIdentify();	 Catch:{ all -> 0x00e4 }
            r3.remove(r4);	 Catch:{ all -> 0x00e4 }
            r3 = "AndroidWear";
            r3 = r1.equalsIgnoreCase(r3);	 Catch:{ all -> 0x00e4 }
            if (r3 != 0) goto L_0x00e7;
        L_0x00af:
            r0 = r0.m22375g();	 Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00c8;
        L_0x00b5:
            r0 = "01";
            r1 = 1;
            r3 = "BTSDKApi";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e4 }
            r5 = 0;
            r6 = "unpair from health ......";
            r4[r5] = r6;	 Catch:{ all -> 0x00e4 }
            com.huawei.v.c.a(r0, r1, r3, r4);	 Catch:{ all -> 0x00e4 }
            monitor-exit(r2);	 Catch:{ all -> 0x00e4 }
        L_0x00c7:
            return;
        L_0x00c8:
            r0 = com.huawei.hwbtsdk.p399a.C4600d.m21899a();	 Catch:{ all -> 0x00e4 }
            r0 = r0.m21937a(r1);	 Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00e2;
        L_0x00d2:
            r0 = "01";
            r1 = 1;
            r3 = "BTSDKApi";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e4 }
            r5 = 0;
            r6 = "Remove bond device fail.";
            r4[r5] = r6;	 Catch:{ all -> 0x00e4 }
            com.huawei.v.c.b(r0, r1, r3, r4);	 Catch:{ all -> 0x00e4 }
        L_0x00e2:
            monitor-exit(r2);	 Catch:{ all -> 0x00e4 }
            goto L_0x00c7;
        L_0x00e4:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x00e4 }
            throw r0;
        L_0x00e7:
            r0 = "01";
            r1 = 1;
            r3 = "BTSDKApi";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e4 }
            r5 = 0;
            r6 = "AW device do not need remove bond info.";
            r4[r5] = r6;	 Catch:{ all -> 0x00e4 }
            com.huawei.v.c.a(r0, r1, r3, r4);	 Catch:{ all -> 0x00e4 }
            goto L_0x00e2;
        L_0x00f8:
            r1 = com.huawei.hwbtsdk.c.a.a;
            monitor-enter(r1);
            r0 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r0 = com.huawei.hwbtsdk.c.a.f(r0);	 Catch:{ all -> 0x0213 }
            if (r0 == 0) goto L_0x01ea;
        L_0x0103:
            r0 = "01";
            r2 = 1;
            r3 = "BTSDKApi";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0213 }
            r5 = 0;
            r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0213 }
            r6.<init>();	 Catch:{ all -> 0x0213 }
            r7 = "Device BTType = ";
            r6 = r6.append(r7);	 Catch:{ all -> 0x0213 }
            r7 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r7 = com.huawei.hwbtsdk.c.a.f(r7);	 Catch:{ all -> 0x0213 }
            r7 = r7.getDeviceBTType();	 Catch:{ all -> 0x0213 }
            r6 = r6.append(r7);	 Catch:{ all -> 0x0213 }
            r6 = r6.toString();	 Catch:{ all -> 0x0213 }
            r4[r5] = r6;	 Catch:{ all -> 0x0213 }
            com.huawei.v.c.a(r0, r2, r3, r4);	 Catch:{ all -> 0x0213 }
            r0 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r0 = com.huawei.hwbtsdk.c.a.f(r0);	 Catch:{ all -> 0x0213 }
            r0 = r0.getDeviceIdentify();	 Catch:{ all -> 0x0213 }
            r2 = "01";
            r3 = 1;
            r4 = "BTSDKApi";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0213 }
            r6 = 0;
            r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0213 }
            r7.<init>();	 Catch:{ all -> 0x0213 }
            r8 = "mReConnectDeviceInfo macAddress = ";
            r7 = r7.append(r8);	 Catch:{ all -> 0x0213 }
            r8 = com.huawei.hwbtsdk.p399a.C4600d.m21899a();	 Catch:{ all -> 0x0213 }
            r8 = r8.m21950d(r0);	 Catch:{ all -> 0x0213 }
            r7 = r7.append(r8);	 Catch:{ all -> 0x0213 }
            r7 = r7.toString();	 Catch:{ all -> 0x0213 }
            r5[r6] = r7;	 Catch:{ all -> 0x0213 }
            com.huawei.v.c.a(r2, r3, r4, r5);	 Catch:{ all -> 0x0213 }
            r2 = 2;
            r3 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r3 = com.huawei.hwbtsdk.c.a.f(r3);	 Catch:{ all -> 0x0213 }
            r3 = r3.getDeviceBTType();	 Catch:{ all -> 0x0213 }
            if (r2 != r3) goto L_0x01ea;
        L_0x016e:
            r2 = 3;
            if (r2 == r11) goto L_0x0174;
        L_0x0171:
            r2 = 4;
            if (r2 != r11) goto L_0x01ea;
        L_0x0174:
            r2 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r2 = com.huawei.hwbtsdk.c.a.g(r2);	 Catch:{ all -> 0x0213 }
            r3 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r3 = com.huawei.hwbtsdk.c.a.f(r3);	 Catch:{ all -> 0x0213 }
            r3 = r3.getDeviceIdentify();	 Catch:{ all -> 0x0213 }
            r2 = r2.m21946c(r3);	 Catch:{ all -> 0x0213 }
            r3 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r4 = 2;
            r2 = com.huawei.hwbtsdk.c.a.a(r3, r4, r2);	 Catch:{ all -> 0x0213 }
            r3 = r10.getDeviceIdentify();	 Catch:{ all -> 0x0213 }
            r0 = r3.equalsIgnoreCase(r0);	 Catch:{ all -> 0x0213 }
            if (r0 == 0) goto L_0x01ea;
        L_0x0199:
            r0 = "01";
            r3 = 1;
            r4 = "BTSDKApi";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0213 }
            r6 = 0;
            r7 = "Start to reconnect BLE device.";
            r5[r6] = r7;	 Catch:{ all -> 0x0213 }
            com.huawei.v.c.b(r0, r3, r4, r5);	 Catch:{ all -> 0x0213 }
            r0 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r0 = com.huawei.hwbtsdk.c.a.e(r0);	 Catch:{ all -> 0x0213 }
            r0.m22283a(r2);	 Catch:{ all -> 0x0213 }
            if (r2 == 0) goto L_0x0216;
        L_0x01b4:
            r0 = r2.m22379k();	 Catch:{ all -> 0x0213 }
            r2 = "01";
            r3 = 1;
            r4 = "BTSDKApi";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0213 }
            r6 = 0;
            r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0213 }
            r7.<init>();	 Catch:{ all -> 0x0213 }
            r8 = "reconnectEnableFlag info = ";
            r7 = r7.append(r8);	 Catch:{ all -> 0x0213 }
            r7 = r7.append(r0);	 Catch:{ all -> 0x0213 }
            r7 = r7.toString();	 Catch:{ all -> 0x0213 }
            r5[r6] = r7;	 Catch:{ all -> 0x0213 }
            com.huawei.v.c.a(r2, r3, r4, r5);	 Catch:{ all -> 0x0213 }
            if (r0 == 0) goto L_0x0209;
        L_0x01db:
            r0 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r0 = com.huawei.hwbtsdk.c.a.e(r0);	 Catch:{ all -> 0x0213 }
            r2 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r2 = com.huawei.hwbtsdk.c.a.f(r2);	 Catch:{ all -> 0x0213 }
            r0.m22284a(r2);	 Catch:{ all -> 0x0213 }
        L_0x01ea:
            monitor-exit(r1);	 Catch:{ all -> 0x0213 }
            r0 = 2;
            if (r0 != r11) goto L_0x00c7;
        L_0x01ee:
            r0 = "01";
            r1 = 1;
            r2 = "BTSDKApi";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = "Device connected so stop reconnect.";
            r3[r4] = r5;
            com.huawei.v.c.a(r0, r1, r2, r3);
            r0 = r9.f17051a;
            r0 = com.huawei.hwbtsdk.c.a.e(r0);
            r0.m22282a();
            goto L_0x00c7;
        L_0x0209:
            r0 = r9.f17051a;	 Catch:{ all -> 0x0213 }
            r0 = com.huawei.hwbtsdk.c.a.e(r0);	 Catch:{ all -> 0x0213 }
            r0.m22282a();	 Catch:{ all -> 0x0213 }
            goto L_0x01ea;
        L_0x0213:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0213 }
            throw r0;
        L_0x0216:
            r0 = "01";
            r2 = 1;
            r3 = "BTSDKApi";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0213 }
            r5 = 0;
            r6 = "deviceSendCommandUtil is null.";
            r4[r5] = r6;	 Catch:{ all -> 0x0213 }
            com.huawei.v.c.a(r0, r2, r3, r4);	 Catch:{ all -> 0x0213 }
            goto L_0x01ea;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwbtsdk.c.d.a(com.huawei.hwcommonmodel.datatypes.DeviceInfo, int):void");
        }

        public void m22387a(DeviceInfo deviceInfo, int i, byte[] bArr) {
            if (BTSDKApi.d(this.f17051a) != null) {
                BTSDKApi.d(this.f17051a).a(deviceInfo, i, bArr);
            }
        }
    }

    /* compiled from: BTSDKApi */
    class C4657e implements C4623g {
        final /* synthetic */ BTSDKApi f17052a;
    
        C4657e(BTSDKApi aVar) {
            this.f17052a = aVar;
        }
    
        public void mo4550a(int i) {
            C2538c.a("01", 1, "BTSDKApi", "During add device then receive BT Switch state = " + i);
            switch (i) {
                case 1:
                    BTSDKApi.g(this.f17052a).m21947c(this.f17052a.c);
                    if (BTSDKApi.h(this.f17052a) != null) {
                        BTSDKApi.h(this.f17052a).a(2);
                        return;
                    }
                    return;
                case 3:
                    BTSDKApi.g(this.f17052a).m21947c(this.f17052a.c);
                    if (-1 != BTSDKApi.i(this.f17052a) && BTSDKApi.i(this.f17052a) != 0) {
                        if (1 != BTSDKApi.j(this.f17052a)) {
                            BTSDKApi.m().sendEmptyMessage(4);
                        }
                        if (f1618s != null) {
                            Handler handler = f1618s.get();
                            if (handler != null) {
                                handler.sendEmptyMessage(1);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (BTSDKApi.i(this.f17052a) == 0) {
                        BTSDKApi.m().sendEmptyMessage(5);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* compiled from: BTSDKApi */
    class C4658f implements C4623g {
        public void mo4550a(int i) {
            switch (i) {
                case 1:
                    C2538c.a("01", 1, "BTSDKApi", "click openBTDialog opne system bt mBTSwitchOpenCallback BT_STATE_OFF!");
                    return;
                case 2:
                    C2538c.a("01", 1, "BTSDKApi", "click openBTDialog opne system bt mBTSwitchOpenCallback BT_STATE_TURNING_OFF!");
                    return;
                case 3:
                    C2538c.a("01", 1, "BTSDKApi", "click openBTDialog opne system bt mBTSwitchOpenCallback BT_STATE_ON!");
                    return;
                case 4:
                    C2538c.a("01", 1, "BTSDKApi", "click openBTDialog opne system bt mBTSwitchOpenCallback BT_STATE_TURNING_ON!");
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: BTSDKApi */
    class C4661i extends Handler {
        final /* synthetic */ BTSDKApi f17056a;
    
        public C4661i(BTSDKApi aVar, Looper looper) {
            super(looper);
            this.f17056a = aVar;
        }
    
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (BTSDKApi.h(this.f17056a) != null) {
                        BTSDKApi.h(this.f17056a).a(1);
                        return;
                    }
                    return;
                case 2:
//                    BTSDKApi.g(this.f17056a).m21933a(this.f17056a.c);
                    f1617r.m21933a(f1606c);
                    return;
                case 3:
                    if (BTSDKApi.h(this.f17056a) != null) {
                        BTSDKApi.h(this.f17056a).a(3);
                        return;
                    }
                    return;
                case 4:
//                    BTSDKApi.a(this.f17056a, false);
                    m3463a(false);
                    return;
                case 5:
//                    BTSDKApi.a(this.f17056a, 0, null, true);
                    m3426a(0, null, true);
                    return;
                case 6:
//                    BTSDKApi.g(this.f17056a).m21933a(this.f17056a.d);
                    f1617r.m21933a(f1607d);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: BTSDKApi */
    class C4659g implements C4621d {
        final /* synthetic */ BTSDKApi f17054a;
    
        C4659g(BTSDKApi aVar) {
            this.f17054a = aVar;
        }
    
        public void mo4551a(BluetoothDevice bluetoothDevice) {
            C2538c.a("01", 1, "BTSDKApi", "Enter onBTDeviceHFPConnected().");
            if (BTSDKApi.f(this.f17054a) == null || 1 != BTSDKApi.f(this.f17054a).getDeviceActiveState() || BTSDKApi.f(this.f17054a).getDeviceIdentify().equalsIgnoreCase("AndroidWear")) {
                C2538c.a("01", 1, "BTSDKApi", "Parameter is incorrect.");
                return;
            }
            C2538c.a("01", 1, "BTSDKApi", "Start to connect BT Device.");
            if (bluetoothDevice != null) {
                String deviceIdentify = BTSDKApi.f(this.f17054a).getDeviceIdentify();
                String address = bluetoothDevice.getAddress();
                if (deviceIdentify.equalsIgnoreCase(address)) {
                    C2538c.a("01", 1, "BTSDKApi", "The connected hfp is the wanted device, isAvailable : " + ((C4648h) BTSDKApi.k().get(address)).m22378j());
                    if (2 != BTSDKApi.f(this.f17054a).getDeviceProtocol() || (5 != BTSDKApi.f(this.f17054a).getDeviceConnectState() && r0)) {
                        C2538c.a("01", 1, "BTSDKApi", "The connected hfp is the wanted device, so start to connect spp.");
                        BTSDKApi.a(this.f17054a, 1, bluetoothDevice, false);
                        return;
                    }
                    C2538c.a("01", 1, "BTSDKApi", "Current is headset status, so do not need connect BR device.");
                    return;
                }
                C2538c.a("01", 1, "BTSDKApi", "The connected hfp is not wanted device, so stop to connect spp.");
                return;
            }
            C2538c.a("01", 1, "BTSDKApi", "btDevice is null.");
        }
    }

    /* compiled from: BTSDKApi */
    static class C4660h implements C4623g {
        final /* synthetic */ BTSDKApi f17055a;
    
        C4660h(BTSDKApi aVar) {
            this.f17055a = aVar;
        }
    
        public void mo4550a(int i) {
            C2538c.a("01", 1, "BTSDKApi", "Receive BT Switch state = " + i);
            switch (i) {
                case 1:
                    if (BTSDKApi.f(this.f17055a) != null && 2 == BTSDKApi.f(this.f17055a).getDeviceBTType()) {
                        String deviceIdentify = BTSDKApi.f(this.f17055a).getDeviceIdentify();
                        C2538c.a("01", 1, "BTSDKApi", "BT Switch off with identify = " + C4600d.m21899a().m21950d(deviceIdentify));
                        C4648h c4648h = (C4648h) BTSDKApi.k().get(BTSDKApi.f(this.f17055a).getDeviceIdentify());
                        if (c4648h != null) {
                            C2538c.a("01", 1, "BTSDKApi", "Start to tell bt service switch info");
                            c4648h.m22369c(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (BTSDKApi.f(this.f17055a) != null && 2 == BTSDKApi.f(this.f17055a).getDeviceBTType()) {
                        C2538c.a("01", 1, "BTSDKApi", "BT switch on so start to force connect BLE device.");
                        this.f17055a.d(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: BTSDKApi */
    static class C4655c implements Runnable {
        final /* synthetic */ BTSDKApi f17050a;
    
        C4655c(BTSDKApi aVar) {
            this.f17050a = aVar;
        }
    
        public void run() {
            BTSDKApi.c(this.f17050a).m22028a(BTSDKApi.b(this.f17050a));
        }
    }
}
