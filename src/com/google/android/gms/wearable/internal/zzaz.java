package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaz extends zza {
    public static final Creator<zzaz> CREATOR = new C0567z();
    public final int statusCode;
    public final ParcelFileDescriptor zzbUv;

    public zzaz(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i;
        this.zzbUv = parcelFileDescriptor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0567z.m2223a(this, parcel, i);
    }
}
