package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import java.util.regex.Pattern;

/* compiled from: EmailDoCoMoResultParser */
public final class C3752j extends C3742a {
    private static final Pattern f14601a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18894a(c3934m);
    }

    public C3750h m18894a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("MATMSG:")) {
            return null;
        }
        String[] a = C3742a.m18836a("TO:", c, true);
        if (a == null) {
            return null;
        }
        String str = a[0];
        if (C3752j.m18893a(str)) {
            return new C3750h(str, C3742a.m18837b("SUB:", c, false), C3742a.m18837b("BODY:", c, false), "mailto:" + str);
        }
        return null;
    }

    static boolean m18893a(String str) {
        return str != null && f14601a.matcher(str).matches() && str.indexOf(64) >= 0;
    }
}
