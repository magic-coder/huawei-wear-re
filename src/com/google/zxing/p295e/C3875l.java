package com.google.zxing.p295e;

import com.google.zxing.C3709a;
import com.google.zxing.C3740c;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import java.util.Map;

/* compiled from: UPCAReader */
public final class C3875l extends C3868p {
    private final C3868p f14955a = new C3869e();

    public C3934m mo4324a(int i, C3712a c3712a, int[] iArr, Map<C3880e, ?> map) throws C3932i, C3900f, C3832d {
        return C3875l.m19292a(this.f14955a.mo4324a(i, c3712a, iArr, (Map) map));
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i, C3900f, C3832d {
        return C3875l.m19292a(this.f14955a.mo4321a(i, c3712a, (Map) map));
    }

    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3900f {
        return C3875l.m19292a(this.f14955a.mo4301a(c3740c, map));
    }

    C3709a mo4323b() {
        return C3709a.UPC_A;
    }

    protected int mo4322a(C3712a c3712a, int[] iArr, StringBuilder stringBuilder) throws C3932i {
        return this.f14955a.mo4322a(c3712a, iArr, stringBuilder);
    }

    private static C3934m m19292a(C3934m c3934m) throws C3900f {
        String a = c3934m.m19572a();
        if (a.charAt(0) == '0') {
            return new C3934m(a.substring(1), null, c3934m.m19577c(), C3709a.UPC_A);
        }
        throw C3900f.m19459a();
    }
}
