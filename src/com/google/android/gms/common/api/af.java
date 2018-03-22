package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class af implements Creator<Scope> {
    static void m349a(Scope scope, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, scope.zzaiI);
        C0438c.m740a(parcel, 2, scope.zzvt(), false);
        C0438c.m729a(parcel, a);
    }

    public Scope m350a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public Scope[] m351a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m350a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m351a(i);
    }
}
