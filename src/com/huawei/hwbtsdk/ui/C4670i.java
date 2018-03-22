package com.huawei.hwbtsdk.ui;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;

/* compiled from: BTDialogActivity */
class C4670i extends Handler {
    WeakReference<BTDialogActivity> f17084a;
    final /* synthetic */ BTDialogActivity f17085b;

    C4670i(BTDialogActivity bTDialogActivity, BTDialogActivity bTDialogActivity2) {
        this.f17085b = bTDialogActivity;
        this.f17084a = new WeakReference(bTDialogActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((BTDialogActivity) this.f17084a.get()) != null) {
            C2538c.a("01", 1, "BTDialogActivity", new Object[]{"receive msg:" + message.what});
            switch (message.what) {
                case 1:
                    if (2 == this.f17085b.f17069c) {
                        this.f17085b.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
