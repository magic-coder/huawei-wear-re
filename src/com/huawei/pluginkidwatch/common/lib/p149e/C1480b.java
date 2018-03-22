package com.huawei.pluginkidwatch.common.lib.p149e;

import java.nio.charset.Charset;

/* compiled from: StringUtils */
public class C1480b {
    private static byte[] m6808a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] m6807a(String str) {
        return C1480b.m6808a(str, C1479a.f3452f);
    }

    private static String m6806a(byte[] bArr, Charset charset) {
        return bArr == null ? null : new String(bArr, charset);
    }

    public static String m6805a(byte[] bArr) {
        return C1480b.m6806a(bArr, C1479a.f3452f);
    }
}
