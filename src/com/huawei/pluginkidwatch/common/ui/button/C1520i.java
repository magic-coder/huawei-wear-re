package com.huawei.pluginkidwatch.common.ui.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.d;

/* compiled from: TextImageButton */
public class C1520i extends LinearLayout {
    private ImageView f3567a;
    private TextView f3568b;

    public C1520i(Context context) {
        super(context);
        this.f3567a = new ImageView(context);
        this.f3567a.setPadding(0, 0, 0, 0);
        this.f3568b = new TextView(context);
        this.f3568b.setGravity(17);
        this.f3568b.setTextColor(getResources().getColor(d.kw_color_white_50alpha));
        this.f3568b.setPadding(0, 0, 0, 0);
        this.f3568b.setTextSize(2, 14.0f);
        setClickable(true);
        setFocusable(true);
        setOrientation(0);
        addView(this.f3567a);
        addView(this.f3568b);
        setGravity(17);
    }

    public void setText(String str) {
        this.f3568b.setText(str);
    }

    public void setText(int i) {
        this.f3568b.setText(getContext().getResources().getString(i));
    }

    public void setBackgroundRes(int i) {
        setBackgroundResource(i);
    }

    public void setIcon(int i) {
        this.f3567a.setImageResource(i);
    }

    public void setIcon(Drawable drawable) {
        this.f3567a.setImageDrawable(drawable);
    }

    public void setBackgroundDra(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setTextVisibility(int i) {
        this.f3568b.setVisibility(i);
    }

    public void setTextSize(float f) {
        this.f3568b.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.f3568b.setTextColor(i);
    }

    public TextView getTextView() {
        return this.f3568b;
    }
}
