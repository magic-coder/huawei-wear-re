package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class df implements Creator<zzo> {
    static void m2115a(zzo com_google_android_gms_wearable_internal_zzo, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, com_google_android_gms_wearable_internal_zzo.getName(), false);
        C0438c.m749b(parcel, 3, com_google_android_gms_wearable_internal_zzo.zzUt(), false);
        C0438c.m729a(parcel, a);
    }

    public zzo m2116a(Parcel parcel) {
        List list = null;
        int b = C0436a.m700b(parcel);
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    list = C0436a.m703c(parcel, a, zzcc.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzo(str, list);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzo[] m2117a(int i) {
        return new zzo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2116a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2117a(i);
    }
}
