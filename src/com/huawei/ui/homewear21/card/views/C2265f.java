package com.huawei.ui.homewear21.card.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.List;

/* compiled from: PariedDevicesSwitcher */
class C2265f implements OnClickListener {
    final /* synthetic */ PariedDevicesSwitcher f8247a;

    C2265f(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f8247a = pariedDevicesSwitcher;
    }

    public void onClick(View view) {
        c.a().a(BaseApplication.m2632b(), a.cs.a(), new HashMap(), 0);
        List b = this.f8247a.m11688b();
        if (b != null && b.size() - 1 > 0) {
            C2538c.m12677c(PariedDevicesSwitcher.f8209b, "devices is not null");
            if (this.f8247a.getFocus()) {
                this.f8247a.m11663a(view);
                this.f8247a.setFocus(false);
            } else if (this.f8247a.f8216h != null) {
                this.f8247a.f8230v.post(new C2266g(this));
            }
        }
    }
}
