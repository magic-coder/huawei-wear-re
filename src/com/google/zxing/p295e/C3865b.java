package com.google.zxing.p295e;

import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3712a;

/* compiled from: Code128Reader */
public final class C3865b extends C3856k {
    static final int[][] f14923a = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int[] m19247a(C3712a c3712a) throws C3932i {
        int a = c3712a.m18676a();
        int c = c3712a.m18682c(0);
        Object obj = new int[6];
        int length = obj.length;
        int i = c;
        int i2 = 0;
        int i3 = c;
        int i4 = 0;
        while (i < a) {
            int i5;
            int i6;
            if ((c3712a.m18678a(i) ^ i2) != 0) {
                obj[i4] = obj[i4] + 1;
                i5 = i2;
                i6 = i4;
            } else {
                if (i4 == length - 1) {
                    int i7 = 64;
                    c = -1;
                    i6 = 103;
                    while (i6 <= 105) {
                        i5 = C3856k.m19182a((int[]) obj, f14923a[i6], 179);
                        if (i5 < i7) {
                            c = i6;
                        } else {
                            i5 = i7;
                        }
                        i6++;
                        i7 = i5;
                    }
                    if (c < 0 || !c3712a.m18679a(Math.max(0, i3 - ((i - i3) / 2)), i3, false)) {
                        c = (obj[0] + obj[1]) + i3;
                        System.arraycopy(obj, 2, obj, 0, length - 2);
                        obj[length - 2] = null;
                        obj[length - 1] = null;
                        i6 = i4 - 1;
                    } else {
                        return new int[]{i3, i, c};
                    }
                }
                i6 = i4 + 1;
                c = i3;
                obj[i6] = 1;
                if (i2 != 0) {
                    i5 = false;
                } else {
                    i5 = 1;
                }
                i3 = c;
            }
            i++;
            i2 = i5;
            i4 = i6;
        }
        throw C3932i.m19565a();
    }

    private static int m19246a(C3712a c3712a, int[] iArr, int i) throws C3932i {
        C3856k.m19183a(c3712a, i, iArr);
        int i2 = 64;
        int i3 = -1;
        for (int i4 = 0; i4 < f14923a.length; i4++) {
            int a = C3856k.m19182a(iArr, f14923a[i4], 179);
            if (a < i2) {
                i3 = i4;
                i2 = a;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C3932i.m19565a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.C3934m mo4321a(int r23, com.google.zxing.p278b.C3712a r24, java.util.Map<com.google.zxing.C3880e, ?> r25) throws com.google.zxing.C3932i, com.google.zxing.C3900f, com.google.zxing.C3832d {
        /*
        r22 = this;
        if (r25 == 0) goto L_0x002f;
    L_0x0002:
        r2 = com.google.zxing.C3880e.ASSUME_GS1;
        r0 = r25;
        r2 = r0.containsKey(r2);
        if (r2 == 0) goto L_0x002f;
    L_0x000c:
        r2 = 1;
    L_0x000d:
        r15 = com.google.zxing.p295e.C3865b.m19247a(r24);
        r3 = 2;
        r5 = r15[r3];
        r16 = new java.util.ArrayList;
        r3 = 20;
        r0 = r16;
        r0.<init>(r3);
        r3 = (byte) r5;
        r3 = java.lang.Byte.valueOf(r3);
        r0 = r16;
        r0.add(r3);
        switch(r5) {
            case 103: goto L_0x0031;
            case 104: goto L_0x007e;
            case 105: goto L_0x0081;
            default: goto L_0x002a;
        };
    L_0x002a:
        r2 = com.google.zxing.C3900f.m19459a();
        throw r2;
    L_0x002f:
        r2 = 0;
        goto L_0x000d;
    L_0x0031:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0033:
        r9 = 0;
        r8 = 0;
        r17 = new java.lang.StringBuilder;
        r4 = 20;
        r0 = r17;
        r0.<init>(r4);
        r4 = 0;
        r11 = r15[r4];
        r4 = 1;
        r10 = r15[r4];
        r4 = 6;
        r0 = new int[r4];
        r18 = r0;
        r12 = 0;
        r7 = 0;
        r4 = 0;
        r6 = 1;
        r14 = r8;
        r8 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r9;
        r9 = r11;
        r11 = r10;
        r21 = r7;
        r7 = r12;
        r12 = r21;
    L_0x0059:
        if (r5 == 0) goto L_0x0084;
    L_0x005b:
        r2 = r11 - r9;
        r0 = r24;
        r5 = r0.m18684d(r11);
        r10 = r24.m18676a();
        r11 = r5 - r9;
        r11 = r11 / 2;
        r11 = r11 + r5;
        r10 = java.lang.Math.min(r10, r11);
        r11 = 0;
        r0 = r24;
        r5 = r0.m18679a(r5, r10, r11);
        if (r5 != 0) goto L_0x0224;
    L_0x0079:
        r2 = com.google.zxing.C3932i.m19565a();
        throw r2;
    L_0x007e:
        r3 = 100;
        goto L_0x0033;
    L_0x0081:
        r3 = 99;
        goto L_0x0033;
    L_0x0084:
        r7 = 0;
        r0 = r24;
        r1 = r18;
        r13 = com.google.zxing.p295e.C3865b.m19246a(r0, r1, r11);
        r9 = (byte) r13;
        r9 = java.lang.Byte.valueOf(r9);
        r0 = r16;
        r0.add(r9);
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x009c;
    L_0x009b:
        r6 = 1;
    L_0x009c:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x00a5;
    L_0x00a0:
        r3 = r3 + 1;
        r9 = r3 * r13;
        r4 = r4 + r9;
    L_0x00a5:
        r0 = r18;
        r0 = r0.length;
        r19 = r0;
        r9 = 0;
        r10 = r11;
    L_0x00ac:
        r0 = r19;
        if (r9 < r0) goto L_0x00ce;
    L_0x00b0:
        switch(r13) {
            case 103: goto L_0x00d5;
            case 104: goto L_0x00d5;
            case 105: goto L_0x00d5;
            default: goto L_0x00b3;
        };
    L_0x00b3:
        switch(r8) {
            case 99: goto L_0x01bd;
            case 100: goto L_0x0152;
            case 101: goto L_0x00da;
            default: goto L_0x00b6;
        };
    L_0x00b6:
        r21 = r5;
        r5 = r8;
        r8 = r21;
    L_0x00bb:
        if (r14 == 0) goto L_0x02a6;
    L_0x00bd:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 != r9) goto L_0x0220;
    L_0x00c1:
        r5 = 100;
    L_0x00c3:
        r9 = r11;
        r14 = r7;
        r11 = r10;
        r7 = r12;
        r12 = r13;
        r21 = r8;
        r8 = r5;
        r5 = r21;
        goto L_0x0059;
    L_0x00ce:
        r20 = r18[r9];
        r10 = r10 + r20;
        r9 = r9 + 1;
        goto L_0x00ac;
    L_0x00d5:
        r2 = com.google.zxing.C3900f.m19459a();
        throw r2;
    L_0x00da:
        r9 = 64;
        if (r13 >= r9) goto L_0x00ec;
    L_0x00de:
        r9 = r13 + 32;
        r9 = (char) r9;
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x00ec:
        r9 = 96;
        if (r13 >= r9) goto L_0x00fe;
    L_0x00f0:
        r9 = r13 + -64;
        r9 = (char) r9;
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x00fe:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x0103;
    L_0x0102:
        r6 = 0;
    L_0x0103:
        switch(r13) {
            case 96: goto L_0x012e;
            case 97: goto L_0x012e;
            case 98: goto L_0x0134;
            case 99: goto L_0x0147;
            case 100: goto L_0x013e;
            case 101: goto L_0x012e;
            case 102: goto L_0x010c;
            case 103: goto L_0x0106;
            case 104: goto L_0x0106;
            case 105: goto L_0x0106;
            case 106: goto L_0x0150;
            default: goto L_0x0106;
        };
    L_0x0106:
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x010c:
        if (r2 == 0) goto L_0x00b6;
    L_0x010e:
        r9 = r17.length();
        if (r9 != 0) goto L_0x0121;
    L_0x0114:
        r9 = "]C1";
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0121:
        r9 = 29;
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x012e:
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0134:
        r7 = 1;
        r8 = 100;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x013e:
        r8 = 100;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0147:
        r8 = 99;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0150:
        r5 = 1;
        goto L_0x0106;
    L_0x0152:
        r9 = 96;
        if (r13 >= r9) goto L_0x0165;
    L_0x0156:
        r9 = r13 + 32;
        r9 = (char) r9;
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0165:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x016a;
    L_0x0169:
        r6 = 0;
    L_0x016a:
        switch(r13) {
            case 96: goto L_0x0198;
            case 97: goto L_0x0198;
            case 98: goto L_0x019f;
            case 99: goto L_0x01b2;
            case 100: goto L_0x0198;
            case 101: goto L_0x01a9;
            case 102: goto L_0x0174;
            case 103: goto L_0x016d;
            case 104: goto L_0x016d;
            case 105: goto L_0x016d;
            case 106: goto L_0x01bb;
            default: goto L_0x016d;
        };
    L_0x016d:
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0174:
        if (r2 == 0) goto L_0x00b6;
    L_0x0176:
        r9 = r17.length();
        if (r9 != 0) goto L_0x018a;
    L_0x017c:
        r9 = "]C1";
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x018a:
        r9 = 29;
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0198:
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x019f:
        r7 = 1;
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x01a9:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x01b2:
        r8 = 99;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x01bb:
        r5 = 1;
        goto L_0x016d;
    L_0x01bd:
        r9 = 100;
        if (r13 >= r9) goto L_0x01d8;
    L_0x01c1:
        r9 = 10;
        if (r13 >= r9) goto L_0x01cc;
    L_0x01c5:
        r9 = 48;
        r0 = r17;
        r0.append(r9);
    L_0x01cc:
        r0 = r17;
        r0.append(r13);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x01d8:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r13 == r9) goto L_0x01dd;
    L_0x01dc:
        r6 = 0;
    L_0x01dd:
        switch(r13) {
            case 100: goto L_0x01e2;
            case 101: goto L_0x020f;
            case 102: goto L_0x01eb;
            case 103: goto L_0x01e0;
            case 104: goto L_0x01e0;
            case 105: goto L_0x01e0;
            case 106: goto L_0x0218;
            default: goto L_0x01e0;
        };
    L_0x01e0:
        goto L_0x00b6;
    L_0x01e2:
        r8 = 100;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x01eb:
        if (r2 == 0) goto L_0x00b6;
    L_0x01ed:
        r9 = r17.length();
        if (r9 != 0) goto L_0x0201;
    L_0x01f3:
        r9 = "]C1";
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0201:
        r9 = 29;
        r0 = r17;
        r0.append(r9);
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x020f:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0218:
        r5 = 1;
        r21 = r5;
        r5 = r8;
        r8 = r21;
        goto L_0x00bb;
    L_0x0220:
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x00c3;
    L_0x0224:
        r3 = r3 * r7;
        r3 = r4 - r3;
        r3 = r3 % 103;
        if (r3 == r7) goto L_0x0230;
    L_0x022b:
        r2 = com.google.zxing.C3832d.m19108a();
        throw r2;
    L_0x0230:
        r3 = r17.length();
        if (r3 != 0) goto L_0x023b;
    L_0x0236:
        r2 = com.google.zxing.C3932i.m19565a();
        throw r2;
    L_0x023b:
        if (r3 <= 0) goto L_0x024a;
    L_0x023d:
        if (r6 == 0) goto L_0x024a;
    L_0x023f:
        r4 = 99;
        if (r8 != r4) goto L_0x028c;
    L_0x0243:
        r4 = r3 + -2;
        r0 = r17;
        r0.delete(r4, r3);
    L_0x024a:
        r3 = 1;
        r3 = r15[r3];
        r4 = 0;
        r4 = r15[r4];
        r3 = r3 + r4;
        r3 = (float) r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r3 / r4;
        r3 = (float) r9;
        r2 = (float) r2;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 / r5;
        r5 = r3 + r2;
        r6 = r16.size();
        r7 = new byte[r6];
        r2 = 0;
        r3 = r2;
    L_0x0265:
        if (r3 < r6) goto L_0x0294;
    L_0x0267:
        r2 = new com.google.zxing.m;
        r3 = r17.toString();
        r6 = 2;
        r6 = new com.google.zxing.C3922o[r6];
        r8 = 0;
        r9 = new com.google.zxing.o;
        r0 = r23;
        r10 = (float) r0;
        r9.<init>(r4, r10);
        r6[r8] = r9;
        r4 = 1;
        r8 = new com.google.zxing.o;
        r0 = r23;
        r9 = (float) r0;
        r8.<init>(r5, r9);
        r6[r4] = r8;
        r4 = com.google.zxing.C3709a.CODE_128;
        r2.<init>(r3, r7, r6, r4);
        return r2;
    L_0x028c:
        r4 = r3 + -1;
        r0 = r17;
        r0.delete(r4, r3);
        goto L_0x024a;
    L_0x0294:
        r0 = r16;
        r2 = r0.get(r3);
        r2 = (java.lang.Byte) r2;
        r2 = r2.byteValue();
        r7[r3] = r2;
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0265;
    L_0x02a6:
        r9 = r11;
        r14 = r7;
        r11 = r10;
        r7 = r12;
        r12 = r13;
        r21 = r8;
        r8 = r5;
        r5 = r21;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.b.a(int, com.google.zxing.b.a, java.util.Map):com.google.zxing.m");
    }
}
