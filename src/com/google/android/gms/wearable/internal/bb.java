package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class bb implements Creator<zzbz> {
    static void m1956a(zzbz com_google_android_gms_wearable_internal_zzbz, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbz.getRequestId());
        C0438c.m740a(parcel, 3, com_google_android_gms_wearable_internal_zzbz.getPath(), false);
        C0438c.m743a(parcel, 4, com_google_android_gms_wearable_internal_zzbz.getData(), false);
        C0438c.m740a(parcel, 5, com_google_android_gms_wearable_internal_zzbz.getSourceNodeId(), false);
        C0438c.m729a(parcel, a);
    }

    public zzbz m1957a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        byte[] bArr = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    bArr = C0436a.m716o(parcel, a);
                    break;
                case 5:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbz(i, str2, bArr, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbz[] m1958a(int i) {
        return new zzbz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1957a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1958a(i);
    }
}
