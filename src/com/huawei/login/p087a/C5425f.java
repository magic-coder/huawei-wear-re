package com.huawei.login.p087a;

import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiLoginManager */
class C5425f implements LoginHandler {
    final /* synthetic */ a f19243a;
    private IBaseResponseCallback f19244b;
    private boolean f19245c;

    C5425f(a aVar, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        this.f19243a = aVar;
        this.f19244b = iBaseResponseCallback;
        this.f19245c = z;
    }

    public void onLogin(CloudAccount[] cloudAccountArr, int i) {
        C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"AidlLoginHandler --- >onLogin"});
        if (cloudAccountArr != null && cloudAccountArr.length > 0) {
            if (i != -1) {
                if (this.f19244b != null) {
                    CloudAccount cloudAccount = cloudAccountArr[i];
                    a.a(cloudAccount);
                    this.f19244b.onResponse(0, cloudAccount.getAccountInfo().getString("userId"));
                    return;
                }
                a.b(cloudAccountArr[i]);
                a.e(this.f19243a);
            } else if (this.f19244b != null) {
                C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"AidlLoginHandler --- >error"});
                this.f19244b.onResponse(-1, "");
            }
        }
    }

    public void onLogout(CloudAccount[] cloudAccountArr, int i) {
        a.b(null);
    }

    public void onFinish(CloudAccount[] cloudAccountArr) {
    }

    public void onError(ErrorStatus errorStatus) {
        C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"AidlLoginHandler onError"});
        if (errorStatus != null) {
            C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"AidlLoginHandler onError:" + errorStatus.getErrorCode() + ", reason = " + errorStatus.getErrorReason()});
            if (31 == errorStatus.getErrorCode() || 39 == errorStatus.getErrorCode() || 30 == errorStatus.getErrorCode()) {
                C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"aidl login error, go to notAidlLogin():"});
                a.a(this.f19243a, this.f19244b, this.f19245c);
            } else if (this.f19244b != null) {
                this.f19244b.onResponse(errorStatus.getErrorCode(), errorStatus.getErrorReason());
            } else {
                a.a(this.f19243a, errorStatus.getErrorCode());
            }
        }
    }
}
