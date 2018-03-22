package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0526d;
import com.google.android.gms.wearable.C0569x;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzo extends zza implements C0526d {
    public static final Creator<zzo> CREATOR = new df();
    private final String mName;
    private Set<C0569x> zzbTN;
    private final List<zzcc> zzbTQ;
    private final Object zzrJ = new Object();

    public zzo(String str, List<zzcc> list) {
        this.mName = str;
        this.zzbTQ = list;
        this.zzbTN = null;
        zzUs();
    }

    private void zzUs() {
        C0424f.m649a(this.mName);
        C0424f.m649a(this.zzbTQ);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzo com_google_android_gms_wearable_internal_zzo = (zzo) obj;
        if (this.mName == null ? com_google_android_gms_wearable_internal_zzo.mName != null : !this.mName.equals(com_google_android_gms_wearable_internal_zzo.mName)) {
            return false;
        }
        if (this.zzbTQ != null) {
            if (this.zzbTQ.equals(com_google_android_gms_wearable_internal_zzo.zzbTQ)) {
                return true;
            }
        } else if (com_google_android_gms_wearable_internal_zzo.zzbTQ == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.mName;
    }

    public Set<C0569x> getNodes() {
        Set<C0569x> set;
        synchronized (this.zzrJ) {
            if (this.zzbTN == null) {
                this.zzbTN = new HashSet(this.zzbTQ);
            }
            set = this.zzbTN;
        }
        return set;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + 31) * 31;
        if (this.zzbTQ != null) {
            i = this.zzbTQ.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String str = this.mName;
        String valueOf = String.valueOf(this.zzbTQ);
        return new StringBuilder((String.valueOf(str).length() + 18) + String.valueOf(valueOf).length()).append("CapabilityInfo{").append(str).append(", ").append(valueOf).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        df.m2115a(this, parcel, i);
    }

    public List<zzcc> zzUt() {
        return this.zzbTQ;
    }
}
