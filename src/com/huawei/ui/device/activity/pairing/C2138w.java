package com.huawei.ui.device.activity.pairing;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: DevicePairGuideActivity */
class C2138w extends Handler {
    WeakReference<DevicePairGuideActivity> f7548a;

    C2138w(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7548a = new WeakReference(devicePairGuideActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        DevicePairGuideActivity devicePairGuideActivity = (DevicePairGuideActivity) this.f7548a.get();
        if (devicePairGuideActivity != null) {
            C2538c.m12677c("DevicePairGuideActivity", "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 0:
                    devicePairGuideActivity.m10934g();
                    return;
                case 1:
                    devicePairGuideActivity.m10944l();
                    return;
                case 2:
                    devicePairGuideActivity.m10952p();
                    return;
                case 3:
                    devicePairGuideActivity.m10923c(0);
                    return;
                case 4:
                    devicePairGuideActivity.m10937i();
                    return;
                case 5:
                    devicePairGuideActivity.m10919b(true);
                    return;
                case 6:
                    devicePairGuideActivity.m10919b(false);
                    return;
                case 7:
                    devicePairGuideActivity.m10923c(1);
                    return;
                case 8:
                    if (3 == devicePairGuideActivity.f7500f || 10 == devicePairGuideActivity.f7500f) {
                        devicePairGuideActivity.finish();
                    }
                    devicePairGuideActivity.m10919b(true);
                    return;
                default:
                    return;
            }
        }
    }
}
