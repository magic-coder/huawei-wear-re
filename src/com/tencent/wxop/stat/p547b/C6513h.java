package com.tencent.wxop.stat.p547b;

public class C6513h {
    static final /* synthetic */ boolean f22693a = (!C6513h.class.desiredAssertionStatus());

    private C6513h() {
    }

    public static byte[] m29723a(byte[] bArr) {
        int length = bArr.length;
        C6515j c6515j = new C6515j(new byte[((length * 3) / 4)]);
        if (!c6515j.m29725a(bArr, length)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c6515j.b == c6515j.a.length) {
            return c6515j.a;
        } else {
            Object obj = new byte[c6515j.b];
            System.arraycopy(c6515j.a, 0, obj, 0, c6515j.b);
            return obj;
        }
    }

    public static byte[] m29724b(byte[] bArr) {
        int length = bArr.length;
        C6516k c6516k = new C6516k();
        int i = (length / 3) * 4;
        if (!c6516k.f22705d) {
            switch (length % 3) {
                case 0:
                    break;
                case 1:
                    i += 2;
                    break;
                case 2:
                    i += 3;
                    break;
                default:
                    break;
            }
        } else if (length % 3 > 0) {
            i += 4;
        }
        if (c6516k.f22706e && length > 0) {
            i += (c6516k.f22707f ? 2 : 1) * (((length - 1) / 57) + 1);
        }
        c6516k.a = new byte[i];
        c6516k.m29726a(bArr, length);
        if (f22693a || c6516k.b == i) {
            return c6516k.a;
        }
        throw new AssertionError();
    }
}
