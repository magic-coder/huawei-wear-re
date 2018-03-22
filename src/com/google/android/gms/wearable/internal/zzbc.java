package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbc extends zza {
    public static final Creator<zzbc> CREATOR = new aa();
    public final int statusCode;
    public final boolean zzbUw;

    public zzbc(int i, boolean z) {
        this.statusCode = i;
        this.zzbUw = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        aa.m1778a(this, parcel, i);
    }
}
