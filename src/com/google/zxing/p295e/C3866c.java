package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.datatype.SportType;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.util.Arrays;
import java.util.Map;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: Code39Reader */
public final class C3866c extends C3856k {
    static final int[] f14924a = new int[]{52, 289, 97, 352, 49, HttpStatus.SC_NOT_MODIFIED, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, SportType.SPORT_TYPE_BIKE, 67, 322, 19, 274, 82, 7, SportType.SPORT_TYPE_SWIM, 70, 22, 385, 193, 448, 145, HttpStatus.SC_BAD_REQUEST, AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, 133, 388, 196, 148, SyslogAppender.LOG_LOCAL5, 162, 138, 42};
    private static final char[] f14925b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
    private static final int f14926c = f14924a[39];
    private final boolean f14927d;
    private final boolean f14928e;
    private final StringBuilder f14929f;
    private final int[] f14930g;

    public C3866c() {
        this(false);
    }

    public C3866c(boolean z) {
        this(z, false);
    }

    public C3866c(boolean z, boolean z2) {
        this.f14927d = z;
        this.f14928e = z2;
        this.f14929f = new StringBuilder(20);
        this.f14930g = new int[9];
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f {
        int a;
        int i2;
        int[] iArr = this.f14930g;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.f14929f;
        charSequence.setLength(0);
        int c = c3712a.m18682c(C3866c.m19252a(c3712a, iArr)[1]);
        int a2 = c3712a.m18676a();
        while (true) {
            C3856k.m19183a(c3712a, c, iArr);
            a = C3866c.m19250a(iArr);
            if (a < 0) {
                throw C3932i.m19565a();
            }
            char a3 = C3866c.m19249a(a);
            charSequence.append(a3);
            i2 = c;
            for (int i3 : iArr) {
                i2 += i3;
            }
            a = c3712a.m18682c(i2);
            if (a3 == '*') {
                break;
            }
            c = a;
        }
        charSequence.setLength(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        i2 = (a - c) - i4;
        if (a == a2 || (i2 >> 1) >= i4) {
            if (this.f14927d) {
                int length = charSequence.length() - 1;
                i2 = 0;
                for (a = 0; a < length; a++) {
                    i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(this.f14929f.charAt(a));
                }
                if (charSequence.charAt(length) != f14925b[i2 % 43]) {
                    throw C3832d.m19108a();
                }
                charSequence.setLength(length);
            }
            if (charSequence.length() == 0) {
                throw C3932i.m19565a();
            }
            String a4;
            if (this.f14928e) {
                a4 = C3866c.m19251a(charSequence);
            } else {
                a4 = charSequence.toString();
            }
            float f = ((float) c) + (((float) i4) / 2.0f);
            return new C3934m(a4, null, new C3922o[]{new C3922o(((float) (r6[1] + r6[0])) / 2.0f, (float) i), new C3922o(f, (float) i)}, C3709a.CODE_39);
        }
        throw C3932i.m19565a();
    }

    private static int[] m19252a(C3712a c3712a, int[] iArr) throws C3932i {
        int a = c3712a.m18676a();
        int c = c3712a.m18682c(0);
        int length = iArr.length;
        int i = c;
        int i2 = 0;
        int i3 = 0;
        while (i < a) {
            if ((c3712a.m18678a(i) ^ i2) != 0) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (C3866c.m19250a(iArr) == f14926c && c3712a.m18679a(Math.max(0, c - ((i - c) >> 1)), c, false)) {
                    return new int[]{c, i};
                } else {
                    c += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                if (i2 != 0) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
            }
            i++;
        }
        throw C3932i.m19565a();
    }

    private static int m19250a(int[] iArr) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3;
            int i4 = Integer.MAX_VALUE;
            for (int i5 : iArr) {
                if (i5 < i4 && i5 > r0) {
                    i4 = i5;
                }
            }
            i2 = 0;
            int i52 = 0;
            i = 0;
            for (i3 = 0; i3 < length; i3++) {
                int i6 = iArr[i3];
                if (i6 > i4) {
                    i2 |= 1 << ((length - 1) - i3);
                    i++;
                    i52 += i6;
                }
            }
            if (i == 3) {
                break;
            } else if (i <= 3) {
                return -1;
            } else {
                i2 = i4;
            }
        }
        int i7 = i;
        for (i = 0; i < length && i7 > 0; i++) {
            i3 = iArr[i];
            if (i3 > i4) {
                i7--;
                if ((i3 << 1) >= i52) {
                    return -1;
                }
            }
        }
        return i2;
    }

    private static char m19249a(int i) throws C3932i {
        for (int i2 = 0; i2 < f14924a.length; i2++) {
            if (f14924a[i2] == i) {
                return f14925b[i2];
            }
        }
        throw C3932i.m19565a();
    }

    private static String m19251a(CharSequence charSequence) throws C3900f {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case '$':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw C3900f.m19459a();
                        break;
                    case '%':
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
                    case '+':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw C3900f.m19459a();
                    case '/':
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
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            } else {
                stringBuilder.append(charAt);
                i2 = i;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }
}
