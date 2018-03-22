package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.internal.zzacw.zza;
import com.google.android.gms.internal.zzacw.zzb;
import java.util.ArrayList;

public class cs implements Creator<zza> {
    static void m1171a(zza com_google_android_gms_internal_zzacw_zza, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacw_zza.versionCode);
        C0438c.m740a(parcel, 2, com_google_android_gms_internal_zzacw_zza.className, false);
        C0438c.m749b(parcel, 3, com_google_android_gms_internal_zzacw_zza.zzaHk, false);
        C0438c.m729a(parcel, a);
    }

    public zza m1172a(Parcel parcel) {
        ArrayList arrayList = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    arrayList = C0436a.m703c(parcel, a, zzb.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(i, str, arrayList);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zza[] m1173a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1172a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1173a(i);
    }
}
