package com.huawei.pluginkidwatch.common.ui.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WaveView */
final class ap implements Creator<SavedState> {
    ap() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7251a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7252a(i);
    }

    public SavedState m7251a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m7252a(int i) {
        return new SavedState[i];
    }
}
