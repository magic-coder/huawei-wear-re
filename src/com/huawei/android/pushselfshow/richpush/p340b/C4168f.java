package com.huawei.android.pushselfshow.richpush.p340b;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;

public class C4168f implements OnTouchListener {
    private static int f15659f = 0;
    private static int f15660g = 1;
    private static int f15661h = 2;
    private View f15662a;
    private ImageView f15663b;
    private ImageView f15664c;
    private TextView f15665d;
    private TextView f15666e;

    @SuppressLint({"NewApi"})
    private void m20331a(View view, int i) {
        if (view != null && view.isClickable()) {
            TextView textView;
            if (view == this.f15663b) {
                textView = this.f15665d;
            } else if (view == this.f15664c) {
                textView = this.f15666e;
            } else {
                return;
            }
            if (textView != null) {
                float f = f15660g == i ? 0.5f : f15661h == i ? NFCBaseActivity.PERCENT_MARGIN_30 : DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                view.setAlpha(f);
                textView.setAlpha(f);
            }
        }
    }

    private void m20332a(ImageView imageView, boolean z) {
        if (imageView != null) {
            imageView.setClickable(z);
        }
    }

    public void m20333a() {
        if (this.f15662a != null) {
            this.f15662a.setVisibility(0);
        }
    }

    public void m20334a(ImageView imageView) {
        m20331a((View) imageView, f15661h);
        m20332a(imageView, false);
    }

    public void m20335b(ImageView imageView) {
        m20332a(imageView, true);
        m20331a((View) imageView, f15659f);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m20331a(view, f15659f);
        } else {
            m20331a(view, f15660g);
        }
        return false;
    }
}
