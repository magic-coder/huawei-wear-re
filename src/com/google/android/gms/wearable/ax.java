package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class ax implements Creator<Asset> {
    static void m1715a(Asset asset, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m743a(parcel, 2, asset.getData(), false);
        C0438c.m740a(parcel, 3, asset.getDigest(), false);
        C0438c.m738a(parcel, 4, asset.zzbSM, i, false);
        C0438c.m738a(parcel, 5, asset.uri, i, false);
        C0438c.m729a(parcel, a);
    }

    public Asset m1716a(Parcel parcel) {
        Uri uri = null;
        int b = C0436a.m700b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            ParcelFileDescriptor parcelFileDescriptor2;
            String str2;
            byte[] o;
            Uri uri2;
            int a = C0436a.m695a(parcel);
            Uri uri3;
            switch (C0436a.m694a(a)) {
                case 2:
                    uri3 = uri;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    str2 = str;
                    o = C0436a.m716o(parcel, a);
                    uri2 = uri3;
                    break;
                case 3:
                    o = bArr;
                    ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptor;
                    str2 = C0436a.m713l(parcel, a);
                    uri2 = uri;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 4:
                    str2 = str;
                    o = bArr;
                    uri3 = uri;
                    parcelFileDescriptor2 = (ParcelFileDescriptor) C0436a.m697a(parcel, a, ParcelFileDescriptor.CREATOR);
                    uri2 = uri3;
                    break;
                case 5:
                    uri2 = (Uri) C0436a.m697a(parcel, a, Uri.CREATOR);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    str2 = str;
                    o = bArr;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    uri2 = uri;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    str2 = str;
                    o = bArr;
                    break;
            }
            bArr = o;
            str = str2;
            parcelFileDescriptor = parcelFileDescriptor2;
            uri = uri2;
        }
        if (parcel.dataPosition() == b) {
            return new Asset(bArr, str, parcelFileDescriptor, uri);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public Asset[] m1717a(int i) {
        return new Asset[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1716a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1717a(i);
    }
}
