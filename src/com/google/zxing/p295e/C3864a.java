package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3880e;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import java.util.Arrays;
import java.util.Map;

/* compiled from: CodaBarReader */
public final class C3864a extends C3856k {
    static final char[] f14917a = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] f14918b = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] f14919c = new char[]{'A', 'B', 'C', 'D'};
    private final StringBuilder f14920d = new StringBuilder(20);
    private int[] f14921e = new int[80];
    private int f14922f = 0;

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i {
        Arrays.fill(this.f14921e, 0);
        m19239a(c3712a);
        int b = m19241b();
        this.f14920d.setLength(0);
        int i2 = b;
        do {
            int c = m19243c(i2);
            if (c != -1) {
                this.f14920d.append((char) c);
                i2 += 8;
                if (this.f14920d.length() > 1 && C3864a.m19240a(f14919c, f14917a[c])) {
                    break;
                }
            } else {
                throw C3932i.m19565a();
            }
        } while (i2 < this.f14922f);
        int i3 = this.f14921e[i2 - 1];
        int i4 = 0;
        for (c = -8; c < -1; c++) {
            i4 += this.f14921e[i2 + c];
        }
        if (i2 >= this.f14922f || i3 >= i4 / 2) {
            m19245a(b);
            for (c = 0; c < this.f14920d.length(); c++) {
                this.f14920d.setCharAt(c, f14917a[this.f14920d.charAt(c)]);
            }
            if (C3864a.m19240a(f14919c, this.f14920d.charAt(0))) {
                if (!C3864a.m19240a(f14919c, this.f14920d.charAt(this.f14920d.length() - 1))) {
                    throw C3932i.m19565a();
                } else if (this.f14920d.length() <= 3) {
                    throw C3932i.m19565a();
                } else {
                    if (map == null || !map.containsKey(C3880e.RETURN_CODABAR_START_END)) {
                        this.f14920d.deleteCharAt(this.f14920d.length() - 1);
                        this.f14920d.deleteCharAt(0);
                    }
                    i4 = 0;
                    c = 0;
                    while (i4 < b) {
                        i3 = this.f14921e[i4] + c;
                        i4++;
                        c = i3;
                    }
                    float f = (float) c;
                    while (b < i2 - 1) {
                        c += this.f14921e[b];
                        b++;
                    }
                    float f2 = (float) c;
                    return new C3934m(this.f14920d.toString(), null, new C3922o[]{new C3922o(f, (float) i), new C3922o(f2, (float) i)}, C3709a.CODABAR);
                }
            }
            throw C3932i.m19565a();
        }
        throw C3932i.m19565a();
    }

    void m19245a(int i) throws C3932i {
        int i2 = 0;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int length = this.f14920d.length() - 1;
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = f14918b[this.f14920d.charAt(i3)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.f14921e[i4 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i3 >= length) {
                break;
            }
            i4 += 8;
            i3++;
        }
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        for (i3 = 0; i3 < 2; i3++) {
            iArr4[i3] = 0;
            iArr4[i3 + 2] = (((iArr[i3] << 8) / iArr2[i3]) + ((iArr[i3 + 2] << 8) / iArr2[i3 + 2])) >> 1;
            iArr3[i3] = iArr4[i3 + 2];
            iArr3[i3 + 2] = ((iArr[i3 + 2] * 512) + 384) / iArr2[i3 + 2];
        }
        loop3:
        while (true) {
            i4 = f14918b[this.f14920d.charAt(i2)];
            i3 = 6;
            while (i3 >= 0) {
                int i8 = (i3 & 1) + ((i4 & 1) * 2);
                int i9 = this.f14921e[i + i3] << 8;
                if (i9 >= iArr4[i8] && i9 <= iArr3[i8]) {
                    i4 >>= 1;
                    i3--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw C3932i.m19565a();
    }

    private void m19239a(C3712a c3712a) throws C3932i {
        this.f14922f = 0;
        int d = c3712a.m18684d(0);
        int a = c3712a.m18676a();
        if (d >= a) {
            throw C3932i.m19565a();
        }
        int i = 1;
        d = 0;
        for (int i2 = d; i2 < a; i2++) {
            if ((c3712a.m18678a(i2) ^ i) != 0) {
                d++;
            } else {
                m19242b(d);
                i = i != 0 ? 0 : 1;
                d = 1;
            }
        }
        m19242b(d);
    }

    private void m19242b(int i) {
        this.f14921e[this.f14922f] = i;
        this.f14922f++;
        if (this.f14922f >= this.f14921e.length) {
            Object obj = new int[(this.f14922f * 2)];
            System.arraycopy(this.f14921e, 0, obj, 0, this.f14922f);
            this.f14921e = obj;
        }
    }

    private int m19241b() throws C3932i {
        int i = 1;
        while (i < this.f14922f) {
            int c = m19243c(i);
            if (c != -1 && C3864a.m19240a(f14919c, f14917a[c])) {
                int i2 = 0;
                for (c = i; c < i + 7; c++) {
                    i2 += this.f14921e[c];
                }
                if (i == 1 || this.f14921e[i - 1] >= i2 / 2) {
                    return i;
                }
            }
            i += 2;
        }
        throw C3932i.m19565a();
    }

    static boolean m19240a(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private int m19243c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = i + 7;
        if (i3 >= this.f14922f) {
            return -1;
        }
        int[] iArr = this.f14921e;
        int i4 = i;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i5 = (i5 + i6) / 2;
        i4 = i + 1;
        i6 = 0;
        while (i4 < i3) {
            i7 = iArr[i4];
            if (i7 < i2) {
                i2 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i6 = (i2 + i6) / 2;
        i4 = 0;
        i2 = 0;
        i3 = 128;
        while (i4 < 7) {
            if ((i4 & 1) == 0) {
                i7 = i5;
            } else {
                i7 = i6;
            }
            i3 >>= 1;
            if (iArr[i + i4] > i7) {
                i7 = i2 | i3;
            } else {
                i7 = i2;
            }
            i4++;
            i2 = i7;
        }
        for (i7 = 0; i7 < f14918b.length; i7++) {
            if (f14918b[i7] == i2) {
                return i7;
            }
        }
        return -1;
    }
}
