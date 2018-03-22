package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;

/* compiled from: URLTOResultParser */
public final class ae extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18851a(c3934m);
    }

    public ac m18851a(C3934m c3934m) {
        String str = null;
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("urlto:") && !c.startsWith("URLTO:")) {
            return null;
        }
        int indexOf = c.indexOf(58, 6);
        if (indexOf < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = c.substring(6, indexOf);
        }
        return new ac(c.substring(indexOf + 1), str);
    }
}
