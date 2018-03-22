package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzae extends zza {
    public static final Creator<zzae> CREATOR = new C0542e();
    public final int statusCode;

    public zzae(int i) {
        this.statusCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0542e.m2167a(this, parcel, i);
    }
}
