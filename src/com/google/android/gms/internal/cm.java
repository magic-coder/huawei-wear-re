package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.internal.zzacp.zza;
import java.util.ArrayList;

public class cm implements Creator<zzacp> {
    static void m1156a(zzacp com_google_android_gms_internal_zzacp, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_internal_zzacp.zzaiI);
        C0438c.m749b(parcel, 2, com_google_android_gms_internal_zzacp.zzyq(), false);
        C0438c.m729a(parcel, a);
    }

    public zzacp m1157a(Parcel parcel) {
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
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacp(i, arrayList);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzacp[] m1158a(int i) {
        return new zzacp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1157a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1158a(i);
    }
}
