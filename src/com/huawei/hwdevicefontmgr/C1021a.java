package com.huawei.hwdevicefontmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.nio.ByteBuffer;

/* compiled from: HWDeviceFontManager */
public class C1021a extends C0628a {
    private static C1021a f1822a;
    private C1204c f1823b;
    private Context f1824c;
    private IBaseResponseCallback f1825d = new b(this);
    private final BroadcastReceiver f1826e = new c(this);

    public static C1021a m3912a(Context context) {
        if (f1822a == null) {
            C2538c.m12680e("HWDeviceFontManager", "getInstance() context = " + context);
            f1822a = new C1021a(BaseApplication.m2632b());
        }
        return f1822a;
    }

    private C1021a(Context context) {
        super(context);
        this.f1824c = context;
        this.f1823b = C1204c.m5370a(this.f1824c);
        if (this.f1823b != null) {
            this.f1823b.m5423a(12, this.f1825d);
        } else {
            C2538c.m12680e("HWDeviceFontManager", "HWDeviceFontManager() hwDeviceConfigManager is null");
        }
        m3913c();
    }

    protected Integer getModuleId() {
        return Integer.valueOf(12);
    }

    public void m3914a() {
        int i;
        int i2;
        byte b;
        ByteBuffer allocate;
        C2538c.m12680e("HWDeviceFontManager", "setDeviceLanguage()");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(12);
        deviceCommand.setCommandID(1);
        C2538c.m12677c("HWDeviceFontManager", "sendLanguage is ", C0977d.m3553d());
        byte[] b2 = C0973a.m3512b(C0973a.m3518e(r0));
        if (this.f1823b != null) {
            DeviceInfo c = this.f1823b.m5447c();
            if (!(c == null || 2 != c.getDeviceProtocol() || 7 == c.getProductType() || 14 == c.getProductType())) {
                C2538c.m12677c("HWDeviceFontManager", "Need set unit info.");
                if (C0956c.m3349a()) {
                    i = 1;
                } else {
                    i = 0;
                }
                C2538c.m12677c("HWDeviceFontManager", "unit info = " + i);
                i2 = i;
                b = (byte) 1;
                if (b == (byte) 0) {
                    i = ((b2.length + 1) + 1) + 3;
                } else {
                    i = (b2.length + 1) + 1;
                }
                allocate = ByteBuffer.allocate(i);
                allocate.put((byte) 1);
                allocate.put((byte) b2.length);
                allocate.put(b2);
                if (b != (byte) 0) {
                    allocate.put((byte) 2);
                    allocate.put((byte) 1);
                    allocate.put((byte) i2);
                }
                deviceCommand.setDataLen(allocate.array().length);
                deviceCommand.setDataContent(allocate.array());
                C2538c.m12677c("HWDeviceFontManager", "setDeviceLanguage(): Command = " + C0973a.m3506a(deviceCommand.getServiceID()) + C0973a.m3506a(deviceCommand.getCommandID()) + C0973a.m3509a(deviceCommand.getDataContent()));
                if (this.f1823b == null) {
                    this.f1823b.m5427a(deviceCommand);
                }
                C2538c.m12680e("HWDeviceFontManager", "hwDeviceConfigManager is null.");
                return;
            }
        }
        i2 = 0;
        b = (byte) 0;
        if (b == (byte) 0) {
            i = (b2.length + 1) + 1;
        } else {
            i = ((b2.length + 1) + 1) + 3;
        }
        allocate = ByteBuffer.allocate(i);
        allocate.put((byte) 1);
        allocate.put((byte) b2.length);
        allocate.put(b2);
        if (b != (byte) 0) {
            allocate.put((byte) 2);
            allocate.put((byte) 1);
            allocate.put((byte) i2);
        }
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        C2538c.m12677c("HWDeviceFontManager", "setDeviceLanguage(): Command = " + C0973a.m3506a(deviceCommand.getServiceID()) + C0973a.m3506a(deviceCommand.getCommandID()) + C0973a.m3509a(deviceCommand.getDataContent()));
        if (this.f1823b == null) {
            C2538c.m12680e("HWDeviceFontManager", "hwDeviceConfigManager is null.");
            return;
        }
        this.f1823b.m5427a(deviceCommand);
    }

    public void m3915b() {
        if (this.f1823b != null) {
            C2538c.m12677c("HWDeviceFontManager", "autoSendCommend()  send command begin");
            DeviceCapability a = C0972a.m3499a();
            if (a == null) {
                C2538c.m12677c("HWDeviceFontManager", "setDeviceLanguage(), deviceCapability is null");
                return;
            } else if (a.isLanguage()) {
                C2538c.m12677c("HWDeviceFontManager", "autoSendCommend()  send ");
                m3914a();
                return;
            } else {
                C2538c.m12677c("HWDeviceFontManager", "setDeviceLanguage(), not support language set");
                return;
            }
        }
        C2538c.m12680e("HWDeviceFontManager", "autoSendCommend() deviceInfo is null");
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void m3913c() {
        C2538c.m12677c("HWDeviceFontManager", "Enter registerUnitRefreshBroadcast():");
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.REFRESH_UNIT");
        intentFilter.addAction("com.huawei.bone.action.REFRESH_UNIT");
        if (this.f1824c != null) {
            this.f1824c.registerReceiver(this.f1826e, intentFilter, C0976c.f1642a, null);
        }
    }
}
