package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SMSKeyInfo implements Parcelable {
    public static final Creator<SMSKeyInfo> CREATOR = new C51891();
    public static final String TAG_KEY = "key";
    public static final String TAG_LANG = "lang";
    private String f18692a = "";
    private String f18693b = "";

    final class C51891 implements Creator<SMSKeyInfo> {
        C51891() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25152a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25153a(i);
        }

        public SMSKeyInfo m25152a(Parcel parcel) {
            SMSKeyInfo sMSKeyInfo = new SMSKeyInfo();
            sMSKeyInfo.f18692a = parcel.readString();
            sMSKeyInfo.f18693b = parcel.readString();
            return sMSKeyInfo;
        }

        public SMSKeyInfo[] m25153a(int i) {
            return new SMSKeyInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18692a);
        parcel.writeString(this.f18693b);
    }
}
