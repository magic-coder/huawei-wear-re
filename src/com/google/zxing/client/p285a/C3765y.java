package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;

/* compiled from: SMTPResultParser */
public final class C3765y extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18918a(c3934m);
    }

    public C3750h m18918a(C3934m c3934m) {
        String str = null;
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("smtp:") && !c.startsWith("SMTP:")) {
            return null;
        }
        String substring = c.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            c = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            indexOf = c.indexOf(58);
            if (indexOf >= 0) {
                str = c.substring(indexOf + 1);
                c = c.substring(0, indexOf);
            }
        } else {
            c = null;
        }
        return new C3750h(substring, c, str, "mailto:" + substring);
    }
}
