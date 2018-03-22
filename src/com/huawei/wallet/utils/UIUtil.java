package com.huawei.wallet.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.huawei.b.b;
import com.huawei.b.c;
import com.huawei.wallet.utils.log.LogC;

public class UIUtil {

    public interface UIUtilSAI10 {
    }

    public interface UIUtilSAI1 {
    }

    public interface UIUtilSAI2 {
    }

    public interface UIUtilSAI3 {
    }

    public interface UIUtilSAI4 {
    }

    public interface UIUtilSAI5 {
    }

    public interface UIUtilSAI6 {
    }

    public interface UIUtilSAI7 {
    }

    public interface UIUtilSAI8 {
    }

    public interface UIUtilSAI9 {
    }

    public static boolean m28489a(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        return -1 == requestedOrientation || 3 == requestedOrientation;
    }

    public static void m28490b(Activity activity) {
        if (activity.getResources().getBoolean(b.IsSupportOrientation)) {
            activity.setRequestedOrientation(-1);
        } else {
            activity.setRequestedOrientation(1);
        }
    }

    public static void m28487a(Activity activity, View view) {
        if (activity != null && view != null && activity.getResources().getBoolean(b.IsNeedReset)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i >= i2) {
                i = i2;
            }
            i2 = (i * 6) / 8;
            LogC.m28530b(" resetButtonMargin screenWidth=" + i + ",width=" + i2, false);
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void m28488a(Activity activity, ViewGroup viewGroup, boolean z) {
        if (activity != null && viewGroup != null) {
            int i = 0;
            Resources resources = activity.getResources();
            float f = resources.getDisplayMetrics().density;
            if (resources.getConfiguration().orientation == 2) {
                float f2 = ((float) resources.getConfiguration().screenWidthDp) * f;
                i = (int) (f2 / 12.0f);
                int i2 = (int) ((f2 * 11.0f) / 12.0f);
                Drawable layerDrawable = new LayerDrawable(new ColorDrawable[]{new ColorDrawable(activity.getResources().getColor(c.black_2)), new ColorDrawable(activity.getResources().getColor(c.hwpay_bg_color)), new ColorDrawable(activity.getResources().getColor(c.black_2))});
                layerDrawable.setLayerInset(0, 0, 0, i2, 0);
                layerDrawable.setLayerInset(1, i, 0, i, 0);
                layerDrawable.setLayerInset(2, i2, 0, 0, 0);
                viewGroup.setBackground(layerDrawable);
            } else {
                viewGroup.setBackground(null);
            }
            if (z) {
                viewGroup.setPadding(i, viewGroup.getPaddingTop(), i, viewGroup.getPaddingBottom());
                return;
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) viewGroup.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i;
            viewGroup.setLayoutParams(marginLayoutParams);
        }
    }
}
