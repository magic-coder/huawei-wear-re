package com.huawei.feedback.logic;

import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: FeedbackSubmitTask */
class C4422m implements Runnable {
    final /* synthetic */ C4419j f16424a;

    C4422m(C4419j c4419j) {
        this.f16424a = c4419j;
    }

    public void run() {
        c.d("FeedbackSubmitTask", "A maximum of 500 feedback records can be saved. Please delete some records first.");
    }
}
