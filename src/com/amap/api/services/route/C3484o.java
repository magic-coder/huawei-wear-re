package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.FromAndTo;

/* compiled from: RouteSearch */
final class C3484o implements Creator<FromAndTo> {
    C3484o() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17149a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17150a(i);
    }

    public FromAndTo m17149a(Parcel parcel) {
        return new FromAndTo(parcel);
    }

    public FromAndTo[] m17150a(int i) {
        return new FromAndTo[i];
    }
}
