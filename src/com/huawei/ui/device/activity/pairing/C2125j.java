package com.huawei.ui.device.activity.pairing;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import java.util.Map;

/* compiled from: DevicePairGuideActivity */
class C2125j implements IBaseResponseCallback {
    final /* synthetic */ Map f7530a;
    final /* synthetic */ DevicePairGuideActivity f7531b;

    C2125j(DevicePairGuideActivity devicePairGuideActivity, Map map) {
        this.f7531b = devicePairGuideActivity;
        this.f7530a = map;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            this.f7530a.put("mac", ((DataDeviceInfo) obj).getDevice_sn());
            c.a().a(BaseApplication.m2632b(), a.A.a(), this.f7530a, 0);
        }
    }
}
