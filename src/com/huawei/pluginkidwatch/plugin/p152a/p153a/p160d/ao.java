package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiWearableDeviceImpl */
class ao extends BroadcastReceiver {
    final /* synthetic */ an f4469a;

    ao(an anVar) {
        this.f4469a = anVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.bluetooth.device.action.FOUND".equals(action)) {
            this.f4469a.m7924a(intent);
        } else if ("android.bluetooth.device.action.UUID".equals(action)) {
            this.f4469a.m7931b(intent);
        } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
            C2538c.m12674b("HuaweiWearableDeviceImpl", "Finished classic device discovery.");
            this.f4469a.m7953j();
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            this.f4469a.m7946f();
        } else if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
            this.f4469a.m7938c(intent);
        }
    }
}
