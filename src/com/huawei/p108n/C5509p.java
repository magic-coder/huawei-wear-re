package com.huawei.p108n;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceConfigManager */
class C5509p implements IBaseResponseCallback {
    final /* synthetic */ C5508o f19415a;

    C5509p(C5508o c5508o) {
        this.f19415a = c5508o;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWDeviceConfigManager", new Object[]{"requestDeviceAllowDisturbContent err_code = " + i});
        if (i == 0 && obj != null) {
            com.huawei.n.c.a(this.f19415a.f19414a, ((Integer) obj).intValue());
            C2538c.c("HWDeviceConfigManager", new Object[]{"requestDeviceAllowDisturbContent objData = " + obj + "  mDisturbList = " + com.huawei.n.c.b(this.f19415a.f19414a)});
        }
    }
}
