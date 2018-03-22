package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: URIResultParser */
public final class ad extends C3741u {
    private static final Pattern f14549a = Pattern.compile("[a-zA-Z0-9]{2,}:");
    private static final Pattern f14550b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18849a(c3934m);
    }

    public ac m18849a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        if (c.startsWith("URL:") || c.startsWith("URI:")) {
            return new ac(c.substring(4).trim(), null);
        }
        c = c.trim();
        return ad.m18848a(c) ? new ac(c, null) : null;
    }

    static boolean m18848a(String str) {
        if (str.contains(HwAccountConstants.BLANK)) {
            return false;
        }
        Matcher matcher = f14549a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        matcher = f14550b.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        return false;
    }
}
