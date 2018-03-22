package com.huawei.ui.device.activity.adddevice;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: AddDeviceActivity */
class C2009k extends Handler {
    WeakReference<AddDeviceActivity> f7047a;

    C2009k(AddDeviceActivity addDeviceActivity) {
        this.f7047a = new WeakReference(addDeviceActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        AddDeviceActivity addDeviceActivity = (AddDeviceActivity) this.f7047a.get();
        if (addDeviceActivity != null) {
            C2538c.m12661a("01", 0, "AddDeviceActivity", "receive message is: " + message.what);
            AddDeviceActivity.m10512d(message.what, addDeviceActivity);
            AddDeviceActivity.m10516e(message.what, addDeviceActivity);
            AddDeviceActivity.m10519f(message.what, addDeviceActivity);
        }
    }
}
