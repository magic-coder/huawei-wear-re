package com.huawei.pluginkidwatch.common.ui.listview;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PariedDevicesSwitcher */
class C1524d implements OnClickListener {
    final /* synthetic */ PariedDevicesSwitcher f3608a;

    C1524d(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f3608a = pariedDevicesSwitcher;
    }

    public void onClick(View view) {
        C2538c.m12674b("PariedDevicesSwitcher", "titleSpace", " setOnClickListener");
        if (this.f3608a.f3591f != null) {
            this.f3608a.m7024b();
        }
    }
}
