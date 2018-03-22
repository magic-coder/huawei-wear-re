package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ag implements Creator<zzbn> {
    static void m1796a(zzbn com_google_android_gms_wearable_internal_zzbn, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbn.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzbn.zzbUC, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbn m1797a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzao com_google_android_gms_wearable_internal_zzao = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_wearable_internal_zzao = (zzao) C0436a.m697a(parcel, a, zzao.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbn(i, com_google_android_gms_wearable_internal_zzao);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbn[] m1798a(int i) {
        return new zzbn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1797a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1798a(i);
    }
}
