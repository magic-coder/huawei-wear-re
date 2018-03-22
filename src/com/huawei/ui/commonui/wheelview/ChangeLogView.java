package com.huawei.ui.commonui.wheelview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;

public class ChangeLogView extends ScrollView {
    private Context f20851a;

    public ChangeLogView(Context context) {
        super(context);
        m27659a(context);
    }

    public ChangeLogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27659a(context);
    }

    public ChangeLogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27659a(context);
    }

    private void m27659a(Context context) {
        this.f20851a = context;
    }

    protected void onMeasure(int i, int i2) {
        Display defaultDisplay = ((Activity) this.f20851a).getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 3, Integer.MIN_VALUE));
    }
}
