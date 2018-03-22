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
class C2226j implements OnCheckedChangeListener {
    final /* synthetic */ C2217a f8138a;

    C2226j(C2217a c2217a) {
        this.f8138a = c2217a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "Rotate wake screem is onCheckedChanged isChecked = " + z);
        compoundButton.setClickable(false);
        synchronized (this.f8138a.aW) {
            this.f8138a.m11444a(this.f8138a.ak, 11).m11260a(z);
        }
        this.f8138a.f8004M.m10421a(z, new C2227k(this, compoundButton));
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        if (z) {
            hashMap.put("status", "1");
        } else {
            hashMap.put("status", "0");
        }
        c.a().a(BaseApplication.m2632b(), a.cy.a(), hashMap, 0);
    }
}
