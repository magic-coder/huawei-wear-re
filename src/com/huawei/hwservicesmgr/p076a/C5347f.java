package com.huawei.hwservicesmgr.p076a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.a.e;
import com.huawei.p190v.C2538c;

/* compiled from: NotifySendData */
class C5347f extends BroadcastReceiver {
    final /* synthetic */ e f19087a;

    C5347f(e eVar) {
        this.f19087a = eVar;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("NotifySendData", new Object[]{"mConnectStateChangedReceiver() context = " + context + " intent = " + intent.getAction()});
        if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            e.a(this.f19087a, true);
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                C2538c.c("NotifySendData", new Object[]{"mConnectStateChangedReceiver() getDeviceConnectState = " + deviceInfo.getDeviceConnectState()});
                if (2 == deviceInfo.getDeviceConnectState()) {
                    e.a(this.f19087a);
                    e.b(this.f19087a);
                    return;
                }
                return;
            }
            C2538c.e("NotifySendData", new Object[]{"mConnectStateChangedReceiver() deviceInfo is null"});
        }
    }
}
