package com.huawei.ui.device.activity.pairing;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: DevicePairGuideActivity */
class C2116a implements OnGlobalLayoutListener {
    final /* synthetic */ DevicePairGuideActivity f7521a;

    C2116a(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7521a = devicePairGuideActivity;
    }

    public void onGlobalLayout() {
        int width = this.f7521a.f7481M.getWidth();
        LayoutParams layoutParams = this.f7521a.f7486R.getLayoutParams();
        layoutParams.height = width;
        this.f7521a.f7486R.setLayoutParams(layoutParams);
    }
}
