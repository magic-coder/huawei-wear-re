package com.huawei.bone.p552b;

import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6759d implements Runnable {
    final /* synthetic */ int f23175a;
    final /* synthetic */ C6758c f23176b;

    C6759d(C6758c c6758c, int i) {
        this.f23176b = c6758c;
        this.f23175a = i;
    }

    public void run() {
        if (this.f23175a == 0) {
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 2"});
            this.f23176b.f23174a.m30102p();
        } else if (999 == this.f23175a) {
            this.f23176b.f23174a.m30067t();
        } else if (10 == this.f23175a) {
            this.f23176b.f23174a.m30068u();
        } else {
            this.f23176b.f23174a.f23126i.finish();
        }
    }
}
