package com.huawei.login.p087a;

import android.os.Bundle;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiLoginManager */
class C5422c implements CloudRequestHandler {
    final /* synthetic */ IBaseResponseCallback f19238a;
    final /* synthetic */ a f19239b;

    C5422c(a aVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19239b = aVar;
        this.f19238a = iBaseResponseCallback;
    }

    public void onFinish(Bundle bundle) {
        if (bundle == null) {
            C2538c.e("PLGLOGIN_HuaweiLoginManager", new Object[]{"loginForHuid  onFinish bundle is null"});
            if (this.f19238a != null) {
                this.f19238a.onResponse(-1, "");
                return;
            }
            return;
        }
        String string = bundle.getString(CloudAccount.KEY_VERSION_NAME);
        C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"loginForHuid  initial onFinish,version:", string});
        if (a.a(this.f19239b)) {
            if (a.b(this.f19239b)) {
                a.a(this.f19239b, this.f19238a, true);
            } else {
                a.b(this.f19239b, this.f19238a, true);
            }
        } else if (a.b(this.f19239b)) {
            a.a(this.f19239b, this.f19238a);
        } else {
            a.b(this.f19239b, this.f19238a, false);
        }
    }

    public void onError(ErrorStatus errorStatus) {
        C2538c.e("PLGLOGIN_HuaweiLoginManager", new Object[]{"loginForHuid initial onError, ErrorCode: " + errorStatus.getErrorCode() + ", ErrorReason: " + errorStatus.getErrorReason()});
        if (this.f19238a != null) {
            this.f19238a.onResponse(errorStatus.getErrorCode(), errorStatus.getErrorReason());
        }
    }
}
