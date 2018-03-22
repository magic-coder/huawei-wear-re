package com.huawei.ui.device.activity.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceManagerListActivity */
class C2032c extends BroadcastReceiver {
    final /* synthetic */ DeviceManagerListActivity f7138a;

    C2032c(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7138a = deviceManagerListActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("DeviceManagerListActivity", "mConnectStateChangedBroadcastReceiver() intent = " + intent.getAction());
        String action = intent.getAction();
        if (action != null && action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (parcelableExtra != null) {
                if (parcelableExtra instanceof DeviceInfo) {
                    this.f7138a.m10619a((DeviceInfo) parcelableExtra);
                    return;
                }
                C2538c.m12677c("DeviceManagerListActivity", "! parcelableExtra instanceof DeviceInfo ");
            }
        }
    }
}
