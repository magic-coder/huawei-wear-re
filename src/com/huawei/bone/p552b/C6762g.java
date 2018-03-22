package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6762g implements IBaseResponseCallback {
    final /* synthetic */ C6761f f23181a;

    C6762g(C6761f c6761f) {
        this.f23181a = c6761f;
    }

    public void onResponse(int i, Object obj) {
        if (this.f23181a.f23180c.f23177a.f23136s) {
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid timeout return"});
            return;
        }
        C2538c.b("MainInterators", new Object[]{"hwidLogined getHuidInHwid err_code:" + i});
        this.f23181a.f23178a.countDown();
        this.f23181a.f23180c.f23177a.f23126i.runOnUiThread(new C6763h(this, i, obj));
    }
}
