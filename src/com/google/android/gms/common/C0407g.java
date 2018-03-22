package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0407g implements Creator<zzc> {
    static void m491a(zzc com_google_android_gms_common_zzc, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 1, com_google_android_gms_common_zzc.name, false);
        C0438c.m733a(parcel, 2, com_google_android_gms_common_zzc.version);
        C0438c.m729a(parcel, a);
    }

    public zzc m492a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzc(str, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzc[] m493a(int i) {
        return new zzc[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m492a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m493a(i);
    }
}
