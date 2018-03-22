package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class bi implements Creator<zzce> {
    static void m1982a(zzce com_google_android_gms_wearable_internal_zzce, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzce.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzce.zzbTW, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzce m1983a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzu com_google_android_gms_wearable_internal_zzu = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzu = (zzu) C0436a.m697a(parcel, a, zzu.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzce(i, com_google_android_gms_wearable_internal_zzu);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzce[] m1984a(int i) {
        return new zzce[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1983a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1984a(i);
    }
}
