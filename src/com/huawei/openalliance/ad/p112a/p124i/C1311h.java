package com.huawei.openalliance.ad.p112a.p124i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.utils.C1365i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class C1311h extends LinearLayout {
    private Context f2833a;
    private String f2834b;
    private int f2835c;
    private int f2836d;

    public C1311h(Context context, String str, int i, int i2) {
        super(context);
        this.f2833a = context;
        this.f2834b = str;
        this.f2835c = i;
        this.f2836d = i2;
        m5810b();
    }

    private void m5810b() {
        int i = 54;
        int i2 = 16;
        int a = C1287e.m5678a(this.f2833a, 20.0f);
        int parseColor = Color.parseColor("#33000000");
        if (C1365i.m6081a(this.f2834b)) {
            this.f2834b = "跳过广告";
        } else {
            try {
                this.f2834b = URLDecoder.decode(this.f2834b, "utf-8");
            } catch (UnsupportedEncodingException e) {
                this.f2834b = "跳过广告";
            }
        }
        int length = (this.f2834b.length() * 12) + 20;
        if (length >= 54) {
            i = length;
        }
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius((float) a);
        gradientDrawable.setStroke(1, Color.parseColor("#80FFFFFF"));
        View textView = new TextView(this.f2833a);
        textView.setText(this.f2834b);
        textView.setTextColor(-838860801);
        textView.setTextSize(0, (float) C1287e.m5678a(this.f2833a, 11.0f));
        textView.setGravity(17);
        textView.setBackground(gradientDrawable);
        textView.setWidth(C1287e.m5678a(this.f2833a, (float) i));
        textView.setHeight(C1287e.m5678a(this.f2833a, 22.0f));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        if (5 == this.f2836d) {
            i = 16;
        } else {
            i = 12;
            i2 = 12;
        }
        if (this.f2835c == 0) {
            i = 56;
        }
        int d = C1289h.m5695a(this.f2833a).m5709d();
        setPadding(C1287e.m5678a(this.f2833a, (float) d), C1287e.m5678a(this.f2833a, (float) Math.min(i2, d)), C1287e.m5678a(this.f2833a, (float) Math.min(i, d)), C1287e.m5678a(this.f2833a, (float) d));
        addView(textView, layoutParams);
        setClickable(true);
    }

    public RelativeLayout.LayoutParams m5811a() {
        int i = 16;
        int i2 = 12;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        if (5 == this.f2836d) {
            i2 = 16;
        } else {
            i = 12;
        }
        if (this.f2835c == 0) {
            i = 56;
        }
        int d = C1289h.m5695a(this.f2833a).m5709d();
        layoutParams.setMargins(0, C1287e.m5678a(this.f2833a, (float) (i2 < d ? 0 : i2 - d)), C1287e.m5678a(this.f2833a, (float) (i < d ? 0 : i - d)), 0);
        return layoutParams;
    }
}
