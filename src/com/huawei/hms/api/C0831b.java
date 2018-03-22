package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.C0887a;

/* compiled from: HuaweiApiClientImpl */
class C0831b implements Callback {
    final /* synthetic */ HuaweiApiClientImpl f1321a;

    C0831b(HuaweiApiClientImpl huaweiApiClientImpl) {
        this.f1321a = huaweiApiClientImpl;
    }

    public boolean handleMessage(Message message) {
        if (message == null || message.what != 2) {
            return false;
        }
        C0887a.m3098d("HuaweiApiClientImpl", "In connect, bind core service time out");
        if (this.f1321a.f1312f.get() != 5) {
            return true;
        }
        this.f1321a.m2928a(1);
        if (this.f1321a.f1318l == null) {
            return true;
        }
        this.f1321a.f1318l.onConnectionFailed(new ConnectionResult(6));
        return true;
    }
}
