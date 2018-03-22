package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: PrivacyPolicyActivity */
class C2320h extends Handler {
    WeakReference<PrivacyPolicyActivity> f8408a;
    final /* synthetic */ PrivacyPolicyActivity f8409b;

    C2320h(PrivacyPolicyActivity privacyPolicyActivity, PrivacyPolicyActivity privacyPolicyActivity2) {
        this.f8409b = privacyPolicyActivity;
        this.f8408a = new WeakReference(privacyPolicyActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((PrivacyPolicyActivity) this.f8408a.get()) != null) {
            C2538c.m12677c("PrivacyPolicyActivity", "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 1:
                    C2538c.m12674b("PrivacyPolicyActivity", "===www===mHandler====" + message.obj);
                    this.f8409b.m11836a((String) message.obj);
                    return;
                case 2:
                    C2538c.m12674b("PrivacyPolicyActivity", "===www===mHandler====" + message.obj);
                    this.f8409b.m11845c();
                    return;
                default:
                    return;
            }
        }
    }
}
