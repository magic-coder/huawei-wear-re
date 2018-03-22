package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0499do implements Creator<zzbak> {
    static void m1215a(zzbak com_google_android_gms_internal_zzbak, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzbak.zzaiI);
        C0438c.m733a(parcel, 2, com_google_android_gms_internal_zzbak.zzPP());
        C0438c.m738a(parcel, 3, com_google_android_gms_internal_zzbak.zzPQ(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbak m1216a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    intent = (Intent) C0436a.m697a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbak(i2, i, intent);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbak[] m1217a(int i) {
        return new zzbak[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1216a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1217a(i);
    }
}
