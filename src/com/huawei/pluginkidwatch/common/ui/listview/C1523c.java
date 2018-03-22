package com.huawei.pluginkidwatch.common.ui.listview;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1617f;

/* compiled from: PariedDevicesSwitcher */
class C1523c implements OnClickListener {
    final /* synthetic */ PariedDevicesSwitcher f3607a;

    C1523c(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f3607a = pariedDevicesSwitcher;
    }

    public void onClick(View view) {
        if (this.f3607a.getFocus()) {
            this.f3607a.f3587b.setImageResource(C1617f.commonui_top_botton_list);
            if (this.f3607a.f3594i != null) {
                this.f3607a.f3594i.mo2559a(view);
            }
            this.f3607a.m7020a(view);
            this.f3607a.setFocus(false);
            return;
        }
        this.f3607a.clearAnimation();
    }
}
