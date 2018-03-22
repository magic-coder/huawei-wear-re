package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class C0481e implements Callable<Integer> {
    final /* synthetic */ SharedPreferences f495a;
    final /* synthetic */ String f496b;
    final /* synthetic */ Integer f497c;

    C0481e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f495a = sharedPreferences;
        this.f496b = str;
        this.f497c = num;
    }

    public Integer m838a() {
        return Integer.valueOf(this.f495a.getInt(this.f496b, this.f497c.intValue()));
    }

    public /* synthetic */ Object call() throws Exception {
        return m838a();
    }
}
