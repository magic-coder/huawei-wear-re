package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.C0388h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0443x;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class C0511s implements bj {
    private final Context f807a;
    private final zzaat f808b;
    private final Looper f809c;
    private final zzaav f810d;
    private final zzaav f811e;
    private final Map<C0371h<?>, zzaav> f812f;
    private final Set<by> f813g = Collections.newSetFromMap(new WeakHashMap());
    private final C0372j f814h;
    private Bundle f815i;
    private ConnectionResult f816j = null;
    private ConnectionResult f817k = null;
    private boolean f818l = false;
    private final Lock f819m;
    private int f820n = 0;

    private C0511s(Context context, zzaat com_google_android_gms_internal_zzaat, Lock lock, Looper looper, C0388h c0388h, Map<C0371h<?>, C0372j> map, Map<C0371h<?>, C0372j> map2, C0443x c0443x, C0369f<? extends dk, dl> c0369f, C0372j c0372j, ArrayList<C0510q> arrayList, ArrayList<C0510q> arrayList2, Map<C0367a<?>, Boolean> map3, Map<C0367a<?>, Boolean> map4) {
        this.f807a = context;
        this.f808b = com_google_android_gms_internal_zzaat;
        this.f819m = lock;
        this.f809c = looper;
        this.f814h = c0372j;
        this.f810d = new zzaav(context, this.f808b, lock, looper, c0388h, map2, null, map4, null, arrayList2, new C0513u());
        this.f811e = new zzaav(context, this.f808b, lock, looper, c0388h, map, c0443x, map3, c0369f, arrayList, new C0514v());
        Map arrayMap = new ArrayMap();
        for (C0371h put : map2.keySet()) {
            arrayMap.put(put, this.f810d);
        }
        for (C0371h put2 : map.keySet()) {
            arrayMap.put(put2, this.f811e);
        }
        this.f812f = Collections.unmodifiableMap(arrayMap);
    }

    public static C0511s m1508a(Context context, zzaat com_google_android_gms_internal_zzaat, Lock lock, Looper looper, C0388h c0388h, Map<C0371h<?>, C0372j> map, C0443x c0443x, Map<C0367a<?>, Boolean> map2, C0369f<? extends dk, dl> c0369f, ArrayList<C0510q> arrayList) {
        C0372j c0372j = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (Entry entry : map.entrySet()) {
            C0372j c0372j2 = (C0372j) entry.getValue();
            if (c0372j2.m366f()) {
                c0372j = c0372j2;
            }
            if (c0372j2.mo1868d()) {
                arrayMap.put((C0371h) entry.getKey(), c0372j2);
            } else {
                arrayMap2.put((C0371h) entry.getKey(), c0372j2);
            }
        }
        C0424f.m655a(!arrayMap.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (C0367a c0367a : map2.keySet()) {
            C0371h c = c0367a.m335c();
            if (arrayMap.containsKey(c)) {
                arrayMap3.put(c0367a, (Boolean) map2.get(c0367a));
            } else if (arrayMap2.containsKey(c)) {
                arrayMap4.put(c0367a, (Boolean) map2.get(c0367a));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0510q c0510q = (C0510q) it.next();
            if (arrayMap3.containsKey(c0510q.f804a)) {
                arrayList2.add(c0510q);
            } else if (arrayMap4.containsKey(c0510q.f804a)) {
                arrayList3.add(c0510q);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new C0511s(context, com_google_android_gms_internal_zzaat, lock, looper, c0388h, arrayMap, arrayMap2, c0443x, c0369f, c0372j, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private void m1510a(int i, boolean z) {
        this.f808b.mo1892a(i, z);
        this.f817k = null;
        this.f816j = null;
    }

    private void m1511a(Bundle bundle) {
        if (this.f815i == null) {
            this.f815i = bundle;
        } else if (bundle != null) {
            this.f815i.putAll(bundle);
        }
    }

    private void m1512a(ConnectionResult connectionResult) {
        switch (this.f820n) {
            case 1:
                break;
            case 2:
                this.f808b.mo1894a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m1527j();
        this.f820n = 0;
    }

    private static boolean m1518b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean m1519c(C0503g<? extends C0366w, ? extends C0370g> c0503g) {
        C0371h b = c0503g.mo1882b();
        C0424f.m658b(this.f812f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzaav) this.f812f.get(b)).equals(this.f811e);
    }

    private void m1524g() {
        this.f817k = null;
        this.f816j = null;
        this.f810d.mo1885a();
        this.f811e.mo1885a();
    }

    private void m1525h() {
        if (C0511s.m1518b(this.f816j)) {
            if (C0511s.m1518b(this.f817k) || m1528k()) {
                m1526i();
            } else if (this.f817k == null) {
            } else {
                if (this.f820n == 1) {
                    m1527j();
                    return;
                }
                m1512a(this.f817k);
                this.f810d.mo1888b();
            }
        } else if (this.f816j != null && C0511s.m1518b(this.f817k)) {
            this.f811e.mo1888b();
            m1512a(this.f816j);
        } else if (this.f816j != null && this.f817k != null) {
            ConnectionResult connectionResult = this.f816j;
            if (this.f811e.f879f < this.f810d.f879f) {
                connectionResult = this.f817k;
            }
            m1512a(connectionResult);
        }
    }

    private void m1526i() {
        switch (this.f820n) {
            case 1:
                break;
            case 2:
                this.f808b.mo1893a(this.f815i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m1527j();
        this.f820n = 0;
    }

    private void m1527j() {
        for (by a : this.f813g) {
            a.m1121a();
        }
        this.f813g.clear();
    }

    private boolean m1528k() {
        return this.f817k != null && this.f817k.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent m1529l() {
        return this.f814h == null ? null : PendingIntent.getActivity(this.f807a, this.f808b.m1614m(), this.f814h.m367g(), HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1884a(@NonNull T t) {
        if (!m1519c((C0503g) t)) {
            return this.f810d.mo1884a((C0503g) t);
        }
        if (!m1528k()) {
            return this.f811e.mo1884a((C0503g) t);
        }
        t.mo1880a(new Status(4, null, m1529l()));
        return t;
    }

    public void mo1885a() {
        this.f820n = 2;
        this.f818l = false;
        m1524g();
    }

    public void mo1886a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f811e.mo1886a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f810d.mo1886a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1887b(@NonNull T t) {
        if (!m1519c((C0503g) t)) {
            return this.f810d.mo1887b((C0503g) t);
        }
        if (!m1528k()) {
            return this.f811e.mo1887b((C0503g) t);
        }
        t.mo1880a(new Status(4, null, m1529l()));
        return t;
    }

    public void mo1888b() {
        this.f817k = null;
        this.f816j = null;
        this.f820n = 0;
        this.f810d.mo1888b();
        this.f811e.mo1888b();
        m1527j();
    }

    public boolean mo1889c() {
        boolean z = true;
        this.f819m.lock();
        try {
            if (!(this.f810d.mo1889c() && (m1538f() || m1528k() || this.f820n == 1))) {
                z = false;
            }
            this.f819m.unlock();
            return z;
        } catch (Throwable th) {
            this.f819m.unlock();
        }
    }

    public boolean mo1890d() {
        this.f819m.lock();
        try {
            boolean z = this.f820n == 2;
            this.f819m.unlock();
            return z;
        } catch (Throwable th) {
            this.f819m.unlock();
        }
    }

    public void mo1891e() {
        this.f810d.mo1891e();
        this.f811e.mo1891e();
    }

    public boolean m1538f() {
        return this.f811e.mo1889c();
    }
}
