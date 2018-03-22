package com.huawei.ui.device.views.device;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceListAdapter */
class C2200f implements OnClickListener {
    final /* synthetic */ int f7871a;
    final /* synthetic */ C2198d f7872b;

    C2200f(C2198d c2198d, int i) {
        this.f7872b = c2198d;
        this.f7871a = i;
    }

    public void onClick(View view) {
        C2538c.m12677c("DeviceListAdapter", "onBindViewHolder():mBtnDel");
        this.f7872b.f7867f.sendMessage(this.f7872b.f7867f.obtainMessage(3, Integer.valueOf(this.f7871a)));
    }
}
