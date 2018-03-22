package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;

/* compiled from: TelResultParser */
public final class aa extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18838a(c3934m);
    }

    public C3766z m18838a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("tel:") && !c.startsWith("TEL:")) {
            return null;
        }
        String str;
        if (c.startsWith("TEL:")) {
            str = "tel:" + c.substring(4);
        } else {
            str = c;
        }
        int indexOf = c.indexOf(63, 4);
        return new C3766z(indexOf < 0 ? c.substring(4) : c.substring(4, indexOf), str, null);
    }
}
