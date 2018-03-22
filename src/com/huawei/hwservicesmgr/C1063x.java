package com.huawei.hwservicesmgr;

import android.os.RemoteException;
import com.huawei.hwbtsdk.p057b.p058a.C0957a;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneService */
class C1063x implements C0957a {
    final /* synthetic */ C1046a f2084a;
    final /* synthetic */ C1062w f2085b;

    C1063x(C1062w c1062w, C1046a c1046a) {
        this.f2085b = c1062w;
        this.f2084a = c1046a;
    }

    public void mo2341a(int i) {
        try {
            if (this.f2084a != null) {
                this.f2084a.mo2634a(i);
            }
        } catch (RemoteException e) {
            C2538c.m12680e("PhoneService", e.getMessage());
        }
    }
}
