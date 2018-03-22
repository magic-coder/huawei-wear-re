package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class cx implements Creator<zzh> {
    static void m2102a(zzh com_google_android_gms_wearable_internal_zzh, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m730a(parcel, 2, com_google_android_gms_wearable_internal_zzh.zzUk());
        C0438c.m730a(parcel, 3, com_google_android_gms_wearable_internal_zzh.zzUl());
        C0438c.m740a(parcel, 4, com_google_android_gms_wearable_internal_zzh.getValue(), false);
        C0438c.m729a(parcel, a);
    }

    public zzh m2103a(Parcel parcel) {
        byte b = (byte) 0;
        int b2 = C0436a.m700b(parcel);
        String str = null;
        byte b3 = (byte) 0;
        while (parcel.dataPosition() < b2) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    b3 = C0436a.m705d(parcel, a);
                    break;
                case 3:
                    b = C0436a.m705d(parcel, a);
                    break;
                case 4:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new zzh(b3, b, str);
        }
        throw new C0437b("Overread allowed size end=" + b2, parcel);
    }

    public zzh[] m2104a(int i) {
        return new zzh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2103a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2104a(i);
    }
}
