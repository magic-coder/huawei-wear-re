package com.huawei.feedback.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: FeedbackEditActivity */
class C4464m implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16596a;

    C4464m(FeedbackEditActivity feedbackEditActivity) {
        this.f16596a = feedbackEditActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f16596a.f16495X != null) {
            this.f16596a.f16495X.cancel();
        }
        this.f16596a.finish();
    }
}
