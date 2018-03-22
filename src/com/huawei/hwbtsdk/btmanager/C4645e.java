package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hwbtsdk.p057b.p058a.C4604c;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: BLEReconnectManager */
public class C4645e {
    private int f16982a = 2000;
    private boolean f16983b = true;
    private C4648h f16984c = null;
    private boolean f16985d = false;
    private DeviceInfo f16986e = null;
    private HandlerThread f16987f = null;
    private Handler f16988g = null;
    private String f16989h = "";
    private C4604c f16990i = new C4646f(this);

    public C4645e() {
        m22277d();
    }

    private void m22277d() {
        this.f16987f = new HandlerThread("BLEReconnectManager");
        this.f16987f.start();
        this.f16988g = new C4647g(this, this.f16987f.getLooper());
    }

    public void m22284a(DeviceInfo deviceInfo) {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter tryToReconnectBLE()."});
        if (deviceInfo != null) {
            String deviceIdentify = deviceInfo.getDeviceIdentify();
            this.f16986e = deviceInfo;
            if (m22274b(deviceIdentify)) {
                C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User do not disconnect device so start to find device."});
                this.f16983b = false;
                m22273b(deviceInfo);
            }
        }
    }

    public void m22282a() {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter stopReconnectBLE()."});
        this.f16983b = true;
        this.f16982a = 2000;
        this.f16988g.removeMessages(1);
    }

    private void m22273b(DeviceInfo deviceInfo) {
        C2538c.b("01", 1, "BLEReconnectManager", new Object[]{"Enter reconnectBLEDevice()."});
        this.f16988g.removeMessages(1);
        Message obtainMessage = this.f16988g.obtainMessage(1, deviceInfo);
        if (m22281g()) {
            this.f16988g.sendMessageDelayed(obtainMessage, 4000);
            return;
        }
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Delay Time is: " + ((long) m22279e()) + "ms"});
        this.f16988g.sendMessageDelayed(obtainMessage, r2);
    }

    private int m22279e() {
        if (m22281g()) {
            return 1200000;
        }
        if (this.f16982a < 256000) {
            this.f16982a *= 2;
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"getReconnectDelayMillis(): delayMillis = " + this.f16982a});
            return this.f16982a;
        }
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"getReconnectDelayMillis(): delayMillis = 256000"});
        return 256000;
    }

    private void m22276c(DeviceInfo deviceInfo) {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter reconnectBLEDeviceDelay()  with mIsCancel = " + this.f16983b});
        if (this.f16983b) {
            C2538c.b("01", 1, "BLEReconnectManager", new Object[]{"device already connected so stop reconnect."});
            m22282a();
        } else if (3 == C4600d.m21899a().m21944c()) {
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"BT switch is on."});
            m22278d(deviceInfo);
        } else {
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"BT switch is not on."});
            m22282a();
        }
    }

    private void m22278d(DeviceInfo deviceInfo) {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter tryConnectBleDevice()."});
        if (deviceInfo == null) {
            C2538c.a("0xA0200005", "01", 1, "BLEReconnectManager", new Object[]{"device is null."});
            return;
        }
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Device identify = " + C4600d.m21899a().m21950d(deviceInfo.getDeviceIdentify())});
        if (this.f16984c == null) {
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"mSendCommandUtil is null."});
        } else if (2 == this.f16984c.m22365b() || 1 == this.f16984c.m22365b()) {
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"do not need reconnect with status = " + this.f16984c.m22365b()});
        } else {
            this.f16985d = false;
            if (m22274b(deviceInfo.getDeviceIdentify())) {
                C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User do not disable current device, so start to discover ble device."});
                C4600d.m21899a().m21934a(null, 2, this.f16990i);
                return;
            }
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User disabled current device, so do not need to connect wanted device."});
        }
    }

    private void m22280f() {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter doConnectBleDevice()."});
        if (this.f16984c != null) {
            this.f16984c.m22368c();
            return;
        }
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"mSendCommandUtil is null."});
    }

    private void m22270a(String str, BluetoothDevice bluetoothDevice, String str2) {
        if (!this.f16985d) {
            if (TextUtils.equals(str2, str)) {
                C2538c.b("01", 1, "BLEReconnectManager", new Object[]{"Find the wanted device."});
                this.f16985d = true;
                C2538c.c("01", 0, "BLEReconnectManager", new Object[]{"Enter verifySearchDestDeviceToReconnect()."});
                C4600d.m21899a().m21951d();
                if (m22274b(str2)) {
                    C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User do not disable current device, so start to connect wanted device."});
                    m22280f();
                    return;
                }
                C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"User disabled current device, so do not need  to connect wanted device."});
                return;
            }
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"verifySearchDestDeviceToReconnect(): find different device."});
        }
    }

    public void m22283a(C4648h c4648h) {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter setSendCommandUtilInfo()."});
        this.f16984c = c4648h;
        if (this.f16984c != null && this.f16984c.m22376h() != null) {
            String deviceIdentify = this.f16984c.m22376h().getDeviceIdentify();
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"set identify = " + C4600d.m21899a().m21950d(deviceIdentify)});
        }
    }

    public C4648h m22286b() {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"Enter getSendCommandUtilInfo()."});
        return this.f16984c;
    }

    public String m22287c() {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"get identify = " + C4600d.m21899a().m21950d(this.f16989h)});
        return this.f16989h;
    }

    public void m22285a(String str) {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"set identify = " + C4600d.m21899a().m21950d(str)});
        this.f16989h = str;
    }

    private boolean m22274b(String str) {
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"isWantedReconnectDeviceExist with identify = " + C4600d.m21899a().m21950d(str)});
        return this.f16989h.equalsIgnoreCase(str);
    }

    private boolean m22281g() {
        try {
            BaseApplication.b().getPackageManager().getApplicationInfo("com.huawei.iconnect", 0);
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"iconnect pkg exist."});
            return true;
        } catch (NameNotFoundException e) {
            C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"iconnect pkg do not exist."});
            return false;
        }
    }
}
