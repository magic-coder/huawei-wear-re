package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class SerialListView extends ListView {
    public SerialListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SerialListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SerialListView(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
