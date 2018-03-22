package com.huawei.p192w;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.w.c;

/* compiled from: HWMultiSimMgr */
class C6142f implements IBaseResponseCallback {
    final /* synthetic */ c f21192a;

    C6142f(c cVar) {
        this.f21192a = cVar;
    }

    public void onResponse(int i, Object obj) {
        if (c.b(this.f21192a).hasMessages(5)) {
            c.b(this.f21192a).removeMessages(5);
        }
        if (i != 0) {
            c.a(this.f21192a, 0);
        } else if (obj == null || !(obj instanceof MultiSimDeviceInfo)) {
            c.a(this.f21192a, 0);
        } else {
            c.a(this.f21192a, (MultiSimDeviceInfo) obj);
        }
    }
}
