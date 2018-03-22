package com.huawei.feedback;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.huawei.phoneserviceuni.common.d.a;

/* compiled from: FeedbackUtils */
public class c$a implements OnTouchListener {
    public TextView f16370a;
    public Context f16371b;

    public c$a(TextView textView, Context context) {
        this.f16370a = textView;
        this.f16371b = context;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f16371b != null && a.m()) {
            if (motionEvent.getAction() == 0) {
                this.f16370a.setTextColor(this.f16371b.getResources().getColor(d.d(this.f16371b, "feedback_spannable_click_color")));
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.f16370a.setTextColor(c.c(this.f16371b));
            }
        }
        return false;
    }
}
