package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class cl implements Creator<zzacn> {
    static void m1153a(zzacn com_google_android_gms_internal_zzacn, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacn.zzaiI);
        C0438c.m738a(parcel, 2, com_google_android_gms_internal_zzacn.zzyo(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzacn m1154a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzacp com_google_android_gms_internal_zzacp = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    com_google_android_gms_internal_zzacp = (zzacp) C0436a.m697a(parcel, a, zzacp.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacn(i, com_google_android_gms_internal_zzacp);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzacn[] m1155a(int i) {
        return new zzacn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1154a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1155a(i);
    }
}
