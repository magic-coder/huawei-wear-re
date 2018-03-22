package com.huawei.feedback.ui;

import android.os.Handler;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;

/* compiled from: FeedbackDetailActivity */
class C4456f extends Handler {
    final /* synthetic */ FeedbackDetailActivity f16578a;

    C4456f(FeedbackDetailActivity feedbackDetailActivity) {
        this.f16578a = feedbackDetailActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case -109:
                this.f16578a.m21313j();
                break;
            case 1:
                if (this.f16578a.f16447k.getText().toString().isEmpty() && this.f16578a.f16448l.getTag() == null) {
                    this.f16578a.m21300b(false);
                    ((InputMethodManager) this.f16578a.f16447k.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f16578a.f16447k.getWindowToken(), 0);
                    break;
                }
        }
        super.handleMessage(message);
    }
}
