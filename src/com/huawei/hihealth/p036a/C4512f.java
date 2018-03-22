package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.az;

/* compiled from: HiHealthNativeAPI */
class C4512f extends az {
    final /* synthetic */ C4511e f16708a;

    C4512f(C4511e c4511e) {
        this.f16708a = c4511e;
    }

    public void mo4489a(boolean z) throws RemoteException {
        if (this.f16708a.f16706b != null) {
            this.f16708a.f16706b.onResult(z);
        }
    }
}
