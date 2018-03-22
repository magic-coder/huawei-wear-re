package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothInputDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;
import com.huawei.hwbtsdk.p057b.p058a.C4620b;
import com.huawei.hwbtsdk.p057b.p058a.C4621d;
import com.huawei.hwbtsdk.p057b.p058a.C4622e;
import com.huawei.hwbtsdk.p057b.p058a.C4623g;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: BTDeviceMgrUtil */
public class C4600d {
    private static final int f16823d = VERSION.SDK_INT;
    private static C4600d f16824r = null;
    private static final Object f16825v = new Object();
    private BroadcastReceiver f16826A = new C4608k(this);
    public BluetoothInputDevice f16827a = null;
    private Context f16828b = null;
    private BluetoothAdapter f16829c = null;
    private BluetoothHeadset f16830e = null;
    private ServiceListener f16831f = null;
    private C4604c f16832g = null;
    private C4598b f16833h = null;
    private List<BluetoothDevice> f16834i = new ArrayList();
    private BluetoothManager f16835j = null;
    private boolean f16836k = false;
    private boolean f16837l = false;
    private C4609l f16838m = null;
    private boolean f16839n = false;
    private C4622e f16840o = null;
    private List<C4623g> f16841p = new ArrayList();
    private C4621d f16842q = null;
    private C4620b f16843s = null;
    private HandlerThread f16844t = new HandlerThread("scan_thread");
    private Handler f16845u;
    private BroadcastReceiver f16846w = new C4602f(this);
    private C4604c f16847x = new C4605h(this);
    private BroadcastReceiver f16848y = new C4606i(this);
    private BroadcastReceiver f16849z = new C4607j(this);

    private C4600d() {
        this.f16844t.start();
        this.f16845u = new Handler(this.f16844t.getLooper());
    }

    public static C4600d m21899a() {
        if (f16824r == null) {
            f16824r = new C4600d();
        }
        return f16824r;
    }

    public void m21930a(Context context) {
        if (context != null) {
            this.f16828b = context;
            this.f16835j = (BluetoothManager) this.f16828b.getSystemService("bluetooth");
            m21940b();
            if (this.f16831f == null) {
                this.f16831f = new C4601e(this);
            }
            if (this.f16829c == null) {
                this.f16829c = BluetoothAdapter.getDefaultAdapter();
                if (this.f16829c != null) {
                    if (!this.f16829c.getProfileProxy(context, this.f16831f, 1)) {
                        C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"Get HFP Profile handle fail."});
                    }
                    if (!this.f16829c.getProfileProxy(context, this.f16831f, 4)) {
                        C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"Get HID Profile handle fail."});
                    }
                } else {
                    C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"mAdapter is null."});
                }
            }
            this.f16828b.registerReceiver(this.f16848y, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
            this.f16828b.registerReceiver(this.f16849z, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
            this.f16828b.registerReceiver(this.f16826A, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public void m21940b() {
        if (this.f16829c != null) {
            this.f16829c.closeProfileProxy(1, this.f16830e);
            this.f16829c.closeProfileProxy(4, this.f16827a);
            this.f16829c = null;
            this.f16830e = null;
            this.f16827a = null;
            this.f16831f = null;
        }
    }

    private static int m21907b(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 3;
            case 13:
                return 2;
            default:
                return 0;
        }
    }

    public int m21944c() {
        if (this.f16829c != null) {
            return C4600d.m21907b(this.f16829c.getState());
        }
        this.f16829c = BluetoothAdapter.getDefaultAdapter();
        if (this.f16829c == null) {
            return 1;
        }
        return C4600d.m21907b(this.f16829c.getState());
    }

    public void m21933a(C4623g c4623g) {
        if (c4623g == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceMgrUtil", new Object[]{"btSwitchEnable with parameter is incorrect."});
        } else if (this.f16829c == null) {
            this.f16829c = BluetoothAdapter.getDefaultAdapter();
            if (this.f16829c == null) {
                c4623g.mo4550a(1);
            } else if (this.f16829c.isEnabled()) {
                c4623g.mo4550a(3);
            } else {
                m21941b(c4623g);
                this.f16829c.enable();
            }
        } else if (this.f16829c.isEnabled()) {
            c4623g.mo4550a(3);
        } else {
            m21941b(c4623g);
            this.f16829c.enable();
        }
    }

    private boolean m21924i() {
        if (this.f16828b.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        }
        return false;
    }

    private boolean m21905a(BluetoothDevice bluetoothDevice, List<String> list) {
        if (bluetoothDevice == null || list == null) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"matchDeviceByName with parameter is incorrect."});
            return false;
        }
        Object name = bluetoothDevice.getName();
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        int i = 0;
        while (i < list.size()) {
            if (!TextUtils.isEmpty((CharSequence) list.get(i)) && name.toUpperCase().contains(((String) list.get(i)).toUpperCase())) {
                return true;
            }
            i++;
        }
        return false;
    }

    private void m21915d(List<String> list) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter unPairBRDevice()."});
        if (this.f16829c == null) {
            this.f16829c = BluetoothAdapter.getDefaultAdapter();
            if (this.f16829c == null) {
                C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"mAdapter is null."});
                return;
            }
        }
        Set<BluetoothDevice> bondedDevices = this.f16829c.getBondedDevices();
        if (bondedDevices != null && bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (!(bluetoothDevice == null || m21942b(bluetoothDevice) || !m21905a(bluetoothDevice, (List) list))) {
                    m21935a(bluetoothDevice);
                }
            }
        }
    }

    public void m21934a(List<String> list, int i, C4604c c4604c) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter startBTDeviceDiscovery()."});
        if (c4604c == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceMgrUtil", new Object[]{"callback is null."});
            return;
        }
        this.f16845u.post(new C4603g(this, i, list, c4604c));
    }

    private void m21904a(C4604c c4604c) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter discoverClassicDevice()."});
        if (this.f16829c == null) {
            this.f16829c = BluetoothAdapter.getDefaultAdapter();
            if (this.f16829c == null) {
                C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"mAdapter is null for br discover."});
                return;
            }
        }
        if (this.f16829c.isDiscovering()) {
            this.f16829c.cancelDiscovery();
        }
        if (this.f16836k && this.f16838m != null) {
            this.f16838m.m21960a(2);
        }
        synchronized (f16825v) {
            this.f16832g = c4604c;
        }
        this.f16837l = true;
        this.f16834i.clear();
        if (this.f16828b != null) {
            this.f16828b.registerReceiver(this.f16846w, new IntentFilter("android.bluetooth.device.action.FOUND"));
            this.f16828b.registerReceiver(this.f16846w, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"));
        }
        Set<BluetoothDevice> bondedDevices = this.f16829c.getBondedDevices();
        if (bondedDevices != null && bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (bluetoothDevice != null) {
                    this.f16834i.add(bluetoothDevice);
                    synchronized (f16825v) {
                        if (this.f16832g != null) {
                            this.f16832g.mo4540a(bluetoothDevice);
                        }
                    }
                }
            }
        }
        try {
            this.f16829c.startDiscovery();
        } catch (Exception e) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"start discover br device occur exception."});
        }
    }

    private void m21910b(C4604c c4604c) {
        int i = 0;
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter discoverBLEDevice()."});
        if (this.f16829c == null) {
            this.f16829c = BluetoothAdapter.getDefaultAdapter();
            if (this.f16829c == null) {
                C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"mAdapter is null."});
                return;
            }
        }
        if (this.f16829c.isDiscovering()) {
            this.f16829c.cancelDiscovery();
        }
        if (this.f16836k && this.f16838m != null) {
            this.f16838m.m21960a(2);
        }
        synchronized (f16825v) {
            this.f16832g = c4604c;
        }
        try {
            this.f16836k = true;
            this.f16834i.clear();
            if (this.f16827a != null) {
                this.f16834i.addAll(this.f16827a.getConnectedDevices());
            } else {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"mHidService is null."});
            }
            if (this.f16835j != null) {
                this.f16834i.addAll(this.f16835j.getConnectedDevices(7));
            }
            synchronized (f16825v) {
                for (BluetoothDevice bluetoothDevice : this.f16834i) {
                    if (!(bluetoothDevice == null || this.f16832g == null)) {
                        this.f16832g.mo4540a(bluetoothDevice);
                    }
                }
            }
            this.f16833h = new C4598b(this.f16847x);
            int i2 = 0;
            while (i < 3) {
                boolean startLeScan = this.f16829c.startLeScan(this.f16833h);
                if (startLeScan) {
                    i2 = 1;
                    break;
                } else {
                    i++;
                    boolean z = startLeScan;
                }
            }
            if (i2 == 0) {
                this.f16833h = null;
                return;
            }
            if (this.f16838m != null) {
                this.f16838m = null;
            }
            this.f16839n = false;
            this.f16838m = new C4609l();
            this.f16838m.start();
        } catch (Exception e) {
        }
    }

    public void m21951d() {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter cancelBTDeviceDiscovery()."});
        if (this.f16837l) {
            try {
                this.f16828b.unregisterReceiver(this.f16846w);
            } catch (Exception e) {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"unregisterReceiver exception = " + e.getMessage()});
            }
            if (this.f16829c.isDiscovering()) {
                this.f16829c.cancelDiscovery();
            }
            synchronized (f16825v) {
                if (this.f16832g != null) {
                    this.f16832g.mo4541b();
                    this.f16832g = null;
                }
            }
            this.f16837l = false;
        }
        if (this.f16836k) {
            boolean i = m21924i();
            if (f16823d >= 18 && i) {
                this.f16836k = false;
                if (this.f16838m != null) {
                    this.f16838m.m21960a(1);
                }
            }
        }
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Leave cancelBTDeviceDiscovery()."});
    }

    public boolean m21936a(BluetoothDevice bluetoothDevice, C4622e c4622e) {
        boolean z = false;
        try {
            this.f16840o = c4622e;
            this.f16828b.registerReceiver(this.f16846w, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
            z = C4611n.m22000a(bluetoothDevice);
        } catch (Exception e) {
            C2538c.a("0xA0200001", "01", 1, "BTDeviceMgrUtil", new Object[]{"btDevicePair with exception = " + e.getMessage()});
        }
        return z;
    }

    public boolean m21935a(BluetoothDevice bluetoothDevice) {
        boolean b;
        Exception e;
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Start to unPair device with btDevice."});
        try {
            b = C4611n.m22003b(bluetoothDevice);
            try {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"removeBond: result = " + b});
            } catch (Exception e2) {
                e = e2;
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"removeBond occur exception with info : " + e.getMessage()});
                return b;
            }
        } catch (Exception e3) {
            e = e3;
            b = false;
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"removeBond occur exception with info : " + e.getMessage()});
            return b;
        }
        return b;
    }

    public boolean m21937a(String str) {
        Exception e;
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Start to unPair device with mac address."});
        BluetoothDevice c = m21946c(str);
        if (c == null) {
            return false;
        }
        if (12 != c.getBondState()) {
            c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"device is not bond."});
            return true;
        }
        boolean b;
        try {
            b = C4611n.m22003b(c);
            try {
                c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"removeBond: result = " + b});
                return b;
            } catch (Exception e2) {
                e = e2;
                c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"removeBond occur exception with info : " + e.getMessage()});
                return b;
            }
        } catch (Exception e3) {
            e = e3;
            b = false;
            c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"removeBond occur exception with info : " + e.getMessage()});
            return b;
        }
    }

    public boolean m21942b(BluetoothDevice bluetoothDevice) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter isHfpConnected()."});
        if (this.f16830e == null || bluetoothDevice == null) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"mHfpService or btDevice is null."});
        } else {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"HFP connect state = " + this.f16830e.getConnectionState(bluetoothDevice)});
            if (2 == this.f16830e.getConnectionState(bluetoothDevice)) {
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"HFP connected."});
                return true;
            }
        }
        return false;
    }

    public BluetoothDevice m21952e() {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter getHFPConnectedDevice()."});
        if (this.f16829c == null) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"mAdapter is null."});
            return null;
        }
        Set<BluetoothDevice> bondedDevices = this.f16829c.getBondedDevices();
        if (bondedDevices != null && bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (m21942b(bluetoothDevice)) {
                    return bluetoothDevice;
                }
            }
        }
        return null;
    }

    public boolean m21938a(List<String> list) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter isWantedDeviceConnected()."});
        if (list == null || list.size() == 0) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"parameter is incorrect."});
            return false;
        }
        BluetoothDevice e = m21952e();
        if (e == null) {
            return false;
        }
        Object name = e.getName();
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"strDeviceName = " + name});
        if (TextUtils.isEmpty(name)) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"strDeviceName is empty."});
            return false;
        }
        int i = 0;
        while (i < list.size()) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"after toUpperCase mNameFilter[" + i + "] = " + ((String) list.get(i)).toUpperCase()});
            if (!TextUtils.isEmpty((CharSequence) list.get(i)) && name.toUpperCase().contains(((String) list.get(i)).toUpperCase())) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean m21943b(List<String> list) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter isWantedBRDeviceTypePaired()."});
        if (list == null || list.size() == 0) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"parameter is incorrect."});
            return false;
        } else if (this.f16829c == null) {
            return false;
        } else {
            Set<BluetoothDevice> bondedDevices = this.f16829c.getBondedDevices();
            if (bondedDevices == null) {
                return false;
            }
            if (bondedDevices.size() > 0) {
                int i = 0;
                boolean z = false;
                while (i < list.size()) {
                    C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"after toUpperCase mNameFilter[" + i + "] = " + ((String) list.get(i)).toUpperCase(Locale.US)});
                    if (z) {
                        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Has found the wanted paired BR device."});
                        break;
                    }
                    if (!TextUtils.isEmpty((CharSequence) list.get(i))) {
                        for (BluetoothDevice bluetoothDevice : bondedDevices) {
                            if (bluetoothDevice != null) {
                                Object name = bluetoothDevice.getName();
                                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Device name = " + name});
                                if (!TextUtils.isEmpty(name) && name.toUpperCase(Locale.US).contains(((String) list.get(i)).toUpperCase())) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                    }
                    i++;
                }
                return z;
            }
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"pairedDevices size = 0"});
            return false;
        }
    }

    public boolean m21948c(BluetoothDevice bluetoothDevice) {
        int a;
        int i;
        Exception exception;
        int i2 = 0;
        try {
            if (this.f16830e != null) {
                a = C4611n.m22002a(this.f16830e, bluetoothDevice, 100);
                try {
                    i2 = C4611n.m22001a(this.f16830e, bluetoothDevice);
                } catch (Exception e) {
                    Exception exception2 = e;
                    i = a;
                    exception = exception2;
                    C2538c.a("0xA0200001", "01", 1, "BTDeviceMgrUtil", new Object[]{"Exception = " + exception.getMessage()});
                    return i2 & i;
                }
            }
            a = i2;
            return i2 & a;
        } catch (Exception e2) {
            exception = e2;
            i = i2;
            C2538c.a("0xA0200001", "01", 1, "BTDeviceMgrUtil", new Object[]{"Exception = " + exception.getMessage()});
            return i2 & i;
        }
    }

    private int m21916e(BluetoothDevice bluetoothDevice) {
        int i = 0;
        if (bluetoothDevice == null) {
            return -1;
        }
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids != null) {
            int i2 = 0;
            while (i2 < uuids.length) {
                if (uuids[i2].toString().equalsIgnoreCase("82ff3820-8411-400c-b85a-55bdb32cf056")) {
                    break;
                } else if (uuids[i2].toString().equalsIgnoreCase("82ff3820-8411-400c-b85a-55bdb32cf057")) {
                    i = 1;
                    break;
                } else if (uuids[i2].toString().equalsIgnoreCase("82ff3820-8411-400c-b85a-55bdb32cf059")) {
                    i = 4;
                    break;
                } else if (uuids[i2].toString().equalsIgnoreCase("82ff3820-8411-400c-b85a-55bdb32cf060")) {
                    i = 7;
                    break;
                } else {
                    i2++;
                }
            }
            i = -1;
        } else {
            C2538c.b("01", 1, "BTDeviceMgrUtil", new Object[]{"uuids is null."});
            i = -1;
        }
        return i;
    }

    public int m21939b(String str) {
        int i = 0;
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"getDeviceTypeByName with name = " + str});
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String toUpperCase = str.toUpperCase();
        if (!TextUtils.isEmpty(toUpperCase)) {
            if (!toUpperCase.startsWith("HUAWEI B1")) {
                if (toUpperCase.startsWith("HUAWEI B2")) {
                    i = 1;
                } else if (toUpperCase.startsWith("HONOR ZERO") || toUpperCase.startsWith("HUAWEI B0") || toUpperCase.startsWith("HUAWEI BAND-") || toUpperCase.startsWith("HONOR BAND Z1")) {
                    i = 5;
                } else if (toUpperCase.equalsIgnoreCase("HUAWEI WATCH")) {
                    i = 3;
                } else {
                    C2538c.b("01", 1, "BTDeviceMgrUtil", new Object[]{"Do not match product name, may be they are new type device."});
                }
            }
            return i;
        }
        i = -1;
        return i;
    }

    public int m21949d(BluetoothDevice bluetoothDevice) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter getDeviceType()."});
        if (bluetoothDevice == null) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"getDeviceType with btDevice is null."});
            return -1;
        }
        int e = m21916e(bluetoothDevice);
        if (-1 != e) {
            return e;
        }
        C2538c.b("01", 1, "BTDeviceMgrUtil", new Object[]{"Do not get product type by UUID."});
        e = m21939b(bluetoothDevice.getName());
        if (-1 != e) {
            return e;
        }
        C2538c.b("01", 1, "BTDeviceMgrUtil", new Object[]{"Do not get product type by Device Name."});
        return e;
    }

    public void m21953f() {
        if (this.f16829c != null && this.f16829c.isDiscovering()) {
            this.f16829c.cancelDiscovery();
        }
    }

    public BluetoothDevice m21946c(String str) {
        if (TextUtils.isEmpty(str)) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceMgrUtil", new Object[]{"getBluetoothDeviceByMac with parameter incorrect."});
            return null;
        } else if (this.f16829c != null) {
            return this.f16829c.getRemoteDevice(str);
        } else {
            return null;
        }
    }

    public void m21932a(C4621d c4621d) {
        this.f16842q = c4621d;
    }

    public void m21931a(C4620b c4620b) {
        this.f16843s = c4620b;
    }

    private synchronized Object m21926j() {
        return this.f16841p;
    }

    public void m21941b(C4623g c4623g) {
        if (c4623g != null && !this.f16841p.contains(c4623g)) {
            synchronized (m21926j()) {
                this.f16841p.add(c4623g);
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Reg mBTSwitchStateCallbackList size = " + this.f16841p.size()});
            }
        }
    }

    public void m21947c(C4623g c4623g) {
        if (c4623g != null && this.f16841p.contains(c4623g)) {
            synchronized (m21926j()) {
                this.f16841p.remove(c4623g);
                C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"UnReg mBTSwitchStateCallbackList size = " + this.f16841p.size()});
            }
        }
    }

    public int m21945c(List<String> list) {
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Enter getDeviceTypeByNameFilter()."});
        if (list == null || list.size() == 0) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"parameter is incorrect."});
            return -1;
        }
        int i;
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"after toUpperCase mNameFilter[" + i2 + "] = " + ((String) list.get(i2)).toUpperCase()});
            if (!TextUtils.isEmpty((CharSequence) list.get(i2))) {
                String toUpperCase = ((String) list.get(i2)).toUpperCase();
                if (toUpperCase.equalsIgnoreCase("HUAWEI B1")) {
                    i = 0;
                    break;
                } else if (toUpperCase.equalsIgnoreCase("HUAWEI B2")) {
                    i = 1;
                    break;
                } else if (toUpperCase.equalsIgnoreCase("HONOR ZERO") || toUpperCase.equalsIgnoreCase("HUAWEI B0") || toUpperCase.equalsIgnoreCase("HUAWEI BAND-") || toUpperCase.equalsIgnoreCase("HONOR BAND Z1")) {
                    i = 5;
                    break;
                }
            }
        }
        i = -1;
        C2538c.a("01", 1, "BTDeviceMgrUtil", new Object[]{"Product Type = " + i});
        return i;
    }

    public String m21950d(String str) {
        C2538c.c("01", 0, "BTDeviceMgrUtil", new Object[]{"identify = " + str});
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return "";
        }
        return str.substring(str.length() - 4, str.length());
    }
}
