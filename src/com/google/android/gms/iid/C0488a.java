package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0488a implements Creator<MessengerCompat> {
    C0488a() {
    }

    public MessengerCompat m845a(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
    }

    public MessengerCompat[] m846a(int i) {
        return new MessengerCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m845a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m846a(i);
    }
}
