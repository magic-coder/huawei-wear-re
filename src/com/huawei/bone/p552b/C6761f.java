package com.huawei.bone.p552b;

import java.util.concurrent.CountDownLatch;

/* compiled from: MainInterators */
class C6761f implements Runnable {
    final /* synthetic */ CountDownLatch f23178a;
    final /* synthetic */ String f23179b;
    final /* synthetic */ C6760e f23180c;

    C6761f(C6760e c6760e, CountDownLatch countDownLatch, String str) {
        this.f23180c = c6760e;
        this.f23178a = countDownLatch;
        this.f23179b = str;
    }

    public void run() {
        this.f23180c.f23177a.m30027a(this.f23180c.f23177a.f23124g, this.f23180c.f23177a.m30087c(), new C6762g(this));
    }
}
