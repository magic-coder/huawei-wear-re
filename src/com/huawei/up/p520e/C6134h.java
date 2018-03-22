package com.huawei.up.p520e;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.common.login.HuaweiCloudLogin;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.b;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.p111o.C5704b;
import com.huawei.p111o.p478b.C5696b;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Utils */
public class C6134h {
    public static String m27921a(String str, Context context) throws UnsupportedEncodingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        String a = C5704b.m26317a(context).m26326a("02FE00AEA70FE6492F95E820602066A4DcDyd3lSsN3S9Gxpj2QwK958cFuXW/z/hxGV5dJAhQ8=");
        String a2 = C6134h.m27919a();
        String str2 = "";
        if (a != null) {
            return a2 + ":" + a.a(C5696b.m26286a(str.getBytes(GameManager.DEFAULT_CHARSET), a.getBytes(GameManager.DEFAULT_CHARSET), a2));
        }
        C2538c.e("Utils", new Object[]{"fullSecretKey is null"});
        return str2;
    }

    public static String m27920a(Context context) {
        String str = "";
        str = Build.MODEL;
        try {
            str = URLEncoder.encode(str, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.e("Utils", new Object[]{"exception e=" + e.getMessage()});
        }
        return str;
    }

    private static String m27919a() {
        return C0973a.a(new SecureRandom().generateSeed(16));
    }

    public static boolean m27923a(String str) {
        if (str == null || str.trim().length() < 1) {
            return true;
        }
        return false;
    }

    public static String m27924b(Context context) {
        String c = C6134h.m27925c(context);
        if (c == null || c.equals("")) {
            return HuaweiCloudLogin.DEVICE_ID;
        }
        return c;
    }

    public static String m27925c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (SecurityException e) {
            C2538c.b("Utils", new Object[]{"getDeviceType() SecurityException "});
            return "";
        } catch (Exception e2) {
            C2538c.b("Utils", new Object[]{"getDeviceType() Exception"});
            return "";
        }
    }

    public static UserInfo m27918a(UserInfo userInfo, UserInfomation userInfomation) {
        if (BaseApplication.c() == b.a && !TextUtils.isEmpty(userInfomation.getName())) {
            userInfo.setNickName(userInfomation.getName());
        }
        if (!TextUtils.isEmpty(userInfomation.getBirthday())) {
            userInfo.setBirthDate(userInfomation.getBirthday());
        }
        if (-1000 != userInfomation.getGender()) {
            userInfo.setGender(String.valueOf(userInfomation.getGender()));
        }
        return userInfo;
    }

    public static boolean m27922a(UserInfomation userInfomation) {
        if (TextUtils.isEmpty(userInfomation.getName()) && TextUtils.isEmpty(userInfomation.getBirthday()) && -1000 == userInfomation.getGender()) {
            return false;
        }
        return true;
    }
}
