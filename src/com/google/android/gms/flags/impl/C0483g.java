package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class C0483g implements Callable<Long> {
    final /* synthetic */ SharedPreferences f498a;
    final /* synthetic */ String f499b;
    final /* synthetic */ Long f500c;

    C0483g(SharedPreferences sharedPreferences, String str, Long l) {
        this.f498a = sharedPreferences;
        this.f499b = str;
        this.f500c = l;
    }

    public Long m840a() {
        return Long.valueOf(this.f498a.getLong(this.f499b, this.f500c.longValue()));
    }

    public /* synthetic */ Object call() throws Exception {
        return m840a();
    }
}
