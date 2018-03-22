package com.huawei.login.p087a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.login.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiLoginManager */
class C5421b implements CloudRequestHandler {
    final /* synthetic */ Context f19235a;
    final /* synthetic */ boolean f19236b;
    final /* synthetic */ a f19237c;

    C5421b(a aVar, Context context, boolean z) {
        this.f19237c = aVar;
        this.f19235a = context;
        this.f19236b = z;
    }

    public void onFinish(Bundle bundle) {
        if (bundle == null) {
            C2538c.e("PLGLOGIN_HuaweiLoginManager", new Object[]{"login() onFinish bundle is null"});
            a.a(this.f19237c, -100);
            return;
        }
        String string = bundle.getString(CloudAccount.KEY_VERSION_NAME);
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"login() initial onFinish,version:", string});
        a.a(this.f19237c, this.f19235a);
        if (a.a(this.f19237c)) {
            if (a.b(this.f19237c)) {
                a.a(this.f19237c, null, true);
            } else {
                a.b(this.f19237c, null, true);
            }
        } else if (a.b(this.f19237c)) {
            a.a(this.f19237c, null);
        } else {
            a.b(this.f19237c, null, this.f19236b);
        }
    }

    public void onError(ErrorStatus errorStatus) {
        C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"login() initial onError, ErrorCode: " + errorStatus.getErrorCode() + ", ErrorReason: " + errorStatus.getErrorReason()});
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"login() initial onError, ErrorCode: " + errorStatus.getErrorCode()});
        a.a(this.f19237c, errorStatus.getErrorCode());
    }
}
