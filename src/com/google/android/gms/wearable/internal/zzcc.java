package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0569x;

public class zzcc extends zza implements C0569x {
    public static final Creator<zzcc> CREATOR = new bh();
    private final String zzGV;
    private final String zzakb;
    private final int zzbUN;
    private final boolean zzbUO;

    public zzcc(String str, String str2, int i, boolean z) {
        this.zzGV = str;
        this.zzakb = str2;
        this.zzbUN = i;
        this.zzbUO = z;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof zzcc) ? false : ((zzcc) obj).zzGV.equals(this.zzGV);
    }

    public String getDisplayName() {
        return this.zzakb;
    }

    public int getHopCount() {
        return this.zzbUN;
    }

    public String getId() {
        return this.zzGV;
    }

    public int hashCode() {
        return this.zzGV.hashCode();
    }

    public boolean isNearby() {
        return this.zzbUO;
    }

    public String toString() {
        String str = this.zzakb;
        String str2 = this.zzGV;
        int i = this.zzbUN;
        return new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(str2).length()).append("Node{").append(str).append(", id=").append(str2).append(", hops=").append(i).append(", isNearby=").append(this.zzbUO).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        bh.m1979a(this, parcel, i);
    }
}
