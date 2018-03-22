package com.huawei.ui.homewear21.card.p176a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;

/* compiled from: HeartRateStatusInteractors */
class C2253k extends BroadcastReceiver {
    final /* synthetic */ C2247e f8190a;

    C2253k(C2247e c2247e) {
        this.f8190a = c2247e;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            C2538c.m12677c("HeartRateStatusInteractors", "mConnectStateChangedReceiver() action = " + intent.getAction());
            if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    C2538c.m12677c("HeartRateStatusInteractors", "mConnectStateChangedReceiver() status = " + deviceInfo.getDeviceConnectState());
                    try {
                        switch (deviceInfo.getDeviceConnectState()) {
                            case 2:
                                this.f8190a.m11641o();
                                return;
                            case 3:
                                deviceInfo = C1204c.m5370a(this.f8190a.f8177h).m5447c();
                                if (deviceInfo != null && 11 == deviceInfo.getProductType()) {
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e) {
                        C2538c.m12680e("HeartRateStatusInteractors", e.getMessage());
                    }
                    C2538c.m12680e("HeartRateStatusInteractors", e.getMessage());
                }
            }
        }
    }
}
