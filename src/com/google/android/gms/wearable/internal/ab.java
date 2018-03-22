package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ab implements Creator<zzbe> {
    static void m1781a(zzbe com_google_android_gms_wearable_internal_zzbe, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbe.statusCode);
        C0438c.m742a(parcel, 3, com_google_android_gms_wearable_internal_zzbe.zzbUx);
        C0438c.m742a(parcel, 4, com_google_android_gms_wearable_internal_zzbe.zzbUy);
        C0438c.m729a(parcel, a);
    }

    public zzbe m1782a(Parcel parcel) {
        boolean z = false;
        int b = C0436a.m700b(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    z2 = C0436a.m704c(parcel, a);
                    break;
                case 4:
                    z = C0436a.m704c(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbe(i, z2, z);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbe[] m1783a(int i) {
        return new zzbe[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1782a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1783a(i);
    }
}
