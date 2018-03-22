package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.C0389b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.ah;
import com.google.android.gms.common.internal.ai;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class zzaat extends C0378p implements bk {
    final Queue<C0503g<?, ?>> f848a = new LinkedList();
    zzaaz f849b;
    final Map<C0371h<?>, C0372j> f850c;
    Set<Scope> f851d = new HashSet();
    final C0443x f852e;
    final Map<C0367a<?>, Boolean> f853f;
    final C0369f<? extends dk, dl> f854g;
    Set<zzabx> f855h = null;
    final cg f856i;
    private final Lock f857j;
    private boolean f858k;
    private final ah f859l;
    private bj f860m = null;
    private final int f861n;
    private final Context f862o;
    private final Looper f863p;
    private volatile boolean f864q;
    private long f865r = 120000;
    private long f866s = 5000;
    private final zza f867t;
    private final C0389b f868u;
    private final bs f869v = new bs();
    private final ArrayList<C0510q> f870w;
    private Integer f871x = null;
    private final ai f872y = new au(this);

    final class zza extends Handler {
        final /* synthetic */ zzaat f847a;

        zza(zzaat com_google_android_gms_internal_zzaat, Looper looper) {
            this.f847a = com_google_android_gms_internal_zzaat;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f847a.m1589p();
                    return;
                case 2:
                    this.f847a.m1588o();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzaat(Context context, Lock lock, Looper looper, C0443x c0443x, C0389b c0389b, C0369f<? extends dk, dl> c0369f, Map<C0367a<?>, Boolean> map, List<C0380r> list, List<C0381s> list2, Map<C0371h<?>, C0372j> map2, int i, int i2, ArrayList<C0510q> arrayList, boolean z) {
        this.f862o = context;
        this.f857j = lock;
        this.f858k = z;
        this.f859l = new ah(looper, this.f872y);
        this.f863p = looper;
        this.f867t = new zza(this, looper);
        this.f868u = c0389b;
        this.f861n = i;
        if (this.f861n >= 0) {
            this.f871x = Integer.valueOf(i2);
        }
        this.f853f = map;
        this.f850c = map2;
        this.f870w = arrayList;
        this.f856i = new cg(this.f850c);
        for (C0380r a : list) {
            this.f859l.m589a(a);
        }
        for (C0381s a2 : list2) {
            this.f859l.m590a(a2);
        }
        this.f852e = c0443x;
        this.f854g = c0369f;
    }

    public static int m1582a(Iterable<C0372j> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C0372j c0372j : iterable) {
            if (c0372j.mo1868d()) {
                i2 = 1;
            }
            i = c0372j.m366f() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    static String m1584b(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m1586c(int i) {
        if (this.f871x == null) {
            this.f871x = Integer.valueOf(i);
        } else if (this.f871x.intValue() != i) {
            String valueOf = String.valueOf(m1584b(i));
            String valueOf2 = String.valueOf(m1584b(this.f871x.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f860m == null) {
            boolean z = false;
            boolean z2 = false;
            for (C0372j c0372j : this.f850c.values()) {
                if (c0372j.mo1868d()) {
                    z2 = true;
                }
                z = c0372j.m366f() ? true : z;
            }
            switch (this.f871x.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        if (this.f858k) {
                            this.f860m = new C0516x(this.f862o, this.f857j, this.f863p, this.f868u, this.f850c, this.f852e, this.f853f, this.f854g, this.f870w, this, true);
                            return;
                        } else {
                            this.f860m = C0511s.m1508a(this.f862o, this, this.f857j, this.f863p, this.f868u, this.f850c, this.f852e, this.f853f, this.f854g, this.f870w);
                            return;
                        }
                    }
                    break;
            }
            if (!this.f858k || z) {
                this.f860m = new zzaav(this.f862o, this, this.f857j, this.f863p, this.f868u, this.f850c, this.f852e, this.f853f, this.f854g, this.f870w, this);
            } else {
                this.f860m = new C0516x(this.f862o, this.f857j, this.f863p, this.f868u, this.f850c, this.f852e, this.f853f, this.f854g, this.f870w, this, false);
            }
        }
    }

    private void m1587n() {
        this.f859l.m591b();
        this.f860m.mo1885a();
    }

    private void m1588o() {
        this.f857j.lock();
        try {
            if (m1609h()) {
                m1587n();
            }
            this.f857j.unlock();
        } catch (Throwable th) {
            this.f857j.unlock();
        }
    }

    private void m1589p() {
        this.f857j.lock();
        try {
            if (m1611j()) {
                m1587n();
            }
            this.f857j.unlock();
        } catch (Throwable th) {
            this.f857j.unlock();
        }
    }

    public Looper mo1838a() {
        return this.f863p;
    }

    <C extends C0372j> C m1591a(C0371h<?> c0371h) {
        Object obj = (C0372j) this.f850c.get(c0371h);
        C0424f.m650a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1839a(@NonNull T t) {
        C0424f.m658b(t.mo1882b() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f850c.containsKey(t.mo1882b());
        String d = t.mo1883c() != null ? t.mo1883c().m336d() : "the API";
        C0424f.m658b(containsKey, new StringBuilder(String.valueOf(d).length() + 65).append("GoogleApiClient is not configured to use ").append(d).append(" required for this call.").toString());
        this.f857j.lock();
        try {
            if (this.f860m == null) {
                this.f848a.add(t);
            } else {
                t = this.f860m.mo1884a(t);
                this.f857j.unlock();
            }
            return t;
        } finally {
            this.f857j.unlock();
        }
    }

    public <L> zzabh<L> mo1897a(@NonNull L l) {
        this.f857j.lock();
        try {
            zzabh<L> a = this.f869v.m1111a(l, this.f863p);
            return a;
        } finally {
            this.f857j.unlock();
        }
    }

    public void mo1898a(int i) {
        boolean z = true;
        this.f857j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            C0424f.m658b(z, "Illegal sign-in mode: " + i);
            m1586c(i);
            m1587n();
        } finally {
            this.f857j.unlock();
        }
    }

    public void mo1892a(int i, boolean z) {
        if (i == 1 && !z) {
            m1610i();
        }
        this.f856i.m1148b();
        this.f859l.m586a(i);
        this.f859l.m585a();
        if (i == 2) {
            m1587n();
        }
    }

    public void mo1893a(Bundle bundle) {
        while (!this.f848a.isEmpty()) {
            mo1841b((C0503g) this.f848a.remove());
        }
        this.f859l.m587a(bundle);
    }

    public void mo1894a(ConnectionResult connectionResult) {
        if (!this.f868u.mo1748b(this.f862o, connectionResult.getErrorCode())) {
            m1611j();
        }
        if (!m1609h()) {
            this.f859l.m588a(connectionResult);
            this.f859l.m585a();
        }
    }

    public void mo1805a(@NonNull C0381s c0381s) {
        this.f859l.m590a(c0381s);
    }

    public void mo1840a(zzabx com_google_android_gms_internal_zzabx) {
        this.f857j.lock();
        try {
            if (this.f855h == null) {
                this.f855h = new HashSet();
            }
            this.f855h.add(com_google_android_gms_internal_zzabx);
        } finally {
            this.f857j.unlock();
        }
    }

    public void mo1806a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f862o);
        printWriter.append(str).append("mResuming=").print(this.f864q);
        printWriter.append(" mWorkQueue.size()=").print(this.f848a.size());
        this.f856i.m1147a(printWriter);
        if (this.f860m != null) {
            this.f860m.mo1886a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1841b(@NonNull T t) {
        C0424f.m658b(t.mo1882b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f850c.containsKey(t.mo1882b());
        String d = t.mo1883c() != null ? t.mo1883c().m336d() : "the API";
        C0424f.m658b(containsKey, new StringBuilder(String.valueOf(d).length() + 65).append("GoogleApiClient is not configured to use ").append(d).append(" required for this call.").toString());
        this.f857j.lock();
        try {
            if (this.f860m == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m1609h()) {
                this.f848a.add(t);
                while (!this.f848a.isEmpty()) {
                    C0501m c0501m = (C0503g) this.f848a.remove();
                    this.f856i.m1146a(c0501m);
                    c0501m.mo1880a(Status.zzazz);
                }
            } else {
                t = this.f860m.mo1887b(t);
                this.f857j.unlock();
            }
            return t;
        } finally {
            this.f857j.unlock();
        }
    }

    public void mo1807b() {
        boolean z = false;
        this.f857j.lock();
        try {
            if (this.f861n >= 0) {
                if (this.f871x != null) {
                    z = true;
                }
                C0424f.m655a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f871x == null) {
                this.f871x = Integer.valueOf(m1582a(this.f850c.values(), false));
            } else if (this.f871x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo1898a(this.f871x.intValue());
        } finally {
            this.f857j.unlock();
        }
    }

    public void mo1808b(@NonNull C0381s c0381s) {
        this.f859l.m592b(c0381s);
    }

    public void mo1842b(zzabx com_google_android_gms_internal_zzabx) {
        this.f857j.lock();
        try {
            if (this.f855h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f855h.remove(com_google_android_gms_internal_zzabx)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m1612k()) {
                this.f860m.mo1891e();
            }
            this.f857j.unlock();
        } catch (Throwable th) {
            this.f857j.unlock();
        }
    }

    public void mo1809c() {
        this.f857j.lock();
        try {
            this.f856i.m1145a();
            if (this.f860m != null) {
                this.f860m.mo1888b();
            }
            this.f869v.m1113a();
            for (C0503g c0503g : this.f848a) {
                c0503g.m1479a(null);
                c0503g.m1483e();
            }
            this.f848a.clear();
            if (this.f860m != null) {
                m1611j();
                this.f859l.m585a();
                this.f857j.unlock();
            }
        } finally {
            this.f857j.unlock();
        }
    }

    public void mo1810d() {
        mo1809c();
        mo1807b();
    }

    public boolean mo1811e() {
        return this.f860m != null && this.f860m.mo1889c();
    }

    public boolean mo1812f() {
        return this.f860m != null && this.f860m.mo1890d();
    }

    boolean m1609h() {
        return this.f864q;
    }

    void m1610i() {
        if (!m1609h()) {
            this.f864q = true;
            if (this.f849b == null) {
                this.f849b = this.f868u.m432a(this.f862o.getApplicationContext(), new av(this));
            }
            this.f867t.sendMessageDelayed(this.f867t.obtainMessage(1), this.f865r);
            this.f867t.sendMessageDelayed(this.f867t.obtainMessage(2), this.f866s);
        }
    }

    boolean m1611j() {
        if (!m1609h()) {
            return false;
        }
        this.f864q = false;
        this.f867t.removeMessages(2);
        this.f867t.removeMessages(1);
        if (this.f849b != null) {
            this.f849b.m1634a();
            this.f849b = null;
        }
        return true;
    }

    boolean m1612k() {
        boolean z = false;
        this.f857j.lock();
        try {
            if (this.f855h != null) {
                if (!this.f855h.isEmpty()) {
                    z = true;
                }
                this.f857j.unlock();
            }
            return z;
        } finally {
            this.f857j.unlock();
        }
    }

    String m1613l() {
        Writer stringWriter = new StringWriter();
        mo1806a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m1614m() {
        return System.identityHashCode(this);
    }
}
