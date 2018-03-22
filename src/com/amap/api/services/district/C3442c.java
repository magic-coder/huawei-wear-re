package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DistrictSearchQuery */
final class C3442c implements Creator<DistrictSearchQuery> {
    C3442c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17044a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17045a(i);
    }

    public DistrictSearchQuery m17044a(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(parcel.readString());
        districtSearchQuery.setKeywordsLevel(parcel.readString());
        districtSearchQuery.setPageNum(parcel.readInt());
        districtSearchQuery.setPageSize(parcel.readInt());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        districtSearchQuery.setShowChild(z);
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        districtSearchQuery.setShowBoundary(z2);
        return districtSearchQuery;
    }

    public DistrictSearchQuery[] m17045a(int i) {
        return new DistrictSearchQuery[i];
    }
}
