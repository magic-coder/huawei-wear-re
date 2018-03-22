package com.huawei.android.pushselfshow.richpush.p341c;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;

public class C4190b implements OnTouchListener {
    private static int f15780i = 0;
    private static int f15781j = 1;
    private static int f15782k = 2;
    private ImageView f15783a;
    private ImageView f15784b;
    private ImageView f15785c;
    private ImageView f15786d;
    private TextView f15787e;
    private TextView f15788f;
    private TextView f15789g;
    private TextView f15790h;

    @SuppressLint({"NewApi"})
    private void m20378a(View view, int i) {
        if (view != null && view.isClickable()) {
            TextView textView;
            if (view == this.f15784b) {
                textView = this.f15788f;
            } else if (view == this.f15783a) {
                textView = this.f15787e;
            } else if (view == this.f15785c) {
                textView = this.f15789g;
            } else if (view == this.f15786d) {
                textView = this.f15790h;
            } else {
                return;
            }
            if (textView != null) {
                float f = f15781j == i ? 0.5f : f15782k == i ? NFCBaseActivity.PERCENT_MARGIN_30 : DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                view.setAlpha(f);
                textView.setAlpha(f);
            }
        }
    }

    private void m20379a(ImageView imageView, boolean z) {
        if (imageView != null) {
            imageView.setClickable(z);
        }
    }

    public void m20380a(ImageView imageView) {
        m20379a(imageView, true);
        m20378a((View) imageView, f15780i);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m20378a(view, f15780i);
        } else {
            m20378a(view, f15781j);
        }
        return false;
    }
}
