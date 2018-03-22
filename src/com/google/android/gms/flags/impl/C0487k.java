package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class C0487k implements Callable<SharedPreferences> {
    final /* synthetic */ Context f505a;

    C0487k(Context context) {
        this.f505a = context;
    }

    public SharedPreferences m844a() {
        return this.f505a.getSharedPreferences("google_sdk_flags", 1);
    }

    public /* synthetic */ Object call() throws Exception {
        return m844a();
    }
}
