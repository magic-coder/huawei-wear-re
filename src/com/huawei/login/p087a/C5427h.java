package com.huawei.login.p087a;

import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiLoginManager */
class C5427h implements LoginHandler {
    final /* synthetic */ a f19248a;
    private IBaseResponseCallback f19249b;
    private boolean f19250c;

    C5427h(a aVar, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        this.f19248a = aVar;
        this.f19249b = iBaseResponseCallback;
        this.f19250c = z;
    }

    public void onLogin(CloudAccount[] cloudAccountArr, int i) {
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"NotAidlLoginHandler onLogin:"});
        if (a.b(this.f19248a)) {
            a.a(this.f19248a, this.f19249b);
        } else {
            a.b(this.f19248a, this.f19249b, this.f19250c);
        }
    }

    public void onLogout(CloudAccount[] cloudAccountArr, int i) {
        a.b(null);
    }

    public void onFinish(CloudAccount[] cloudAccountArr) {
    }

    public void onError(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"NotAidlLoginHandler onError is null."});
            return;
        }
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"NotAidlLoginHandler onError :" + errorStatus.getErrorCode() + "," + errorStatus.getErrorReason()});
        if (this.f19249b != null) {
            this.f19249b.onResponse(errorStatus.getErrorCode(), errorStatus.getErrorReason());
        } else {
            a.a(this.f19248a, errorStatus.getErrorCode());
        }
    }
}
