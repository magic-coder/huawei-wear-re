package com.huawei.p510u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWLinkLossAlarmManager */
class C5980c extends BroadcastReceiver {
    final /* synthetic */ C5978a f20583a;

    C5980c(C5978a c5978a) {
        this.f20583a = c5978a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWLinkLossAlarmManager", new Object[]{"mConnectStateChangedReceiver() context = " + context + " intent = " + intent.getAction()});
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                switch (deviceInfo.getDeviceConnectState()) {
                    case 2:
                        this.f20583a.m27408e();
                        return;
                    default:
                        return;
                }
            }
            C2538c.e("HWLinkLossAlarmManager", new Object[]{"mConnectStateChangedReceiver() deviceInfo is null"});
        }
    }
}
