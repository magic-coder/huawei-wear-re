package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1684a;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1687e;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1688f;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1694b;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi", "HandlerLeak"})
/* compiled from: HuaweiWearableDeviceImpl */
class an {
    private static final int f4449a = VERSION.SDK_INT;
    private Context f4450b = null;
    private BluetoothAdapter f4451c = null;
    private C1686d f4452d = null;
    private C1688f f4453e = null;
    private C1719y f4454f = null;
    private boolean f4455g = false;
    private boolean f4456h = false;
    private C1684a f4457i = null;
    private ArrayList<BluetoothDevice> f4458j = new ArrayList();
    private C1687e f4459k = null;
    private int f4460l;
    private int f4461m = 0;
    private boolean f4462n = true;
    private aq f4463o = null;
    private boolean f4464p = false;
    private BluetoothManager f4465q = null;
    private List<BluetoothDevice> f4466r = null;
    private final BroadcastReceiver f4467s = new ao(this);
    private C1686d f4468t = new ap(this);

    public an(Context context, int i) {
        this.f4450b = context;
        this.f4451c = BluetoothAdapter.getDefaultAdapter();
        this.f4454f = new C1719y(this.f4450b, i);
        this.f4454f.m8226a();
        this.f4466r = new ArrayList();
        C2538c.m12674b("HuaweiWearableDeviceImpl", "new HuaweiWearableDeviceImpl being called");
        if (f4449a >= 18) {
            this.f4465q = (BluetoothManager) this.f4450b.getSystemService("bluetooth");
            if (this.f4450b.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                this.f4456h = true;
                C2538c.m12679d("HuaweiWearableDeviceImpl", "BLE feature is supported!");
                return;
            }
            C2538c.m12679d("HuaweiWearableDeviceImpl", "BLE feature is not supported! ");
            return;
        }
        C2538c.m12679d("HuaweiWearableDeviceImpl", "BLE is not supported.");
    }

    public void m7960a(C1686d c1686d, int i) {
        if (!m7944e()) {
            C2538c.m12680e("HuaweiWearableDeviceImpl", "startDeviceDiscovery(): BT is not enabled, enable it again.");
            this.f4451c.enable();
        }
        this.f4460l = i;
        m7956a();
        synchronized (this.f4458j) {
            this.f4458j.clear();
        }
        this.f4452d = c1686d;
        if (f4449a < 18) {
            m7950h();
        } else if (2 == i || 3 == i) {
            m7948g();
        } else {
            m7950h();
        }
    }

    public void m7956a() {
        if (this.f4464p && this.f4452d != null) {
            try {
                this.f4450b.unregisterReceiver(this.f4467s);
            } catch (IllegalArgumentException e) {
                C2538c.m12680e("HuaweiWearableDeviceImpl", "mContext.unregisterReceiver(mReceiver) fail, the receive is not register");
            }
            this.f4452d = null;
        }
        if (f4449a >= 18 && this.f4456h && this.f4455g) {
            this.f4455g = false;
            this.f4451c.stopLeScan(this.f4457i);
            C2538c.m12680e("HuaweiWearableDeviceImpl", "Stop BLE device discovery.");
            if (this.f4463o != null) {
                this.f4463o.m7969a();
            }
            C2538c.m12680e("HuaweiWearableDeviceImpl", "Scan all devices exited.");
            m7954k();
        }
        if (this.f4451c.isDiscovering()) {
            this.f4451c.cancelDiscovery();
            C2538c.m12680e("HuaweiWearableDeviceImpl", "Stop classic device discovery.");
            C2538c.m12680e("HuaweiWearableDeviceImpl", "Scan all devices exited.");
            m7954k();
        }
    }

    public void m7959a(BluetoothDevice bluetoothDevice, C1690h c1690h, int i) {
        if (m7944e()) {
            m7956a();
            this.f4454f.m8229a(bluetoothDevice, c1690h, i);
            return;
        }
        C2538c.m12680e("HuaweiWearableDeviceImpl", "Bluetooth is not enabled. Please enable it first！");
        c1690h.mo2568a(3);
    }

    private boolean m7944e() {
        if (this.f4451c == null) {
            this.f4451c = BluetoothAdapter.getDefaultAdapter();
            if (this.f4451c == null) {
                C2538c.m12680e("HuaweiWearableDeviceImpl", "mAdapter is null!");
                return false;
            } else if (this.f4451c.isEnabled()) {
                C2538c.m12674b("HuaweiWearableDeviceImpl", "bluetooth is enabled !");
                return true;
            } else {
                C2538c.m12680e("HuaweiWearableDeviceImpl", "bluetooth is not enabled!");
                return false;
            }
        }
        C2538c.m12674b("HuaweiWearableDeviceImpl", "mAdapter is not null .");
        if (this.f4451c.isEnabled()) {
            return true;
        }
        C2538c.m12680e("HuaweiWearableDeviceImpl", "bluetooth is not enabled!");
        return false;
    }

    public void m7962b() {
        if (this.f4466r != null) {
            this.f4466r.clear();
        }
        this.f4454f.m8231b();
    }

    public static int m7936c() {
        return C1719y.m8194c();
    }

    public boolean m7963d() {
        return this.f4451c.isEnabled();
    }

    public void m7958a(int i, byte[] bArr) {
        if (2 != C1719y.m8199d()) {
            C2538c.m12679d("HuaweiWearableDeviceImpl", "sendCommand() Connection is not established! Please connect to a remote device first.");
            return;
        }
        this.f4454f.m8228a(i, bArr);
    }

    public C1694b m7955a(int i, byte[] bArr, int i2) {
        if (2 == C1719y.m8199d()) {
            return this.f4454f.m8225a(i, bArr, i2);
        }
        C2538c.m12674b("HuaweiWearableDeviceImpl", "sendCommandSyc() Connection is not established! Please connect to a remote device first.");
        C1694b c1694b = new C1694b();
        c1694b.f4435a = 10;
        return c1694b;
    }

    private void m7924a(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            C2538c.m12680e("HuaweiWearableDeviceImpl", "BluetoothDevice is null");
        } else if (bluetoothDevice.getBondState() != 12) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "BluetoothDevice ACTION_FOUND - " + bluetoothDevice.getName());
            m7937c(bluetoothDevice);
        }
    }

    private void m7931b(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            C2538c.m12680e("HuaweiWearableDeviceImpl", "ACTION_UUID with device == null.");
            return;
        }
        String name = bluetoothDevice.getName();
        C2538c.m12674b("HuaweiWearableDeviceImpl", "ACTION_UUID received for device:" + name);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        if (parcelableArrayExtra != null) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "get UUIDs by fetchUuidsWithSdp:");
            for (Object obj : parcelableArrayExtra) {
                C2538c.m12674b("HuaweiWearableDeviceImpl", "DEV:" + name + "; UUID:" + parcelableArrayExtra[r1].toString());
                if (obj.toString().equals("00001101-0000-1000-8000-00805F9B34FB")) {
                    C2538c.m12674b("HuaweiWearableDeviceImpl", "Found huawei bracelet device DEV:" + name);
                    m7942d(bluetoothDevice);
                }
            }
            return;
        }
        C2538c.m12674b("HuaweiWearableDeviceImpl", "EXTRA_UUID ArrayExtra is null");
    }

    private void m7946f() {
        if (12 == this.f4451c.getState()) {
            this.f4459k.m7865b();
            this.f4450b.unregisterReceiver(this.f4467s);
        } else if (11 == this.f4451c.getState()) {
            this.f4459k.m7864a();
        } else if (10 == this.f4451c.getState()) {
            this.f4459k.m7867d();
            this.f4450b.unregisterReceiver(this.f4467s);
        } else if (13 == this.f4451c.getState()) {
            this.f4459k.m7866c();
        }
    }

    private void m7938c(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "device = " + bluetoothDevice);
            if (bluetoothDevice.getBondState() == 12) {
                if (4 == C1700i.m8041a()) {
                    this.f4453e.m7869a(bluetoothDevice);
                    C2538c.m12680e("HuaweiWearableDeviceImpl", "绑定成功");
                }
                this.f4450b.unregisterReceiver(this.f4467s);
                return;
            } else if (bluetoothDevice.getBondState() == 11) {
                C2538c.m12680e("HuaweiWearableDeviceImpl", "绑定中");
                this.f4453e.m7868a(11);
                return;
            } else if (bluetoothDevice.getBondState() == 10) {
                C2538c.m12680e("HuaweiWearableDeviceImpl", "绑定失败");
                this.f4453e.m7870b(10);
                this.f4450b.unregisterReceiver(this.f4467s);
                return;
            } else {
                return;
            }
        }
        C2538c.m12680e("HuaweiWearableDeviceImpl", "actionBondStateChanged() device is null");
    }

    private boolean m7928a(BluetoothDevice bluetoothDevice) {
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        String name = bluetoothDevice.getName();
        C2538c.m12674b("HuaweiWearableDeviceImpl", "get Uuids by getUuids:");
        if (uuids != null) {
            for (ParcelUuid parcelUuid : uuids) {
                C2538c.m12674b("HuaweiWearableDeviceImpl", "DEV:" + name + "; UUID:" + uuids[r0].toString());
                if (parcelUuid.toString().equals("00001101-0000-1000-8000-00805F9B34FB")) {
                    C2538c.m12674b("HuaweiWearableDeviceImpl", "Found Huawei bracelet device DEV:" + name);
                    m7942d(bluetoothDevice);
                    return true;
                }
            }
            return false;
        }
        C2538c.m12674b("HuaweiWearableDeviceImpl", "getUuids return is null");
        return false;
    }

    private void m7930b(BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        synchronized (this.f4458j) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "current devNum:" + this.f4458j.size());
            int i = 0;
            while (i < r4) {
                if (this.f4458j.get(i) != null && ((BluetoothDevice) this.f4458j.get(i)).getAddress().equals(address)) {
                    C2538c.m12674b("HuaweiWearableDeviceImpl", "addr: " + address + " device is already in list.");
                    return;
                }
                i++;
            }
            this.f4458j.add(bluetoothDevice);
            C2538c.m12674b("HuaweiWearableDeviceImpl", "Found new addr: " + address + " device,total devNum= " + this.f4458j.size());
        }
    }

    private void m7948g() {
        if (this.f4451c == null) {
            this.f4451c = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.f4451c.isDiscovering()) {
            this.f4451c.cancelDiscovery();
        } else {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "No ClassBlueTooth Discovering");
        }
        if (!this.f4455g) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "mScanningBLE is false");
        } else if (this.f4463o != null) {
            this.f4463o.m7969a();
        } else {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "stopScanBLEThread is null");
        }
        if (this.f4456h) {
            this.f4457i = new C1684a(this.f4468t);
            try {
                this.f4455g = true;
                if (C1695a.m7889a() != null) {
                    C2538c.m12680e("HuaweiWearableDeviceImpl", "mHidService 不为空");
                    this.f4466r.addAll(C1695a.m7889a().getConnectedDevices());
                } else {
                    C2538c.m12680e("HuaweiWearableDeviceImpl", "mHidService 为空");
                }
                this.f4466r.addAll(this.f4465q.getConnectedDevices(7));
                C2538c.m12680e("HuaweiWearableDeviceImpl", "bluetoothDevices.size() = " + this.f4466r.size());
                this.f4455g = true;
                for (int i = 0; i < this.f4466r.size(); i++) {
                    m7937c((BluetoothDevice) this.f4466r.get(i));
                }
                for (int i2 = 0; i2 < 3; i2++) {
                    C2538c.m12680e("HuaweiWearableDeviceImpl", "mAdapter.startLeScan : " + this.f4451c.startLeScan(this.f4457i) + ", count:" + i2);
                    if (this.f4451c.startLeScan(this.f4457i)) {
                        break;
                    }
                }
                if (this.f4463o != null) {
                    this.f4463o = null;
                }
                this.f4462n = true;
                this.f4461m = 0;
                this.f4463o = new aq();
                this.f4463o.start();
                C2538c.m12680e("HuaweiWearableDeviceImpl", "Start BLE device discovery.");
                return;
            } catch (Exception e) {
                C2538c.m12680e("HuaweiWearableDeviceImpl", "BLE discovery Exception, mAdapter is dead " + e.getMessage());
                return;
            }
        }
        C2538c.m12674b("HuaweiWearableDeviceImpl", "BLE is not supported.");
    }

    private void m7950h() {
        if (this.f4451c == null) {
            this.f4451c = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.f4451c.isDiscovering()) {
            this.f4451c.cancelDiscovery();
        } else {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "No ClassBlueTooth Discovering");
        }
        if (!this.f4455g) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "mScanningBLE is false");
        } else if (this.f4463o != null) {
            this.f4463o.m7969a();
        } else {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "stopScanBLEThread is null");
        }
        this.f4464p = true;
        this.f4450b.registerReceiver(this.f4467s, new IntentFilter("android.bluetooth.device.action.FOUND"));
        this.f4450b.registerReceiver(this.f4467s, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"));
        this.f4450b.registerReceiver(this.f4467s, new IntentFilter("android.bluetooth.device.action.UUID"));
        C2538c.m12680e("HuaweiWearableDeviceImpl", "Start classic device discovery.");
        try {
            this.f4451c.startDiscovery();
        } catch (Exception e) {
            C2538c.m12680e("HuaweiWearableDeviceImpl", "Classic discovery Exception, mAdapter is dead " + e.getMessage());
        }
    }

    private void m7937c(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            C2538c.m12680e("HuaweiWearableDeviceImpl", "discovery device is null");
            return;
        }
        if (f4449a >= 18) {
            if (1 == bluetoothDevice.getType() && !m7928a(bluetoothDevice)) {
                bluetoothDevice.fetchUuidsWithSdp();
            }
            if (2 == bluetoothDevice.getType()) {
                C2538c.m12674b("HuaweiWearableDeviceImpl", "Found new BLE device, addr:" + bluetoothDevice.getAddress() + "");
            } else {
                m7930b(bluetoothDevice);
            }
        } else {
            m7930b(bluetoothDevice);
        }
        if (this.f4452d != null) {
            this.f4452d.mo2573a(bluetoothDevice);
        }
    }

    private void m7942d(BluetoothDevice bluetoothDevice) {
        if (this.f4452d != null) {
            this.f4452d.mo2575b(bluetoothDevice);
        }
    }

    private void m7951i() {
        C2538c.m12680e("HuaweiWearableDeviceImpl", "Finished BLE device discovery.");
        if (3 == this.f4460l) {
            m7950h();
        } else {
            m7953j();
        }
    }

    private void m7953j() {
        C2538c.m12680e("HuaweiWearableDeviceImpl", "Scan all devices exited.");
        if (this.f4452d != null) {
            this.f4452d.mo2571a();
            this.f4452d = null;
        }
        this.f4464p = false;
    }

    private void m7954k() {
        C2538c.m12680e("HuaweiWearableDeviceImpl", "Enter deviceDiscoveryCanceled().");
        if (this.f4452d != null) {
            this.f4452d.mo2574b();
            this.f4452d = null;
        }
        this.f4464p = false;
    }

    public void m7957a(int i) {
        this.f4454f.m8227a(i);
    }

    public void m7961a(byte[] bArr, C1620b c1620b) {
        this.f4454f.m8230a(bArr, c1620b);
    }
}
