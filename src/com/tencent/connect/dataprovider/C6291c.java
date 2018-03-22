package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.connect.dataprovider.DataType.TextOnly;

/* compiled from: ProGuard */
final class C6291c implements Creator<TextOnly> {
    C6291c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m28877a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m28878a(i);
    }

    public TextOnly m28877a(Parcel parcel) {
        return new TextOnly(parcel);
    }

    public TextOnly[] m28878a(int i) {
        return new TextOnly[i];
    }
}
