package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0567z implements Creator<zzaz> {
    static void m2223a(zzaz com_google_android_gms_wearable_internal_zzaz, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzaz.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzaz.zzbUv, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzaz m2224a(Parcel parcel) {
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
            return new zzaz(i, parcelFileDescriptor);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzaz[] m2225a(int i) {
        return new zzaz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2224a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2225a(i);
    }
}
