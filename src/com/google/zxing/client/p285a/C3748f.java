package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;

/* compiled from: BookmarkDoCoMoResultParser */
public final class C3748f extends C3742a {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18884a(c3934m);
    }

    public ac m18884a(C3934m c3934m) {
        String a = c3934m.m19572a();
        if (!a.startsWith("MEBKM:")) {
            return null;
        }
        String b = C3742a.m18837b("TITLE:", a, true);
        String[] a2 = C3742a.m18836a("URL:", a, true);
        if (a2 == null) {
            return null;
        }
        a = a2[0];
        if (ad.m18848a(a)) {
            return new ac(a, b);
        }
        return null;
    }
}
