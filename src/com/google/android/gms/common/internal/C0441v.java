package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class C0441v extends C0433n {
    public final IBinder f445e;
    final /* synthetic */ zzf f446f;

    @BinderThread
    public C0441v(zzf com_google_android_gms_common_internal_zzf, int i, IBinder iBinder, Bundle bundle) {
        this.f446f = com_google_android_gms_common_internal_zzf;
        super(com_google_android_gms_common_internal_zzf, i, bundle);
        this.f445e = iBinder;
    }

    protected void mo1778a(ConnectionResult connectionResult) {
        if (this.f446f.f385v != null) {
            this.f446f.f385v.mo1764a(connectionResult);
        }
        this.f446f.m544a(connectionResult);
    }

    protected boolean mo1779a() {
        try {
            String interfaceDescriptor = this.f445e.getInterfaceDescriptor();
            if (this.f446f.mo1774j().equals(interfaceDescriptor)) {
                IInterface a = this.f446f.mo1772a(this.f445e);
                if (a == null || !this.f446f.m531a(2, 3, a)) {
                    return false;
                }
                Bundle t = this.f446f.m566t();
                if (this.f446f.f384u != null) {
                    this.f446f.f384u.mo1763a(t);
                }
                return true;
            }
            String valueOf = String.valueOf(this.f446f.mo1774j());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
