package com.huawei.up.p519d;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.up.p520e.C6128b;
import com.huawei.up.p520e.C6133g;
import com.huawei.up.p520e.C6134h;
import com.huawei.up.p520e.C6135i;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: GetUserInfoRequest */
public class C6125a extends C6124b {
    private String f21159c;
    private Context f21160d;
    private String f21161e;
    private Integer f21162f;
    private UserInfo f21163g;
    private String f21164h;
    private String f21165i;

    public C6125a(Context context) {
        super(context);
        this.f21163g = null;
        this.b = a + "/IUserInfoMng/getUserInfo?Version=10001";
        this.f21160d = context;
    }

    public String m27897a() throws IllegalArgumentException, IllegalStateException, IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer a = C6135i.m27927a(byteArrayOutputStream);
            a.startDocument(GameManager.DEFAULT_CHARSET, Boolean.valueOf(true));
            a.startTag(null, "GetUserInfoReq");
            C6135i.m27928a(a, "version", "10001");
            C6135i.m27928a(a, "userID", this.f21159c);
            C6135i.m27928a(a, "queryRangeFlag", this.f21161e);
            a.endTag(null, "GetUserInfoReq");
            a.endDocument();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET);
            int indexOf = byteArrayOutputStream2.indexOf("?>");
            if (-1 != indexOf) {
                byteArrayOutputStream2 = byteArrayOutputStream2.substring(indexOf + 2);
            }
            C2538c.b("GetUserInfoRequest", new Object[]{"request is packedStr = " + byteArrayOutputStream2});
            return byteArrayOutputStream2;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                C2538c.e("GetUserInfoRequest", new Object[]{"byteArrayOutputStream.close() error ,e = " + e.getMessage()});
            }
        }
    }

    public Bundle m27896a(String str) throws XmlPullParserException, IOException {
        Bundle bundle = new Bundle();
        C2538c.b("GetUserInfoRequest", new Object[]{"response=" + str});
        if (str == null) {
            return bundle;
        }
        XmlPullParser a = C6135i.m27926a(str.getBytes(GameManager.DEFAULT_CHARSET));
        int i = 0;
        for (int eventType = a.getEventType(); 1 != eventType; eventType = a.next()) {
            String name = a.getName();
            switch (eventType) {
                case 2:
                    if ("result".equals(name)) {
                        this.f21162f = Integer.valueOf(a.getAttributeValue(null, "resultCode"));
                    }
                    if (this.f21162f.intValue() == 0) {
                        if (!"userID".equals(name)) {
                            if (!"userInfo".equals(name)) {
                                if (!(i == 0 || this.f21163g == null)) {
                                    C6125a.m27892a(a, this.f21163g, name);
                                    break;
                                }
                            }
                            this.f21163g = new UserInfo();
                            i = 1;
                            break;
                        }
                        this.f21159c = a.nextText();
                        break;
                    }
                    break;
                case 3:
                    if (!"userInfo".equals(name)) {
                        break;
                    }
                    i = 0;
                    break;
                default:
                    break;
            }
        }
        bundle.putInt("resultCode", this.f21162f.intValue());
        bundle.putParcelable("getUserInfoTag", this.f21163g);
        return bundle;
    }

    public void m27898b(String str) {
        this.f21159c = str;
    }

    public void m27899c(String str) {
        this.f21161e = str;
    }

    public static void m27892a(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if (xmlPullParser != null && userInfo != null && str != null) {
            C6125a.m27893b(xmlPullParser, userInfo, str);
            C6125a.m27894c(xmlPullParser, userInfo, str);
            C6125a.m27895d(xmlPullParser, userInfo, str);
        }
    }

    private static void m27893b(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if ("nickName".equals(str)) {
            userInfo.setNickName(xmlPullParser.nextText());
        } else if (UserInfo.LANGUAGECODE.equals(str)) {
            userInfo.setLanguageCode(xmlPullParser.nextText());
        } else if (UserInfo.FIRSTNAME.equals(str)) {
            userInfo.setFirstName(xmlPullParser.nextText());
        } else if (UserInfo.LASTNAME.equals(str)) {
            userInfo.setLastName(xmlPullParser.nextText());
        } else if (UserInfo.USERSTATE.equals(str)) {
            userInfo.setUserState(xmlPullParser.nextText());
        } else if (UserInfo.GENDER.equals(str)) {
            userInfo.setGender(xmlPullParser.nextText());
        } else if ("birthDate".equals(str)) {
            userInfo.setBirthDate(xmlPullParser.nextText());
        } else if (UserInfo.ADDRESS.equals(str)) {
            userInfo.setAddress(xmlPullParser.nextText());
        } else if (UserInfo.OCCUPATION.equals(str)) {
            userInfo.setOccupation(xmlPullParser.nextText());
        }
    }

    private static void m27894c(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if ("headPictureURL".equals(str)) {
            userInfo.setHeadPictureURL(xmlPullParser.nextText());
        } else if (UserInfo.NATIONALCODE.equals(str)) {
            userInfo.setNationalCode(xmlPullParser.nextText());
        } else if ("province".equals(str)) {
            userInfo.setProvince(xmlPullParser.nextText());
        } else if ("city".equals(str)) {
            userInfo.setCity(xmlPullParser.nextText());
        } else if (UserInfo.PASSWORDPROMPT.equals(str)) {
            userInfo.setPasswordPrompt(xmlPullParser.nextText());
        } else if (UserInfo.PASSWORDANWSER.equals(str)) {
            userInfo.setPasswordAnwser(xmlPullParser.nextText());
        } else if (UserInfo.CLOUDACCOUNT.equals(str)) {
            userInfo.setCloudAccount(xmlPullParser.nextText());
        } else if (UserInfo.SERVICEFLAG.equals(str)) {
            userInfo.setServiceFlag(xmlPullParser.nextText());
        } else if (UserInfo.USERVALID_STATUS.equals(str)) {
            userInfo.setUserValidStatus(xmlPullParser.nextText());
        } else if (UserInfo.INVITER_USERID.equals(str)) {
            userInfo.setInviterUserID(xmlPullParser.nextText());
        }
    }

    private static void m27895d(XmlPullParser xmlPullParser, UserInfo userInfo, String str) throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException {
        if (UserInfo.INVITER.equals(str)) {
            userInfo.setInviter(xmlPullParser.nextText());
        } else if ("updateTime".equals(str)) {
            userInfo.setUpdateTime(xmlPullParser.nextText());
        } else if ("loginUserName".equals(str)) {
            userInfo.setLoginUserName(xmlPullParser.nextText());
        } else if (UserInfo.LOGIN_USER_NAME_FLAG.equals(str)) {
            userInfo.setLoginUserNameFlag(xmlPullParser.nextText());
        } else if (UserInfo.USER_STATUS_FLAGS.equals(str)) {
            userInfo.setuserStatusFlags(xmlPullParser.nextText());
        } else if (UserInfo.TWO_STEP_VERIFY.equals(str)) {
            userInfo.settwoStepVerify(xmlPullParser.nextText());
        } else if (UserInfo.TWO_STEP_TIME.equals(str)) {
            userInfo.settwoStepTime(xmlPullParser.nextText());
        } else if (UserInfo.RESET_PASSWD_MODE.equals(str)) {
            userInfo.setResetPasswdMode(xmlPullParser.nextText());
        }
    }

    public String mo5139d(String str) {
        String str2 = null;
        HttpUriRequest a = C6128b.m27910a(this.b, 30, 30, false);
        if (a == null) {
            C2538c.b("GetUserInfoRequest", new Object[]{"null == httpPost!"});
            return "";
        }
        a.addHeader("Content-Type", "text/xml");
        if (!C6134h.m27923a(this.f21164h)) {
            a.addHeader(AUTH.WWW_AUTH_RESP, this.f21164h);
        }
        if (!C6134h.m27923a(this.f21165i)) {
            a.addHeader("Cookie", this.f21165i);
        }
        try {
            a.setEntity(new StringEntity(str));
        } catch (UnsupportedEncodingException e) {
            C2538c.b("GetUserInfoRequest", new Object[]{"UnsupportedEncodingException error = " + e.getMessage()});
        }
        try {
            HttpClient a2 = C6128b.m27909a(this.f21160d, this.b);
        } catch (C6133g e2) {
            C2538c.b("GetUserInfoRequest", new Object[]{"NSPException error = " + e2.getMessage()});
            Object obj = str2;
        }
        if (a2 == null) {
            C2538c.b("GetUserInfoRequest", new Object[]{"null == httpClient1!"});
            return "";
        }
        try {
            HttpResponse execute = a2.execute(a);
        } catch (IOException e3) {
            C2538c.b("GetUserInfoRequest", new Object[]{"IOException error =" + e3.getMessage()});
            obj = str2;
        }
        if (execute == null) {
            return str2;
        }
        try {
            return EntityUtils.toString(execute.getEntity(), GameManager.DEFAULT_CHARSET);
        } catch (IOException e32) {
            C2538c.b("GetUserInfoRequest", new Object[]{"IOException error, e1 = " + e32.getMessage()});
            return str2;
        }
    }

    public void m27901e(String str) {
        this.f21164h = str;
    }

    public void m27902f(String str) {
        this.f21165i = str;
    }
}
