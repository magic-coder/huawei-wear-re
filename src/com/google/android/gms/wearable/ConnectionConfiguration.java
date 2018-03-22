package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class ConnectionConfiguration extends zza implements ReflectedParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new az();
    private final String mName;
    private final int zzaLu;
    private final String zzaSq;
    private boolean zzagx;
    private final int zzakD;
    private final boolean zzbSP;
    private String zzbSQ;
    private boolean zzbSR;
    private String zzbSS;

    ConnectionConfiguration(String str, String str2, int i, int i2, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.mName = str;
        this.zzaSq = str2;
        this.zzakD = i;
        this.zzaLu = i2;
        this.zzbSP = z;
        this.zzagx = z2;
        this.zzbSQ = str3;
        this.zzbSR = z3;
        this.zzbSS = str4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return C0421c.m647a(this.mName, connectionConfiguration.mName) && C0421c.m647a(this.zzaSq, connectionConfiguration.zzaSq) && C0421c.m647a(Integer.valueOf(this.zzakD), Integer.valueOf(connectionConfiguration.zzakD)) && C0421c.m647a(Integer.valueOf(this.zzaLu), Integer.valueOf(connectionConfiguration.zzaLu)) && C0421c.m647a(Boolean.valueOf(this.zzbSP), Boolean.valueOf(connectionConfiguration.zzbSP)) && C0421c.m647a(Boolean.valueOf(this.zzbSR), Boolean.valueOf(connectionConfiguration.zzbSR));
    }

    public String getAddress() {
        return this.zzaSq;
    }

    public String getName() {
        return this.mName;
    }

    public String getNodeId() {
        return this.zzbSS;
    }

    public int getRole() {
        return this.zzaLu;
    }

    public int getType() {
        return this.zzakD;
    }

    public int hashCode() {
        return C0421c.m645a(this.mName, this.zzaSq, Integer.valueOf(this.zzakD), Integer.valueOf(this.zzaLu), Boolean.valueOf(this.zzbSP), Boolean.valueOf(this.zzbSR));
    }

    public boolean isConnected() {
        return this.zzagx;
    }

    public boolean isEnabled() {
        return this.zzbSP;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        String str = "mName=";
        String valueOf = String.valueOf(this.mName);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        str = ", mAddress=";
        valueOf = String.valueOf(this.zzaSq);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append(", mType=" + this.zzakD);
        stringBuilder.append(", mRole=" + this.zzaLu);
        stringBuilder.append(", mEnabled=" + this.zzbSP);
        stringBuilder.append(", mIsConnected=" + this.zzagx);
        str = ", mPeerNodeId=";
        valueOf = String.valueOf(this.zzbSQ);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append(", mBtlePriority=" + this.zzbSR);
        str = ", mNodeId=";
        valueOf = String.valueOf(this.zzbSS);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        az.m1718a(this, parcel, i);
    }

    public String zzUe() {
        return this.zzbSQ;
    }

    public boolean zzUf() {
        return this.zzbSR;
    }
}
