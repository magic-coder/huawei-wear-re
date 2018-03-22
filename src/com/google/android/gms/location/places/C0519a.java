package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0519a implements Creator<PlaceReport> {
    static void m1654a(PlaceReport placeReport, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, placeReport.zzaiI);
        C0438c.m740a(parcel, 2, placeReport.getPlaceId(), false);
        C0438c.m740a(parcel, 3, placeReport.getTag(), false);
        C0438c.m740a(parcel, 4, placeReport.getSource(), false);
        C0438c.m729a(parcel, a);
    }

    public PlaceReport m1655a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str3 = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlaceReport(i, str3, str2, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public PlaceReport[] m1656a(int i) {
        return new PlaceReport[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1655a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1656a(i);
    }
}
