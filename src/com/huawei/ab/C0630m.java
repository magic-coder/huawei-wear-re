package com.huawei.ab;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.a.c;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.c.d;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdatamigrate.a.ba;
import com.huawei.hwdatamigrate.a.h;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HWUserProfileMgr */
public class C0630m extends C0628a {
    private static C0630m f1115b;
    private static HashSet<String> f1116c = new HashSet(Arrays.asList(new String[]{"com.huawei.bone.action.CLOUD_SWITCH_CHANGED", "com.huawei.bone.action.FITNESS_USERINFO_UPDATED"}));
    private static final String[] f1117e = new String[]{"", "true", "", "", "true", "true"};
    private static final Object f1118g = new Object();
    private Context f1119a = null;
    private d f1120d = null;
    private ExecutorService f1121f;
    private a f1122h;
    private BroadcastReceiver f1123i = new n(this);
    private BroadcastReceiver f1124j = new o(this);

    private C0630m(Context context) {
        super(context);
        this.f1119a = context;
        this.f1121f = Executors.newFixedThreadPool(5);
        if (this.f1120d == null) {
            this.f1120d = d.a(context);
        }
        registerBroadcast(this.f1123i, "com.huawei.plugin.account.login");
        registerBroadcast(this.f1124j, "com.huawei.plugin.account.logout");
        this.f1122h = a.a(this.f1119a);
    }

    public static C0630m m2297a(Context context) {
        C0630m c0630m;
        synchronized (f1118g) {
            if (f1115b == null) {
                f1115b = new C0630m(context.getApplicationContext());
            }
            c0630m = f1115b;
        }
        return c0630m;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1004);
    }

    protected Set<String> getAvailableBroadcastSet() {
        return f1116c;
    }

    public void m2309a(String str, String str2, a<Boolean> aVar) {
    }

    public String m2303a(String str) {
        C2538c.m12677c("HWUserProfileMgr", " getCustomeDefine Entry, key=" + str);
        return "";
    }

    public void m2305a(Context context, com.huawei.up.b.a aVar) {
        this.f1122h.a(context, aVar);
    }

    private void m2300a(boolean z, Context context, UserInfomation userInfomation, a<Boolean> aVar) {
        C2538c.m12677c("HWUserProfileMgr", " setUserInfo Entry, user=" + userInfomation.toString());
        v.a(userInfomation.getPicPath());
        this.f1120d.a(context, userInfomation, new p(this, z, aVar, userInfomation));
    }

    public void m2308a(UserInfomation userInfomation, a<Boolean> aVar) {
        C2538c.m12677c("HWUserProfileMgr", " enter setUserInfoToHILocal user=" + userInfomation.toString());
        c.a(this.f1119a).b(new q(this, userInfomation, aVar));
    }

    public void m2316b(UserInfomation userInfomation, a<Boolean> aVar) {
        C2538c.m12677c("HWUserProfileMgr", " setUserInfoToLocal Entry, user=" + userInfomation.toString());
        c.a(this.f1119a).b(new r(this, userInfomation, aVar));
    }

    boolean m2312a(UserInfomation userInfomation) {
        if (userInfomation.getHeight() <= 0 || userInfomation.getWeight() <= 0) {
            return false;
        }
        return true;
    }

    public void m2311a(boolean z, Context context, UserInfomation userInfomation, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWUserProfileMgr", "setUserInfo enter ");
        if (!m2312a(userInfomation)) {
            C2538c.m12679d("HWUserProfileMgr", "invalide user info");
            C2538c.m12674b("HWUserProfileMgr", "invalide userinfo = ", userInfomation);
            iBaseResponseCallback.onResponse(300099, null);
        } else if (m2320e()) {
            C2538c.m12677c("HWUserProfileMgr", "setUserInfo() if (getIfAccountArea())");
            m2300a(z, context, userInfomation, new s(this, iBaseResponseCallback));
        } else {
            C2538c.m12677c("HWUserProfileMgr", "setUserInfo() if (getIfAccountArea()) ELSE");
            m2316b(userInfomation, new t(this, iBaseResponseCallback));
        }
    }

    public UserInfomation m2301a() {
        return v.a();
    }

    public void m2306a(IBaseResponseCallback iBaseResponseCallback) {
        v.a(iBaseResponseCallback);
    }

    public void m2304a(int i, boolean z, String str, IBaseResponseCallback iBaseResponseCallback) {
        v.a(i, z, str, iBaseResponseCallback);
    }

    public String m2302a(int i) {
        return v.a(i);
    }

    public void m2313b() {
        C2538c.m12677c("HWUserProfileMgr", "reuploadUserPrivacy Enter");
        this.f1121f.execute(new u(this));
    }

    public boolean m2318c() {
        C2538c.m12677c("HWUserProfileMgr", "getUserAgreeFlagJoinPlan enter");
        String a = m2302a(1);
        if (a == null || "".equals(a)) {
            return true;
        }
        C2538c.m12677c("HWUserProfileMgr", "getUserAgreeFlagJoinPlan,isAgreeFlag = " + Boolean.parseBoolean(a));
        return Boolean.parseBoolean(a);
    }

    public void m2310a(boolean z) {
        C2538c.m12677c("HWUserProfileMgr", "setUserPrivacyUpgraded, flag = " + z);
        setSharedPreference("KEY_PERSONAL_PRIVACY_SETTINGS_UPGRADED_FLAG", String.valueOf(z), null);
    }

    public boolean m2319d() {
        String sharedPreference = getSharedPreference("KEY_PERSONAL_PRIVACY_SETTINGS_UPGRADED_FLAG");
        if ("".equals(sharedPreference)) {
            return false;
        }
        C2538c.m12677c("HWUserProfileMgr", "getUserPrivacyUpgraded, flag = ", sharedPreference, ", ret = ", Boolean.valueOf(Boolean.parseBoolean(sharedPreference)));
        return Boolean.parseBoolean(sharedPreference);
    }

    public boolean onDataMigrate() {
        C2538c.m12677c("HWUserProfileMgr", "onDataMigrate Enter...");
        com.huawei.hwdatamigrate.a a = com.huawei.hwdatamigrate.a.a(this.f1119a);
        boolean k = a.k(this.f1119a);
        C2538c.m12677c("HWUserProfileMgr", "onDataMigrate cloudServiceOn = ", Boolean.valueOf(k), ", userInfoOn = ", Boolean.valueOf(a.l(this.f1119a)));
        if (C0969i.m3482a(50)) {
            m2304a(2, k, "", null);
            m2304a(3, k, "", null);
        } else {
            m2304a(2, r0, "", null);
            m2304a(3, k, "", null);
        }
        m2310a(true);
        return super.onDataMigrate();
    }

    public boolean m2320e() {
        C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() enter");
        String i = m2324i();
        if (i.equals("1")) {
            C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() if (flag.equals(ACCOUNT_AREA))");
            return true;
        } else if (i.equals("2")) {
            C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() else if (flag.equals(NO_ACCOUNT_AREA))");
            if (1 != C1093a.m4739a(this.f1119a).m4752e()) {
                return false;
            }
            C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() siteid is china");
            m2317b("1");
            return true;
        } else {
            if (m2322g()) {
                C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() if (getIfCoverFrom15())");
                if (m2323h()) {
                    C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() if (getIfLoginIn15())");
                    m2317b("1");
                    return true;
                }
            }
            C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() if (getIfCoverFrom15()) ELSE");
            if (C0977d.m3536a(BaseApplication.m2632b(), "") || C0977d.m3535a(BaseApplication.m2632b())) {
                C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() if (getIfInEUAccountArea())");
                m2317b("1");
                return true;
            }
            C2538c.m12677c("HWUserProfileMgr", "getIfAccountArea() if (getIfInEUAccountArea()) ELSE");
            m2317b("2");
            return false;
        }
    }

    public String m2321f() {
        C2538c.m12677c("HWUserProfileMgr", "Enter getAccountAreaFlag!");
        String str = "";
        str = m2324i();
        if (str.equals("1")) {
            C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag if (flag.equals(ACCOUNT_AREA)) retAccountArea = " + "1");
            return "1";
        } else if (str.equals("2")) {
            if (1 == C1093a.m4739a(this.f1119a).m4752e()) {
                C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag siteid is china retAccountArea = " + "1");
                m2317b("1");
                return "1";
            }
            C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag else if (flag.equals(NO_ACCOUNT_AREA)) retAccountArea = " + "2");
            return "2";
        } else if (m2322g() && m2323h()) {
            C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag if (getIfCoverFrom15 && getIfLoginIn15) retAccountArea = " + "1");
            m2317b("1");
            return "1";
        } else {
            C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag if (getIfCoverFrom15()) ELSE");
            str = "";
            if (C0977d.m3544b(BaseApplication.m2632b())) {
                if (C0977d.m3545b(BaseApplication.m2632b(), C0977d.m3547c(BaseApplication.m2632b()))) {
                    C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag judgeIfInAccountArea set ACCOUNT_AREA!");
                    str = "1";
                    m2317b("1");
                    return str;
                }
                C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag judgeIfInAccountArea set NO_ACCOUNT_AREA!");
                str = "2";
                m2317b("2");
                return str;
            }
            C2538c.m12677c("HWUserProfileMgr", "getAccountAreaFlag isSameTelephonyNetWorkAndSim ELSE retAccountArea = " + "3");
            return "3";
        }
    }

    public boolean m2322g() {
        C2538c.m12677c("HWUserProfileMgr", "getIfCoverFrom15() enter");
        com.huawei.hwdatamigrate.a a = com.huawei.hwdatamigrate.a.a(BaseApplication.m2632b());
        if (a.a()) {
            C2538c.m12677c("HWUserProfileMgr", "getIfCoverFrom15() if (status)");
            return false;
        } else if (a.b(BaseApplication.m2632b())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean m2323h() {
        C2538c.m12677c("HWUserProfileMgr", "getIfLoginIn15() enter");
        String a = h.a(BaseApplication.m2632b());
        if (a == null || a.equals("")) {
            C2538c.m12677c("HWUserProfileMgr", "getIfLoginIn15() if (strUserID == null || strUserID.equals(\"\"))");
            return false;
        }
        ba c = h.c(BaseApplication.m2632b(), a);
        if (c != null && c.g != null && !c.g.isEmpty()) {
            return true;
        }
        C2538c.m12677c("HWUserProfileMgr", "getIfLoginIn15() if ((userConfigTable == null) || (userConfigTable.accessToken_Login == null) || (userConfigTable.accessToken_Login.isEmpty()))");
        return false;
    }

    public void m2317b(String str) {
        C2538c.m12677c("HWUserProfileMgr", "setIfAccountAreaInSharePreference() enter");
        setSharedPreference("KEY_IF_ACCOUNT_AREA", str, null);
    }

    public String m2324i() {
        C2538c.m12677c("HWUserProfileMgr", "getIfAccountAreaInSharePreference() enter");
        String sharedPreference = getSharedPreference("KEY_IF_ACCOUNT_AREA");
        if (sharedPreference == null) {
            return "0";
        }
        if (sharedPreference.equals("1")) {
            return "1";
        }
        if (sharedPreference.equals("2")) {
            return "2";
        }
        return "0";
    }

    public void m2315b(Context context) {
        C2538c.m12677c("HWUserProfileMgr", "setNoAccountArea() enter");
        C1093a a = C1093a.m4739a(context);
        a.m4748a(true);
        a.m4746a("0");
    }

    public void m2307a(com.huawei.up.b.a aVar, boolean z, boolean z2, int... iArr) {
        this.f1122h.a(aVar, z, z2, iArr);
    }

    private void m2299a(HiUserInfo hiUserInfo, long j) {
        C2538c.m12677c("HWUserProfileMgr", "setHiUserInfoModifiedTime time = " + j);
        hiUserInfo.setCreateTime(j);
    }

    public void m2314b(int i) {
        C2538c.m12677c("HWUserProfileMgr", "setTryLoginCountryCountToSharePreference count = " + ("" + i));
        setSharedPreference("key_login_country_try_count", r0, null);
    }

    public int m2325j() {
        C2538c.m12677c("HWUserProfileMgr", "getTryLoginCountryCountToSharePreference count = " + getSharedPreference("key_login_country_try_count"));
        return com.huawei.hwcommonmodel.d.c.a(getSharedPreference("key_login_country_try_count"));
    }
}
