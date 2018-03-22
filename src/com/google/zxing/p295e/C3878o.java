package com.google.zxing.p295e;

import com.google.zxing.C3831l;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;

/* compiled from: UPCEANExtensionSupport */
final class C3878o {
    private static final int[] f14961a = new int[]{1, 1, 2};
    private final C3876m f14962b = new C3876m();
    private final C3877n f14963c = new C3877n();

    C3878o() {
    }

    C3934m m19307a(int i, C3712a c3712a, int i2) throws C3932i {
        int[] a = C3868p.m19264a(c3712a, i2, false, f14961a);
        try {
            return this.f14963c.m19306a(i, c3712a, a);
        } catch (C3831l e) {
            return this.f14962b.m19300a(i, c3712a, a);
        }
    }
}
