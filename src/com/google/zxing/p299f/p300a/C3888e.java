package com.google.zxing.p299f.p300a;

import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p299f.C3899c;
import java.math.BigInteger;
import java.util.Arrays;

/* compiled from: DecodedBitStreamParser */
final class C3888e {
    private static final char[] f15008a = new char[]{';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final char[] f15009b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '\r', '\t', ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};
    private static final BigInteger[] f15010c = new BigInteger[16];
    private static /* synthetic */ int[] f15011d;

    static /* synthetic */ int[] m19373a() {
        int[] iArr = f15011d;
        if (iArr == null) {
            iArr = new int[C3889f.values().length];
            try {
                iArr[C3889f.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C3889f.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C3889f.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C3889f.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C3889f.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C3889f.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            f15011d = iArr;
        }
        return iArr;
    }

    static {
        f15010c[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        f15010c[1] = valueOf;
        for (int i = 2; i < f15010c.length; i++) {
            f15010c[i] = f15010c[i - 1].multiply(valueOf);
        }
    }

    static C3720e m19370a(int[] iArr, String str) throws C3900f {
        StringBuilder stringBuilder = new StringBuilder(iArr.length * 2);
        int i = 2;
        int i2 = iArr[1];
        Object c3899c = new C3899c();
        while (i < iArr[0]) {
            switch (i2) {
                case 900:
                    i2 = C3888e.m19369a(iArr, i, stringBuilder);
                    break;
                case 901:
                case 913:
                case 924:
                    i2 = C3888e.m19367a(i2, iArr, i, stringBuilder);
                    break;
                case 902:
                    i2 = C3888e.m19374b(iArr, i, stringBuilder);
                    break;
                case 922:
                case 923:
                    throw C3900f.m19459a();
                case 928:
                    i2 = C3888e.m19368a(iArr, i, (C3899c) c3899c);
                    break;
                default:
                    i2 = C3888e.m19369a(iArr, i - 1, stringBuilder);
                    break;
            }
            if (i2 < iArr.length) {
                i = i2 + 1;
                i2 = iArr[i2];
            } else {
                throw C3900f.m19459a();
            }
        }
        if (stringBuilder.length() == 0) {
            throw C3900f.m19459a();
        }
        C3720e c3720e = new C3720e(null, stringBuilder.toString(), null, str);
        c3720e.m18727a(c3899c);
        return c3720e;
    }

    private static int m19368a(int[] iArr, int i, C3899c c3899c) throws C3900f {
        if (i + 2 > iArr[0]) {
            throw C3900f.m19459a();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        c3899c.m19455a(Integer.parseInt(C3888e.m19371a(iArr2, 2)));
        StringBuilder stringBuilder = new StringBuilder();
        int a = C3888e.m19369a(iArr, i, stringBuilder);
        c3899c.m19456a(stringBuilder.toString());
        if (iArr[a] == 923) {
            i2 = a + 1;
            int[] iArr3 = new int[(iArr[0] - i2)];
            int i3 = 0;
            a = i2;
            i2 = 0;
            while (a < iArr[0] && r0 == 0) {
                int i4 = a + 1;
                int i5 = iArr[a];
                if (i5 < 900) {
                    a = i3 + 1;
                    iArr3[i3] = i5;
                    i3 = a;
                    a = i4;
                } else {
                    switch (i5) {
                        case 922:
                            c3899c.m19457a(true);
                            a = i4 + 1;
                            i2 = true;
                            break;
                        default:
                            throw C3900f.m19459a();
                    }
                }
            }
            c3899c.m19458a(Arrays.copyOf(iArr3, i3));
            return a;
        } else if (iArr[a] != 922) {
            return a;
        } else {
            c3899c.m19457a(true);
            return a + 1;
        }
    }

    private static int m19369a(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 >= 900) {
                switch (i5) {
                    case 900:
                        i5 = i3 + 1;
                        iArr2[i3] = 900;
                        i3 = i5;
                        i = i4;
                        break;
                    case 901:
                    case 902:
                    case 922:
                    case 923:
                    case 924:
                    case 928:
                        i = i4 - 1;
                        i2 = 1;
                        break;
                    case 913:
                        iArr2[i3] = 913;
                        i = i4 + 1;
                        iArr3[i3] = iArr[i4];
                        i3++;
                        break;
                    default:
                        i = i4;
                        break;
                }
            }
            iArr2[i3] = i5 / 30;
            iArr2[i3 + 1] = i5 % 30;
            i3 += 2;
            i = i4;
        }
        C3888e.m19372a(iArr2, iArr3, i3, stringBuilder);
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m19372a(int[] r8, int[] r9, int r10, java.lang.StringBuilder r11) {
        /*
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        r1 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        r0 = 0;
        r3 = r0;
    L_0x0006:
        if (r3 < r10) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r4 = r8[r3];
        r0 = 0;
        r5 = com.google.zxing.p299f.p300a.C3888e.m19373a();
        r6 = r2.ordinal();
        r5 = r5[r6];
        switch(r5) {
            case 1: goto L_0x0022;
            case 2: goto L_0x005b;
            case 3: goto L_0x0097;
            case 4: goto L_0x00e0;
            case 5: goto L_0x0106;
            case 6: goto L_0x0121;
            default: goto L_0x0019;
        };
    L_0x0019:
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        r11.append(r0);
    L_0x001e:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0006;
    L_0x0022:
        r5 = 26;
        if (r4 >= r5) goto L_0x002a;
    L_0x0026:
        r0 = r4 + 65;
        r0 = (char) r0;
        goto L_0x0019;
    L_0x002a:
        r5 = 26;
        if (r4 != r5) goto L_0x0031;
    L_0x002e:
        r0 = 32;
        goto L_0x0019;
    L_0x0031:
        r5 = 27;
        if (r4 != r5) goto L_0x0038;
    L_0x0035:
        r2 = com.google.zxing.p299f.p300a.C3889f.LOWER;
        goto L_0x0019;
    L_0x0038:
        r5 = 28;
        if (r4 != r5) goto L_0x003f;
    L_0x003c:
        r2 = com.google.zxing.p299f.p300a.C3889f.MIXED;
        goto L_0x0019;
    L_0x003f:
        r5 = 29;
        if (r4 != r5) goto L_0x0049;
    L_0x0043:
        r1 = com.google.zxing.p299f.p300a.C3889f.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0019;
    L_0x0049:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x0054;
    L_0x004d:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0019;
    L_0x0054:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0019;
    L_0x0058:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x005b:
        r5 = 26;
        if (r4 >= r5) goto L_0x0063;
    L_0x005f:
        r0 = r4 + 97;
        r0 = (char) r0;
        goto L_0x0019;
    L_0x0063:
        r5 = 26;
        if (r4 != r5) goto L_0x006a;
    L_0x0067:
        r0 = 32;
        goto L_0x0019;
    L_0x006a:
        r5 = 27;
        if (r4 != r5) goto L_0x0074;
    L_0x006e:
        r1 = com.google.zxing.p299f.p300a.C3889f.ALPHA_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0019;
    L_0x0074:
        r5 = 28;
        if (r4 != r5) goto L_0x007b;
    L_0x0078:
        r2 = com.google.zxing.p299f.p300a.C3889f.MIXED;
        goto L_0x0019;
    L_0x007b:
        r5 = 29;
        if (r4 != r5) goto L_0x0085;
    L_0x007f:
        r1 = com.google.zxing.p299f.p300a.C3889f.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0019;
    L_0x0085:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x0090;
    L_0x0089:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0019;
    L_0x0090:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0019;
    L_0x0094:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x0097:
        r5 = 25;
        if (r4 >= r5) goto L_0x00a1;
    L_0x009b:
        r0 = f15009b;
        r0 = r0[r4];
        goto L_0x0019;
    L_0x00a1:
        r5 = 25;
        if (r4 != r5) goto L_0x00a9;
    L_0x00a5:
        r2 = com.google.zxing.p299f.p300a.C3889f.PUNCT;
        goto L_0x0019;
    L_0x00a9:
        r5 = 26;
        if (r4 != r5) goto L_0x00b1;
    L_0x00ad:
        r0 = 32;
        goto L_0x0019;
    L_0x00b1:
        r5 = 27;
        if (r4 != r5) goto L_0x00b9;
    L_0x00b5:
        r2 = com.google.zxing.p299f.p300a.C3889f.LOWER;
        goto L_0x0019;
    L_0x00b9:
        r5 = 28;
        if (r4 != r5) goto L_0x00c1;
    L_0x00bd:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x00c1:
        r5 = 29;
        if (r4 != r5) goto L_0x00cc;
    L_0x00c5:
        r1 = com.google.zxing.p299f.p300a.C3889f.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0019;
    L_0x00cc:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x00d8;
    L_0x00d0:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0019;
    L_0x00d8:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0019;
    L_0x00dc:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x00e0:
        r5 = 29;
        if (r4 >= r5) goto L_0x00ea;
    L_0x00e4:
        r0 = f15008a;
        r0 = r0[r4];
        goto L_0x0019;
    L_0x00ea:
        r5 = 29;
        if (r4 != r5) goto L_0x00f2;
    L_0x00ee:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x00f2:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x00fe;
    L_0x00f6:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0019;
    L_0x00fe:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0019;
    L_0x0102:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x0106:
        r2 = 26;
        if (r4 >= r2) goto L_0x0110;
    L_0x010a:
        r0 = r4 + 65;
        r0 = (char) r0;
        r2 = r1;
        goto L_0x0019;
    L_0x0110:
        r2 = 26;
        if (r4 != r2) goto L_0x0119;
    L_0x0114:
        r0 = 32;
        r2 = r1;
        goto L_0x0019;
    L_0x0119:
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r2) goto L_0x0149;
    L_0x011d:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x0121:
        r2 = 29;
        if (r4 >= r2) goto L_0x012c;
    L_0x0125:
        r0 = f15008a;
        r0 = r0[r4];
        r2 = r1;
        goto L_0x0019;
    L_0x012c:
        r2 = 29;
        if (r4 != r2) goto L_0x0134;
    L_0x0130:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x0134:
        r2 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r2) goto L_0x0141;
    L_0x0138:
        r2 = r9[r3];
        r2 = (char) r2;
        r11.append(r2);
        r2 = r1;
        goto L_0x0019;
    L_0x0141:
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r2) goto L_0x0149;
    L_0x0145:
        r2 = com.google.zxing.p299f.p300a.C3889f.ALPHA;
        goto L_0x0019;
    L_0x0149:
        r2 = r1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.e.a(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int m19367a(int i, int[] iArr, int i2, StringBuilder stringBuilder) {
        int i3;
        long j;
        int i4;
        int i5;
        if (i == 901) {
            i3 = 0;
            j = 0;
            char[] cArr = new char[6];
            int[] iArr2 = new int[6];
            Object obj = null;
            i4 = i2 + 1;
            int i6 = iArr[i2];
            int i7 = i4;
            while (i7 < iArr[0] && r1 == null) {
                i4 = i3 + 1;
                iArr2[i3] = i6;
                j = (j * 900) + ((long) i6);
                int i8 = i7 + 1;
                i6 = iArr[i7];
                if (i6 == 900 || i6 == 901 || i6 == 902 || i6 == 924 || i6 == 928 || i6 == 923 || i6 == 922) {
                    obj = 1;
                    i7 = i8 - 1;
                    i3 = i4;
                } else if (i4 % 5 != 0 || i4 <= 0) {
                    i3 = i4;
                    i7 = i8;
                } else {
                    i3 = 0;
                    while (i3 < 6) {
                        cArr[5 - i3] = (char) ((int) (j % 256));
                        i3++;
                        j >>= 8;
                    }
                    stringBuilder.append(cArr);
                    i3 = 0;
                    i7 = i8;
                }
            }
            if (i7 == iArr[0] && i6 < 900) {
                i5 = i3 + 1;
                iArr2[i3] = i6;
                i3 = i5;
            }
            for (i6 = 0; i6 < i3; i6++) {
                stringBuilder.append((char) iArr2[i6]);
            }
            return i7;
        } else if (i != 924) {
            return i2;
        } else {
            i5 = 0;
            j = 0;
            Object obj2 = null;
            while (i2 < iArr[0] && r0 == null) {
                i3 = i2 + 1;
                i4 = iArr[i2];
                if (i4 < 900) {
                    i5++;
                    j = (j * 900) + ((long) i4);
                    i2 = i3;
                } else if (i4 == 900 || i4 == 901 || i4 == 902 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                    i2 = i3 - 1;
                    obj2 = 1;
                } else {
                    i2 = i3;
                }
                if (i5 % 5 == 0 && i5 > 0) {
                    char[] cArr2 = new char[6];
                    for (i5 = 0; i5 < 6; i5++) {
                        cArr2[5 - i5] = (char) ((int) (255 & j));
                        j >>= 8;
                    }
                    stringBuilder.append(cArr2);
                    i5 = 0;
                }
            }
            return i2;
        }
    }

    private static int m19374b(int[] iArr, int i, StringBuilder stringBuilder) throws C3900f {
        int[] iArr2 = new int[15];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == iArr[0]) {
                i2 = 1;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
                i = i4;
            } else if (i5 == 900 || i5 == 901 || i5 == 924 || i5 == 928 || i5 == 923 || i5 == 922) {
                i = i4 - 1;
                i2 = 1;
            } else {
                i = i4;
            }
            if (i3 % 15 == 0 || i5 == 902 || r0 != 0) {
                stringBuilder.append(C3888e.m19371a(iArr2, i3));
                i3 = 0;
            }
        }
        return i;
    }

    private static String m19371a(int[] iArr, int i) throws C3900f {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(f15010c[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw C3900f.m19459a();
    }
}
