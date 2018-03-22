package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzcs extends zza {
    public static final Creator<zzcs> CREATOR = new bq();
    public final int statusCode;
    public final long zzbUP;
    public final List<zzcg> zzbUR;

    public zzcs(int i, long j, List<zzcg> list) {
        this.statusCode = i;
        this.zzbUP = j;
        this.zzbUR = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        bq.m2005a(this, parcel, i);
    }
}
