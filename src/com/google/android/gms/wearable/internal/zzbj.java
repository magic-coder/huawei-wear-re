package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzbj extends zza {
    public static final Creator<zzbj> CREATOR = new ae();
    public final int statusCode;
    public final ConnectionConfiguration[] zzbUA;

    public zzbj(int i, ConnectionConfiguration[] connectionConfigurationArr) {
        this.statusCode = i;
        this.zzbUA = connectionConfigurationArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ae.m1790a(this, parcel, i);
    }
}
