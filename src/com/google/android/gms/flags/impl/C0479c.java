package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class C0479c implements Callable<Boolean> {
    final /* synthetic */ SharedPreferences f492a;
    final /* synthetic */ String f493b;
    final /* synthetic */ Boolean f494c;

    C0479c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f492a = sharedPreferences;
        this.f493b = str;
        this.f494c = bool;
    }

    public Boolean m836a() {
        return Boolean.valueOf(this.f492a.getBoolean(this.f493b, this.f494c.booleanValue()));
    }

    public /* synthetic */ Object call() throws Exception {
        return m836a();
    }
}
