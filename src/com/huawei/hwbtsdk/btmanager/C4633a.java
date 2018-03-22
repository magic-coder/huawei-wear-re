package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothInputDevice;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p057b.p058a.C4622e;
import com.huawei.hwbtsdk.p057b.p400b.C4624a;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.hwbtsdk.p399a.C4612o;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: BLEAuthenticManager */
public class C4633a {
    private Context f16919a;
    private HandlerThread f16920b = null;
    private Handler f16921c = null;
    private boolean f16922d = false;
    private boolean f16923e = false;
    private boolean f16924f = false;
    private int f16925g = 0;
    private BluetoothDevice f16926h = null;
    private C4648h f16927i = null;
    private C0958f f16928j;
    private DeviceInfo f16929k;
    private C4622e f16930l = new C4643c(this);

    public C4633a(C4648h c4648h, Context context, BluetoothDevice bluetoothDevice, C0958f fVar) {
        this.f16927i = c4648h;
        this.f16919a = context;
        this.f16926h = bluetoothDevice;
        this.f16928j = fVar;
        m22173b();
    }

    private void m22173b() {
        this.f16920b = new HandlerThread("BLEAuthenticManager");
        this.f16920b.start();
        this.f16921c = new C4644d(this, this.f16920b.getLooper());
    }

    public boolean m22183a(DeviceInfo deviceInfo, byte[] bArr) {
        this.f16929k = deviceInfo;
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"processPairResponse with mBTDeviceInfo =" + this.f16925g + " isAllowBind = " + C4610m.m21979b(this.f16919a, bArr)});
        switch (C4610m.m21979b(this.f16919a, bArr)) {
            case 0:
                m22165a(4, false);
                C2538c.b("01", 1, "BLEAuthenticManager", new Object[]{"user refuse to allow connect device."});
                if (this.f16927i == null) {
                    return true;
                }
                this.f16927i.m22363a(false, 4);
                this.f16927i.m22372d(false);
                this.f16927i.m22371d();
                return true;
            case 1:
                if (2 == this.f16925g) {
                    byte[] b = C0973a.b(C0973a.e(this.f16926h.getAddress().replace(":", "") + "0000"));
                    C2538c.c("01", 0, "BLEAuthenticManager", new Object[]{"CommandPackage.key = " + C4612o.m22004a(this.f16919a).m22014b()});
                    byte[] c = C4612o.m22004a(this.f16919a).m22016c();
                    byte[] d = C4612o.m22004a(this.f16919a).m22017d();
                    if (c == null || d == null || b == null) {
                        c.b("01", 1, "BLEAuthenticManager", new Object[]{"CX info is incorrect."});
                    } else {
                        C4612o.m22004a(this.f16919a).m22011a(this.f16926h.getAddress(), c, "btsdk_sharedpreferences_name1", this.f16919a);
                        C4612o.m22004a(this.f16919a).m22011a(this.f16926h.getAddress(), d, "btsdk_sharedpreferences_name2", this.f16919a);
                        C4612o.m22004a(this.f16919a).m22011a(this.f16926h.getAddress(), b, "btsdk_sharedpreferences_name3", this.f16919a);
                        C4612o.m22004a(this.f16919a).m22011a(this.f16926h.getAddress(), C0973a.b(r3), "btsdk_sharedpreferences_name4", this.f16919a);
                    }
                }
                switch (this.f16925g) {
                    case 0:
                        C4612o.m22004a(this.f16919a).m22015b(this.f16919a);
                        this.f16921c.sendEmptyMessageDelayed(4, 1000);
                        return true;
                    case 1:
                        m22165a(2, false);
                        return true;
                    case 2:
                        m22165a(2, false);
                        return true;
                    default:
                        return true;
                }
            default:
                return false;
        }
    }

    private void m22167a(DeviceInfo deviceInfo, int i) {
        if (12 == i && 1 == deviceInfo.getDeviceProtocol()) {
            m22182a(this.f16926h, true);
            return;
        }
        String a = C4612o.m22004a(this.f16919a).m22008a(this.f16926h.getAddress(), this.f16919a);
        C2538c.c("01", 0, "BLEAuthenticManager", new Object[]{"Encrypt key = " + a});
        if (this.f16929k != null && a != null && 2 == deviceInfo.getDeviceProtocol() && 64 == a.length()) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"Need to reset v2 key info empty."});
            C4612o.m22004a(this.f16919a).m22011a(this.f16926h.getAddress(), a.b(""), "btsdk_sharedpreferences_name4", this.f16919a);
        }
        this.f16921c.sendEmptyMessageDelayed(1, 1000);
    }

    private void m22168a(DeviceInfo deviceInfo, C4624a c4624a, int i) {
        if (c4624a.m22103c() != 0) {
            String a = C4612o.m22004a(this.f16919a).m22008a(this.f16926h.getAddress(), this.f16919a);
            C2538c.c("01", 0, "BLEAuthenticManager", new Object[]{"Encrypt key = " + a});
            if (this.f16929k != null && a != null && 2 == deviceInfo.getDeviceProtocol() && 64 == a.length()) {
                C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"Need to reset v2 key info empty."});
                C4612o.m22004a(this.f16919a).m22011a(this.f16926h.getAddress(), a.b(""), "btsdk_sharedpreferences_name4", this.f16919a);
            }
            if (a == null || a.equals("")) {
                this.f16921c.sendEmptyMessageDelayed(1, 1000);
                C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"手机侧未配对，手环侧新版本，手机侧没有key，发起配对!"});
                return;
            }
            m22165a(2, false);
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"手机侧未配对，手环侧新版本，手机侧有key，上报连接成功!"});
        } else if (12 == i) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"手机侧已配对，查询手环侧配对OK，上报连接成功!"});
            m22165a(2, false);
            if (C4600d.m21899a().f16827a != null) {
                Message obtainMessage = this.f16921c.obtainMessage(3);
                obtainMessage.obj = this.f16926h;
                this.f16921c.sendMessageDelayed(obtainMessage, 1000);
                return;
            }
            C2538c.b("01", 1, "BLEAuthenticManager", new Object[]{"start connectHidService() failure for HidService is null."});
        } else {
            this.f16921c.sendEmptyMessageDelayed(1, 1000);
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"手机侧未配对，手环侧老版本，发起配对!"});
        }
    }

    public boolean m22184b(DeviceInfo deviceInfo, byte[] bArr) {
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"Enter processBondStatusResponse()."});
        this.f16929k = deviceInfo;
        C4624a a = C4610m.m21961a(this.f16919a, bArr);
        if (a == null) {
            C2538c.a("0xA0200007", "01", 1, "BLEAuthenticManager", new Object[]{"bondState parameter is incorrect."});
            return false;
        }
        this.f16925g = a.m22103c();
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"mBTVersionInfo = " + this.f16925g});
        int d = a.m22105d();
        if (d != 0) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"bt_service_mtu need to modify,bt_service_mtu = " + d});
            this.f16927i.m22358a(d);
        } else {
            this.f16927i.m22358a(128);
        }
        C2538c.c("01", 0, "BLEAuthenticManager", new Object[]{"mBTDevice = " + this.f16926h});
        d = this.f16926h.getBondState();
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"deviceBondState = " + d + " BT_bind_status =" + a.m22099a() + " BT_bind_status_info = " + a.m22101b()});
        switch (a.m22099a()) {
            case 0:
                m22167a(deviceInfo, d);
                break;
            case 1:
                if (1 != a.m22101b()) {
                    if (!this.f16923e) {
                        C2538c.b("01", 1, "BLEAuthenticManager", new Object[]{"查询手环配对状态回复错误！重新发送查询配对状态命令."});
                        this.f16921c.sendEmptyMessage(5);
                        this.f16923e = true;
                        break;
                    }
                    C2538c.b("01", 1, "BLEAuthenticManager", new Object[]{"查询手环配对状态2次回复错误！断开连接."});
                    m22180a();
                    this.f16923e = false;
                    break;
                }
                m22168a(deviceInfo, a, d);
                break;
        }
        return true;
    }

    public void m22181a(BluetoothDevice bluetoothDevice, C4622e c4622e) {
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"pairDevice(), result = " + C4600d.m21899a().m21936a(bluetoothDevice, c4622e)});
        if (!C4600d.m21899a().m21936a(bluetoothDevice, c4622e)) {
            if (this.f16924f) {
                this.f16924f = false;
                m22180a();
                C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"pairDeviceFlag = " + this.f16924f});
                return;
            }
            this.f16921c.postDelayed(new C4634b(this, bluetoothDevice, c4622e), 1000);
        }
    }

    public boolean m22182a(BluetoothDevice bluetoothDevice, boolean z) {
        this.f16922d = z;
        boolean a = C4600d.m21899a().m21935a(bluetoothDevice);
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"unPairDevice() 解绑失败 unPair = " + a + " reConnectFlag = " + z});
        if (a && z) {
            m22180a();
            this.f16921c.sendEmptyMessageDelayed(2, 5000);
        } else {
            if (a || !z) {
                C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"unPairDevice() 解绑成功，清除Key."});
                C4612o.m22004a(this.f16919a).m22015b(this.f16919a);
            } else {
                C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"unPairDevice() 解绑失败."});
            }
            this.f16922d = false;
            m22180a();
        }
        return a;
    }

    private void m22165a(int i, boolean z) {
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"Enter reportConnectStatus() status = " + i + " flag = " + z});
        if (3 == i || i == 0) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"unPairFlag=" + this.f16922d + ",status=" + i});
            if (this.f16922d) {
                return;
            }
        } else if (1 == i && this.f16922d) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"解绑重连上报正在连接."});
            return;
        }
        if (2 == this.f16925g) {
            this.f16929k.setEncryptType(1);
        } else {
            this.f16929k.setEncryptType(0);
        }
        if (2 == i) {
            this.f16927i.m22363a(false, 2);
        }
        this.f16928j.a(this.f16929k, i);
    }

    private boolean m22169a(BluetoothInputDevice bluetoothInputDevice, BluetoothDevice bluetoothDevice) {
        if (bluetoothInputDevice == null || bluetoothDevice == null) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"connectHidService() bluetoothInputDevice or device is null."});
            return false;
        } else if (2 != bluetoothInputDevice.getConnectionState(bluetoothDevice)) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"start connectHidService() with flag = " + bluetoothInputDevice.connect(bluetoothDevice)});
            return bluetoothInputDevice.connect(bluetoothDevice);
        } else {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"connectHidService() HID is connected."});
            return false;
        }
    }

    public void m22180a() {
        if (!(C4600d.m21899a().f16827a == null || this.f16926h == null)) {
            m22174b(C4600d.m21899a().f16827a, this.f16926h);
        }
        if (this.f16927i.m22373e() != null) {
            this.f16927i.m22373e().mo2295b();
        }
        this.f16925g = 0;
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"disconnect end."});
    }

    private boolean m22174b(BluetoothInputDevice bluetoothInputDevice, BluetoothDevice bluetoothDevice) {
        if (bluetoothInputDevice == null || bluetoothDevice == null) {
            C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"closeHidService() bluetoothInputDevice or device is null."});
            return false;
        }
        C2538c.a("01", 1, "BLEAuthenticManager", new Object[]{"start closeHidService() with flag = " + bluetoothInputDevice.disconnect(bluetoothDevice)});
        return bluetoothInputDevice.disconnect(bluetoothDevice);
    }
}
