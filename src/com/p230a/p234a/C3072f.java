package com.p230a.p234a;

import android.content.Context;
import java.util.HashMap;

final class C3072f implements Runnable {
    private /* synthetic */ C3067e f10333a;
    private final /* synthetic */ Context f10334b;
    private final /* synthetic */ HashMap f10335c;

    C3072f(C3067e c3067e, Context context, HashMap hashMap) {
        this.f10333a = c3067e;
        this.f10334b = context;
        this.f10335c = hashMap;
    }

    public final void run() {
        try {
            this.f10333a.m13751a(this.f10334b, this.f10335c);
        } catch (Exception e) {
            e.printStackTrace();
            this.f10333a.mo3643b();
        }
    }
}
