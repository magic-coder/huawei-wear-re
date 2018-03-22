package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.C0344b;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.internal.C0443x;

public final class C0515w<O extends C0344b> extends ad<O> {
    private final C0372j f824b;
    private final C0510q f825c;
    private final C0443x f826d;
    private final C0369f<? extends dk, dl> f827e;

    public C0515w(@NonNull Context context, C0367a<O> c0367a, Looper looper, @NonNull C0372j c0372j, @NonNull C0510q c0510q, C0443x c0443x, C0369f<? extends dk, dl> c0369f) {
        super(context, c0367a, looper);
        this.f824b = c0372j;
        this.f825c = c0510q;
        this.f826d = c0443x;
        this.f827e = c0369f;
        this.a.m1025a((ad) this);
    }

    public C0372j mo1895a(Looper looper, bb<O> bbVar) {
        this.f825c.m1506a((C0496r) bbVar);
        return this.f824b;
    }

    public bz mo1896a(Context context, Handler handler) {
        return new bz(context, handler, this.f826d, this.f827e);
    }

    public C0372j m1547e() {
        return this.f824b;
    }
}
