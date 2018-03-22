package com.huawei.feedback.ui;

import android.support.v4.view.InputDeviceCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.feedback.c;

/* compiled from: FeedbackEditActivity */
class C4470s implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16602a;

    C4470s(FeedbackEditActivity feedbackEditActivity) {
        this.f16602a = feedbackEditActivity;
    }

    public void onClick(View view) {
        boolean z = true;
        this.f16602a.f16511n.setChecked(!this.f16602a.f16511n.isChecked());
        if (this.f16602a.f16520w.m21178h()) {
            z = false;
        }
        if (!z || c.a(this.f16602a) || !c.a(this.f16602a, "android.permission.WRITE_EXTERNAL_STORAGE", InputDeviceCompat.SOURCE_TOUCHSCREEN)) {
            this.f16602a.f16520w.m21160a(z);
        }
    }
}
