package com.huawei.login.p087a;

import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiLoginManager */
class C5426g implements LoginHandler {
    final /* synthetic */ a f19246a;
    private IBaseResponseCallback f19247b;

    C5426g(a aVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19246a = aVar;
        this.f19247b = iBaseResponseCallback;
    }

    public void onLogin(CloudAccount[] cloudAccountArr, int i) {
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"LoginSystemHandler --- >onLogin"});
        if (cloudAccountArr != null && cloudAccountArr.length > 0) {
            if (i != -1) {
                if (this.f19247b != null) {
                    CloudAccount cloudAccount = cloudAccountArr[i];
                    a.a(cloudAccount);
                    this.f19247b.onResponse(0, cloudAccount.getAccountInfo().getString("userId"));
                    return;
                }
                a.b(cloudAccountArr[i]);
                a.e(this.f19246a);
            } else if (this.f19247b != null) {
                C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"LoginSystemHandler --- >error"});
                this.f19247b.onResponse(-1, "");
            }
        }
    }

    public void onLogout(CloudAccount[] cloudAccountArr, int i) {
        a.b(null);
    }

    public void onFinish(CloudAccount[] cloudAccountArr) {
    }

    public void onError(ErrorStatus errorStatus) {
        C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"LoginSystemHandler onError"});
        if (errorStatus != null) {
            C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"LoginSystemHandler onError:" + errorStatus.getErrorCode() + ", reason = " + errorStatus.getErrorReason()});
            if (this.f19247b != null) {
                this.f19247b.onResponse(errorStatus.getErrorCode(), errorStatus.getErrorReason());
            } else {
                a.a(this.f19246a, errorStatus.getErrorCode());
            }
        }
    }
}
