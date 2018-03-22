package com.huawei.ui.device.activity.device;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import java.util.Map;

/* compiled from: DeviceManagerListActivity */
class C2047q implements IBaseResponseCallback {
    final /* synthetic */ Map f7153a;
    final /* synthetic */ DeviceManagerListActivity f7154b;

    C2047q(DeviceManagerListActivity deviceManagerListActivity, Map map) {
        this.f7154b = deviceManagerListActivity;
        this.f7153a = map;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            this.f7153a.put("mac", ((DataDeviceInfo) obj).getDevice_sn());
            c.a().a(BaseApplication.m2632b(), a.B.a(), this.f7153a, 0);
        }
    }
}
