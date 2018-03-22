package com.huawei.ui.homewear21.p175a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HomeFragment */
class C2228l implements OnCheckedChangeListener {
    final /* synthetic */ C2217a f8141a;

    C2228l(C2217a c2217a) {
        this.f8141a = c2217a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "Rotate switch screem is onCheckedChanged isChecked = " + z);
        compoundButton.setClickable(false);
        synchronized (this.f8141a.aW) {
            this.f8141a.m11444a(this.f8141a.ak, 25).m11260a(z);
        }
        this.f8141a.f8004M.m10434c(z, new C2229m(this, compoundButton));
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        if (z) {
            hashMap.put("status", "1");
        } else {
            hashMap.put("status", "0");
        }
        c.a().a(BaseApplication.m2632b(), a.cT.a(), hashMap, 0);
    }
}
