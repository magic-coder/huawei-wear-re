package com.huawei.hwdevicemgr.p073a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceMgr */
class C4988g extends BroadcastReceiver {
    final /* synthetic */ C1023c f18071a;

    C4988g(C1023c cVar) {
        this.f18071a = cVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if ("android.intent.action.TIMEZONE_CHANGED".equals(intent.getAction()) || "android.intent.action.TIME_SET".equals(intent.getAction()) || "android.intent.action.DATE_CHANGED".equals(intent.getAction())) {
            C4625b a;
            C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"System Time changed with type : " + intent.getAction() + " and with connect state : " + C1023c.g(this.f18071a)});
            if (C1023c.j(this.f18071a) == 0) {
                a = C4610m.m21963a(C1023c.b(this.f18071a));
            } else {
                a = C4610m.m21980b();
            }
            if (C1023c.m(this.f18071a).length() != 0 && 2 == C1023c.g(this.f18071a)) {
                a.m22109a(C1023c.m(this.f18071a));
                if (C1023c.i(this.f18071a) != null) {
                    C2538c.a("02", 0, "HWDeviceMgr", new Object[]{"Start to set device time when system change."});
                    C1023c.i(this.f18071a).a(a);
                }
            }
        }
    }
}
