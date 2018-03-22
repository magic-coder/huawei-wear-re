package com.huawei.feedback.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.huawei.feedback.d;

/* compiled from: FeedbackDetailActivity */
class C4454d implements OnClickListener {
    final /* synthetic */ FeedbackDetailActivity f16575a;

    C4454d(FeedbackDetailActivity feedbackDetailActivity) {
        this.f16575a = feedbackDetailActivity;
    }

    public void onClick(View view) {
        if (d.a(this.f16575a, "feedback_continue_txtview") == view.getId()) {
            this.f16575a.m21300b(true);
            this.f16575a.f16447k.requestFocus();
            ((InputMethodManager) this.f16575a.f16447k.getContext().getSystemService("input_method")).showSoftInput(this.f16575a.f16447k, 0);
        } else if (d.a(this.f16575a, "feedback_send_btn") == view.getId()) {
            this.f16575a.m21311h();
        } else if (d.a(this.f16575a, "add_image_btn") == view.getId()) {
            this.f16575a.m21312i();
        }
    }
}
