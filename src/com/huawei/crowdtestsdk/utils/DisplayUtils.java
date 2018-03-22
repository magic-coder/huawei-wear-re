package com.huawei.crowdtestsdk.utils;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;

public class DisplayUtils {
    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int getViewMeasuredHeight(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }
}
