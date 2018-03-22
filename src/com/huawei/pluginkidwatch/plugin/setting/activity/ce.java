package com.huawei.pluginkidwatch.plugin.setting.activity;

/* compiled from: SetKidWatchNumActivity */
class ce implements Runnable {
    final /* synthetic */ int f6657a;
    final /* synthetic */ SetKidWatchNumActivity f6658b;

    ce(SetKidWatchNumActivity setKidWatchNumActivity, int i) {
        this.f6658b = setKidWatchNumActivity;
        this.f6657a = i;
    }

    public void run() {
        this.f6658b.m10028a(this.f6657a - 1);
    }
}
