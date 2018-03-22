package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class dy implements Creator<zzy> {
    static void m2164a(zzy com_google_android_gms_wearable_internal_zzy, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzy.statusCode);
        C0438c.m729a(parcel, a);
    }

    public zzy m2165a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzy(i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzy[] m2166a(int i) {
        return new zzy[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2165a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2166a(i);
    }
}
