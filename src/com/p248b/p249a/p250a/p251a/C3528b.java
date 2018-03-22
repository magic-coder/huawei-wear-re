package com.p248b.p249a.p250a.p251a;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;

/* compiled from: Gaia */
public class C3528b {
    public static byte[] m17646a(int i, int i2, byte[] bArr, int i3, byte b) throws IOException {
        int i4 = 0;
        if (i3 > 254) {
            throw new IOException("GAIA frame full");
        }
        int i5;
        byte b2 = (b & 1) != 0 ? (byte) 1 : (byte) 0;
        int i6 = i3 + 8;
        if (b2 != (byte) 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        i6 += i5;
        byte[] bArr2 = new byte[i6];
        bArr2[0] = (byte) -1;
        bArr2[1] = (byte) 1;
        bArr2[2] = b;
        bArr2[3] = (byte) i3;
        bArr2[4] = (byte) (i >> 8);
        bArr2[5] = (byte) i;
        bArr2[6] = (byte) (i2 >> 8);
        bArr2[7] = (byte) i2;
        if (bArr != null) {
            for (i5 = 0; i5 < i3; i5++) {
                bArr2[i5 + 8] = bArr[i5];
            }
        }
        if (b2 != (byte) 0) {
            byte b3 = (byte) 0;
            while (i4 < i6 - 1) {
                b3 = (byte) (b3 ^ bArr2[i4]);
                i4++;
            }
            bArr2[i6 - 1] = b3;
        }
        return bArr2;
    }

    public static byte[] m17645a(int i, int i2, byte[] bArr, int i3) throws IOException {
        return C3528b.m17646a(i, i2, bArr, i3, (byte) 0);
    }

    public static byte[] m17644a(int i, int i2, byte[] bArr, byte b) throws IOException {
        int i3;
        if (bArr == null) {
            i3 = 0;
        } else {
            i3 = bArr.length;
        }
        return C3528b.m17646a(i, i2, bArr, i3, b);
    }

    public static byte[] m17643a(int i, int i2, byte[] bArr) throws IOException {
        return C3528b.m17644a(i, i2, bArr, (byte) 0);
    }

    public static byte[] m17642a(int i, int i2) throws IOException {
        return C3528b.m17643a(i, i2, null);
    }

    public static String m17640a(byte b) {
        return String.format("%02X", new Object[]{Integer.valueOf(b & 255)});
    }

    public static String m17641a(int i) {
        return String.format("%04X", new Object[]{Integer.valueOf(SupportMenu.USER_MASK & i)});
    }
}
