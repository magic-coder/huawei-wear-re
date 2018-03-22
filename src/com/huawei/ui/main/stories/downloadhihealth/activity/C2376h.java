package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: HealthStartActivity */
class C2376h extends Handler {
    WeakReference<HealthStartActivity> f8567a;
    final /* synthetic */ HealthStartActivity f8568b;

    C2376h(HealthStartActivity healthStartActivity, HealthStartActivity healthStartActivity2) {
        this.f8568b = healthStartActivity;
        this.f8567a = new WeakReference(healthStartActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((HealthStartActivity) this.f8567a.get()) != null) {
            C2538c.m12677c("HealthStartActivity", "Enter handleMessage():" + message.what);
            if (2 != message.what) {
                HealthStartActivity.a(this.f8568b).removeMessages(2);
            }
        }
    }
}
