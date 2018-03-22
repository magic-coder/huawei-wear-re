package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0427i implements Creator<zzah> {
    static void m666a(zzah com_google_android_gms_common_internal_zzah, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_common_internal_zzah.zzaiI);
        C0438c.m733a(parcel, 2, com_google_android_gms_common_internal_zzah.zzyk());
        C0438c.m733a(parcel, 3, com_google_android_gms_common_internal_zzah.zzyl());
        C0438c.m744a(parcel, 4, com_google_android_gms_common_internal_zzah.zzym(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzah m667a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i3 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) C0436a.m702b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzah(i3, i2, i, scopeArr);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzah[] m668a(int i) {
        return new zzah[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m667a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m668a(i);
    }
}
