package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0426h implements Creator<zzaf> {
    static void m663a(zzaf com_google_android_gms_common_internal_zzaf, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_common_internal_zzaf.zzaiI);
        C0438c.m736a(parcel, 2, com_google_android_gms_common_internal_zzaf.zzaEW, false);
        C0438c.m738a(parcel, 3, com_google_android_gms_common_internal_zzaf.zzyh(), i, false);
        C0438c.m742a(parcel, 4, com_google_android_gms_common_internal_zzaf.zzyi());
        C0438c.m742a(parcel, 5, com_google_android_gms_common_internal_zzaf.zzyj());
        C0438c.m729a(parcel, a);
    }

    public zzaf m664a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C0436a.m700b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    iBinder = C0436a.m714m(parcel, a);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) C0436a.m697a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = C0436a.m704c(parcel, a);
                    break;
                case 5:
                    z = C0436a.m704c(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaf(i, iBinder, connectionResult, z2, z);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzaf[] m665a(int i) {
        return new zzaf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m664a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m665a(i);
    }
}
