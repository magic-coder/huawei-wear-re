package com.huawei.pluginkidwatch.common.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SlectPictureDialog */
class ai implements OnClickListener {
    final /* synthetic */ ae f3852a;
    final /* synthetic */ ah f3853b;

    ai(ah ahVar, ae aeVar) {
        this.f3853b = ahVar;
        this.f3852a = aeVar;
    }

    public void onClick(View view) {
        C2538c.m12674b("com.huawei.bone.sns.ui.base.CommonDialog", "==============you click 2：chose from default photos");
        this.f3852a.m7236a(4, -1, null);
        this.f3853b.m7245a(this.f3853b.f3844a);
    }
}
