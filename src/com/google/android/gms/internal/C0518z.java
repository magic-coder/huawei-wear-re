package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ac;
import com.google.android.gms.p015b.C0357a;
import com.google.android.gms.p015b.C0358b;
import java.util.Collections;

class C0518z implements C0357a<Void> {
    final /* synthetic */ C0516x f846a;

    private C0518z(C0516x c0516x) {
        this.f846a = c0516x;
    }

    public void mo1803a(@NonNull C0358b<Void> c0358b) {
        this.f846a.f833f.lock();
        try {
            if (this.f846a.f841n) {
                if (c0358b.mo1739a()) {
                    this.f846a.f842o = new ArrayMap(this.f846a.f828a.size());
                    for (C0515w b : this.f846a.f828a.values()) {
                        this.f846a.f842o.put(b.m344b(), ConnectionResult.zzayj);
                    }
                } else if (c0358b.mo1740b() instanceof ac) {
                    ac acVar = (ac) c0358b.mo1740b();
                    if (this.f846a.f839l) {
                        this.f846a.f842o = new ArrayMap(this.f846a.f828a.size());
                        for (C0515w c0515w : this.f846a.f828a.values()) {
                            ez b2 = c0515w.m344b();
                            ConnectionResult a = acVar.m338a(c0515w);
                            if (this.f846a.m1552a(c0515w, a)) {
                                this.f846a.f842o.put(b2, new ConnectionResult(16));
                            } else {
                                this.f846a.f842o.put(b2, a);
                            }
                        }
                    } else {
                        this.f846a.f842o = acVar.m337a();
                    }
                    this.f846a.f845r = this.f846a.m1565h();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", c0358b.mo1740b());
                    this.f846a.f842o = Collections.emptyMap();
                    this.f846a.f845r = new ConnectionResult(8);
                }
                if (this.f846a.f843p != null) {
                    this.f846a.f842o.putAll(this.f846a.f843p);
                    this.f846a.f845r = this.f846a.m1565h();
                }
                if (this.f846a.f845r == null) {
                    this.f846a.m1562f();
                    this.f846a.m1564g();
                } else {
                    this.f846a.f841n = false;
                    this.f846a.f832e.mo1894a(this.f846a.f845r);
                }
                this.f846a.f836i.signalAll();
                this.f846a.f833f.unlock();
            }
        } finally {
            this.f846a.f833f.unlock();
        }
    }
}
