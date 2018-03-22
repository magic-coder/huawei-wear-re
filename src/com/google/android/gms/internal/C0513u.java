package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

class C0513u implements bk {
    final /* synthetic */ C0511s f822a;

    private C0513u(C0511s c0511s) {
        this.f822a = c0511s;
    }

    public void mo1892a(int i, boolean z) {
        this.f822a.f819m.lock();
        try {
            if (this.f822a.f818l || this.f822a.f817k == null || !this.f822a.f817k.isSuccess()) {
                this.f822a.f818l = false;
                this.f822a.m1510a(i, z);
                return;
            }
            this.f822a.f818l = true;
            this.f822a.f811e.mo1828a(i);
            this.f822a.f819m.unlock();
        } finally {
            this.f822a.f819m.unlock();
        }
    }

    public void mo1893a(@Nullable Bundle bundle) {
        this.f822a.f819m.lock();
        try {
            this.f822a.m1511a(bundle);
            this.f822a.f816j = ConnectionResult.zzayj;
            this.f822a.m1525h();
        } finally {
            this.f822a.f819m.unlock();
        }
    }

    public void mo1894a(@NonNull ConnectionResult connectionResult) {
        this.f822a.f819m.lock();
        try {
            this.f822a.f816j = connectionResult;
            this.f822a.m1525h();
        } finally {
            this.f822a.f819m.unlock();
        }
    }
}
