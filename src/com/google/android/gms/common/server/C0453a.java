package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0453a implements Creator<FavaDiagnosticsEntity> {
    static void m790a(FavaDiagnosticsEntity favaDiagnosticsEntity, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, favaDiagnosticsEntity.zzaiI);
        C0438c.m740a(parcel, 2, favaDiagnosticsEntity.zzaGP, false);
        C0438c.m733a(parcel, 3, favaDiagnosticsEntity.zzaGQ);
        C0438c.m729a(parcel, a);
    }

    public FavaDiagnosticsEntity m791a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    i = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FavaDiagnosticsEntity(i2, str, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public FavaDiagnosticsEntity[] m792a(int i) {
        return new FavaDiagnosticsEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m791a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m792a(i);
    }
}
