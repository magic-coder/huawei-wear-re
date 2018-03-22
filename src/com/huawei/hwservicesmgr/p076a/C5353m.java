package com.huawei.hwservicesmgr.p076a;

import android.telephony.PhoneStateListener;
import com.huawei.hwservicesmgr.a.h;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneListManager */
class C5353m extends PhoneStateListener {
    final /* synthetic */ h f19097a;

    C5353m(h hVar) {
        this.f19097a = hVar;
    }

    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        if (h.d(this.f19097a)) {
            C2538c.b("PhoneListManager", new Object[]{"onCallStateChanged() has READ_PHONE_STATE permission "});
        }
        C2538c.c("PhoneListManager", new Object[]{"onCallStateChanged() state--------------------" + i});
        C2538c.c("PhoneListManager", new Object[]{"onCallStateChanged() incomingNumber-----------" + str});
        if (i == 1) {
            h.a(this.f19097a, str);
        } else {
            h.e(this.f19097a);
        }
    }
}
