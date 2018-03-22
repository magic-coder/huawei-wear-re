package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ai implements Creator<zzbr> {
    static void m1802a(zzbr com_google_android_gms_wearable_internal_zzbr, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbr.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzbr.zzbUD, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbr m1803a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzcc com_google_android_gms_wearable_internal_zzcc = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzcc = (zzcc) C0436a.m697a(parcel, a, zzcc.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbr(i, com_google_android_gms_wearable_internal_zzcc);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbr[] m1804a(int i) {
        return new zzbr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1803a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1804a(i);
    }
}
