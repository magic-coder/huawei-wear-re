package com.huawei.bone.p551a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: StatusBarUtil */
public class C6754a {
    public static void m30024a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i, int i2) {
        if (VERSION.SDK_INT >= 19) {
            if (VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            if (viewGroup.getChildCount() <= 0 || !(viewGroup.getChildAt(0) instanceof C6755b)) {
                viewGroup.addView(C6754a.m30025b(activity, i), 0);
            } else {
                viewGroup.getChildAt(0).setBackgroundColor(C6754a.m30021a(i, i2));
            }
            if (!((viewGroup instanceof LinearLayout) || viewGroup.getChildAt(1) == null)) {
                viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), C6754a.m30022a(activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            }
            ViewGroup viewGroup2 = (ViewGroup) drawerLayout.getChildAt(1);
            drawerLayout.setFitsSystemWindows(false);
            viewGroup.setFitsSystemWindows(false);
            viewGroup.setClipToPadding(true);
            viewGroup2.setFitsSystemWindows(false);
            C6754a.m30023a(activity, i2);
        }
    }

    private static void m30023a(Activity activity, int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup.getChildCount() > 1) {
            viewGroup.getChildAt(1).setBackgroundColor(Color.argb(i, 0, 0, 0));
        } else {
            viewGroup.addView(C6754a.m30026c(activity, i));
        }
    }

    private static C6755b m30025b(Activity activity, @ColorInt int i) {
        C6755b c6755b = new C6755b(activity);
        c6755b.setLayoutParams(new LayoutParams(-1, C6754a.m30022a(activity)));
        c6755b.setBackgroundColor(i);
        return c6755b;
    }

    private static C6755b m30026c(Activity activity, int i) {
        C6755b c6755b = new C6755b(activity);
        c6755b.setLayoutParams(new LayoutParams(-1, C6754a.m30022a(activity)));
        c6755b.setBackgroundColor(Color.argb(i, 0, 0, 0));
        return c6755b;
    }

    private static int m30022a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", ResUtil.TYPE_DIMEN, "android"));
    }

    private static int m30021a(@ColorInt int i, int i2) {
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - (((float) i2) / 255.0f);
        return ((int) (((double) (f * ((float) (i & 255)))) + 0.5d)) | (((((int) (((double) (((float) ((i >> 16) & 255)) * f)) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK) | (((int) (((double) (((float) ((i >> 8) & 255)) * f)) + 0.5d)) << 8));
    }
}
