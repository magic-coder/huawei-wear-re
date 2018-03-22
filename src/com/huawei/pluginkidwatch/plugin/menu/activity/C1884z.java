package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;

/* compiled from: AddFenceActivity */
class C1884z implements OnClickListener {
    final /* synthetic */ AddFenceActivity f6192a;

    C1884z(AddFenceActivity addFenceActivity) {
        this.f6192a = addFenceActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("AddFenceActivity", "============== name : home");
        this.f6192a.f5457q.setText(this.f6192a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_home));
        this.f6192a.m9026a(this.f6192a.f5437V);
    }
}
