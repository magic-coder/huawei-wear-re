package com.huawei.p388g.p389a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.constant.RequestKey;

/* compiled from: PluginPayAdapterImpl */
class C4482c implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16654a;

    C4482c(C4481b c4481b) {
        this.f16654a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        C2538c.e("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getCplc.onResponse.err_code." + i});
        if (i == 0 && (obj instanceof String)) {
            this.f16654a.f16648q = (String) obj;
            C2538c.b("PluginPayAdapterImpl", new Object[]{"get cplc from watch=" + this.f16654a.f16648q});
        } else {
            this.f16654a.f16648q = null;
        }
        this.f16654a.m21484a(RequestKey.KEY_GET_CPLC, C4481b.f16618I);
    }
}
