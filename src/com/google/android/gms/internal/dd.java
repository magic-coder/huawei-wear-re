package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class dd implements Creator<zzayx> {
    static void m1190a(zzayx com_google_android_gms_internal_zzayx, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_internal_zzayx.zzbBy);
        C0438c.m744a(parcel, 3, com_google_android_gms_internal_zzayx.zzbBz, i, false);
        C0438c.m745a(parcel, 4, com_google_android_gms_internal_zzayx.zzbBA, false);
        C0438c.m729a(parcel, a);
    }

    public zzayx m1191a(Parcel parcel) {
        String[] strArr = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        zzayz[] com_google_android_gms_internal_zzayzArr = null;
        while (parcel.dataPosition() < b) {
            zzayz[] com_google_android_gms_internal_zzayzArr2;
            int e;
            String[] strArr2;
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    String[] strArr3 = strArr;
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr;
                    e = C0436a.m706e(parcel, a);
                    strArr2 = strArr3;
                    break;
                case 3:
                    e = i;
                    zzayz[] com_google_android_gms_internal_zzayzArr3 = (zzayz[]) C0436a.m702b(parcel, a, zzayz.CREATOR);
                    strArr2 = strArr;
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr3;
                    break;
                case 4:
                    strArr2 = C0436a.m724w(parcel, a);
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr;
                    e = i;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    strArr2 = strArr;
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr;
                    e = i;
                    break;
            }
            i = e;
            com_google_android_gms_internal_zzayzArr = com_google_android_gms_internal_zzayzArr2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == b) {
            return new zzayx(i, com_google_android_gms_internal_zzayzArr, strArr);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzayx[] m1192a(int i) {
        return new zzayx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1191a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1192a(i);
    }
}
