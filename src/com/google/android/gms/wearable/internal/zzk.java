package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.aw;

public final class zzk extends zza implements aw {
    public static final Creator<zzk> CREATOR = new cz();
    private final String mAppId;
    private int mId;
    private final String zzRg;
    private final String zzaZc;
    private final String zzakb;
    private final String zzamJ;
    private final String zzaoc;
    private final String zzbTD;
    private final byte zzbTE;
    private final byte zzbTF;
    private final byte zzbTG;
    private final byte zzbTH;

    public zzk(int i, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4, String str7) {
        this.mId = i;
        this.mAppId = str;
        this.zzbTD = str2;
        this.zzaoc = str3;
        this.zzamJ = str4;
        this.zzaZc = str5;
        this.zzakb = str6;
        this.zzbTE = b;
        this.zzbTF = b2;
        this.zzbTG = b3;
        this.zzbTH = b4;
        this.zzRg = str7;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzk com_google_android_gms_wearable_internal_zzk = (zzk) obj;
        if (this.mId != com_google_android_gms_wearable_internal_zzk.mId || this.zzbTE != com_google_android_gms_wearable_internal_zzk.zzbTE || this.zzbTF != com_google_android_gms_wearable_internal_zzk.zzbTF || this.zzbTG != com_google_android_gms_wearable_internal_zzk.zzbTG || this.zzbTH != com_google_android_gms_wearable_internal_zzk.zzbTH || !this.mAppId.equals(com_google_android_gms_wearable_internal_zzk.mAppId)) {
            return false;
        }
        if (this.zzbTD != null) {
            if (!this.zzbTD.equals(com_google_android_gms_wearable_internal_zzk.zzbTD)) {
                return false;
            }
        } else if (com_google_android_gms_wearable_internal_zzk.zzbTD != null) {
            return false;
        }
        if (!this.zzaoc.equals(com_google_android_gms_wearable_internal_zzk.zzaoc) || !this.zzamJ.equals(com_google_android_gms_wearable_internal_zzk.zzamJ) || !this.zzaZc.equals(com_google_android_gms_wearable_internal_zzk.zzaZc)) {
            return false;
        }
        if (this.zzakb != null) {
            if (!this.zzakb.equals(com_google_android_gms_wearable_internal_zzk.zzakb)) {
                return false;
            }
        } else if (com_google_android_gms_wearable_internal_zzk.zzakb != null) {
            return false;
        }
        if (this.zzRg != null) {
            z = this.zzRg.equals(com_google_android_gms_wearable_internal_zzk.zzRg);
        } else if (com_google_android_gms_wearable_internal_zzk.zzRg != null) {
            z = false;
        }
        return z;
    }

    public String getDisplayName() {
        return this.zzakb == null ? this.mAppId : this.zzakb;
    }

    public int getId() {
        return this.mId;
    }

    public String getPackageName() {
        return this.zzRg;
    }

    public String getTitle() {
        return this.zzamJ;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((this.zzakb != null ? this.zzakb.hashCode() : 0) + (((((((((this.zzbTD != null ? this.zzbTD.hashCode() : 0) + ((((this.mId + 31) * 31) + this.mAppId.hashCode()) * 31)) * 31) + this.zzaoc.hashCode()) * 31) + this.zzamJ.hashCode()) * 31) + this.zzaZc.hashCode()) * 31)) * 31) + this.zzbTE) * 31) + this.zzbTF) * 31) + this.zzbTG) * 31) + this.zzbTH) * 31;
        if (this.zzRg != null) {
            i = this.zzRg.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        int i = this.mId;
        String str = this.mAppId;
        String str2 = this.zzbTD;
        String str3 = this.zzaoc;
        String str4 = this.zzamJ;
        String str5 = this.zzaZc;
        String str6 = this.zzakb;
        byte b = this.zzbTE;
        byte b2 = this.zzbTF;
        byte b3 = this.zzbTG;
        byte b4 = this.zzbTH;
        String str7 = this.zzRg;
        return new StringBuilder(((((((String.valueOf(str).length() + 211) + String.valueOf(str2).length()) + String.valueOf(str3).length()) + String.valueOf(str4).length()) + String.valueOf(str5).length()) + String.valueOf(str6).length()) + String.valueOf(str7).length()).append("AncsNotificationParcelable{, id=").append(i).append(", appId='").append(str).append("'").append(", dateTime='").append(str2).append("'").append(", notificationText='").append(str3).append("'").append(", title='").append(str4).append("'").append(", subtitle='").append(str5).append("'").append(", displayName='").append(str6).append("'").append(", eventId=").append(b).append(", eventFlags=").append(b2).append(", categoryId=").append(b3).append(", categoryCount=").append(b4).append(", packageName='").append(str7).append("'").append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        cz.m2105a(this, parcel, i);
    }

    public String zzEv() {
        return this.zzaZc;
    }

    public String zzUm() {
        return this.zzbTD;
    }

    public String zzUn() {
        return this.zzaoc;
    }

    public byte zzUo() {
        return this.zzbTE;
    }

    public byte zzUp() {
        return this.zzbTF;
    }

    public byte zzUq() {
        return this.zzbTG;
    }

    public byte zzUr() {
        return this.zzbTH;
    }

    public String zzke() {
        return this.mAppId;
    }
}
