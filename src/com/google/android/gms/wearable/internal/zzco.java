package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzco extends zza {
    public static final Creator<zzco> CREATOR = new bn();
    public final int statusCode;
    public final int zzbhU;

    public zzco(int i, int i2) {
        this.statusCode = i;
        this.zzbhU = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bn.m1997a(this, parcel, i);
    }
}
