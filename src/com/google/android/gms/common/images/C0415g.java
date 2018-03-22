package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.C0421c;
import java.lang.ref.WeakReference;

public final class C0415g extends C0413e {
    private WeakReference<C0409a> f357c;

    protected void mo1757a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        if (!z2) {
            C0409a c0409a = (C0409a) this.f357c.get();
            if (c0409a != null) {
                c0409a.m505a(this.a.f356a, drawable, z3);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0415g)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0415g c0415g = (C0415g) obj;
        C0409a c0409a = (C0409a) this.f357c.get();
        C0409a c0409a2 = (C0409a) c0415g.f357c.get();
        boolean z = c0409a2 != null && c0409a != null && C0421c.m647a(c0409a2, c0409a) && C0421c.m647a(c0415g.a, this.a);
        return z;
    }

    public int hashCode() {
        return C0421c.m645a(this.a);
    }
}
