package com.google.android.gms.p015b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C0424f;
import java.util.concurrent.Executor;

final class C0364h<TResult> extends C0358b<TResult> {
    private final Object f257a = new Object();
    private final C0363g<TResult> f258b = new C0363g();
    private boolean f259c;
    private TResult f260d;
    private Exception f261e;

    C0364h() {
    }

    private void m318c() {
        C0424f.m655a(!this.f259c, (Object) "Task is already complete");
    }

    private void m319d() {
        synchronized (this.f257a) {
            if (this.f259c) {
                this.f258b.m316a((C0358b) this);
                return;
            }
        }
    }

    @NonNull
    public C0358b<TResult> mo1738a(@NonNull Executor executor, @NonNull C0357a<TResult> c0357a) {
        this.f258b.m317a(new C0361d(executor, c0357a));
        m319d();
        return this;
    }

    public void m321a(@NonNull Exception exception) {
        C0424f.m650a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f257a) {
            m318c();
            this.f259c = true;
            this.f261e = exception;
        }
        this.f258b.m316a((C0358b) this);
    }

    public void m322a(TResult tResult) {
        synchronized (this.f257a) {
            m318c();
            this.f259c = true;
            this.f260d = tResult;
        }
        this.f258b.m316a((C0358b) this);
    }

    public boolean mo1739a() {
        boolean z;
        synchronized (this.f257a) {
            z = this.f259c && this.f261e == null;
        }
        return z;
    }

    @Nullable
    public Exception mo1740b() {
        Exception exception;
        synchronized (this.f257a) {
            exception = this.f261e;
        }
        return exception;
    }

    public boolean m325b(@NonNull Exception exception) {
        boolean z = true;
        C0424f.m650a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f257a) {
            if (this.f259c) {
                z = false;
            } else {
                this.f259c = true;
                this.f261e = exception;
                this.f258b.m316a((C0358b) this);
            }
        }
        return z;
    }
}
