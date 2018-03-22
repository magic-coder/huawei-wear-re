package com.huawei.pluginkidwatch.common.ui.listview;

import android.widget.PopupWindow.OnDismissListener;
import com.huawei.pluginkidwatch.C1617f;

/* compiled from: PariedDevicesSwitcher */
class C1525e implements OnDismissListener {
    final /* synthetic */ PariedDevicesSwitcher f3609a;

    C1525e(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f3609a = pariedDevicesSwitcher;
    }

    public void onDismiss() {
        this.f3609a.f3587b.setImageResource(C1617f.commonui_down_botton_list);
        this.f3609a.setFocus(true);
    }
}
