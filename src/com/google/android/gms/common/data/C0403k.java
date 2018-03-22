package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0403k implements Creator<DataHolder> {
    static void m476a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m745a(parcel, 1, dataHolder.zzxl(), false);
        C0438c.m744a(parcel, 2, dataHolder.zzxm(), i, false);
        C0438c.m733a(parcel, 3, dataHolder.getStatusCode());
        C0438c.m735a(parcel, 4, dataHolder.zzxf(), false);
        C0438c.m733a(parcel, 1000, dataHolder.zzaiI);
        C0438c.m729a(parcel, a);
    }

    public DataHolder m477a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = C0436a.m700b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    strArr = C0436a.m724w(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0436a.m702b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 4:
                    bundle = C0436a.m715n(parcel, a);
                    break;
                case 1000:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new C0437b("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zzxk();
        return dataHolder;
    }

    public DataHolder[] m478a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m477a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m478a(i);
    }
}
