package com.huawei.hms.support.log.p044a;

import com.huawei.hms.support.log.p044a.C0884a.C0883a;

/* compiled from: FileLogNode */
class C0886c implements Runnable {
    final /* synthetic */ String f1416a;
    final /* synthetic */ int f1417b;
    final /* synthetic */ String f1418c;
    final /* synthetic */ String f1419d;
    final /* synthetic */ C0883a f1420e;

    C0886c(C0883a c0883a, String str, int i, String str2, String str3) {
        this.f1420e = c0883a;
        this.f1416a = str;
        this.f1417b = i;
        this.f1418c = str2;
        this.f1419d = str3;
    }

    public void run() {
        this.f1420e.f1409a.mo2263a(this.f1416a, this.f1417b, this.f1418c, this.f1419d);
    }
}
