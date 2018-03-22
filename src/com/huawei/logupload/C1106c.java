package com.huawei.logupload;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LogUpload */
class C1106c implements Creator<LogUpload> {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4919a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4920a(i);
    }

    C1106c() {
    }

    public LogUpload m4919a(Parcel parcel) {
        return new LogUpload(parcel);
    }

    public LogUpload[] m4920a(int i) {
        return new LogUpload[i];
    }
}
