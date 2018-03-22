package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import java.util.List;

/* compiled from: VEventResultParser */
public final class ag extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18868a(c3934m);
    }

    public C3749g m18868a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (c.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String a = ag.m18865a("SUMMARY", c, true);
        String a2 = ag.m18865a("DTSTART", c, true);
        if (a2 == null) {
            return null;
        }
        double d;
        double d2;
        String a3 = ag.m18865a("DTEND", c, true);
        String a4 = ag.m18865a("DURATION", c, true);
        String a5 = ag.m18865a("LOCATION", c, true);
        String a6 = ag.m18866a(ag.m18865a("ORGANIZER", c, true));
        String[] b = ag.m18867b("ATTENDEE", c, true);
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                b[i] = ag.m18866a(b[i]);
            }
        }
        String a7 = ag.m18865a("DESCRIPTION", c, true);
        String a8 = ag.m18865a("GEO", c, true);
        if (a8 == null) {
            d = Double.NaN;
            d2 = Double.NaN;
        } else {
            int indexOf = a8.indexOf(59);
            try {
                d = Double.parseDouble(a8.substring(0, indexOf));
                d2 = Double.parseDouble(a8.substring(indexOf + 1));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        try {
            return new C3749g(a, a2, a3, a4, a5, a6, b, a7, d, d2);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    private static String m18865a(CharSequence charSequence, String str, boolean z) {
        List b = af.m18861b(charSequence, str, z, false);
        return (b == null || b.isEmpty()) ? null : (String) b.get(0);
    }

    private static String[] m18867b(CharSequence charSequence, String str, boolean z) {
        List a = af.m18855a(charSequence, str, z, false);
        if (a == null || a.isEmpty()) {
            return null;
        }
        int size = a.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) ((List) a.get(i)).get(0);
        }
        return strArr;
    }

    private static String m18866a(String str) {
        if (str == null) {
            return str;
        }
        if (str.startsWith("mailto:") || str.startsWith("MAILTO:")) {
            return str.substring(7);
        }
        return str;
    }
}
