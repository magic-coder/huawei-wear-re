package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TmemberRight implements Parcelable {
    public static final Creator<TmemberRight> CREATOR = new C51921();
    public static final String TAG_DEVICEID = "deviceId";
    public static final String TAG_DEVICEID2 = "deviceID2";
    public static final String TAG_DEVICETYPE = "deviceType";
    public static final String TAG_EXPIREDDATE = "expiredDate";
    public static final String TAG_MEMBERBINDTIME = "memberBindTime";
    public static final String TAG_RIGHTSID = "rightsID";
    public static final String TAG_TERMINALTYPE = "terminalType";
    public static final String TAG_USERID = "userID";
    private long f18716a;
    private int f18717b;
    private String f18718c;
    private String f18719d;
    private String f18720e;
    private int f18721f;
    private String f18722g;
    private String f18723h;

    final class C51921 implements Creator<TmemberRight> {
        C51921() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25182a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25183a(i);
        }

        public TmemberRight m25182a(Parcel parcel) {
            TmemberRight tmemberRight = new TmemberRight();
            tmemberRight.f18716a = parcel.readLong();
            tmemberRight.f18717b = parcel.readInt();
            tmemberRight.f18718c = parcel.readString();
            tmemberRight.f18719d = parcel.readString();
            tmemberRight.f18720e = parcel.readString();
            tmemberRight.f18721f = parcel.readInt();
            tmemberRight.f18722g = parcel.readString();
            tmemberRight.f18723h = parcel.readString();
            return tmemberRight;
        }

        public TmemberRight[] m25183a(int i) {
            return new TmemberRight[i];
        }
    }

    public void m25194a(long j) {
        this.f18716a = j;
    }

    public void m25193a(int i) {
        this.f18717b = i;
    }

    public void m25195a(String str) {
        this.f18718c = str;
    }

    public void m25196b(String str) {
        this.f18719d = this.f18718c;
    }

    public void m25197c(String str) {
        this.f18720e = str;
    }

    public void m25198d(String str) {
        try {
            this.f18721f = Integer.parseInt(str);
        } catch (Exception e) {
            C5165e.m24906b("TmemberRight", e.getMessage());
        }
    }

    public void m25199e(String str) {
        this.f18722g = str;
    }

    public void m25200f(String str) {
        String str2 = "";
        try {
            str2 = C5166b.m24917a(str, "yyyy-MM-dd", "yyyyMMdd");
        } catch (Exception e) {
            C5165e.m24908c("TmemberRight", e.getMessage());
        }
        this.f18723h = str2;
    }

    public static void m25187a(XmlPullParser xmlPullParser, TmemberRight tmemberRight, String str) throws XmlPullParserException, IOException {
        if (xmlPullParser != null && tmemberRight != null && str != null) {
            if ("userID".equals(str)) {
                tmemberRight.m25194a(Long.parseLong(xmlPullParser.nextText()));
            } else if ("deviceType".equals(str)) {
                try {
                    tmemberRight.m25193a(Integer.parseInt(xmlPullParser.nextText()));
                } catch (Exception e) {
                    C5165e.m24906b("TmemberRight", e.getMessage());
                }
            } else if ("deviceId".equals(str)) {
                tmemberRight.m25195a(xmlPullParser.nextText());
            } else if ("deviceID2".equals(str)) {
                tmemberRight.m25196b(xmlPullParser.nextText());
            } else if ("terminalType".equals(str)) {
                tmemberRight.m25197c(xmlPullParser.nextText());
            } else if (TAG_RIGHTSID.equals(str)) {
                tmemberRight.m25198d(xmlPullParser.nextText());
            } else if (TAG_MEMBERBINDTIME.equals(str)) {
                tmemberRight.m25199e(xmlPullParser.nextText());
            } else if (TAG_EXPIREDDATE.equals(str)) {
                tmemberRight.m25200f(xmlPullParser.nextText());
            } else {
                C5165e.m24906b("TmemberRight", "in getTmemberRightTag nodeName:" + str + " is unknow");
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f18716a);
        parcel.writeInt(this.f18717b);
        parcel.writeString(this.f18718c);
        parcel.writeString(this.f18719d);
        parcel.writeString(this.f18720e);
        parcel.writeInt(this.f18721f);
        parcel.writeString(this.f18722g);
        parcel.writeString(this.f18723h);
    }
}
