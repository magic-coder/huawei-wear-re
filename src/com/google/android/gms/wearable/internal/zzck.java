package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzck extends zza {
    public static final Creator<zzck> CREATOR = new bl();
    final int zzaiI;
    public final ap zzbTx;

    zzck(int i, IBinder iBinder) {
        this.zzaiI = i;
        if (iBinder != null) {
            this.zzbTx = aq.m1702a(iBinder);
        } else {
            this.zzbTx = null;
        }
    }

    public zzck(ap apVar) {
        this.zzaiI = 1;
        this.zzbTx = apVar;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bl.m1991a(this, parcel, i);
    }

    IBinder zzAh() {
        return this.zzbTx == null ? null : this.zzbTx.asBinder();
    }
}
