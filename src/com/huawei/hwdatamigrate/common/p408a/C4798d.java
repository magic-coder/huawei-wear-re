package com.huawei.hwdatamigrate.common.p408a;

import com.huawei.p111o.p478b.C5701g;
import java.nio.charset.Charset;

/* compiled from: StringUtils */
public class C4798d {
    public static byte[] m22979a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    private static String m22977a(byte[] bArr, Charset charset) {
        return bArr == null ? null : new String(bArr, charset);
    }

    public static String m22976a(byte[] bArr) {
        return C4798d.m22977a(bArr, C5701g.f19454f);
    }

    public static byte[] m22978a(String str) {
        return C4798d.m22979a(str, C5701g.f19454f);
    }
}
