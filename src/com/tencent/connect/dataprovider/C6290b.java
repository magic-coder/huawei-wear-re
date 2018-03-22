package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.connect.dataprovider.DataType.TextAndMediaPath;

/* compiled from: ProGuard */
final class C6290b implements Creator<TextAndMediaPath> {
    C6290b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m28875a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m28876a(i);
    }

    public TextAndMediaPath m28875a(Parcel parcel) {
        return new TextAndMediaPath(parcel);
    }

    public TextAndMediaPath[] m28876a(int i) {
        return new TextAndMediaPath[i];
    }
}
