package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BizcardResultParser */
public final class C3747e extends C3742a {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18882a(c3934m);
    }

    public C3746d m18882a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("BIZCARD:")) {
            return null;
        }
        String a = C3747e.m18880a(C3742a.m18837b("N:", c, true), C3742a.m18837b("X:", c, true));
        String b = C3742a.m18837b("T:", c, true);
        String b2 = C3742a.m18837b("C:", c, true);
        return new C3746d(C3741u.m18829b(a), null, null, C3747e.m18881a(C3742a.m18837b("B:", c, true), C3742a.m18837b("M:", c, true), C3742a.m18837b("F:", c, true)), null, C3741u.m18829b(C3742a.m18837b("E:", c, true)), null, null, null, C3742a.m18836a("A:", c, true), null, b2, null, b, null, null);
    }

    private static String[] m18881a(String str, String str2, String str3) {
        List arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String m18880a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            str = new StringBuilder(String.valueOf(str)).append(' ').append(str2).toString();
        }
        return str;
    }
}
