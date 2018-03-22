package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0568w;

public class zzbz extends zza implements C0568w {
    public static final Creator<zzbz> CREATOR = new bb();
    private final String mPath;
    private final int zzaKE;
    private final String zzacO;
    private final byte[] zzbeL;

    public zzbz(int i, String str, byte[] bArr, String str2) {
        this.zzaKE = i;
        this.mPath = str;
        this.zzbeL = bArr;
        this.zzacO = str2;
    }

    public byte[] getData() {
        return this.zzbeL;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRequestId() {
        return this.zzaKE;
    }

    public String getSourceNodeId() {
        return this.zzacO;
    }

    public String toString() {
        int i = this.zzaKE;
        String str = this.mPath;
        String valueOf = String.valueOf(this.zzbeL == null ? "null" : Integer.valueOf(this.zzbeL.length));
        return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()).append("MessageEventParcelable[").append(i).append(",").append(str).append(", size=").append(valueOf).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        bb.m1956a(this, parcel, i);
    }
}
