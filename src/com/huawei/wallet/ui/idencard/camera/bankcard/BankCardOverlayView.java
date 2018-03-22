package com.huawei.wallet.ui.idencard.camera.bankcard;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.huawei.b.d;
import com.huawei.wallet.ui.idencard.camera.base.BaseOverlayView;

public class BankCardOverlayView extends BaseOverlayView {
    public BankCardOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void mo5181a() {
        super.mo5181a();
        this.a = m28386a(getContext(), 2.0f);
        this.b = m28386a(getContext(), 24.0f);
        this.d = m28386a(getContext(), 2.0f);
        this.e = 0.6f;
    }

    protected Rect mo5180a(int i, int i2) {
        int dimensionPixelSize = i - (getResources().getDimensionPixelSize(d.camera_bankcard_tips_margin_left_or_right) * 2);
        int i3 = (dimensionPixelSize * 2) / 3;
        int i4 = (i - dimensionPixelSize) / 2;
        int i5 = (i2 - i3) / 2;
        return new Rect(i4, i5, dimensionPixelSize + i4, i3 + i5);
    }
}
