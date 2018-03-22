package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0434r;
import java.lang.ref.WeakReference;

class ak implements C0434r {
    private final WeakReference<ai> f551a;
    private final C0367a<?> f552b;
    private final boolean f553c;

    public ak(ai aiVar, C0367a<?> c0367a, boolean z) {
        this.f551a = new WeakReference(aiVar);
        this.f552b = c0367a;
        this.f553c = z;
    }

    public void mo1777a(@NonNull ConnectionResult connectionResult) {
        boolean z = false;
        ai aiVar = (ai) this.f551a.get();
        if (aiVar != null) {
            if (Looper.myLooper() == aiVar.f529a.f880g.mo1838a()) {
                z = true;
            }
            C0424f.m655a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            aiVar.f530b.lock();
            try {
                if (aiVar.m934b(0)) {
                    if (!connectionResult.isSuccess()) {
                        aiVar.m933b(connectionResult, this.f552b, this.f553c);
                    }
                    if (aiVar.m941d()) {
                        aiVar.m942e();
                    }
                    aiVar.f530b.unlock();
                }
            } finally {
                aiVar.f530b.unlock();
            }
        }
    }
}
