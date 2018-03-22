package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusinessArea */
final class C3445a implements Creator<BusinessArea> {
    C3445a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17048a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17049a(i);
    }

    public BusinessArea m17048a(Parcel parcel) {
        return new BusinessArea(parcel);
    }

    public BusinessArea[] m17049a(int i) {
        return new BusinessArea[i];
    }
}
