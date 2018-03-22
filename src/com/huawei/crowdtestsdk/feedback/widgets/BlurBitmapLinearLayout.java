package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.AbsWallpaperManager.IBlurWallpaperCallback;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.android.app.WallpaperManagerEx;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.uploadlog.p188c.C2511g;

public class BlurBitmapLinearLayout extends LinearLayout {
    private Drawable mDrawable;
    private Handler mHandler;
    private WallpaperManager mWallpaperManager;

    class InnerUi implements IBlurWallpaperCallback {
        private Handler handler;

        public InnerUi(Handler handler) {
            this.handler = handler;
        }

        public void onBlurWallpaperChanged() {
            C2511g.m12481b("BETACLUB_SDK", "[BlurBitmapLinearLayout.onBlurWallpaperChanged]");
            this.handler.sendEmptyMessage(1);
        }
    }

    public BlurBitmapLinearLayout(Context context) {
        super(context);
        if (SdkConstants.isEmui3()) {
            init();
        } else {
            setBackgroundColor(Color.rgb(0, 0, 0));
        }
    }

    public BlurBitmapLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (SdkConstants.isEmui3()) {
            init();
        } else {
            setBackgroundColor(Color.rgb(0, 0, 0));
        }
    }

    public BlurBitmapLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (SdkConstants.isEmui3()) {
            init();
        } else {
            setBackgroundColor(Color.rgb(0, 0, 0));
        }
    }

    private void initHandler(Looper looper) {
        this.mHandler = new Handler(looper) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        try {
                            BlurBitmapLinearLayout.this.setBlurWallpaperBackground();
                            return;
                        } catch (Throwable e) {
                            C2511g.m12482b("BETACLUB_SDK", "[BlurBitmapLinearLayout.initHandler] error!", e);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
    }

    private void setBlurWallpaperBackground() {
        C2511g.m12481b("BETACLUB_SDK", "[BlurBitmapLinearLayout.setBlurWallpaperBackground]");
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        C2511g.m12481b("BETACLUB_SDK", "[BlurBitmapLinearLayout.setBlurWallpaperBackground]arrayOfInt[0]:" + iArr[0]);
        C2511g.m12481b("BETACLUB_SDK", "[BlurBitmapLinearLayout.setBlurWallpaperBackground]arrayOfInt[1]:" + iArr[1]);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + getWidth(), iArr[1] + getHeight());
        if (rect.width() > 0 && rect.height() > 0) {
            this.mDrawable = new BitmapDrawable(getResources(), WallpaperManagerEx.getBlurBitmap(this.mWallpaperManager, rect));
            setBackground(this.mDrawable);
        }
    }

    public void init() {
        C2511g.m12481b("BETACLUB_SDK", "[BlurBitmapLinearLayout.init]");
        this.mWallpaperManager = (WallpaperManager) getContext().getSystemService("wallpaper");
        initHandler(getContext().getMainLooper());
        WallpaperManagerEx.setCallback(this.mWallpaperManager, new InnerUi(this.mHandler));
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            if (SdkConstants.isEmui3()) {
                C2511g.m12481b("BETACLUB_SDK", "setBlurWallpaperBackground");
                setBlurWallpaperBackground();
            }
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[BlurBitmapLinearLayout.onLayout]:NullPointerException = " + e.getMessage(), e);
        }
    }
}
