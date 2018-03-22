package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class bj implements Creator<zzcg> {
    static void m1985a(zzcg com_google_android_gms_wearable_internal_zzcg, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, com_google_android_gms_wearable_internal_zzcg.packageName, false);
        C0438c.m740a(parcel, 3, com_google_android_gms_wearable_internal_zzcg.label, false);
        C0438c.m734a(parcel, 4, com_google_android_gms_wearable_internal_zzcg.zzbUP);
        C0438c.m729a(parcel, a);
    }

    public zzcg m1986a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        long j = 0;
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
                    j = C0436a.m708g(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzcg(str2, str, j);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzcg[] m1987a(int i) {
        return new zzcg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1986a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1987a(i);
    }
}
