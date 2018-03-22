package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.C3671c;

/* compiled from: AnalyticsGmsCoreClient */
final class C3652c implements ServiceConnection {
    final /* synthetic */ C3648b f14178a;

    C3652c(C3648b c3648b) {
        this.f14178a = c3648b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ar.m18268c("service connected, binder: " + iBinder);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(iBinder.getInterfaceDescriptor())) {
                ar.m18268c("bound to service");
                this.f14178a.f14155e = C3671c.m18410a(iBinder);
                this.f14178a.m18302g();
                return;
            }
        } catch (RemoteException e) {
        }
        this.f14178a.f14154d.unbindService(this);
        this.f14178a.f14151a = null;
        this.f14178a.f14153c.mo4262a(2, null);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ar.m18268c("service disconnected: " + componentName);
        this.f14178a.f14151a = null;
        this.f14178a.f14152b.mo4264b();
    }
}
