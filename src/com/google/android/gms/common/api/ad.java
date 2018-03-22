package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.C0503g;
import com.google.android.gms.internal.az;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bh;
import com.google.android.gms.internal.bz;
import com.google.android.gms.internal.cc;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ez;

public abstract class ad<O extends C0344b> {
    protected final az f272a;
    private final Context f273b;
    private final C0367a<O> f274c;
    private final O f275d = null;
    private final ez<O> f276e;
    private final Looper f277f;
    private final int f278g;
    private final C0378p f279h;
    private final cc f280i;
    private final Account f281j;

    protected ad(@NonNull Context context, C0367a<O> c0367a, Looper looper) {
        C0424f.m650a((Object) context, (Object) "Null context is not permitted.");
        C0424f.m650a((Object) c0367a, (Object) "Api must not be null.");
        C0424f.m650a((Object) looper, (Object) "Looper must not be null.");
        this.f273b = context.getApplicationContext();
        this.f274c = c0367a;
        this.f277f = looper;
        this.f276e = ez.m1467a(c0367a);
        this.f279h = new bh(this);
        this.f272a = az.m1002a(this.f273b);
        this.f278g = this.f272a.m1029b();
        this.f280i = new ey();
        this.f281j = null;
    }

    private <A extends C0370g, T extends C0503g<? extends C0366w, A>> T m339a(int i, @NonNull T t) {
        t.m1487i();
        this.f272a.m1026a(this, i, t);
        return t;
    }

    public C0367a<O> m340a() {
        return this.f274c;
    }

    @WorkerThread
    public C0372j mo1895a(Looper looper, bb<O> bbVar) {
        return this.f274c.m334b().mo1854a(this.f273b, looper, new C0379q(this.f273b).m392a(this.f281j).m397a(), this.f275d, bbVar, bbVar);
    }

    public bz mo1896a(Context context, Handler handler) {
        return new bz(context, handler);
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T m343a(@NonNull T t) {
        return m339a(0, (C0503g) t);
    }

    public ez<O> m344b() {
        return this.f276e;
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T m345b(@NonNull T t) {
        return m339a(1, (C0503g) t);
    }

    public int m346c() {
        return this.f278g;
    }

    public Looper m347d() {
        return this.f277f;
    }
}
