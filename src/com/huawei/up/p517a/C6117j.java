package com.huawei.up.p517a;

import com.huawei.login.ui.login.util.C5432b;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;

/* compiled from: UpApi */
class C6117j implements ILoginCallback {
    final /* synthetic */ UserInfomation f21137a;
    final /* synthetic */ C4694a f21138b;
    final /* synthetic */ C6108a f21139c;

    C6117j(C6108a c6108a, UserInfomation userInfomation, C4694a c4694a) {
        this.f21139c = c6108a;
        this.f21137a = userInfomation;
        this.f21138b = c4694a;
    }

    public void onLoginSuccess(Object obj) {
        this.f21139c.m27858a(this.f21137a, this.f21138b);
    }

    public void onLoginFailed(Object obj) {
        C2538c.b("UpApi", new Object[]{"login loginResult = ", (C5432b) obj});
        C2538c.c("UpApi", new Object[]{"login errcode = ", Integer.valueOf(r7.m26038a())});
        if (this.f21138b != null) {
            C2538c.e("UpApi", new Object[]{"onLoginFailed is fail"});
            this.f21138b.mo4557a(r0);
        }
    }
}
