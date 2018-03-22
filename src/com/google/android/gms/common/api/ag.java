package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ag implements Creator<Status> {
    static void m352a(Status status, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, status.getStatusCode());
        C0438c.m740a(parcel, 2, status.getStatusMessage(), false);
        C0438c.m738a(parcel, 3, status.zzvu(), i, false);
        C0438c.m733a(parcel, 1000, status.zzaiI);
        C0438c.m729a(parcel, a);
    }

    public Status m353a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C0436a.m700b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) C0436a.m697a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public Status[] m354a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m353a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m354a(i);
    }
}
