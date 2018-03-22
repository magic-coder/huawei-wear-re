package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextImgButton extends LinearLayout {
    private ImageView f3804a;
    private TextView f3805b;
    private float f3806c = 0.0f;

    public TextImgButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3804a = new ImageView(context, attributeSet);
        this.f3804a.setPadding(0, 0, 0, 10);
        this.f3805b = new TextView(context, attributeSet);
        this.f3805b.setGravity(1);
        this.f3805b.setPadding(0, 0, 0, 0);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        addView(this.f3804a);
        addView(this.f3805b);
        this.f3806c = this.f3804a.getAlpha();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (isEnabled()) {
                    this.f3804a.setAlpha(0.5f);
                    this.f3805b.setAlpha(0.5f);
                    break;
                }
                break;
            case 1:
                if (isEnabled()) {
                    this.f3804a.setAlpha(this.f3806c);
                    this.f3805b.setAlpha(this.f3806c);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void setHui(boolean z) {
        float f = 0.5f;
        this.f3804a.setAlpha(!z ? 0.5f : this.f3806c);
        TextView textView = this.f3805b;
        if (z) {
            f = this.f3806c;
        }
        textView.setAlpha(f);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setHui(z);
    }
}
