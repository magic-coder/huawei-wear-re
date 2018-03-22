package com.huawei.p169s;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.s.b;

import java.lang.ref.WeakReference;

/* compiled from: HWGPSMgrHandler */
public class C5896i extends Handler {
    private WeakReference<b> f20190a;

    C5896i(b bVar) {
        this.f20190a = new WeakReference(bVar);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        b bVar = (b) this.f20190a.get();
        if (bVar != null) {
            C2538c.c("HWGPSMgrHandler", new Object[]{"handleMessage msg = " + message.what});
            switch (message.what) {
                case 1:
                    bVar.c();
                    return;
                default:
                    return;
            }
        }
    }
}
