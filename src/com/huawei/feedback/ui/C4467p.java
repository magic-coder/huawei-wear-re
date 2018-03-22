package com.huawei.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.huawei.feedback.d;
import com.huawei.phoneserviceuni.common.d.a;

/* compiled from: FeedbackEditActivity */
class C4467p implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16599a;

    C4467p(FeedbackEditActivity feedbackEditActivity) {
        this.f16599a = feedbackEditActivity;
    }

    public void onClick(View view) {
        if (!a.a(this.f16599a)) {
            Toast.makeText(this.f16599a, this.f16599a.getResources().getString(d.b(this.f16599a.f16500c, "feedback_no_network_connection_prompt")), 0).show();
        } else if (this.f16599a.f16479G != null) {
            this.f16599a.f16513p.setVisibility(8);
            this.f16599a.f16514q.setVisibility(0);
            this.f16599a.m21401u();
            this.f16599a.f16515r.loadUrl(this.f16599a.f16479G.m21132d());
        }
    }
}
