package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: DataBuffer */
public class C0862b implements Parcelable {
    public static final Creator<C0862b> CREATOR = new C0863c();
    public String f1357a;
    public Bundle f1358b;
    private int f1359c;
    private Bundle f1360d;

    private C0862b(Parcel parcel) {
        this.f1359c = 1;
        this.f1358b = null;
        this.f1360d = null;
        m3032a(parcel);
    }

    public C0862b() {
        this.f1359c = 1;
        this.f1358b = null;
        this.f1360d = null;
    }

    public C0862b(String str, int i) {
        this.f1359c = 1;
        this.f1358b = null;
        this.f1360d = null;
        this.f1357a = str;
        this.f1359c = i;
    }

    public C0862b m3034a(Bundle bundle) {
        this.f1360d = bundle;
        return this;
    }

    public Bundle m3033a() {
        return this.f1360d;
    }

    public int m3035b() {
        return this.f1360d == null ? 0 : 1;
    }

    private void m3032a(Parcel parcel) {
        this.f1359c = parcel.readInt();
        this.f1357a = parcel.readString();
        this.f1358b = parcel.readBundle(C0862b.m3031a(Bundle.class));
        this.f1360d = parcel.readBundle(C0862b.m3031a(Bundle.class));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1359c);
        parcel.writeString(this.f1357a);
        parcel.writeBundle(this.f1358b);
        parcel.writeBundle(this.f1360d);
    }

    public int m3036c() {
        return this.f1359c;
    }

    private static ClassLoader m3031a(Class cls) {
        return cls.getClassLoader();
    }
}
