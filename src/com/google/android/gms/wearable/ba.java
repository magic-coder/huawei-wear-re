package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ba implements Creator<PutDataRequest> {
    static void m1721a(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m738a(parcel, 2, putDataRequest.getUri(), i, false);
        C0438c.m735a(parcel, 4, putDataRequest.zzUg(), false);
        C0438c.m743a(parcel, 5, putDataRequest.getData(), false);
        C0438c.m734a(parcel, 6, putDataRequest.zzUh());
        C0438c.m729a(parcel, a);
    }

    public PutDataRequest m1722a(Parcel parcel) {
        byte[] bArr = null;
        int b = C0436a.m700b(parcel);
        long j = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 2:
                    uri = (Uri) C0436a.m697a(parcel, a, Uri.CREATOR);
                    break;
                case 4:
                    bundle = C0436a.m715n(parcel, a);
                    break;
                case 5:
                    bArr = C0436a.m716o(parcel, a);
                    break;
                case 6:
                    j = C0436a.m708g(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PutDataRequest(uri, bundle, bArr, j);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public PutDataRequest[] m1723a(int i) {
        return new PutDataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1722a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1723a(i);
    }
}
