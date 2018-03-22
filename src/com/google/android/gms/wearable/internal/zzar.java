package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzar extends zza {
    public static final Creator<zzar> CREATOR = new C0562t();
    public final int statusCode;
    public final int zzbUs;

    public zzar(int i, int i2) {
        this.statusCode = i;
        this.zzbUs = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0562t.m2206a(this, parcel, i);
    }
}
