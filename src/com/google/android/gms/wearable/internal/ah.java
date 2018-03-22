package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ah implements Creator<zzbp> {
    static void m1799a(zzbp com_google_android_gms_wearable_internal_zzbp, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbp.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzbp.zzbyd, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbp m1800a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0436a.m697a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbp(i, parcelFileDescriptor);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbp[] m1801a(int i) {
        return new zzbp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1800a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1801a(i);
    }
}
