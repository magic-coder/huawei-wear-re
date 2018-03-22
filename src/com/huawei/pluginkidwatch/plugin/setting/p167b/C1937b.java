package com.huawei.pluginkidwatch.plugin.setting.p167b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1388d;

/* compiled from: CheckBillAdapter */
class C1937b implements OnClickListener {
    int f6708a;
    C1938c f6709b;
    final /* synthetic */ C1936a f6710c;

    public C1937b(C1936a c1936a, int i, C1938c c1938c) {
        this.f6710c = c1936a;
        this.f6708a = i;
        this.f6709b = c1938c;
    }

    public void onClick(View view) {
        boolean z = ((C1388d) this.f6710c.f6705b.get(this.f6708a)).f3045f;
        if (((C1388d) this.f6710c.f6705b.get(this.f6708a)).f3043d == null || ((C1388d) this.f6710c.f6705b.get(this.f6708a)).f3043d.isEmpty()) {
            C1483c.m6834d(this.f6710c.f6707d, this.f6710c.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_check_bill_main_Unable_to_resolve));
        } else if (z) {
            this.f6709b.f6720j.setBackground(this.f6710c.f6707d.getResources().getDrawable(C1617f.bill_kw_telephone_switch));
            this.f6709b.f6721k.setVisibility(0);
            this.f6709b.f6722l.setVisibility(8);
            ((C1388d) this.f6710c.f6705b.get(this.f6708a)).f3045f = false;
        } else {
            this.f6709b.f6720j.setBackground(this.f6710c.f6707d.getResources().getDrawable(C1617f.bill_kw_telephone_switch_press));
            this.f6709b.f6713c.setVisibility(0);
            this.f6709b.f6721k.setVisibility(8);
            this.f6709b.f6722l.setVisibility(0);
            ((C1388d) this.f6710c.f6705b.get(this.f6708a)).f3045f = true;
        }
    }
}
