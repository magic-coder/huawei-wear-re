package com.huawei.feedback.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.feedback.d;
import com.huawei.feedback.ui.FeedbackEditActivity.C4440i;

/* compiled from: FeedbackEditActivity */
class C4463l implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16595a;

    C4463l(FeedbackEditActivity feedbackEditActivity) {
        this.f16595a = feedbackEditActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16595a.f16492U = new ProgressDialog(this.f16595a.f16500c);
        this.f16595a.f16492U.setMessage(this.f16595a.f16500c.getString(d.b(this.f16595a.f16500c, "feedback_waiting")));
        this.f16595a.f16492U.setCancelable(false);
        this.f16595a.f16492U.show();
        this.f16595a.f16478F = new C4440i(this.f16595a, this.f16595a.f16500c);
        this.f16595a.f16478F.start();
        this.f16595a.f16494W.cancel();
    }
}
