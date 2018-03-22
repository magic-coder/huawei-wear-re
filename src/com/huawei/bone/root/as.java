package com.huawei.bone.root;

import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.c.a;
import com.huawei.p190v.C2538c;

/* compiled from: SplashActivity */
class as extends a<SplashActivity> {
    public as(Looper looper, SplashActivity splashActivity) {
        super(looper, splashActivity);
    }

    protected void m30207a(SplashActivity splashActivity, Message message) {
        C2538c.c("SplashActivity", new Object[]{"WeakHandler:" + message.what});
        switch (message.what) {
            case 100:
                splashActivity.f23274b.m30074a(message.arg1, message.obj);
                return;
            default:
                return;
        }
    }
}
