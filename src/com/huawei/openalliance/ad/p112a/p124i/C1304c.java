package com.huawei.openalliance.ad.p112a.p124i;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.utils.C1365i;
import org.apache.log4j.net.SyslogAppender;

public class C1304c extends LinearLayout implements OnClickListener {
    private TextView f2811a;
    private ImageView f2812b;
    private C1301a f2813c;

    public interface C1301a {
        void mo2447a();
    }

    public C1304c(Context context) {
        super(context);
        setBackgroundColor(Color.rgb(0, 151, SyslogAppender.LOG_LOCAL5));
        int a = C1287e.m5678a(context, 8.0f);
        setPadding(a, a, a, a);
        m5797a(context);
        m5796a();
    }

    private void m5796a() {
        this.f2812b.setOnClickListener(this);
    }

    private void m5797a(Context context) {
        setOrientation(0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(C1287e.m5678a(context, 32.0f), C1287e.m5678a(context, 32.0f));
        this.f2812b = new ImageView(context);
        byte[] decode = Base64.decode("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", 0);
        this.f2812b.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        addView(this.f2812b, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, C1287e.m5678a(context, 32.0f));
        this.f2811a = new TextView(context);
        this.f2811a.setEllipsize(TruncateAt.END);
        this.f2811a.setSingleLine(true);
        this.f2811a.setGravity(17);
        this.f2811a.setText("详情");
        this.f2811a.setTextColor(-1);
        this.f2811a.setTextSize(1, 14.0f);
        addView(this.f2811a, layoutParams);
    }

    public void m5798a(C1301a c1301a) {
        this.f2813c = c1301a;
    }

    public void m5799a(String str) {
        if (this.f2811a != null && !C1365i.m6081a(str)) {
            this.f2811a.setText(str);
        }
    }

    public void onClick(View view) {
        if (this.f2813c != null && view == this.f2812b) {
            this.f2813c.mo2447a();
        }
    }
}
