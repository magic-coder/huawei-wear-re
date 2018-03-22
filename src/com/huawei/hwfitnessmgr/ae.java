package com.huawei.hwfitnessmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ae extends BroadcastReceiver {
    final /* synthetic */ q f18145a;

    ae(q qVar) {
        this.f18145a = qVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"onReceive deviceStatusReceiver:" + action});
        if (action != null && action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED")) {
            try {
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    q.a(this.f18145a, deviceInfo);
                    return;
                }
                C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"deviceStatusReceiver() deviceInfo is null"});
            } catch (ClassCastException e) {
                C2538c.a("05", 1, "HWFitnessMgr", new Object[]{" deviceStatusReceiver Exception :" + e.getMessage()});
            }
        }
    }
}
