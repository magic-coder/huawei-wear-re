package com.huawei.hwid.openapi.p442c;

import android.os.Bundle;
import android.util.Log;
import com.huawei.hwid.openapi.OpenHwID;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.out.ResReqHandler;

class C5232b extends ResReqHandler {
    final /* synthetic */ C5231a f18863a;

    C5232b(C5231a c5231a) {
        this.f18863a = c5231a;
    }

    public void onComplete(Bundle bundle) {
        try {
            if (OutReturn.isRequestSuccess(bundle)) {
                String accessToken = OutReturn.getAccessToken(bundle);
                OpenHwID.storeAccessToken(this.f18863a.f18860d, this.f18863a.f18861e, null, accessToken, null);
                Log.i(C5231a.f18856g, "authorize, onComplete, token:" + accessToken);
                this.f18863a.m25383a(accessToken);
                return;
            }
            this.f18863a.m25385b(bundle);
        } catch (Exception e) {
            this.f18863a.m25382a(e);
        }
    }
}
