package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzav extends zza {
    public static final Creator<zzav> CREATOR = new C0564v();
    public final int statusCode;
    public final zzo zzbUu;

    public zzav(int i, zzo com_google_android_gms_wearable_internal_zzo) {
        this.statusCode = i;
        this.zzbUu = com_google_android_gms_wearable_internal_zzo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0564v.m2212a(this, parcel, i);
    }
}
