package com.google.android.gms.common.util;

import android.util.Base64;

public final class C0458c {
    public static String m810a(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 0);
    }

    public static String m811b(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 10);
    }
}
