package com.huawei.ui.device.activity.donotdisturb;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.lang.ref.WeakReference;

/* compiled from: NoDisturbSettingActivity */
class C2056f extends Handler {
    WeakReference<NoDisturbSettingActivity> f7198a;
    final /* synthetic */ NoDisturbSettingActivity f7199b;

    C2056f(NoDisturbSettingActivity noDisturbSettingActivity, NoDisturbSettingActivity noDisturbSettingActivity2) {
        this.f7199b = noDisturbSettingActivity;
        this.f7198a = new WeakReference(noDisturbSettingActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((NoDisturbSettingActivity) this.f7198a.get()) != null) {
            C2538c.m12677c("NoDisturbSettingActivity", "Enter handleMessage():" + message.what);
            switch (message.what) {
                case 0:
                    this.f7199b.m10678a(message.obj);
                    return;
                case 1:
                    this.f7199b.m10673a();
                    return;
                case 2:
                    this.f7199b.m10680b();
                    return;
                case 3:
                    this.f7199b.m10682c();
                    return;
                default:
                    return;
            }
        }
    }
}
