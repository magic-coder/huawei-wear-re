package com.huawei.crowdtestsdk.feedback.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ScrollLinearLayout extends LinearLayout {
    private OnScrollChangeListener onScrollChangeListener;

    public interface OnScrollChangeListener {
        void onScrollChanged(ScrollLinearLayout scrollLinearLayout, int i, int i2, int i3, int i4);
    }

    public ScrollLinearLayout(Context context) {
        super(context);
    }

    public ScrollLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.onScrollChangeListener != null) {
            this.onScrollChangeListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }
}
