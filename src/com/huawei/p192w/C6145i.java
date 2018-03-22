package com.huawei.p192w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.w.c;

/* compiled from: HWMultiSimMgr */
class C6145i extends BroadcastReceiver {
    final /* synthetic */ c f21195a;

    C6145i(c cVar) {
        this.f21195a = cVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.c("HWMultiSimMgr", new Object[]{"onReceive deviceStatusReceiver:" + action});
        if (action != null && action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED")) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                C2538c.c("HWMultiSimMgr", new Object[]{"handleDeviceConnection enter"});
                int deviceConnectState = deviceInfo.getDeviceConnectState();
                C2538c.c("HWMultiSimMgr", new Object[]{"device Connect state = " + deviceConnectState});
                if (2 != deviceConnectState) {
                    c.b(this.f21195a).removeMessages(0);
                    c.b(this.f21195a).removeMessages(1);
                    c.b(this.f21195a).removeMessages(2);
                    c.b(this.f21195a).removeMessages(3);
                    c.a(this.f21195a, 1, 100001, Integer.valueOf(-2));
                    c.a(this.f21195a, 2, -1, Integer.valueOf(-2));
                    c.a(this.f21195a, 3, 100001, Integer.valueOf(-2));
                    c.a(this.f21195a, 4, -1, Integer.valueOf(-2));
                } else {
                    if (c.b(this.f21195a).hasMessages(4)) {
                        C2538c.c("HWMultiSimMgr", new Object[]{"mHandler.hasMessages MULTI_SIM_WAIT_QUERY_CONN_TIMEOUT_MSG"});
                        c.b(this.f21195a).removeMessages(4);
                        this.f21195a.c();
                    }
                    c.d(this.f21195a);
                }
                synchronized (c.e(this.f21195a)) {
                    for (IBaseResponseCallback onResponse : c.e(this.f21195a)) {
                        onResponse.onResponse(deviceConnectState, null);
                    }
                }
                return;
            }
            C2538c.e("HWMultiSimMgr", new Object[]{"mBTConnectStatus() deviceInfo is null"});
        }
    }
}
