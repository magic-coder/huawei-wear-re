package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class dq implements Creator<zzban> {
    static void m1218a(zzban com_google_android_gms_internal_zzban, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzban.zzaiI);
        C0438c.m742a(parcel, 2, com_google_android_gms_internal_zzban.zzbEp);
        C0438c.m749b(parcel, 3, com_google_android_gms_internal_zzban.zzbEq, false);
        C0438c.m729a(parcel, a);
    }

    public zzban m1219a(Parcel parcel) {
        boolean z = false;
        int b = C0436a.m700b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    z = C0436a.m704c(parcel, a);
                    break;
                case 3:
                    list = C0436a.m703c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzban(i, z, list);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzban[] m1220a(int i) {
        return new zzban[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1219a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1220a(i);
    }
}
