package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbn extends zza {
    public static final Creator<zzbn> CREATOR = new ag();
    public final int statusCode;
    public final zzao zzbUC;

    public zzbn(int i, zzao com_google_android_gms_wearable_internal_zzao) {
        this.statusCode = i;
        this.zzbUC = com_google_android_gms_wearable_internal_zzao;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ag.m1796a(this, parcel, i);
    }
}
