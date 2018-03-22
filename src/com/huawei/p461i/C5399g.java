package com.huawei.p461i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWAlarmManager */
class C5399g extends BroadcastReceiver {
    final /* synthetic */ C5393a f19215a;

    C5399g(C5393a c5393a) {
        this.f19215a = c5393a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWAlarmManager", new Object[]{"mConnectStateChangedReceiver() context = " + context + " intent = " + intent.getAction()});
        if (context == null) {
            C2538c.c("HWAlarmManager", new Object[]{"mConnectStateChangedReceiver() context is null "});
        } else if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                this.f19215a.f19200q = deviceInfo.getDeviceConnectState();
                switch (deviceInfo.getDeviceConnectState()) {
                    case 2:
                        String k = this.f19215a.f19194e.k();
                        String deviceIdentify = deviceInfo.getDeviceIdentify();
                        C2538c.c("HWAlarmManager", new Object[]{"curIdentify = " + deviceIdentify, ", getSharedPreference lastIdentify = " + k});
                        if (k.equalsIgnoreCase(deviceIdentify)) {
                            C2538c.c("HWAlarmManager", new Object[]{"alarm, same device, don't need send alarm"});
                        } else {
                            this.f19215a.m25976o();
                        }
                        this.f19215a.f19194e.a(deviceIdentify);
                        return;
                    default:
                        return;
                }
            }
            C2538c.e("HWAlarmManager", new Object[]{"mConnectStateChangedReceiver() deviceInfo is null "});
        }
    }
}
