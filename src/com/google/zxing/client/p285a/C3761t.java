package com.google.zxing.client.p285a;

import com.google.zxing.C3709a;
import com.google.zxing.C3934m;
import com.google.zxing.p295e.C3879q;

/* compiled from: ProductResultParser */
public final class C3761t extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18910a(c3934m);
    }

    public C3760s m18910a(C3934m c3934m) {
        C3709a d = c3934m.m19578d();
        if (d != C3709a.UPC_A && d != C3709a.UPC_E && d != C3709a.EAN_8 && d != C3709a.EAN_13) {
            return null;
        }
        String b;
        String c = C3741u.m18830c(c3934m);
        int length = c.length();
        for (int i = 0; i < length; i++) {
            char charAt = c.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
        }
        if (d == C3709a.UPC_E) {
            b = C3879q.m19309b(c);
        } else {
            b = c;
        }
        return new C3760s(c, b);
    }
}
