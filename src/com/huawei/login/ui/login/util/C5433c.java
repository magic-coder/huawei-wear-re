package com.huawei.login.ui.login.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.a.c;
import com.huawei.hwdataaccessmodel.p065a.C4761b;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.p190v.C2538c;

/* compiled from: SharedPreferenceUtil */
public class C5433c {
    private static C5433c f19258a = null;
    private static final String f19259c = C5433c.class.getSimpleName();
    private static final Object f19260d = new Object();
    private Context f19261b = null;

    public static C5433c m26039a(Context context) {
        C5433c c5433c;
        synchronized (f19260d) {
            if (f19258a == null) {
                f19258a = new C5433c(BaseApplication.b());
            }
            c5433c = f19258a;
        }
        return c5433c;
    }

    private C5433c(Context context) {
        this.f19261b = context;
    }

    public void m26045a(String str, C4761b c4761b) {
        C5431a.m26035a(str);
        a.a(String.valueOf(20000), "server_token", str, new c(1), c4761b);
        C2538c.c(f19259c, new Object[]{"setSeverToken completed :"});
    }

    public String m26040a() {
        C2538c.b(f19259c, new Object[]{"Enter getSeverToken"});
        String a = a.a(BaseApplication.b(), String.valueOf(20000), "server_token");
        C2538c.c(f19259c, new Object[]{"getSeverToken completed !!!"});
        return a;
    }

    public void m26043a(C4761b c4761b) {
        a.a(String.valueOf(20000), "server_token", c4761b);
        C2538c.c(f19259c, new Object[]{"getSeverToken completed !!!"});
    }

    public void m26042a(int i, C4761b c4761b) {
        a.a(String.valueOf(20000), "site_id", String.valueOf(i), new c(1), c4761b);
        C2538c.c(f19259c, new Object[]{"setSiteID completed, site id:" + i});
    }

    public void m26041a(int i) {
        a.a(BaseApplication.b(), String.valueOf(20000), "site_id", String.valueOf(i), new c(1));
        C2538c.c(f19259c, new Object[]{"setSiteID completed sync, site id:" + i});
    }

    public int m26047b() {
        String a = a.a(BaseApplication.b(), String.valueOf(20000), "site_id");
        C2538c.c(f19259c, new Object[]{"getSiteID completed !!!"});
        int i = -1;
        try {
            i = Integer.parseInt(a, 10);
        } catch (Exception e) {
            C2538c.c(f19259c, new Object[]{"parse int error:", a});
        }
        return i;
    }

    public void m26050b(String str, C4761b c4761b) {
        a.a(String.valueOf(20000), "country_code", str, new c(1), c4761b);
        C2538c.c(f19259c, new Object[]{"setCountryCode completed, country is:" + str});
    }

    public void m26044a(String str) {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return;
        }
        this.f19261b.getSharedPreferences("login_data", 0).edit().putString(ReportCardInfo.COLUMN_NAME_CARD_USERID, str).commit();
        C2538c.c(f19259c, new Object[]{"setUserID completed !!! userid is : ", str});
    }

    public String m26051c() {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return null;
        }
        String string = this.f19261b.getSharedPreferences("login_data", 0).getString(ReportCardInfo.COLUMN_NAME_CARD_USERID, null);
        C2538c.c(f19259c, new Object[]{"getUserID completed !!! userid is : ", string});
        C2538c.b(f19259c, new Object[]{"getUserID completed !!! userid is:", string, ";pid:", Integer.valueOf(Process.myPid())});
        return string;
    }

    public void m26049b(String str) {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return;
        }
        this.f19261b.getSharedPreferences("login_data", 0).edit().putString("account_name", str).commit();
        C2538c.c(f19259c, new Object[]{"setAccountName completed !!! accountName is : ", str});
    }

    public String m26054d() {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return null;
        }
        String string = this.f19261b.getSharedPreferences("login_data", 0).getString("account_name", null);
        C2538c.b(f19259c, new Object[]{"setAccountName completed !!! accountName is:", string, ";pid:", Integer.valueOf(Process.myPid())});
        return string;
    }

    public void m26052c(String str) {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return;
        }
        this.f19261b.getSharedPreferences("login_data", 0).edit().putString(SNBConstant.FIELD_DEVICE_ID, str).commit();
        C2538c.c(f19259c, new Object[]{"setDeviceId completed !!! deviceId is : ", str});
    }

    public String m26056e() {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return null;
        }
        String string = this.f19261b.getSharedPreferences("login_data", 0).getString(SNBConstant.FIELD_DEVICE_ID, null);
        C2538c.b(f19259c, new Object[]{"getDeviceId completed !!! deviceID is:", string, ";pid:", Integer.valueOf(Process.myPid())});
        return string;
    }

    public void m26055d(String str) {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return;
        }
        this.f19261b.getSharedPreferences("login_data", 0).edit().putString("device_type", str).commit();
        C2538c.c(f19259c, new Object[]{"setDeviceType completed !!! deviceType is : ", str});
    }

    public String m26058f() {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return null;
        }
        String string = this.f19261b.getSharedPreferences("login_data", 0).getString("device_type", null);
        C2538c.b(f19259c, new Object[]{"getDeviceType completed !!! deviceType is:", string, ";pid:", Integer.valueOf(Process.myPid())});
        return string;
    }

    public void m26048b(int i) {
        BaseApplication.b().getSharedPreferences("login_data", 0).edit().putInt("login_type", i).commit();
        C2538c.c(f19259c, new Object[]{"setLoginType completed !!!"});
    }

    public int m26059g() {
        SharedPreferences sharedPreferences = BaseApplication.b().getSharedPreferences("login_data", 0);
        C2538c.c(f19259c, new Object[]{"getLoginType completed !!!"});
        return sharedPreferences.getInt("login_type", -1);
    }

    public void m26057e(String str) {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return;
        }
        this.f19261b.getSharedPreferences("login_data", 0).edit().putString("session_id", str).commit();
        C2538c.c(f19259c, new Object[]{"setSessionID completed !!!"});
    }

    public String m26060h() {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return null;
        }
        SharedPreferences sharedPreferences = this.f19261b.getSharedPreferences("login_data", 0);
        C2538c.c(f19259c, new Object[]{"getSessionID completed !!!"});
        return sharedPreferences.getString("session_id", null);
    }

    public void m26053c(String str, C4761b c4761b) {
        a.a(String.valueOf(20000), "access_token", str, new c(1), c4761b);
        C2538c.c(f19259c, new Object[]{"setAccessToken completed !!!"});
    }

    public String m26061i() {
        String a = a.a(BaseApplication.b(), String.valueOf(20000), "access_token");
        C2538c.c(f19259c, new Object[]{"getAccessToken completed !!!"});
        return a;
    }

    public void m26046a(boolean z) {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return;
        }
        this.f19261b.getSharedPreferences("login_data", 0).edit().putBoolean("is_logined", z).commit();
        C2538c.c(f19259c, new Object[]{"setIsLogined completed !!!" + z});
    }

    public boolean m26062j() {
        if (this.f19261b == null) {
            C2538c.e(f19259c, new Object[]{"mContext is null !!!"});
            return false;
        }
        SharedPreferences sharedPreferences = this.f19261b.getSharedPreferences("login_data", 0);
        C2538c.c(f19259c, new Object[]{"getIsLogined completed !!!"});
        return sharedPreferences.getBoolean("is_logined", false);
    }
}
