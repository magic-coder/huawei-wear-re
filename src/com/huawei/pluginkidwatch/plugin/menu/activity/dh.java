package com.huawei.pluginkidwatch.plugin.menu.activity;

/* compiled from: EditPhoneNumActivity */
class dh implements Runnable {
    final /* synthetic */ int f6031a;
    final /* synthetic */ EditPhoneNumActivity f6032b;

    dh(EditPhoneNumActivity editPhoneNumActivity, int i) {
        this.f6032b = editPhoneNumActivity;
        this.f6031a = i;
    }

    public void run() {
        this.f6032b.m9299a(this.f6031a - 1);
    }
}
