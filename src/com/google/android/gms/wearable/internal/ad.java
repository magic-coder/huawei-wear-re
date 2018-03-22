package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class ad implements Creator<zzbh> {
    static void m1787a(zzbh com_google_android_gms_wearable_internal_zzbh, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 2, com_google_android_gms_wearable_internal_zzbh.statusCode);
        C0438c.m738a(parcel, 3, com_google_android_gms_wearable_internal_zzbh.zzbUz, i, false);
        C0438c.m729a(parcel, a);
    }

    public zzbh m1788a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        ConnectionConfiguration connectionConfiguration = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 3:
                    connectionConfiguration = (ConnectionConfiguration) C0436a.m697a(parcel, a, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzbh(i, connectionConfiguration);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public zzbh[] m1789a(int i) {
        return new zzbh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1788a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1789a(i);
    }
}
