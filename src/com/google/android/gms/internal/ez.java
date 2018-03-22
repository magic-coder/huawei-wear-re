package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0344b;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.internal.C0421c;

public final class ez<O extends C0344b> {
    private final boolean f777a = true;
    private final int f778b;
    private final C0367a<O> f779c;
    private final O f780d;

    private ez(C0367a<O> c0367a) {
        this.f779c = c0367a;
        this.f780d = null;
        this.f778b = System.identityHashCode(this);
    }

    public static <O extends C0344b> ez<O> m1467a(C0367a<O> c0367a) {
        return new ez(c0367a);
    }

    public String m1468a() {
        return this.f779c.m336d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ez)) {
            return false;
        }
        ez ezVar = (ez) obj;
        return !this.f777a && !ezVar.f777a && C0421c.m647a(this.f779c, ezVar.f779c) && C0421c.m647a(this.f780d, ezVar.f780d);
    }

    public int hashCode() {
        return this.f778b;
    }
}
