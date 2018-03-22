package com.huawei.p111o.p478b;

import java.nio.charset.Charset;

/* compiled from: StringUtils */
public class C5703i {
    private static byte[] m26316a(String str, Charset charset) {
        if (str == null) {
            return new byte[0];
        }
        return str.getBytes(charset);
    }

    public static byte[] m26315a(String str) {
        return C5703i.m26316a(str, C5701g.f19454f);
    }

    private static String m26314a(byte[] bArr, Charset charset) {
        return bArr == null ? null : new String(bArr, charset);
    }

    public static String m26313a(byte[] bArr) {
        return C5703i.m26314a(bArr, C5701g.f19454f);
    }
}
