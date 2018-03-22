package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;

/* compiled from: EAN13Reader */
public final class C3869e extends C3868p {
    static final int[] f14943a;
    private final int[] f14944f = new int[4];

    static {
        int[] iArr = new int[10];
        iArr[1] = 11;
        iArr[2] = 13;
        iArr[3] = 14;
        iArr[4] = 19;
        iArr[5] = 25;
        iArr[6] = 28;
        iArr[7] = 21;
        iArr[8] = 22;
        iArr[9] = 26;
        f14943a = iArr;
    }

    protected int mo4322a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i {
        int i;
        int[] iArr2 = this.f14944f;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c3712a.m18676a();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < a) {
            int a2 = C3868p.m19261a(c3712a, iArr2, i2, e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            i = i2;
            for (int i5 : iArr2) {
                i += i5;
            }
            if (a2 >= 10) {
                i4 |= 1 << (5 - i3);
            }
            i3++;
            i2 = i;
        }
        C3869e.m19272a(stringBuilder, i4);
        i4 = C3868p.m19264a(c3712a, i2, true, c)[1];
        i = 0;
        while (i < 6 && i4 < a) {
            stringBuilder.append((char) (C3868p.m19261a(c3712a, iArr2, i4, d) + 48));
            i2 = i4;
            for (int a22 : iArr2) {
                i2 += a22;
            }
            i++;
            i4 = i2;
        }
        return i4;
    }

    C3709a mo4323b() {
        return C3709a.EAN_13;
    }

    private static void m19272a(StringBuilder stringBuilder, int i) throws C3932i {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f14943a[i2]) {
                stringBuilder.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw C3932i.m19565a();
    }
}
