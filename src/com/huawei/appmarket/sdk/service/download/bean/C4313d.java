package com.huawei.appmarket.sdk.service.download.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C4313d implements Creator<DownloadTask> {
    C4313d() {
    }

    public DownloadTask m20786a(Parcel parcel) {
        return new DownloadTask(parcel);
    }

    public DownloadTask[] m20787a(int i) {
        return new DownloadTask[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m20786a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m20787a(i);
    }
}
