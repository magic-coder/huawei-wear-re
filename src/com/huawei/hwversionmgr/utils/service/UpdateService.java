package com.huawei.hwversionmgr.utils.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwversionmgr.p079a.C1068c;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.hwversionmgr.p081c.p082a.C1073b;
import com.huawei.hwversionmgr.utils.C1078c;
import com.huawei.hwversionmgr.utils.C1079e;
import com.huawei.hwversionmgr.utils.C1080f;
import com.huawei.hwversionmgr.utils.p083a.C1074a;
import com.huawei.hwversionmgr.utils.p083a.C1075b;
import com.huawei.hwversionmgr.utils.p083a.C1076c;
import com.huawei.hwversionmgr.utils.p084b.C1077f;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UpdateService extends Service {
    private C1073b f2176a = null;
    private Context f2177b = null;
    private String f2178c = null;
    private String f2179d = null;
    private int f2180e = 0;
    private int f2181f = 0;
    private String f2182g = null;
    private String f2183h = null;
    private String f2184i = null;
    private int f2185j = -1;
    private int f2186k = 2;
    private int f2187l = 1;
    private int f2188m = -1;
    private C1071a f2189n;
    private ExecutorService f2190o;
    private BroadcastReceiver f2191p = new C1081a(this);
    private final BroadcastReceiver f2192q = new C1082b(this);
    private C1074a f2193r = new C1083c(this);
    private C1074a f2194s = new C1084d(this);
    private C1076c f2195t = new C1085e(this);
    private C1076c f2196u = new C1086f(this);
    private C1075b f2197v = new C1087g(this);
    private C1075b f2198w = new C1088h(this);

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f2177b = getApplicationContext();
        C2538c.m12677c("UpdateService", "onCreate");
        this.f2176a = new C1073b(this.f2177b);
        this.f2189n = C1071a.m4507a(this.f2177b);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_app_download_new_version");
        intentFilter.addAction("action_app_download_hihealth_new_version");
        intentFilter.addAction("action_app_install_new_version");
        intentFilter.addAction("action_app_download_cancel");
        registerReceiver(this.f2191p, intentFilter, "com.huawei.wearable.permission.internal", null);
    }

    public void onDestroy() {
        super.onDestroy();
        C2538c.m12677c("UpdateService", "onDestroy");
        unregisterReceiver(this.f2191p);
        if (this.f2192q != null) {
            try {
                this.f2177b.unregisterReceiver(this.f2192q);
            } catch (Exception e) {
                C2538c.m12674b("UpdateService", e.getMessage());
            }
        }
        if (this.f2190o != null) {
            this.f2190o.shutdown();
        }
        this.f2184i = null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2538c.m12677c("UpdateService", "onStartCommand: intent = " + intent);
        m4629a(intent);
        return 2;
    }

    private void m4629a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            C2538c.m12677c("UpdateService", "handleIntent: action = " + action);
            if ("action_app_auto_check_new_version".equals(action)) {
                action = C0977d.m3564h(this.f2177b);
                C2538c.m12677c("UpdateService", "checkNewVersion telephIMEI = " + action);
                if (TextUtils.equals(action, "")) {
                    C2538c.m12677c("UpdateService", "can not get phone imei ,cancel autocheck");
                    return;
                }
                m4636a(action);
            } else if ("action_band_auto_check_new_version".equals(action)) {
                r0 = intent.getIntExtra("extra_band_type", -1);
                r1 = intent.getStringExtra("extra_band_version");
                r2 = intent.getStringExtra("extra_band_imei");
                C2538c.m12677c("UpdateService", "checkNewVersion type = " + r0);
                C2538c.m12677c("UpdateService", "checkNewVersion bandVersion = " + r1);
                C2538c.m12677c("UpdateService", "checkNewVersion bandIMEI = " + r2);
                if (r0 == -1 || TextUtils.isEmpty(r1) || TextUtils.isEmpty(r2)) {
                    C2538c.m12677c("UpdateService", "bandVersion or bandIMEI is invalid!");
                    return;
                }
                m4628a(r0, r1, r2);
            } else if ("action_app_manual_update_new_version".equals(action)) {
                this.f2186k = 2;
                C2538c.m12677c("UpdateService", "checkNewVersion telephIMEI = " + C0977d.m3564h(this.f2177b));
                m4644b(action);
            } else if ("action_hihealth_app_manual_update_new_version".equals(action)) {
                this.f2186k = 2;
                C2538c.m12677c("UpdateService", "checkNewVersion telephIMEI = " + C0977d.m3564h(this.f2177b));
                m4649c(action);
            } else if ("action_band_manual_update_new_version".equals(action)) {
                this.f2187l = 3;
                r0 = intent.getIntExtra("extra_band_type", -1);
                r1 = intent.getStringExtra("extra_band_version");
                r2 = intent.getStringExtra("extra_band_imei");
                C2538c.m12677c("UpdateService", "checkNewVersion type = " + r0);
                C2538c.m12677c("UpdateService", "checkNewVersion bandVersion = " + r1);
                C2538c.m12677c("UpdateService", "checkNewVersion bandIMEI = " + r2);
                m4642b(r0, r1, r2);
            } else if ("action_app_download_new_version".equals(action)) {
                m4634a(Boolean.valueOf(true));
            } else if ("action_band_download_new_version".equals(action)) {
                m4634a(Boolean.valueOf(false));
            } else if ("action_app_download_hihealth_new_version".equals(action)) {
                m4653d();
            } else if ("action_app_auto_download".equals(action)) {
                m4659f();
            } else if ("action_app_install_new_version".equals(action)) {
                m4663h();
            } else if ("action_cancel_download_app".equals(action)) {
                C2538c.m12677c("UpdateService", "cancel download app!");
                this.f2176a.m4539a();
            } else if ("action_app_update_success".equals(action)) {
                m4635a(Boolean.valueOf(true), Boolean.valueOf(true));
            } else if ("action_app_update_failed".equals(action)) {
                m4635a(Boolean.valueOf(true), Boolean.valueOf(false));
            } else if ("action_band_update_success".equals(action)) {
                m4635a(Boolean.valueOf(false), Boolean.valueOf(true));
            } else if ("action_band_update_failed".equals(action)) {
                m4635a(Boolean.valueOf(false), Boolean.valueOf(false));
            }
        }
    }

    private void m4635a(Boolean bool, Boolean bool2) {
        C2538c.m12677c("UpdateService", "reportStatus isApp: " + bool + " isSuccess: " + bool2);
        if (this.f2190o == null || this.f2190o.isShutdown()) {
            this.f2190o = Executors.newSingleThreadExecutor();
        }
        C1068c c1068c = new C1068c();
        if (bool2.booleanValue()) {
            c1068c.f2123a = 3;
        } else {
            c1068c.f2123a = 4;
        }
        c1068c.f2124b = C1078c.m4574c(this.f2177b);
        if (bool.booleanValue() && C1078c.m4587i() != null) {
            c1068c.f2125c = C1078c.m4587i().f2130c;
        } else if (!(bool.booleanValue() || C1078c.m4588j() == null)) {
            c1068c.f2125c = C1078c.m4588j().f2130c;
        }
        c1068c.f2126d = C1078c.m4557a(C1078c.m4586h(), this.f2177b);
        c1068c.f2127e = "";
        this.f2190o.execute(new C1077f(this.f2177b, c1068c));
    }

    private void m4622a() {
        this.f2185j = -1;
        this.f2177b.registerReceiver(this.f2192q, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private void m4636a(String str) {
        C2538c.m12677c("UpdateService", "autoAppCheckNewVersion = telephIMEI" + str);
        C2538c.m12677c("UpdateService", "autoAppCheckNewVersion = strLastTime" + C1080f.m4596a(this.f2177b));
        C2538c.m12677c("UpdateService", "autoAppCheckNewVersion = alreadyCheck" + C1080f.m4602b(r0));
        if (C1080f.m4602b(r0)) {
            stopSelf();
            return;
        }
        this.f2176a.m4543a(str, this.f2193r);
        this.f2186k = 0;
    }

    private void m4628a(int i, String str, String str2) {
        C2538c.m12677c("UpdateService", "autoBandCheckNewVersion = type" + i + ",+version = " + str + ",+macAddress = " + str2);
        if (C1080f.m4602b(C1080f.m4600b(this.f2177b)) || m4671l()) {
            m4623a(11);
            return;
        }
        this.f2176a.m4540a(i, str, str2, this.f2194s);
        this.f2187l = 1;
    }

    private void m4644b(String str) {
        C2538c.m12677c("UpdateService", "manualAppCheckNewVersion");
        m4624a(10, -1);
        this.f2176a.m4543a(str, this.f2193r);
    }

    private void m4649c(String str) {
        C2538c.m12677c("UpdateService", "manualHiHlealthAppCheckNewVersion");
        this.f2184i = WeChat.HEALTH_PACKAGE_NAME;
        this.f2176a.m4545b(str, this.f2193r);
    }

    private void m4642b(int i, String str, String str2) {
        C2538c.m12677c("UpdateService", "manualBandCheckNewVersion");
        m4624a(10, -1);
        this.f2176a.m4540a(i, str, str2, this.f2194s);
    }

    private void m4624a(int i, int i2) {
        m4625a(i, i2, "", "", 0);
    }

    private void m4625a(int i, int i2, String str, String str2, int i3) {
        C2538c.m12677c("UpdateService", "broadcastCheckState: state = " + i + ", result = " + i2 + ",content = " + str);
        Intent intent = new Intent("action_app_check_new_version_state");
        intent.addFlags(1610612736);
        intent.putExtra("state", i);
        intent.putExtra("result", i2);
        intent.putExtra("content", str);
        intent.putExtra("minAppCode", i3);
        intent.putExtra("mPackageName", this.f2184i);
        if (TextUtils.equals(str2, "true")) {
            intent.putExtra("isForced", true);
        } else {
            intent.putExtra("isForced", false);
        }
        this.f2177b.sendBroadcast(intent, C0976c.f1642a);
    }

    private void m4626a(int i, int i2, String str, String str2, int i3, String str3) {
        C2538c.m12677c("UpdateService", "broadcastCheckState: state = " + i + ", result = " + i2 + ",content = " + str);
        Intent intent = new Intent("action_app_check_new_version_state");
        intent.addFlags(1610612736);
        intent.putExtra("state", i);
        intent.putExtra("result", i2);
        intent.putExtra("content", str);
        intent.putExtra("minAppCode", i3);
        intent.putExtra("mPackageName", str3);
        if (TextUtils.equals(str2, "true")) {
            intent.putExtra("isForced", true);
        } else {
            intent.putExtra("isForced", false);
        }
        this.f2177b.sendBroadcast(intent, C0976c.f1642a);
    }

    private void m4623a(int i) {
        m4627a(i, "", 0, "", "", 0);
    }

    private void m4627a(int i, String str, int i2, String str2, String str3, int i3) {
        C2538c.m12677c("UpdateService", "broadcastAutoCheckResult: result = " + i + ",+name = " + str + ",+ size = " + i2 + "isForced:" + str3 + "appMinCode" + i3);
        C2538c.m12677c("UpdateService", "broadcastAutoCheckResult: changelog = " + str2);
        Intent intent = new Intent("action_band_auto_check_new_version_result");
        intent.addFlags(1610612736);
        intent.putExtra("result", i);
        intent.putExtra("name", str);
        intent.putExtra(UploadFile.SIZE_LABEL, i2);
        intent.putExtra("changelog", str2);
        intent.putExtra("minAppCode", i3);
        if (TextUtils.equals(str3, "true")) {
            intent.putExtra("isForced", true);
        } else {
            intent.putExtra("isForced", false);
        }
        this.f2177b.sendBroadcast(intent, C0976c.f1642a);
    }

    private void m4641b() {
        C2538c.m12677c("UpdateService", "fetchChangeLog");
        m4624a(30, -1);
        this.f2176a.m4542a(this.f2195t, Boolean.valueOf(true));
    }

    private void m4648c() {
        C2538c.m12677c("UpdateService", "fetchChangeLogForBand");
        m4624a(30, -1);
        this.f2176a.m4542a(this.f2196u, Boolean.valueOf(false));
    }

    private void m4634a(Boolean bool) {
        if (bool.booleanValue()) {
            this.f2188m = 2;
        } else {
            this.f2188m = 3;
        }
        C2538c.m12677c("UpdateService", "downloadFile: newVersionExist = " + m4665i() + "isAPP:" + bool);
        if (!m4665i()) {
            m4661g();
        } else if (m4657e()) {
            m4624a(23, 0);
        } else {
            m4661g();
        }
    }

    private void m4653d() {
        C2538c.m12677c("UpdateService", "downloadHiHealthFile: newVersionExist = " + m4665i());
        this.f2184i = WeChat.HEALTH_PACKAGE_NAME;
        if (!m4665i()) {
            m4661g();
        } else if (m4657e()) {
            m4624a(23, 0);
        } else {
            m4661g();
        }
    }

    private boolean m4657e() {
        String str;
        C2538c.m12677c("UpdateService", "enter checkMd5 mReportSuccess:" + this.f2188m);
        String str2 = "";
        str2 = "";
        if (this.f2188m == 2 || this.f2188m == 0) {
            str2 = this.f2189n.m4528k();
            str = C1078c.m4587i().f2145r;
        } else {
            str2 = this.f2189n.m4527j();
            str = C1078c.m4588j().f2145r;
        }
        String a = C1079e.m4591a(str2);
        File file = new File(str2);
        C2538c.m12677c("UpdateService", "srcMd5=" + str + " ,path=" + str2 + " file exists:" + file.exists() + " file size:" + file.length());
        if (str.equals(a)) {
            C2538c.m12677c("UpdateService", "verify md5 success  " + a);
            return true;
        }
        C2538c.m12677c("UpdateService", "verify md5 failed  " + a);
        if (this.f2186k == 0 || this.f2186k == 2) {
            m4667j();
        }
        if (this.f2186k == 1 || this.f2186k == 3) {
            m4669k();
        }
        return false;
    }

    private void m4659f() {
        this.f2176a.m4541a(this.f2197v, Boolean.valueOf(false));
    }

    private void m4661g() {
        m4624a(20, -1);
        m4622a();
    }

    private boolean m4637a(Context context, String str) {
        return C0977d.m3556e(context, str);
    }

    private void m4663h() {
        String k = this.f2189n.m4528k();
        C2538c.m12677c("UpdateService", "install: strAppStorePath = " + k);
        if (TextUtils.isEmpty(k)) {
            C2538c.m12680e("UpdateService", "install() error, file path is empty...");
            m4624a(40, 47);
        } else if (WeChat.HEALTH_PACKAGE_NAME.equals(this.f2184i) || m4637a(this.f2177b, k)) {
            m4624a(27, 0);
            this.f2176a.m4544a(k, null);
        } else {
            C2538c.m12680e("UpdateService", "install() error, is not the same signatures...");
            m4624a(22, 47);
        }
    }

    private boolean m4665i() {
        C2538c.m12677c("UpdateService", "enter isNewVersionFileExist() mReportSuccess:" + this.f2188m);
        Object obj = "";
        if (this.f2188m == 2 || this.f2188m == 0) {
            obj = this.f2189n.m4528k();
        }
        if (this.f2188m == 3 || this.f2188m == 1) {
            obj = this.f2189n.m4527j();
        }
        C2538c.m12677c("UpdateService", "isNewVersionFileExist(): strAppStorePath = " + obj);
        if (TextUtils.isEmpty(obj)) {
            C2538c.m12680e("UpdateService", "isNewVersionFileExist() error, file path is empty...");
            return false;
        }
        C2538c.m12677c("UpdateService", "isNewVersionFileExist: bExist = " + new File(obj).exists());
        return new File(obj).exists();
    }

    private void m4667j() {
        Object k = this.f2189n.m4528k();
        C2538c.m12677c("UpdateService", "deleteUpdateApk: path = " + k);
        if (!TextUtils.isEmpty(k)) {
            File file = new File(k);
            if (file.exists()) {
                try {
                    if (file.delete()) {
                        C2538c.m12677c("UpdateService", "删除成功.");
                    }
                } catch (Exception e) {
                    C2538c.m12677c("UpdateService", "deleteUpdateApk: Exception e = " + e);
                }
            }
        }
    }

    private void m4669k() {
        String j = this.f2189n.m4527j();
        C2538c.m12677c("UpdateService", "deleteUpdateDfu: path = " + j);
        if (!TextUtils.isEmpty(j)) {
            File file = new File(j);
            if (file.exists() && !file.delete()) {
                C2538c.m12680e("UpdateService", "deleteUpdateDfu: path = " + j + " failed!");
            }
        }
    }

    private boolean m4671l() {
        List runningTasks = ((ActivityManager) this.f2177b.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            C2538c.m12677c("UpdateService", "current activity  :" + componentName.getClassName());
            if (TextUtils.equals(componentName.getClassName(), "com.huawei.ui.main.stories.about.activity.update.AppUpdateDialogActivity") || TextUtils.equals(componentName.getClassName(), "com.huawei.ui.device.activity.update.UpdateVersionActivity") || TextUtils.equals(componentName.getClassName(), "com.huawei.ui.device.activity.update.DeviceOtaActivity")) {
                return true;
            }
        }
        return false;
    }
}
