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
class C2224h implements OnCheckedChangeListener {
    final /* synthetic */ C2217a f8135a;

    C2224h(C2217a c2217a) {
        this.f8135a = c2217a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2538c.m12661a("MainUI", 1, "HomeFragment", "BluetoothOffalert is onCheckedChanged isChecked = " + z);
        compoundButton.setClickable(false);
        synchronized (this.f8135a.aW) {
            this.f8135a.m11444a(this.f8135a.ak, 2).m11260a(z);
        }
        this.f8135a.f8004M.m10438d(z, new C2225i(this, compoundButton));
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        if (z) {
            hashMap.put("status", "1");
        } else {
            hashMap.put("status", "0");
        }
        c.a().a(BaseApplication.m2632b(), a.cx.a(), hashMap, 0);
    }
}
