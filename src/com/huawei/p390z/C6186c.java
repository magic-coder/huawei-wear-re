package com.huawei.p390z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWPayManager */
class C6186c extends BroadcastReceiver {
    final /* synthetic */ C6184a f21703a;

    C6186c(C6184a c6184a) {
        this.f21703a = c6184a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWPayManager", new Object[]{" HWPayManager connectedChanged mNonLocalBroadcastReceiver(): intent = " + intent.getAction()});
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (parcelableExtra == null || !(parcelableExtra instanceof DeviceInfo)) {
                C2538c.e("HWPayManager", new Object[]{"deviceInfo is null 2!"});
                return;
            }
            int deviceConnectState = ((DeviceInfo) parcelableExtra).getDeviceConnectState();
            C2538c.b("HWPayManager", new Object[]{"connectedChanged(): " + r0.getDeviceName() + ",state = " + deviceConnectState});
            if (2 != deviceConnectState) {
                for (Integer intValue : C6184a.f21695g) {
                    this.f21703a.m28629a(intValue.intValue(), 100001, Integer.valueOf(-1));
                }
            }
            if (this.f21703a.f21697c != null) {
                this.f21703a.f21697c.mo4466a(deviceConnectState);
                return;
            }
            return;
        }
        C2538c.e("HWPayManager", new Object[]{"deviceInfo is null!"});
    }
}
