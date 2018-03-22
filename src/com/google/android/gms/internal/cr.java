package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.internal.zzacw.zza;
import java.util.ArrayList;

public class cr implements Creator<zzacw> {
    static void m1168a(zzacw com_google_android_gms_internal_zzacw, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacw.zzaiI);
        C0438c.m749b(parcel, 2, com_google_android_gms_internal_zzacw.zzyE(), false);
        C0438c.m740a(parcel, 3, com_google_android_gms_internal_zzacw.zzyF(), false);
        C0438c.m729a(parcel, a);
    }

    public zzacw m1169a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    arrayList = C0436a.m703c(parcel, a, zza.CREATOR);
                    break;
                case 3:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacw(i, arrayList, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzacw[] m1170a(int i) {
        return new zzacw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1169a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1170a(i);
    }
}
