package com.huawei.ui.device.activity.selectcontact;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: ContactMainActivity */
class C2147h extends Handler {
    WeakReference<ContactMainActivity> f7607a;
    final /* synthetic */ ContactMainActivity f7608b;

    C2147h(ContactMainActivity contactMainActivity, ContactMainActivity contactMainActivity2) {
        this.f7608b = contactMainActivity;
        this.f7607a = new WeakReference(contactMainActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((ContactMainActivity) this.f7607a.get()) != null) {
            C2538c.m12677c("ContactMainActivity", "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 1:
                    this.f7608b.m10990a();
                    return;
                case 2:
                    this.f7608b.m10997b();
                    return;
                default:
                    return;
            }
        }
    }
}
