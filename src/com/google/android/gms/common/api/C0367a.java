package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.C0424f;

public final class C0367a<O extends C0344b> {
    private final C0369f<?, O> f265a;
    private final C0375m<?, O> f266b = null;
    private final C0373k<?> f267c;
    private final C0376n<?> f268d;
    private final String f269e;

    public <C extends C0372j> C0367a(String str, C0369f<C, O> c0369f, C0373k<C> c0373k) {
        C0424f.m650a((Object) c0369f, (Object) "Cannot construct an Api with a null ClientBuilder");
        C0424f.m650a((Object) c0373k, (Object) "Cannot construct an Api with a null ClientKey");
        this.f269e = str;
        this.f265a = c0369f;
        this.f267c = c0373k;
        this.f268d = null;
    }

    public C0368i<?, O> m333a() {
        return this.f265a;
    }

    public C0369f<?, O> m334b() {
        C0424f.m655a(this.f265a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f265a;
    }

    public C0371h<?> m335c() {
        if (this.f267c != null) {
            return this.f267c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public String m336d() {
        return this.f269e;
    }
}
