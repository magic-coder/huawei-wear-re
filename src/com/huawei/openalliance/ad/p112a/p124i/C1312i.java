package com.huawei.openalliance.ad.p112a.p124i;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.huawei.openalliance.ad.inter.data.SplashParam;
import com.huawei.openalliance.ad.p112a.p124i.p126a.C1297d;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

public class C1312i extends C1303b {
    private boolean f2837b = true;
    private C1273a f2838c;

    public interface C1273a {
        void mo2433a(int i);
    }

    public C1312i(Context context, SplashParam splashParam, C1273a c1273a) {
        super(context);
        this.f2838c = c1273a;
    }

    public void m5813a(int i, int i2) {
        addView(new C1297d(this.a, i, new C1314k(this, i2)), new LayoutParams(-1, -1));
    }

    public void m5814a(Bitmap bitmap) {
        View imageView = new ImageView(this.a);
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        addView(imageView, new LayoutParams(-1, -1));
    }

    public void m5815a(String str, int i, int i2) {
        View c1297d;
        if (4 == i) {
            c1297d = new C1297d(this.a, str, new C1313j(this, i2));
        } else {
            c1297d = m5795a(str);
            c1297d.setScaleType(ScaleType.CENTER_CROP);
        }
        addView(c1297d, new LayoutParams(-1, -1));
    }

    public boolean m5816a() {
        return this.f2837b;
    }

    public void onWindowVisibilityChanged(int i) {
        C1336d.m5886b("SloganView", "onWindowVisibilityChanged");
        if (8 == i || 4 == i) {
            this.f2837b = false;
        } else if (i == 0) {
            this.f2837b = true;
        }
        super.onWindowVisibilityChanged(i);
    }
}
