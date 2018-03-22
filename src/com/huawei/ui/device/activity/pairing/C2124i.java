package com.huawei.ui.device.activity.pairing;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

/* compiled from: DevicePairGuideActivity */
class C2124i implements ImageGetter {
    final /* synthetic */ DevicePairGuideActivity f7529a;

    C2124i(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7529a = devicePairGuideActivity;
    }

    public Drawable getDrawable(String str) {
        Drawable drawable = this.f7529a.f7497c.getResources().getDrawable(Integer.parseInt(str));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }
}
