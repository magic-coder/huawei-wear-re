package com.google.zxing.p278b;

import com.google.zxing.C3723b;
import com.google.zxing.C3824g;
import com.google.zxing.C3932i;
import java.lang.reflect.Array;

/* compiled from: HybridBinarizer */
public final class C3725j extends C3724h {
    private C3717b f14486a;

    public C3725j(C3824g c3824g) {
        super(c3824g);
    }

    public C3717b mo4307b() throws C3932i {
        if (this.f14486a != null) {
            return this.f14486a;
        }
        C3824g a = m18742a();
        int b = a.m19082b();
        int c = a.m19083c();
        if (b < 40 || c < 40) {
            this.f14486a = super.mo4307b();
        } else {
            byte[] a2 = a.mo4316a();
            int i = b >> 3;
            if ((b & 7) != 0) {
                i++;
            }
            int i2 = c >> 3;
            if ((c & 7) != 0) {
                i2++;
            }
            int[][] a3 = C3725j.m18754a(a2, i, i2, b, c);
            C3717b c3717b = new C3717b(b, c);
            C3725j.m18753a(a2, i, i2, b, c, a3, c3717b);
            this.f14486a = c3717b;
        }
        return this.f14486a;
    }

    public C3723b mo4306a(C3824g c3824g) {
        return new C3725j(c3824g);
    }

    private static void m18753a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, C3717b c3717b) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            for (int i8 = 0; i8 < i; i8++) {
                i6 = i8 << 3;
                int i9 = i3 - 8;
                if (i6 <= i9) {
                    i9 = i6;
                }
                int a = C3725j.m18751a(i8, 2, i - 3);
                int a2 = C3725j.m18751a(i5, 2, i2 - 3);
                int i10 = 0;
                for (i6 = -2; i6 <= 2; i6++) {
                    int[] iArr2 = iArr[a2 + i6];
                    i10 += iArr2[a + 2] + (((iArr2[a - 2] + iArr2[a - 1]) + iArr2[a]) + iArr2[a + 1]);
                }
                C3725j.m18752a(bArr, i9, i7, i10 / 25, i3, c3717b);
            }
        }
    }

    private static int m18751a(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    private static void m18752a(byte[] bArr, int i, int i2, int i3, int i4, C3717b c3717b) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    c3717b.m18714b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] m18754a(byte[] bArr, int i, int i2, int i3, int i4) {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i2, i});
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << 3;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            int i8 = 0;
            while (i8 < i) {
                int i9 = i8 << 3;
                i6 = i3 - 8;
                if (i9 <= i6) {
                    i6 = i9;
                }
                int i10 = 0;
                int i11 = 255;
                i9 = 0;
                int i12 = 0;
                int i13 = (i7 * i3) + i6;
                while (i12 < 8) {
                    int i14 = 0;
                    while (i14 < 8) {
                        i6 = bArr[i13 + i14] & 255;
                        int i15 = i10 + i6;
                        if (i6 < i11) {
                            i10 = i6;
                        } else {
                            i10 = i11;
                        }
                        if (i6 <= i9) {
                            i6 = i9;
                        }
                        i14++;
                        i11 = i10;
                        i9 = i6;
                        i10 = i15;
                    }
                    if (i9 - i11 > 24) {
                        i6 = i13 + i3;
                        i13 = i12 + 1;
                        i12 = i10;
                        while (i13 < 8) {
                            i10 = i12;
                            for (i12 = 0; i12 < 8; i12++) {
                                i10 += bArr[i6 + i12] & 255;
                            }
                            i13++;
                            i6 += i3;
                            i12 = i10;
                        }
                    } else {
                        i6 = i13;
                        i13 = i12;
                        i12 = i10;
                    }
                    i10 = i13 + 1;
                    i13 = i6 + i3;
                    int i16 = i10;
                    i10 = i12;
                    i12 = i16;
                }
                i6 = i10 >> 6;
                if (i9 - i11 <= 24) {
                    i9 = i11 >> 1;
                    if (i5 > 0 && i8 > 0) {
                        i6 = ((iArr[i5 - 1][i8] + (iArr[i5][i8 - 1] * 2)) + iArr[i5 - 1][i8 - 1]) >> 2;
                        if (i11 < i6) {
                        }
                    }
                    i6 = i9;
                }
                iArr[i5][i8] = i6;
                i8++;
            }
        }
        return iArr;
    }
}
