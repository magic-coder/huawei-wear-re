package com.huawei.login.p087a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.a.b;
import com.huawei.login.a.c;
import com.huawei.login.a.d;
import com.huawei.login.a.e;
import com.huawei.login.a.f;
import com.huawei.login.a.g;
import com.huawei.login.a.h;
import com.huawei.login.ui.login.util.ILoginCallback;
import com.huawei.p190v.C2538c;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: HuaweiLoginManager */
public class C1092a {
    private static CloudAccount f2212a = null;
    private static CloudAccount f2213b = null;
    private static boolean f2214f = false;
    private Context f2215c = null;
    private ILoginCallback f2216d = null;
    private Context f2217e;

    public static CloudAccount m4701a() {
        return f2213b;
    }

    public static void m4703a(CloudAccount cloudAccount) {
        if (cloudAccount == null) {
            C2538c.m12674b("PLGLOGIN_HuaweiLoginManager", "setAccountTemp -->accountTemp is null");
        } else {
            C2538c.m12674b("PLGLOGIN_HuaweiLoginManager", "setAccountTemp -->accountTemp is not null" + cloudAccount.getAccountInfo().toString());
        }
        f2213b = cloudAccount;
    }

    public static CloudAccount m4713b() {
        return f2212a;
    }

    public static void m4714b(CloudAccount cloudAccount) {
        f2212a = cloudAccount;
    }

    public C1092a(Context context, ILoginCallback iLoginCallback) {
        this.f2215c = context.getApplicationContext();
        this.f2216d = iLoginCallback;
    }

    private Context m4727g() {
        return this.f2217e;
    }

    private void m4723d(Context context) {
        if (context != null) {
            this.f2217e = context;
        }
    }

    public void m4731a(Context context) {
        m4733a(context, true);
    }

    public void m4733a(Context context, boolean z) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "enter login:isNeedAuth = " + z);
        Bundle bundle = new Bundle();
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "login() sdk initial");
        CloudAccount.initial(BaseApplication.m2632b(), bundle, new b(this, context, z));
    }

    public void m4732a(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter loginForHuid ");
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "loginForHealth sdk initial");
        m4723d(context);
        if (!C1092a.m4717b(BaseApplication.m2632b())) {
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter loginForHuid 3");
        } else if (C1092a.m4721c(BaseApplication.m2632b())) {
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter loginForHuid 1");
            if (m4728h()) {
                if (m4730j()) {
                    m4715b(iBaseResponseCallback, true);
                    return;
                } else {
                    m4705a(iBaseResponseCallback, true);
                    return;
                }
            } else if (m4730j()) {
                m4704a(iBaseResponseCallback);
                return;
            } else {
                m4705a(iBaseResponseCallback, false);
                return;
            }
        } else {
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter loginForHuid 2");
        }
        CloudAccount.initial(BaseApplication.m2632b(), new Bundle(), new c(this, iBaseResponseCallback));
    }

    private boolean m4728h() {
        CharSequence a = C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(20007), "current_token_is_timeout");
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "getIsStTimeout:", a);
        if ("true".equals(a) || TextUtils.isEmpty(a)) {
            return true;
        }
        return false;
    }

    public static boolean m4717b(Context context) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter checkIsInstallHuaweiAccount");
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "checkIsInstallHuaweiAccount:", Boolean.valueOf(CloudAccount.checkIsInstallHuaweiAccount(context)));
        return CloudAccount.checkIsInstallHuaweiAccount(context);
    }

    public static boolean m4720c() {
        return f2214f;
    }

    public static void m4711a(boolean z) {
        f2214f = z;
    }

    public static boolean m4721c(Context context) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "enter hasLoginAccount():");
        if (C1092a.m4717b(context)) {
            boolean await;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Executors.newSingleThreadExecutor().execute(new d(context, countDownLatch));
            try {
                await = countDownLatch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                C2538c.m12680e("PLGLOGIN_HuaweiLoginManager", "InterruptedException e = ", e.getMessage());
                await = false;
            }
            if (!await) {
                C2538c.m12680e("PLGLOGIN_HuaweiLoginManager", "hasLoginAccount outTime:" + await);
                C1092a.m4711a(false);
            }
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "hasLoginAccount:" + C1092a.m4720c());
            return C1092a.m4720c();
        }
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "huid sdk is not exit ,return false.");
        return false;
    }

    public void m4734d() {
        this.f2216d = null;
    }

    public void m4735e() {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter updateTempAccountToAccount");
        CloudAccount a = C1092a.m4701a();
        if (a != null) {
            C1092a.m4714b(a);
            m4729i();
            return;
        }
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "tempAccount is null");
    }

    private void m4702a(int i) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "loginFaile error, code is:" + i);
        if (this.f2216d != null) {
            this.f2216d.onLoginFailed(new com.huawei.login.ui.login.util.b(i));
        }
    }

    private void m4729i() {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "enter loginSuccess():");
        C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(20007), "migrate_is_account_from_hwid_app", "migrate_account_is_from_hwid", new C0993c(0));
        C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(20007), "current_token_is_timeout", "false", new C0993c());
        String str = "";
        str = "";
        str = "";
        str = "";
        str = "";
        str = "";
        String string = C1092a.m4713b().getAccountInfo().getString("userId");
        String serviceToken = C1092a.m4713b().getServiceToken();
        int i = C1092a.m4713b().getAccountInfo().getInt("siteId");
        String string2 = C1092a.m4713b().getAccountInfo().getString("countryIsoCode");
        String string3 = C1092a.m4713b().getAccountInfo().getString("accountName");
        String string4 = C1092a.m4713b().getAccountInfo().getString("deviceId");
        String string5 = C1092a.m4713b().getAccountInfo().getString("deviceType");
        C2538c.m12674b("PLGLOGIN_HuaweiLoginManager", "----login countryCode:", string2);
        m4710a(string, serviceToken, i, string2, string3, string4, string5);
    }

    private void m4710a(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "Enter saveLoginInfo");
        C2538c.m12674b("PLGLOGIN_HuaweiLoginManager", "Enter saveLoginInfo strServiceToken:" + str2);
        com.huawei.login.ui.login.util.c.a(this.f2215c).a(i, null);
        com.huawei.login.ui.login.util.c.a(this.f2215c).b(str3, null);
        com.huawei.login.ui.login.util.c.a(this.f2215c).a(str);
        com.huawei.login.ui.login.util.c.a(this.f2215c).b(0);
        com.huawei.login.ui.login.util.c.a(this.f2215c).b(str4);
        com.huawei.login.ui.login.util.c.a(this.f2215c).c(str5);
        com.huawei.login.ui.login.util.c.a(this.f2215c).d(str6);
        com.huawei.login.ui.login.util.c.a(this.f2215c).a(str2, new e(this));
    }

    public static boolean m4726f() {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "enter hasGetTokenInActivitys():");
        PackageManager packageManager = BaseApplication.m2632b().getPackageManager();
        Intent intent = new Intent("com.huawei.hwid.GET_AUTH_TOKEN");
        intent.setPackage("com.huawei.hwid");
        List list = null;
        if (packageManager != null) {
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "isHwIDStoped packageManager is not null");
            list = packageManager.queryIntentActivities(intent, 0);
        }
        if (list != null) {
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "isHwIDStoped resolveInfos is not null");
            if (list.isEmpty()) {
                return false;
            }
            return true;
        }
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "action com.huawei.hwid.GET_AUTH_TOKEN in HwID is useless");
        return false;
    }

    private void m4705a(IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "enter aidlLogin():");
        Bundle bundle = new Bundle();
        bundle.putInt(CloudAccount.KEY_LOGIN_CHANNEL, 39000000);
        bundle.putInt(CloudAccount.KEY_REQCLIENTTYPE, 39);
        bundle.putBoolean("AIDL", true);
        bundle.putBoolean(CloudAccount.KEY_NEEDAUTH, z);
        CloudAccount.getAccountsByType(this.f2215c, this.f2215c.getPackageName(), bundle, new f(this, iBaseResponseCallback, z));
    }

    private void m4715b(IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "enter notAidlLogin():");
        Bundle bundle = new Bundle();
        bundle.putInt(CloudAccount.KEY_LOGIN_CHANNEL, 39000000);
        bundle.putInt(CloudAccount.KEY_REQCLIENTTYPE, 39);
        bundle.putBoolean("AIDL", false);
        bundle.putBoolean(CloudAccount.KEY_NEEDAUTH, z);
        CloudAccount.getAccountsByType(this.f2215c, this.f2215c.getPackageName(), bundle, new h(this, iBaseResponseCallback, z));
    }

    private static int m4724e(Context context) {
        try {
            C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "getHwIDVersionCode versionCode " + context.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionCode);
            return context.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionCode;
        } catch (NameNotFoundException e) {
            C2538c.m12680e("PLGLOGIN_HuaweiLoginManager", "getVersionTag NameNotFoundException error :" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("PLGLOGIN_HuaweiLoginManager", "getVersionTag Exception error :" + e2.getMessage());
        }
        return 0;
    }

    private boolean m4730j() {
        if (C0977d.m3534a() || 20504302 > C1092a.m4724e(BaseApplication.m2632b())) {
            return false;
        }
        return true;
    }

    private void m4704a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("PLGLOGIN_HuaweiLoginManager", "**********processLoginByNewMethod enter: ");
        try {
            C2538c.m12680e("PLGLOGIN_HuaweiLoginManager", "**********activity is: " + ((Activity) m4727g()));
            CloudAccount.loginSystemAccount(r0, new g(this, iBaseResponseCallback), 39000000);
            m4723d(BaseApplication.m2632b());
        } catch (ClassCastException e) {
            C2538c.m12680e("PLGLOGIN_HuaweiLoginManager", "ClassCastException e = " + e.getMessage());
            m4705a(iBaseResponseCallback, false);
        }
    }
}
