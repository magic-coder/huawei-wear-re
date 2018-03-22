package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ct implements Creator<zzacz> {
    static void m1174a(zzacz com_google_android_gms_internal_zzacz, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacz.getVersionCode());
        C0438c.m737a(parcel, 2, com_google_android_gms_internal_zzacz.zzyH(), false);
        C0438c.m738a(parcel, 3, com_google_android_gms_internal_zzacz.zzyI(), i, false);
        C0438c.m729a(parcel, a);
    }

    public zzacz m1175a(Parcel parcel) {
        zzacw com_google_android_gms_internal_zzacw = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    parcel2 = C0436a.m726y(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_internal_zzacw = (zzacw) C0436a.m697a(parcel, a, zzacw.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacz(i, parcel2, com_google_android_gms_internal_zzacw);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzacz[] m1176a(int i) {
        return new zzacz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1175a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1176a(i);
    }
}
