package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;

/* compiled from: WifiResultParser */
public final class ai extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18871a(c3934m);
    }

    public ah m18871a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (!c.startsWith("WIFI:")) {
            return null;
        }
        String b = C3741u.m18828b("S:", c, ';', false);
        if (b == null || b.isEmpty()) {
            return null;
        }
        String b2 = C3741u.m18828b("P:", c, ';', false);
        String b3 = C3741u.m18828b("T:", c, ';', false);
        if (b3 == null) {
            b3 = "nopass";
        }
        return new ah(b3, b, b2, Boolean.parseBoolean(C3741u.m18828b("H:", c, ';', false)));
    }
}
