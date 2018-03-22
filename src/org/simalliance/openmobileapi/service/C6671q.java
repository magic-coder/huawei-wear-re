package org.simalliance.openmobileapi.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: SmartcardError */
final class C6671q implements Creator<SmartcardError> {
    C6671q() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m30015a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m30016a(i);
    }

    public SmartcardError m30015a(Parcel parcel) {
        return new SmartcardError(parcel);
    }

    public SmartcardError[] m30016a(int i) {
        return new SmartcardError[i];
    }
}
