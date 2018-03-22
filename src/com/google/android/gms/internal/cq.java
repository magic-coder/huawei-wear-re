package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.internal.zzacs.zza;
import com.google.android.gms.internal.zzacw.zzb;

public class cq implements Creator<zzb> {
    static void m1165a(zzb com_google_android_gms_internal_zzacw_zzb, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacw_zzb.versionCode);
        C0438c.m740a(parcel, 2, com_google_android_gms_internal_zzacw_zzb.zzaB, false);
        C0438c.m738a(parcel, 3, com_google_android_gms_internal_zzacw_zzb.zzaHl, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzb m1166a(Parcel parcel) {
        zza com_google_android_gms_internal_zzacs_zza = null;
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
                    com_google_android_gms_internal_zzacs_zza = (zza) C0436a.m697a(parcel, a, zza.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzb(i, str, com_google_android_gms_internal_zzacs_zza);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzb[] m1167a(int i) {
        return new zzb[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1166a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1167a(i);
    }
}
