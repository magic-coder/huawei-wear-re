package com.huawei.ui.device.activity.device;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: DeviceManagerListActivity */
class C2030a implements OnCancelListener {
    final /* synthetic */ DeviceManagerListActivity f7136a;

    C2030a(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7136a = deviceManagerListActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f7136a.f7122l = null;
    }
}
