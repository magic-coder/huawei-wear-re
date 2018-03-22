package com.huawei.ui.device.activity.adddevice;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AddDeviceActivity */
class C2006h implements OnClickListener {
    final /* synthetic */ AddDeviceActivity f7044a;

    C2006h(AddDeviceActivity addDeviceActivity) {
        this.f7044a = addDeviceActivity;
    }

    public void onClick(View view) {
        if (23 == this.f7044a.f6979D) {
            this.f7044a.m10510c(true);
            this.f7044a.f6985J.sendEmptyMessage(26);
        } else if (21 == this.f7044a.f6979D) {
            this.f7044a.m10510c(true);
            this.f7044a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 11);
        } else if (22 == this.f7044a.f6979D) {
            this.f7044a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 11);
        }
    }
}
