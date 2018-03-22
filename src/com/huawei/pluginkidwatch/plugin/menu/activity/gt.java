package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.g;

/* compiled from: TailorContactActivity */
class gt implements OnClickListener {
    final /* synthetic */ TailorContactActivity f6163a;

    gt(TailorContactActivity tailorContactActivity) {
        this.f6163a = tailorContactActivity;
    }

    public void onClick(View view) {
        if (view.getId() == g.mom_tv) {
            if (!this.f6163a.f5917x) {
                this.f6163a.f5879E = "2";
                this.f6163a.f5913t.setImageBitmap(null);
                this.f6163a.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_mom);
                this.f6163a.m9569a(C1617f.kw_pic_relation_mid_mom);
            }
            this.f6163a.f5897d.setText(C1680l.IDS_plugin_kidwatch_main_relation_mom);
        } else if (view.getId() == g.dad_tv) {
            if (!this.f6163a.f5917x) {
                this.f6163a.f5879E = "1";
                this.f6163a.f5913t.setImageBitmap(null);
                this.f6163a.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_dad);
                this.f6163a.m9569a(C1617f.kw_pic_relation_mid_dad);
            }
            this.f6163a.f5897d.setText(C1680l.IDS_plugin_kidwatch_main_relation_dad);
        } else if (view.getId() == g.gf_tv) {
            if (!this.f6163a.f5917x) {
                this.f6163a.f5879E = "3";
                this.f6163a.f5913t.setImageBitmap(null);
                this.f6163a.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_grandpa);
                this.f6163a.m9569a(C1617f.kw_pic_relation_mid_grandpa);
            }
            this.f6163a.f5897d.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandpa);
        } else if (view.getId() == g.gm_tv) {
            if (!this.f6163a.f5917x) {
                this.f6163a.f5879E = "4";
                this.f6163a.f5913t.setImageBitmap(null);
                this.f6163a.f5913t.setBackgroundResource(C1617f.kw_pic_relation_mid_grandma);
                this.f6163a.m9569a(C1617f.kw_pic_relation_mid_grandma);
            }
            this.f6163a.f5897d.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandma);
        }
        this.f6163a.m9539a(this.f6163a.f5906m);
    }
}
