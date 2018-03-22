package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.C0351d;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg extends zza {
    public static final Creator<zzg> CREATOR = new C0354a();
    final int versionCode;
    private Bundle zzaic;
    private int zzakD;

    zzg(int i, int i2, Bundle bundle) {
        this.versionCode = i;
        this.zzakD = i2;
        this.zzaic = bundle;
    }

    public zzg(C0351d c0351d) {
        this(1, 1, c0351d.m284a());
    }

    public Bundle getBundle() {
        return this.zzaic;
    }

    public int getType() {
        return this.zzakD;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0354a.m291a(this, parcel, i);
    }
}
