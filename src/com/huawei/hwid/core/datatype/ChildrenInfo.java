package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ChildrenInfo implements Parcelable {
    public static final Creator<ChildrenInfo> CREATOR = new C51851();
    public static final String TAG_ACCOUNT_LOGIN_USER_NAME = "loginUserName";
    public static final String TAG_ACCOUNT_NAME = "accountname";
    public static final String TAG_ACCOUNT_NICK_NAME = "nickName";
    public static final String TAG_BIRTH_DATE = "birthDate";
    public static final String TAG_CHILDREN_INFO = "children";
    public static final String TAG_CHILDREN_INFO_LIST = "childrenList";
    public static final String TAG_CHILDREN_USER_ID = "childrenUserID";
    public static final String TAG_HEAD_PICTURE_URL = "headPictureURL";
    public static final String TAG_UNI_NICK_NAME = "uniquelyNickname";
    private String f18661a;
    private String f18662b;
    private String f18663c;
    private String f18664d;
    private String f18665e;
    private String f18666f;
    private String f18667g;

    final class C51851 implements Creator<ChildrenInfo> {
        C51851() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25074a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25075a(i);
        }

        public ChildrenInfo m25074a(Parcel parcel) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.f18661a = parcel.readString();
            childrenInfo.f18662b = parcel.readString();
            childrenInfo.f18663c = parcel.readString();
            childrenInfo.f18664d = parcel.readString();
            childrenInfo.f18665e = parcel.readString();
            childrenInfo.f18666f = parcel.readString();
            childrenInfo.f18667g = parcel.readString();
            return childrenInfo;
        }

        public ChildrenInfo[] m25075a(int i) {
            return new ChildrenInfo[i];
        }
    }

    private void m25077a(String str) {
        this.f18661a = str;
    }

    private void m25080b(String str) {
        this.f18662b = str;
    }

    private void m25082c(String str) {
        this.f18663c = str;
    }

    private void m25084d(String str) {
        this.f18664d = str;
    }

    private void m25086e(String str) {
        this.f18666f = str;
    }

    private void m25088f(String str) {
        this.f18667g = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18661a);
        parcel.writeString(this.f18662b);
        parcel.writeString(this.f18663c);
        parcel.writeString(this.f18664d);
        parcel.writeString(this.f18665e);
        parcel.writeString(this.f18666f);
        parcel.writeString(this.f18667g);
    }

    public static void m25078a(XmlPullParser xmlPullParser, ChildrenInfo childrenInfo, String str) throws XmlPullParserException, IOException {
        if (xmlPullParser != null && childrenInfo != null && str != null) {
            if (TAG_CHILDREN_USER_ID.equals(str)) {
                childrenInfo.m25077a(xmlPullParser.nextText());
            } else if ("birthDate".equals(str)) {
                childrenInfo.m25080b(xmlPullParser.nextText());
            } else if ("uniquelyNickname".equals(str)) {
                childrenInfo.m25082c(xmlPullParser.nextText());
            } else if ("headPictureURL".equals(str)) {
                childrenInfo.m25084d(xmlPullParser.nextText());
            } else if (TAG_ACCOUNT_NAME.equals(str)) {
                childrenInfo.m25084d(xmlPullParser.nextText());
            } else if ("nickName".equals(str)) {
                childrenInfo.m25086e(xmlPullParser.nextText());
            } else if ("loginUserName".equals(str)) {
                childrenInfo.m25088f(xmlPullParser.nextText());
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{'childrenUserID':");
        stringBuilder.append(this.f18661a);
        stringBuilder.append(",'birthDate':");
        stringBuilder.append(this.f18662b);
        stringBuilder.append(",'uniquelyNickname':");
        stringBuilder.append(this.f18663c);
        stringBuilder.append(",'headPictureURL':");
        stringBuilder.append(this.f18665e);
        stringBuilder.append(",'accountName':");
        stringBuilder.append(this.f18664d);
        stringBuilder.append(this.f18666f);
        stringBuilder.append(this.f18667g);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }
}
