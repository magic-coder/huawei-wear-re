package com.huawei.crowdtestsdk.feedback.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class FeedbackScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener = null;

    public interface ScrollViewListener {
        void onScrollChanged(FeedbackScrollView feedbackScrollView, int i, int i2, int i3, int i4);
    }

    public FeedbackScrollView(Context context) {
        super(context);
    }

    public FeedbackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedbackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.scrollViewListener != null) {
            this.scrollViewListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }
}
