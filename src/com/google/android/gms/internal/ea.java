package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.common.internal.zzaf;

public class ea implements Creator<zzbaw> {
    static void m1267a(zzbaw com_google_android_gms_internal_zzbaw, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzbaw.zzaiI);
        C0438c.m738a(parcel, 2, com_google_android_gms_internal_zzbaw.zzyh(), i, false);
        C0438c.m738a(parcel, 3, com_google_android_gms_internal_zzbaw.zzPU(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbaw m1268a(Parcel parcel) {
        zzaf com_google_android_gms_common_internal_zzaf = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int e;
            zzaf com_google_android_gms_common_internal_zzaf2;
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    zzaf com_google_android_gms_common_internal_zzaf3 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult;
                    e = C0436a.m706e(parcel, a);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf3;
                    break;
                case 2:
                    e = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C0436a.m697a(parcel, a, ConnectionResult.CREATOR);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    com_google_android_gms_common_internal_zzaf2 = (zzaf) C0436a.m697a(parcel, a, zzaf.CREATOR);
                    connectionResult2 = connectionResult;
                    e = i;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    com_google_android_gms_common_internal_zzaf2 = com_google_android_gms_common_internal_zzaf;
                    connectionResult2 = connectionResult;
                    e = i;
                    break;
            }
            i = e;
            connectionResult = connectionResult2;
            com_google_android_gms_common_internal_zzaf = com_google_android_gms_common_internal_zzaf2;
        }
        if (parcel.dataPosition() == b) {
            return new zzbaw(i, connectionResult, com_google_android_gms_common_internal_zzaf);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbaw[] m1269a(int i) {
        return new zzbaw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1268a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1269a(i);
    }
}
