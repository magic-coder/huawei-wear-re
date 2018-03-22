package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GeoResultParser */
public final class C3756n extends C3741u {
    private static final Pattern f14621a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18904a(c3934m);
    }

    public C3755m m18904a(C3934m c3934m) {
        double d = 0.0d;
        Matcher matcher = f14621a.matcher(C3741u.m18830c(c3934m));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble > 90.0d || parseDouble < -90.0d) {
                return null;
            }
            double parseDouble2 = Double.parseDouble(matcher.group(2));
            if (parseDouble2 > 180.0d || parseDouble2 < -180.0d) {
                return null;
            }
            if (matcher.group(3) != null) {
                double parseDouble3 = Double.parseDouble(matcher.group(3));
                if (parseDouble3 < 0.0d) {
                    return null;
                }
                d = parseDouble3;
            }
            return new C3755m(parseDouble, parseDouble2, d, group);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
