package com.huawei.bone.root;

import android.content.Context;

/* compiled from: MainActivity */
class C6792k implements Runnable {
    final /* synthetic */ Context f23333a;
    final /* synthetic */ C6791j f23334b;

    C6792k(C6791j c6791j, Context context) {
        this.f23334b = c6791j;
        this.f23333a = context;
    }

    public void run() {
        new Thread(new C6793l(this)).start();
    }
}
