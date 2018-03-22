package com.huawei.android.pushselfshow.utils;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.android.pushagent.c.a.e;
import java.lang.reflect.InvocationTargetException;

public class RelativeLayoutForBckgColor extends RelativeLayout {
    private WallpaperManager f15806a;
    private Drawable f15807b;

    public RelativeLayoutForBckgColor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20393a();
    }

    public RelativeLayoutForBckgColor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20393a();
    }

    private static Object m20391a(WallpaperManager wallpaperManager, Rect rect) {
        Object obj = null;
        try {
            Class cls = Class.forName("com.huawei.android.app.WallpaperManagerEx");
            obj = cls.getDeclaredMethod("getBlurBitmap", new Class[]{WallpaperManager.class, Rect.class}).invoke(cls, new Object[]{wallpaperManager, rect});
        } catch (ClassNotFoundException e) {
            e.d("PushSelfShowLog", " WallpaperManagerEx getBlurBitmap wrong " + e.toString());
        } catch (NoSuchMethodException e2) {
            e.d("PushSelfShowLog", " WallpaperManagerEx getBlurBitmap wrong " + e2.toString());
        } catch (IllegalAccessException e3) {
            e.d("PushSelfShowLog", " WallpaperManagerEx getBlurBitmap wrong " + e3.toString());
        } catch (IllegalArgumentException e4) {
            e.d("PushSelfShowLog", " WallpaperManagerEx getBlurBitmap wrong " + e4.toString());
        } catch (InvocationTargetException e5) {
            e.d("PushSelfShowLog", " WallpaperManagerEx getBlurBitmap wrong " + e5.toString());
        }
        return obj;
    }

    private void m20392b() {
        int color = getContext().getResources().getColor(C4211e.m20464d(getContext(), "hwpush_bgcolor"));
        try {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + getWidth(), iArr[1] + getHeight());
            if (rect.width() > 0 && rect.height() > 0) {
                if (C4203a.m20436d()) {
                    int h = C4203a.m20441h(getContext());
                    if (h == 0) {
                        setBackgroundColor(color);
                    } else {
                        setBackgroundColor(h);
                    }
                } else if (m20391a(this.f15806a, rect) != null) {
                    this.f15807b = new BitmapDrawable((Bitmap) m20391a(this.f15806a, rect));
                    setBackgroundDrawable(this.f15807b);
                } else {
                    e.d("PushSelfShowLog", "not emui 3.0,can not use wallpaper as background");
                    setBackgroundColor(color);
                }
            }
        } catch (NotFoundException e) {
            e.d("PushSelfShowLog", "setBlurWallpaperBackground error, use default backgroud");
            setBackgroundColor(color);
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "setBlurWallpaperBackground error, use default backgroud");
            setBackgroundColor(color);
        }
    }

    @SuppressLint({"ServiceCast"})
    public void m20393a() {
        this.f15806a = (WallpaperManager) getContext().getSystemService("wallpaper");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m20392b();
    }
}
