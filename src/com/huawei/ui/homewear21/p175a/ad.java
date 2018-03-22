package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.ui.homewear21.card.p176a.C2243a;

/* compiled from: HomeFragment */
class ad extends BroadcastReceiver {
    final /* synthetic */ C2217a f8045a;

    ad(C2217a c2217a) {
        this.f8045a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.huawei.bone.action.BATTERY_LEVEL".equals(intent.getAction())) {
            if (intent.getExtras() != null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "电量刷新广播接收到，refreshBattery =" + intent.getExtras().getInt("BATTERY_LEVEL"));
                this.f8045a.m11502d(r0);
                if (this.f8045a.f8009R) {
                    C2538c.m12661a("MainUI", 0, "HomeFragment", " isConnected is true");
                    return;
                }
                this.f8045a.ag = C2243a.m11601a().m11614c();
                if (this.f8045a.ag != null) {
                    if (2 == this.f8045a.ag.getDeviceConnectState()) {
                        this.f8045a.f8009R = true;
                    } else {
                        this.f8045a.f8009R = false;
                    }
                    C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter mDeviceBatteryRefreshReceiver  isConnected:" + this.f8045a.f8009R + " state:" + this.f8045a.ag.getDeviceConnectState());
                    if (this.f8045a.f8009R) {
                        this.f8045a.ai();
                        return;
                    }
                    return;
                }
                C2538c.m12661a("MainUI", 0, "HomeFragment", " current is null");
                return;
            }
            C2538c.m12680e("HomeFragment", "intent.getExtra() is null!");
        }
    }
}
