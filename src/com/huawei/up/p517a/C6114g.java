package com.huawei.up.p517a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.login.ui.login.util.C5432b;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.p190v.C2538c;

/* compiled from: UpApi */
class C6114g implements ILoginCallback {
    final /* synthetic */ IBaseResponseCallback f21130a;
    final /* synthetic */ C6108a f21131b;

    C6114g(C6108a c6108a, IBaseResponseCallback iBaseResponseCallback) {
        this.f21131b = c6108a;
        this.f21130a = iBaseResponseCallback;
    }

    public void onLoginSuccess(Object obj) {
        C2538c.b("UpApi", new Object[]{"goToLoginActivity onLoginSuccess"});
        this.f21130a.onResponse(0, "login success");
    }

    public void onLoginFailed(Object obj) {
        if (obj instanceof C5432b) {
            this.f21130a.onResponse(((C5432b) obj).m26038a(), "login fail 1");
        } else {
            this.f21130a.onResponse(-1, "login fail 2");
        }
        C2538c.b("UpApi", new Object[]{"goToLoginActivity login fail object"});
    }
}
