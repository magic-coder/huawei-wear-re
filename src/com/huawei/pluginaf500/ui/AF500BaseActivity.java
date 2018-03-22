package com.huawei.pluginaf500.ui;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginaf500.b;
import com.huawei.pluginaf500.connect_ble.C5775a;
import com.huawei.pluginaf500.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.receiver.BltConnStateReceiver;
import com.huawei.pluginaf500.view.C5827a;
import com.huawei.p190v.C2538c;

public abstract class AF500BaseActivity extends Activity {
    private int f19573a = -1;
    private FrameLayout f19574b = null;
    private int f19575c = 0;
    private C5827a f19576d = null;
    public boolean f19577e = false;
    public Handler f19578f = new C5792a(this);
    private BltConnStateReceiver f19579g;
    private C5775a f19580h;

    protected abstract int mo5104a();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19580h = C5775a.m26544a((Context) this);
        if (-1 == this.f19573a) {
            this.f19573a = getResources().getColor(b.startup_title_background);
        }
        Window window = getWindow();
        if (VERSION.SDK_INT >= 19) {
            window.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        }
        this.f19575c = m26504a((Context) this);
        this.f19574b = new FrameLayout(this);
        this.f19574b.setLayoutParams(new LayoutParams(-1, -1));
        this.f19574b.setId(16908300);
        setContentView(this.f19574b);
        mo5115j();
    }

    public void setContentView(int i) {
        super.setContentView(i);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        m26513d();
        super.onDestroy();
    }

    public void viewOnClick(View view) {
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void m26507a(int i) {
        m26510a(getString(i));
    }

    protected void m26510a(String str) {
        if (str == null) {
            str = "";
        }
        TextView textView = (TextView) findViewById(e.title);
        if (textView != null) {
            textView.setText(str);
        }
    }

    protected void m26511b() {
        if (this.f19576d == null) {
            this.f19576d = C5827a.m26922a((Context) this);
            this.f19576d.m26923a(getString(h.please_waiting));
            this.f19576d.setCanceledOnTouchOutside(false);
            this.f19576d.setCancelable(false);
        }
        if (!this.f19576d.isShowing()) {
            this.f19576d.show();
        }
    }

    protected void m26512c() {
        if (this.f19576d != null) {
            this.f19576d.dismiss();
            this.f19576d = null;
        }
    }

    public void mo5112a(Message message) {
    }

    public void m26508a(IntentFilter intentFilter) {
        if (!this.f19577e) {
            if (this.f19579g == null) {
                this.f19579g = new BltConnStateReceiver(this.f19578f);
            }
            registerReceiver(this.f19579g, intentFilter, "com.af500.permission.MYBRODCAST", null);
            this.f19577e = true;
        }
    }

    public void m26513d() {
        if (this.f19577e && this.f19579g != null) {
            unregisterReceiver(this.f19579g);
        }
    }

    public C5775a m26514e() {
        return this.f19580h;
    }

    private static int m26504a(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            C2538c.c("BaseActivity", new Object[]{"etStatusBarHeight exception : " + e.getMessage()});
        }
        return i;
    }

    private void mo5115j() {
        int f = mo5114f();
        int g = m26516g();
        int h = m26517h();
        View imageView = new ImageView(this);
        if (f > 0) {
            if (VERSION.SDK_INT >= 19) {
                f += this.f19575c;
            }
            imageView.setLayoutParams(new LayoutParams(-1, f));
            if (h > 0) {
                imageView.setScaleType(ScaleType.FIT_XY);
                imageView.setImageResource(h);
            } else {
                imageView.setBackgroundColor(g);
            }
        } else if (h > 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), h);
            f = decodeResource.getHeight();
            if (VERSION.SDK_INT >= 19) {
                f += this.f19575c;
            }
            imageView.setLayoutParams(new LayoutParams(-1, f));
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setImageResource(h);
            decodeResource.recycle();
        }
        this.f19574b.addView(imageView);
        View inflate = LayoutInflater.from(this).inflate(mo5104a(), null);
        inflate.setFitsSystemWindows(m26518i());
        this.f19574b.addView(inflate, -1, -1);
    }

    protected int mo5114f() {
        return getResources().getDimensionPixelSize(com.huawei.pluginaf500.c.settings_head_title_backgroud_height);
    }

    protected int m26516g() {
        return this.f19573a;
    }

    protected int m26517h() {
        return d.main_view_top_bg;
    }

    protected boolean m26518i() {
        return true;
    }
}
