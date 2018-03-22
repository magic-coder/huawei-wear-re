package com.huawei.hwfitnessmgr.receiver;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: SendDataToDeviceBroadcastReceiver */
class C1027a implements IBaseResponseCallback {
    final /* synthetic */ SendDataToDeviceBroadcastReceiver f1914a;

    C1027a(SendDataToDeviceBroadcastReceiver sendDataToDeviceBroadcastReceiver) {
        this.f1914a = sendDataToDeviceBroadcastReceiver;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("SendDataToDeviceBroadcastReceiver", "setHeartZoneConfig onResponse err_code = " + i);
        if (i == 0 && obj != null) {
            C2538c.m12677c("SendDataToDeviceBroadcastReceiver", "setHeartZoneConfig onResponse objData = " + obj.toString());
        }
    }
}
