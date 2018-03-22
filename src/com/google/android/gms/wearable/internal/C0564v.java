package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0564v implements Creator<zzav> {
    static void m2212a(zzav com_google_android_gms_wearable_internal_zzav, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzav.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzav.zzbUu, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzav m2213a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzo com_google_android_gms_wearable_internal_zzo = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzo = (zzo) C0436a.m697a(parcel, a, zzo.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzav(i, com_google_android_gms_wearable_internal_zzo);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzav[] m2214a(int i) {
        return new zzav[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2213a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2214a(i);
    }
}