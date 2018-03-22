package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0556o implements Creator<DataItemAssetParcelable> {
    static void m2195a(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m740a(parcel, 2, dataItemAssetParcelable.getId(), false);
        C0438c.m740a(parcel, 3, dataItemAssetParcelable.getDataItemKey(), false);
        C0438c.m729a(parcel, a);
    }

    public DataItemAssetParcelable m2196a(Parcel parcel) {
        String str = null;
        int b = C0436a.m700b(parcel);
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 3:
                    str = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DataItemAssetParcelable(str2, str);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public DataItemAssetParcelable[] m2197a(int i) {
        return new DataItemAssetParcelable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m2196a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2197a(i);
    }
}
