package com.huawei.cp3.widget.custom.p384a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: Screen */
class C4379f {
    public static int m21040a(Context context) {
        return C4379f.m21042c(context).widthPixels;
    }

    private static DisplayMetrics m21042c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int m21041b(Context context) {
        return C4379f.m21042c(context).heightPixels;
    }
}
