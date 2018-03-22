package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DistrictItem */
final class C3440a implements Creator<DistrictItem> {
    C3440a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17040a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17041a(i);
    }

    public DistrictItem m17040a(Parcel parcel) {
        return new DistrictItem(parcel);
    }

    public DistrictItem[] m17041a(int i) {
        return new DistrictItem[i];
    }
}
