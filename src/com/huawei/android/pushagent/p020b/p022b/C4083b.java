package com.huawei.android.pushagent.p020b.p022b;

import com.huawei.android.pushagent.a.e;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.p018c.p027c.C4116f;

class C4083b extends Thread {
    final /* synthetic */ a f15458a;

    C4083b(a aVar, String str) {
        this.f15458a = aVar;
        super(str);
    }

    public void run() {
        try {
            e a = C4116f.m20150a(a.a(this.f15458a), this.f15458a.b());
            if (a == null) {
                a = new e(a.b(this.f15458a));
            }
            if (a.V()) {
                a.a(this.f15458a, a);
            } else {
                com.huawei.android.pushagent.c.a.e.b("PushLogSC2712", "query trs error:" + this.f15458a.a());
            }
        } catch (Throwable e) {
            com.huawei.android.pushagent.c.a.e.c("PushLogSC2712", e.toString(), e);
        }
    }
}
