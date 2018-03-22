package com.huawei.hms.p039c;

/* compiled from: HEX */
public final class C0853b {
    private static final char[] f1350a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] f1351b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] m3004a(byte[] bArr, boolean z) {
        return C0853b.m3005a(bArr, z ? f1351b : f1350a);
    }

    private static char[] m3005a(byte[] bArr, char[] cArr) {
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

    public static String m3006b(byte[] bArr, boolean z) {
        return new String(C0853b.m3004a(bArr, z));
    }
}
