package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0417a implements Creator<BinderWrapper> {
    C0417a() {
    }

    public BinderWrapper m517a(Parcel parcel) {
        return new BinderWrapper(parcel);
    }

    public BinderWrapper[] m518a(int i) {
        return new BinderWrapper[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m517a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m518a(i);
    }
}
