package com.huawei.p108n;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5510q implements IBaseResponseCallback {
    final /* synthetic */ List f19416a;
    final /* synthetic */ c f19417b;

    C5510q(c cVar, List list) {
        this.f19417b = cVar;
        this.f19416a = list;
    }

    public void onResponse(int i, Object obj) {
        if (obj != null) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"onDataMigrate() if (objData != null)"});
            if (((List) obj).size() == 0) {
                C2538c.c("HWDeviceConfigManager", new Object[]{"onDataMigrate() if (list.size() == 0)"});
                c.a(this.f19417b, this.f19416a, null);
                return;
            }
            C2538c.c("HWDeviceConfigManager", new Object[]{"onDataMigrate() if (list.size() == 0) ELSE"});
            c.b(this.f19417b, this.f19416a, null);
        }
    }
}
