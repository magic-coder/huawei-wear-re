package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

class bg implements Runnable {
    final /* synthetic */ ConnectionResult f614a;
    final /* synthetic */ bf f615b;

    bg(bf bfVar, ConnectionResult connectionResult) {
        this.f615b = bfVar;
        this.f614a = connectionResult;
    }

    public void run() {
        if (this.f614a.isSuccess()) {
            this.f615b.f613f = true;
            if (this.f615b.f609b.mo1868d()) {
                this.f615b.m1072a();
                return;
            } else {
                this.f615b.f609b.m359a(null, Collections.emptySet());
                return;
            }
        }
        ((bb) this.f615b.f608a.f582m.get(this.f615b.f610c)).mo1830a(this.f614a);
    }
}
