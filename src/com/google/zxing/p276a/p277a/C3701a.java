package com.google.zxing.p276a.p277a;

import com.google.zxing.C3900f;
import com.google.zxing.p276a.C3704a;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p278b.p281b.C3713a;
import com.google.zxing.p278b.p281b.C3715c;
import com.google.zxing.p278b.p281b.C3716d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.unionpay.tsmservice.data.Constant;
import java.util.Arrays;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: Decoder */
public final class C3701a {
    private static final String[] f14361a = new String[]{"CTRL_PS", HwAccountConstants.BLANK, "A", "B", TypeParams.SEARCH_CODE, "D", "E", "F", "G", "H", "I", "J", TypeParams.SEARCH_KEYWORDS, "L", TypeParams.QUESTION_CHOOSE_MULTI, "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] f14362b = new String[]{"CTRL_PS", HwAccountConstants.BLANK, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, "r", "s", "t", "u", Constant.KEY_VERSION, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] f14363c = new String[]{"CTRL_PS", HwAccountConstants.BLANK, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", HwAccountConstants.SPLIIT_UNDERLINE, "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] f14364d = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", SNBConstant.FILTER, "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", LocationInfo.NA, "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f14365e = new String[]{"CTRL_PS", HwAccountConstants.BLANK, "0", "1", "2", "3", "4", "5", "6", "7", "8", CardStatusQueryResponse.DEV_STATUS_LOCK, ",", ".", "CTRL_UL", "CTRL_US"};
    private static /* synthetic */ int[] f14366g;
    private C3704a f14367f;

    static /* synthetic */ int[] m18634a() {
        int[] iArr = f14366g;
        if (iArr == null) {
            iArr = new int[C3702b.values().length];
            try {
                iArr[C3702b.BINARY.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C3702b.DIGIT.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C3702b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C3702b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C3702b.PUNCT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C3702b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            f14366g = iArr;
        }
        return iArr;
    }

    public C3720e m18636a(C3704a c3704a) throws C3900f {
        this.f14367f = c3704a;
        return new C3720e(null, C3701a.m18633a(m18635b(m18637a(c3704a.m18638d()))), null, null);
    }

    private static String m18633a(boolean[] zArr) {
        int length = zArr.length;
        C3702b c3702b = C3702b.UPPER;
        C3702b c3702b2 = C3702b.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        int i = 0;
        C3702b c3702b3 = c3702b2;
        while (i < length) {
            int a;
            if (c3702b3 == C3702b.BINARY) {
                if (length - i < 5) {
                    break;
                }
                a = C3701a.m18630a(zArr, i, 5);
                i += 5;
                if (a == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    a = C3701a.m18630a(zArr, i, 11) + 31;
                    i += 11;
                }
                int i2 = 0;
                while (i2 < a) {
                    if (length - i < 8) {
                        a = length;
                        break;
                    }
                    stringBuilder.append((char) C3701a.m18630a(zArr, i, 8));
                    i2++;
                    i += 8;
                }
                a = i;
                i = a;
                c3702b3 = c3702b;
            } else {
                a = c3702b3 == C3702b.DIGIT ? 4 : 5;
                if (length - i < a) {
                    break;
                }
                int a2 = C3701a.m18630a(zArr, i, a);
                a += i;
                String a3 = C3701a.m18632a(c3702b3, a2);
                if (a3.startsWith("CTRL_")) {
                    C3702b a4 = C3701a.m18631a(a3.charAt(5));
                    if (a3.charAt(6) == 'L') {
                        c3702b3 = a4;
                        c3702b = a4;
                        i = a;
                    } else {
                        c3702b3 = a4;
                        i = a;
                    }
                } else {
                    stringBuilder.append(a3);
                    i = a;
                    c3702b3 = c3702b;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static C3702b m18631a(char c) {
        switch (c) {
            case 'B':
                return C3702b.BINARY;
            case 'D':
                return C3702b.DIGIT;
            case 'L':
                return C3702b.LOWER;
            case 'M':
                return C3702b.MIXED;
            case 'P':
                return C3702b.PUNCT;
            default:
                return C3702b.UPPER;
        }
    }

    private static String m18632a(C3702b c3702b, int i) {
        switch (C3701a.m18634a()[c3702b.ordinal()]) {
            case 1:
                return f14361a[i];
            case 2:
                return f14362b[i];
            case 3:
                return f14363c[i];
            case 4:
                return f14365e[i];
            case 5:
                return f14364d[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private boolean[] m18635b(boolean[] zArr) throws C3900f {
        C3713a c3713a;
        int i = 8;
        if (this.f14367f.m18640a() <= 2) {
            i = 6;
            c3713a = C3713a.f14418c;
        } else if (this.f14367f.m18640a() <= 8) {
            c3713a = C3713a.f14422g;
        } else if (this.f14367f.m18640a() <= 22) {
            i = 10;
            c3713a = C3713a.f14417b;
        } else {
            i = 12;
            c3713a = C3713a.f14416a;
        }
        int b = this.f14367f.m18641b();
        int length = zArr.length / i;
        int i2 = length - b;
        int[] iArr = new int[length];
        int length2 = zArr.length % i;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = C3701a.m18630a(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new C3715c(c3713a).m18709a(iArr, i2);
            int i4 = (1 << i) - 1;
            int i5 = 0;
            for (i3 = 0; i3 < b; i3++) {
                length2 = iArr[i3];
                if (length2 == 0 || length2 == i4) {
                    throw C3900f.m19459a();
                }
                if (length2 == 1 || length2 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[((b * i) - i5)];
            i2 = 0;
            i3 = 0;
            while (i2 < b) {
                int i6 = iArr[i2];
                boolean z;
                if (i6 == 1 || i6 == i4 - 1) {
                    length2 = (i3 + i) - 1;
                    if (i6 > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Arrays.fill(zArr2, i3, length2, z);
                    i5 = (i - 1) + i3;
                } else {
                    length2 = i - 1;
                    while (length2 >= 0) {
                        length = i3 + 1;
                        if (((1 << length2) & i6) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zArr2[i3] = z;
                        length2--;
                        i3 = length;
                    }
                    i5 = i3;
                }
                i2++;
                i3 = i5;
            }
            return zArr2;
        } catch (C3716d e) {
            throw C3900f.m19459a();
        }
    }

    boolean[] m18637a(C3717b c3717b) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean c = this.f14367f.m18642c();
        int a = this.f14367f.m18640a();
        int i5 = c ? (a * 4) + 11 : (a * 4) + 14;
        int[] iArr = new int[i5];
        boolean[] zArr = new boolean[C3701a.m18629a(a, c)];
        if (c) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i5 / 2;
            i3 = ((i5 + 1) + ((((i5 / 2) - 1) / 15) * 2)) / 2;
            for (i = 0; i < i2; i++) {
                i4 = (i / 15) + i;
                iArr[(i2 - i) - 1] = (i3 - i4) - 1;
                iArr[i2 + i] = (i4 + i3) + 1;
            }
        }
        i4 = 0;
        for (int i6 = 0; i6 < a; i6++) {
            i = c ? ((a - i6) * 4) + 9 : ((a - i6) * 4) + 12;
            int i7 = i6 * 2;
            int i8 = (i5 - 1) - i7;
            for (i3 = 0; i3 < i; i3++) {
                int i9 = i3 * 2;
                for (i2 = 0; i2 < 2; i2++) {
                    zArr[(i4 + i9) + i2] = c3717b.m18712a(iArr[i7 + i2], iArr[i7 + i3]);
                    zArr[(((i * 2) + i4) + i9) + i2] = c3717b.m18712a(iArr[i7 + i3], iArr[i8 - i2]);
                    zArr[(((i * 4) + i4) + i9) + i2] = c3717b.m18712a(iArr[i8 - i2], iArr[i8 - i3]);
                    zArr[(((i * 6) + i4) + i9) + i2] = c3717b.m18712a(iArr[i8 - i3], iArr[i7 + i2]);
                }
            }
            i4 = (i * 8) + i4;
        }
        return zArr;
    }

    private static int m18630a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3++;
            }
        }
        return i3;
    }

    private static int m18629a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }
}
