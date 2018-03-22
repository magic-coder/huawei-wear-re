package com.huawei.android.pushselfshow.richpush.p340b;

import com.huawei.android.pushagent.c.a.e;

class C4169g implements Runnable {
    final /* synthetic */ C4163a f15667a;

    public void run() {
        e.a("PushSelfShowLog", "onCreate mThread run");
        if (!this.f15667a.f15645m) {
            this.f15667a.m20312a(this.f15667a.f15634b);
        }
        this.f15667a.f15641i.m20330b();
        this.f15667a.f15633a.sendEmptyMessage(1000);
    }
}
