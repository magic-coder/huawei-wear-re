package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.C5184o;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class UserAccountInfo implements Parcelable {
    public static final Creator<UserAccountInfo> CREATOR = new C51931();
    public static final String TAG_ACCOUNTVALID_STATUS = "accountValidStatus";
    public static final String TAG_ACCOUNT_STATE = "accountState";
    public static final String TAG_ACCOUNT_TYPE = "accountType";
    public static final String TAG_MEMBERRIGHT = "memberRight";
    public static final String TAG_MEMBERRIGHTLIST = "memberRightList";
    public static final String TAG_MOBILEPHONE = "mobilePhone";
    public static final String TAG_MOBILE_PHONE_STATE = "mobilePhoneState";
    public static final String TAG_UPDATE_TIME = "updateTime";
    public static final String TAG_USERACCINFO = "userAcctInfo";
    public static final String TAG_USERACCTINFO_LIST = "userAcctInfoList";
    public static final String TAG_USEREMAIL = "userEMail";
    public static final String TAG_USER_ACCOUNT = "userAccount";
    public static final String TAG_USER_EMAIL_STATE = "emailState";
    private String f18724a;
    private String f18725b;
    private String f18726c;
    private String f18727d;
    private String f18728e;
    private String f18729f;
    private String f18730g;
    private String f18731h;
    private String f18732i;

    final class C51931 implements Creator<UserAccountInfo> {
        C51931() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25201a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25202a(i);
        }

        public UserAccountInfo m25201a(Parcel parcel) {
            UserAccountInfo userAccountInfo = new UserAccountInfo();
            userAccountInfo.f18724a = parcel.readString();
            userAccountInfo.f18725b = parcel.readString();
            userAccountInfo.f18726c = parcel.readString();
            userAccountInfo.f18727d = parcel.readString();
            userAccountInfo.f18728e = parcel.readString();
            userAccountInfo.f18729f = parcel.readString();
            userAccountInfo.f18730g = parcel.readString();
            userAccountInfo.f18731h = parcel.readString();
            userAccountInfo.f18732i = parcel.readString();
            return userAccountInfo;
        }

        public UserAccountInfo[] m25202a(int i) {
            return new UserAccountInfo[i];
        }
    }

    public String getAccountType() {
        return this.f18724a;
    }

    public void setAccountType(String str) {
        this.f18724a = str;
    }

    public String getUserAccount() {
        return this.f18725b;
    }

    public void setUserAccount(String str) {
        this.f18725b = str;
    }

    public String getAccountState() {
        return this.f18726c;
    }

    public void setAccountState(String str) {
        this.f18726c = str;
    }

    private void m25204a(String str) {
        this.f18727d = str;
    }

    private void m25206b(String str) {
        this.f18728e = str;
    }

    private void m25208c(String str) {
        this.f18729f = str;
    }

    private void m25210d(String str) {
        this.f18730g = str;
    }

    private void m25212e(String str) {
        this.f18731h = str;
    }

    private void m25214f(String str) {
        this.f18732i = str;
    }

    public int describeContents() {
        return 0;
    }

    public static void setUserAccInfoInTag(XmlSerializer xmlSerializer, UserAccountInfo userAccountInfo) throws IllegalArgumentException, IllegalStateException, IOException {
        if (xmlSerializer != null && userAccountInfo != null) {
            C5184o.m25072a(xmlSerializer, "accountType", userAccountInfo.getAccountType());
            C5184o.m25072a(xmlSerializer, "userAccount", userAccountInfo.getUserAccount());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18724a);
        parcel.writeString(this.f18725b);
        parcel.writeString(this.f18726c);
        parcel.writeString(this.f18727d);
        parcel.writeString(this.f18728e);
        parcel.writeString(this.f18729f);
        parcel.writeString(this.f18730g);
        parcel.writeString(this.f18731h);
        parcel.writeString(this.f18732i);
    }

    public boolean isObjectEquals(Object obj) {
        if (obj == null || !(obj instanceof UserAccountInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (C5181l.m25040b(this.f18730g, ((UserAccountInfo) obj).f18730g)) {
            return true;
        }
        return false;
    }

    public static void getUserAccInfoInTag(XmlPullParser xmlPullParser, UserAccountInfo userAccountInfo, String str) throws XmlPullParserException, IOException {
        if (xmlPullParser != null && userAccountInfo != null && str != null) {
            if (TAG_ACCOUNT_STATE.equals(str)) {
                userAccountInfo.setAccountState(xmlPullParser.nextText());
            } else if ("accountType".equals(str)) {
                userAccountInfo.setAccountType(xmlPullParser.nextText());
            } else if (TAG_ACCOUNTVALID_STATUS.equals(str)) {
                userAccountInfo.m25204a(xmlPullParser.nextText());
            } else if ("updateTime".equals(str)) {
                userAccountInfo.m25206b(xmlPullParser.nextText());
            } else if ("userAccount".equals(str)) {
                userAccountInfo.setUserAccount(xmlPullParser.nextText());
            } else if (TAG_USEREMAIL.equals(str)) {
                userAccountInfo.m25208c(xmlPullParser.nextText());
            } else if (TAG_MOBILEPHONE.equals(str)) {
                userAccountInfo.m25210d(xmlPullParser.nextText());
            } else if (TAG_USER_EMAIL_STATE.equals(str)) {
                userAccountInfo.m25212e(xmlPullParser.nextText());
            } else if (TAG_MOBILE_PHONE_STATE.equals(str)) {
                userAccountInfo.m25214f(xmlPullParser.nextText());
            }
        }
    }
}
