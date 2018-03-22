package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaa extends zza {
    public static final Creator<zzaa> CREATOR = new C0534b();
    public final int statusCode;

    public zzaa(int i) {
        this.statusCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0534b.m1953a(this, parcel, i);
    }
}
