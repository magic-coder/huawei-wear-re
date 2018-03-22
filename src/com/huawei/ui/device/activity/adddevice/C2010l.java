package com.huawei.ui.device.activity.adddevice;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.views.p172a.C2187c;

/* compiled from: AddDeviceActivity */
class C2010l implements OnClickListener {
    C2187c f7048a;
    final /* synthetic */ AddDeviceActivity f7049b;

    public C2010l(AddDeviceActivity addDeviceActivity, C2187c c2187c) {
        this.f7049b = addDeviceActivity;
        this.f7048a = c2187c;
    }

    public void onClick(View view) {
        C2538c.m12677c("AddDeviceActivity", "MyOnClickListener(): item.getID()=" + this.f7048a.m11202a());
        this.f7049b.f6985J.sendEmptyMessage(13);
        this.f7049b.f6999d = this.f7048a.m11202a();
        this.f7049b.m10537r();
    }
}
