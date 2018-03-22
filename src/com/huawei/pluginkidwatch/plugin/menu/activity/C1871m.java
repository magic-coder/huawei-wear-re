package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.g;

/* compiled from: AddContactActivity */
class C1871m implements OnClickListener {
    final /* synthetic */ AddContactActivity f6176a;

    C1871m(AddContactActivity addContactActivity) {
        this.f6176a = addContactActivity;
    }

    public void onClick(View view) {
        if (view.getId() == g.mom_tv) {
            if (!this.f6176a.f5409t) {
                this.f6176a.f5414y = "2";
                this.f6176a.f5395f.setImageBitmap(null);
                this.f6176a.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_mom);
                this.f6176a.m9017a(C1617f.kw_pic_relation_mid_mom);
            }
            this.f6176a.f5405p.setText(C1680l.IDS_plugin_kidwatch_main_relation_mom);
        } else if (view.getId() == g.dad_tv) {
            if (!this.f6176a.f5409t) {
                this.f6176a.f5414y = "1";
                this.f6176a.f5395f.setImageBitmap(null);
                this.f6176a.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_dad);
                this.f6176a.m9017a(C1617f.kw_pic_relation_mid_dad);
            }
            this.f6176a.f5405p.setText(C1680l.IDS_plugin_kidwatch_main_relation_dad);
        } else if (view.getId() == g.gf_tv) {
            if (!this.f6176a.f5409t) {
                this.f6176a.f5414y = "3";
                this.f6176a.f5395f.setImageBitmap(null);
                this.f6176a.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_grandpa);
                this.f6176a.m9017a(C1617f.kw_pic_relation_mid_grandpa);
            }
            this.f6176a.f5405p.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandpa);
        } else if (view.getId() == g.gm_tv) {
            if (!this.f6176a.f5409t) {
                this.f6176a.f5414y = "4";
                this.f6176a.f5395f.setImageBitmap(null);
                this.f6176a.f5395f.setBackgroundResource(C1617f.kw_pic_relation_mid_grandma);
                this.f6176a.m9017a(C1617f.kw_pic_relation_mid_grandma);
            }
            this.f6176a.f5405p.setText(C1680l.IDS_plugin_kidwatch_main_relation_grandma);
        }
        this.f6176a.m8985a(this.f6176a.f5397h);
    }
}
