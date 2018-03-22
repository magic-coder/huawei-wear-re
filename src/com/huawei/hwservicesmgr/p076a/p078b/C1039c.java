package com.huawei.hwservicesmgr.p076a.p078b;

import com.huawei.hwservicesmgr.a.b.a;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileServicesManagerQueue */
public class C1039c implements IParser {
    private static C1039c f1978a;
    private static final Object f1979b = new Object();

    public static C1039c m4270a() {
        C1039c c1039c;
        synchronized (f1979b) {
            C2538c.m12677c("HWFileServicesManagerQueue", "getInstance() instance = " + f1978a);
            if (f1978a == null) {
                f1978a = new C1039c();
            }
            c1039c = f1978a;
        }
        return c1039c;
    }

    private C1039c() {
    }

    public void getResult(byte[] bArr) {
        C2538c.m12677c("HWFileServicesManagerQueue", "getResult() ");
        a.a().a(bArr);
    }
}
