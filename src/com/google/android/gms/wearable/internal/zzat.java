package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzat extends zza {
    public static final Creator<zzat> CREATOR = new C0563u();
    public final int statusCode;
    public final List<zzo> zzbUt;

    public zzat(int i, List<zzo> list) {
        this.statusCode = i;
        this.zzbUt = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0563u.m2209a(this, parcel, i);
    }
}
