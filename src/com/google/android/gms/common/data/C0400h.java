package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0400h implements Creator<BitmapTeleporter> {
    static void m469a(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, bitmapTeleporter.zzaiI);
        C0438c.m738a(parcel, 2, bitmapTeleporter.zzSQ, i, false);
        C0438c.m733a(parcel, 3, bitmapTeleporter.zzakD);
        C0438c.m729a(parcel, a);
    }

    public BitmapTeleporter m470a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int e;
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    e = C0436a.m706e(parcel, a);
                    a = i3;
                    break;
                case 2:
                    e = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) C0436a.m697a(parcel, a, ParcelFileDescriptor.CREATOR);
                    a = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    a = C0436a.m706e(parcel, a);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    e = i2;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    a = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    e = i2;
                    break;
            }
            i2 = e;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = a;
        }
        if (parcel.dataPosition() == b) {
            return new BitmapTeleporter(i2, parcelFileDescriptor, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public BitmapTeleporter[] m471a(int i) {
        return new BitmapTeleporter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m470a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m471a(i);
    }
}
