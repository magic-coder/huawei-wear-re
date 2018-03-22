package com.unionpay.blepayservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Channel */
class C6550a implements Creator<Channel> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m29913a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m29914a(i);
    }

    C6550a() {
    }

    public Channel m29913a(Parcel parcel) {
        return new Channel(parcel);
    }

    public Channel[] m29914a(int i) {
        return new Channel[i];
    }
}
