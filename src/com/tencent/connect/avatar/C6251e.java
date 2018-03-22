package com.tencent.connect.avatar;

/* compiled from: ProGuard */
class C6251e implements Runnable {
    final /* synthetic */ String f21759a;
    final /* synthetic */ int f21760b;
    final /* synthetic */ ImageActivity f21761c;

    C6251e(ImageActivity imageActivity, String str, int i) {
        this.f21761c = imageActivity;
        this.f21759a = str;
        this.f21760b = i;
    }

    public void run() {
        this.f21761c.m28733b(this.f21759a, this.f21760b);
    }
}
