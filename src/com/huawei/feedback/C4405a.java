package com.huawei.feedback;

import android.text.TextUtils;

/* compiled from: FeedbackApi */
final class C4405a implements Runnable {
    C4405a() {
    }

    public void run() {
        if (!TextUtils.isEmpty(FeedbackApi.access$000()) && !TextUtils.isEmpty(FeedbackApi.access$100())) {
            c.a(b.c, FeedbackApi.access$000(), FeedbackApi.access$200());
            c.a(FeedbackApi.access$100(), FeedbackApi.access$000(), FeedbackApi.access$200());
        }
    }
}
