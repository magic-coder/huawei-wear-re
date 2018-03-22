package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzcg extends zza {
    public static final Creator<zzcg> CREATOR = new bj();
    public final String label;
    public final String packageName;
    public final long zzbUP;

    public zzcg(String str, String str2, long j) {
        this.packageName = str;
        this.label = str2;
        this.zzbUP = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bj.m1985a(this, parcel, i);
    }
}
