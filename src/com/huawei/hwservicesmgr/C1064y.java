package com.huawei.hwservicesmgr;

import android.os.RemoteException;
import com.huawei.p029c.C0669b;
import com.huawei.p190v.C2538c;

/* compiled from: PhoneService */
class C1064y implements C0669b {
    final /* synthetic */ C1052j f2086a;
    final /* synthetic */ C1062w f2087b;

    C1064y(C1062w c1062w, C1052j c1052j) {
        this.f2087b = c1062w;
        this.f2086a = c1052j;
    }

    public void mo2342a(int i) {
        try {
            if (this.f2086a != null) {
                this.f2086a.mo2630a(i);
            }
        } catch (RemoteException e) {
            C2538c.m12680e("PhoneService", e.getMessage());
        }
    }

    public void mo2343a(int i, String str) {
        try {
            if (this.f2086a != null) {
                this.f2086a.mo2631a(i, str);
            }
        } catch (RemoteException e) {
            C2538c.m12680e("PhoneService", e.getMessage());
        }
    }

    public void mo2344b(int i) {
        try {
            if (this.f2086a != null) {
                this.f2086a.mo2632b(i);
            }
        } catch (RemoteException e) {
            C2538c.m12680e("PhoneService", e.getMessage());
        }
    }
}
