package com.huawei.hwservicesmgr.p076a;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwservicesmgr.a.a;

/* compiled from: HWFindPhoneMgr */
class C5345b extends Handler {
    final /* synthetic */ a f19085a;

    C5345b(a aVar) {
        this.f19085a = aVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                a.a(this.f19085a);
                this.f19085a.a(2);
                return;
            default:
                return;
        }
    }
}
