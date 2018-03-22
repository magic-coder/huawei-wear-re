package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class C6441a implements Creator<TextAndMediaPath> {
    C6441a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m29358a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m29359a(i);
    }

    public TextAndMediaPath m29358a(Parcel parcel) {
        return new TextAndMediaPath(parcel);
    }

    public TextAndMediaPath[] m29359a(int i) {
        return new TextAndMediaPath[i];
    }
}
