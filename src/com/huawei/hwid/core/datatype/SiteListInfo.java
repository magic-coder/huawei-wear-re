package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class SiteListInfo implements Parcelable {
    public static final Creator<SiteListInfo> CREATOR = new C51911();
    public static final String TAG_CHILD_AGE = "child-age";
    public static final String TAG_CHILD_MANAGER = "child-manager";
    public static final String TAG_NAME_EN = "name-en";
    public static final String TAG_NAME_ZH = "name-zh";
    public static final String TAG_PERSONAL_DATA_COPY = "personal-data-copy";
    public static final String TAG_SITE_ID = "id";
    public static final String TAG_UNREGISTER = "unregister";
    public static final String TAG_YOUTH_AGE = "youth-age";
    private int f18707a = 0;
    private String f18708b = "";
    private String f18709c = "";
    private int f18710d = 0;
    private int f18711e = 0;
    private int f18712f = 0;
    private int f18713g = 0;
    private int f18714h = 0;
    private List<String> f18715i = new ArrayList();

    final class C51911 implements Creator<SiteListInfo> {
        C51911() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25171a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25172a(i);
        }

        public SiteListInfo m25171a(Parcel parcel) {
            SiteListInfo siteListInfo = new SiteListInfo();
            siteListInfo.f18707a = parcel.readInt();
            siteListInfo.f18708b = parcel.readString();
            siteListInfo.f18709c = parcel.readString();
            siteListInfo.f18710d = parcel.readInt();
            siteListInfo.f18711e = parcel.readInt();
            siteListInfo.f18712f = parcel.readInt();
            siteListInfo.f18713g = parcel.readInt();
            siteListInfo.f18714h = parcel.readInt();
            parcel.readStringList(siteListInfo.f18715i);
            return siteListInfo;
        }

        public SiteListInfo[] m25172a(int i) {
            return new SiteListInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f18707a);
        parcel.writeString(this.f18708b);
        parcel.writeString(this.f18709c);
        parcel.writeInt(this.f18710d);
        parcel.writeInt(this.f18711e);
        parcel.writeInt(this.f18712f);
        parcel.writeInt(this.f18713g);
        parcel.writeInt(this.f18714h);
        parcel.readStringList(this.f18715i);
    }
}
