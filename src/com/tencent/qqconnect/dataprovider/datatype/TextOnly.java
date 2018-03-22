package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class TextOnly implements Parcelable {
    public static final Creator<TextOnly> CREATOR = new C6442b();
    private String f22332a;

    public TextOnly(String str) {
        this.f22332a = str;
    }

    public String getText() {
        return this.f22332a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22332a);
    }

    private TextOnly(Parcel parcel) {
        this.f22332a = parcel.readString();
    }
}
