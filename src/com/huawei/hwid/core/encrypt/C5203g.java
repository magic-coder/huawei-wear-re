package com.huawei.hwid.core.encrypt;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: Proguard */
public class C5203g {
    private static final List<String> f18791a = new ArrayList();
    private static String[] f18792b = new String[]{"userid", "password", "siteid", "plmn", "mobilephone", "deviceinfo", "uuid", "deviceid2", "secretdigest", "salt", "emmcid", "secretdigesttype", "clientip", "deviceid", SNBConstant.FIELD_DEVICE_ID, "securityphone", "securityemail", "cookie", "devicetype", "useremail", "email", HwAccountConstants.PARA_ACCOUNT_SERVICETOKEN, "oldpassword", "newpassword", "thirdtoken", "smsauthcode", "phone", "access_token", "sc", "sso_st", SNBConstant.FIELD_TOKEN, "ac", "pw", "dvid", "pl", "dvid2", "sc", "emid", "sct", "c", BundleKey.KEY_ST, "app", "uid", UploadFile.DEVICE_IMSI_LABEL, "thirdopenid", "thirdaccesstoken", "accountName", "useraccount", "fulluseraccount", "nickName", "uniquelynickname", "loginusername", "thirdnickname", "fingerST"};
    private static String[] f18793c = new String[]{"nickName", "uniquelyNickname", "loginUserName", "thirdNickname"};

    static {
        C5203g.m25319a();
    }

    private static void m25319a() {
        if (f18792b != null) {
            for (Object obj : f18792b) {
                if (!TextUtils.isEmpty(obj)) {
                    f18791a.add(obj.toLowerCase(Locale.ENGLISH));
                }
            }
        }
        C5165e.m24904a("Proguard", "keyList size is " + f18791a.size());
    }

    private static String m25313a(char c, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    public static String m25315a(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return "*";
        }
        return C5203g.m25316a(String.valueOf(obj));
    }

    public static String m25316a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() == 1) {
            return "*";
        }
        int ceil = (int) Math.ceil(((double) (str.length() * 50)) / 100.0d);
        return C5203g.m25313a('*', ceil) + str.substring(ceil);
    }

    public static String m25318a(String str, Object obj) {
        String str2 = "";
        if (str == null || obj == null) {
            return str2;
        }
        String b = C5203g.m25320b(str);
        String valueOf = String.valueOf(obj);
        if (!String.valueOf('*').equals(b) || TextUtils.isEmpty(valueOf)) {
            str2 = valueOf;
        } else {
            String str3 = "";
            str2 = C5203g.m25317a(String.valueOf('*'), valueOf.length());
            if (valueOf.length() > 4) {
                str3 = valueOf.substring(valueOf.length() - 2);
                str2 = str2.substring(0, valueOf.length() - 2);
            }
            str2 = str2 + str3;
        }
        return b + "=" + str2;
    }

    private static String m25317a(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static String m25314a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        Set<String> keySet = bundle.keySet();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : keySet) {
            Object a;
            Object obj = bundle.get(str);
            String str2 = "";
            if (obj instanceof Bundle) {
                a = C5203g.m25314a((Bundle) obj);
            } else {
                a = C5203g.m25315a(obj);
                for (String equalsIgnoreCase : f18793c) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str) && !TextUtils.isEmpty(r2) && r2.length() == 1) {
                        a = "*";
                    }
                }
            }
            stringBuffer.append(C5203g.m25318a(str, a)).append(HwAccountConstants.BLANK);
        }
        return stringBuffer.toString();
    }

    public static String m25320b(String str) {
        if (f18791a == null || !f18791a.contains(str.toLowerCase(Locale.ENGLISH))) {
            return str;
        }
        C5165e.m24904a("Proguard", "keyList contains " + str.toLowerCase(Locale.ENGLISH));
        return String.valueOf('*');
    }

    public static String m25321c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int indexOf = str.indexOf("=");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            return str;
        } catch (Exception e) {
            C5165e.m24910d("Proguard", e.getMessage());
            return str;
        }
    }

    public static String m25322d(String str) {
        return "ACCOUNT_NAME";
    }
}
