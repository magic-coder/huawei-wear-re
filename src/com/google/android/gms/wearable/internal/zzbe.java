package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbe extends zza {
    public static final Creator<zzbe> CREATOR = new ab();
    public final int statusCode;
    public final boolean zzbUx;
    public final boolean zzbUy;

    public zzbe(int i, boolean z, boolean z2) {
        this.statusCode = i;
        this.zzbUx = z;
        this.zzbUy = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ab.m1781a(this, parcel, i);
    }
}
