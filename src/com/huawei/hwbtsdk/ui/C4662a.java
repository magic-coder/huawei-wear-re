package com.huawei.hwbtsdk.ui;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceScanListActivity */
class C4662a extends Handler {
    final /* synthetic */ BTDeviceScanListActivity f17076a;

    C4662a(BTDeviceScanListActivity bTDeviceScanListActivity) {
        this.f17076a = bTDeviceScanListActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.a("01", 1, "BTDeviceScanListActivity", new Object[]{"receive message is: " + message.what});
        switch (message.what) {
            case 0:
                this.f17076a.m22396b();
                return;
            default:
                return;
        }
    }
}
