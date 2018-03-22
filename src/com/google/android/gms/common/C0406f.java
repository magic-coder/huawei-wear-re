package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0406f implements Creator<ConnectionResult> {
    static void m488a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, connectionResult.zzaiI);
        C0438c.m733a(parcel, 2, connectionResult.getErrorCode());
        C0438c.m738a(parcel, 3, connectionResult.getResolution(), i, false);
        C0438c.m740a(parcel, 4, connectionResult.getErrorMessage(), false);
        C0438c.m729a(parcel, a);
    }

    public ConnectionResult m489a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C0436a.m700b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C0436a.m695a(parcel);
            String str3;
            switch (C0436a.m694a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C0436a.m706e(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C0436a.m706e(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C0436a.m697a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C0436a.m713l(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m490a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m489a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m490a(i);
    }
}
