package com.huawei.feedback.logic;

import android.widget.Toast;
import com.huawei.feedback.d;

/* compiled from: FeedbackSubmitTask */
class C4421l implements Runnable {
    final /* synthetic */ C4419j f16423a;

    C4421l(C4419j c4419j) {
        this.f16423a = c4419j;
    }

    public void run() {
        Toast.makeText(this.f16423a.f16421a.f16411g, this.f16423a.f16421a.f16411g.getString(d.b(this.f16423a.f16421a.f16411g, "feedback_send__feedback_failed")), 0).show();
    }
}
