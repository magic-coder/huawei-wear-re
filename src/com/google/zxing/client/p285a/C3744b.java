package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AddressBookAUResultParser */
public final class C3744b extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18874a(c3934m);
    }

    public C3746d m18874a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (!c.contains("MEMORY") || !c.contains("\r\n")) {
            return null;
        }
        return new C3746d(C3741u.m18829b(C3741u.m18828b("NAME1:", c, '\r', true)), null, C3741u.m18828b("NAME2:", c, '\r', true), C3744b.m18873a("TEL", 3, c, true), null, C3744b.m18873a("MAIL", 3, c, true), null, null, C3741u.m18828b("MEMORY:", c, '\r', false), C3741u.m18828b("ADD:", c, '\r', true) == null ? null : new String[]{C3741u.m18828b("ADD:", c, '\r', true)}, null, null, null, null, null, null);
    }

    private static String[] m18873a(String str, int i, String str2, boolean z) {
        List list = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String b = C3741u.m18828b(new StringBuilder(String.valueOf(str)).append(i2).append(':').toString(), str2, '\r', z);
            if (b == null) {
                break;
            }
            if (list == null) {
                list = new ArrayList(i);
            }
            list.add(b);
        }
        if (list == null) {
            return null;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
