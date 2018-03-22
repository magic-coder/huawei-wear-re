package com.huawei.ui.homewear21.card.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: PariedDevicesSwitcher */
class C2270k implements OnClickListener {
    final /* synthetic */ int f8252a;
    final /* synthetic */ PariedDevicesSwitcher f8253b;

    C2270k(PariedDevicesSwitcher pariedDevicesSwitcher, int i) {
        this.f8253b = pariedDevicesSwitcher;
        this.f8252a = i;
    }

    public void onClick(View view) {
        C2538c.m12677c(PariedDevicesSwitcher.f8209b, "showReplaceDeviceDialog():点击同意切换设备，开始连接！");
        this.f8253b.m11661a(this.f8252a);
    }
}
