package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MsgImage */
final class C4749p implements Creator<MsgImage> {
    C4749p() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m22726a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m22727a(i);
    }

    public MsgImage m22726a(Parcel parcel) {
        return new MsgImage(parcel);
    }

    public MsgImage[] m22727a(int i) {
        return new MsgImage[i];
    }
}
