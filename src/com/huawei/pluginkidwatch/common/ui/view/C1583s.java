package com.huawei.pluginkidwatch.common.ui.view;

import android.os.Handler;
import android.os.Message;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: CustomCircleProgress */
class C1583s extends Handler {
    final /* synthetic */ CustomCircleProgress f3928a;
    final /* synthetic */ C1582r f3929b;

    C1583s(C1582r c1582r, CustomCircleProgress customCircleProgress) {
        this.f3929b = c1582r;
        this.f3928a = customCircleProgress;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 16:
                if (this.f3929b.f3918b) {
                    C1582r c1582r;
                    if (this.f3929b.f3925i) {
                        c1582r = this.f3929b;
                        c1582r.f3923g += (float) this.f3929b.f3926j;
                        this.f3929b.f3926j = this.f3929b.f3926j + 5;
                    } else {
                        c1582r = this.f3929b;
                        c1582r.f3923g += DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    }
                    this.f3929b.f3924h.setMainProgress((int) this.f3929b.f3923g);
                    if (this.f3929b.f3923g < ((float) this.f3929b.f3924h.f3793b)) {
                        return;
                    }
                    if (!this.f3929b.f3927k || this.f3929b.f3925i) {
                        this.f3929b.m7293b();
                        return;
                    }
                    this.f3929b.f3923g = 0.0f;
                    this.f3929b.f3926j = 1;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
