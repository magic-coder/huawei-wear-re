package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class C0563u implements Creator<zzat> {
    static void m2209a(zzat com_google_android_gms_wearable_internal_zzat, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzat.statusCode);
        C0438c.m749b(parcel, 3, com_google_android_gms_wearable_internal_zzat.zzbUt, false);
        C0438c.m729a(parcel, a);
    }

    public zzat m2210a(Parcel parcel) {
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
                    list = C0436a.m703c(parcel, a, zzo.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzat(i, list);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzat[] m2211a(int i) {
        return new zzat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2210a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2211a(i);
    }
}
