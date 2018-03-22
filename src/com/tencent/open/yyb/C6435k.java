package com.tencent.open.yyb;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.tencent.open.p541a.C6367n;
import java.util.HashMap;

/* compiled from: ProGuard */
public class C6435k extends Dialog {
    private LinearLayout f22320a;
    private RelativeLayout f22321b;
    private HashMap<String, TextView> f22322c = new HashMap(4);
    private float f22323d;
    private Rect f22324e = new Rect(0, m29340a(9.0f), 0, 0);

    public C6435k(Context context) {
        super(context, 16973840);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f22323d = displayMetrics.density;
        C6367n.m29107b("openSDK_LOG", "-->(MoreFloatingDialog) : density = " + this.f22323d);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f22321b = new RelativeLayout(context);
        this.f22321b.setLayoutParams(layoutParams);
        this.f22321b.setBackgroundDrawable(C6438n.m29353a("yyb_appdetail_bg_floatingwindow.9.png", context, this.f22324e));
        this.f22320a = new LinearLayout(context);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f22320a.setLayoutParams(layoutParams);
        this.f22322c.put("yyb_qq.png", m29338a(C6438n.m29353a("yyb_qq.png", getContext(), this.f22324e), "QQ分享"));
        this.f22322c.put("yyb_qzone.png", m29338a(C6438n.m29353a("yyb_qzone.png", getContext(), this.f22324e), "空间分享"));
        this.f22321b.addView(this.f22320a, layoutParams);
        setContentView(this.f22321b);
    }

    public View m29341a() {
        return (View) this.f22322c.get("yyb_qq.png");
    }

    public View m29342b() {
        return (View) this.f22322c.get("yyb_qzone.png");
    }

    public View m29343c() {
        return (View) this.f22322c.get("yyb_weixin.png");
    }

    public View m29344d() {
        return (View) this.f22322c.get("yyb_friends.png");
    }

    private TextView m29338a(Drawable drawable, String str) {
        if (drawable != null) {
            drawable.setBounds(0, 0, m29340a(28.0f), m29340a(28.0f));
        }
        View textView = new TextView(getContext());
        textView.setTextColor(-1);
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextSize(13.0f);
        textView.setCompoundDrawablePadding(m29340a(8.0f));
        textView.setPadding(0, m29340a(19.0f), 0, m29340a(19.0f));
        textView.setGravity(1);
        textView.setText(str);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        layoutParams.gravity = 1;
        this.f22320a.addView(textView, layoutParams);
        m29339e();
        return textView;
    }

    private void m29339e() {
        View imageView = new ImageView(getContext());
        imageView.setBackgroundColor(Color.parseColor("#33ffffff"));
        this.f22320a.addView(imageView, new LinearLayout.LayoutParams(m29340a(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT), -1));
    }

    public int m29340a(float f) {
        return (int) ((this.f22323d * f) + 0.5f);
    }
}
