package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbg extends zza {
    public static final Creator<zzbg> CREATOR = new ac();
    public final boolean enabled;
    public final int statusCode;

    public zzbg(int i, boolean z) {
        this.statusCode = i;
        this.enabled = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ac.m1784a(this, parcel, i);
    }
}
