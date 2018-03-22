package com.huawei.bone.p552b;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6766k implements IBaseResponseCallback {
    final /* synthetic */ String f23187a;
    final /* synthetic */ C6756a f23188b;

    C6766k(C6756a c6756a, String str) {
        this.f23188b = c6756a;
        this.f23187a = str;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("MainInterators", new Object[]{"hwidNotLogined getHuidInHwid err_code:" + i});
        this.f23188b.f23126i.runOnUiThread(new C6767l(this, i, obj));
    }
}
