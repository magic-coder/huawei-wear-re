package com.huawei.hms.support.log.p044a;

import android.content.Context;
import com.huawei.hms.support.log.p044a.C0884a.C0883a;

/* compiled from: FileLogNode */
class C0885b implements Runnable {
    final /* synthetic */ Context f1413a;
    final /* synthetic */ String f1414b;
    final /* synthetic */ C0883a f1415c;

    C0885b(C0883a c0883a, Context context, String str) {
        this.f1415c = c0883a;
        this.f1413a = context;
        this.f1414b = str;
    }

    public void run() {
        this.f1415c.f1409a.mo2262a(this.f1413a, this.f1414b);
    }
}
