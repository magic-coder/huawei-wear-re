package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code93Reader */
public final class C3867d extends C3856k {
    private static final char[] f14931a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    private static final int[] f14932b = new int[]{276, 328, SdkConstants.REQUEST_CAMERA_VIDEO, 322, 296, 292, 290, 336, 274, 266, HttpStatus.SC_FAILED_DEPENDENCY, HttpStatus.SC_METHOD_FAILURE, 418, HttpStatus.SC_NOT_FOUND, HttpStatus.SC_PAYMENT_REQUIRED, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, HttpStatus.SC_UNPROCESSABLE_ENTITY, HttpStatus.SC_NOT_ACCEPTABLE, HttpStatus.SC_GONE, 364, 358, 310, 314, HttpStatus.SC_MOVED_TEMPORARILY, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
    private static final int f14933c = f14932b[47];
    private final StringBuilder f14934d = new StringBuilder(20);
    private final int[] f14935e = new int[6];

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        int c = c3712a.m18682c(m19258a(c3712a)[1]);
        int a = c3712a.m18676a();
        int[] iArr = this.f14935e;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.f14934d;
        charSequence.setLength(0);
        while (true) {
            C3856k.m19183a(c3712a, c, iArr);
            int a2 = C3867d.m19255a(iArr);
            if (a2 < 0) {
                throw C3932i.m19565a();
            }
            char a3 = C3867d.m19254a(a2);
            charSequence.append(a3);
            int i2 = c;
            for (int i3 : iArr) {
                i2 += i3;
            }
            a2 = c3712a.m18682c(i2);
            if (a3 == '*') {
                break;
            }
            c = a2;
        }
        charSequence.deleteCharAt(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        if (a2 == a || !c3712a.m18678a(a2)) {
            throw C3932i.m19565a();
        } else if (charSequence.length() < 2) {
            throw C3932i.m19565a();
        } else {
            C3867d.m19259b(charSequence);
            charSequence.setLength(charSequence.length() - 2);
            float f = ((float) c) + (((float) i4) / 2.0f);
            return new C3934m(C3867d.m19256a(charSequence), null, new C3922o[]{new C3922o(((float) (r4[1] + r4[0])) / 2.0f, (float) i), new C3922o(f, (float) i)}, C3709a.CODE_93);
        }
    }

    private int[] m19258a(C3712a c3712a) throws C3932i {
        int a = c3712a.m18676a();
        int c = c3712a.m18682c(0);
        Arrays.fill(this.f14935e, 0);
        int[] iArr = this.f14935e;
        int length = iArr.length;
        int i = 0;
        int i2 = c;
        c = 0;
        for (int i3 = c; i3 < a; i3++) {
            if ((c3712a.m18678a(i3) ^ i) != 0) {
                iArr[c] = iArr[c] + 1;
            } else {
                if (c != length - 1) {
                    c++;
                } else if (C3867d.m19255a(iArr) == f14933c) {
                    return new int[]{i2, i3};
                } else {
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    c--;
                }
                iArr[c] = 1;
                if (i != 0) {
                    i = 0;
                } else {
                    i = 1;
                }
            }
        }
        throw C3932i.m19565a();
    }

    private static int m19255a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4;
            int i5 = ((iArr[i3] << 8) * 9) / i2;
            int i6 = i5 >> 8;
            if ((i5 & 255) > 127) {
                i4 = i6 + 1;
            } else {
                i4 = i6;
            }
            if (i4 < 1 || i4 > 4) {
                return -1;
            }
            if ((i3 & 1) == 0) {
                i6 = 0;
                while (i6 < i4) {
                    i6++;
                    i = (i << 1) | 1;
                }
            } else {
                i <<= i4;
            }
        }
        return i;
    }

    private static char m19254a(int i) throws C3932i {
        for (int i2 = 0; i2 < f14932b.length; i2++) {
            if (f14932b[i2] == i) {
                return f14931a[i2];
            }
        }
        throw C3932i.m19565a();
    }

    private static String m19256a(CharSequence charSequence) throws C3900f {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt < 'a' || charAt > 'd') {
                stringBuilder.append(charAt);
                i2 = i;
            } else if (i >= length - 1) {
                throw C3900f.m19459a();
            } else {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw C3900f.m19459a();
                        break;
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 >= 'F' && charAt2 <= 'W') {
                                charAt = (char) (charAt2 - 11);
                                break;
                            }
                            throw C3900f.m19459a();
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw C3900f.m19459a();
                        }
                        break;
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw C3900f.m19459a();
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }

    private static void m19259b(CharSequence charSequence) throws C3832d {
        int length = charSequence.length();
        C3867d.m19257a(charSequence, length - 2, 20);
        C3867d.m19257a(charSequence, length - 1, 15);
    }

    private static void m19257a(CharSequence charSequence, int i, int i2) throws C3832d {
        int i3 = 1;
        int i4 = i - 1;
        int i5 = 0;
        while (i4 >= 0) {
            int indexOf = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3) + i5;
            i5 = i3 + 1;
            if (i5 > i2) {
                i5 = 1;
            }
            i4--;
            i3 = i5;
            i5 = indexOf;
        }
        if (charSequence.charAt(i) != f14931a[i5 % 47]) {
            throw C3832d.m19108a();
        }
    }
}
