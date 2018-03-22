package com.huawei.hms.update.p045a;

import java.io.File;

/* compiled from: ThreadWrapper */
class C0907n implements Runnable {
    final /* synthetic */ int f1494a;
    final /* synthetic */ int f1495b;
    final /* synthetic */ int f1496c;
    final /* synthetic */ File f1497d;
    final /* synthetic */ C0905l f1498e;

    C0907n(C0905l c0905l, int i, int i2, int i3, File file) {
        this.f1498e = c0905l;
        this.f1494a = i;
        this.f1495b = i2;
        this.f1496c = i3;
        this.f1497d = file;
    }

    public void run() {
        this.f1498e.f1490a.mo2269a(this.f1494a, this.f1495b, this.f1496c, this.f1497d);
    }
}
