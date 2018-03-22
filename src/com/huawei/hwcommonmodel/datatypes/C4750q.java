package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MsgText */
final class C4750q implements Creator<MsgText> {
    C4750q() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m22728a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m22729a(i);
    }

    public MsgText m22728a(Parcel parcel) {
        return new MsgText(parcel);
    }

    public MsgText[] m22729a(int i) {
        return new MsgText[i];
    }
}
