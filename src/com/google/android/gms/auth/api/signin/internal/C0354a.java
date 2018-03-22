package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0354a implements Creator<zzg> {
    static void m291a(zzg com_google_android_gms_auth_api_signin_internal_zzg, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, com_google_android_gms_auth_api_signin_internal_zzg.versionCode);
        C0438c.m733a(parcel, 2, com_google_android_gms_auth_api_signin_internal_zzg.getType());
        C0438c.m735a(parcel, 3, com_google_android_gms_auth_api_signin_internal_zzg.getBundle(), false);
        C0438c.m729a(parcel, a);
    }

    public zzg m292a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    bundle = C0436a.m715n(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzg(i2, i, bundle);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzg[] m293a(int i) {
        return new zzg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m292a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m293a(i);
    }
}
