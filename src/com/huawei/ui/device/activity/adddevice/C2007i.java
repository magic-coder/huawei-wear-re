package com.huawei.ui.device.activity.adddevice;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: AddDeviceActivity */
class C2007i implements OnItemClickListener {
    final /* synthetic */ AddDeviceActivity f7045a;

    C2007i(AddDeviceActivity addDeviceActivity) {
        this.f7045a = addDeviceActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12661a("01", 0, "AddDeviceActivity", "onItemClick: id is " + j);
        this.f7045a.f6985J.sendEmptyMessage(13);
        C2538c.m12661a("01", 0, "AddDeviceActivity", "onItemClick: btSwitchState is " + this.f7045a.f7015t.c());
        if (3 == this.f7045a.f7015t.c()) {
            this.f7045a.m10485a(j);
        } else {
            this.f7045a.f6985J.sendEmptyMessage(28);
        }
    }
}
