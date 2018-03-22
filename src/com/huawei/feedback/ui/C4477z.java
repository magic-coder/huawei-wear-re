package com.huawei.feedback.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.feedback.logic.C4416g;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: FeedbackRecordActivity */
class C4477z extends BroadcastReceiver {
    final /* synthetic */ FeedbackRecordActivity f16609a;

    C4477z(FeedbackRecordActivity feedbackRecordActivity) {
        this.f16609a = feedbackRecordActivity;
    }

    public void onReceive(Context context, Intent intent) {
        c.a("FeedbackRecordActivity", "receive a broadcast");
        this.f16609a.m21431g();
        if (this.f16609a.f16548n != null) {
            c.a("FeedbackRecordActivity", "begin update feedback records by receive broadcast");
            this.f16609a.f16548n.notifyDataSetChanged();
        }
        C4416g.m21260d();
    }
}
