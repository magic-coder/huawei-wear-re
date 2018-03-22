package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class dt implements Creator<zzu> {
    static void m2153a(zzu com_google_android_gms_wearable_internal_zzu, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, com_google_android_gms_wearable_internal_zzu.getToken(), false);
        C0438c.m740a(parcel, 3, com_google_android_gms_wearable_internal_zzu.getNodeId(), false);
        C0438c.m740a(parcel, 4, com_google_android_gms_wearable_internal_zzu.getPath(), false);
        C0438c.m729a(parcel, a);
    }

    public zzu m2154a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    str3 = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzu(str3, str2, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzu[] m2155a(int i) {
        return new zzu[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2154a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2155a(i);
    }
}
