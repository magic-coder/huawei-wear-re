package com.huawei.hwid.openapi.p442c;

import android.os.Bundle;
import android.util.Log;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.out.ResReqHandler;
import com.huawei.hwid.openapi.p445e.C5251f;

class C5233c extends ResReqHandler {
    final /* synthetic */ C5231a f18864a;

    C5233c(C5231a c5231a) {
        this.f18864a = c5231a;
    }

    public void onComplete(Bundle bundle) {
        try {
            this.f18864a.f18857a.dismiss();
            if (bundle == null) {
                this.f18864a.m25382a(new Exception("null return"));
            } else if (OutReturn.isRequestSuccess(bundle)) {
                String retContent = OutReturn.getRetContent(bundle);
                this.f18864a.m25387b(retContent);
                this.f18864a.f18859c.onUserInfo(C5251f.m25460a(retContent));
            } else {
                this.f18864a.m25385b(bundle);
            }
        } catch (Throwable e) {
            Log.e(C5231a.f18856g, e.toString(), e);
        }
    }
}
