package com.huawei.ui.homewear21.p175a;

import android.text.TextUtils;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.d.k;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class an implements IBaseResponseCallback {
    final /* synthetic */ DeviceInfo f8055a;
    final /* synthetic */ C2217a f8056b;

    an(C2217a c2217a, DeviceInfo deviceInfo) {
        this.f8056b = c2217a;
        this.f8055a = deviceInfo;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            DataDeviceInfo dataDeviceInfo = (DataDeviceInfo) obj;
            C2217a.af.c(dataDeviceInfo.getDevice_soft_version());
            C2538c.m12674b("HomeFragment", "mDeviceInfo.dataDeviceInfo = " + dataDeviceInfo.toString());
            C2538c.m12674b("HomeFragment", "mDeviceInfo.DeviceMac = " + C2217a.af.b());
            C2538c.m12674b("HomeFragment", "mDeviceInfo.DeviceType = " + C2217a.af.a());
            C2538c.m12674b("HomeFragment", "mDeviceInfo.DeviceVersion = " + C2217a.af.c());
            C2538c.m12674b("HomeFragment", "dataDeviceInfo.getDevice_sn = " + dataDeviceInfo.getDevice_sn());
            if (3 == dataDeviceInfo.getDevice_type()) {
                C2217a.af.b(dataDeviceInfo.getDevice_sn());
            } else if (10 == dataDeviceInfo.getDevice_type() && this.f8055a != null) {
                boolean z;
                if (TextUtils.isEmpty(this.f8055a.getUUID())) {
                    C2217a.af.b(dataDeviceInfo.getDevice_sn());
                } else {
                    C2217a.af.b(this.f8055a.getUUID());
                }
                if (2 == dataDeviceInfo.getDevice_support_healthapp()) {
                    this.f8056b.bu.sendEmptyMessageDelayed(1023, 1000);
                    z = true;
                } else {
                    z = false;
                }
                k.a(new ao(this, z));
            }
            C2538c.m12674b("HomeFragment", "setBIAnalyticsData.getDeviceMac = " + C2217a.af.b());
            this.f8056b.f8013V.a(C2217a.af);
        }
    }
}
