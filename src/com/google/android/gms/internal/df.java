package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class df implements Creator<zzayz> {
    static void m1194a(zzayz com_google_android_gms_internal_zzayz, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, com_google_android_gms_internal_zzayz.name, false);
        C0438c.m734a(parcel, 3, com_google_android_gms_internal_zzayz.zzbBC);
        C0438c.m742a(parcel, 4, com_google_android_gms_internal_zzayz.zzbhn);
        C0438c.m731a(parcel, 5, com_google_android_gms_internal_zzayz.zzbhp);
        C0438c.m740a(parcel, 6, com_google_android_gms_internal_zzayz.zzaGV, false);
        C0438c.m743a(parcel, 7, com_google_android_gms_internal_zzayz.zzbBD, false);
        C0438c.m733a(parcel, 8, com_google_android_gms_internal_zzayz.zzbBE);
        C0438c.m733a(parcel, 9, com_google_android_gms_internal_zzayz.zzbBF);
        C0438c.m729a(parcel, a);
    }

    public zzayz m1195a(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int b = C0436a.m700b(parcel);
        long j = 0;
        double d = 0.0d;
        int i2 = 0;
        String str = null;
        boolean z = false;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    j = C0436a.m708g(parcel, a);
                    break;
                case 4:
                    z = C0436a.m704c(parcel, a);
                    break;
                case 5:
                    d = C0436a.m711j(parcel, a);
                    break;
                case 6:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 7:
                    bArr = C0436a.m716o(parcel, a);
                    break;
                case 8:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 9:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzayz(str2, j, z, d, str, bArr, i2, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzayz[] m1196a(int i) {
        return new zzayz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1195a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1196a(i);
    }
}
