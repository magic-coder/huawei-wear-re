package com.huawei.phoneserviceuni.common.p491a;

import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p132d.C5768d;
import com.huawei.phoneserviceuni.common.p491a.p492a.C5750a;
import com.huawei.phoneserviceuni.common.p491a.p492a.C5751b;
import com.huawei.phoneserviceuni.common.p491a.p492a.C5752c;
import com.huawei.phoneserviceuni.common.p491a.p492a.C5753d;
import com.huawei.phoneserviceuni.common.p491a.p492a.C5754e;

/* compiled from: SIMUtils */
public final class C5756b {
    private static final Object f19533b = new Object();
    private static C5756b f19534c = null;
    private C5750a f19535a;

    private C5756b() {
        m26437c();
    }

    public static C5756b m26436a() {
        C5756b c5756b;
        synchronized (f19533b) {
            if (f19534c == null) {
                f19534c = new C5756b();
            }
            c5756b = f19534c;
        }
        return c5756b;
    }

    public String m26441a(int i) {
        return this.f19535a.mo5103a(i);
    }

    public C5752c m26442b() {
        return this.f19535a.mo5102a();
    }

    private void m26437c() {
        try {
            if (m26438d()) {
                c.b("SIMUtils", "init SIMUtils choose MTK mutil");
                this.f19535a = new C5751b();
            } else if (m26439e()) {
                c.b("SIMUtils", "init SIMUtils choose HW mutil");
                this.f19535a = new C5753d();
            } else {
                c.b("SIMUtils", "init SIMUtils choose single");
                this.f19535a = new C5754e();
            }
        } catch (Exception e) {
            c.d("SIMUtils", "createSim Exception ");
        } catch (Error e2) {
            c.d("SIMUtils", "createSim Error error");
        }
        if (this.f19535a == null) {
            c.d("SIMUtils", "Fail to create sim, so init singleSIM");
            this.f19535a = new C5754e();
        }
    }

    private boolean m26438d() {
        return C5768d.m26485a("com.mediatek.common.featureoption.FeatureOption", "MTK_GEMINI_SUPPORT", false);
    }

    private boolean m26439e() {
        try {
            return ((Boolean) C5768d.m26481a(Class.forName("android.telephony.MSimTelephonyManager"), m26440f(), "isMultiSimEnabled", new Class[0], new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            c.d("SIMUtils", "isHwGeminiSupport ClassNotFoundException wrong ");
            return false;
        }
    }

    private Object m26440f() {
        return C5768d.m26482a("android.telephony.MSimTelephonyManager", "getDefault", new Class[0], new Object[0]);
    }
}
