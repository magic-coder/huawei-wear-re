package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class bk implements Creator<zzci> {
    static void m1988a(zzci com_google_android_gms_wearable_internal_zzci, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzci.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzci.zzbUC, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzci m1989a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzao com_google_android_gms_wearable_internal_zzao = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzao = (zzao) C0436a.m697a(parcel, a, zzao.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzci(i, com_google_android_gms_wearable_internal_zzao);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzci[] m1990a(int i) {
        return new zzci[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1989a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1990a(i);
    }
}
