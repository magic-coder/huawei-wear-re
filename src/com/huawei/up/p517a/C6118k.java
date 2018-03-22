package com.huawei.up.p517a;

import android.os.Bundle;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;
import com.unionpay.tsmservice.data.Constant;

/* compiled from: UpApi */
class C6118k implements CloudRequestHandler {
    final /* synthetic */ C4694a f21140a;
    final /* synthetic */ C6108a f21141b;

    C6118k(C6108a c6108a, C4694a c4694a) {
        this.f21141b = c6108a;
        this.f21140a = c4694a;
    }

    public void onFinish(Bundle bundle) {
        C2538c.b("UpApi", new Object[]{"updateUserInfoBySdk finish() "});
        if (this.f21140a != null) {
            bundle.putString(Constant.KEY_METHOD, "updateUserInfo");
            this.f21140a.mo4558a(bundle);
        }
    }

    public void onError(ErrorStatus errorStatus) {
        C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk onError " + errorStatus.getErrorCode()});
        if (this.f21140a != null) {
            C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk is fail"});
            this.f21140a.mo4557a(errorStatus.getErrorCode());
        }
    }
}
