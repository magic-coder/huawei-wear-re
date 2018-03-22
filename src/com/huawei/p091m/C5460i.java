package com.huawei.p091m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

/* compiled from: HwCoreSleepMgr */
class C5460i extends BroadcastReceiver {
    final /* synthetic */ d f19307a;

    C5460i(d dVar) {
        this.f19307a = dVar;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HwCoreSleepMgr", new Object[]{"mConnectStateChangedReceiver(): intent = " + intent.getAction()});
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (parcelableExtra == null || !(parcelableExtra instanceof DeviceInfo)) {
                C2538c.c("HwCoreSleepMgr", new Object[]{"mConnectStateChangedReceiver(): cast error"});
                return;
            }
            C2538c.c("HwCoreSleepMgr", new Object[]{"mConnectStateChangedReceiver(): " + r0.getDeviceName() + ",state = " + ((DeviceInfo) parcelableExtra).getDeviceConnectState()});
            if (((DeviceInfo) parcelableExtra).getDeviceConnectState() == 3) {
                C2538c.c("HwCoreSleepMgr", new Object[]{" bt disconnect, coreSleepSyncFlag =  " + this.f19307a.b});
                if (2 == this.f19307a.b) {
                    d.a(this.f19307a, false);
                    d.b(this.f19307a, false);
                    d.a(this.f19307a);
                    d.b(this.f19307a);
                }
            }
        }
    }
}
