package com.huawei.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.huawei.feedback.bean.C4410d;

/* compiled from: FeedbackDetailAdapter */
class C4459h implements OnClickListener {
    final /* synthetic */ C4410d f16586a;
    final /* synthetic */ LinearLayout f16587b;
    final /* synthetic */ C4458g f16588c;

    C4459h(C4458g c4458g, C4410d c4410d, LinearLayout linearLayout) {
        this.f16588c = c4458g;
        this.f16586a = c4410d;
        this.f16587b = linearLayout;
    }

    public void onClick(View view) {
        this.f16588c.m21471a(1, this.f16586a, this.f16587b);
    }
}
