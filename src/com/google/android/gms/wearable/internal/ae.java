package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class ae implements Creator<zzbj> {
    static void m1790a(zzbj com_google_android_gms_wearable_internal_zzbj, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbj.statusCode);
        C0438c.m744a(parcel, 3, com_google_android_gms_wearable_internal_zzbj.zzbUA, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbj m1791a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        ConnectionConfiguration[] connectionConfigurationArr = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    connectionConfigurationArr = (ConnectionConfiguration[]) C0436a.m702b(parcel, a, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbj(i, connectionConfigurationArr);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbj[] m1792a(int i) {
        return new zzbj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1791a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1792a(i);
    }
}
