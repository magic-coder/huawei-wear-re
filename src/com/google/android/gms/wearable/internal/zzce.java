package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzce extends zza {
    public static final Creator<zzce> CREATOR = new bi();
    public final int statusCode;
    public final zzu zzbTW;

    public zzce(int i, zzu com_google_android_gms_wearable_internal_zzu) {
        this.statusCode = i;
        this.zzbTW = com_google_android_gms_wearable_internal_zzu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bi.m1982a(this, parcel, i);
    }
}
