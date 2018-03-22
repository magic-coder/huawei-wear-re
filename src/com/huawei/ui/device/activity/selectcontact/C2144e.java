package com.huawei.ui.device.activity.selectcontact;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: ContactDeleteActivity */
class C2144e extends Handler {
    WeakReference<ContactDeleteActivity> f7603a;
    final /* synthetic */ ContactDeleteActivity f7604b;

    C2144e(ContactDeleteActivity contactDeleteActivity, ContactDeleteActivity contactDeleteActivity2) {
        this.f7604b = contactDeleteActivity;
        this.f7603a = new WeakReference(contactDeleteActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((ContactDeleteActivity) this.f7603a.get()) != null) {
            C2538c.m12677c(this.f7604b.f7553e, "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 1:
                    this.f7604b.m10967a();
                    return;
                case 2:
                    this.f7604b.m10968b();
                    return;
                default:
                    return;
            }
        }
    }
}
