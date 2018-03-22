package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.g;

/* compiled from: EditRelationSettingActivity */
class di implements OnClickListener {
    final /* synthetic */ EditRelationSettingActivity f6033a;

    di(EditRelationSettingActivity editRelationSettingActivity) {
        this.f6033a = editRelationSettingActivity;
    }

    public void onClick(View view) {
        if (g.btn_next == view.getId()) {
            this.f6033a.finish();
        } else if (g.relation_lly_mother == view.getId()) {
            this.f6033a.m9324f();
        } else if (g.relation_lly_father == view.getId()) {
            this.f6033a.m9326g();
        } else if (g.relation_lly_grandpa == view.getId()) {
            this.f6033a.m9328h();
        } else if (g.relation_lly_grandma == view.getId()) {
            this.f6033a.m9330i();
        } else if (g.relation_lly_other == view.getId()) {
            this.f6033a.m9319d();
        } else if (g.edit_btn_back == view.getId()) {
            C1497q.m6943a(this.f6033a.f5696q, "editname", "");
            this.f6033a.finish();
        }
    }
}
