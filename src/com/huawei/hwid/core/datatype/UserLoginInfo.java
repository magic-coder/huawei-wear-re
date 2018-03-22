package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class UserLoginInfo implements Parcelable {
    public static final Creator<UserLoginInfo> CREATOR = new C51951();
    public static final String TAG_LASTLOGINTIME = "lastLoginTime";
    public static final String TAG_LAST_LOGINIP = "lastLoginIP";
    public static final String TAG_REGISTERCLIENT_IP = "registerClientIP";
    public static final String TAG_REGISTERFROM = "registerFrom";
    public static final String TAG_REGISTERTIME = "registerTime";
    public static final String TAG_REGISTER_CLIENTTYPE = "registerClientType";
    public static final String TAG_UNREGISTERTIME = "unRegisterTime";
    public static final String TAG_USER_ID = "userID";
    private String f18769a;
    private String f18770b;
    private String f18771c;
    private String f18772d;
    private String f18773e;
    private String f18774f;
    private String f18775g;
    private String f18776h;

    final class C51951 implements Creator<UserLoginInfo> {
        C51951() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25256a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25257a(i);
        }

        public UserLoginInfo m25256a(Parcel parcel) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.f18776h = parcel.readString();
            userLoginInfo.f18772d = parcel.readString();
            userLoginInfo.f18774f = parcel.readString();
            userLoginInfo.f18773e = parcel.readString();
            userLoginInfo.f18775g = parcel.readString();
            userLoginInfo.f18770b = parcel.readString();
            userLoginInfo.f18771c = parcel.readString();
            userLoginInfo.f18769a = parcel.readString();
            return userLoginInfo;
        }

        public UserLoginInfo[] m25257a(int i) {
            return new UserLoginInfo[i];
        }
    }

    private void m25259a(String str) {
        this.f18769a = str;
    }

    private void m25261b(String str) {
        this.f18770b = str;
    }

    private void m25263c(String str) {
        this.f18771c = str;
    }

    private void m25265d(String str) {
        this.f18772d = str;
    }

    private void m25267e(String str) {
        this.f18773e = str;
    }

    private void m25269f(String str) {
        this.f18774f = str;
    }

    private void m25271g(String str) {
        this.f18775g = str;
    }

    private void m25273h(String str) {
        this.f18776h = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18776h);
        parcel.writeString(this.f18772d);
        parcel.writeString(this.f18774f);
        parcel.writeString(this.f18773e);
        parcel.writeString(this.f18775g);
        parcel.writeString(this.f18770b);
        parcel.writeString(this.f18771c);
        parcel.writeString(this.f18769a);
    }

    public static void getUserLoginInfoInTag(XmlPullParser xmlPullParser, UserLoginInfo userLoginInfo, String str) throws XmlPullParserException, IOException {
        if (xmlPullParser != null && userLoginInfo != null && str != null) {
            if ("userID".equals(str)) {
                userLoginInfo.m25259a(xmlPullParser.nextText());
            } else if (TAG_REGISTERTIME.equals(str)) {
                userLoginInfo.m25261b(xmlPullParser.nextText());
            } else if (TAG_UNREGISTERTIME.equals(str)) {
                userLoginInfo.m25263c(xmlPullParser.nextText());
            } else if (TAG_LASTLOGINTIME.equals(str)) {
                userLoginInfo.m25265d(xmlPullParser.nextText());
            } else if (TAG_REGISTER_CLIENTTYPE.equals(str)) {
                userLoginInfo.m25267e(xmlPullParser.nextText());
            } else if (TAG_LAST_LOGINIP.equals(str)) {
                userLoginInfo.m25273h(xmlPullParser.nextText());
            } else if (TAG_REGISTERCLIENT_IP.equals(str)) {
                userLoginInfo.m25269f(xmlPullParser.nextText());
            } else if (TAG_REGISTERFROM.equals(str)) {
                userLoginInfo.m25271g(xmlPullParser.nextText());
            }
        }
    }
}
