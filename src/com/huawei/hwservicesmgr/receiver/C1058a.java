package com.huawei.hwservicesmgr.receiver;

import android.content.Context;
import android.content.Intent;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C1025h;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.p190v.C2538c;

/* compiled from: ScreenReceiver */
class C1058a implements Runnable {
    final /* synthetic */ String f2078a;
    final /* synthetic */ Context f2079b;
    final /* synthetic */ ScreenReceiver f2080c;

    C1058a(ScreenReceiver screenReceiver, String str, Context context) {
        this.f2080c = screenReceiver;
        this.f2078a = str;
        this.f2079b = context;
    }

    public void run() {
        if (this.f2078a != null && this.f2078a.equals("android.intent.action.USER_PRESENT")) {
            if (C1025h.m4003a()) {
                C2538c.m12677c("ScreenReceiver", "ScreenBroadcastReceiver : has device so start PhoneService");
                Intent intent = new Intent(this.f2079b, PhoneService.class);
                intent.setAction("android.intent.action.USER_PRESENT");
                this.f2079b.startService(intent);
            } else {
                C2538c.m12677c("ScreenReceiver", "ScreenBroadcastReceiver : have no device so do not need to start PhoneService");
            }
            this.f2080c.f2076a.getLooper().quit();
        }
    }
}
