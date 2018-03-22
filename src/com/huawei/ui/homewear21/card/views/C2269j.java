package com.huawei.ui.homewear21.card.views;

import android.widget.PopupWindow.OnDismissListener;

/* compiled from: PariedDevicesSwitcher */
class C2269j implements OnDismissListener {
    final /* synthetic */ PariedDevicesSwitcher f8251a;

    C2269j(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f8251a = pariedDevicesSwitcher;
    }

    public void onDismiss() {
        this.f8251a.setFocus(true);
    }
}
