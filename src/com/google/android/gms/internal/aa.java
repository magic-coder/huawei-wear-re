package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ac;
import com.google.android.gms.p015b.C0357a;
import com.google.android.gms.p015b.C0358b;
import java.util.Collections;

class aa implements C0357a<Void> {
    final /* synthetic */ C0516x f515a;
    private by f516b;

    void m878a() {
        this.f516b.m1121a();
    }

    public void mo1803a(@NonNull C0358b<Void> c0358b) {
        this.f515a.f833f.lock();
        try {
            if (this.f515a.f841n) {
                if (c0358b.mo1739a()) {
                    this.f515a.f843p = new ArrayMap(this.f515a.f829b.size());
                    for (C0515w b : this.f515a.f829b.values()) {
                        this.f515a.f843p.put(b.m344b(), ConnectionResult.zzayj);
                    }
                } else if (c0358b.mo1740b() instanceof ac) {
                    ac acVar = (ac) c0358b.mo1740b();
                    if (this.f515a.f839l) {
                        this.f515a.f843p = new ArrayMap(this.f515a.f829b.size());
                        for (C0515w c0515w : this.f515a.f829b.values()) {
                            ez b2 = c0515w.m344b();
                            ConnectionResult a = acVar.m338a(c0515w);
                            if (this.f515a.m1552a(c0515w, a)) {
                                this.f515a.f843p.put(b2, new ConnectionResult(16));
                            } else {
                                this.f515a.f843p.put(b2, a);
                            }
                        }
                    } else {
                        this.f515a.f843p = acVar.m337a();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", c0358b.mo1740b());
                    this.f515a.f843p = Collections.emptyMap();
                }
                if (this.f515a.mo1889c()) {
                    this.f515a.f842o.putAll(this.f515a.f843p);
                    if (this.f515a.m1565h() == null) {
                        this.f515a.m1562f();
                        this.f515a.m1564g();
                        this.f515a.f836i.signalAll();
                    }
                }
                this.f516b.m1121a();
                this.f515a.f833f.unlock();
                return;
            }
            this.f516b.m1121a();
        } finally {
            this.f515a.f833f.unlock();
        }
    }
}
