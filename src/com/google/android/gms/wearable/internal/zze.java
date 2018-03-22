package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze extends zza {
    public static final Creator<zze> CREATOR = new cv();
    public final int statusCode;

    public zze(int i) {
        this.statusCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        cv.m2099a(this, parcel, i);
    }
}
