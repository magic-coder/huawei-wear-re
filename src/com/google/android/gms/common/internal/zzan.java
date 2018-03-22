package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzan extends zza {
    public static final Creator<zzan> CREATOR = new C0429k();
    final int zzaiI;

    zzan(int i) {
        this.zzaiI = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0429k.m673a(this, parcel, i);
    }
}
