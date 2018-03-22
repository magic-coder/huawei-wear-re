package com.huawei.cp3.widget.custom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.cp3.widget.C4372a;
import huawei.android.widget.ErrorTipTextLayout;

public class HwErrorEditText extends EditText {
    int childIndex;
    LayoutParams editTextLayoutParams;
    LayoutParams errorLayoutParams;
    LinearLayout.LayoutParams errorLiLayoutParams;
    RelativeLayout.LayoutParams errorReLayoutParams;
    boolean hasReView;
    View mErrorTipView;

    public HwErrorEditText(Context context) {
        this(context, null);
    }

    public HwErrorEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public HwErrorEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasReView = false;
        this.childIndex = -1;
        if (C4372a.m21003c()) {
            this.mErrorTipView = new ErrorTipTextLayout(context);
            this.editTextLayoutParams = new LayoutParams(-1, -2);
            this.errorLayoutParams = new LayoutParams(-1, -2);
            this.errorReLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.errorLiLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
    }

    private void reView() {
        int i = 0;
        if (!this.hasReView) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (viewGroup.getChildAt(i2) == this) {
                        this.childIndex = i2;
                        break;
                    }
                }
                if (getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                    this.editTextLayoutParams.height = layoutParams.height;
                    this.editTextLayoutParams.width = layoutParams.width;
                    this.errorReLayoutParams.height = layoutParams.height;
                    this.errorReLayoutParams.width = layoutParams.width;
                    this.errorReLayoutParams.alignWithParent = layoutParams.alignWithParent;
                    this.errorReLayoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    int[] rules = layoutParams.getRules();
                    while (i < rules.length) {
                        this.errorReLayoutParams.addRule(i, rules[i]);
                        i++;
                    }
                    this.errorLayoutParams = this.errorReLayoutParams;
                } else if (getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getLayoutParams();
                    this.editTextLayoutParams.height = layoutParams2.height;
                    this.editTextLayoutParams.width = layoutParams2.width;
                    this.errorLiLayoutParams.height = layoutParams2.height;
                    this.errorLiLayoutParams.width = layoutParams2.width;
                    this.errorLiLayoutParams.gravity = layoutParams2.gravity;
                    this.errorLiLayoutParams.weight = layoutParams2.weight;
                    this.errorLiLayoutParams.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    this.errorLayoutParams = this.errorLiLayoutParams;
                }
                if (-1 != this.childIndex && this.mErrorTipView != null) {
                    this.hasReView = true;
                    viewGroup.addView((ViewGroup) this.mErrorTipView, this.childIndex, this.errorLayoutParams);
                    viewGroup.removeViewAt(this.childIndex + 1);
                    ((ViewGroup) this.mErrorTipView).addView(this, this.editTextLayoutParams);
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (C4372a.m21003c()) {
            reView();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!C4372a.m21003c() || this.mErrorTipView == null) {
            super.setError(charSequence);
        } else {
            ((ErrorTipTextLayout) this.mErrorTipView).setError(charSequence);
        }
    }

    public CharSequence getError() {
        if (!C4372a.m21003c()) {
            return super.getError();
        }
        if (this.mErrorTipView != null) {
            return ((ErrorTipTextLayout) this.mErrorTipView).getError();
        }
        return null;
    }

    public void resetErrorChangedFlag() {
        super.resetErrorChangedFlag();
        if (getError() != null) {
            setError(null);
        }
    }
}
