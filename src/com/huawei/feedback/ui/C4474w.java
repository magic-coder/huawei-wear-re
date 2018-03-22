package com.huawei.feedback.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: FeedbackEditActivity */
class C4474w implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16606a;

    C4474w(FeedbackEditActivity feedbackEditActivity) {
        this.f16606a = feedbackEditActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f16606a.f16494W != null) {
            this.f16606a.f16494W.cancel();
        }
        this.f16606a.m21374g();
        this.f16606a.finish();
    }
}
