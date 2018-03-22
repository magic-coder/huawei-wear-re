package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class SiteCountryInfo implements Parcelable {
    public static final Creator<SiteCountryInfo> CREATOR = new C51901();
    public static final String TAG_CHILD_AGE = "child-age";
    public static final String TAG_CHILD_MANAGER = "child-manager";
    public static final String TAG_ISO_CODE = "iso-2code";
    public static final String TAG_MCC = "mcc";
    public static final String TAG_NAME_EN = "name-en";
    public static final String TAG_NAME_ZH = "name-zh";
    public static final String TAG_PERSONAL_DATA_COPY = "personal-data-copy";
    public static final String TAG_SITE_ID = "site-id";
    public static final String TAG_SMS = "sms";
    public static final String TAG_TEL_CODE = "tel-code";
    public static final String TAG_UNREGISTER = "unregister";
    public static final String TAG_YOUTH_AGE = "youth-age";
    private String f18694a = "";
    private String f18695b = "";
    private String f18696c = "";
    private String f18697d = "";
    private int f18698e = 0;
    private int f18699f = 0;
    private String f18700g = "";
    private int f18701h = 0;
    private int f18702i = 0;
    private int f18703j = 0;
    private int f18704k = 0;
    private int f18705l = 0;
    private List<String> f18706m = new ArrayList();

    final class C51901 implements Creator<SiteCountryInfo> {
        C51901() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25156a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25157a(i);
        }

        public SiteCountryInfo m25156a(Parcel parcel) {
            SiteCountryInfo siteCountryInfo = new SiteCountryInfo();
            siteCountryInfo.f18694a = parcel.readString();
            siteCountryInfo.f18695b = parcel.readString();
            siteCountryInfo.f18696c = parcel.readString();
            siteCountryInfo.f18697d = parcel.readString();
            siteCountryInfo.f18700g = parcel.readString();
            siteCountryInfo.f18698e = parcel.readInt();
            siteCountryInfo.f18699f = parcel.readInt();
            siteCountryInfo.f18701h = parcel.readInt();
            siteCountryInfo.f18702i = parcel.readInt();
            siteCountryInfo.f18703j = parcel.readInt();
            siteCountryInfo.f18704k = parcel.readInt();
            siteCountryInfo.f18705l = parcel.readInt();
            parcel.readStringList(siteCountryInfo.f18706m);
            return siteCountryInfo;
        }

        public SiteCountryInfo[] m25157a(int i) {
            return new SiteCountryInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18694a);
        parcel.writeString(this.f18695b);
        parcel.writeString(this.f18696c);
        parcel.writeString(this.f18697d);
        parcel.writeString(this.f18700g);
        parcel.writeInt(this.f18698e);
        parcel.writeInt(this.f18699f);
        parcel.writeInt(this.f18701h);
        parcel.writeInt(this.f18702i);
        parcel.writeInt(this.f18703j);
        parcel.writeInt(this.f18704k);
        parcel.writeInt(this.f18705l);
        parcel.readStringList(this.f18706m);
    }
}
