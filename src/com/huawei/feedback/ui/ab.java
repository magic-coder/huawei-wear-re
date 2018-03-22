package com.huawei.feedback.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: FeedbackRecordActivity */
class ab implements OnClickListener {
    final /* synthetic */ FeedbackRecordActivity f16560a;

    ab(FeedbackRecordActivity feedbackRecordActivity) {
        this.f16560a = feedbackRecordActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16560a.f16547m.dismiss();
    }
}
