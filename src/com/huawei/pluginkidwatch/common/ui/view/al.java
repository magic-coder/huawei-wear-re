package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.plugin.menu.activity.SelectPictrueActivity;

/* compiled from: SlectPictureDialog */
class al implements OnClickListener {
    final /* synthetic */ Activity f3859a;
    final /* synthetic */ ah f3860b;

    al(ah ahVar, Activity activity) {
        this.f3860b = ahVar;
        this.f3859a = activity;
    }

    public void onClick(View view) {
        C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "==============you click 2：chose from default photos");
        C1497q.m6942a(this.f3859a, "isaddselectimg", Boolean.valueOf(true));
        Intent intent = new Intent();
        intent.setClass(this.f3859a, SelectPictrueActivity.class);
        this.f3859a.startActivity(intent);
        this.f3860b.m7245a(this.f3860b.f3844a);
    }
}
