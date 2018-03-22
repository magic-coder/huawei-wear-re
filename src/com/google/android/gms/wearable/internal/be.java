package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.aa;

final class be implements C0537y<aa> {
    final /* synthetic */ IntentFilter[] f967a;

    be(IntentFilter[] intentFilterArr) {
        this.f967a = intentFilterArr;
    }

    public void m1971a(ch chVar, C0502h<Status> c0502h, aa aaVar, zzabh<aa> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_aa) throws RemoteException {
        chVar.m2034a((C0502h) c0502h, aaVar, (zzabh) com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_aa, this.f967a);
    }
}
