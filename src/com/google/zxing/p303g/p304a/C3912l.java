package com.google.zxing.p303g.p304a;

import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3718c;
import com.google.zxing.p278b.C3719d;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p278b.C3727l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser */
final class C3912l {
    private static final char[] f15049a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    static C3720e m19483a(byte[] bArr, C3918r c3918r, C3914n c3914n, Map<C3880e, ?> map) throws C3900f {
        C3718c c3718c = new C3718c(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        List arrayList = new ArrayList(1);
        boolean z = false;
        C3719d c3719d = null;
        while (true) {
            C3916p c3916p;
            boolean z2;
            if (c3718c.m18724c() < 4) {
                c3916p = C3916p.TERMINATOR;
            } else {
                try {
                    c3916p = C3916p.m19498a(c3718c.m18722a(4));
                } catch (IllegalArgumentException e) {
                    throw C3900f.m19459a();
                }
            }
            if (c3916p != C3916p.TERMINATOR) {
                if (c3916p != C3916p.FNC1_FIRST_POSITION && c3916p != C3916p.FNC1_SECOND_POSITION) {
                    if (c3916p == C3916p.STRUCTURED_APPEND) {
                        if (c3718c.m18724c() < 16) {
                            throw C3900f.m19459a();
                        }
                        c3718c.m18722a(16);
                        z2 = z;
                    } else if (c3916p == C3916p.ECI) {
                        c3719d = C3719d.m18725a(C3912l.m19482a(c3718c));
                        if (c3719d == null) {
                            throw C3900f.m19459a();
                        }
                    } else if (c3916p == C3916p.HANZI) {
                        r2 = c3718c.m18722a(4);
                        int a = c3718c.m18722a(c3916p.m19499a(c3918r));
                        if (r2 == 1) {
                            C3912l.m19484a(c3718c, stringBuilder, a);
                            z2 = z;
                        }
                    } else {
                        r2 = c3718c.m18722a(c3916p.m19499a(c3918r));
                        if (c3916p == C3916p.NUMERIC) {
                            C3912l.m19488c(c3718c, stringBuilder, r2);
                            z2 = z;
                        } else if (c3916p == C3916p.ALPHANUMERIC) {
                            C3912l.m19486a(c3718c, stringBuilder, r2, z);
                            z2 = z;
                        } else if (c3916p == C3916p.BYTE) {
                            C3912l.m19485a(c3718c, stringBuilder, r2, c3719d, arrayList, map);
                            z2 = z;
                        } else if (c3916p == C3916p.KANJI) {
                            C3912l.m19487b(c3718c, stringBuilder, r2);
                            z2 = z;
                        } else {
                            throw C3900f.m19459a();
                        }
                    }
                    if (c3916p != C3916p.TERMINATOR) {
                        break;
                    }
                    z = z2;
                } else {
                    z2 = true;
                    if (c3916p != C3916p.TERMINATOR) {
                        break;
                    }
                    z = z2;
                }
            }
            z2 = z;
            if (c3916p != C3916p.TERMINATOR) {
                break;
            }
            z = z2;
        }
        String stringBuilder2 = stringBuilder.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new C3720e(bArr, stringBuilder2, arrayList, c3914n == null ? null : c3914n.toString());
    }

    private static void m19484a(C3718c c3718c, StringBuilder stringBuilder, int i) throws C3900f {
        if (i * 13 > c3718c.m18724c()) {
            throw C3900f.m19459a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = c3718c.m18722a(13);
            a = (a % 96) | ((a / 96) << 8);
            if (a < 959) {
                a += 41377;
            } else {
                a += 42657;
            }
            bArr[i2] = (byte) ((a >> 8) & 255);
            bArr[i2 + 1] = (byte) (a & 255);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException e) {
            throw C3900f.m19459a();
        }
    }

    private static void m19487b(C3718c c3718c, StringBuilder stringBuilder, int i) throws C3900f {
        if (i * 13 > c3718c.m18724c()) {
            throw C3900f.m19459a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = c3718c.m18722a(13);
            a = (a % 192) | ((a / 192) << 8);
            if (a < 7936) {
                a += 33088;
            } else {
                a += 49472;
            }
            bArr[i2] = (byte) (a >> 8);
            bArr[i2 + 1] = (byte) a;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException e) {
            throw C3900f.m19459a();
        }
    }

    private static void m19485a(C3718c c3718c, StringBuilder stringBuilder, int i, C3719d c3719d, Collection<byte[]> collection, Map<C3880e, ?> map) throws C3900f {
        if ((i << 3) > c3718c.m18724c()) {
            throw C3900f.m19459a();
        }
        String a;
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            obj[i2] = (byte) c3718c.m18722a(8);
        }
        if (c3719d == null) {
            a = C3727l.m18763a(obj, map);
        } else {
            a = c3719d.name();
        }
        try {
            stringBuilder.append(new String(obj, a));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw C3900f.m19459a();
        }
    }

    private static char m19481a(int i) throws C3900f {
        if (i < f15049a.length) {
            return f15049a[i];
        }
        throw C3900f.m19459a();
    }

    private static void m19486a(C3718c c3718c, StringBuilder stringBuilder, int i, boolean z) throws C3900f {
        int length = stringBuilder.length();
        while (i > 1) {
            if (c3718c.m18724c() < 11) {
                throw C3900f.m19459a();
            }
            int a = c3718c.m18722a(11);
            stringBuilder.append(C3912l.m19481a(a / 45));
            stringBuilder.append(C3912l.m19481a(a % 45));
            i -= 2;
        }
        if (i == 1) {
            if (c3718c.m18724c() < 6) {
                throw C3900f.m19459a();
            }
            stringBuilder.append(C3912l.m19481a(c3718c.m18722a(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + 1) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + 1);
                    }
                }
                length++;
            }
        }
    }

    private static void m19488c(C3718c c3718c, StringBuilder stringBuilder, int i) throws C3900f {
        while (i >= 3) {
            if (c3718c.m18724c() < 10) {
                throw C3900f.m19459a();
            }
            int a = c3718c.m18722a(10);
            if (a >= 1000) {
                throw C3900f.m19459a();
            }
            stringBuilder.append(C3912l.m19481a(a / 100));
            stringBuilder.append(C3912l.m19481a((a / 10) % 10));
            stringBuilder.append(C3912l.m19481a(a % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c3718c.m18724c() < 7) {
                throw C3900f.m19459a();
            }
            a = c3718c.m18722a(7);
            if (a >= 100) {
                throw C3900f.m19459a();
            }
            stringBuilder.append(C3912l.m19481a(a / 10));
            stringBuilder.append(C3912l.m19481a(a % 10));
        } else if (i != 1) {
        } else {
            if (c3718c.m18724c() < 4) {
                throw C3900f.m19459a();
            }
            a = c3718c.m18722a(4);
            if (a >= 10) {
                throw C3900f.m19459a();
            }
            stringBuilder.append(C3912l.m19481a(a));
        }
    }

    private static int m19482a(C3718c c3718c) throws C3900f {
        int a = c3718c.m18722a(8);
        if ((a & 128) == 0) {
            return a & 127;
        }
        if ((a & 192) == 128) {
            return ((a & 63) << 8) | c3718c.m18722a(8);
        } else if ((a & 224) == 192) {
            return ((a & 31) << 16) | c3718c.m18722a(16);
        } else {
            throw C3900f.m19459a();
        }
    }
}
