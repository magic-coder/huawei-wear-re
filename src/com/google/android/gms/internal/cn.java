package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.internal.zzacp.zza;

public class cn implements Creator<zza> {
    static void m1159a(zza com_google_android_gms_internal_zzacp_zza, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacp_zza.versionCode);
        C0438c.m740a(parcel, 2, com_google_android_gms_internal_zzacp_zza.zzaGV, false);
        C0438c.m733a(parcel, 3, com_google_android_gms_internal_zzacp_zza.zzaGW);
        C0438c.m729a(parcel, a);
    }

    public zza m1160a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zza(i2, str, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zza[] m1161a(int i) {
        return new zza[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1160a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1161a(i);
    }
}
