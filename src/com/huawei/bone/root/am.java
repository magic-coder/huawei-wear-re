package com.huawei.bone.root;

import com.huawei.up.a.a;

/* compiled from: SplashActivity */
class am implements Runnable {
    final /* synthetic */ a f23309a;
    final /* synthetic */ String f23310b;
    final /* synthetic */ SplashActivity f23311c;

    am(SplashActivity splashActivity, a aVar, String str) {
        this.f23311c = splashActivity;
        this.f23309a = aVar;
        this.f23310b = str;
    }

    public void run() {
        this.f23309a.a(this.f23310b, new an(this));
    }
}
