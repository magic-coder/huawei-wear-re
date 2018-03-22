package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.C0975b;
import com.huawei.hwversionmgr.p080b.C1071a;
import com.huawei.hwversionmgr.utils.service.UpdateService;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.ui.main.stories.about.activity.update.AppUpdateDialogActivity;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import com.sina.weibo.sdk.constant.WBConstants;

/* compiled from: AppUpdateInteractor */
public class C2279a {
    private static C2279a f8272f;
    public int f8273a = 0;
    public String f8274b = null;
    public String f8275c = null;
    public String f8276d = null;
    public boolean f8277e = false;

    public static C2279a m11722a() {
        if (f8272f == null) {
            f8272f = new C2279a();
        }
        return f8272f;
    }

    public void m11733b() {
        C2538c.m12677c("AppUpdateInteractor", "autoCheckAppNewVersionService");
        if (BaseApplication.m2632b() != null) {
            this.f8277e = true;
            C1071a.m4507a(BaseApplication.m2632b()).m4511a(Boolean.valueOf(true));
        }
    }

    public void m11735c() {
        if (BaseApplication.m2632b() != null) {
            C1071a.m4507a(BaseApplication.m2632b()).m4511a(Boolean.valueOf(false));
        }
    }

    public void m11736d() {
        if (BaseApplication.m2632b() != null) {
            C1071a.m4507a(BaseApplication.m2632b()).m4509a();
        }
    }

    public void m11737e() {
        C2538c.m12677c("AppUpdateInteractor", "doDownloadAppFile ");
        if (BaseApplication.m2632b() != null) {
            C1071a.m4507a(BaseApplication.m2632b()).m4514b(Boolean.valueOf(true));
        }
    }

    public void m11738f() {
        C2538c.m12677c("AppUpdateInteractor", "doDownloadHiHealthAppFile ");
        if (BaseApplication.m2632b() != null) {
            C1071a.m4507a(BaseApplication.m2632b()).m4513b();
        }
    }

    public void m11739g() {
        C2538c.m12677c("AppUpdateInteractor", "cancelDownloadApp");
        if (BaseApplication.m2632b() != null) {
            C1071a.m4507a(BaseApplication.m2632b()).m4516c();
        }
    }

    public void m11727a(Context context) {
        C2538c.m12677c("AppUpdateInteractor", "installApk 安装app ");
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction("action_app_install_new_version");
        context.startService(intent);
    }

    public boolean m11732a(long j) {
        C2538c.m12677c("AppUpdateInteractor", "checkMemory needSize = " + j);
        StatFs statFs = new StatFs(BaseApplication.m2632b().getFilesDir().getAbsolutePath());
        if (((long) (((double) (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()))) * 0.9d)) > j) {
            return true;
        }
        return false;
    }

    public boolean m11740h() {
        C2538c.m12677c("AppUpdateInteractor", "isWifiConnected");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.m2632b().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public boolean m11741i() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.m2632b().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public String m11726a(String str) {
        String str2 = "";
        if (BaseApplication.m2632b() != null) {
            return C1071a.m4507a(BaseApplication.m2632b()).m4508a(str);
        }
        return str2;
    }

    public void m11734b(Context context) {
        m11723a(context, 3);
    }

    public void m11728a(Context context, Boolean bool) {
        if (bool.booleanValue()) {
            m11723a(context, 1);
        }
    }

    private void m11723a(Context context, int i) {
        C1971j a = C1971j.m10236a(BaseApplication.m2632b());
        a.m10254b("device", "device_app_update", new C2280b(this, a, i, context));
    }

    public void m11742j() {
        C2538c.m12677c("AppUpdateInteractor", "enter deleteMessage");
        C1971j a = C1971j.m10236a(BaseApplication.m2632b());
        a.m10254b("device", "device_app_update", new C2282d(this, a, new C2422e(BaseApplication.m2632b())));
    }

    public void m11729a(Context context, String str, int i, String str2, Boolean bool) {
        C2538c.m12677c("AppUpdateInteractor", "showAppAutoCheckDialog version:" + str);
        C2538c.m12677c("AppUpdateInteractor", "showAppAutoCheckDialog size:" + i);
        C2538c.m12677c("AppUpdateInteractor", "showAppAutoCheckDialog changeLog:" + str2);
        C2538c.m12677c("AppUpdateInteractor", "showAppAutoCheckDialog isForced:" + bool);
        Intent intent = new Intent();
        intent.putExtra("name", str);
        intent.putExtra(UploadFile.SIZE_LABEL, i);
        intent.putExtra(WBConstants.ACTION_LOG_TYPE_MESSAGE, str2);
        intent.putExtra("isForced", bool);
        intent.setFlags(536870912);
        intent.setClass(context, AppUpdateDialogActivity.class);
        context.startActivity(intent);
    }

    private boolean m11725l() {
        if (C0975b.HEALTH == BaseApplication.m2633c()) {
            C2538c.m12677c("AppUpdateInteractor", "包名为com.huawei.health");
            return false;
        }
        C2538c.m12677c("AppUpdateInteractor", "包名为com.huawei.bone");
        return true;
    }

    public void m11730a(Boolean bool) {
        if (BaseApplication.m2632b() != null) {
            C1071a.m4507a(BaseApplication.m2632b()).m4512a(Boolean.valueOf(true), bool);
        }
    }

    public void m11731a(boolean z) {
        this.f8277e = z;
    }

    public boolean m11743k() {
        return this.f8277e;
    }
}
