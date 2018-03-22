package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.au;

public class zzh extends zza implements au {
    public static final Creator<zzh> CREATOR = new cx();
    private final String mValue;
    private byte zzbTB;
    private final byte zzbTC;

    public zzh(byte b, byte b2, String str) {
        this.zzbTB = b;
        this.zzbTC = b2;
        this.mValue = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzh com_google_android_gms_wearable_internal_zzh = (zzh) obj;
        return this.zzbTB != com_google_android_gms_wearable_internal_zzh.zzbTB ? false : this.zzbTC != com_google_android_gms_wearable_internal_zzh.zzbTC ? false : this.mValue.equals(com_google_android_gms_wearable_internal_zzh.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return ((((this.zzbTB + 31) * 31) + this.zzbTC) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        byte b = this.zzbTB;
        byte b2 = this.zzbTC;
        String str = this.mValue;
        return new StringBuilder(String.valueOf(str).length() + 73).append("AmsEntityUpdateParcelable{, mEntityId=").append(b).append(", mAttributeId=").append(b2).append(", mValue='").append(str).append("'").append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        cx.m2102a(this, parcel, i);
    }

    public byte zzUk() {
        return this.zzbTB;
    }

    public byte zzUl() {
        return this.zzbTC;
    }
}
