package com.huawei.android.pushagent.p020b.p021a.p324a;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.util.Date;

public abstract class C4067b {
    public long f15415a = 0;
    public boolean f15416b = false;
    public Context f15417c = null;
    public int f15418d = 1;

    public C4067b(Context context) {
        this.f15417c = context;
    }

    public void m19955a() {
        if (a.b(this.f15417c) == this) {
            long b = mo4361b(false);
            e.a("PushLogAC2712", "after delayHeartBeatReq, nextHeartBeatTime, will be " + b + "ms later");
            com.huawei.android.pushagent.c.a.a.a(this.f15417c, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", b).setPackage(this.f15417c.getPackageName()), b);
        }
    }

    public void m19956a(int i) {
        this.f15418d = i;
    }

    public void m19957a(long j) {
        this.f15415a = j;
        new h(this.f15417c, mo4363c()).a("lastHeartBeatTime", Long.valueOf(j));
    }

    public void m19958a(boolean z) {
        this.f15416b = z;
    }

    public abstract long mo4361b(boolean z);

    public void m19960b() {
        if (a.b(this.f15417c) == this) {
            long e = m19965e() - System.currentTimeMillis();
            e.a("PushLogAC2712", "after updateHeartBeatReq, nextHeartBeatTime, will be " + e + "ms later");
            com.huawei.android.pushagent.c.a.a.a(this.f15417c, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", e).setPackage(this.f15417c.getPackageName()), e);
        }
    }

    public abstract boolean mo4362b(long j);

    public String mo4363c() {
        return getClass().getSimpleName();
    }

    public abstract void mo4364c(boolean z);

    public long m19964d() {
        return this.f15415a;
    }

    public long m19965e() {
        long currentTimeMillis = System.currentTimeMillis();
        long b = mo4361b(false);
        return (m19964d() > currentTimeMillis || m19964d() + b <= currentTimeMillis) ? currentTimeMillis + b : m19964d() + b;
    }

    public abstract C4067b mo4365f();

    public abstract void mo4366g();

    public String toString() {
        return new StringBuffer().append("lastHeartBeatTime").append(new Date(this.f15415a)).append(" heartBeatInterval").append(mo4361b(false)).toString();
    }
}
