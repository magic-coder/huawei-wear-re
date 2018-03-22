package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.common.internal.zzad;

public class dz implements Creator<zzbau> {
    static void m1264a(zzbau com_google_android_gms_internal_zzbau, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzbau.zzaiI);
        C0438c.m738a(parcel, 2, com_google_android_gms_internal_zzbau.zzPT(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbau m1265a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzad com_google_android_gms_common_internal_zzad = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    com_google_android_gms_common_internal_zzad = (zzad) C0436a.m697a(parcel, a, zzad.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbau(i, com_google_android_gms_common_internal_zzad);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbau[] m1266a(int i) {
        return new zzbau[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1265a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1266a(i);
    }
}
