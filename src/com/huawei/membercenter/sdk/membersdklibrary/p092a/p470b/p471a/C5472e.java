package com.huawei.membercenter.sdk.membersdklibrary.p092a.p470b.p471a;

import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5482d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5486h;

/* compiled from: SIMUtils */
public final class C5472e {
    private static C5472e f19327b = null;
    private C5468a f19328a;

    private C5472e() {
        m26158c();
    }

    public static synchronized C5472e m26157a() {
        C5472e c5472e;
        synchronized (C5472e.class) {
            if (f19327b == null) {
                f19327b = new C5472e();
            }
            c5472e = f19327b;
        }
        return c5472e;
    }

    public String m26162a(int i) {
        return this.f19328a.mo4698a(i);
    }

    public C5470c m26163b() {
        return this.f19328a.mo4697a();
    }

    private void m26158c() {
        try {
            if (m26159d()) {
                C5482d.m26183a("SIMUtils", "init SIMUtils choose MTK mutil");
                this.f19328a = new C5469b();
            } else if (m26160e()) {
                C5482d.m26183a("SIMUtils", "init SIMUtils choose HW mutil");
                this.f19328a = new C5471d();
            } else {
                C5482d.m26183a("SIMUtils", "init SIMUtils choose single");
                this.f19328a = new C5473f();
            }
        } catch (Exception e) {
            C5482d.m26186d("SIMUtils", "createSim Exception " + e.getMessage());
        } catch (Error e2) {
            C5482d.m26186d("SIMUtils", "Error error");
        }
        if (this.f19328a == null) {
            C5482d.m26186d("SIMUtils", "Fail to create sim, so init singleSIM");
            this.f19328a = new C5473f();
        }
    }

    private boolean m26159d() {
        return C5486h.m26205a("com.mediatek.common.featureoption.FeatureOption", "MTK_GEMINI_SUPPORT", false);
    }

    private boolean m26160e() {
        try {
            return ((Boolean) C5486h.m26193a(Class.forName("android.telephony.MSimTelephonyManager"), m26161f(), "isMultiSimEnabled", new Class[0], new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            C5482d.m26186d("SIMUtils", "isHwGeminiSupport ClassNotFoundException wrong ");
            return false;
        }
    }

    private Object m26161f() {
        return C5486h.m26194a("android.telephony.MSimTelephonyManager", "getDefault", new Class[0], new Object[0]);
    }
}
