package com.huawei.ui.device.activity.device;

import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.n.a;
import com.huawei.n.b;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.p137a.C1383f;
import com.huawei.ui.device.p170a.C1988p;

/* compiled from: DeviceManagerListActivity */
class C2041k implements Runnable {
    final /* synthetic */ boolean f7146a;
    final /* synthetic */ DeviceManagerListActivity f7147b;

    C2041k(DeviceManagerListActivity deviceManagerListActivity, boolean z) {
        this.f7147b = deviceManagerListActivity;
        this.f7146a = z;
    }

    public void run() {
        int i;
        int deviceConnectState;
        if (!this.f7147b.f7117f.isEmpty()) {
            this.f7147b.f7117f.clear();
        }
        this.f7147b.f7116e = C1988p.m10381a(BaseApplication.m2632b()).m10392b();
        if (this.f7147b.f7116e != null) {
            C2538c.m12677c("DeviceManagerListActivity", "updateDeviceListItem(): mDeviceInfoListSize =" + this.f7147b.f7116e.size() + ",mDeviceInfoList = " + this.f7147b.f7116e.toString());
            i = deviceConnectState;
        } else {
            C2538c.m12680e("DeviceManagerListActivity", "mDeviceInfoList is null!");
            i = 0;
        }
        boolean d = C1383f.m6188a(this.f7147b.f7114c).m6194d();
        boolean e = C1383f.m6188a(this.f7147b.f7114c).m6195e();
        if (i != 0 || d || e) {
            b a;
            this.f7147b.f7131u.post(new C2044n(this));
            if (this.f7147b.f7114c != null) {
                this.f7147b.runOnUiThread(new C2045o(this));
            }
            for (int i2 = 0; i2 < i; i2++) {
                DeviceInfo deviceInfo = (DeviceInfo) this.f7147b.f7116e.get(i2);
                if (deviceInfo != null) {
                    deviceConnectState = deviceInfo.getDeviceConnectState();
                    int productType = deviceInfo.getProductType();
                    String deviceName = deviceInfo.getDeviceName();
                    String deviceIdentify = deviceInfo.getDeviceIdentify();
                    if (-1 == productType) {
                        C2538c.m12680e("DeviceManagerListActivity", "updateDeviceListItem(): ProductType = -1");
                    } else {
                        C2538c.m12677c("DeviceManagerListActivity", "updateDeviceListItem():第" + i2 + " 个设备," + deviceName + ",deviceConnectState =" + deviceConnectState);
                        if (2 == deviceConnectState) {
                            if (!(-1 == productType || a.a(productType).i() == 0)) {
                                C2538c.m12677c("DeviceManagerListActivity", "connect item，productType != -1 !");
                                if (10 == productType && TextUtils.equals(deviceInfo.getDeviceModel(), "PORSCHE DESIGN")) {
                                    this.f7147b.m10618a(a.i().i(), deviceInfo.getDeviceName(), 2, 2, deviceIdentify, productType);
                                } else if (11 == productType && TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                    this.f7147b.m10618a(a.j().i(), deviceInfo.getDeviceName(), 2, 2, deviceIdentify, productType);
                                } else {
                                    this.f7147b.m10618a(a.a(productType).i(), deviceInfo.getDeviceName(), 2, 2, deviceIdentify, productType);
                                }
                            }
                            if (-2 != productType) {
                                C1988p.m10381a(BaseApplication.m2632b()).m10387a(this.f7147b.f7113b);
                            }
                        } else if (3 == deviceConnectState || 4 == deviceConnectState || 5 == deviceConnectState) {
                            if (!(-1 == productType || a.a(productType).f() == 0)) {
                                C2538c.m12677c("DeviceManagerListActivity", "disconnect item，productType != -1 !");
                                if (10 == productType && TextUtils.equals(deviceInfo.getDeviceModel(), "PORSCHE DESIGN")) {
                                    this.f7147b.m10618a(a.i().f(), deviceInfo.getDeviceName(), 3, 3, deviceIdentify, productType);
                                } else if (11 == productType && TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                    this.f7147b.m10618a(a.j().f(), deviceInfo.getDeviceName(), 3, 3, deviceIdentify, productType);
                                } else {
                                    this.f7147b.m10618a(a.a(productType).f(), deviceInfo.getDeviceName(), 3, 3, deviceIdentify, productType);
                                }
                            }
                        } else if (1 == deviceConnectState) {
                            this.f7147b.f7130t = true;
                            if (!(-1 == productType || a.a(productType).f() == 0)) {
                                C2538c.m12677c("DeviceManagerListActivity", "connectting item，productType != -1 !");
                                if (10 == productType && TextUtils.equals(deviceInfo.getDeviceModel(), "PORSCHE DESIGN")) {
                                    this.f7147b.m10618a(a.i().f(), deviceInfo.getDeviceName(), 1, 1, deviceIdentify, productType);
                                } else if (11 == productType && TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                    this.f7147b.m10618a(a.j().f(), deviceInfo.getDeviceName(), 1, 1, deviceIdentify, productType);
                                } else {
                                    this.f7147b.m10618a(a.a(productType).f(), deviceInfo.getDeviceName(), 1, 1, deviceIdentify, productType);
                                }
                            }
                        }
                    }
                } else {
                    C2538c.m12677c("DeviceManagerListActivity", "updateDeviceListItem(): deviceInfo is null.!");
                }
            }
            if (d) {
                a = a.a(2);
                this.f7147b.m10618a(a.i(), a.j(), 0, 5, "", 2);
            }
            if (e) {
                a = a.a(9);
                this.f7147b.m10618a(a.i(), a.j(), 0, 5, "", 9);
            }
            C2538c.m12677c("DeviceManagerListActivity", " updateDeviceListItem():item创建完毕,mDeviceItemList:" + this.f7147b.f7117f.toString());
            if (this.f7146a && this.f7147b.f7114c != null) {
                this.f7147b.runOnUiThread(new C2046p(this));
                return;
            }
            return;
        }
        this.f7147b.f7131u.post(new C2042l(this));
        if (this.f7147b.f7114c != null) {
            this.f7147b.runOnUiThread(new C2043m(this));
        }
    }
}
