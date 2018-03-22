package com.huawei.pluginaf500.connect_ble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;

/* compiled from: AF500DeviceMgr */
class C5779e extends BroadcastReceiver {
    final /* synthetic */ C5775a f19617a;

    C5779e(C5775a c5775a) {
        this.f19617a = c5775a;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) && this.f19617a.f19603d != null) {
            C2538c.c("AF500DeviceMgr", new Object[]{"Receive BT Switch = " + this.f19617a.f19603d.getState()});
            switch (this.f19617a.f19603d.getState()) {
                case 12:
                    C2538c.c("AF500DeviceMgr", new Object[]{"Receive BT Switch is on."});
                    if (this.f19617a.m26564e() && !TextUtils.isEmpty(this.f19617a.f19604e)) {
                        C2538c.c("AF500DeviceMgr", new Object[]{"Start to connect AF500 device with address = " + this.f19617a.f19604e});
                        this.f19617a.m26557a(this.f19617a.f19604e, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
