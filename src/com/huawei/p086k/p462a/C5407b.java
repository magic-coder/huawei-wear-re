package com.huawei.p086k.p462a;

/* compiled from: HEX */
public final class C5407b {
    private static final char[] f19221a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] f19222b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] m25993a(byte[] bArr, boolean z) {
        return C5407b.m25994a(bArr, z ? f19222b : f19221a);
    }

    private static char[] m25994a(byte[] bArr, char[] cArr) {
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

    public static String m25995b(byte[] bArr, boolean z) {
        return new String(C5407b.m25993a(bArr, z));
    }
}
