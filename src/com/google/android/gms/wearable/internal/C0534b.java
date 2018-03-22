package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0534b implements Creator<zzaa> {
    static void m1953a(zzaa com_google_android_gms_wearable_internal_zzaa, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzaa.statusCode);
        C0438c.m729a(parcel, a);
    }

    public zzaa m1954a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaa(i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzaa[] m1955a(int i) {
        return new zzaa[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1954a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1955a(i);
    }
}
