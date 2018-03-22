package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.C3670b;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

/* compiled from: AnalyticsGmsCoreClient */
class C3648b implements C3645a {
    private ServiceConnection f14151a;
    private C3653d f14152b;
    private C3654e f14153c;
    private Context f14154d;
    private C3670b f14155e;

    public C3648b(Context context, C3653d c3653d, C3654e c3654e) {
        this.f14154d = context;
        if (c3653d == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.f14152b = c3653d;
        if (c3654e == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.f14153c = c3654e;
    }

    public void mo4246b() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.f14154d.getPackageName());
        if (this.f14151a != null) {
            ar.m18264a("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.f14151a = new C3652c(this);
        boolean bindService = this.f14154d.bindService(intent, this.f14151a, 129);
        ar.m18268c("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.f14151a = null;
            this.f14153c.mo4262a(1, null);
        }
    }

    public void mo4247c() {
        this.f14155e = null;
        if (this.f14151a != null) {
            try {
                this.f14154d.unbindService(this.f14151a);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.f14151a = null;
            this.f14152b.mo4264b();
        }
    }

    public void mo4245a(Map<String, String> map, long j, String str, List<Command> list) {
        try {
            m18301f().mo4269a(map, j, str, list);
        } catch (RemoteException e) {
            ar.m18264a("sendHit failed: " + e);
        }
    }

    public void mo4244a() {
        try {
            m18301f().mo4268a();
        } catch (RemoteException e) {
            ar.m18264a("clear hits failed: " + e);
        }
    }

    private C3670b m18301f() {
        m18308d();
        return this.f14155e;
    }

    protected void m18308d() {
        if (!m18309e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean m18309e() {
        return this.f14155e != null;
    }

    private void m18302g() {
        m18303h();
    }

    private void m18303h() {
        this.f14152b.mo4261a();
    }
}
