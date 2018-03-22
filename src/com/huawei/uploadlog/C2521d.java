package com.huawei.uploadlog;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LogUpload */
final class C2521d implements Creator<LogUpload> {
    C2521d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12598a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12599a(i);
    }

    public LogUpload m12598a(Parcel parcel) {
        return new LogUpload(parcel);
    }

    public LogUpload[] m12599a(int i) {
        return new LogUpload[i];
    }
}
