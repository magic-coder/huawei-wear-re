package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class bh implements Creator<zzcc> {
    static void m1979a(zzcc com_google_android_gms_wearable_internal_zzcc, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, com_google_android_gms_wearable_internal_zzcc.getId(), false);
        C0438c.m740a(parcel, 3, com_google_android_gms_wearable_internal_zzcc.getDisplayName(), false);
        C0438c.m733a(parcel, 4, com_google_android_gms_wearable_internal_zzcc.getHopCount());
        C0438c.m742a(parcel, 5, com_google_android_gms_wearable_internal_zzcc.isNearby());
        C0438c.m729a(parcel, a);
    }

    public zzcc m1980a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = C0436a.m700b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 5:
                    z = C0436a.m704c(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzcc(str2, str, i, z);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzcc[] m1981a(int i) {
        return new zzcc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1980a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1981a(i);
    }
}
