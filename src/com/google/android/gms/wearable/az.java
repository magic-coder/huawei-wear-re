package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class az implements Creator<ConnectionConfiguration> {
    static void m1718a(ConnectionConfiguration connectionConfiguration, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, connectionConfiguration.getName(), false);
        C0438c.m740a(parcel, 3, connectionConfiguration.getAddress(), false);
        C0438c.m733a(parcel, 4, connectionConfiguration.getType());
        C0438c.m733a(parcel, 5, connectionConfiguration.getRole());
        C0438c.m742a(parcel, 6, connectionConfiguration.isEnabled());
        C0438c.m742a(parcel, 7, connectionConfiguration.isConnected());
        C0438c.m740a(parcel, 8, connectionConfiguration.zzUe(), false);
        C0438c.m742a(parcel, 9, connectionConfiguration.zzUf());
        C0438c.m740a(parcel, 10, connectionConfiguration.getNodeId(), false);
        C0438c.m729a(parcel, a);
    }

    public ConnectionConfiguration m1719a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = C0436a.m700b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    str4 = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    str3 = C0436a.m713l(parcel, a);
                    break;
                case 4:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 5:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 6:
                    z3 = C0436a.m704c(parcel, a);
                    break;
                case 7:
                    z2 = C0436a.m704c(parcel, a);
                    break;
                case 8:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 9:
                    z = C0436a.m704c(parcel, a);
                    break;
                case 10:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionConfiguration(str4, str3, i2, i, z3, z2, str2, z, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public ConnectionConfiguration[] m1720a(int i) {
        return new ConnectionConfiguration[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1719a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1720a(i);
    }
}
