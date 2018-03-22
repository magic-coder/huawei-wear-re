package com.huawei.bone.root;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: SplashActivity */
class ag implements Callback {
    final /* synthetic */ SplashActivity f23301a;

    ag(SplashActivity splashActivity) {
        this.f23301a = splashActivity;
    }

    public boolean handleMessage(Message message) {
        if (this.f23301a.hasWindowFocus()) {
            C2538c.b("SplashActivity", new Object[]{"handleMessage"});
            this.f23301a.m30201b();
        }
        return false;
    }
}
