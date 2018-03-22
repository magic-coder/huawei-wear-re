package com.huawei.al;

import android.content.Context;

/* compiled from: WordLibUtil */
class C4033f implements Runnable {
    final /* synthetic */ Context f15329a;
    final /* synthetic */ C4032e f15330b;

    C4033f(C4032e c4032e, Context context) {
        this.f15330b = c4032e;
        this.f15329a = context;
    }

    public void run() {
        this.f15330b.f15327a = new C4031d(this.f15329a);
        this.f15330b.f15328b.countDown();
        this.f15330b.f15328b = null;
    }
}
