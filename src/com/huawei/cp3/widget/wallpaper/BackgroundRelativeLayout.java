package com.huawei.cp3.widget.wallpaper;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.android.app.WallpaperManagerEx;
import com.huawei.cp3.C4365b;
import com.huawei.cp3.C4369f;
import com.huawei.cp3.widget.C4372a;

@SuppressLint({"ServiceCast"})
public class BackgroundRelativeLayout extends RelativeLayout {
    private WallpaperManager f16280a;
    private Drawable f16281b;
    private boolean f16282c = true;

    public BackgroundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21046a(context, attributeSet);
    }

    public BackgroundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21046a(context, attributeSet);
    }

    public BackgroundRelativeLayout(Context context) {
        super(context);
        m21045a();
    }

    private void m21046a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4369f.BackgroundWallPager);
        this.f16282c = obtainStyledAttributes.getBoolean(C4369f.BackgroundWallPager_isNeedSetWallPager, true);
        obtainStyledAttributes.recycle();
        m21045a();
    }

    private void m21045a() {
        this.f16280a = (WallpaperManager) getContext().getSystemService("wallpaper");
    }

    private void m21047b() {
        try {
            if (C4372a.m20999a()) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + getWidth(), iArr[1] + getHeight());
                if (rect.width() > 0 && rect.height() > 0) {
                    this.f16281b = new BitmapDrawable(WallpaperManagerEx.getBlurBitmap(this.f16280a, rect));
                    setBackgroundDrawable(this.f16281b);
                    return;
                }
                return;
            }
            setBackgroundDrawable(getResources().getDrawable(C4365b.cp3_background_brand_shade));
        } catch (RuntimeException e) {
            setBackgroundDrawable(getResources().getDrawable(C4365b.cp3_background_brand_shade));
        } catch (NoClassDefFoundError e2) {
            setBackgroundDrawable(getResources().getDrawable(C4365b.cp3_background_brand_shade));
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!C4372a.m21002b() || this.f16282c) {
            m21047b();
        } else {
            setBackgroundDrawable(getResources().getDrawable(C4365b.cp3_background_brand_shade));
        }
    }
}
