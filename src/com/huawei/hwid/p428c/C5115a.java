package com.huawei.hwid.p428c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5114a;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: HwIDMemCache */
public final class C5115a {
    private static C5115a f18425b = null;
    private Context f18426a;
    private HwAccount f18427c;
    private HwAccount f18428d;
    private HashMap<String, String> f18429e = new HashMap();

    public static C5115a m24641a(Context context) {
        C5115a c5115a;
        synchronized (C5115a.class) {
            if (f18425b == null) {
                f18425b = new C5115a(context.getApplicationContext());
            }
            c5115a = f18425b;
        }
        return c5115a;
    }

    private C5115a(Context context) {
        this.f18426a = context;
    }

    public void m24643a() {
        C5165e.m24904a("HwIDMemCache", "initHwAccount");
        ArrayList a = C5114a.m24640a(this.f18426a).mo4617a(this.f18426a, C5166b.m24960l(this.f18426a));
        if (a.size() > 0) {
            this.f18427c = (HwAccount) a.get(0);
        }
    }

    public void m24644a(HwAccount hwAccount) {
        C5165e.m24904a("HwIDMemCache", "saveHwAccount");
        if (C5166b.m24930a(hwAccount)) {
            C5114a.m24640a(this.f18426a).mo4621a(this.f18426a, hwAccount);
            this.f18428d = null;
            if (C5166b.m24953g(this.f18426a)) {
                m24643a();
                return;
            }
            C5165e.m24904a("HwIDMemCache", "update hwAccount in SDK");
            this.f18427c = hwAccount;
            return;
        }
        C5165e.m24910d("HwIDMemCache", "hwAccount is invalid");
    }

    public HwAccount m24646b() {
        return this.f18428d;
    }

    public HwAccount m24647c() {
        if (this.f18427c == null) {
            m24643a();
        }
        return this.f18427c;
    }

    public void m24645a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.f18429e.put(str, str2);
        }
    }

    public String m24642a(String str) {
        return this.f18429e.get(str) == null ? "" : (String) this.f18429e.get(str);
    }
}
