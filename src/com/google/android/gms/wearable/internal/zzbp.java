package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbp extends zza {
    public static final Creator<zzbp> CREATOR = new ah();
    public final int statusCode;
    public final ParcelFileDescriptor zzbyd;

    public zzbp(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i;
        this.zzbyd = parcelFileDescriptor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ah.m1799a(this, parcel, i | 1);
    }
}
