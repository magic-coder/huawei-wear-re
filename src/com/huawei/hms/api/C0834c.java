package com.huawei.hms.api;

import com.huawei.hms.core.aidl.C0832d.C0833a;
import com.huawei.hms.core.aidl.C0861a;
import com.huawei.hms.core.aidl.C0862b;
import com.huawei.hms.core.aidl.C0868f;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.ResultCallback;

/* compiled from: HuaweiApiClientImpl */
class C0834c extends C0833a {
    final /* synthetic */ ResultCallback f1322a;
    final /* synthetic */ HuaweiApiClientImpl f1323b;

    C0834c(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
        this.f1323b = huaweiApiClientImpl;
        this.f1322a = resultCallback;
    }

    public void mo2230a(C0862b c0862b) {
        if (c0862b != null) {
            C0868f a = C0861a.m3030a(c0862b.m3036c());
            IMessageEntity responseHeader = new ResponseHeader();
            a.m3051a(c0862b.f1358b, responseHeader);
            this.f1322a.onResult(new BundleResult(responseHeader.getStatusCode(), c0862b.m3033a()));
            return;
        }
        this.f1322a.onResult(new BundleResult(-1, null));
    }
}
