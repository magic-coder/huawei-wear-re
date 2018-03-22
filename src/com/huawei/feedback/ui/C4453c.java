package com.huawei.feedback.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: FeedbackDetailActivity */
class C4453c implements OnScrollListener {
    final /* synthetic */ FeedbackDetailActivity f16574a;

    C4453c(FeedbackDetailActivity feedbackDetailActivity) {
        this.f16574a = feedbackDetailActivity;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            View currentFocus = this.f16574a.getCurrentFocus();
            if (currentFocus != null) {
                currentFocus.clearFocus();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
