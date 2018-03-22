package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc extends zza {
    public static final Creator<zzc> CREATOR = new ct();
    public final String zzbTA;
    public final ap zzbTx;
    public final IntentFilter[] zzbTy;
    public final String zzbTz;

    zzc(IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        if (iBinder != null) {
            this.zzbTx = aq.m1702a(iBinder);
        } else {
            this.zzbTx = null;
        }
        this.zzbTy = intentFilterArr;
        this.zzbTz = str;
        this.zzbTA = str2;
    }

    public zzc(cl clVar) {
        this.zzbTx = clVar;
        this.zzbTy = clVar.m2070b();
        this.zzbTz = clVar.m2071c();
        this.zzbTA = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ct.m2096a(this, parcel, i);
    }

    IBinder zzAh() {
        return this.zzbTx == null ? null : this.zzbTx.asBinder();
    }
}
