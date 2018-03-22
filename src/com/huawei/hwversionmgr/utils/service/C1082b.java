package com.huawei.hwversionmgr.utils.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateService */
class C1082b extends BroadcastReceiver {
    final /* synthetic */ UpdateService f2200a;

    C1082b(UpdateService updateService) {
        this.f2200a = updateService;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            C2538c.m12677c("UpdateService", "Batrery level = " + intent.getIntExtra("level", 0));
            if (this.f2200a.f2185j < 0) {
                this.f2200a.f2185j = r0;
                if (this.f2200a.f2185j < 10) {
                    C2538c.m12677c("UpdateService", "Batrery mBatteryLevel = " + this.f2200a.f2185j);
                    this.f2200a.m4624a(22, 4);
                    this.f2200a.stopSelf();
                    return;
                }
                C2538c.m12677c("UpdateService", "Batrery check ok! ");
                if (this.f2200a.f2188m == 2 || this.f2200a.f2188m == 0) {
                    this.f2200a.f2176a.m4541a(this.f2200a.f2198w, Boolean.valueOf(true));
                    return;
                } else {
                    this.f2200a.f2176a.m4541a(this.f2200a.f2198w, Boolean.valueOf(false));
                    return;
                }
            }
            C2538c.m12677c("UpdateService", "unregisterReceiver mGetPhoneBatteryReceiver ");
            this.f2200a.f2177b.unregisterReceiver(this.f2200a.f2192q);
        }
    }
}
