package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ResultParser */
public abstract class C3741u {
    private static final C3741u[] f14538a = new C3741u[]{new C3748f(), new C3745c(), new C3752j(), new C3744b(), new af(), new C3747e(), new ag(), new C3751i(), new C3765y(), new aa(), new C3762v(), new C3764x(), new C3756n(), new ai(), new ae(), new ad(), new C3758p(), new C3761t(), new C3754l()};
    private static final Pattern f14539b = Pattern.compile("\\d*");
    private static final Pattern f14540c = Pattern.compile("[a-zA-Z0-9]*");
    private static final Pattern f14541d = Pattern.compile(SNBConstant.FILTER);
    private static final Pattern f14542e = Pattern.compile("=");

    public abstract C3743q mo4308b(C3934m c3934m);

    protected static String m18830c(C3934m c3934m) {
        String a = c3934m.m19572a();
        if (a.startsWith("﻿")) {
            return a.substring(1);
        }
        return a;
    }

    public static C3743q m18832d(C3934m c3934m) {
        for (C3741u b : f14538a) {
            C3743q b2 = b.mo4308b(c3934m);
            if (b2 != null) {
                return b2;
            }
        }
        return new ab(c3934m.m19572a(), null);
    }

    protected static String[] m18829b(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static String m18831c(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length - 1);
        stringBuilder.append(str.toCharArray(), 0, indexOf);
        indexOf = 0;
        for (int i = indexOf; i < length; i++) {
            char charAt = str.charAt(i);
            if (indexOf == 0 && charAt == '\\') {
                indexOf = 1;
            } else {
                stringBuilder.append(charAt);
                indexOf = 0;
            }
        }
        return stringBuilder.toString();
    }

    protected static int m18824a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 65) + 10;
    }

    protected static boolean m18826a(CharSequence charSequence, int i) {
        return charSequence != null && i == charSequence.length() && f14539b.matcher(charSequence).matches();
    }

    static Map<String, String> m18833d(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        Map hashMap = new HashMap(3);
        for (CharSequence a : f14541d.split(str.substring(indexOf + 1))) {
            C3741u.m18825a(a, hashMap);
        }
        return hashMap;
    }

    private static void m18825a(CharSequence charSequence, Map<String, String> map) {
        String[] split = f14542e.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], C3741u.m18834e(split[1]));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    static String m18834e(String str) {
        try {
            return URLDecoder.decode(str, GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    static String[] m18827a(String str, String str2, char c, boolean z) {
        int length = str2.length();
        int i = 0;
        List list = null;
        while (i < length) {
            i = str2.indexOf(str, i);
            if (i < 0) {
                break;
            }
            int length2 = i + str.length();
            Object obj = 1;
            List list2 = list;
            int i2 = length2;
            while (obj != null) {
                int indexOf = str2.indexOf(c, i2);
                if (indexOf < 0) {
                    i2 = str2.length();
                    obj = null;
                } else if (str2.charAt(indexOf - 1) == '\\') {
                    i2 = indexOf + 1;
                } else {
                    if (list2 == null) {
                        list2 = new ArrayList(3);
                    }
                    String c2 = C3741u.m18831c(str2.substring(length2, indexOf));
                    if (z) {
                        c2 = c2.trim();
                    }
                    if (!c2.isEmpty()) {
                        list2.add(c2);
                    }
                    i2 = indexOf + 1;
                    obj = null;
                }
            }
            int i3 = i2;
            list = list2;
            i = i3;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    static String m18828b(String str, String str2, char c, boolean z) {
        String[] a = C3741u.m18827a(str, str2, c, z);
        return a == null ? null : a[0];
    }
}
