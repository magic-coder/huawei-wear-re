package com.huawei.up.p518c;

import com.huawei.login.ui.login.util.C5433c;

/* compiled from: UserInfoManager */
class C6123c extends Thread {
    final /* synthetic */ String f21154a;
    final /* synthetic */ C6122b f21155b;

    C6123c(C6122b c6122b, String str) {
        this.f21155b = c6122b;
        this.f21154a = str;
    }

    public void run() {
        C5433c.m26039a(this.f21155b.f21149c).m26057e(this.f21154a);
    }
}
