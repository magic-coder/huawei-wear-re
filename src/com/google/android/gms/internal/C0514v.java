package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

class C0514v implements bk {
    final /* synthetic */ C0511s f823a;

    private C0514v(C0511s c0511s) {
        this.f823a = c0511s;
    }

    public void mo1892a(int i, boolean z) {
        this.f823a.f819m.lock();
        try {
            if (this.f823a.f818l) {
                this.f823a.f818l = false;
                this.f823a.m1510a(i, z);
                return;
            }
            this.f823a.f818l = true;
            this.f823a.f810d.mo1828a(i);
            this.f823a.f819m.unlock();
        } finally {
            this.f823a.f819m.unlock();
        }
    }

    public void mo1893a(@Nullable Bundle bundle) {
        this.f823a.f819m.lock();
        try {
            this.f823a.f817k = ConnectionResult.zzayj;
            this.f823a.m1525h();
        } finally {
            this.f823a.f819m.unlock();
        }
    }

    public void mo1894a(@NonNull ConnectionResult connectionResult) {
        this.f823a.f819m.lock();
        try {
            this.f823a.f817k = connectionResult;
            this.f823a.m1525h();
        } finally {
            this.f823a.f819m.unlock();
        }
    }
}
