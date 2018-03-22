package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.e;

public class WaitingLineView extends RelativeLayout {
    LayoutParams f3807a;
    int f3808b;
    private Context f3809c;
    private ImageView f3810d;
    private TranslateAnimation f3811e;

    public WaitingLineView(Context context) {
        this(context, null);
    }

    public WaitingLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            this.f3809c = context;
            this.f3808b = this.f3809c.getResources().getDisplayMetrics().widthPixels;
            this.f3811e = new TranslateAnimation(-100.0f, (float) this.f3808b, 0.0f, 0.0f);
            this.f3811e.setDuration(600);
            this.f3811e.setRepeatCount(-1);
            m7205a();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void m7205a() {
        setBackgroundColor(this.f3809c.getResources().getColor(d.kw_color_flash_line_bg));
        int dimension = (int) getResources().getDimension(e.title_height);
        this.f3807a = new LayoutParams(dimension, dimension);
        if (this.f3810d == null) {
            this.f3810d = new ImageView(this.f3809c);
        }
        this.f3810d.setImageResource(C1617f.flashline);
        this.f3810d.setPadding(0, 0, 0, 0);
        this.f3810d.setLayoutParams(new LayoutParams(-2, -2));
        removeView(this.f3810d);
        addView(this.f3810d, this.f3807a);
        this.f3810d.setAnimation(this.f3811e);
        this.f3810d.setVisibility(4);
    }

    public void m7206a(boolean z) {
        if (z) {
            this.f3811e.startNow();
        } else {
            this.f3811e.cancel();
        }
    }
}
