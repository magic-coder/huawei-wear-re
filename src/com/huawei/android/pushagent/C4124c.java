package com.huawei.android.pushagent;

import android.os.MessageQueue.IdleHandler;

class C4124c implements IdleHandler {
    final /* synthetic */ b f15514a;

    C4124c(b bVar) {
        this.f15514a = bVar;
    }

    public boolean queueIdle() {
        if (b.a(this.f15514a).isHeld()) {
            b.a(this.f15514a).release();
        }
        return true;
    }
}
