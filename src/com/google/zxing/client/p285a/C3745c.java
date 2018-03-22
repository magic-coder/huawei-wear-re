package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;

/* compiled from: AddressBookDoCoMoResultParser */
public final class C3745c extends C3742a {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18877a(c3934m);
    }

    public C3746d m18877a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("MECARD:")) {
            return null;
        }
        String[] a = C3742a.m18836a("N:", c, true);
        if (a == null) {
            return null;
        }
        String a2 = C3745c.m18876a(a[0]);
        String b = C3742a.m18837b("SOUND:", c, true);
        String[] a3 = C3742a.m18836a("TEL:", c, true);
        String[] a4 = C3742a.m18836a("EMAIL:", c, true);
        String b2 = C3742a.m18837b("NOTE:", c, false);
        String[] a5 = C3742a.m18836a("ADR:", c, true);
        String b3 = C3742a.m18837b("BDAY:", c, true);
        if (!(b3 == null || C3741u.m18826a((CharSequence) b3, 8))) {
            b3 = null;
        }
        String[] a6 = C3742a.m18836a("URL:", c, true);
        return new C3746d(C3741u.m18829b(a2), null, b, a3, null, a4, null, null, b2, a5, null, C3742a.m18837b("ORG:", c, true), b3, null, a6, null);
    }

    private static String m18876a(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
        }
        return str;
    }
}
