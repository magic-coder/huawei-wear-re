package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: TailorContactActivity */
class gp implements OnClickListener {
    final /* synthetic */ TailorContactActivity f6159a;

    gp(TailorContactActivity tailorContactActivity) {
        this.f6159a = tailorContactActivity;
    }

    public void onClick(View view) {
        this.f6159a.f5906m = new C1507h(this.f6159a, h.dialog_contact_list, m.servicedialog, true);
        if (this.f6159a.f5906m != null) {
            this.f6159a.m9544b();
        }
    }
}
