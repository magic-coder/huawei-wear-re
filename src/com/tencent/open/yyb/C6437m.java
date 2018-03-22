package com.tencent.open.yyb;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

/* compiled from: ProGuard */
public class C6437m extends RelativeLayout {
    private float f22325a;
    private ImageView f22326b;
    private ImageView f22327c;
    private TextView f22328d;
    private RelativeLayout f22329e;

    public C6437m(Context context) {
        super(context);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f22325a = displayMetrics.density;
        setLayoutParams(new LayoutParams(-1, m29347a(51.0f)));
        setBackgroundDrawable(C6438n.m29352a("yyb_topbar.9.png", context));
        m29348a();
        m29351d();
    }

    public void setTitle(String str) {
        this.f22328d.setText(str);
    }

    private void m29348a() {
        this.f22329e = new RelativeLayout(getContext());
        this.f22329e.setLayoutParams(new LayoutParams(-2, -1));
        addView(this.f22329e);
        m29349b();
        m29350c();
    }

    private void m29349b() {
        this.f22326b = new ImageView(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(m29347a(11.0f), m29347a(18.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = m29347a(20.0f);
        this.f22326b.setId(10000);
        this.f22326b.setLayoutParams(layoutParams);
        this.f22326b.setClickable(true);
        this.f22326b.setBackgroundDrawable(C6438n.m29352a("yyb_icon_back.png", getContext()));
        this.f22326b.setPadding(m29347a(15.0f), m29347a(7.0f), m29347a(20.0f), m29347a(7.0f));
        this.f22329e.addView(this.f22326b);
    }

    private void m29350c() {
        this.f22328d = new TextView(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(1, 10000);
        layoutParams.leftMargin = m29347a(20.0f);
        this.f22328d.setTextColor(Color.parseColor("#fefefe"));
        this.f22328d.setTextSize(20.0f);
        this.f22328d.setShadowLayer(2.0f, 0.0f, 2.0f, Color.parseColor("#2E000000"));
        this.f22329e.addView(this.f22328d, layoutParams);
    }

    private void m29351d() {
        this.f22327c = new ImageView(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(m29347a(52.0f), m29347a(52.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        this.f22327c.setLayoutParams(layoutParams);
        this.f22327c.setClickable(true);
        this.f22327c.setBackgroundDrawable(C6438n.m29352a("yyb_appdetail_showmore.png", getContext()));
        addView(this.f22327c);
    }

    public RelativeLayout getBackBtn() {
        return this.f22329e;
    }

    public ImageView getSharBtn() {
        return this.f22327c;
    }

    private int m29347a(float f) {
        return (int) ((this.f22325a * f) + 0.5f);
    }
}
