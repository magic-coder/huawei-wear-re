package com.huawei.hwservicesmgr.p076a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hwservicesmgr.a.h;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneListManager */
class C5350j extends BroadcastReceiver {
    final /* synthetic */ h f19094a;

    C5350j(h hVar) {
        this.f19094a = hVar;
    }

    public void onReceive(Context context, Intent intent) {
        CharSequence action = intent.getAction();
        C2538c.c("PhoneListManager", new Object[]{"midware onReceive: action = " + action});
        if (action != null && TextUtils.equals(action, "midware_phone_flag")) {
            h.a(this.f19094a, intent.getBooleanExtra("phone_flag", false));
            C2538c.c("PhoneListManager", new Object[]{"PhoneForbiddenn = " + h.c(this.f19094a)});
        }
    }
}
