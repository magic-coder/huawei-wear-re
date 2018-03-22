package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;

/* compiled from: AddFenceActivity */
class aa implements OnClickListener {
    final /* synthetic */ AddFenceActivity f5921a;

    aa(AddFenceActivity addFenceActivity) {
        this.f5921a = addFenceActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("AddFenceActivity", "============== name : school");
        this.f5921a.f5457q.setText(this.f5921a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_school));
        this.f5921a.f5457q.clearFocus();
        this.f5921a.m9026a(this.f5921a.f5437V);
    }
}
