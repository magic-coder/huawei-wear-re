package com.huawei.feedback.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: FeedbackEditActivity */
class C4468q implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16600a;

    C4468q(FeedbackEditActivity feedbackEditActivity) {
        this.f16600a = feedbackEditActivity;
    }

    public void onClick(View view) {
        if (this.f16600a.f16479G != null) {
            try {
                this.f16600a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + this.f16600a.f16479G.m21136f())));
            } catch (ActivityNotFoundException e) {
                c.d("FeedbackEditActivity", "Fail to DialView.");
            }
        }
    }
}
