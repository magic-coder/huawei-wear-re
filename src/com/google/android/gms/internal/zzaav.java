package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.C0388h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0370g;
import com.google.android.gms.common.api.C0371h;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.internal.C0443x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzaav implements bj, C0496r {
    final Map<C0371h<?>, C0372j> f874a;
    final Map<C0371h<?>, ConnectionResult> f875b = new HashMap();
    final C0443x f876c;
    final Map<C0367a<?>, Boolean> f877d;
    final C0369f<? extends dk, dl> f878e;
    int f879f;
    final zzaat f880g;
    final bk f881h;
    private final Lock f882i;
    private final Condition f883j;
    private final Context f884k;
    private final C0388h f885l;
    private final zzb f886m;
    private volatile aw f887n;
    private ConnectionResult f888o = null;

    final class zzb extends Handler {
        final /* synthetic */ zzaav f873a;

        zzb(zzaav com_google_android_gms_internal_zzaav, Looper looper) {
            this.f873a = com_google_android_gms_internal_zzaav;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((ax) message.obj).m920a(this.f873a);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzaav(Context context, zzaat com_google_android_gms_internal_zzaat, Lock lock, Looper looper, C0388h c0388h, Map<C0371h<?>, C0372j> map, C0443x c0443x, Map<C0367a<?>, Boolean> map2, C0369f<? extends dk, dl> c0369f, ArrayList<C0510q> arrayList, bk bkVar) {
        this.f884k = context;
        this.f882i = lock;
        this.f885l = c0388h;
        this.f874a = map;
        this.f876c = c0443x;
        this.f877d = map2;
        this.f878e = c0369f;
        this.f880g = com_google_android_gms_internal_zzaat;
        this.f881h = bkVar;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C0510q) it.next()).m1506a((C0496r) this);
        }
        this.f886m = new zzb(this, looper);
        this.f883j = lock.newCondition();
        this.f887n = new at(this);
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1884a(@NonNull T t) {
        t.m1487i();
        return this.f887n.mo1813a((C0503g) t);
    }

    public void mo1885a() {
        this.f887n.mo1820c();
    }

    public void mo1828a(int i) {
        this.f882i.lock();
        try {
            this.f887n.mo1815a(i);
        } finally {
            this.f882i.unlock();
        }
    }

    public void mo1829a(@Nullable Bundle bundle) {
        this.f882i.lock();
        try {
            this.f887n.mo1816a(bundle);
        } finally {
            this.f882i.unlock();
        }
    }

    void m1621a(ConnectionResult connectionResult) {
        this.f882i.lock();
        try {
            this.f888o = connectionResult;
            this.f887n = new at(this);
            this.f887n.mo1814a();
            this.f883j.signalAll();
        } finally {
            this.f882i.unlock();
        }
    }

    public void mo1835a(@NonNull ConnectionResult connectionResult, @NonNull C0367a<?> c0367a, boolean z) {
        this.f882i.lock();
        try {
            this.f887n.mo1817a(connectionResult, c0367a, z);
        } finally {
            this.f882i.unlock();
        }
    }

    void m1623a(ax axVar) {
        this.f886m.sendMessage(this.f886m.obtainMessage(1, axVar));
    }

    void m1624a(RuntimeException runtimeException) {
        this.f886m.sendMessage(this.f886m.obtainMessage(2, runtimeException));
    }

    public void mo1886a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f887n);
        for (C0367a c0367a : this.f877d.keySet()) {
            printWriter.append(str).append(c0367a.m336d()).println(":");
            ((C0372j) this.f874a.get(c0367a.m335c())).m361a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1887b(@NonNull T t) {
        t.m1487i();
        return this.f887n.mo1818b(t);
    }

    public void mo1888b() {
        if (this.f887n.mo1819b()) {
            this.f875b.clear();
        }
    }

    public boolean mo1889c() {
        return this.f887n instanceof af;
    }

    public boolean mo1890d() {
        return this.f887n instanceof ai;
    }

    public void mo1891e() {
        if (mo1889c()) {
            ((af) this.f887n).m918d();
        }
    }

    void m1631f() {
        this.f882i.lock();
        try {
            this.f887n = new ai(this, this.f876c, this.f877d, this.f885l, this.f878e, this.f882i, this.f884k);
            this.f887n.mo1814a();
            this.f883j.signalAll();
        } finally {
            this.f882i.unlock();
        }
    }

    void m1632g() {
        this.f882i.lock();
        try {
            this.f880g.m1611j();
            this.f887n = new af(this);
            this.f887n.mo1814a();
            this.f883j.signalAll();
        } finally {
            this.f882i.unlock();
        }
    }

    void m1633h() {
        for (C0372j a : this.f874a.values()) {
            a.m358a();
        }
    }
}
