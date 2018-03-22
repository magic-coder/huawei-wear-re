package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzax extends zza {
    public static final Creator<zzax> CREATOR = new C0565w();
    public final int statusCode;
    public final ParcelFileDescriptor zzbUv;

    public zzax(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i;
        this.zzbUv = parcelFileDescriptor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0565w.m2215a(this, parcel, i);
    }
}
