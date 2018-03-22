package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzcm extends zza {
    public static final Creator<zzcm> CREATOR = new bm();
    public final int statusCode;

    public zzcm(int i) {
        this.statusCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bm.m1994a(this, parcel, i);
    }
}
