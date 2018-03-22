package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzbl extends zza {
    public static final Creator<zzbl> CREATOR = new af();
    public final int statusCode;
    public final List<zzcc> zzbUB;

    public zzbl(int i, List<zzcc> list) {
        this.statusCode = i;
        this.zzbUB = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        af.m1793a(this, parcel, i);
    }
}
