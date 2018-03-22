package com.huawei.ui.device.activity.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceManagerListActivity */
class C2031b extends BroadcastReceiver {
    final /* synthetic */ DeviceManagerListActivity f7137a;

    C2031b(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7137a = deviceManagerListActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("DeviceManagerListActivity", "Enter mDeviceListChangedReceiver()：");
        if (context == null) {
            return;
        }
        if ("com.huawei.bone.action.DEVICE_LIST_CHANGED".equals(intent.getAction()) || "com.huawei.bone.action.ACTION_GET_KIDWATCH_SUCCESS".equals(intent.getAction())) {
            C2538c.m12677c("DeviceManagerListActivity", " mDeviceListChangedReceiver():列表发生变化，更新deviceRecyclerView." + intent.getAction());
            Message obtainMessage = this.f7137a.f7131u.obtainMessage();
            obtainMessage.what = 2;
            this.f7137a.f7131u.sendMessage(obtainMessage);
        }
    }
}
