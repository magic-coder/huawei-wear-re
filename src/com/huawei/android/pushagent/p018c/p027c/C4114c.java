package com.huawei.android.pushagent.p018c.p027c;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.c.b;

final class C4114c implements Runnable {
    final /* synthetic */ Context f15507a;
    final /* synthetic */ Intent f15508b;

    C4114c(Context context, Intent intent) {
        this.f15507a = context;
        this.f15508b = intent;
    }

    public void run() {
        try {
            b.a(b.b(), this.f15507a, this.f15508b);
        } catch (Throwable e) {
            e.c("PushLogAC2712", "call handleEvent process cause Exception:" + e.toString(), e);
        }
    }
}
