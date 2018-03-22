package com.huawei.sim.esim.view;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: ConformActivity */
class C5931h extends Handler {
    final /* synthetic */ ConformActivity f20444a;

    C5931h(ConformActivity conformActivity) {
        this.f20444a = conformActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.b("ConformActivity", new Object[]{"message " + message.what});
        switch (message.what) {
        }
    }
}
