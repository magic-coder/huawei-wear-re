package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class zzbh extends zza {
    public static final Creator<zzbh> CREATOR = new ad();
    public final int statusCode;
    public final ConnectionConfiguration zzbUz;

    public zzbh(int i, ConnectionConfiguration connectionConfiguration) {
        this.statusCode = i;
        this.zzbUz = connectionConfiguration;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.m1787a(this, parcel, i);
    }
}
