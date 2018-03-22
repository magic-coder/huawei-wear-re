package com.huawei.ui.main.stories.nps.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: QuestionMainActivity */
class C2436k implements OnClickListener {
    final /* synthetic */ QuestionMainActivity f8768a;

    C2436k(QuestionMainActivity questionMainActivity) {
        this.f8768a = questionMainActivity;
    }

    public void onClick(View view) {
        if (!this.f8768a.isFinishing()) {
            if (this.f8768a.f8727h != null && this.f8768a.f8727h.isShowing()) {
                C2538c.m12677c(this.f8768a.f8720a, "==========nps close commitSuccessDialog");
                this.f8768a.f8727h.cancel();
                this.f8768a.f8727h = null;
            }
            this.f8768a.finish();
        }
    }
}
