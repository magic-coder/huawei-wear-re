package com.google.zxing.p293d.p294a;

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
public final class C3829c {
    private final C3715c f14847a = new C3715c(C3713a.f14423h);

    public C3720e m19104a(C3717b c3717b, Map<C3880e, ?> map) throws C3900f, C3832d {
        byte[] bArr;
        Object a = new C3827a(c3717b).m19093a();
        m19103a(a, 0, 10, 10, 0);
        int i = a[0] & 15;
        switch (i) {
            case 2:
            case 3:
            case 4:
                m19103a(a, 20, 84, 40, 1);
                m19103a(a, 20, 84, 40, 2);
                bArr = new byte[94];
                break;
            case 5:
                m19103a(a, 20, 68, 56, 1);
                m19103a(a, 20, 68, 56, 2);
                bArr = new byte[78];
                break;
            default:
                throw C3900f.m19459a();
        }
        System.arraycopy(a, 0, bArr, 0, 10);
        System.arraycopy(a, 20, bArr, 10, bArr.length - 10);
        return C3828b.m19097a(bArr, i);
    }

    private void m19103a(byte[] bArr, int i, int i2, int i3, int i4) throws C3832d {
        int i5 = 0;
        int i6 = i2 + i3;
        int i7 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i6 / i7)];
        int i8 = 0;
        while (i8 < i6) {
            if (i4 == 0 || i8 % 2 == i4 - 1) {
                iArr[i8 / i7] = bArr[i8 + i] & 255;
            }
            i8++;
        }
        try {
            this.f14847a.m18709a(iArr, i3 / i7);
            while (i5 < i2) {
                if (i4 == 0 || i5 % 2 == i4 - 1) {
                    bArr[i5 + i] = (byte) iArr[i5 / i7];
                }
                i5++;
            }
        } catch (C3716d e) {
            throw C3832d.m19108a();
        }
    }
}
