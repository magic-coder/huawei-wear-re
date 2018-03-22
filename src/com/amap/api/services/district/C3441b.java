package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DistrictResult */
class C3441b implements Creator<DistrictResult> {
    final /* synthetic */ DistrictResult f12552a;

    C3441b(DistrictResult districtResult) {
        this.f12552a = districtResult;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17042a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17043a(i);
    }

    public DistrictResult m17042a(Parcel parcel) {
        return new DistrictResult(parcel);
    }

    public DistrictResult[] m17043a(int i) {
        return new DistrictResult[i];
    }
}
