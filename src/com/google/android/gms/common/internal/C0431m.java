package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0431m implements Creator<zzd> {
    static void m679a(zzd com_google_android_gms_common_internal_zzd, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_common_internal_zzd.zzaiI);
        C0438c.m736a(parcel, 2, com_google_android_gms_common_internal_zzd.zzaEW, false);
        C0438c.m744a(parcel, 3, com_google_android_gms_common_internal_zzd.zzaEX, i, false);
        C0438c.m739a(parcel, 4, com_google_android_gms_common_internal_zzd.zzaEY, false);
        C0438c.m739a(parcel, 5, com_google_android_gms_common_internal_zzd.zzaEZ, false);
        C0438c.m729a(parcel, a);
    }

    public zzd m680a(Parcel parcel) {
        Integer num = null;
        int b = C0436a.m700b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    iBinder = C0436a.m714m(parcel, a);
                    break;
                case 3:
                    scopeArr = (Scope[]) C0436a.m702b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = C0436a.m707f(parcel, a);
                    break;
                case 5:
                    num = C0436a.m707f(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzd(i, iBinder, scopeArr, num2, num);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzd[] m681a(int i) {
        return new zzd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m680a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m681a(i);
    }
}
