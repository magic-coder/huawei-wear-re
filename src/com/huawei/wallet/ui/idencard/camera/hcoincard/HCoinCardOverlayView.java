package com.huawei.wallet.ui.idencard.camera.hcoincard;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.huawei.b.d;
import com.huawei.wallet.ui.idencard.camera.base.BaseOverlayView;

public class HCoinCardOverlayView extends BaseOverlayView {
    public HCoinCardOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void mo5181a() {
        super.mo5181a();
        this.a = m28386a(getContext(), 2.0f);
        this.b = m28386a(getContext(), 24.0f);
        this.d = m28386a(getContext(), 2.0f);
        this.c = m28386a(getContext(), 0.0f);
        this.e = 0.5f;
    }

    protected Rect mo5180a(int i, int i2) {
        int dimensionPixelSize = i - (getResources().getDimensionPixelSize(d.camera_hcoincard_tips_margin_left_or_right) * 2);
        int i3 = dimensionPixelSize / 5;
        int i4 = (i - dimensionPixelSize) / 2;
        int i5 = (i2 - i3) / 2;
        return new Rect(i4, i5, dimensionPixelSize + i4, i3 + i5);
    }
}
