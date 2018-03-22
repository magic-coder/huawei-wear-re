package com.huawei.hwid.p075d;

/* compiled from: HEX */
public final class C5206b {
    private static final char[] f18797a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] f18798b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] m25328a(byte[] bArr, boolean z) {
        return C5206b.m25329a(bArr, z ? f18798b : f18797a);
    }

    private static char[] m25329a(byte[] bArr, char[] cArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static String m25330b(byte[] bArr, boolean z) {
        return new String(C5206b.m25328a(bArr, z));
    }
}
