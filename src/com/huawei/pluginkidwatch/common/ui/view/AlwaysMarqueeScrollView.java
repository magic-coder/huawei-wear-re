package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class AlwaysMarqueeScrollView extends TextView {
    public AlwaysMarqueeScrollView(Context context) {
        super(context);
    }

    public AlwaysMarqueeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlwaysMarqueeScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isFocused() {
        return true;
    }
}
