package com.huawei.feedback.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

/* compiled from: FeedbackDetailActivity */
class C4455e implements OnClickListener {
    final /* synthetic */ Intent f16576a;
    final /* synthetic */ FeedbackDetailActivity f16577b;

    C4455e(FeedbackDetailActivity feedbackDetailActivity, Intent intent) {
        this.f16577b = feedbackDetailActivity;
        this.f16576a = intent;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16577b.m21291a(this.f16576a);
    }
}
