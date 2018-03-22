package com.google.zxing.client.p285a;

import com.google.zxing.C3709a;
import com.google.zxing.C3934m;

/* compiled from: ISBNResultParser */
public final class C3758p extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18907a(c3934m);
    }

    public C3757o m18907a(C3934m c3934m) {
        if (c3934m.m19578d() != C3709a.EAN_13) {
            return null;
        }
        String c = C3741u.m18830c(c3934m);
        if (c.length() != 13) {
            return null;
        }
        if (c.startsWith("978") || c.startsWith("979")) {
            return new C3757o(c);
        }
        return null;
    }
}
