package com.huawei.bone.root;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: ProtocolAndClauseActivity */
class C6797p extends Handler {
    final /* synthetic */ ProtocolAndClauseActivity f23339a;

    C6797p(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23339a = protocolAndClauseActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"receive msg:" + message.what});
        switch (message.what) {
            case 1:
                this.f23339a.f23244k.setEnabled(true);
                return;
            default:
                return;
        }
    }
}
