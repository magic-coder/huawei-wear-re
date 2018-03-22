package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class dj implements Creator<zzs> {
    static void m2122a(zzs com_google_android_gms_wearable_internal_zzs, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m738a(parcel, 2, com_google_android_gms_wearable_internal_zzs.zzbTW, i, false);
        C0438c.m733a(parcel, 3, com_google_android_gms_wearable_internal_zzs.type);
        C0438c.m733a(parcel, 4, com_google_android_gms_wearable_internal_zzs.zzbTU);
        C0438c.m733a(parcel, 5, com_google_android_gms_wearable_internal_zzs.zzbTV);
        C0438c.m729a(parcel, a);
    }

    public zzs m2123a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        zzu com_google_android_gms_wearable_internal_zzu = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            zzu com_google_android_gms_wearable_internal_zzu2;
            int a = C0436a.m695a(parcel);
            int i4;
            switch (C0436a.m694a(a)) {
                case 2:
                    i4 = i;
                    i = i2;
                    i2 = i3;
                    com_google_android_gms_wearable_internal_zzu2 = (zzu) C0436a.m697a(parcel, a, zzu.CREATOR);
                    a = i4;
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzu2 = com_google_android_gms_wearable_internal_zzu;
                    i4 = i2;
                    i2 = C0436a.m706e(parcel, a);
                    a = i;
                    i = i4;
                    break;
                case 4:
                    i2 = i3;
                    com_google_android_gms_wearable_internal_zzu2 = com_google_android_gms_wearable_internal_zzu;
                    i4 = i;
                    i = C0436a.m706e(parcel, a);
                    a = i4;
                    break;
                case 5:
                    a = C0436a.m706e(parcel, a);
                    i = i2;
                    i2 = i3;
                    com_google_android_gms_wearable_internal_zzu2 = com_google_android_gms_wearable_internal_zzu;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    a = i;
                    i = i2;
                    i2 = i3;
                    com_google_android_gms_wearable_internal_zzu2 = com_google_android_gms_wearable_internal_zzu;
                    break;
            }
            com_google_android_gms_wearable_internal_zzu = com_google_android_gms_wearable_internal_zzu2;
            i3 = i2;
            i2 = i;
            i = a;
        }
        if (parcel.dataPosition() == b) {
            return new zzs(com_google_android_gms_wearable_internal_zzu, i3, i2, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzs[] m2124a(int i) {
        return new zzs[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2123a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2124a(i);
    }
}
