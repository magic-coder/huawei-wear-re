package com.huawei.p169s;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwlocationmgr.p457b.C5315a;
import com.huawei.p190v.C2538c;
import com.huawei.s.b;

/* compiled from: HWGPSLocationManager */
class C5892e implements IBaseResponseCallback {
    final /* synthetic */ b f20186a;

    C5892e(b bVar) {
        this.f20186a = bVar;
    }

    public void onResponse(int i, Object obj) {
        b.a(this.f20186a, ((Boolean) obj).booleanValue());
        if (b.b(this.f20186a)) {
            b.a(this.f20186a, 0);
            if (b.a(this.f20186a) != null) {
                if (b.a(this.f20186a).getGps_info_bitmap() > 15) {
                    C2538c.c("HWGPSLocationManager", new Object[]{"bitmap not support lat"});
                    if (!d.f()) {
                        C2538c.c("HWGPSLocationManager", new Object[]{"is not emui5.0"});
                        this.f20186a.a(124004);
                        return;
                    }
                }
                if (C5897j.m27098a(b.c(this.f20186a))) {
                    C2538c.c("HWGPSLocationManager", new Object[]{"device enable set gps"});
                    this.f20186a.a(100000);
                    C5315a.m25697a(b.c(this.f20186a)).m25699a(this.f20186a.d, 1000, 0.0f);
                    b.b(this.f20186a, true);
                    return;
                }
                C2538c.c("HWGPSLocationManager", new Object[]{"gps not open"});
                this.f20186a.a(124003);
                b.b(this.f20186a, false);
                return;
            }
            return;
        }
        C2538c.c("HWGPSLocationManager", new Object[]{"device disenable set gps"});
        this.f20186a.a(100000);
        C5315a.m25697a(b.c(this.f20186a)).m25700b(this.f20186a.d);
    }
}
