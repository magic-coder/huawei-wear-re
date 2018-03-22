package com.huawei.hms.update.p050e;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.p039c.C0855d;
import com.huawei.hms.p039c.C0859g;
import com.huawei.hms.support.p043b.C0881a;
import com.huawei.hms.update.p048c.C0914a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AbsUpdateWizard */
public abstract class C0916a {
    abstract void mo2281a(C0917b c0917b);

    abstract void mo2282b(C0917b c0917b);

    abstract Activity mo2283c();

    protected void m3202a(int i, int i2) {
        Context c = mo2283c();
        if (c != null && !c.isFinishing()) {
            Map hashMap = new HashMap();
            hashMap.put("package", c.getPackageName());
            hashMap.put("sdk_ver", String.valueOf(20502300));
            hashMap.put("app_id", C0859g.m3025a(c));
            hashMap.put("trigger_api", C0914a.m3199b());
            hashMap.put("hms_ver", String.valueOf(C0914a.m3194a()));
            hashMap.put("update_type", String.valueOf(i2));
            hashMap.put("net_type", String.valueOf(C0855d.m3011a(c)));
            hashMap.put("result", String.valueOf(i));
            C0881a.m3076a().m3078a(c, "HMS_SDK_UPDATE", hashMap);
        }
    }
}
