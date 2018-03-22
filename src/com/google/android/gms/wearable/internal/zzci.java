package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzci extends zza {
    public static final Creator<zzci> CREATOR = new bk();
    public final int statusCode;
    public final zzao zzbUC;

    public zzci(int i, zzao com_google_android_gms_wearable_internal_zzao) {
        this.statusCode = i;
        this.zzbUC = com_google_android_gms_wearable_internal_zzao;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bk.m1988a(this, parcel, i);
    }
}
