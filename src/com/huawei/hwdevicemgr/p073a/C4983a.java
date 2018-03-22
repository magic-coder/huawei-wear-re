package com.huawei.hwdevicemgr.p073a;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.datatypes.C4746m;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C1024b;
import com.huawei.p032e.p264a.p265a.p266b.C4386b;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceIGetTotalDataFromDevice */
public class C4983a implements C4386b {
    private C1024b f18066a;

    public C4983a(Context context) {
    }

    public void m23915a(C1024b bVar) {
        this.f18066a = bVar;
    }

    public void mo4596a(int[] iArr, int[] iArr2) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setProductType(-2);
        if (this.f18066a != null) {
            C4746m c4746m = new C4746m();
            Gson gson = new Gson();
            String toJson = gson.toJson(iArr);
            String toJson2 = gson.toJson(iArr2);
            c4746m.m22708a(3);
            c4746m.m22709a(toJson);
            c4746m.m22712b(toJson2);
            this.f18066a.mo2339a(deviceInfo, 7, gson.toJson(c4746m));
            return;
        }
        // C2538c.e("DeviceIGetTotalDataFromDevice", new Object[]{"mDeviceStateClientCallback is null."});
    }
}
