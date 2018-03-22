package com.huawei.up.p517a;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccountManager;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.common.login.HuaweiCloudLogin;
import com.huawei.common.util.EncryptUtil;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.login.ui.login.a;
import com.huawei.p111o.p479c.C5705a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p404b.C4694a;
import com.huawei.up.p518c.C6121a;
import com.huawei.up.p519d.C6124b;
import com.huawei.up.p520e.C6134h;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.util.regex.Pattern;

/* compiled from: UpApi */
public class C6108a {
    private Context f21116a;
    private C6121a f21117b;

    public C6108a(Context context) {
        C6124b.m27889g("https://setting1.hicloud.com/AccountServer");
        this.f21116a = context;
    }

    private void m27860a(String str, String str2, String str3, C4694a c4694a) {
        if (this.f21117b == null) {
            this.f21117b = new C6121a();
        }
        new Thread(new C6112e(this, str, str2, str3, c4694a)).start();
    }

    public void m27874a(Context context, CloudRequestHandler cloudRequestHandler) {
        int b = a.a(BaseApplication.b()).b();
        boolean z = (b == 0 || b == -1) ? false : true;
        C2538c.c("UpApi", new Object[]{"isThirdLogin:" + z});
        if (1 == a.a(BaseApplication.b()).e() && com.huawei.login.a.a.b(BaseApplication.b()) && z) {
            C2538c.c("UpApi", new Object[]{" 1.5login ,get userinfo from up server directly"});
            m27863b(BaseApplication.b(), cloudRequestHandler);
        } else if (com.huawei.login.a.a.b() != null) {
            C2538c.c("UpApi", new Object[]{"getUserInfo by huawei sdk111"});
            com.huawei.login.a.a.b().getUserInfo(context, "1000", cloudRequestHandler);
        } else {
            a.a(this.f21116a).a(context, new C6113f(this, cloudRequestHandler), false);
        }
    }

    public void m27875a(Context context, IBaseResponseCallback iBaseResponseCallback) {
        a.a(this.f21116a).a(context, new C6114g(this, iBaseResponseCallback));
    }

    private void m27863b(Context context, CloudRequestHandler cloudRequestHandler) {
        a a = a.a(context);
        a.a(new C6115h(this, cloudRequestHandler, context, a));
    }

    public int m27872a(Fragment fragment, int i) {
        if (fragment == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.ACTION_MAIN_SETTINGS");
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        intent.setPackage("com.huawei.hwid");
        intent.putExtra("channel", 39000000);
        intent.putExtra("showLogout", true);
        if (com.huawei.login.a.a.b(BaseApplication.b())) {
            intent.setPackage("com.huawei.hwid");
        } else {
            intent.setPackage(BaseApplication.b().getPackageName());
        }
        fragment.startActivityForResult(intent, i);
        return 0;
    }

    public void m27876a(Context context, UserInfomation userInfomation, C4694a c4694a) {
        C2538c.c("UpApi", new Object[]{"Enter updateUserInfo "});
        if (!C6134h.m27922a(userInfomation)) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.KEY_METHOD, "updateUserInfo");
            c4694a.mo4558a(bundle);
        } else if (com.huawei.login.a.a.b() == null) {
            a.a(this.f21116a).a(context, new C6117j(this, userInfomation, c4694a));
        } else {
            m27858a(userInfomation, c4694a);
        }
    }

    private void m27858a(UserInfomation userInfomation, C4694a c4694a) {
        C2538c.e("UpApi", new Object[]{"Enter updateUserInfoBySdk"});
        if (com.huawei.login.a.a.b() == null) {
            C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk Account is null"});
            if (c4694a != null) {
                C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk is fail"});
                c4694a.mo4557a(-100);
                return;
            }
            return;
        }
        UserInfo userInfo = new UserInfo();
        C2538c.b("UpApi", new Object[]{"updateUserInfoBySdk begin name is", userInfomation.getName()});
        if (!com.huawei.login.a.a.b().updateUserInfo(BaseApplication.b(), C6134h.m27918a(userInfo, userInfomation), new C6118k(this, c4694a)) && c4694a != null) {
            C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk is fail"});
            c4694a.mo4557a(-100);
        }
    }

    public boolean m27879a(Context context, String str, C4694a c4694a) {
        if (com.huawei.login.a.a.b() == null) {
            a.a(this.f21116a).a(context, new C6119l(this, str, c4694a));
        }
        m27865b(str, c4694a);
        return true;
    }

    private void m27865b(String str, C4694a c4694a) {
        if (com.huawei.login.a.a.b() == null) {
            C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk Account is null"});
            if (c4694a != null) {
                C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk is fail"});
                c4694a.mo4557a(-100);
            }
        } else if (!com.huawei.login.a.a.b().updateHeadPicture(BaseApplication.b(), str, new C6120m(this, c4694a)) && c4694a != null) {
            C2538c.e("UpApi", new Object[]{"updateUserInfoBySdk is fail"});
            c4694a.mo4557a(-100);
        }
    }

    public void m27878a(String str, boolean z) {
        C2538c.c("UpApi", new Object[]{"changeSTToAT isFromLoginSuccess:" + z});
        if (1 != a.a(BaseApplication.b()).e()) {
            C2538c.c("UpApi", new Object[]{"not china account, not support ST to AT"});
            return;
        }
        String str2 = "";
        String decrypt = EncryptUtil.decrypt(this.f21116a, EncryptUtil.APP_ID);
        C2538c.c("UpApi", new Object[]{"changeSTToAT-->shared 2"});
        int b = a.a(this.f21116a).b();
        boolean z2 = (b == 0 || b == -1) ? false : true;
        C2538c.c("UpApi", new Object[]{"login third type! login type is:" + b, ", isThirdLogin = ", Boolean.valueOf(z2)});
        if (z2) {
            C2538c.c("UpApi", new Object[]{"third part not go"});
            C2538c.c("UpApi", new Object[]{"changeSTToAT-->shared 3"});
            m27866b(str, decrypt);
        } else if (z) {
            C2538c.c("UpApi", new Object[]{"isFromLoginSuccess " + z});
            m27859a(str, decrypt);
        } else if (!com.huawei.login.a.a.b(BaseApplication.b())) {
            C2538c.c("UpApi", new Object[]{"changeSTToAT-->shared 4"});
            m27866b(str, decrypt);
        } else if (com.huawei.login.a.a.c(BaseApplication.b())) {
            new com.huawei.login.a.a(this.f21116a, null).a(this.f21116a, new C6109b(this, str, decrypt));
        } else {
            C2538c.c("UpApi", new Object[]{"changeSTToAT-->shared 5"});
            m27866b(str, decrypt);
        }
        C2538c.b("UpApi", new Object[]{"changeSTToAT: " + decrypt});
    }

    private void m27859a(String str, String str2) {
        C2538c.c("UpApi", new Object[]{"Enter getAtbySDK"});
        String str3 = str2;
        String str4 = str;
        CloudAccountManager.changeSTToAT(this.f21116a, "", "oob", str3, str4, new Bundle(), new C6110c(this));
    }

    private void m27866b(String str, String str2) {
        C2538c.c("UpApi", new Object[]{"Enter getAtbyCloud"});
        HuaweiCloudLogin.stToAt(str, a.a(BaseApplication.b()).c(), str2, d.h(this.f21116a), C5705a.m26330a(BaseApplication.b()), new C6111d(this), BaseApplication.b());
    }

    public String m27873a() {
        String str = "";
        if (com.huawei.login.a.a.b() != null) {
            Bundle accountInfo = com.huawei.login.a.a.b().getAccountInfo();
            if (accountInfo != null) {
                str = accountInfo.getString("accountName");
            }
        }
        C2538c.b("UpApi", new Object[]{"getAccountName: " + m27852a(str)});
        return m27852a(str);
    }

    private String m27852a(String str) {
        C2538c.b("UpApi", new Object[]{"handleUserAccount: " + str});
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (m27870e(str)) {
            return m27862b(str);
        }
        if (m27871f(str)) {
            return m27867c(str);
        }
        return m27869d(str);
    }

    private String m27862b(String str) {
        String[] split = str.split("@");
        if (split.length != 2 || split[0].length() <= 0 || split[1].length() <= 0) {
            return str;
        }
        String str2 = split[0];
        String str3 = split[1];
        if (str2.length() <= 6 || !m27868c(str2, HwAccountConstants.DIGITAL_REGX)) {
            if (str2.length() > 8) {
                return str2.substring(0, str2.length() - 4) + "****@" + str3;
            }
            if (str2.length() > 2) {
                return str2.substring(0, str2.length() - 2) + "**@" + str3;
            }
            return m27853a("*", str2.length()) + "@" + str3;
        } else if (str2.length() > 8) {
            return str2.substring(0, str2.length() - 8) + "****" + str2.substring(str2.length() - 4) + "@" + str3;
        } else {
            return m27853a("*", str2.length() - 4) + str2.substring(str2.length() - 4) + "@" + str3;
        }
    }

    private String m27867c(String str) {
        if (str.length() < 5) {
            return str;
        }
        if (str.length() < 8) {
            return m27853a("*", str.length() - 4) + str.substring(str.length() - 4);
        }
        return str.substring(0, str.length() - 8) + "****" + str.substring(str.length() - 4);
    }

    private String m27869d(String str) {
        if (str.length() < 5) {
            return str;
        }
        if (str.length() < 8) {
            return m27853a("*", str.length() - 4) + str.substring(str.length() - 4);
        }
        return str.substring(0, str.length() - 8) + "****" + str.substring(str.length() - 4);
    }

    private String m27853a(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    private boolean m27870e(String str) {
        if (str.endsWith("@inner.up.huawei")) {
            return false;
        }
        return m27868c(str, "^\\s*([A-Za-z0-9_-]+(\\.\\w+)*@(\\w+\\.)+\\w+)\\s*$");
    }

    private boolean m27868c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !Pattern.compile(str2).matcher(str).matches()) {
            return false;
        }
        return true;
    }

    private boolean m27871f(String str) {
        if (Pattern.compile("^1[0-9]{10}$").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public void m27877a(String str, C4694a c4694a) {
        C6121a c6121a = new C6121a();
        try {
            C2538c.b("UpApi", new Object[]{"----findUserIdBySt"});
            c6121a.m27885a(BaseApplication.b(), str, c4694a);
        } catch (IOException e) {
            if (c4694a != null) {
                C2538c.e("UpApi", new Object[]{"----findUserIdBySt error"});
                c4694a.mo4557a(-1);
            }
        }
    }
}
