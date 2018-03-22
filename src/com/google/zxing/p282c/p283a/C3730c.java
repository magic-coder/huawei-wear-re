package com.google.zxing.p282c.p283a;

import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3718c;
import com.google.zxing.p278b.C3720e;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: DecodedBitStreamParser */
final class C3730c {
    private static final char[] f14503a = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] f14504b = new char[]{'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] f14505c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] f14506d = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', ''};
    private static /* synthetic */ int[] f14507e;

    static /* synthetic */ int[] m18783a() {
        int[] iArr = f14507e;
        if (iArr == null) {
            iArr = new int[C3731d.values().length];
            try {
                iArr[C3731d.ANSIX12_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C3731d.ASCII_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C3731d.BASE256_ENCODE.ordinal()] = 7;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C3731d.C40_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C3731d.EDIFACT_ENCODE.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C3731d.PAD_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C3731d.TEXT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            f14507e = iArr;
        }
        return iArr;
    }

    static C3720e m18778a(byte[] bArr) throws C3900f {
        String stringBuilder;
        List list;
        C3718c c3718c = new C3718c(bArr);
        StringBuilder stringBuilder2 = new StringBuilder(100);
        StringBuilder stringBuilder3 = new StringBuilder(0);
        Collection arrayList = new ArrayList(1);
        C3731d c3731d = C3731d.ASCII_ENCODE;
        do {
            if (c3731d == C3731d.ASCII_ENCODE) {
                c3731d = C3730c.m18779a(c3718c, stringBuilder2, stringBuilder3);
            } else {
                switch (C3730c.m18783a()[c3731d.ordinal()]) {
                    case 3:
                        C3730c.m18781a(c3718c, stringBuilder2);
                        break;
                    case 4:
                        C3730c.m18784b(c3718c, stringBuilder2);
                        break;
                    case 5:
                        C3730c.m18785c(c3718c, stringBuilder2);
                        break;
                    case 6:
                        C3730c.m18786d(c3718c, stringBuilder2);
                        break;
                    case 7:
                        C3730c.m18782a(c3718c, stringBuilder2, arrayList);
                        break;
                    default:
                        throw C3900f.m19459a();
                }
                c3731d = C3731d.ASCII_ENCODE;
            }
            if (c3731d != C3731d.PAD_ENCODE) {
            }
            if (stringBuilder3.length() > 0) {
                stringBuilder2.append(stringBuilder3.toString());
            }
            stringBuilder = stringBuilder2.toString();
            if (arrayList.isEmpty()) {
                Collection collection = arrayList;
            } else {
                list = null;
            }
            return new C3720e(bArr, stringBuilder, list, null);
        } while (c3718c.m18724c() > 0);
        if (stringBuilder3.length() > 0) {
            stringBuilder2.append(stringBuilder3.toString());
        }
        stringBuilder = stringBuilder2.toString();
        if (arrayList.isEmpty()) {
            Collection collection2 = arrayList;
        } else {
            list = null;
        }
        return new C3720e(bArr, stringBuilder, list, null);
    }

    private static C3731d m18779a(C3718c c3718c, StringBuilder stringBuilder, StringBuilder stringBuilder2) throws C3900f {
        int i = 0;
        do {
            int a = c3718c.m18722a(8);
            if (a == 0) {
                throw C3900f.m19459a();
            } else if (a <= 128) {
                if (i != 0) {
                    i = a + 128;
                } else {
                    i = a;
                }
                stringBuilder.append((char) (i - 1));
                return C3731d.ASCII_ENCODE;
            } else if (a == 129) {
                return C3731d.PAD_ENCODE;
            } else {
                if (a <= 229) {
                    a -= 130;
                    if (a < 10) {
                        stringBuilder.append('0');
                    }
                    stringBuilder.append(a);
                } else if (a == 230) {
                    return C3731d.C40_ENCODE;
                } else {
                    if (a == 231) {
                        return C3731d.BASE256_ENCODE;
                    }
                    if (a == 232) {
                        stringBuilder.append('\u001d');
                    } else if (!(a == 233 || a == FitnessSleepType.HW_FITNESS_WAKE)) {
                        if (a == FitnessSleepType.HW_FITNESS_SLEEP_WRONG) {
                            i = 1;
                        } else if (a == FitnessSleepType.HW_FITNESS_DREAM) {
                            stringBuilder.append("[)>\u001e05\u001d");
                            stringBuilder2.insert(0, "\u001e\u0004");
                        } else if (a == FitnessSleepType.HW_FITNESS_NOON) {
                            stringBuilder.append("[)>\u001e06\u001d");
                            stringBuilder2.insert(0, "\u001e\u0004");
                        } else if (a == FitnessSleepType.HW_FITNESS_SLEEP) {
                            return C3731d.ANSIX12_ENCODE;
                        } else {
                            if (a == 239) {
                                return C3731d.TEXT_ENCODE;
                            }
                            if (a == 240) {
                                return C3731d.EDIFACT_ENCODE;
                            }
                            if (!(a == 241 || a < 242 || (a == 254 && c3718c.m18724c() == 0))) {
                                throw C3900f.m19459a();
                            }
                        }
                    }
                }
            }
        } while (c3718c.m18724c() > 0);
        return C3731d.ASCII_ENCODE;
    }

    private static void m18781a(C3718c c3718c, StringBuilder stringBuilder) throws C3900f {
        int[] iArr = new int[3];
        int i = 0;
        Object obj = null;
        while (c3718c.m18724c() != 8) {
            int a = c3718c.m18722a(8);
            if (a != 254) {
                C3730c.m18780a(a, c3718c.m18722a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i2 = iArr[a];
                    switch (i) {
                        case 0:
                            if (i2 < 3) {
                                i = i2 + 1;
                                break;
                            } else if (i2 < f14503a.length) {
                                char c = f14503a[i2];
                                if (obj == null) {
                                    stringBuilder.append(c);
                                    break;
                                }
                                stringBuilder.append((char) (c + 128));
                                obj = null;
                                break;
                            } else {
                                throw C3900f.m19459a();
                            }
                        case 1:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 128));
                                obj = null;
                            } else {
                                stringBuilder.append((char) i2);
                            }
                            i = 0;
                            break;
                        case 2:
                            if (i2 < f14504b.length) {
                                char c2 = f14504b[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c2 + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c2);
                                }
                            } else if (i2 == 27) {
                                stringBuilder.append('\u001d');
                            } else if (i2 == 30) {
                                obj = 1;
                            } else {
                                throw C3900f.m19459a();
                            }
                            i = 0;
                            break;
                        case 3:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 224));
                                obj = null;
                            } else {
                                stringBuilder.append((char) (i2 + 96));
                            }
                            i = 0;
                            break;
                        default:
                            throw C3900f.m19459a();
                    }
                }
                if (c3718c.m18724c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void m18784b(C3718c c3718c, StringBuilder stringBuilder) throws C3900f {
        int[] iArr = new int[3];
        int i = 0;
        Object obj = null;
        while (c3718c.m18724c() != 8) {
            int a = c3718c.m18722a(8);
            if (a != 254) {
                C3730c.m18780a(a, c3718c.m18722a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i2 = iArr[a];
                    char c;
                    switch (i) {
                        case 0:
                            if (i2 < 3) {
                                i = i2 + 1;
                                break;
                            } else if (i2 < f14505c.length) {
                                char c2 = f14505c[i2];
                                if (obj == null) {
                                    stringBuilder.append(c2);
                                    break;
                                }
                                stringBuilder.append((char) (c2 + 128));
                                obj = null;
                                break;
                            } else {
                                throw C3900f.m19459a();
                            }
                        case 1:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 128));
                                obj = null;
                            } else {
                                stringBuilder.append((char) i2);
                            }
                            i = 0;
                            break;
                        case 2:
                            if (i2 < f14504b.length) {
                                c = f14504b[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c);
                                }
                            } else if (i2 == 27) {
                                stringBuilder.append('\u001d');
                            } else if (i2 == 30) {
                                obj = 1;
                            } else {
                                throw C3900f.m19459a();
                            }
                            i = 0;
                            break;
                        case 3:
                            if (i2 < f14506d.length) {
                                c = f14506d[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c);
                                }
                                i = 0;
                                break;
                            }
                            throw C3900f.m19459a();
                        default:
                            throw C3900f.m19459a();
                    }
                }
                if (c3718c.m18724c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void m18785c(C3718c c3718c, StringBuilder stringBuilder) throws C3900f {
        int[] iArr = new int[3];
        while (c3718c.m18724c() != 8) {
            int a = c3718c.m18722a(8);
            if (a != 254) {
                C3730c.m18780a(a, c3718c.m18722a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i = iArr[a];
                    if (i == 0) {
                        stringBuilder.append('\r');
                    } else if (i == 1) {
                        stringBuilder.append('*');
                    } else if (i == 2) {
                        stringBuilder.append('>');
                    } else if (i == 3) {
                        stringBuilder.append(' ');
                    } else if (i < 14) {
                        stringBuilder.append((char) (i + 44));
                    } else if (i < 40) {
                        stringBuilder.append((char) (i + 51));
                    } else {
                        throw C3900f.m19459a();
                    }
                }
                if (c3718c.m18724c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void m18780a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        i3 -= i4 * 1600;
        i4 = i3 / 40;
        iArr[1] = i4;
        iArr[2] = i3 - (i4 * 40);
    }

    private static void m18786d(C3718c c3718c, StringBuilder stringBuilder) {
        while (c3718c.m18724c() > 16) {
            for (int i = 0; i < 4; i++) {
                int a = c3718c.m18722a(6);
                if (a == 31) {
                    a = 8 - c3718c.m18721a();
                    if (a != 8) {
                        c3718c.m18722a(a);
                        return;
                    }
                    return;
                }
                if ((a & 32) == 0) {
                    a |= 64;
                }
                stringBuilder.append((char) a);
            }
            if (c3718c.m18724c() <= 0) {
                return;
            }
        }
    }

    private static void m18782a(C3718c c3718c, StringBuilder stringBuilder, Collection<byte[]> collection) throws C3900f {
        int c;
        int b = c3718c.m18723b() + 1;
        int i = b + 1;
        b = C3730c.m18777a(c3718c.m18722a(8), b);
        if (b == 0) {
            c = c3718c.m18724c() / 8;
        } else if (b < 250) {
            c = b;
        } else {
            c = ((b - 249) * 250) + C3730c.m18777a(c3718c.m18722a(8), i);
            i++;
        }
        if (c < 0) {
            throw C3900f.m19459a();
        }
        Object obj = new byte[c];
        b = 0;
        while (b < c) {
            if (c3718c.m18724c() < 8) {
                throw C3900f.m19459a();
            }
            int i2 = i + 1;
            obj[b] = (byte) C3730c.m18777a(c3718c.m18722a(8), i);
            b++;
            i = i2;
        }
        collection.add(obj);
        try {
            stringBuilder.append(new String(obj, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    private static int m18777a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
