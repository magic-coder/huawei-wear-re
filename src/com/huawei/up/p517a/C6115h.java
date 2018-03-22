package com.huawei.up.p517a;

import android.content.Context;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwdataaccessmodel.p065a.C4761b;
import com.huawei.hwdataaccessmodel.p065a.C4762d;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.ui.login.a;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.p190v.C2538c;

/* compiled from: UpApi */
class C6115h implements C4761b {
    final /* synthetic */ CloudRequestHandler f21132a;
    final /* synthetic */ Context f21133b;
    final /* synthetic */ a f21134c;
    final /* synthetic */ C6108a f21135d;

    C6115h(C6108a c6108a, CloudRequestHandler cloudRequestHandler, Context context, a aVar) {
        this.f21135d = c6108a;
        this.f21132a = cloudRequestHandler;
        this.f21133b = context;
        this.f21134c = aVar;
    }

    public void mo4692a(C4762d c4762d) {
        if (c4762d.m22752a() != 0) {
            this.f21132a.onError(new ErrorStatus(c4762d.m22752a(), "unknown error"));
            C2538c.b("UpApi", new Object[]{"getUserInfo failure, errcode is " + c4762d.m22752a()});
            C2538c.c("UpApi", new Object[]{"getUserInfo failure, errcode is error"});
            return;
        }
        this.f21135d.m27860a(this.f21134c.c(), (String) c4762d.m22755b(), C5433c.m26039a(this.f21133b).m26060h(), new C6116i(this));
    }
}
