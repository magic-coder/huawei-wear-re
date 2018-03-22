package com.google.zxing.client.p285a;

import java.util.regex.Pattern;

/* compiled from: URIParsedResult */
public final class ac extends C3743q {
    private static final Pattern f14546a = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String f14547b;
    private final String f14548c;

    public ac(String str, String str2) {
        super(C3759r.URI);
        this.f14547b = ac.m18845a(str);
        this.f14548c = str2;
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(30);
        C3743q.m18840a(this.f14548c, stringBuilder);
        C3743q.m18840a(this.f14547b, stringBuilder);
        return stringBuilder.toString();
    }

    private static String m18845a(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf < 0) {
            return "http://" + trim;
        }
        if (ac.m18846a(trim, indexOf)) {
            return "http://" + trim;
        }
        return trim;
    }

    private static boolean m18846a(String str, int i) {
        int length;
        int indexOf = str.indexOf(47, i + 1);
        if (indexOf < 0) {
            length = str.length();
        } else {
            length = indexOf;
        }
        if (length <= i + 1) {
            return false;
        }
        indexOf = i + 1;
        while (indexOf < length) {
            if (str.charAt(indexOf) < '0' || str.charAt(indexOf) > '9') {
                return false;
            }
            indexOf++;
        }
        return true;
    }
}
