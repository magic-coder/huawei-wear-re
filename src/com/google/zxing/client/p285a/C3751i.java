package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import java.util.Map;

/* compiled from: EmailAddressResultParser */
public final class C3751i extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18891a(c3934m);
    }

    public C3750h m18891a(C3934m c3934m) {
        String str = null;
        String c = C3741u.m18830c(c3934m);
        if (c.startsWith("mailto:") || c.startsWith("MAILTO:")) {
            String str2;
            String substring = c.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            substring = C3741u.m18834e(substring);
            Map d = C3741u.m18833d(c);
            if (d != null) {
                if (substring.isEmpty()) {
                    str2 = (String) d.get("to");
                } else {
                    str2 = substring;
                }
                substring = (String) d.get("subject");
                str = (String) d.get("body");
            } else {
                str2 = substring;
                substring = null;
            }
            return new C3750h(str2, substring, str, c);
        } else if (C3752j.m18893a(c)) {
            return new C3750h(c, null, null, "mailto:" + c);
        } else {
            return null;
        }
    }
}