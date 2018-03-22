package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.internal.zzacs.zza;

public class cp implements Creator<zza> {
    static void m1162a(zza com_google_android_gms_internal_zzacs_zza, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacs_zza.getVersionCode());
        C0438c.m733a(parcel, 2, com_google_android_gms_internal_zzacs_zza.zzys());
        C0438c.m742a(parcel, 3, com_google_android_gms_internal_zzacs_zza.zzyt());
        C0438c.m733a(parcel, 4, com_google_android_gms_internal_zzacs_zza.zzyu());
        C0438c.m742a(parcel, 5, com_google_android_gms_internal_zzacs_zza.zzyv());
        C0438c.m740a(parcel, 6, com_google_android_gms_internal_zzacs_zza.zzyw(), false);
        C0438c.m733a(parcel, 7, com_google_android_gms_internal_zzacs_zza.zzyx());
        C0438c.m740a(parcel, 8, com_google_android_gms_internal_zzacs_zza.zzyz(), false);
        C0438c.m738a(parcel, 9, com_google_android_gms_internal_zzacs_zza.zzyB(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zza m1163a(Parcel parcel) {
        zzacn com_google_android_gms_internal_zzacn = null;
        int i = 0;
        int b = C0436a.m700b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i4 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    i3 = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    z2 = C0436a.m704c(parcel, a);
                    break;
                case 4:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 5:
                    z = C0436a.m704c(parcel, a);
                    break;
                case 6:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 7:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 8:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 9:
                    com_google_android_gms_internal_zzacn = (zzacn) C0436a.m697a(parcel, a, zzacn.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(i4, i3, z2, i2, z, str2, i, str, com_google_android_gms_internal_zzacn);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zza[] m1164a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1163a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1164a(i);
    }
}
