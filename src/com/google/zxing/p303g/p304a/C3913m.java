package com.google.zxing.p303g.p304a;

import com.google.zxing.C3831l;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p278b.p281b.C3713a;
import com.google.zxing.p278b.p281b.C3715c;
import com.google.zxing.p278b.p281b.C3716d;
import java.util.Map;

/* compiled from: Decoder */
public final class C3913m {
    private final C3715c f15050a = new C3715c(C3713a.f14420e);

    public C3720e m19491a(C3717b c3717b, Map<C3880e, ?> map) throws C3900f, C3832d {
        C3720e a;
        C3832d c3832d;
        C3831l c3831l = null;
        C3901a c3901a = new C3901a(c3717b);
        try {
            a = m19489a(c3901a, (Map) map);
        } catch (C3900f e) {
            C3900f c3900f = e;
            c3832d = c3831l;
            try {
                c3901a.m19465d();
                c3901a.m19462a(true);
                c3901a.m19463b();
                c3901a.m19461a();
                c3901a.m19466e();
                a = m19489a(c3901a, (Map) map);
                a.m18727a(new C3917q(true));
                return a;
            } catch (C3900f e2) {
                if (c3900f != null) {
                    throw c3900f;
                } else if (c3832d != null) {
                    throw c3832d;
                } else {
                    throw e2;
                }
            } catch (C3832d e3) {
                if (c3900f != null) {
                    throw c3900f;
                } else if (c3832d != null) {
                    throw c3832d;
                } else {
                    throw e3;
                }
            }
        } catch (C3832d e4) {
            c3832d = e4;
            C3831l c3831l2 = c3831l;
            c3901a.m19465d();
            c3901a.m19462a(true);
            c3901a.m19463b();
            c3901a.m19461a();
            c3901a.m19466e();
            a = m19489a(c3901a, (Map) map);
            a.m18727a(new C3917q(true));
            return a;
        }
        return a;
    }

    private C3720e m19489a(C3901a c3901a, Map<C3880e, ?> map) throws C3900f, C3832d {
        C3918r b = c3901a.m19463b();
        C3914n a = c3901a.m19461a().m19496a();
        C3902b[] a2 = C3902b.m19467a(c3901a.m19464c(), b, a);
        int i = 0;
        for (C3902b a3 : a2) {
            i += a3.m19468a();
        }
        byte[] bArr = new byte[i];
        i = 0;
        for (C3902b c3902b : a2) {
            byte[] b2 = c3902b.m19469b();
            int a4 = c3902b.m19468a();
            m19490a(b2, a4);
            int i2 = 0;
            while (i2 < a4) {
                int i3 = i + 1;
                bArr[i] = b2[i2];
                i2++;
                i = i3;
            }
        }
        return C3912l.m19483a(bArr, b, a, (Map) map);
    }

    private void m19490a(byte[] bArr, int i) throws C3832d {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f15050a.m18709a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (C3716d e) {
            throw C3832d.m19108a();
        }
    }
}
