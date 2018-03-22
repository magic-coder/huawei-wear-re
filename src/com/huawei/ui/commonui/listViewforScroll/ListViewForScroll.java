package com.huawei.ui.commonui.listViewforScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class ListViewForScroll extends ListView {
    public ListViewForScroll(Context context) {
        super(context);
    }

    public ListViewForScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
