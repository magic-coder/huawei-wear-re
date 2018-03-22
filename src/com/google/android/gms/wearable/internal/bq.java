package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class bq implements Creator<zzcs> {
    static void m2005a(zzcs com_google_android_gms_wearable_internal_zzcs, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzcs.statusCode);
        C0438c.m734a(parcel, 3, com_google_android_gms_wearable_internal_zzcs.zzbUP);
        C0438c.m749b(parcel, 4, com_google_android_gms_wearable_internal_zzcs.zzbUR, false);
        C0438c.m729a(parcel, a);
    }

    public zzcs m2006a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    j = C0436a.m708g(parcel, a);
                    break;
                case 4:
                    list = C0436a.m703c(parcel, a, zzcg.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzcs(i, j, list);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzcs[] m2007a(int i) {
        return new zzcs[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2006a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2007a(i);
    }
}
