package com.google.zxing.client.p285a;

import com.google.zxing.C3709a;
import com.google.zxing.C3934m;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ExpandedProductResultParser */
public final class C3754l extends C3741u {
    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18901a(c3934m);
    }

    public C3753k m18901a(C3934m c3934m) {
        if (c3934m.m19578d() != C3709a.RSS_EXPANDED) {
            return null;
        }
        String c = C3741u.m18830c(c3934m);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < c.length()) {
            String a = C3754l.m18899a(i, c);
            if (a == null) {
                return null;
            }
            i += a.length() + 2;
            String b = C3754l.m18900b(i, c);
            i += b.length();
            if ("00".equals(a)) {
                str2 = b;
            } else if ("01".equals(a)) {
                str = b;
            } else if (WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD.equals(a)) {
                str3 = b;
            } else if ("11".equals(a)) {
                str4 = b;
            } else if ("13".equals(a)) {
                str5 = b;
            } else if ("15".equals(a)) {
                str6 = b;
            } else if ("17".equals(a)) {
                str7 = b;
            } else if ("3100".equals(a) || "3101".equals(a) || "3102".equals(a) || "3103".equals(a) || "3104".equals(a) || "3105".equals(a) || "3106".equals(a) || "3107".equals(a) || "3108".equals(a) || "3109".equals(a)) {
                str9 = "KG";
                str10 = a.substring(3);
                str8 = b;
            } else if ("3200".equals(a) || "3201".equals(a) || "3202".equals(a) || "3203".equals(a) || "3204".equals(a) || "3205".equals(a) || "3206".equals(a) || "3207".equals(a) || "3208".equals(a) || "3209".equals(a)) {
                str9 = "LB";
                str10 = a.substring(3);
                str8 = b;
            } else if ("3920".equals(a) || "3921".equals(a) || "3922".equals(a) || "3923".equals(a)) {
                str12 = a.substring(3);
                str11 = b;
            } else if (!"3930".equals(a) && !"3931".equals(a) && !"3932".equals(a) && !"3933".equals(a)) {
                hashMap.put(a, b);
            } else if (b.length() < 4) {
                return null;
            } else {
                str11 = b.substring(3);
                str13 = b.substring(0, 3);
                str12 = a.substring(3);
            }
        }
        return new C3753k(c, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }

    private static String m18899a(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        CharSequence substring = str.substring(i + 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return stringBuilder.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    private static String m18900b(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (C3754l.m18899a(i2, substring) != null) {
                    break;
                }
                stringBuilder.append('(');
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
