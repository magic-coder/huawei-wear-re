package com.huawei.up.p517a;

import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.a.a;
import com.huawei.login.ui.login.util.C5432b;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.p190v.C2538c;

/* compiled from: UpApi */
class C6113f implements ILoginCallback {
    final /* synthetic */ CloudRequestHandler f21128a;
    final /* synthetic */ C6108a f21129b;

    C6113f(C6108a c6108a, CloudRequestHandler cloudRequestHandler) {
        this.f21129b = c6108a;
        this.f21128a = cloudRequestHandler;
    }

    public void onLoginSuccess(Object obj) {
        C2538c.c("UpApi", new Object[]{"getUserInfo by huawei sdk222"});
        a.b().getUserInfo(BaseApplication.b(), "1000", this.f21128a);
    }

    public void onLoginFailed(Object obj) {
        C2538c.b("UpApi", new Object[]{"onLoginFailed loginResult = ", (C5432b) obj});
        C2538c.c("UpApi", new Object[]{"login errCode = ", Integer.valueOf(r7.m26038a())});
        this.f21128a.onError(new ErrorStatus(r0, "mAccount is null"));
        C2538c.e("UpApi", new Object[]{" onLoginFailed getUserInfo error, mAccount is null!"});
    }
}
