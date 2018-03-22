package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.p278b.C3712a;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension5Support */
final class C3877n {
    private static final int[] f14958a = new int[]{24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] f14959b = new int[4];
    private final StringBuilder f14960c = new StringBuilder();

    C3877n() {
    }

    C3934m m19306a(int i, C3712a c3712a, int[] iArr) throws C3932i {
        StringBuilder stringBuilder = this.f14960c;
        stringBuilder.setLength(0);
        int a = m19305a(c3712a, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a2 = C3877n.m19303a(stringBuilder2);
        C3934m c3934m = new C3934m(stringBuilder2, null, new C3922o[]{new C3922o(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i), new C3922o((float) a, (float) i)}, C3709a.UPC_EAN_EXTENSION);
        if (a2 != null) {
            c3934m.m19574a(a2);
        }
        return c3934m;
    }

    int m19305a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i {
        int[] iArr2 = this.f14959b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c3712a.m18676a();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && i < a; i3++) {
            int a2 = C3868p.m19261a(c3712a, iArr2, i, C3868p.f14939e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = 0;
            while (i4 < iArr2.length) {
                int i5 = iArr2[i4] + i;
                i4++;
                i = i5;
            }
            if (a2 >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                i = c3712a.m18684d(c3712a.m18682c(i));
            }
        }
        if (stringBuilder.length() != 5) {
            throw C3932i.m19565a();
        }
        if (C3877n.m19302a(stringBuilder.toString()) == C3877n.m19301a(i2)) {
            return i;
        }
        throw C3932i.m19565a();
    }

    private static int m19302a(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            i2 += charSequence.charAt(i) - 48;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            i2 += charSequence.charAt(i) - 48;
        }
        return (i2 * 3) % 10;
    }

    private static int m19301a(int i) throws C3932i {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f14958a[i2]) {
                return i2;
            }
        }
        throw C3932i.m19565a();
    }

    private static Map<C3935n, Object> m19303a(String str) {
        if (str.length() != 5) {
            return null;
        }
        String b = C3877n.m19304b(str);
        if (b == null) {
            return null;
        }
        Map<C3935n, Object> enumMap = new EnumMap(C3935n.class);
        enumMap.put(C3935n.SUGGESTED_PRICE, b);
        return enumMap;
    }

    private static String m19304b(String str) {
        Object obj;
        switch (str.charAt(0)) {
            case '0':
                obj = "£";
                break;
            case '5':
                obj = "$";
                break;
            case '9':
                if (!"90000".equals(str)) {
                    if (!"99991".equals(str)) {
                        if (!"99990".equals(str)) {
                            obj = "";
                            break;
                        }
                        return "Used";
                    }
                    return "0.00";
                }
                return null;
            default:
                obj = "";
                break;
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        parseInt %= 100;
        return new StringBuilder(String.valueOf(obj)).append(valueOf).append('.').append(parseInt < 10 ? "0" + parseInt : String.valueOf(parseInt)).toString();
    }
}
