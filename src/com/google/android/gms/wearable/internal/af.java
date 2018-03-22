package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class af implements Creator<zzbl> {
    static void m1793a(zzbl com_google_android_gms_wearable_internal_zzbl, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbl.statusCode);
        C0438c.m749b(parcel, 3, com_google_android_gms_wearable_internal_zzbl.zzbUB, false);
        C0438c.m729a(parcel, a);
    }

    public zzbl m1794a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    list = C0436a.m703c(parcel, a, zzcc.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbl(i, list);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbl[] m1795a(int i) {
        return new zzbl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1794a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1795a(i);
    }
}
