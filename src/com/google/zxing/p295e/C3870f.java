package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;

/* compiled from: EAN8Reader */
public final class C3870f extends C3868p {
    private final int[] f14945a = new int[4];

    protected int mo4322a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i {
        int[] iArr2 = this.f14945a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c3712a.m18676a();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < a) {
            stringBuilder.append((char) (C3868p.m19261a(c3712a, iArr2, i, d) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        i = C3868p.m19264a(c3712a, i, true, c)[1];
        i2 = 0;
        while (i2 < 4 && i < a) {
            stringBuilder.append((char) (C3868p.m19261a(c3712a, iArr2, i, d) + 48));
            i3 = i;
            for (int i42 : iArr2) {
                i3 += i42;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    C3709a mo4323b() {
        return C3709a.EAN_8;
    }
}
