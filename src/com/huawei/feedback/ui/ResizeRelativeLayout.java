package com.huawei.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ResizeRelativeLayout extends RelativeLayout {
    private C4447a f16557a;

    public interface C4447a {
        void mo4464a(int i, int i2, int i3, int i4);
    }

    public void m21453a(C4447a c4447a) {
        this.f16557a = c4447a;
    }

    public ResizeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f16557a != null) {
            this.f16557a.mo4464a(i, i2, i3, i4);
        }
    }
}
