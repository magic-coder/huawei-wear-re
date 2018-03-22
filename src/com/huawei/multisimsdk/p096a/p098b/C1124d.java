package com.huawei.multisimsdk.p096a.p098b;

import android.os.IBinder.DeathRecipient;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;

/* compiled from: AttachedDeviceManager */
class C1124d implements DeathRecipient {
    final /* synthetic */ C1119a f2381a;

    C1124d(C1119a c1119a) {
        this.f2381a = c1119a;
    }

    public void binderDied() {
        C1119a.f2368k = 1;
        C1183h.m5286d("AttachedDeviceManager", "MultiSimService binderDied.");
        if (this.f2381a.f2372d == null) {
            C1183h.m5286d("AttachedDeviceManager", "Binder is null.");
            C1119a.f2368k = 2;
            this.f2381a.m4997b(C1119a.f2368k);
            return;
        }
        this.f2381a.f2372d.asBinder().unlinkToDeath(this.f2381a.f2378n, 0);
        this.f2381a.f2373e = null;
        this.f2381a.m5008c();
    }
}
