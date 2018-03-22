package com.alipay.sdk.p247d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.p245b.C3170a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class C3177b extends AlertDialog {
    final /* synthetic */ C3176a f10583a;

    protected C3177b(C3176a c3176a, Context context) {
        this.f10583a = c3176a;
        super(context);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        View linearLayout = new LinearLayout(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, C3177b.m14034a(context, 50.0f));
        layoutParams.gravity = 17;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-450944201);
        gradientDrawable.setCornerRadius((float) C3177b.m14034a(context, 5.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        View imageView = new ImageView(context);
        layoutParams = new LinearLayout.LayoutParams(C3177b.m14034a(context, 20.0f), C3177b.m14034a(context, 20.0f));
        layoutParams.gravity = 16;
        layoutParams.setMargins(C3177b.m14034a(this.f10583a.f10581c, 17.0f), C3177b.m14034a(this.f10583a.f10581c, 10.0f), C3177b.m14034a(this.f10583a.f10581c, 8.0f), C3177b.m14034a(this.f10583a.f10581c, 10.0f));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_CENTER);
        imageView.setImageDrawable(C3177b.m14035a(context, C3176a.f10579a));
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(900);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(rotateAnimation);
        View textView = new TextView(context);
        textView.setText(TextUtils.isEmpty(this.f10583a.f10582d) ? "正在加载" : this.f10583a.f10582d);
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, C3177b.m14034a(context, 17.0f), 0);
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        setContentView(linearLayout);
        setCancelable(false);
    }

    private static Drawable m14035a(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C3170a.m14012a(str));
            try {
                Options options = new Options();
                options.inDensity = 480;
                options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
                try {
                    byteArrayInputStream.close();
                    return bitmapDrawable;
                } catch (Exception e) {
                    return bitmapDrawable;
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    private static int m14034a(Context context, float f) {
        return (int) ((context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics().density * f);
    }
}
