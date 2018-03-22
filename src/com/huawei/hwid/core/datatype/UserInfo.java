package com.huawei.hwid.core.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.C5184o;
import java.io.IOException;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class UserInfo implements Parcelable, Serializable {
    public static final String ADDRESS = "address";
    public static final String BIRTHDATE = "birthDate";
    public static final String CITY = "city";
    public static final String CLOUDACCOUNT = "cloudAccount";
    public static final Creator<UserInfo> CREATOR = new C51941();
    public static final String CTFCODE = "ctfCode";
    public static final String CTFTYPE = "ctfType";
    public static final String CTFVERIFYFLAG = "ctfVerifyFlag";
    public static final String FIRSTNAME = "firstName";
    public static final String GENDER = "gender";
    public static final String GUARDIAN_ACCOUNT = "guardianAccount";
    public static final String GUARDIAN_USER_ID = "guardianUserID";
    public static final String HEADPICTUREURL = "headPictureURL";
    public static final String INVITER = "Inviter";
    public static final String INVITER_USERID = "InviterUserID";
    public static final String LANGUAGECODE = "languageCode";
    public static final String LASTNAME = "lastName";
    public static final String LOGIN_NOTICE = "loginnotice";
    public static final String LOGIN_USER_NAME = "loginUserName";
    public static final String LOGIN_USER_NAME_FLAG = "loginUserNameFlag";
    public static final String NATIONALCODE = "nationalCode";
    public static final String NICKNAME = "nickName";
    public static final String OCCUPATION = "occupation";
    public static final String PASSWORDANWSER = "passwordAnswer";
    public static final String PASSWORDPROMPT = "passwordPrompt";
    public static final String PROVINCE = "province";
    public static final String RESET_PASSWD_MODE = "resetPasswdMode";
    public static final String SERVICEFLAG = "ServiceFlag";
    public static final String TWO_STEP_TIME = "twoStepTime";
    public static final String TWO_STEP_VERIFY = "twoStepVerify";
    public static final String UNIQUE_NICKNAME = "uniquelyNickname";
    public static final String UPDATE_TIME = "updateTime";
    public static final String USERSIGN = "userSignature";
    public static final String USERSTATE = "userState";
    public static final String USERVALID_STATUS = "userValidStatus";
    public static final String USER_STATUS_FLAGS = "userStatusFlags";
    private String f18733A;
    private String f18734B;
    private String f18735C;
    private String f18736D;
    private String f18737E;
    private String f18738F;
    private String f18739G;
    private String f18740H;
    private String f18741I;
    private String f18742J;
    private String f18743a;
    private String f18744b;
    private String f18745c;
    private String f18746d;
    private String f18747e;
    private String f18748f;
    private String f18749g;
    private String f18750h;
    private String f18751i;
    private String f18752j;
    private String f18753k;
    private String f18754l;
    private String f18755m;
    private String f18756n;
    private String f18757o;
    private String f18758p;
    private String f18759q;
    private String f18760r;
    private String f18761s;
    private String f18762t;
    private String f18763u;
    private String f18764v;
    private String f18765w;
    private String f18766x;
    private String f18767y;
    private String f18768z;

    final class C51941 implements Creator<UserInfo> {
        C51941() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25218a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25219a(i);
        }

        public UserInfo m25218a(Parcel parcel) {
            UserInfo userInfo = new UserInfo();
            userInfo.f18751i = parcel.readString();
            userInfo.f18750h = parcel.readString();
            userInfo.f18756n = parcel.readString();
            userInfo.f18759q = parcel.readString();
            userInfo.f18746d = parcel.readString();
            userInfo.f18749g = parcel.readString();
            userInfo.f18753k = parcel.readString();
            userInfo.f18745c = parcel.readString();
            userInfo.f18747e = parcel.readString();
            userInfo.f18754l = parcel.readString();
            userInfo.f18743a = parcel.readString();
            userInfo.f18744b = parcel.readString();
            userInfo.f18752j = parcel.readString();
            userInfo.f18758p = parcel.readString();
            userInfo.f18757o = parcel.readString();
            userInfo.f18755m = parcel.readString();
            userInfo.f18760r = parcel.readString();
            userInfo.f18748f = parcel.readString();
            userInfo.f18761s = parcel.readString();
            userInfo.f18762t = parcel.readString();
            userInfo.f18763u = parcel.readString();
            userInfo.f18764v = parcel.readString();
            userInfo.f18765w = parcel.readString();
            userInfo.f18766x = parcel.readString();
            userInfo.f18767y = parcel.readString();
            userInfo.f18768z = parcel.readString();
            userInfo.f18733A = parcel.readString();
            userInfo.f18734B = parcel.readString();
            userInfo.f18736D = parcel.readString();
            userInfo.f18735C = parcel.readString();
            userInfo.f18737E = parcel.readString();
            userInfo.f18738F = parcel.readString();
            userInfo.f18741I = parcel.readString();
            userInfo.f18739G = parcel.readString();
            userInfo.f18740H = parcel.readString();
            userInfo.f18742J = parcel.readString();
            return userInfo;
        }

        public UserInfo[] m25219a(int i) {
            return new UserInfo[i];
        }
    }

    public String getCtfCode() {
        return this.f18741I;
    }

    public void setCtfCode(String str) {
        this.f18741I = str;
    }

    public String getCtfType() {
        return this.f18739G;
    }

    public void setCtfType(String str) {
        this.f18739G = str;
    }

    public String getCtfVerifyFlag() {
        return this.f18740H;
    }

    public void setCtfVerifyFlag(String str) {
        this.f18740H = str;
    }

    public String getUserValidStatus() {
        return this.f18761s;
    }

    public void setUserValidStatus(String str) {
        this.f18761s = str;
    }

    public String getInviterUserID() {
        return this.f18762t;
    }

    public void setInviterUserID(String str) {
        this.f18762t = str;
    }

    public String getInviter() {
        return this.f18763u;
    }

    public void setInviter(String str) {
        this.f18763u = str;
    }

    public String getUpdateTime() {
        return this.f18764v;
    }

    public void setUpdateTime(String str) {
        this.f18764v = str;
    }

    public String getNickName() {
        return this.f18743a;
    }

    public void setNickName(String str) {
        this.f18743a = str;
    }

    public String getUniqueNickName() {
        return this.f18744b;
    }

    public void setUniqueNickName(String str) {
        this.f18744b = str;
    }

    public String getLanguageCode() {
        return this.f18745c;
    }

    public void setLanguageCode(String str) {
        this.f18745c = str;
    }

    public String getFirstName() {
        return this.f18746d;
    }

    public void setFirstName(String str) {
        this.f18746d = str;
    }

    public String getLastName() {
        return this.f18747e;
    }

    public void setLastName(String str) {
        this.f18747e = str;
    }

    public String getUserState() {
        return this.f18748f;
    }

    public void setUserState(String str) {
        this.f18748f = str;
    }

    public String getGender() {
        return this.f18749g;
    }

    public void setGender(String str) {
        this.f18749g = str;
    }

    public String getBirthDate() {
        return this.f18750h;
    }

    public void setBirthDate(String str) {
        this.f18750h = str;
    }

    public String getAddress() {
        return this.f18751i;
    }

    public void setAddress(String str) {
        this.f18751i = str;
    }

    public String getOccupation() {
        return this.f18752j;
    }

    public void setOccupation(String str) {
        this.f18752j = str;
    }

    public String getHeadPictureURL() {
        return this.f18753k;
    }

    public void setHeadPictureURL(String str) {
        this.f18753k = str;
    }

    public String getNationalCode() {
        return this.f18754l;
    }

    public void setNationalCode(String str) {
        this.f18754l = str;
    }

    public String getProvince() {
        return this.f18755m;
    }

    public void setProvince(String str) {
        this.f18755m = str;
    }

    public String getCity() {
        return this.f18756n;
    }

    public void setCity(String str) {
        this.f18756n = str;
    }

    public String getPasswordPrompt() {
        return this.f18757o;
    }

    public void setPasswordPrompt(String str) {
        this.f18757o = str;
    }

    public String getPasswordAnwser() {
        return this.f18758p;
    }

    public void setPasswordAnwser(String str) {
        this.f18758p = str;
    }

    public String getCloudAccount() {
        return this.f18759q;
    }

    public void setCloudAccount(String str) {
        this.f18759q = str;
    }

    public String getServiceFlag() {
        return this.f18760r;
    }

    public void setServiceFlag(String str) {
        this.f18760r = str;
    }

    public String getLoginUserName() {
        return this.f18765w;
    }

    public void setLoginUserName(String str) {
        this.f18765w = str;
    }

    public String getLoginUserNameFlag() {
        return this.f18766x;
    }

    public void setLoginUserNameFlag(String str) {
        this.f18766x = str;
    }

    public String getuserStatusFlags() {
        return this.f18767y;
    }

    public void setuserStatusFlags(String str) {
        this.f18767y = str;
    }

    public String gettwoStepVerify() {
        return this.f18768z;
    }

    public void settwoStepVerify(String str) {
        this.f18768z = str;
    }

    public String gettwoStepTime() {
        return this.f18733A;
    }

    public void settwoStepTime(String str) {
        this.f18733A = str;
    }

    public String getResetPasswdMode() {
        return this.f18734B;
    }

    public void setResetPasswdMode(String str) {
        this.f18734B = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getUserSign() {
        return this.f18735C;
    }

    public void setUserSign(String str) {
        this.f18735C = str;
    }

    public String getLoginNotice() {
        return this.f18736D;
    }

    public void setLoginNotice(String str) {
        this.f18736D = str;
    }

    public String getGuardianUserID() {
        return this.f18737E;
    }

    public void setGuardianUserID(String str) {
        this.f18737E = str;
    }

    public String getGuardianAccount() {
        return this.f18738F;
    }

    public void setGuardianAccount(String str) {
        this.f18738F = str;
    }

    public int getUserType() {
        if (TextUtils.isEmpty(this.f18737E) || TextUtils.isEmpty(this.f18738F)) {
            return 0;
        }
        return 1;
    }

    public String getServiceCountryCode() {
        return this.f18742J;
    }

    public void setServiceCountryCode(String str) {
        this.f18742J = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18751i);
        parcel.writeString(this.f18750h);
        parcel.writeString(this.f18756n);
        parcel.writeString(this.f18759q);
        parcel.writeString(this.f18746d);
        parcel.writeString(this.f18749g);
        parcel.writeString(this.f18753k);
        parcel.writeString(this.f18745c);
        parcel.writeString(this.f18747e);
        parcel.writeString(this.f18754l);
        parcel.writeString(this.f18743a);
        parcel.writeString(this.f18744b);
        parcel.writeString(this.f18752j);
        parcel.writeString(this.f18758p);
        parcel.writeString(this.f18757o);
        parcel.writeString(this.f18755m);
        parcel.writeString(this.f18760r);
        parcel.writeString(this.f18748f);
        parcel.writeString(this.f18761s);
        parcel.writeString(this.f18762t);
        parcel.writeString(this.f18763u);
        parcel.writeString(this.f18764v);
        parcel.writeString(this.f18765w);
        parcel.writeString(this.f18766x);
        parcel.writeString(this.f18767y);
        parcel.writeString(this.f18768z);
        parcel.writeString(this.f18733A);
        parcel.writeString(this.f18734B);
        parcel.writeString(this.f18736D);
        parcel.writeString(this.f18735C);
        parcel.writeString(this.f18737E);
        parcel.writeString(this.f18738F);
        parcel.writeString(this.f18741I);
        parcel.writeString(this.f18740H);
        parcel.writeString(this.f18739G);
        parcel.writeString(this.f18742J);
    }

    public boolean isObjectEquals(Object obj) {
        if (obj == null || !(obj instanceof UserInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (C5181l.m25040b(getNickName(), userInfo.getNickName()) && C5181l.m25040b(getLoginUserName(), userInfo.getLoginUserName()) && C5181l.m25040b(getLoginUserNameFlag(), userInfo.getLoginUserNameFlag()) && C5181l.m25040b(getGender(), userInfo.getGender()) && C5181l.m25040b(getBirthDate(), userInfo.getBirthDate()) && C5181l.m25040b(getNationalCode(), userInfo.getNationalCode())) {
            return true;
        }
        return false;
    }

    public static void setUserInfoIntag(XmlSerializer xmlSerializer, UserInfo userInfo) throws IllegalArgumentException, IllegalStateException, IOException {
        if (xmlSerializer != null && userInfo != null) {
            C5184o.m25072a(xmlSerializer, "uniquelyNickname", userInfo.getUniqueNickName());
            C5184o.m25072a(xmlSerializer, "nickName", userInfo.getNickName());
            C5184o.m25072a(xmlSerializer, LANGUAGECODE, userInfo.getLanguageCode());
            C5184o.m25072a(xmlSerializer, FIRSTNAME, userInfo.getFirstName());
            C5184o.m25072a(xmlSerializer, LASTNAME, userInfo.getLastName());
            C5184o.m25072a(xmlSerializer, USERSTATE, userInfo.getUserState());
            C5184o.m25072a(xmlSerializer, GENDER, userInfo.getGender());
            C5184o.m25072a(xmlSerializer, "birthDate", userInfo.getBirthDate());
            C5184o.m25072a(xmlSerializer, ADDRESS, userInfo.getAddress());
            C5184o.m25072a(xmlSerializer, OCCUPATION, userInfo.getOccupation());
            C5184o.m25072a(xmlSerializer, "headPictureURL", userInfo.getHeadPictureURL());
            C5184o.m25072a(xmlSerializer, NATIONALCODE, userInfo.getNationalCode());
            C5184o.m25072a(xmlSerializer, "province", userInfo.getProvince());
            C5184o.m25072a(xmlSerializer, "city", userInfo.getCity());
            C5184o.m25072a(xmlSerializer, PASSWORDPROMPT, userInfo.getPasswordPrompt());
            C5184o.m25072a(xmlSerializer, PASSWORDANWSER, userInfo.getPasswordAnwser());
            C5184o.m25072a(xmlSerializer, CLOUDACCOUNT, userInfo.getCloudAccount());
            C5184o.m25072a(xmlSerializer, SERVICEFLAG, userInfo.getServiceFlag());
            C5184o.m25072a(xmlSerializer, USERVALID_STATUS, userInfo.getUserValidStatus());
            C5184o.m25072a(xmlSerializer, INVITER, userInfo.getInviter());
            C5184o.m25072a(xmlSerializer, INVITER_USERID, userInfo.getInviterUserID());
            C5184o.m25072a(xmlSerializer, "updateTime", userInfo.getUpdateTime());
            C5184o.m25072a(xmlSerializer, "loginUserName", userInfo.getLoginUserName());
            C5184o.m25072a(xmlSerializer, LOGIN_USER_NAME_FLAG, userInfo.getLoginUserNameFlag());
            C5184o.m25072a(xmlSerializer, USERSIGN, userInfo.getUserSign());
            C5184o.m25072a(xmlSerializer, CTFCODE, userInfo.getCtfCode());
            C5184o.m25072a(xmlSerializer, CTFTYPE, userInfo.getCtfType());
            C5184o.m25072a(xmlSerializer, CTFVERIFYFLAG, userInfo.getCtfVerifyFlag());
            C5184o.m25072a(xmlSerializer, "srvNationalCode", userInfo.getServiceCountryCode());
        }
    }

    public static void setInfo1(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if ("nickName".equals(str)) {
            userInfo.setNickName(xmlPullParser.nextText());
        } else if ("uniquelyNickname".equals(str)) {
            userInfo.setUniqueNickName(xmlPullParser.nextText());
        } else if (LANGUAGECODE.equals(str)) {
            userInfo.setLanguageCode(xmlPullParser.nextText());
        } else if (FIRSTNAME.equals(str)) {
            userInfo.setFirstName(xmlPullParser.nextText());
        } else if (LASTNAME.equals(str)) {
            userInfo.setLastName(xmlPullParser.nextText());
        } else if (USERSTATE.equals(str)) {
            userInfo.setUserState(xmlPullParser.nextText());
        } else if (GUARDIAN_ACCOUNT.equals(str)) {
            userInfo.setGuardianAccount(xmlPullParser.nextText());
        } else if (GUARDIAN_USER_ID.equals(str)) {
            userInfo.setGuardianUserID(xmlPullParser.nextText());
        } else if (CTFCODE.equals(str)) {
            userInfo.setCtfCode(xmlPullParser.nextText());
        } else if (CTFTYPE.equals(str)) {
            userInfo.setCtfType(xmlPullParser.nextText());
        } else if (CTFVERIFYFLAG.equals(str)) {
            userInfo.setCtfVerifyFlag(xmlPullParser.nextText());
        } else if (USERVALID_STATUS.equals(str)) {
            userInfo.setUserValidStatus(xmlPullParser.nextText());
        } else if (INVITER_USERID.equals(str)) {
            userInfo.setInviterUserID(xmlPullParser.nextText());
        }
    }

    public static void setInfo2(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if (GENDER.equals(str)) {
            userInfo.setGender(xmlPullParser.nextText());
        } else if ("birthDate".equals(str)) {
            userInfo.setBirthDate(xmlPullParser.nextText());
        } else if (ADDRESS.equals(str)) {
            userInfo.setAddress(xmlPullParser.nextText());
        } else if (OCCUPATION.equals(str)) {
            userInfo.setOccupation(xmlPullParser.nextText());
        } else if ("headPictureURL".equals(str)) {
            userInfo.setHeadPictureURL(xmlPullParser.nextText());
        } else if (NATIONALCODE.equals(str)) {
            userInfo.setNationalCode(xmlPullParser.nextText());
        } else if ("province".equals(str)) {
            userInfo.setProvince(xmlPullParser.nextText());
        } else if ("city".equals(str)) {
            userInfo.setCity(xmlPullParser.nextText());
        } else if (PASSWORDPROMPT.equals(str)) {
            userInfo.setPasswordPrompt(xmlPullParser.nextText());
        } else if (PASSWORDANWSER.equals(str)) {
            userInfo.setPasswordAnwser(xmlPullParser.nextText());
        } else if (CLOUDACCOUNT.equals(str)) {
            userInfo.setCloudAccount(xmlPullParser.nextText());
        } else if (SERVICEFLAG.equals(str)) {
            userInfo.setServiceFlag(xmlPullParser.nextText());
        }
    }

    public static void setInfo3(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if (INVITER.equals(str)) {
            userInfo.setInviter(xmlPullParser.nextText());
        } else if ("updateTime".equals(str)) {
            userInfo.setUpdateTime(xmlPullParser.nextText());
        } else if ("loginUserName".equals(str)) {
            userInfo.setLoginUserName(xmlPullParser.nextText());
        } else if (LOGIN_USER_NAME_FLAG.equals(str)) {
            userInfo.setLoginUserNameFlag(xmlPullParser.nextText());
        } else if (USER_STATUS_FLAGS.equals(str)) {
            userInfo.setuserStatusFlags(xmlPullParser.nextText());
        } else if (TWO_STEP_VERIFY.equals(str)) {
            userInfo.settwoStepVerify(xmlPullParser.nextText());
        } else if (TWO_STEP_TIME.equals(str)) {
            userInfo.settwoStepTime(xmlPullParser.nextText());
        } else if (RESET_PASSWD_MODE.equals(str)) {
            userInfo.setResetPasswdMode(xmlPullParser.nextText());
        } else if (USERSIGN.equals(str)) {
            userInfo.setUserSign(xmlPullParser.nextText());
        } else if (LOGIN_NOTICE.equals(str)) {
            userInfo.setLoginNotice(xmlPullParser.nextText());
        } else if ("srvNationalCode".equals(str)) {
            userInfo.setServiceCountryCode(xmlPullParser.nextText());
        }
    }

    public static void getUserInfoIntag(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if (xmlPullParser != null && userInfo != null && str != null) {
            setInfo1(xmlPullParser, userInfo, str);
            setInfo2(xmlPullParser, userInfo, str);
            setInfo3(xmlPullParser, userInfo, str);
        }
    }

    public String toString() {
        return "UserInfo [mNickName=" + this.f18743a + ", mUniqueNickName=" + this.f18744b + ", mLanguageCode=" + this.f18745c + ", mFirstName=" + this.f18746d + ", mLastName=" + this.f18747e + ", mUserState=" + this.f18748f + ", mGender=" + this.f18749g + ", mBirthDate=" + this.f18750h + ", mAddress=" + this.f18751i + ", mOccupation=" + this.f18752j + ", mHeadPictureURL=" + this.f18753k + ", mNationalCode=" + this.f18754l + ", mProvince=" + this.f18755m + ", mCity=" + this.f18756n + ", mPasswordPrompt=" + this.f18757o + ", mscrtdanws=" + this.f18758p + ", mCloudAccount=" + this.f18759q + ", mServiceFlag=" + this.f18760r + ", mUserValidStatus=" + this.f18761s + ", mInviterUserID=" + this.f18762t + ", mInviter=" + this.f18763u + ", mUpdateTime=" + this.f18764v + ", mLoginUserName=" + this.f18765w + ", mLoginUserNameFlag=" + this.f18766x + ", muserStatusFlags=" + this.f18767y + ", mtwoStepVerify=" + this.f18768z + ", mtwoStepTime=" + this.f18733A + ", mResetPasswdMode=" + this.f18734B + ", mUserSign=" + this.f18735C + ", mLoginNotice=" + this.f18736D + ", mGuardianUserID=" + this.f18737E + ", mGuardianAccount=" + this.f18738F + ", mCtfType=" + this.f18739G + ", mCtfVerifyFlag=" + this.f18740H + ", mCtfCode=" + this.f18741I + ", mServiceCountryCode=" + this.f18742J + "]";
    }
}
