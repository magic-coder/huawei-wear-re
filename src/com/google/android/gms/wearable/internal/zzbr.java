package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbr extends zza {
    public static final Creator<zzbr> CREATOR = new ai();
    public final int statusCode;
    public final zzcc zzbUD;

    public zzbr(int i, zzcc com_google_android_gms_wearable_internal_zzcc) {
        this.statusCode = i;
        this.zzbUD = com_google_android_gms_wearable_internal_zzcc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ai.m1802a(this, parcel, i);
    }
}
