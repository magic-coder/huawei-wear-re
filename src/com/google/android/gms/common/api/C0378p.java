package com.google.android.gms.common.api;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.internal.C0503g;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.internal.zzabx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class C0378p {
    private static final Set<C0378p> f284a = Collections.newSetFromMap(new WeakHashMap());

    public Looper mo1838a() {
        throw new UnsupportedOperationException();
    }

    public <A extends C0370g, R extends C0366w, T extends C0503g<R, A>> T mo1839a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzabh<L> mo1897a(@NonNull L l) {
        throw new UnsupportedOperationException();
    }

    public void mo1898a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1805a(@NonNull C0381s c0381s);

    public void mo1840a(zzabx com_google_android_gms_internal_zzabx) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1806a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public <A extends C0370g, T extends C0503g<? extends C0366w, A>> T mo1841b(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1807b();

    public abstract void mo1808b(@NonNull C0381s c0381s);

    public void mo1842b(zzabx com_google_android_gms_internal_zzabx) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1809c();

    public abstract void mo1810d();

    public abstract boolean mo1811e();

    public abstract boolean mo1812f();
}
