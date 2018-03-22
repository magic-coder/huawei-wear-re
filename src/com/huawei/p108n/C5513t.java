package com.huawei.p108n;

import com.huawei.datatype.DataDeviceAvoidDisturbInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5513t implements IBaseResponseCallback {
    final /* synthetic */ C5512s f19420a;

    C5513t(C5512s c5512s) {
        this.f19420a = c5512s;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list.size() == 0) {
            list.add(new DataDeviceAvoidDisturbInfo());
            c.a(this.f19420a.f19419a, list, c.a(this.f19420a.f19419a));
        }
    }
}
