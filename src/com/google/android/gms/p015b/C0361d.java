package com.google.android.gms.p015b;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class C0361d<TResult> implements C0360f<TResult> {
    private final Executor f249a;
    private final Object f250b = new Object();
    private C0357a<TResult> f251c;

    public C0361d(@NonNull Executor executor, @NonNull C0357a<TResult> c0357a) {
        this.f249a = executor;
        this.f251c = c0357a;
    }

    public void mo1737a(@NonNull C0358b<TResult> c0358b) {
        synchronized (this.f250b) {
            if (this.f251c == null) {
                return;
            }
            this.f249a.execute(new C0362e(this, c0358b));
        }
    }
}
