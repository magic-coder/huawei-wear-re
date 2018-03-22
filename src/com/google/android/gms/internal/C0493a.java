package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.internal.C0424f;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0493a extends C0492i {
    private final SparseArray<C0494b> f514e = new SparseArray();

    private C0493a(bn bnVar) {
        super(bnVar);
        this.d.mo1845a("AutoManageHelper", (bm) this);
    }

    public static C0493a m870a(bl blVar) {
        bn b = bm.m850b(blVar);
        C0493a c0493a = (C0493a) b.mo1844a("AutoManageHelper", C0493a.class);
        return c0493a != null ? c0493a : new C0493a(b);
    }

    public void mo1795a() {
        super.mo1795a();
        boolean z = this.a;
        String valueOf = String.valueOf(this.f514e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(HwAccountConstants.BLANK).append(valueOf).toString());
        if (!this.b) {
            for (int i = 0; i < this.f514e.size(); i++) {
                ((C0494b) this.f514e.valueAt(i)).f588b.mo1807b();
            }
        }
    }

    public void m872a(int i) {
        C0494b c0494b = (C0494b) this.f514e.get(i);
        this.f514e.remove(i);
        if (c0494b != null) {
            c0494b.m1033a();
        }
    }

    public void m873a(int i, C0378p c0378p, C0381s c0381s) {
        C0424f.m650a((Object) c0378p, (Object) "GoogleApiClient instance cannot be null");
        C0424f.m655a(this.f514e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + HwAccountConstants.BLANK + this.a + HwAccountConstants.BLANK + this.b);
        this.f514e.put(i, new C0494b(this, i, c0378p, c0381s));
        if (this.a && !this.b) {
            String valueOf = String.valueOf(c0378p);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            c0378p.mo1807b();
        }
    }

    protected void mo1800a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C0494b c0494b = (C0494b) this.f514e.get(i);
        if (c0494b != null) {
            m872a(i);
            C0381s c0381s = c0494b.f589c;
            if (c0381s != null) {
                c0381s.mo1830a(connectionResult);
            }
        }
    }

    public void mo1801a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f514e.size(); i++) {
            ((C0494b) this.f514e.valueAt(i)).m1035a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void mo1798b() {
        super.mo1798b();
        for (int i = 0; i < this.f514e.size(); i++) {
            ((C0494b) this.f514e.valueAt(i)).f588b.mo1809c();
        }
    }

    protected void mo1802c() {
        for (int i = 0; i < this.f514e.size(); i++) {
            ((C0494b) this.f514e.valueAt(i)).f588b.mo1807b();
        }
    }
}
