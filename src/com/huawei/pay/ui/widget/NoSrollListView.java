package com.huawei.pay.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class NoSrollListView extends ListView {
    public NoSrollListView(Context context) {
        super(context);
    }

    public NoSrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoSrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
