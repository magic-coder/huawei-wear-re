package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzy extends zza {
    public static final Creator<zzy> CREATOR = new dy();
    public final int statusCode;

    public zzy(int i) {
        this.statusCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        dy.m2164a(this, parcel, i);
    }
}
