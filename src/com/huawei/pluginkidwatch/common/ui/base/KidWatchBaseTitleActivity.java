package com.huawei.pluginkidwatch.common.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.e;

public abstract class KidWatchBaseTitleActivity extends KidWatchBaseActivity {
    private int f3525b = -1;
    private FrameLayout f3526c = null;
    private int f3527d = 0;

    protected abstract int mo2526h();

    protected void onCreate(Bundle bundle) {
        m6998i();
        if (-1 == this.f3525b) {
            this.f3525b = getResources().getColor(d.common_custom_title_bg);
        }
        Window window = getWindow();
        if (VERSION.SDK_INT >= 19) {
            window.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        }
        this.f3527d = mo2627b(this);
        C2538c.m12674b("BaseKidWatchTitleActivity", "onCreate: mStatusBarHeight = " + this.f3527d);
        this.f3526c = new FrameLayout(this);
        this.f3526c.setLayoutParams(new LayoutParams(-1, -1));
        this.f3526c.setId(16908300);
        setContentView(this.f3526c);
        super.onCreate(bundle);
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void mo2517a() {
        int f = m6995f();
        C2538c.m12674b("BaseKidWatchTitleActivity", "initView: height = " + f);
        int d = mo2518d();
        int e = mo2519e();
        C2538c.m12674b("BaseKidWatchTitleActivity", "initView: color = " + d + ", imageRes = " + e);
        View imageView = new ImageView(this);
        if (f > 0) {
            if (VERSION.SDK_INT >= 19) {
                f += this.f3527d;
            }
            imageView.setLayoutParams(new LayoutParams(-1, f));
            if (e > 0) {
                imageView.setScaleType(ScaleType.FIT_XY);
                imageView.setImageResource(e);
            } else {
                imageView.setBackgroundColor(d);
            }
        } else if (e > 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), e);
            f = decodeResource.getHeight();
            if (VERSION.SDK_INT >= 19) {
                f += this.f3527d;
            }
            imageView.setLayoutParams(new LayoutParams(-1, f));
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setImageResource(e);
            decodeResource.recycle();
        }
        this.f3526c.addView(imageView);
        View inflate = LayoutInflater.from(this).inflate(mo2526h(), null);
        inflate.setFitsSystemWindows(m6996g());
        this.f3526c.addView(inflate, -1, -1);
    }

    private static int mo2627b(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            C2538c.m12680e("BaseKidWatchTitleActivity", "Exception e = " + e.getMessage());
        }
        return i;
    }

    protected int mo2518d() {
        return this.f3525b;
    }

    protected int mo2519e() {
        return C1617f.main_view_top_bg;
    }

    protected int m6995f() {
        return getResources().getDimensionPixelSize(e.settings_head_title_backgroud_height);
    }

    protected boolean m6996g() {
        return true;
    }

    protected void m6998i() {
        requestWindowFeature(1);
    }
}
