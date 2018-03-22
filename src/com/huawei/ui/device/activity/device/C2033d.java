package com.huawei.ui.device.activity.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceManagerListActivity */
class C2033d extends BroadcastReceiver {
    final /* synthetic */ DeviceManagerListActivity f7139a;

    C2033d(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7139a = deviceManagerListActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("DeviceManagerListActivity", "mDialogDismissBroadcastReceiver() intent = " + intent.getAction());
        String action = intent.getAction();
        if (action != null && action.equals("com.huawei.bone.action.ACTION_DIALOG_DISMISS")) {
            Message obtainMessage = this.f7139a.f7131u.obtainMessage();
            obtainMessage.what = 4;
            this.f7139a.f7131u.sendMessage(obtainMessage);
        }
    }
}
