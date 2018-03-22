package com.google.zxing.p282c.p283a;

import com.google.zxing.C3832d;
import com.google.zxing.C3900f;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3720e;
import com.google.zxing.p278b.p281b.C3713a;
import com.google.zxing.p278b.p281b.C3715c;
import com.google.zxing.p278b.p281b.C3716d;

/* compiled from: Decoder */
public final class C3732e {
    private final C3715c f14516a = new C3715c(C3713a.f14421f);

    public C3720e m18788a(C3717b c3717b) throws C3900f, C3832d {
        int i;
        C3728a c3728a = new C3728a(c3717b);
        C3729b[] a = C3729b.m18774a(c3728a.m18771b(), c3728a.m18767a());
        int length = a.length;
        int i2 = 0;
        for (C3729b a2 : a) {
            i2 += a2.m18775a();
        }
        byte[] bArr = new byte[i2];
        for (i = 0; i < length; i++) {
            C3729b c3729b = a[i];
            byte[] b = c3729b.m18776b();
            int a3 = c3729b.m18775a();
            m18787a(b, a3);
            for (i2 = 0; i2 < a3; i2++) {
                bArr[(i2 * length) + i] = b[i2];
            }
        }
        return C3730c.m18778a(bArr);
    }

    private void m18787a(byte[] bArr, int i) throws C3832d {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f14516a.m18709a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (C3716d e) {
            throw C3832d.m19108a();
        }
    }
}
