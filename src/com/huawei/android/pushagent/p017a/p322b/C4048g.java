package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.c.a;
import java.io.Serializable;

public class C4048g implements Serializable {
    private long f15355a;
    private byte f15356b;
    private byte f15357c;

    public long m19888a() {
        return this.f15355a;
    }

    public void m19889a(byte b) {
        this.f15356b = b;
    }

    public void m19890a(long j) {
        this.f15355a = j;
    }

    public byte m19891b() {
        return this.f15356b;
    }

    public void m19892b(byte b) {
        this.f15357c = b;
    }

    public byte m19893c() {
        return this.f15357c;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" netEventTime:").append(a.a(this.f15355a, "yyyy-MM-dd HH:mm:ss SSS")).append(" netType:").append(this.f15356b).append(" netEvent:").append(this.f15357c).toString();
    }
}
