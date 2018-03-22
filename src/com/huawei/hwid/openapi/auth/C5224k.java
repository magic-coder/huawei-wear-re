package com.huawei.hwid.openapi.auth;

import com.huawei.hwid.openapi.p445e.C5248c;

class C5224k implements Runnable {
    final /* synthetic */ C5223j f18846a;

    C5224k(C5223j c5223j) {
        this.f18846a = c5223j;
    }

    public void run() {
        if (this.f18846a.f18845b.f18839c.getProgress() < 100) {
            C5248c.m25445a("testTimeout", "timeout...........");
            this.f18846a.f18845b.m25365a(this.f18846a.f18844a);
        }
    }
}
