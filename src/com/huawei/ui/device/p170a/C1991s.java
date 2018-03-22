package com.huawei.ui.device.p170a;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceSettingsInteractors */
class C1991s extends Handler {
    final /* synthetic */ C1990r f6955a;

    C1991s(C1990r c1990r) {
        this.f6955a = c1990r;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C2538c.m12677c("DeviceSettingsInteractors", "MSG_GET_LOCATION_TIME_OUT");
                this.f6955a.m10408p();
                return;
            default:
                return;
        }
    }
}
