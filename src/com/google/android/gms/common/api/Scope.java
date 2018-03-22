package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Scope extends zza implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new af();
    final int zzaiI;
    private final String zzazw;

    Scope(int i, String str) {
        C0424f.m652a(str, (Object) "scopeUri must not be null or empty");
        this.zzaiI = i;
        this.zzazw = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.zzazw.equals(((Scope) obj).zzazw);
    }

    public int hashCode() {
        return this.zzazw.hashCode();
    }

    public String toString() {
        return this.zzazw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        af.m349a(this, parcel, i);
    }

    public String zzvt() {
        return this.zzazw;
    }
}
