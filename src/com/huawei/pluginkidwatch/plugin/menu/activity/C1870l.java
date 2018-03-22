package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: AddContactActivity */
class C1870l implements OnClickListener {
    final /* synthetic */ AddContactActivity f6175a;

    C1870l(AddContactActivity addContactActivity) {
        this.f6175a = addContactActivity;
    }

    public void onClick(View view) {
        this.f6175a.f5397h = new C1507h(this.f6175a, h.dialog_contact_list, m.servicedialog, true);
        if (this.f6175a.f5397h != null) {
            this.f6175a.f5400k = (TextView) this.f6175a.f5397h.findViewById(g.mom_tv);
            this.f6175a.f5401l = (TextView) this.f6175a.f5397h.findViewById(g.dad_tv);
            this.f6175a.f5402m = (TextView) this.f6175a.f5397h.findViewById(g.gf_tv);
            this.f6175a.f5403n = (TextView) this.f6175a.f5397h.findViewById(g.gm_tv);
            this.f6175a.f5400k.setOnClickListener(this.f6175a.f5387G);
            this.f6175a.f5401l.setOnClickListener(this.f6175a.f5387G);
            this.f6175a.f5402m.setOnClickListener(this.f6175a.f5387G);
            this.f6175a.f5403n.setOnClickListener(this.f6175a.f5387G);
            this.f6175a.f5397h.show();
        }
    }
}
