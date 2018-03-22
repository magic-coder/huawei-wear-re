package com.huawei.hwservicesmgr.p076a.p077a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.a.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWEphemerisManager */
class C5322c extends BroadcastReceiver {
    final /* synthetic */ a f19053a;

    C5322c(a aVar) {
        this.f19053a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            C2538c.c("HWEphemerisManager", new Object[]{"connectStateChangedReceiver() action = " + intent.getAction()});
            if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    C2538c.c("HWEphemerisManager", new Object[]{"ConnectStateChangedReceiver() status = " + deviceInfo.getDeviceConnectState()});
                    switch (deviceInfo.getDeviceConnectState()) {
                        case 3:
                            a.a(this.f19053a, 1);
                            a.j(this.f19053a);
                            a.c(this.f19053a, false);
                            return;
                        default:
                            return;
                    }
                }
            } else if ("com.huawei.bone.ephemeris.checkUpdate".equals(intent.getAction())) {
                if (a.k(this.f19053a) != null) {
                    a.k(this.f19053a).removeMessages(4);
                }
                if (-1 != a.h(this.f19053a)) {
                    a.b(this.f19053a, false);
                    a.a(this.f19053a, "com.huawei.bone.ephemeris.currentState.updating");
                    return;
                }
                a.b(this.f19053a, true);
                if (a.k(this.f19053a) != null) {
                    a.k(this.f19053a).sendEmptyMessageDelayed(4, 9000);
                }
            } else if (("com.huawei.bone.ephemeris.currentState.update.sucess".equals(intent.getAction()) || "com.huawei.bone.ephemeris.currentState.update.fail".equals(intent.getAction())) && 3 == a.h(this.f19053a)) {
                a.b(this.f19053a, -1);
                if (a.k(this.f19053a) != null) {
                    a.k(this.f19053a).removeMessages(3);
                }
            }
        }
    }
}
