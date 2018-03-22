package com.huawei.hwdevicefontmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HWDeviceFontManager */
class C4982c extends BroadcastReceiver {
    final /* synthetic */ a f18065a;

    C4982c(a aVar) {
        this.f18065a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWDeviceFontManager", new Object[]{"Receive broadcast."});
        if ("com.huawei.bone.action.REFRESH_UNIT".equals(intent.getAction())) {
            C2538c.c("HWDeviceFontManager", new Object[]{"Receive unit change broadcast so set unit info to device."});
            this.f18065a.a();
        }
    }
}
