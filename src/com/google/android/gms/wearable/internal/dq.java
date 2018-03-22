package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.C0521h;

final class dq implements C0537y<C0521h> {
    final /* synthetic */ String f1044a;
    final /* synthetic */ IntentFilter[] f1045b;

    dq(String str, IntentFilter[] intentFilterArr) {
        this.f1044a = str;
        this.f1045b = intentFilterArr;
    }

    public void m2149a(ch chVar, C0502h<Status> c0502h, C0521h c0521h, zzabh<C0521h> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h) throws RemoteException {
        chVar.m2035a((C0502h) c0502h, c0521h, (zzabh) com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h, this.f1044a, this.f1045b);
    }
}
