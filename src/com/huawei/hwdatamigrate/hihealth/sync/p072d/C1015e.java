package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.c.b;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdatamigrate.hihealth.c.a;
import com.huawei.hwdatamigrate.hihealth.c.bs;
import com.huawei.hwdatamigrate.hihealth.c.d;
import com.huawei.hwdatamigrate.hihealth.h.e;
import com.huawei.hwdatamigrate.hihealth.p066a.C1001a;
import com.huawei.hwdatamigrate.hihealth.p068d.C1002g;
import com.huawei.hwdatamigrate.hihealth.sync.HiSyncService;
import com.huawei.hwdatamigrate.hihealth.sync.d.g;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: HiSyncControl */
public class C1015e {
    private static boolean f1808b = false;
    private static boolean f1809c = false;
    private static boolean f1810d = false;
    private static boolean f1811e = false;
    private static int f1812f;
    private static Context f1813g;
    SharedPreferences f1814a;

    public static C1015e m3856a(Context context) {
        f1813g = context.getApplicationContext();
        return g.a;
    }

    private C1015e() {
        this.f1814a = f1813g.getSharedPreferences("synSp", 0);
        C1015e.m3870i();
    }

    private static void m3870i() {
        f1812f = 2;
        C0970w.m3487a(f1812f);
        C2538c.m12677c("HiH_HiSyncControl", "initSyncModel current SyncModel is ", Integer.valueOf(2));
    }

    public static void m3858a(boolean z) {
        f1808b = z;
    }

    public static boolean m3859a() {
        return f1809c;
    }

    public static void m3861b(boolean z) {
        f1809c = z;
    }

    public static boolean m3862b() {
        return f1811e;
    }

    public static boolean m3864c() {
        return f1810d;
    }

    public boolean m3881a(String str) {
        return this.f1814a.getBoolean("initialSync" + str, true);
    }

    public void m3880a(String str, boolean z) {
        this.f1814a.edit().putBoolean("initialSync" + str, z).apply();
    }

    private void m3857a(int i) {
        this.f1814a.edit().putInt("currentDay", i).apply();
    }

    public int m3884d() {
        return this.f1814a.getInt("currentDay", 0);
    }

    private int m3871j() {
        return this.f1814a.getInt("appAutoSyncTimes", 0);
    }

    private long m3872k() {
        return this.f1814a.getLong("lastSyncBeginTime", 0);
    }

    private void m3873l() {
        this.f1814a.edit().putLong("lastSyncBeginTime", System.currentTimeMillis()).apply();
    }

    public int m3885e() {
        String a = e.a(f1813g).a();
        if (a == null || a.contains("com.huawei")) {
            C2538c.m12679d("HiH_HiSyncControl", "isSyncDone huid error");
            return 2;
        }
        int a2 = bs.a(f1813g).a(a, 0);
        if (a2 <= 0) {
            C2538c.m12679d("HiH_HiSyncControl", "isSyncDone userId error");
            return 2;
        }
        return this.f1814a.getInt("SYNC_DONE" + a2, 0);
    }

    public void m3882b(String str) {
        this.f1814a.edit().putInt("SYNC_DONE" + str, 1).apply();
    }

    private boolean m3874m() {
        return C0977d.m3555e(f1813g);
    }

    public static int m3868f() {
        if (f1812f > 0) {
            return f1812f;
        }
        C2538c.m12680e("HiH_HiSyncControl", "error syncModel is ", Integer.valueOf(f1812f));
        return 2;
    }

    public static boolean m3869g() {
        return C0970w.m3489b();
    }

    public void m3879a(HiSyncOption hiSyncOption, int i) {
        int a = C1002g.m3672a(f1813g, i);
        C2538c.m12677c("HiH_HiSyncControl", "startSync hiSyncOption = ", hiSyncOption, ",app = ", Integer.valueOf(i), " who = ", Integer.valueOf(a));
        int syncAction = hiSyncOption.getSyncAction();
        if (C1015e.m3860a(hiSyncOption, i, a)) {
            if (!m3867e(hiSyncOption.getSyncDataType()) && f1808b) {
                C2538c.m12679d("HiH_HiSyncControl", "startSync it is syncing right now !  hiSyncOption is ", hiSyncOption);
                C1016h.m3892b(f1813g);
            } else if (syncAction != 0 && !m3865c(hiSyncOption.getSyncAction())) {
                C2538c.m12677c("HiH_HiSyncControl", "ifCanAutoSync false");
            } else if (m3863b(i)) {
                Intent intent = new Intent(f1813g, HiSyncService.class);
                intent.putExtra("sync_option", hiSyncOption);
                intent.putExtra("sync_appId", i);
                intent.putExtra("sync_main_UserID", a);
                intent.setPackage("com.huawei.bone");
                f1813g.startService(intent);
                m3877p();
            } else {
                C1001a.m3646d(f1813g);
            }
        } else if (syncAction == 0) {
            C1001a.m3646d(f1813g);
        }
    }

    public void m3883c(String str) {
        if (str != null) {
            int a = d.a(f1813g).a(str);
            HiSyncOption hiSyncOption = new HiSyncOption();
            hiSyncOption.setSyncModel(2);
            hiSyncOption.setSyncAction(0);
            hiSyncOption.setSyncDataType(20000);
            hiSyncOption.setSyncMethod(2);
            m3879a(hiSyncOption, a);
        }
    }

    private boolean m3875n() {
        m3878q();
        if (System.currentTimeMillis() - m3872k() <= 600000) {
            C2538c.m12679d("HiH_HiSyncControl", "basicSyncCondition NOT! the app has sync too quick,intervalTime is ", Long.valueOf(System.currentTimeMillis() - m3872k()));
            return false;
        }
        C2538c.m12677c("HiH_HiSyncControl", "stepSyncOrNot appSynTimes is ", Integer.valueOf(m3871j()));
        if (m3871j() <= SyslogAppender.LOG_LOCAL2) {
            return true;
        }
        C2538c.m12679d("HiH_HiSyncControl", "basicSyncCondition NOT! the app has sync too many times,appSynTimes is ", Integer.valueOf(r2));
        return false;
    }

    private boolean m3863b(int i) {
        if (C1015e.m3869g()) {
            C2538c.m12679d("HiH_HiSyncControl", "ifCanSync not! no cloud version");
            return false;
        } else if (!m3874m()) {
            C2538c.m12679d("HiH_HiSyncControl", "ifCanSync not! no networkConnected");
            return false;
        } else if (m3866d(i)) {
            return true;
        } else {
            C2538c.m12679d("HiH_HiSyncControl", "ifCanSync not! not login in database");
            return false;
        }
    }

    private boolean m3865c(int i) {
        if (i != 2 && !m3875n()) {
            C2538c.m12679d("HiH_HiSyncControl", "ifCanAutoSync basicSyncCondition is false");
            return false;
        } else if (m3876o()) {
            return true;
        } else {
            C2538c.m12679d("HiH_HiSyncControl", "ifCanAutoSync autoSyncSwitch is closed");
            return false;
        }
    }

    private boolean m3876o() {
        String a = C0996a.m3612a(f1813g, Integer.toString(10000), "auto_synchronous_flag");
        if (a == null) {
            C2538c.m12677c("HiH_HiSyncControl", "needAutoSync autoSyncSwitch is null ,let it autoSync");
            return true;
        } else if (a.equals("") || a.equals("1")) {
            C2538c.m12677c("HiH_HiSyncControl", "needAutoSync autoSyncSwitch is open");
            return true;
        } else {
            C2538c.m12677c("HiH_HiSyncControl", "needAutoSync autoSyncSwitch is closed");
            return false;
        }
    }

    private boolean m3866d(int i) {
        String b = a.a(f1813g).b(i);
        if (b != null && !b.contains("com.")) {
            return true;
        }
        C2538c.m12679d("HiH_HiSyncControl", "isLogin such app can not sync , app is ", Integer.valueOf(i));
        return false;
    }

    private void m3877p() {
        m3873l();
        this.f1814a.edit().putInt("appAutoSyncTimes", this.f1814a.getInt("appAutoSyncTimes", 0) + 1).apply();
    }

    public void m3886h() {
        this.f1814a.edit().putInt("appAutoSyncTimes", 0).apply();
        this.f1814a.edit().putLong("lastSyncBeginTime", b.b(System.currentTimeMillis())).apply();
    }

    private void m3878q() {
        int a = b.a(System.currentTimeMillis());
        if (a != m3884d()) {
            C2538c.m12677c("HiH_HiSyncControl", "checkCurrentDay a new day comes , reset basicSyncCondition, currentDay is ", Integer.valueOf(a), " oldDay is ", Integer.valueOf(m3884d()));
            m3857a(a);
            m3886h();
        }
    }

    public static boolean m3860a(HiSyncOption hiSyncOption, int i, int i2) {
        if (hiSyncOption == null) {
            C2538c.m12679d("HiH_HiSyncControl", "paraCheck hiSyncOption is null");
            return false;
        } else if (hiSyncOption.getSyncMethod() != 2) {
            C2538c.m12679d("HiH_HiSyncControl", "paraCheck syncMethod is not by_user");
            return false;
        } else if (i <= 0) {
            C2538c.m12679d("HiH_HiSyncControl", "paraCheck app <= 0 ");
            return false;
        } else if (i2 <= 0) {
            C2538c.m12679d("HiH_HiSyncControl", "paraCheck who <= 0 ");
            return false;
        } else if (com.huawei.hihealth.data.c.g.a(hiSyncOption.getSyncDataType())) {
            return true;
        } else {
            C2538c.m12679d("HiH_HiSyncControl", "paraCheck error syncType type is ", Integer.valueOf(hiSyncOption.getSyncDataType()));
            return false;
        }
    }

    private boolean m3867e(int i) {
        switch (i) {
            case MessageObserver.RET_AUTH_ERROR /*10005*/:
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION /*10006*/:
                return true;
            default:
                return false;
        }
    }
}
