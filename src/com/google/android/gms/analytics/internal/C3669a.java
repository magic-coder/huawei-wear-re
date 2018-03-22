package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Command */
final class C3669a implements Creator<Command> {
    C3669a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m18406a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m18407a(i);
    }

    public Command m18406a(Parcel parcel) {
        return new Command(parcel);
    }

    public Command[] m18407a(int i) {
        return new Command[i];
    }
}
