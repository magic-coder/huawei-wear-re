package com.huawei.feedback.ui;

import android.os.Message;
import com.huawei.feedback.ui.ResizeRelativeLayout.C4447a;

/* compiled from: FeedbackDetailActivity */
class C4448a implements C4447a {
    final /* synthetic */ FeedbackDetailActivity f16558a;

    C4448a(FeedbackDetailActivity feedbackDetailActivity) {
        this.f16558a = feedbackDetailActivity;
    }

    public void mo4464a(int i, int i2, int i3, int i4) {
        int i5 = -1;
        if (i2 < i4) {
            i5 = 0;
        } else if (i2 > i4) {
            i5 = 1;
        }
        Message message = new Message();
        message.arg1 = i5;
        this.f16558a.f16457u.sendMessage(message);
    }
}
