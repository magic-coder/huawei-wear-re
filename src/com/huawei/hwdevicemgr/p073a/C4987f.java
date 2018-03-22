package com.huawei.hwdevicemgr.p073a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.hwbtsdk.p399a.C4619w;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceMgr */
class C4987f implements C0958f {
    final /* synthetic */ C1023c f18070a;

    C4987f(C1023c cVar) {
        this.f18070a = cVar;
    }

    public void m23925a(DeviceInfo deviceInfo, int i) {
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Enter onDeviceConnectionStateChanged() with state = " + i});
        if (C1023c.a(this.f18070a) != null && deviceInfo != null) {
            if (2 != i) {
                C1023c.a(this.f18070a, false);
                if (C1023c.e(this.f18070a) != null) {
                    C1023c.e(this.f18070a).m23989d();
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"onDeviceConnectionStateChanged otaReportDisconnect"});
                }
            }
            if (2 != i) {
                if (!(-2 == deviceInfo.getProductType() || 1 != i || C1023c.f(this.f18070a) == null)) {
                    int d = C1023c.f(this.f18070a).m26563d();
                    if (1 == d || 2 == d) {
                        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"AF500 is connected while connect other device, so disconnect AF500 device."});
                        C1023c.f(this.f18070a).m26552a();
                    }
                }
                C1023c.a(this.f18070a, i);
                deviceInfo.setDeviceConnectState(i);
                String deviceIdentify = deviceInfo.getDeviceIdentify();
                synchronized (C1023c.c(this.f18070a)) {
                    int a = C1023c.a(this.f18070a, deviceIdentify);
                    if (-1 != a) {
                        ((DeviceInfo) C1023c.a(this.f18070a).get(a)).setDeviceConnectState(i);
                        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Update DeviceInfo state with index = " + a});
                    }
                }
                C1023c.b(this.f18070a, false);
                C1023c.a(this.f18070a, deviceInfo);
            } else if (2 == C1023c.g(this.f18070a)) {
                C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Already finish handshake and repeat report connected."});
                if (-1 == deviceInfo.getDeviceProtocol()) {
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"The device user choose already active and connect so report."});
                    int a2 = C1023c.a(this.f18070a, deviceInfo.getDeviceIdentify());
                    if (-1 != a2) {
                        deviceInfo.setDeviceActiveState(((DeviceInfo) C1023c.a(this.f18070a).get(a2)).getDeviceActiveState());
                        deviceInfo.setProductType(((DeviceInfo) C1023c.a(this.f18070a).get(a2)).getProductType());
                        deviceInfo.setDeviceName(((DeviceInfo) C1023c.a(this.f18070a).get(a2)).getDeviceName());
                        deviceInfo.setDeviceProtocol(((DeviceInfo) C1023c.a(this.f18070a).get(a2)).getDeviceProtocol());
                        C1023c.a(this.f18070a, deviceInfo);
                        return;
                    }
                    return;
                }
                C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Already has the active device so report connected state."});
                C1023c.a(this.f18070a, deviceInfo);
            } else if (C1023c.h(this.f18070a)) {
                C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Already Start handshake."});
            } else {
                C1023c.b(this.f18070a, true);
                C4625b c;
                if (2 == deviceInfo.getDeviceProtocol()) {
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Start to get product type."});
                    c.b(this.f18070a, "");
                    c.c(this.f18070a, "");
                    c = C4610m.m21987c(deviceInfo.getDeviceBTType());
                    c.m22109a(deviceInfo.getDeviceIdentify());
                    if (c.i(this.f18070a) != null) {
                        c.i(this.f18070a).a(c);
                        return;
                    }
                    return;
                }
                c.b(this.f18070a, this.f18070a.a.m21939b(deviceInfo.getDeviceName()));
                if (-1 == c.j(this.f18070a)) {
                    C2538c.b("02", 0, "HWDeviceMgr", new Object[]{"The product type is unknown base name."});
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Device product type = " + deviceInfo.getProductType()});
                    if (-1 != deviceInfo.getProductType()) {
                        c.b(this.f18070a, deviceInfo.getProductType());
                    } else {
                        C2538c.b("02", 0, "HWDeviceMgr", new Object[]{"The product type is unknown base old device info."});
                        return;
                    }
                }
                deviceInfo.setProductType(c.j(this.f18070a));
                if (3 == c.j(this.f18070a) || -2 == c.j(this.f18070a)) {
                    c.k(this.f18070a).resetDeviceCapability();
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"report connect state, watch layer = " + deviceInfo.getDeviceProtocol()});
                    if (deviceInfo.getDeviceBTType() == 0 && 1 == deviceInfo.getDeviceProtocol()) {
                        C4619w.m22049a(c.b(this.f18070a), 3, c.k(this.f18070a));
                    }
                    if (-2 == c.j(this.f18070a)) {
                        c.k(this.f18070a).resetDeviceCapability();
                        C4619w.m22050a(c.k(this.f18070a));
                    }
                    c.b(this.f18070a, deviceInfo);
                    return;
                }
                if (deviceInfo.getDeviceProtocol() == 0) {
                    c = C4610m.m21963a(c.b(this.f18070a));
                } else {
                    c = C4610m.m21980b();
                }
                c.m22109a(deviceInfo.getDeviceIdentify());
                if (c.i(this.f18070a) != null) {
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Start to set device time."});
                    c.i(this.f18070a).a(c);
                }
            }
        }
    }

    public void m23926a(DeviceInfo deviceInfo, int i, byte[] bArr) {
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Enter onDataReceived() with mDuringHandshake = " + C1023c.h(this.f18070a)});
        if (C1023c.h(this.f18070a)) {
            C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Enter onDataReceived() Handshake with dataContent = " + C0973a.a(bArr)});
            if ((byte) 1 == bArr[0] && (byte) 7 == bArr[1]) {
                C1023c.a(this.f18070a, deviceInfo, bArr);
                return;
            } else if ((byte) 1 == bArr[0] && (byte) 5 == bArr[1]) {
                C1023c.b(this.f18070a, deviceInfo, bArr);
                return;
            } else if ((byte) 1 == bArr[0] && (byte) 2 == bArr[1]) {
                C1023c.c(this.f18070a, deviceInfo, bArr);
                return;
            } else if ((byte) 1 == bArr[0] && (byte) 3 == bArr[1]) {
                C1023c.d(this.f18070a, deviceInfo, bArr);
                return;
            } else if ((byte) 1 == bArr[0] && TagName.THIRD_PAY_NUMBER == bArr[1]) {
                C1023c.e(this.f18070a, deviceInfo, bArr);
                return;
            } else if ((byte) 2 == bArr[0] && (byte) 5 == bArr[1]) {
                C1023c.f(this.f18070a, deviceInfo, bArr);
                return;
            } else if ((byte) 1 == bArr[0] && TagName.ORDER_TIME == bArr[1]) {
                C1023c.g(this.f18070a, deviceInfo, bArr);
                return;
            } else {
                C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"handshake report data."});
                if (C1023c.l(this.f18070a) != null) {
                    C1023c.l(this.f18070a).a(deviceInfo, i, bArr);
                } else {
                    C2538c.b("02", 0, "HWDeviceMgr", new Object[]{"mDeviceStateClientCallback is null."});
                }
                if (C1023c.e(this.f18070a) != null) {
                    C1023c.e(this.f18070a).m23982a(bArr);
                    return;
                }
                return;
            }
        }
        C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"not handshake report data."});
        if (C1023c.l(this.f18070a) != null) {
            C1023c.l(this.f18070a).a(deviceInfo, i, bArr);
        } else {
            C2538c.b("02", 0, "HWDeviceMgr", new Object[]{"mDeviceStateClientCallback is null."});
        }
        if (C1023c.e(this.f18070a) != null) {
            C1023c.e(this.f18070a).m23982a(bArr);
        }
    }
}
