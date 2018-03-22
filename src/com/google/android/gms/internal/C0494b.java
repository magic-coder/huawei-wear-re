package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0381s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class C0494b implements C0381s {
    public final int f587a;
    public final C0378p f588b;
    public final C0381s f589c;
    final /* synthetic */ C0493a f590d;

    public C0494b(C0493a c0493a, int i, C0378p c0378p, C0381s c0381s) {
        this.f590d = c0493a;
        this.f587a = i;
        this.f588b = c0378p;
        this.f589c = c0381s;
        c0378p.mo1805a((C0381s) this);
    }

    public void m1033a() {
        this.f588b.mo1808b((C0381s) this);
        this.f588b.mo1809c();
    }

    public void mo1830a(@NonNull ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
        this.f590d.m867b(connectionResult, this.f587a);
    }

    public void m1035a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("GoogleApiClient #").print(this.f587a);
        printWriter.println(":");
        this.f588b.mo1806a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
