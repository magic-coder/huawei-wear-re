package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.C0389b;
import com.google.android.gms.common.ConnectionResult;

public abstract class C0492i extends bm implements OnCancelListener {
    protected boolean f508a;
    protected boolean f509b;
    protected final C0389b f510c;
    private ConnectionResult f511e;
    private int f512f;
    private final Handler f513g;

    protected C0492i(bn bnVar) {
        this(bnVar, C0389b.m424a());
    }

    C0492i(bn bnVar, C0389b c0389b) {
        super(bnVar);
        this.f512f = -1;
        this.f513g = new Handler(Looper.getMainLooper());
        this.f510c = c0389b;
    }

    public void mo1795a() {
        super.mo1795a();
        this.f508a = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1796a(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003d;
    L_0x000c:
        r5.m869d();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.f510c;
        r3 = r5.m857f();
        r2 = r2.mo1742a(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x001c:
        r1 = r5.f511e;
        r1 = r1.getErrorCode();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0045;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0034:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.f511e = r2;
        goto L_0x0009;
    L_0x003d:
        r0 = r5.f511e;
        r1 = r5.f512f;
        r5.mo1800a(r0, r1);
        goto L_0x000f;
    L_0x0045:
        r0 = r2;
        goto L_0x0034;
    L_0x0047:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.a(int, int, android.content.Intent):void");
    }

    public void mo1797a(Bundle bundle) {
        super.mo1797a(bundle);
        if (bundle != null) {
            this.f509b = bundle.getBoolean("resolving_error", false);
            if (this.f509b) {
                this.f512f = bundle.getInt("failed_client_id", -1);
                this.f511e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void mo1800a(ConnectionResult connectionResult, int i);

    public void mo1798b() {
        super.mo1798b();
        this.f508a = false;
    }

    public void mo1799b(Bundle bundle) {
        super.mo1799b(bundle);
        bundle.putBoolean("resolving_error", this.f509b);
        if (this.f509b) {
            bundle.putInt("failed_client_id", this.f512f);
            bundle.putInt("failed_status", this.f511e.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f511e.getResolution());
        }
    }

    public void m867b(ConnectionResult connectionResult, int i) {
        if (!this.f509b) {
            this.f509b = true;
            this.f512f = i;
            this.f511e = connectionResult;
            this.f513g.post(new C0505k());
        }
    }

    protected abstract void mo1802c();

    protected void m869d() {
        this.f512f = -1;
        this.f509b = false;
        this.f511e = null;
        mo1802c();
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo1800a(new ConnectionResult(13, null), this.f512f);
        m869d();
    }
}
