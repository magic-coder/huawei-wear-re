package com.huawei.nfc.carrera.lifecycle.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class NFCPushServiceManager$PushServiceHandler extends Handler {
    final /* synthetic */ NFCPushServiceManager this$0;

    public NFCPushServiceManager$PushServiceHandler(NFCPushServiceManager nFCPushServiceManager, Looper looper) {
        this.this$0 = nFCPushServiceManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (message.obj != null) {
                    NFCPushServiceManager.access$000(this.this$0, (String) message.obj);
                    return;
                }
                return;
            case 2:
                if (message.obj != null) {
                    NFCPushServiceManager.access$100(this.this$0, (String) message.obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
