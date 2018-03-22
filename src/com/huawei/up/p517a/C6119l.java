package com.huawei.up.p517a;

import com.huawei.login.ui.login.util.C5432b;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;

/* compiled from: UpApi */
class C6119l implements ILoginCallback {
    final /* synthetic */ String f21142a;
    final /* synthetic */ C4694a f21143b;
    final /* synthetic */ C6108a f21144c;

    C6119l(C6108a c6108a, String str, C4694a c4694a) {
        this.f21144c = c6108a;
        this.f21142a = str;
        this.f21143b = c4694a;
    }

    public void onLoginSuccess(Object obj) {
        this.f21144c.m27865b(this.f21142a, this.f21143b);
    }

    public void onLoginFailed(Object obj) {
        C2538c.b("UpApi", new Object[]{"updateHeadPicture loginResult = ", (C5432b) obj});
        C2538c.c("UpApi", new Object[]{"updateHeadPicture errcode = ", Integer.valueOf(r7.m26038a())});
        if (this.f21143b != null) {
            C2538c.e("UpApi", new Object[]{"onLoginFailed is fail"});
            this.f21143b.mo4557a(r0);
        }
    }
}
