package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C0434r;
import com.google.android.gms.common.internal.ao;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public interface C0372j extends C0370g {
    void m358a();

    void m359a(ao aoVar, Set<Scope> set);

    void mo2010a(C0434r c0434r);

    void m361a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean m362b();

    boolean m363c();

    boolean mo1868d();

    boolean mo2011e();

    boolean m366f();

    Intent m367g();

    @Nullable
    IBinder m368h();
}
