package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class C0439t implements ServiceConnection {
    final /* synthetic */ zzf f442a;
    private final int f443b;

    public C0439t(zzf com_google_android_gms_common_internal_zzf, int i) {
        this.f442a = com_google_android_gms_common_internal_zzf;
        this.f443b = i;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f442a.m541a(8, null, this.f443b);
            return;
        }
        synchronized (this.f442a.f378o) {
            this.f442a.f379p = ay.m634a(iBinder);
        }
        this.f442a.m541a(0, null, this.f443b);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f442a.f378o) {
            this.f442a.f379p = null;
        }
        this.f442a.f365a.sendMessage(this.f442a.f365a.obtainMessage(4, this.f443b, 1));
    }
}
