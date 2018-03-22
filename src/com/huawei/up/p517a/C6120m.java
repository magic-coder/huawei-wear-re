package com.huawei.up.p517a;

import android.os.Bundle;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;
import com.unionpay.tsmservice.data.Constant;

/* compiled from: UpApi */
class C6120m implements CloudRequestHandler {
    final /* synthetic */ C4694a f21145a;
    final /* synthetic */ C6108a f21146b;

    C6120m(C6108a c6108a, C4694a c4694a) {
        this.f21146b = c6108a;
        this.f21145a = c4694a;
    }

    public void onFinish(Bundle bundle) {
        C2538c.b("UpApi", new Object[]{"updateUserPicBySdk finish() "});
        if (this.f21145a != null) {
            String string = bundle.getString("headPictureURL");
            bundle.putString(Constant.KEY_METHOD, "upLoadPhoto");
            bundle.putString("fileUrlB", string);
            this.f21145a.mo4558a(bundle);
        }
    }

    public void onError(ErrorStatus errorStatus) {
        if (this.f21145a != null) {
            C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk is fail"});
            this.f21145a.mo4557a(errorStatus.getErrorCode());
        }
    }
}
