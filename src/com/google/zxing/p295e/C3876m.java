package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.p278b.C3712a;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension2Support */
final class C3876m {
    private final int[] f14956a = new int[4];
    private final StringBuilder f14957b = new StringBuilder();

    C3876m() {
    }

    C3934m m19300a(int i, C3712a c3712a, int[] iArr) throws C3932i {
        StringBuilder stringBuilder = this.f14957b;
        stringBuilder.setLength(0);
        int a = m19299a(c3712a, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a2 = C3876m.m19298a(stringBuilder2);
        C3934m c3934m = new C3934m(stringBuilder2, null, new C3922o[]{new C3922o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i), new C3922o((float) a, (float) i)}, C3709a.UPC_EAN_EXTENSION);
        if (a2 != null) {
            c3934m.m19574a(a2);
        }
        return c3934m;
    }

    int m19299a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i {
        int[] iArr2 = this.f14956a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c3712a.m18676a();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 2 && i < a; i3++) {
            int a2 = C3868p.m19261a(c3712a, iArr2, i, C3868p.f14939e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = 0;
            while (i4 < iArr2.length) {
                int i5 = iArr2[i4] + i;
                i4++;
                i = i5;
            }
            if (a2 >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                i = c3712a.m18684d(c3712a.m18682c(i));
            }
        }
        if (stringBuilder.length() != 2) {
            throw C3932i.m19565a();
        } else if (Integer.parseInt(stringBuilder.toString()) % 4 == i2) {
            return i;
        } else {
            throw C3932i.m19565a();
        }
    }

    private static Map<C3935n, Object> m19298a(String str) {
        if (str.length() != 2) {
            return null;
        }
        Map<C3935n, Object> enumMap = new EnumMap(C3935n.class);
        enumMap.put(C3935n.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
