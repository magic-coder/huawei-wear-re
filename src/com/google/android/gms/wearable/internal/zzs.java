package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0521h;

public final class zzs extends zza {
    public static final Creator<zzs> CREATOR = new dj();
    final int type;
    final int zzbTU;
    final int zzbTV;
    final zzu zzbTW;

    public zzs(zzu com_google_android_gms_wearable_internal_zzu, int i, int i2, int i3) {
        this.zzbTW = com_google_android_gms_wearable_internal_zzu;
        this.type = i;
        this.zzbTU = i2;
        this.zzbTV = i3;
    }

    private static String zzpr(int i) {
        switch (i) {
            case 1:
                return "CHANNEL_OPENED";
            case 2:
                return "CHANNEL_CLOSED";
            case 3:
                return "INPUT_CLOSED";
            case 4:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzps(int i) {
        switch (i) {
            case 0:
                return "CLOSE_REASON_NORMAL";
            case 1:
                return "CLOSE_REASON_DISCONNECTED";
            case 2:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case 3:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzbTW);
        String valueOf2 = String.valueOf(zzpr(this.type));
        String valueOf3 = String.valueOf(zzps(this.zzbTU));
        return new StringBuilder(((String.valueOf(valueOf).length() + 81) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("ChannelEventParcelable[, channel=").append(valueOf).append(", type=").append(valueOf2).append(", closeReason=").append(valueOf3).append(", appErrorCode=").append(this.zzbTV).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        dj.m2122a(this, parcel, i);
    }

    public void zza(C0521h c0521h) {
        switch (this.type) {
            case 1:
                c0521h.mo1905a(this.zzbTW);
                return;
            case 2:
                c0521h.mo1906a(this.zzbTW, this.zzbTU, this.zzbTV);
                return;
            case 3:
                c0521h.mo1911b(this.zzbTW, this.zzbTU, this.zzbTV);
                return;
            case 4:
                c0521h.mo1913c(this.zzbTW, this.zzbTU, this.zzbTV);
                return;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
                return;
        }
    }
}
