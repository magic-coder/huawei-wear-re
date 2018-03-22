package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;

class ar implements C0380r, C0381s {
    final /* synthetic */ ai f565a;

    private ar(ai aiVar) {
        this.f565a = aiVar;
    }

    public void mo1828a(int i) {
    }

    public void mo1829a(Bundle bundle) {
        this.f565a.f539k.mo1867a(new ap(this.f565a));
    }

    public void mo1830a(@NonNull ConnectionResult connectionResult) {
        this.f565a.f530b.lock();
        try {
            if (this.f565a.m935b(connectionResult)) {
                this.f565a.m949h();
                this.f565a.m942e();
            } else {
                this.f565a.m939c(connectionResult);
            }
            this.f565a.f530b.unlock();
        } catch (Throwable th) {
            this.f565a.f530b.unlock();
        }
    }
}
