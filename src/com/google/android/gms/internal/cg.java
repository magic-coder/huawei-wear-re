package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ae;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class cg {
    public static final Status f659a = new Status(8, "The connection to Google Play services was lost");
    private static final C0501m<?>[] f660c = new C0501m[0];
    final Set<C0501m<?>> f661b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final cj f662d = new ch(this);
    private final Map<C0371h<?>, C0372j> f663e;

    public cg(Map<C0371h<?>, C0372j> map) {
        this.f663e = map;
    }

    private static void m1144a(C0501m<?> c0501m, ae aeVar, IBinder iBinder) {
        if (c0501m.m1482d()) {
            c0501m.m1479a(new ci(c0501m, aeVar, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            c0501m.m1479a(null);
            c0501m.m1483e();
            aeVar.m348a(c0501m.mo1847a().intValue());
        } else {
            cj ciVar = new ci(c0501m, aeVar, iBinder, null);
            c0501m.m1479a(ciVar);
            try {
                iBinder.linkToDeath(ciVar, 0);
            } catch (RemoteException e) {
                c0501m.m1483e();
                aeVar.m348a(c0501m.mo1847a().intValue());
            }
        }
    }

    public void m1145a() {
        for (C0501m c0501m : (C0501m[]) this.f661b.toArray(f660c)) {
            c0501m.m1479a(null);
            if (c0501m.mo1847a() != null) {
                c0501m.m1486h();
                m1144a(c0501m, null, ((C0372j) this.f663e.get(((C0503g) c0501m).mo1882b())).m368h());
                this.f661b.remove(c0501m);
            } else if (c0501m.m1484f()) {
                this.f661b.remove(c0501m);
            }
        }
    }

    void m1146a(C0501m<? extends C0366w> c0501m) {
        this.f661b.add(c0501m);
        c0501m.m1479a(this.f662d);
    }

    public void m1147a(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f661b.size());
    }

    public void m1148b() {
        for (C0501m b : (C0501m[]) this.f661b.toArray(f660c)) {
            b.m1480b(f659a);
        }
    }
}
