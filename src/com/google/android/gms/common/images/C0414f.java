package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.C0421c;

final class C0414f {
    public final Uri f356a;

    public C0414f(Uri uri) {
        this.f356a = uri;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C0414f) ? false : this == obj ? true : C0421c.m647a(((C0414f) obj).f356a, this.f356a);
    }

    public int hashCode() {
        return C0421c.m645a(this.f356a);
    }
}
