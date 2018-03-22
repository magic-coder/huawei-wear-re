package com.huawei.android.pushagent.plugin;

import com.huawei.android.pushagent.plugin.p331a.C4126b;
import com.huawei.android.pushagent.plugin.p333c.C4134b;

class C4130a implements Runnable {
    final /* synthetic */ String f15530a;
    final /* synthetic */ long f15531b;
    final /* synthetic */ PushPlugins f15532c;

    C4130a(PushPlugins pushPlugins, String str, long j) {
        this.f15532c = pushPlugins;
        this.f15530a = str;
        this.f15531b = j;
    }

    public void run() {
        this.f15532c.m20169a(new C4134b(this.f15530a), C4126b.TAG, this.f15531b);
    }
}
