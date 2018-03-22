package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C0378p;
import com.google.android.gms.common.api.C0382t;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0421c;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.C0521h;
import com.google.android.gms.wearable.C0527e;
import com.google.android.gms.wearable.C0528f;
import com.google.android.gms.wearable.Channel;

public class zzu extends zza implements Channel {
    public static final Creator<zzu> CREATOR = new dt();
    private final String mPath;
    private final String zzaiJ;
    private final String zzbSS;

    public zzu(String str, String str2, String str3) {
        this.zzaiJ = (String) C0424f.m649a((Object) str);
        this.zzbSS = (String) C0424f.m649a((Object) str2);
        this.mPath = (String) C0424f.m649a((Object) str3);
    }

    private static C0537y<C0521h> zza(String str, IntentFilter[] intentFilterArr) {
        return new dq(str, intentFilterArr);
    }

    public C0382t<Status> addListener(C0378p c0378p, C0521h c0521h) {
        return C0566x.m2218a(c0378p, zza(this.zzaiJ, new IntentFilter[]{bs.m2008a("com.google.android.gms.wearable.CHANNEL_EVENT")}), c0521h);
    }

    public C0382t<Status> close(C0378p c0378p) {
        return c0378p.mo1839a(new dk(this, c0378p));
    }

    public C0382t<Status> close(C0378p c0378p, int i) {
        return c0378p.mo1839a(new dl(this, c0378p, i));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzu)) {
            return false;
        }
        zzu com_google_android_gms_wearable_internal_zzu = (zzu) obj;
        return this.zzaiJ.equals(com_google_android_gms_wearable_internal_zzu.zzaiJ) && C0421c.m647a(com_google_android_gms_wearable_internal_zzu.zzbSS, this.zzbSS) && C0421c.m647a(com_google_android_gms_wearable_internal_zzu.mPath, this.mPath);
    }

    public C0382t<C0527e> getInputStream(C0378p c0378p) {
        return c0378p.mo1839a(new dm(this, c0378p));
    }

    public String getNodeId() {
        return this.zzbSS;
    }

    public C0382t<C0528f> getOutputStream(C0378p c0378p) {
        return c0378p.mo1839a(new dn(this, c0378p));
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzaiJ;
    }

    public int hashCode() {
        return this.zzaiJ.hashCode();
    }

    public C0382t<Status> receiveFile(C0378p c0378p, Uri uri, boolean z) {
        C0424f.m650a((Object) c0378p, (Object) "client is null");
        C0424f.m650a((Object) uri, (Object) "uri is null");
        return c0378p.mo1839a(new C0541do(this, c0378p, uri, z));
    }

    public C0382t<Status> removeListener(C0378p c0378p, C0521h c0521h) {
        C0424f.m650a((Object) c0378p, (Object) "client is null");
        C0424f.m650a((Object) c0521h, (Object) "listener is null");
        return c0378p.mo1839a(new dh(c0378p, c0521h, this.zzaiJ));
    }

    public C0382t<Status> sendFile(C0378p c0378p, Uri uri) {
        return sendFile(c0378p, uri, 0, -1);
    }

    public C0382t<Status> sendFile(C0378p c0378p, Uri uri, long j, long j2) {
        C0424f.m650a((Object) c0378p, (Object) "client is null");
        C0424f.m650a(this.zzaiJ, (Object) "token is null");
        C0424f.m650a((Object) uri, (Object) "uri is null");
        C0424f.m659b(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        boolean z = j2 >= 0 || j2 == -1;
        C0424f.m659b(z, "invalid length: %s", Long.valueOf(j2));
        return c0378p.mo1839a(new dp(this, c0378p, uri, j, j2));
    }

    public String toString() {
        String str = this.zzaiJ;
        String str2 = this.zzbSS;
        String str3 = this.mPath;
        return new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append("ChannelImpl{, token='").append(str).append("'").append(", nodeId='").append(str2).append("'").append(", path='").append(str3).append("'").append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        dt.m2153a(this, parcel, i);
    }
}
