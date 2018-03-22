package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.C0389b;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.C0443x;
import com.google.android.gms.common.internal.C0444y;
import com.google.android.gms.internal.C0493a;
import com.google.android.gms.internal.C0510q;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.zzaat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class C0379q {
    private Account f285a;
    private final Set<Scope> f286b = new HashSet();
    private final Set<Scope> f287c = new HashSet();
    private int f288d;
    private View f289e;
    private String f290f;
    private String f291g;
    private final Map<C0367a<?>, C0444y> f292h = new ArrayMap();
    private final Context f293i;
    private final Map<C0367a<?>, C0344b> f294j = new ArrayMap();
    private bl f295k;
    private int f296l = -1;
    private C0381s f297m;
    private Looper f298n;
    private C0389b f299o = C0389b.m424a();
    private C0369f<? extends dk, dl> f300p = dg.f686c;
    private final ArrayList<C0380r> f301q = new ArrayList();
    private final ArrayList<C0381s> f302r = new ArrayList();
    private boolean f303s = false;

    public C0379q(@NonNull Context context) {
        this.f293i = context;
        this.f298n = context.getMainLooper();
        this.f290f = context.getPackageName();
        this.f291g = context.getClass().getName();
    }

    private static <C extends C0372j, O> C m389a(C0369f<C, O> c0369f, Object obj, Context context, Looper looper, C0443x c0443x, C0380r c0380r, C0381s c0381s) {
        return c0369f.mo1854a(context, looper, c0443x, obj, c0380r, c0381s);
    }

    private void m390a(C0378p c0378p) {
        C0493a.m870a(this.f295k).m873a(this.f296l, c0378p, this.f297m);
    }

    private C0378p m391c() {
        C0443x a = m397a();
        C0367a c0367a = null;
        Map e = a.m761e();
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        for (C0367a c0367a2 : this.f294j.keySet()) {
            C0367a c0367a22;
            Object obj2 = this.f294j.get(c0367a22);
            boolean z = e.get(c0367a22) != null;
            arrayMap.put(c0367a22, Boolean.valueOf(z));
            C0380r c0510q = new C0510q(c0367a22, z);
            arrayList.add(c0510q);
            C0368i b = c0367a22.m334b();
            C0372j a2 = C0379q.m389a(b, obj2, this.f293i, this.f298n, a, c0510q, c0510q);
            arrayMap2.put(c0367a22.m335c(), a2);
            Object obj3 = b.m355a() == 1 ? obj2 != null ? 1 : null : obj;
            if (!a2.m366f()) {
                c0367a22 = c0367a;
            } else if (c0367a != null) {
                String valueOf = String.valueOf(c0367a22.m336d());
                String valueOf2 = String.valueOf(c0367a.m336d());
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
            }
            obj = obj3;
            c0367a = c0367a22;
        }
        if (c0367a != null) {
            if (obj != null) {
                valueOf = String.valueOf(c0367a.m336d());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 82).append("With using ").append(valueOf).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
            }
            C0424f.m656a(this.f285a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c0367a.m336d());
            C0424f.m656a(this.f286b.equals(this.f287c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c0367a.m336d());
        }
        return new zzaat(this.f293i, new ReentrantLock(), this.f298n, a, this.f299o, this.f300p, arrayMap, this.f301q, this.f302r, arrayMap2, this.f296l, zzaat.m1582a(arrayMap2.values(), true), arrayList, false);
    }

    public C0379q m392a(Account account) {
        this.f285a = account;
        return this;
    }

    public C0379q m393a(@NonNull Handler handler) {
        C0424f.m650a((Object) handler, (Object) "Handler must not be null");
        this.f298n = handler.getLooper();
        return this;
    }

    public C0379q m394a(@NonNull C0367a<? extends C0346d> c0367a) {
        C0424f.m650a((Object) c0367a, (Object) "Api must not be null");
        this.f294j.put(c0367a, null);
        Collection a = c0367a.m333a().m356a(null);
        this.f287c.addAll(a);
        this.f286b.addAll(a);
        return this;
    }

    public C0379q m395a(@NonNull C0380r c0380r) {
        C0424f.m650a((Object) c0380r, (Object) "Listener must not be null");
        this.f301q.add(c0380r);
        return this;
    }

    public C0379q m396a(@NonNull C0381s c0381s) {
        C0424f.m650a((Object) c0381s, (Object) "Listener must not be null");
        this.f302r.add(c0381s);
        return this;
    }

    public C0443x m397a() {
        dl dlVar = dl.f693a;
        if (this.f294j.containsKey(dg.f690g)) {
            dlVar = (dl) this.f294j.get(dg.f690g);
        }
        return new C0443x(this.f285a, this.f286b, this.f292h, this.f288d, this.f289e, this.f290f, this.f291g, dlVar);
    }

    public C0378p m398b() {
        C0424f.m658b(!this.f294j.isEmpty(), "must call addApi() to add at least one API");
        C0378p c = m391c();
        synchronized (C0378p.f284a) {
            C0378p.f284a.add(c);
        }
        if (this.f296l >= 0) {
            m390a(c);
        }
        return c;
    }
}
