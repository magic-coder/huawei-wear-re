package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0562t implements Creator<zzar> {
    static void m2206a(zzar com_google_android_gms_wearable_internal_zzar, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzar.statusCode);
        C0438c.m733a(parcel, 3, com_google_android_gms_wearable_internal_zzar.zzbUs);
        C0438c.m729a(parcel, a);
    }

    public zzar m2207a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzar(i2, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzar[] m2208a(int i) {
        return new zzar[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2207a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2208a(i);
    }
}
