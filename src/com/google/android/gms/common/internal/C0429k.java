package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0429k implements Creator<zzan> {
    static void m673a(zzan com_google_android_gms_common_internal_zzan, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_common_internal_zzan.zzaiI);
        C0438c.m729a(parcel, a);
    }

    public zzan m674a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzan(i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzan[] m675a(int i) {
        return new zzan[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m674a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m675a(i);
    }
}
