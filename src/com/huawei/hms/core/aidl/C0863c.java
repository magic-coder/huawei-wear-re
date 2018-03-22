package com.huawei.hms.core.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DataBuffer */
final class C0863c implements Creator<C0862b> {
    C0863c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3037a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3038a(i);
    }

    public C0862b m3037a(Parcel parcel) {
        return new C0862b(parcel);
    }

    public C0862b[] m3038a(int i) {
        return new C0862b[i];
    }
}
