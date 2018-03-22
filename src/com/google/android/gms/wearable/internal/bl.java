package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class bl implements Creator<zzck> {
    static void m1991a(zzck com_google_android_gms_wearable_internal_zzck, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_wearable_internal_zzck.zzaiI);
        C0438c.m736a(parcel, 2, com_google_android_gms_wearable_internal_zzck.zzAh(), false);
        C0438c.m729a(parcel, a);
    }

    public zzck m1992a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    iBinder = C0436a.m714m(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzck(i, iBinder);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzck[] m1993a(int i) {
        return new zzck[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1992a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1993a(i);
    }
}
