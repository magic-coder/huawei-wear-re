package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;

public class C0416h implements Creator<WebImage> {
    static void m514a(WebImage webImage, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, webImage.zzaiI);
        C0438c.m738a(parcel, 2, webImage.getUrl(), i, false);
        C0438c.m733a(parcel, 3, webImage.getWidth());
        C0438c.m733a(parcel, 4, webImage.getHeight());
        C0438c.m729a(parcel, a);
    }

    public WebImage m515a(Parcel parcel) {
        int i = 0;
        int b = C0436a.m700b(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            Uri uri2;
            int e;
            int a = C0436a.m695a(parcel);
            int i4;
            switch (C0436a.m694a(a)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    e = C0436a.m706e(parcel, a);
                    a = i4;
                    break;
                case 2:
                    e = i3;
                    i4 = i2;
                    uri2 = (Uri) C0436a.m697a(parcel, a, Uri.CREATOR);
                    a = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    e = i3;
                    i4 = i;
                    i = C0436a.m706e(parcel, a);
                    a = i4;
                    break;
                case 4:
                    a = C0436a.m706e(parcel, a);
                    i = i2;
                    uri2 = uri;
                    e = i3;
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    a = i;
                    i = i2;
                    uri2 = uri;
                    e = i3;
                    break;
            }
            i3 = e;
            uri = uri2;
            i2 = i;
            i = a;
        }
        if (parcel.dataPosition() == b) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public WebImage[] m516a(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m515a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m516a(i);
    }
}
