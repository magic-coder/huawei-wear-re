package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1978f implements IBaseResponseCallback {
    final /* synthetic */ C1977e f6912a;

    C1978f(C1977e c1977e) {
        this.f6912a = c1977e;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("CompatibilityInteractor", "isHuaweiWearBinded onResponse err_code:" + i + "  objData:" + ((String) obj));
        Object obj2 = C1987o.NO_BIND_DEVICE;
        if (i != 0 || obj == null) {
            obj2 = C1987o.NO_BIND_DEVICE;
        } else {
            try {
                if (C0977d.m3546c(BaseApplication.m2632b(), (String) obj) > 0) {
                    obj2 = C1987o.EXIST_TYPE;
                } else {
                    obj2 = C1987o.NO_BIND_DEVICE;
                }
            } catch (Exception e) {
                C2538c.m12677c("CompatibilityInteractor", "isHuaweiWearBinded Exception:" + e.getMessage());
            }
        }
        this.f6912a.f6909b.onResponse(0, obj2);
        C2538c.m12677c("CompatibilityInteractor", "isHuaweiWearBinded wearDeviceState:" + obj2);
    }
}
