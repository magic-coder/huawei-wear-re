package com.huawei.feedback.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FeedbackDetailAdapter */
class C4461j implements OnClickListener {
    final /* synthetic */ String f16592a;
    final /* synthetic */ C4458g f16593b;

    C4461j(C4458g c4458g, String str) {
        this.f16593b = c4458g;
        this.f16592a = str;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.f16593b.f16584b, FeedbackPicShowActivity.class);
        intent.putExtra("picture_path", this.f16592a);
        this.f16593b.f16584b.startActivity(intent);
    }
}
