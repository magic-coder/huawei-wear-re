package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.hwcommonmodel.datatypes.w;

/* compiled from: CommandUnpackage */
public class C1718x {
    private static C1718x f4594b = null;
    private w f4595a = new w();

    private C1718x() {
    }

    public static C1718x m8162a() {
        if (f4594b == null) {
            f4594b = new C1718x();
        }
        return f4594b;
    }

    public byte[] m8163a(byte[] bArr) throws Exception {
        String a = al.m7917a(bArr);
        return ax.m8019a(this.f4595a.a(a.substring(2, a.length())));
    }

    public byte[] m8164b(byte[] bArr) throws Exception {
        String a = al.m7917a(bArr);
        return ax.m8020b(this.f4595a.a(a.substring(2, a.length())));
    }
}
