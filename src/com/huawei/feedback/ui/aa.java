package com.huawei.feedback.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: FeedbackRecordActivity */
class aa implements OnItemClickListener {
    final /* synthetic */ FeedbackRecordActivity f16559a;

    aa(FeedbackRecordActivity feedbackRecordActivity) {
        this.f16559a = feedbackRecordActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f16559a.m21414a(i);
    }
}
