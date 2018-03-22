package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.huawei.crowdtestsdk.feedback.description.component.DescriptionDetailEditComponent;
import com.huawei.crowdtestsdk.feedback.widgets.FeedbackScrollView.ScrollViewListener;
import com.huawei.crowdtestsdk.feedback.widgets.ScrollLinearLayout.OnScrollChangeListener;
import com.huawei.crowdtestsdk.utils.DisplayUtils;
import com.huawei.uploadlog.p188c.C2511g;

public class FeedBackLinearLayout extends BlurBitmapLinearLayout {
    private ScrollLinearLayout linearLayoutView;
    private DescriptionDetailEditComponent mDescriptionDetailEditComponent;
    private int mDetailEditComponentMeasuredHeight;
    private FeedbackScrollView scrollView;

    class C07201 implements ScrollViewListener {
        C07201() {
        }

        public void onScrollChanged(FeedbackScrollView feedbackScrollView, int i, int i2, int i3, int i4) {
            if (FeedBackLinearLayout.this.mDescriptionDetailEditComponent != null && FeedBackLinearLayout.this.mDescriptionDetailEditComponent.hasFocus() && i4 > i2) {
                FeedBackLinearLayout.this.hideInputMethod();
            }
        }
    }

    class C07212 implements OnScrollChangeListener {
        C07212() {
        }

        public void onScrollChanged(ScrollLinearLayout scrollLinearLayout, int i, int i2, int i3, int i4) {
            if (FeedBackLinearLayout.this.mDescriptionDetailEditComponent == null) {
                return;
            }
            if (FeedBackLinearLayout.this.mDescriptionDetailEditComponent.isHasFocus()) {
                FeedBackLinearLayout.this.mDescriptionDetailEditComponent.setFocus(false);
            } else {
                FeedBackLinearLayout.this.mDescriptionDetailEditComponent.setFocus(true);
            }
        }
    }

    class C07223 implements OnTouchListener {
        C07223() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    FeedBackLinearLayout.this.hideInputMethod();
                    break;
            }
            return false;
        }
    }

    public FeedBackLinearLayout(Context context) {
        super(context);
    }

    public FeedBackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedBackLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        localInit();
        for (int i5 = 0; i5 < this.linearLayoutView.getChildCount(); i5++) {
            View childAt = this.linearLayoutView.getChildAt(i5);
            if (childAt instanceof DescriptionDetailEditComponent) {
                this.mDescriptionDetailEditComponent = (DescriptionDetailEditComponent) childAt;
                this.mDescriptionDetailEditComponent.setFocusable(true);
                this.mDetailEditComponentMeasuredHeight = childAt.getMeasuredHeight();
                scrollToLinearLayoutView();
            }
        }
        this.scrollView.setScrollViewListener(new C07201());
    }

    private void localInit() {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackLinearLayout.onSizeChanged]count:" + getChildCount());
        this.scrollView = (FeedbackScrollView) getChildAt(2);
        this.linearLayoutView = (ScrollLinearLayout) this.scrollView.getChildAt(0);
        this.linearLayoutView.setOnScrollChangeListener(new C07212());
    }

    private void scrollToLinearLayoutView() {
        int dip2px = DisplayUtils.dip2px(getContext(), 48.0f);
        if (this.mDescriptionDetailEditComponent.isHasFocus()) {
            this.linearLayoutView.scrollTo(0, dip2px + (-this.mDetailEditComponentMeasuredHeight));
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackLinearLayout.scrollToLinearLayoutView] linearLayoutView.scrollTo(0, -mDetailEditComponentMeasuredHeight + dip2px)is running");
            this.scrollView.setOnTouchListener(new C07223());
            return;
        }
        this.linearLayoutView.scrollTo(0, 0);
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackLinearLayout.scrollToLinearLayoutView]linearLayoutView.scrollTo(0, 0)is running");
    }

    public void hideInputMethod() {
        Context context = getContext();
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(((Activity) context).getWindow().getDecorView().getApplicationWindowToken(), 0);
    }
}
