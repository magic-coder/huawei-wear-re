package com.huawei.p169s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.datatype.GPSStruct;
import com.huawei.datatype.GpsParameter;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwlocationmgr.a.a;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p190v.C2538c;
import com.huawei.s.c;
import com.huawei.s.d;
import com.huawei.s.e;
import com.huawei.s.f;
import com.huawei.s.g;
import com.huawei.s.h;
import com.huawei.s.i;
import com.huawei.s.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWGPSLocationManager */
public class C1972b implements IParser {
    private static C1972b f6841f;
    IBaseResponseCallback f6842a = new c(this);
    IBaseResponseCallback f6843b = new d(this);
    IBaseResponseCallback f6844c = new e(this);
    a f6845d = new f(this);
    IBaseResponseCallback f6846e = new g(this);
    private Context f6847g;
    private boolean f6848h = true;
    private long f6849i = 0;
    private GpsParameter f6850j;
    private List<GPSStruct> f6851k = new ArrayList();
    private i f6852l;
    private String f6853m = "";
    private long f6854n;
    private BroadcastReceiver f6855o = new h(this);

    public static C1972b m10261a() {
        if (f6841f == null) {
            f6841f = new C1972b(BaseApplication.m2632b());
        }
        return f6841f;
    }

    private C1972b(Context context) {
        this.f6847g = context;
        this.f6852l = new i(this);
        this.f6847g.registerReceiver(this.f6855o, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), C0976c.f1642a, null);
        DeviceInfo d = m10270d();
        if (d != null) {
            this.f6853m = d.getDeviceIdentify();
        }
        m10279b(this.f6844c);
        if (com.huawei.s.a.e() && d != null && 2 == d.getDeviceConnectState()) {
            m10278b();
        }
    }

    private DeviceInfo m10270d() {
        List<DeviceInfo> a = C1023c.m3920a(BaseApplication.m2632b()).m3984a();
        if (a.size() != 0) {
            C2538c.m12677c("HWGPSLocationManager", "getCurrentDeviceInfo() deviceList.size() = " + a.size());
            for (DeviceInfo deviceInfo : a) {
                if (1 == deviceInfo.getDeviceActiveState()) {
                    return deviceInfo;
                }
            }
            C2538c.m12680e("HWGPSLocationManager", "getCurrentDeviceInfo() device's ActiveState not DeviceActiveState.DEVICE_ACTIVE_ENABLE");
            return null;
        }
        C2538c.m12680e("HWGPSLocationManager", "getCurrentDeviceInfo() deviceInfoList is null");
        return null;
    }

    private void m10263a(DeviceCommand deviceCommand) {
        C2538c.m12677c("HWGPSLocationManager", "sendCommand  deviceCommand = " + C0973a.m3509a(deviceCommand.getDataContent()));
        C1023c.m3920a(BaseApplication.m2632b()).m3995b(deviceCommand);
    }

    public void m10275a(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (com.huawei.s.a.a()) {
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(24);
            deviceCommand.setCommandID(1);
            String e = C0973a.m3517e(0);
            String a = C0973a.m3506a(129);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            m10263a(deviceCommand);
            com.huawei.s.a.a().add(iBaseResponseCallback);
        }
    }

    public void m10274a(int i) {
        synchronized (com.huawei.s.a.a()) {
            C2538c.m12674b("HWGPSLocationManager", "getGPSParameter = ");
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(24);
            deviceCommand.setCommandID(2);
            String a = C0973a.m3507a((long) i);
            String a2 = C0973a.m3506a(a.length() / 2);
            String a3 = C0973a.m3506a(127);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a3);
            stringBuilder.append(a2);
            stringBuilder.append(a);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            m10263a(deviceCommand);
        }
    }

    public void m10276a(List<GPSStruct> list, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        synchronized (com.huawei.s.a.b()) {
            C2538c.m12674b("HWGPSLocationManager", "gpsStructs.size() = " + list.size());
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(24);
            deviceCommand.setCommandID(3);
            String a = com.huawei.s.a.a("", list, z);
            C2538c.m12677c("HWGPSLocationManager", "setGPSParameter(): gpsListValueHex = " + a);
            String e = C0973a.m3517e(a.length() / 2);
            String a2 = C0973a.m3506a(129);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a2);
            stringBuilder.append(e);
            stringBuilder.append(a);
            C2538c.m12677c("HWGPSLocationManager", "setGPSParameter(): gpsListHex = " + stringBuilder.toString());
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            m10263a(deviceCommand);
            com.huawei.s.a.b().add(iBaseResponseCallback);
        }
    }

    public void m10277a(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (com.huawei.s.a.d()) {
            String a;
            String a2;
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(24);
            deviceCommand.setCommandID(4);
            String str = "";
            str = "";
            str = "";
            if (z) {
                str = C0973a.m3506a(1);
                a = C0973a.m3506a(255);
                a2 = C0973a.m3506a(1);
            } else {
                str = C0973a.m3506a(0);
                a = C0973a.m3506a(15);
                a2 = C0973a.m3506a(1);
            }
            String a3 = C0973a.m3506a(1);
            String a4 = C0973a.m3506a(1);
            String a5 = C0973a.m3506a(2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a3);
            stringBuilder.append(a2);
            stringBuilder.append(a);
            stringBuilder.append(a5);
            stringBuilder.append(a4);
            stringBuilder.append(str);
            deviceCommand.setDataLen(stringBuilder.length() / 2);
            deviceCommand.setDataContent(C0973a.m3512b(stringBuilder.toString()));
            m10263a(deviceCommand);
            com.huawei.s.a.d().add(iBaseResponseCallback);
        }
    }

    public void m10279b(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (com.huawei.s.a.c()) {
            com.huawei.s.a.c().add(iBaseResponseCallback);
        }
    }

    public void getResult(byte[] bArr) {
        C2538c.m12677c("HWGPSLocationManager", "getResult(): " + C0973a.m3509a(bArr));
        j.a(bArr);
    }

    public void m10278b() {
        boolean isSupportGPSSetParameter;
        DeviceCapability b = C1023c.m3920a(BaseApplication.m2632b()).m3993b();
        if (b != null) {
            isSupportGPSSetParameter = b.isSupportGPSSetParameter();
        } else {
            isSupportGPSSetParameter = false;
        }
        C2538c.m12677c("HWGPSLocationManager", "isSupportGPSSetParamet:" + isSupportGPSSetParameter);
        if (!isSupportGPSSetParameter) {
            m10275a(this.f6842a);
        } else if (C0977d.m3559f()) {
            C2538c.m12677c("HWGPSLocationManager", "is EMUI5.0");
            m10277a(true, this.f6843b);
        } else {
            C2538c.m12677c("HWGPSLocationManager", "not EMUI5.0");
            m10277a(false, this.f6843b);
        }
    }

    public void m10280c() {
        if (this.f6848h) {
            C2538c.m12674b("HWGPSLocationManager", "unRegisterLocationCallback");
            com.huawei.hwlocationmgr.b.a.a(this.f6847g).b(this.f6845d);
            this.f6848h = false;
        }
    }

    private void m10264a(boolean z) {
        int i;
        long currentTimeMillis;
        C2538c.m12677c("HWGPSLocationManager", "is open:" + z);
        if (z) {
            try {
                if (BaseApplication.m2632b().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    i = 0;
                    if (z || r0 == 0) {
                        currentTimeMillis = System.currentTimeMillis();
                        C2538c.m12677c("HWGPSLocationManager", "currentTime is:" + currentTimeMillis + ";showTime is:" + this.f6854n);
                        if (currentTimeMillis - this.f6854n > 7200000) {
                            C2538c.m12677c("HWGPSLocationManager", "is over 2hours");
                            this.f6854n = currentTimeMillis;
                            Intent intent = new Intent("com.huawei.bone.action.open_gps");
                            intent.setPackage("com.huawei.bone");
                            BaseApplication.m2632b().sendOrderedBroadcast(intent, C0976c.f1642a);
                        }
                    }
                    return;
                }
            } catch (NoSuchMethodError e) {
                C2538c.m12680e("HWGPSLocationManager", "checkPermission:" + e.getMessage());
            }
        }
        i = 1;
        if (z) {
        }
        currentTimeMillis = System.currentTimeMillis();
        C2538c.m12677c("HWGPSLocationManager", "currentTime is:" + currentTimeMillis + ";showTime is:" + this.f6854n);
        if (currentTimeMillis - this.f6854n > 7200000) {
            C2538c.m12677c("HWGPSLocationManager", "is over 2hours");
            this.f6854n = currentTimeMillis;
            Intent intent2 = new Intent("com.huawei.bone.action.open_gps");
            intent2.setPackage("com.huawei.bone");
            BaseApplication.m2632b().sendOrderedBroadcast(intent2, C0976c.f1642a);
        }
    }
}
