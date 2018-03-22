package com.huawei.p169s;

import com.huawei.datatype.GpsParameter;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.s.b;
import com.huawei.p190v.C2538c;

/* compiled from: HWGPSLocationManager */
class C5890c implements IBaseResponseCallback {
    final /* synthetic */ b f20184a;

    C5890c(b bVar) {
        this.f20184a = bVar;
    }

    public void onResponse(int i, Object obj) {
        b.a(this.f20184a, (GpsParameter) obj);
        if (b.a(this.f20184a) != null) {
            C2538c.b("HWGPSLocationManager", new Object[]{"bitmap" + b.a(this.f20184a).getGps_info_bitmap() + ",fomat=" + b.a(this.f20184a).getGps_para_format() + ",threshold=" + b.a(this.f20184a).getGps_threshold()});
        }
    }
}
