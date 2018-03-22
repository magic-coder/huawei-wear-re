package com.huawei.p392h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWAddressBookManager */
class C4507d extends BroadcastReceiver {
    final /* synthetic */ C4504a f16690a;

    C4507d(C4504a c4504a) {
        this.f16690a = c4504a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWAddressBookManager", new Object[]{"mConnectStateChangedReceiver()  intent = " + intent.getAction()});
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                switch (deviceInfo.getDeviceConnectState()) {
                    case 2:
                        this.f16690a.m21577e();
                        return;
                    default:
                        return;
                }
            }
            C2538c.e("HWAddressBookManager", new Object[]{"ConnectStateChangedReceiver() deviceInfo is null"});
        }
    }
}
