package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class C0485i implements Callable<String> {
    final /* synthetic */ SharedPreferences f501a;
    final /* synthetic */ String f502b;
    final /* synthetic */ String f503c;

    C0485i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f501a = sharedPreferences;
        this.f502b = str;
        this.f503c = str2;
    }

    public String m842a() {
        return this.f501a.getString(this.f502b, this.f503c);
    }

    public /* synthetic */ Object call() throws Exception {
        return m842a();
    }
}
