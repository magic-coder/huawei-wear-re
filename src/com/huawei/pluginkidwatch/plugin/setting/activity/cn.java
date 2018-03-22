package com.huawei.pluginkidwatch.plugin.setting.activity;

/* compiled from: SetPhoneNumActivity */
class cn implements Runnable {
    final /* synthetic */ int f6667a;
    final /* synthetic */ SetPhoneNumActivity f6668b;

    cn(SetPhoneNumActivity setPhoneNumActivity, int i) {
        this.f6668b = setPhoneNumActivity;
        this.f6667a = i;
    }

    public void run() {
        this.f6668b.m10049a(this.f6667a - 1);
    }
}
