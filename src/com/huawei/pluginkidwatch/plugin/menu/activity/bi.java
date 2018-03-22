package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.g;

/* compiled from: ContactInfoActivity */
class bi implements OnClickListener {
    final /* synthetic */ ContactInfoActivity f5964a;

    bi(ContactInfoActivity contactInfoActivity) {
        this.f5964a = contactInfoActivity;
    }

    public void onClick(View view) {
        if (view.getId() == g.mom_tv) {
            this.f5964a.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_mom);
            this.f5964a.f5533F.nickname = "妈妈";
            this.f5964a.m9140a(this.f5964a.f5568r);
            this.f5964a.m9150b(this.f5964a.f5533F);
        } else if (view.getId() == g.dad_tv) {
            this.f5964a.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_dad);
            this.f5964a.f5533F.nickname = "爸爸";
            this.f5964a.m9140a(this.f5964a.f5568r);
            this.f5964a.m9150b(this.f5964a.f5533F);
        } else if (view.getId() == g.gf_tv) {
            this.f5964a.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandpa);
            this.f5964a.f5533F.nickname = "爷爷";
            this.f5964a.m9140a(this.f5964a.f5568r);
            this.f5964a.m9150b(this.f5964a.f5533F);
        } else if (view.getId() == g.gm_tv) {
            this.f5964a.f5559i.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandma);
            this.f5964a.f5533F.nickname = "奶奶";
            this.f5964a.m9140a(this.f5964a.f5568r);
            this.f5964a.m9150b(this.f5964a.f5533F);
        } else if (view.getId() == g.info_other) {
            this.f5964a.m9167h();
        }
    }
}
