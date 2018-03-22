package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneService */
final class C1065z implements DeathRecipient {
    public final IBinder f2088a;
    public final String f2089b;
    public final String f2090c;
    final /* synthetic */ PhoneService f2091d;

    public C1065z(PhoneService phoneService, IBinder iBinder, String str, String str2) {
        this.f2091d = phoneService;
        this.f2088a = iBinder;
        this.f2089b = str;
        this.f2090c = str2;
    }

    public void binderDied() {
        if (this.f2091d.f1941i.indexOf(this) >= 0) {
            C2538c.m12677c("PhoneService", "client died: " + this.f2089b);
            this.f2091d.f1941i.remove(this);
            this.f2091d.f1946p.execute(new aa(this));
        }
    }

    private boolean m4501a() {
        int i = 0;
        while (i < this.f2091d.f1941i.size()) {
            if (((C1065z) this.f2091d.f1941i.get(i)).f2089b.equals(this.f2089b) && ((C1065z) this.f2091d.f1941i.get(i)).f2090c.equals(this.f2090c)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
