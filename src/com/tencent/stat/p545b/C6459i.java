package com.tencent.stat.p545b;

public class C6459i {
    static final /* synthetic */ boolean f22412a = (!C6459i.class.desiredAssertionStatus());

    private C6459i() {
    }

    public static byte[] m29427a(byte[] bArr, int i) {
        return C6459i.m29428a(bArr, 0, bArr.length, i);
    }

    public static byte[] m29428a(byte[] bArr, int i, int i2, int i3) {
        C6461k c6461k = new C6461k(i3, new byte[((i2 * 3) / 4)]);
        if (!c6461k.m29431a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c6461k.b == c6461k.a.length) {
            return c6461k.a;
        } else {
            Object obj = new byte[c6461k.b];
            System.arraycopy(c6461k.a, 0, obj, 0, c6461k.b);
            return obj;
        }
    }

    public static byte[] m29429b(byte[] bArr, int i) {
        return C6459i.m29430b(bArr, 0, bArr.length, i);
    }

    public static byte[] m29430b(byte[] bArr, int i, int i2, int i3) {
        C6462l c6462l = new C6462l(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c6462l.f22424d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c6462l.f22425e && i2 > 0) {
            i4 += (c6462l.f22426f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c6462l.a = new byte[i4];
        c6462l.m29432a(bArr, i, i2, true);
        if (f22412a || c6462l.b == i4) {
            return c6462l.a;
        }
        throw new AssertionError();
    }
}
