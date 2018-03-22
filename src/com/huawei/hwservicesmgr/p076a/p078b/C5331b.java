package com.huawei.hwservicesmgr.p076a.p078b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.p076a.p078b.p459a.C5326c;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileServicesManager */
class C5331b extends BroadcastReceiver {
    final /* synthetic */ C5330a f19072a;

    C5331b(C5330a c5330a) {
        this.f19072a = c5330a;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                C2538c.c("HWFileServicesManager", new Object[]{"mConnectStateChangedReceiver() status = " + deviceInfo.getDeviceConnectState()});
                switch (deviceInfo.getDeviceConnectState()) {
                    case 3:
                        C5326c.m25785m();
                        return;
                    case 4:
                        C5326c.m25785m();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
