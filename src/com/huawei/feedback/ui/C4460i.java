package com.huawei.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.huawei.feedback.bean.C4410d;

/* compiled from: FeedbackDetailAdapter */
class C4460i implements OnClickListener {
    final /* synthetic */ C4410d f16589a;
    final /* synthetic */ LinearLayout f16590b;
    final /* synthetic */ C4458g f16591c;

    C4460i(C4458g c4458g, C4410d c4410d, LinearLayout linearLayout) {
        this.f16591c = c4458g;
        this.f16589a = c4410d;
        this.f16590b = linearLayout;
    }

    public void onClick(View view) {
        this.f16591c.m21471a(-1, this.f16589a, this.f16590b);
    }
}
