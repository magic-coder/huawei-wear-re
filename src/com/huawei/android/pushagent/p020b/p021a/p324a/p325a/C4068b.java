package com.huawei.android.pushagent.p020b.p021a.p324a.p325a;

import android.content.Context;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4067b;

public class C4068b extends C4067b {
    long f15419e = -1;

    public C4068b(Context context) {
        super(context);
        mo4365f();
    }

    public long mo4361b(boolean z) {
        if (-1 == C4103b.m20122a(this.c)) {
            return a.a(this.c).p() * 1000;
        }
        if (m19974h()) {
            mo4365f();
        }
        if (this.f15419e > 0) {
            return this.f15419e;
        }
        long B = a.a(this.c).B() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (m19964d() >= currentTimeMillis) {
            m19957a(0);
        }
        return m19964d() <= currentTimeMillis - (a.a(this.c).B() * 1000) ? a.a(this.c).B() * 1000 : (m19964d() > currentTimeMillis || currentTimeMillis > m19964d() + (a.a(this.c).B() * 1000)) ? B : (m19964d() + (a.a(this.c).B() * 1000)) - currentTimeMillis;
    }

    public boolean mo4362b(long j) {
        this.f15419e = j;
        return true;
    }

    public String mo4363c() {
        return "Push_PollingHBeat";
    }

    public void mo4364c(boolean z) {
    }

    public C4067b mo4365f() {
        this.a = new h(this.c, mo4363c()).d("lastHeartBeatTime");
        return this;
    }

    public void mo4366g() {
        try {
            com.huawei.android.pushagent.b.a.a.f().mo4358a(false);
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
        }
    }

    protected boolean m19974h() {
        return false;
    }
}
