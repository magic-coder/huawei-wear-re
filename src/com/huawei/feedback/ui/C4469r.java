package com.huawei.feedback.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: FeedbackEditActivity */
class C4469r implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16601a;

    C4469r(FeedbackEditActivity feedbackEditActivity) {
        this.f16601a = feedbackEditActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.f16601a.f16500c, FeedbackRecordActivity.class);
        intent.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        this.f16601a.startActivity(intent);
    }
}
