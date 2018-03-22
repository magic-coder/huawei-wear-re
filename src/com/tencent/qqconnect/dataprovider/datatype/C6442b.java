package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class C6442b implements Creator<TextOnly> {
    C6442b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m29360a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m29361a(i);
    }

    public TextOnly m29360a(Parcel parcel) {
        return new TextOnly(parcel);
    }

    public TextOnly[] m29361a(int i) {
        return new TextOnly[i];
    }
}
