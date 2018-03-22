package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class C0437b extends RuntimeException {
    public C0437b(String str, Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
    }
}