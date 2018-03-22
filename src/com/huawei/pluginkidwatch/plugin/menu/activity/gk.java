package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: TailorContactActivity */
class gk implements OnClickListener {
    final /* synthetic */ TailorContactActivity f6154a;

    gk(TailorContactActivity tailorContactActivity) {
        this.f6154a = tailorContactActivity;
    }

    public void onClick(View view) {
        this.f6154a.f5907n = new C1507h(this.f6154a, h.dialog_contact_edit_delete, m.servicedialog, true);
        this.f6154a.f5907n.show();
        ((TextView) this.f6154a.f5907n.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new gl(this));
        ((TextView) this.f6154a.f5907n.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new gm(this));
    }
}
