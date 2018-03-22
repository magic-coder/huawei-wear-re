package com.huawei.hwid.core.datatype;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.C5184o;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.log4j.helpers.DateLayout;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class DeviceInfo implements Parcelable {
    public static final Creator<DeviceInfo> CREATOR = new C51861();
    public static final String TAG_DEVICE_ALIASNAME = "deviceAliasName";
    public static final String TAG_DEVICE_FREQUENTLYUSED = "frequentlyUsed";
    public static final String TAG_DEVICE_ID = "deviceID";
    public static final String TAG_DEVICE_INFO = "deviceInfo";
    public static final String TAG_DEVICE_INFO_LIST = "deviceIDList";
    public static final String TAG_DEVICE_LOGINTIME = "loginTime";
    public static final String TAG_DEVICE_LOGOUTTIME = "logoutTime";
    public static final String TAG_DEVICE_TYPE = "deviceType";
    public static final String TAG_TERMINALTYPE = "terminalType";
    public static final String TAG_UUID = "uuid";
    private String f18668a;
    private String f18669b;
    private String f18670c;
    private String f18671d;
    private String f18672e;
    private String f18673f;
    private String f18674g = "";

    final class C51861 implements Creator<DeviceInfo> {
        C51861() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25090a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25091a(i);
        }

        public DeviceInfo m25090a(Parcel parcel) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.f18669b = parcel.readString();
            deviceInfo.f18671d = parcel.readString();
            deviceInfo.f18668a = parcel.readString();
            deviceInfo.f18670c = parcel.readString();
            deviceInfo.f18672e = parcel.readString();
            deviceInfo.f18673f = parcel.readString();
            deviceInfo.f18674g = parcel.readString();
            return deviceInfo;
        }

        public DeviceInfo[] m25091a(int i) {
            return new DeviceInfo[i];
        }
    }

    public DeviceInfo(String str, String str2, String str3) {
        this.f18668a = str;
        this.f18669b = str2;
        this.f18670c = str3;
    }

    public void setDeviceIdInDeviceInfo(String str) {
        this.f18669b = str;
    }

    public void setDeviceType(String str) {
        this.f18668a = str;
    }

    public void setTerminalType(String str) {
        this.f18670c = str;
    }

    public String getDeviceID() {
        return this.f18669b;
    }

    public String getTerminalType() {
        return this.f18670c;
    }

    public String getDeviceType() {
        return this.f18668a;
    }

    public String getDeviceAliasName() {
        return this.f18671d;
    }

    public void setDeviceAliasName(String str) {
        this.f18671d = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getmLoginTime() {
        return this.f18672e;
    }

    public void setmLoginTime(String str) {
        this.f18672e = str;
    }

    public String getmLogoutTime() {
        return this.f18673f;
    }

    public void setmLogoutTime(String str) {
        this.f18673f = str;
    }

    public String getmFrequentlyUsed() {
        return this.f18674g;
    }

    public void setmFrequentlyUsed(String str) {
        this.f18674g = str;
    }

    public boolean isLogin() {
        if (TextUtils.isEmpty(this.f18673f) && !TextUtils.isEmpty(this.f18672e)) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18669b);
        parcel.writeString(this.f18671d);
        parcel.writeString(this.f18668a);
        parcel.writeString(this.f18670c);
        parcel.writeString(this.f18672e);
        parcel.writeString(this.f18673f);
        parcel.writeString(this.f18674g);
    }

    public boolean isObjectEquals(Object obj) {
        if (obj == null || !(obj instanceof DeviceInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (C5181l.m25040b(this.f18671d, deviceInfo.f18671d) && C5181l.m25040b(this.f18669b, deviceInfo.f18669b) && C5181l.m25040b(this.f18670c, deviceInfo.f18670c) && C5181l.m25040b(this.f18668a, deviceInfo.f18668a)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{'mDeviceAliasName':");
        stringBuilder.append(this.f18671d);
        stringBuilder.append(",'mDeviceID':");
        stringBuilder.append(this.f18669b);
        stringBuilder.append(",'mTerminalType':");
        stringBuilder.append(this.f18670c);
        stringBuilder.append(",'mDeviceType':");
        stringBuilder.append(this.f18668a);
        stringBuilder.append(",'mLoginTime':");
        stringBuilder.append(this.f18672e);
        stringBuilder.append(",'mLogoutTime':");
        stringBuilder.append(this.f18673f);
        stringBuilder.append(",'mFrequentlyUsed':");
        stringBuilder.append(this.f18674g);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean isTrusted() {
        return this.f18674g.equals("1") && C5181l.m25043d(this.f18669b);
    }

    public boolean isCurrent(Context context) {
        if (TextUtils.isEmpty(this.f18669b) || !C5182m.m25054b(context).equals(this.f18669b)) {
            return false;
        }
        return true;
    }

    public String getLoginTime() {
        if (TextUtils.isEmpty(this.f18672e)) {
            return "";
        }
        return m25093a(this.f18672e);
    }

    public String getLogoutTime() {
        if (TextUtils.isEmpty(this.f18673f)) {
            return "";
        }
        return m25093a(this.f18673f);
    }

    private static String m25093a(String str) {
        String str2 = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
        try {
            str2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(simpleDateFormat.parse(str));
        } catch (Exception e) {
            C5165e.m24910d("uuid", "format error");
        }
        return str2;
    }

    public static void getDeviceInfoInTag(XmlPullParser xmlPullParser, DeviceInfo deviceInfo, String str) throws XmlPullParserException, IOException {
        if (xmlPullParser != null && deviceInfo != null && str != null) {
            if ("deviceID".equals(str)) {
                deviceInfo.setDeviceIdInDeviceInfo(xmlPullParser.nextText());
            } else if ("deviceType".equals(str)) {
                deviceInfo.setDeviceType(xmlPullParser.nextText());
            } else if ("terminalType".equals(str)) {
                deviceInfo.setTerminalType(xmlPullParser.nextText());
            } else if (TAG_DEVICE_ALIASNAME.equals(str)) {
                deviceInfo.setDeviceAliasName(xmlPullParser.nextText());
            } else if (TAG_DEVICE_LOGINTIME.equals(str)) {
                deviceInfo.setmLoginTime(xmlPullParser.nextText());
            } else if (TAG_DEVICE_LOGOUTTIME.equals(str)) {
                deviceInfo.setmLogoutTime(xmlPullParser.nextText());
            } else if (TAG_DEVICE_FREQUENTLYUSED.equals(str)) {
                deviceInfo.setmFrequentlyUsed(xmlPullParser.nextText());
            }
        }
    }

    public static void setDeviceInfoInTag(XmlSerializer xmlSerializer, DeviceInfo deviceInfo) throws IllegalArgumentException, IllegalStateException, IOException {
        if (xmlSerializer != null && deviceInfo != null) {
            C5184o.m25072a(xmlSerializer, "deviceID", deviceInfo.getDeviceID());
            C5184o.m25072a(xmlSerializer, "deviceType", deviceInfo.getDeviceType());
            C5184o.m25072a(xmlSerializer, "terminalType", deviceInfo.getTerminalType());
            C5184o.m25072a(xmlSerializer, TAG_DEVICE_ALIASNAME, deviceInfo.getDeviceAliasName());
        }
    }

    public static boolean isDeviceIdNULL(String str) {
        return TextUtils.isEmpty(str) || DateLayout.NULL_DATE_FORMAT.equals(str);
    }
}
