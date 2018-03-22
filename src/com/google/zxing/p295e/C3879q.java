package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3832d;
import com.google.zxing.C3900f;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;
import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: UPCEReader */
public final class C3879q extends C3868p {
    private static final int[] f14964a = new int[]{1, 1, 1, 1, 1, 1};
    private static final int[][] f14965f = new int[][]{new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] f14966g = new int[4];

    protected int mo4322a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i {
        int[] iArr2 = this.f14966g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c3712a.m18676a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < a) {
            int a2 = C3868p.m19261a(c3712a, iArr2, i, e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a2 >= 10) {
                i3 |= 1 << (5 - i2);
            }
            i2++;
            i = i4;
        }
        C3879q.m19308a(stringBuilder, i3);
        return i;
    }

    protected int[] mo4326a(C3712a c3712a, int i) throws C3932i {
        return C3868p.m19264a(c3712a, i, true, f14964a);
    }

    protected boolean mo4325a(String str) throws C3900f, C3832d {
        return super.mo4325a(C3879q.m19309b(str));
    }

    private static void m19308a(StringBuilder stringBuilder, int i) throws C3932i {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f14965f[i2][i3]) {
                    stringBuilder.insert(0, (char) (i2 + 48));
                    stringBuilder.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw C3932i.m19565a();
    }

    C3709a mo4323b() {
        return C3709a.UPC_E;
    }

    public static String m19309b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder stringBuilder = new StringBuilder(12);
        stringBuilder.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                stringBuilder.append(cArr, 0, 2);
                stringBuilder.append(c);
                stringBuilder.append("0000");
                stringBuilder.append(cArr, 2, 3);
                break;
            case '3':
                stringBuilder.append(cArr, 0, 3);
                stringBuilder.append(HwAccountConstants.DEFAULT_DEVICEPLMN);
                stringBuilder.append(cArr, 3, 2);
                break;
            case '4':
                stringBuilder.append(cArr, 0, 4);
                stringBuilder.append(HwAccountConstants.DEFAULT_DEVICEPLMN);
                stringBuilder.append(cArr[4]);
                break;
            default:
                stringBuilder.append(cArr, 0, 5);
                stringBuilder.append("0000");
                stringBuilder.append(c);
                break;
        }
        stringBuilder.append(str.charAt(7));
        return stringBuilder.toString();
    }
}
