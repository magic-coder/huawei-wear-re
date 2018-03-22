package com.huawei.hwdevicefontmgr;

import android.content.Context;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C1025h;
import com.huawei.p190v.C2538c;

/* compiled from: LanguageChangedBR */
class C1022d implements Runnable {
    final /* synthetic */ Context f1827a;
    final /* synthetic */ LanguageChangedBR f1828b;

    C1022d(LanguageChangedBR languageChangedBR, Context context) {
        this.f1828b = languageChangedBR;
        this.f1827a = context;
    }

    public void run() {
        if (C1025h.m4003a()) {
            C1021a.m3912a(this.f1827a).m3915b();
        } else {
            C2538c.m12677c("LanguageChangedBR", "ScreenBroadcastReceiver : have no device so do not need to start PhoneService");
        }
        this.f1828b.f1820a.getLooper().quit();
    }
}
