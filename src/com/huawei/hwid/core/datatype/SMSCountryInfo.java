package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SMSCountryInfo implements Parcelable {
    public static final Creator<SMSCountryInfo> CREATOR = new C51881();
    public static final String TAG_COUNTRYCODE = "countryCode";
    public static final String TAG_COUNTRYINFO = "CountryInfo";
    public static final String TAG_COUNTRY_CALLINGCODE = "countryCallingCode";
    private String f18689a = "";
    private String f18690b = "";
    private String f18691c = "";

    final class C51881 implements Creator<SMSCountryInfo> {
        C51881() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25147a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25148a(i);
        }

        public SMSCountryInfo m25147a(Parcel parcel) {
            SMSCountryInfo sMSCountryInfo = new SMSCountryInfo();
            sMSCountryInfo.f18689a = parcel.readString();
            sMSCountryInfo.f18690b = parcel.readString();
            sMSCountryInfo.f18691c = parcel.readString();
            return sMSCountryInfo;
        }

        public SMSCountryInfo[] m25148a(int i) {
            return new SMSCountryInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18689a);
        parcel.writeString(this.f18690b);
        parcel.writeString(this.f18691c);
    }
}
