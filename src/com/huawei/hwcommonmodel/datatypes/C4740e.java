package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DataPromptData */
final class C4740e implements Creator<DataPromptData> {
    C4740e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m22676a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m22677a(i);
    }

    public DataPromptData m22676a(Parcel parcel) {
        return new DataPromptData(parcel);
    }

    public DataPromptData[] m22677a(int i) {
        return new DataPromptData[i];
    }
}
