package com.huawei.up.p517a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: UpApi */
class C6109b implements IBaseResponseCallback {
    final /* synthetic */ String f21118a;
    final /* synthetic */ String f21119b;
    final /* synthetic */ C6108a f21120c;

    C6109b(C6108a c6108a, String str, String str2) {
        this.f21120c = c6108a;
        this.f21118a = str;
        this.f21119b = str2;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("UpApi", new Object[]{"loginForCenter err_code：" + i});
        if (i == 0) {
            if (a.a(BaseApplication.b()).c().equals((String) obj)) {
                C2538c.c("UpApi", new Object[]{"changeSTToAT-->shared 7"});
                C2538c.c("UpApi", new Object[]{"changeSTToAT-->self"});
                this.f21120c.m27859a(this.f21118a, this.f21119b);
                return;
            }
            C2538c.c("UpApi", new Object[]{"changeSTToAT-->shared 6"});
            C2538c.c("UpApi", new Object[]{"loginForCenter enter else"});
            this.f21120c.m27866b(this.f21118a, this.f21119b);
        }
    }
}
