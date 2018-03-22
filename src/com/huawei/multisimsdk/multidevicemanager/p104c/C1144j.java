package com.huawei.multisimsdk.multidevicemanager.p104c;

import com.huawei.multisimsdk.multidevicemanager.common.C1165q;
import com.huawei.multisimsdk.multidevicemanager.common.C1167s;
import com.huawei.multisimsdk.multidevicemanager.common.C1168t;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1141i;

/* compiled from: QueryManager */
class C1144j implements C1141i {
    final /* synthetic */ C1143i f2421a;

    C1144j(C1143i c1143i) {
        this.f2421a = c1143i;
    }

    public void mo2360a(String str) {
        C1168t c1168t = new C1168t();
        c1168t.m5229a(str);
        C1165q a = c1168t.m5228a();
        C1167s b = c1168t.m5230b();
        if (this.f2421a.m5090a(a).booleanValue()) {
            this.f2421a.m5100d(b);
        }
    }
}
